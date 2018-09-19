package blue.sparse.kmc.api.world

import blue.sparse.kmc.api.type.entity.Entity

interface EntityReference {
	val entity: Entity<*, *>
}