package blue.sparse.kmc.api

import blue.sparse.kmc.api.event.EventManager
import blue.sparse.kmc.api.plugin.PluginLoader
import blue.sparse.kmc.api.scheduler.SchedulerAPI
import blue.sparse.kmc.api.world.access.WorldAccess
import java.io.File
import java.util.logging.Logger

/**
 * This class represents the core of KMC.
 * Currently only used for initialization, plugins probably won't be touching this.
 */
object KMC {

	/**
	 * All KMC plugins in this folder will be automatically loaded when KMC is initialized.
	 */
	lateinit var pluginsFolder: File
		private set

	val logger = Logger.getLogger("KMC")

	/**
	 * Primary `EventManager` for KMC
	 */
	val events = EventManager()

	internal lateinit var scheduler: SchedulerAPI

	lateinit var worlds: WorldAccess
		private set

	// players
	// worlds
	//

	/**
	 * Initialize KMC
	 *
	 * **Can only be called once**
	 */
	fun initialize(
			pluginsFolder: File,
			scheduler: SchedulerAPI,
			worlds: WorldAccess
	) {
		if (this::pluginsFolder.isInitialized)
			throw IllegalStateException("Already initialized KMC.")

		this.scheduler = scheduler
		this.pluginsFolder = pluginsFolder
		this.worlds = worlds
		logger.info("KMC initialized!")
		PluginLoader.loadPlugins()
	}

	fun shutdown() {
		logger.info("KMC shutting down...")
		PluginLoader.disablePlugins()
	}
}