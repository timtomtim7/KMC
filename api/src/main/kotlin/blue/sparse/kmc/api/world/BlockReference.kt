package blue.sparse.kmc.api.world

import blue.sparse.kmc.api.type.block.Block
import blue.sparse.kmc.api.util.BlockPosition

interface BlockReference {
	val access: BlockAccess
	val position: BlockPosition

	var block: Block<*, *>
}