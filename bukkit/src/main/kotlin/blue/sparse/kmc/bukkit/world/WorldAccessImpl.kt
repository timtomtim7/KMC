package blue.sparse.kmc.bukkit.world

import blue.sparse.kmc.api.world.World as KMCWorld
import blue.sparse.kmc.api.world.access.WorldAccess
import org.bukkit.Bukkit
import org.bukkit.World as BukkitWorld
import java.util.*

class WorldAccessImpl: WorldAccess {
	val bukkitWorlds get() = Bukkit.getWorlds()

	override val size: Int
		get() = bukkitWorlds.size

	override fun get(name: String): KMCWorld? {
		return WorldImpl(Bukkit.getWorld(name) ?: return null)
	}

	override fun get(id: UUID): KMCWorld? {
		return WorldImpl(Bukkit.getWorld(id) ?: return null)
	}

	override fun contains(element: KMCWorld): Boolean {
		return get(element.id) != null
	}

	override fun containsAll(elements: Collection<KMCWorld>): Boolean {
		return elements.all(::contains)
	}

	override fun isEmpty(): Boolean {
		return false
	}

	override fun iterator(): Iterator<KMCWorld> {
		return bukkitWorlds.asSequence().map(::WorldImpl).iterator()
	}

}