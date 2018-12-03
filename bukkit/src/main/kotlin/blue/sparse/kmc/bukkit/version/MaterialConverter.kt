package blue.sparse.kmc.bukkit.version

import blue.sparse.kmc.api.type.block.Block
import blue.sparse.kmc.api.type.item.Item
import blue.sparse.kmc.bukkit.util.*
import org.bukkit.Material

interface MaterialConverter {

//	fun toKMCItem(material: Material): Item<*, *>
//	fun toKMCBlock(material: Material): Block<*, *>

	fun toBukkitStack(itemStack: KMCItemStack): BukkitItemStack
	fun toKMCStack(itemStack: BukkitItemStack): KMCItemStack

	fun setBlock(target: BukkitBlock, value: Block<*, *>)
	fun getBlock(target: BukkitBlock): Block<*, *>
}
