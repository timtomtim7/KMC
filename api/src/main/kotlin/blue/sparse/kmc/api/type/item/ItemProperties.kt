package blue.sparse.kmc.api.type.item

import blue.sparse.kmc.api.data.Property

object ItemProperties {

	object Durability: Property.Key<Int>
	object DisplayName: Property.Key<String>
	object DisplayLore: Property.Key<List<String>>

}