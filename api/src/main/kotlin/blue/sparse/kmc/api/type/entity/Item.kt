package blue.sparse.kmc.api.type.entity

import blue.sparse.kmc.api.data.Property
import blue.sparse.kmc.api.type.block.Block
import blue.sparse.kmc.api.type.block.BlockType
import blue.sparse.kmc.api.type.item.Item
import blue.sparse.kmc.api.type.item.ItemType
import blue.sparse.kmc.api.type.variations.*

class Entity<T : EntityType<V>, V : EntityVariation>(var type: T, var variation: V) {

	val properties = Property.Map(type.properties)

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is Item<*, *>) return false

		if (type != other.type) return false
		if (variation != other.variation) return false
		if (properties != other.properties) return false

		return true
	}

	override fun hashCode(): Int {
		var result = type.hashCode()
		result = 31 * result + variation.hashCode()
		result = 31 * result + properties.hashCode()
		return result
	}

	companion object {
		operator fun <T : EntityType<NoEntityVariation>> invoke(type: T): Entity<T, NoEntityVariation> {
			return Entity(type, NoEntityVariation)
		}

		inline operator fun <T : EntityType<NoEntityVariation>> invoke(
				type: T,
				body: Entity<T, NoEntityVariation>.() -> Unit
		): Entity<T, NoEntityVariation> {
			return Entity(type, NoEntityVariation).apply(body)
		}

		inline operator fun <T : EntityType<V>, V: EntityVariation> invoke(
				type: T,
				variation: V,
				body: Entity<T, V>.() -> Unit
		): Entity<T, V> {
			return Entity(type, variation).apply(body)
		}
	}

}
