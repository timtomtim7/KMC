package blue.sparse.kmc.api.plugin

import java.io.File
import java.net.URLClassLoader
import java.util.jar.JarFile
import kotlin.reflect.full.isSubclassOf

/**
 * Responsible for loading the classes of a KMC plugin.
 *
 * One instance of this class will be created per plugin.
 */
class PluginClassLoader internal constructor(
		parent: ClassLoader,
		val pluginFile: File
) : URLClassLoader(arrayOf(pluginFile.toURI().toURL()), parent) {

	val plugin: Plugin

	init {
		var instance: Plugin? = null

		val classNames = getClassNames(pluginFile)
				.filter { '$' !in it && it.endsWith("Plugin") }

		for (className in classNames) {
			val clazz = findClass(className).kotlin

			if (!clazz.isSubclassOf(Plugin::class))
				continue

			instance = clazz.objectInstance as Plugin?
			if (instance != null)
				break
		}

		if (instance == null)
			throw IllegalStateException("Plugin did not contain main class")

		instance.init(PluginInitializationInfo(pluginFile, pluginFile.parentFile, "Unknown"))
		plugin = instance
	}

	private companion object {
		fun getClassNames(file: File): List<String> {
			val names = JarFile(file).use { jar: JarFile ->
				jar.entries().asSequence()
						.filter { !it.isDirectory }
						.map { it.name }
						.toList().asSequence()
			}

			return names
					.filter { it.endsWith(".class") }
					.map { it.removeSuffix(".class").replace('/', '.') }
					.toList()
		}
	}

}
