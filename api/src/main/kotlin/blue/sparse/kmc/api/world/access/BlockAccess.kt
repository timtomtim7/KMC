package blue.sparse.kmc.api.world.access

import blue.sparse.kmc.api.util.BlockPosition
import blue.sparse.kmc.api.world.BlockReference

interface BlockAccess: Access {
	operator fun get(x: Int, y: Int, z: Int): BlockReference

	operator fun get(position: BlockPosition): BlockReference
}