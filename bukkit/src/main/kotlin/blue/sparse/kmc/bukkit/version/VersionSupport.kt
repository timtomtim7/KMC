package blue.sparse.kmc.bukkit.version

import blue.sparse.kmc.bukkit.KMCBukkitPlugin

interface VersionSupport {

	val materialConverter: MaterialConverter

	companion object: VersionSupport by KMCBukkitPlugin.versionSupport//TODO: Double check that this works
}