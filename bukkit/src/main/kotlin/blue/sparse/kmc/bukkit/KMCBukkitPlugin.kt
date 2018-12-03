package blue.sparse.kmc.bukkit

import blue.sparse.kmc.api.KMC
import blue.sparse.kmc.api.type.item.Item
import blue.sparse.kmc.api.type.item.ItemStack
import blue.sparse.kmc.api.type.item.Items
import blue.sparse.kmc.api.type.variations.ArmorVariation
import blue.sparse.kmc.bukkit.scheduler.SchedulerImpl
import blue.sparse.kmc.bukkit.version.NMSVersion
import blue.sparse.kmc.bukkit.version.VersionSupport
import blue.sparse.kmc.bukkit.world.WorldAccessImpl
import org.bukkit.plugin.java.JavaPlugin

class KMCBukkitPlugin : JavaPlugin() {

	override fun onEnable() {
		logger.info("KMC Bukkit Initialized for ${NMSVersion.current}")
		KMC.initialize(dataFolder.parentFile, SchedulerImpl, WorldAccessImpl())

		val stack = Item(Items.Helmet, ArmorVariation.Diamond).stack()
		versionSupport.materialConverter.toBukkitStack(stack)
	}

	override fun onDisable() {
		KMC.shutdown()
	}

	companion object {
		var versionSupport = Class.forName(
				"blue.sparse.kmc.bukkit.version.versions.${NMSVersion.current}.VersionSupportImpl"
		).newInstance() as VersionSupport
	}

}