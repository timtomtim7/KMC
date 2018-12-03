package blue.sparse.kmc.api.world

import blue.sparse.kmc.api.world.access.BlockAccess
import blue.sparse.kmc.api.world.access.EntityAccess
import java.util.UUID

interface World {
	val name: String
	val id: UUID

	val entities: EntityAccess
	val blocks: BlockAccess

	companion object {
//		operator fun invoke(): World {
//			TODO("")
//		}
	}
}