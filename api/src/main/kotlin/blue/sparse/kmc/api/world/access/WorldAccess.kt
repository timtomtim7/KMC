package blue.sparse.kmc.api.world.access

import blue.sparse.kmc.api.world.World
import java.util.UUID

interface WorldAccess: Access, Set<World> {
	operator fun get(name: String): World?
	operator fun get(id: UUID): World?

//	fun create()
}