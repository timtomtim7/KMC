package blue.sparse.kmc.api.plugin

import java.io.File
import java.util.logging.Logger

/**
 * Represents a KMC plugin
 */
abstract class Plugin {

	/**
	 * The name of this KMC plugin
	 */
	val name: String
		get() = javaClass.simpleName.removeSuffix("Plugin")

	/**
	 * The logger for this KMC plugin.
	 * This should be used for any logging.
	 */
	val logger: Logger by lazy { Logger.getLogger(name) }

	lateinit var directory: File
		private set

	/**
	 * Called when this plugin is enabled
	 */
	open fun onEnable() {}

	/**
	 * Called when this plugin is disabled
	 */
	open fun onDisable() {}

	internal fun init(info: PluginInitializationInfo) {

	}
}