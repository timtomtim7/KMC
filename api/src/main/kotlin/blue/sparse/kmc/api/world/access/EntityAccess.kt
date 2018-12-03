package blue.sparse.kmc.api.world.access

import blue.sparse.kmc.api.type.entity.Entity
import blue.sparse.kmc.api.world.EntityReference
import blue.sparse.math.vector.floats.Vector3f

interface EntityAccess : Access, MutableSet<EntityReference> {
	fun add(entity: Entity<*, *>, position: Vector3f): EntityReference
}