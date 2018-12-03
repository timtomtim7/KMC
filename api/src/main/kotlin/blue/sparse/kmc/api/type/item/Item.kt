package blue.sparse.kmc.api.type.item

import blue.sparse.kmc.api.data.Property
import blue.sparse.kmc.api.type.block.Block
import blue.sparse.kmc.api.type.block.BlockType
import blue.sparse.kmc.api.type.variations.*

data class Item<T : ItemType<V>, V : ItemVariation>(var type: T, var variation: V) {

	val properties = Property.Map(type.properties)

	val display: ItemDisplay
		inline get() = ItemDisplay(this)

	fun stack(amount: Int = 1): ItemStack {
		return ItemStack(this, amount)
	}

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
		operator fun <T : ItemType<NoItemVariation>> invoke(type: T): Item<T, NoItemVariation> {
			return Item(type, NoItemVariation)
		}

		inline operator fun <T : ItemType<NoItemVariation>> invoke(
				type: T,
				body: Item<T, NoItemVariation>.() -> Unit
		): Item<T, NoItemVariation> {
			return Item(type, NoItemVariation).apply(body)
		}

		inline operator fun <T : ItemType<V>, V: ItemVariation> invoke(
				type: T,
				variation: V,
				body: Item<T, V>.() -> Unit
		): Item<T, V> {
			return Item(type, variation).apply(body)
		}
	}

}
