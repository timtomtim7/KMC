package blue.sparse.kmc.api.type.block

import blue.sparse.kmc.api.data.Property
import blue.sparse.kmc.api.type.item.Item
import blue.sparse.kmc.api.type.variations.*

class Block<T : BlockType<V>, V : BlockVariation>(var type: T, var variety: V) {

	val properties = Property.Map(type.properties)

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is Item<*, *>) return false

		if (type != other.type) return false
		if (variety != other.variation) return false
		if (properties != other.properties) return false

		return true
	}

	override fun hashCode(): Int {
		var result = type.hashCode()
		result = 31 * result + variety.hashCode()
		result = 31 * result + properties.hashCode()
		return result
	}

	companion object {
		operator fun <T : BlockType<NoBlockVariation>> invoke(type: T): Block<T, NoBlockVariation> {
			return Block(type, NoBlockVariation)
		}
	}

}
