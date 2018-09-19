package blue.sparse.kmc.api.plugin

import java.io.File

data class PluginInitializationInfo(
		val pluginFile: File,
		val directory: File,
		val version: String
)