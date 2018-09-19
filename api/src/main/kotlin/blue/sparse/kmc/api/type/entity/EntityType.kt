package blue.sparse.kmc.api.type.entity

import blue.sparse.kmc.api.data.Property
import blue.sparse.kmc.api.type.Type
import blue.sparse.kmc.api.type.Variation
import blue.sparse.kmc.api.type.variations.*
import blue.sparse.kmc.api.util.Identifier
import kotlin.String

interface EntityType<V: EntityVariation>: Type<V> {
	override val properties: Property.Set
		get() = defaultProperties

	abstract class Abstract<V: EntityVariation>(override val identifier: Identifier): EntityType<V> {
		constructor(id: String): this(Identifier.fromString(id))
	}

	abstract class AbstractSimple(override val identifier: Identifier): EntityType<NoEntityVariation> {
		constructor(id: String): this(Identifier.fromString(id))
	}

	companion object {

		val defaultProperties: Property.Set get() {
			return Property.Set()
		}

	}
}
