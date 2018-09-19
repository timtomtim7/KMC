package blue.sparse.kmc.api.plugin

import blue.sparse.kmc.api.KMC
import java.io.File

/**
 * Responsible for managing and loading plugins.
 */
object PluginLoader {

	private val loadedPlugins = HashMap<File, Plugin>()

	/**
	 * All KMC plugins in this folder will be automatically loaded when KMC is initialized.
	 */
	val pluginsFolder: File
		get() = KMC.pluginsFolder

	/**
	 * Collection of all loaded plugins
	 */
	val plugins: Collection<Plugin>
		get() = loadedPlugins.values

	/**
	 * Loads all plugins in [pluginsFolder].
	 *
	 * Specifically, all files with the `kmc` extension will be loaded.
	 */
	fun loadPlugins() {
		pluginsFolder.listFiles()
				.filter { it.extension == "kmc" }
				.forEach { loadPlugin(it) }
	}

	/**
	 * Attempts to load [file] as a KMC plugin.
	 */
	fun loadPlugin(file: File): Plugin? {
		if(file.extension != "kmc")
			throw IllegalArgumentException("Invalid file extension for KMC plugin")

		val loaded = loadedPlugins[file]
		if(loaded != null)
			return loaded

		try {
			val classLoader = PluginClassLoader(javaClass.classLoader, file)
			val plugin = classLoader.plugin
			plugin.logger.info("Loading ${plugin.name}")

			plugin.onEnable() //TODO: Don't enable plugins immediately!

			loadedPlugins[file] = plugin

			LinkedHashSet<Int>().last()

			return plugin
		}catch (t: Throwable) {
			KMC.logger.warning("Failed to load plugin: ${file.name}")
			t.printStackTrace()
		}

		return null
	}

}