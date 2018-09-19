package blue.sparse.kmc.api.world

import blue.sparse.kmc.api.type.entity.Entity
import blue.sparse.math.vector.floats.Vector3f

interface EntityAccess : MutableSet<EntityReference> {
	fun add(entity: Entity<*, *>, position: Vector3f): EntityReference
}