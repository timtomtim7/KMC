package blue.sparse.kmc.bukkit.version.versions.v1_13_R2

import blue.sparse.kmc.bukkit.version.MaterialConverter
import blue.sparse.kmc.bukkit.version.VersionSupport

class VersionSupportImpl: VersionSupport {
	override val materialConverter = MaterialConverterImpl()
}