package blue.sparse.kmc.api.type

import blue.sparse.kmc.api.data.Property
import blue.sparse.kmc.api.util.Identifier

interface Type<V : Variation> {
	val identifier: Identifier

	val properties: Property.Set
}
