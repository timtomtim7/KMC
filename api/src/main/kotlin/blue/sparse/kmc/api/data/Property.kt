package blue.sparse.kmc.api.data

import blue.sparse.kmc.api.KMC
import blue.sparse.kmc.api.type.item.ItemDisplay
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.full.isSubclassOf

data class Property<T: Any>(
		val clazz: KClass<T>,
		val key: Key<T>,
		val defaultValue: () -> T?
) {

	inner class Value(var value: T? = defaultValue()) {
		val property = this@Property

		override fun equals(other: Any?): Boolean {
			if (this === other) return true
			if (other !is Property<*>.Value) return false

			if (value != other.value) return false
			if (property != other.property) return false

			return true
		}

		override fun hashCode(): Int {
			var result = value?.hashCode() ?: 0
			result = 31 * result + property.hashCode()
			return result
		}
	}

	interface Key<V: Any>

	class Set: AbstractMutableSet<Property<*>>() {
		private val backingSet = HashSet<Property<*>>()

		override fun add(element: Property<*>) =
				backingSet.add(element)

		override fun iterator() = backingSet.iterator()

		override val size: Int
			get() = backingSet.size

		inline fun <reified T: Any> add(key: Key<T>, noinline default: () -> T? = { null }) {
			add(Property(T::class, key, default))
		}

	}

	class Map(properties: Set? = null) {
		private val backingMap = HashMap<Key<*>, Property<*>.Value>()

		init {
			if(properties != null) {
				for (property in properties) {
					if(property.key in backingMap)
						throw IllegalStateException("Property map has duplicate keys")
					backingMap[property.key] = property.Value()
				}
			}
		}

		@Suppress("UNCHECKED_CAST")
		fun <T: Any> value(key: Key<T>, clazz: KClass<T>): Property<T>.Value? {
			val result = backingMap[key]
			if(result == null) {
				KMC.logger.warning("Attempt to access property that doesn't exist.")
				return null
			}

			if(!result.property.clazz.isSubclassOf(clazz)) {
				KMC.logger.warning("Attempt to access property with incorrect type.")
				return null
			}

			return result as Property<T>.Value
		}

		fun <T: Any> get(key: Key<T>, clazz: KClass<T>): T? {
			return value(key, clazz)?.value
		}

		@Suppress("UNCHECKED_CAST")
		fun <T: Any> set(key: Key<T>, value: T?, clazz: KClass<T>) {
			val result = backingMap[key]
			if(result == null) {
				KMC.logger.warning("Attempt to access property that doesn't exist.")
				return
			}

			if(!result.property.clazz.isSubclassOf(clazz)) {
				KMC.logger.warning("Attempt to access property with incorrect type.")
				return
			}

			val cast = result as Property<T>.Value
			cast.value = value
		}

		inline operator fun <reified T: Any> get(key: Key<T>) = get(key, T::class)
		inline operator fun <reified T: Any> set(key: Key<T>, value: T?) {
			set(key, value, T::class)
		}

		override fun equals(other: Any?): Boolean {
			if (this === other) return true
			if (other !is Map) return false

			if (backingMap != other.backingMap) return false

			return true
		}

		override fun hashCode(): Int {
			return backingMap.hashCode()
		}


//		inline fun <reified T: Any> delegate(key: Key<T>): Property<T>.Value.Delegate? {
//			return value(key, T::class)?.Delegate()
//		}
	}

}