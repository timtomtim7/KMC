package blue.sparse.kmc.bukkit.version.versions.v1_13_R2

import blue.sparse.kmc.api.type.block.Block
import blue.sparse.kmc.bukkit.util.BukkitBlock
import blue.sparse.kmc.bukkit.util.BukkitItemStack
import blue.sparse.kmc.bukkit.util.KMCItemStack
import blue.sparse.kmc.bukkit.version.MaterialConverter
import net.minecraft.server.v1_13_R2.IRegistry
import net.minecraft.server.v1_13_R2.MinecraftKey
import org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack
import net.minecraft.server.v1_13_R2.Items as NMSItems
import org.bukkit.Material as BukkitMaterial

class MaterialConverterImpl : MaterialConverter {

	override fun toBukkitStack(itemStack: KMCItemStack): BukkitItemStack {
		val vanillaID = itemStack.item.type.identifier

		val item = IRegistry.ITEM.get(MinecraftKey(vanillaID.namespace, vanillaID.key)) ?: NMSItems.BRICK //TODO
		val bukkit = CraftItemStack.asNewCraftStack(item)

		println("$itemStack converted to ${bukkit.type}")

		return bukkit
	}

	override fun toKMCStack(itemStack: BukkitItemStack): KMCItemStack {
		TODO("not implemented")
	}

	override fun setBlock(target: BukkitBlock, value: Block<*, *>) {
		TODO("not implemented")
	}

	override fun getBlock(target: BukkitBlock): Block<*, *> {
		TODO("not implemented")
	}

}