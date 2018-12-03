package blue.sparse.kmc.api.world

import blue.sparse.kmc.api.type.block.Block
import blue.sparse.kmc.api.util.BlockPosition
import blue.sparse.kmc.api.world.access.BlockAccess

interface BlockReference {
	val access: BlockAccess
	val position: BlockPosition

	var block: Block<*, *>
}