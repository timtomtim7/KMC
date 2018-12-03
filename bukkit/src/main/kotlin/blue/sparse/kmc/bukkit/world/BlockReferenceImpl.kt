package blue.sparse.kmc.bukkit.world

import blue.sparse.kmc.api.type.block.Block
import blue.sparse.kmc.api.util.BlockPosition
import blue.sparse.kmc.api.world.BlockReference
import blue.sparse.kmc.bukkit.version.VersionSupport

data class BlockReferenceImpl(val world: WorldImpl, override val position: BlockPosition) : BlockReference {

	val handle = world.world.getBlockAt(position.x, position.y, position.z)

	override val access = world.blocks

	override var block: Block<*, *>
		get() = VersionSupport.materialConverter.getBlock(handle)
		set(value) {
			VersionSupport.materialConverter.setBlock(handle, value)
		}

}