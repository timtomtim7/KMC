package blue.sparse.kmc.api.type.item

import blue.sparse.kmc.api.data.Property
import blue.sparse.kmc.api.type.Type
import blue.sparse.kmc.api.type.Variation
import blue.sparse.kmc.api.type.variations.ItemVariation
import blue.sparse.kmc.api.type.variations.NoItemVariation
import blue.sparse.kmc.api.util.Identifier
import kotlin.String

interface ItemType<V: ItemVariation>: Type<V> {
	override val properties: Property.Set
		get() = defaultProperties

	abstract class Abstract<V: ItemVariation>(override val identifier: Identifier): ItemType<V> {
		constructor(id: String): this(Identifier.fromString(id))
	}

	abstract class AbstractSimple(override val identifier: Identifier): ItemType<NoItemVariation> {
		constructor(id: String): this(Identifier.fromString(id))
	}

	companion object {

		val defaultProperties: Property.Set get() {
			val result = Property.Set()

			result.add(ItemProperties.DisplayName)
			result.add(ItemProperties.DisplayLore)

			return result
		}

	}
}
