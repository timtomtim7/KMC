package blue.sparse.kmc.bukkit

import blue.sparse.kmc.api.type.item.Item as KMCItem
import blue.sparse.kmc.api.type.item.ItemStack as KMCItemStack
import org.bukkit.inventory.ItemStack as BukkitItemStack

interface ItemConverter {

	fun convert(item: KMCItem<*, *>): BukkitItemStack

	fun convert(stack: KMCItemStack): BukkitItemStack {
		val result = convert(stack.item)
		result.amount = stack.amount
		return result
	}

}