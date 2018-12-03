package blue.sparse.kmc.bukkit.world

import blue.sparse.kmc.api.type.entity.Entity
import blue.sparse.kmc.api.util.BlockPosition
import blue.sparse.kmc.api.world.*
import blue.sparse.kmc.api.world.access.BlockAccess
import blue.sparse.kmc.api.world.access.EntityAccess
import blue.sparse.kmc.bukkit.util.BukkitWorld
import blue.sparse.kmc.bukkit.util.KMCWorld
import blue.sparse.math.vector.floats.Vector3f
import java.util.*

data class WorldImpl(val world: BukkitWorld): KMCWorld {
	override val name: String
		get() = world.name

	override val id: UUID
		get() = world.uid

	override val entities: EntityAccess = object : EntityAccess, AbstractMutableSet<EntityReference>() {
		override fun add(entity: Entity<*, *>, position: Vector3f): EntityReference {
			TODO("not implemented")
		}

		override fun add(element: EntityReference): Boolean {
			TODO("not implemented")
		}

		override fun iterator(): MutableIterator<EntityReference> {
			TODO("not implemented")
		}

		override val size: Int
			get() = world.entities.size

	}

	override val blocks: BlockAccess = object: BlockAccess {
		override fun get(x: Int, y: Int, z: Int): BlockReference {
			return BlockReferenceImpl(this@WorldImpl, BlockPosition(x, y, z))
		}

		override fun get(position: BlockPosition): BlockReference {
			return BlockReferenceImpl(this@WorldImpl, position)
		}
	}


}