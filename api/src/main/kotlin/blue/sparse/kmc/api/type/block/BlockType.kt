package blue.sparse.kmc.api.type.block

import blue.sparse.kmc.api.data.Property
import blue.sparse.kmc.api.type.Type
import blue.sparse.kmc.api.type.Variation
import blue.sparse.kmc.api.type.item.ItemType
import blue.sparse.kmc.api.type.variations.NoItemVariation
import blue.sparse.kmc.api.util.Identifier

interface BlockType<V : Variation> : Type<V> {
	override val properties: Property.Set
		get() = defaultProperties

	abstract class Abstract<V : Variation>(override val identifier: Identifier) : BlockType<V> {
		constructor(id: String) : this(Identifier.fromString(id))
	}

	abstract class AbstractSimple(override val identifier: Identifier) : ItemType<NoItemVariation> {
		constructor(id: String) : this(Identifier.fromString(id))
	}

	companion object {

		val defaultProperties: Property.Set
			get() = Property.Set()

	}
}
