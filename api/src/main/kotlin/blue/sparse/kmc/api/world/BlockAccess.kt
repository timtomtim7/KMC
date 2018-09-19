package blue.sparse.kmc.api.world

import blue.sparse.kmc.api.util.BlockPosition

interface BlockAccess {
	operator fun get(x: Int, y: Int, z: Int): BlockReference

	operator fun get(position: BlockPosition): BlockReference
}