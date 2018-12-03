package blue.sparse.kmc.api.plugin

import blue.sparse.kmc.api.data.Persistent
import blue.sparse.kmc.api.type.entity.Entities
import blue.sparse.kmc.api.type.entity.Entity
import java.io.File
import java.net.URLClassLoader
import java.util.jar.JarFile
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.jvm.internal.components.ReflectKotlinClass
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader

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

	private val persistentClasses = HashSet<Class<*>>()
	private val persistentChecked = HashSet<String>()

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

	override fun findClass(name: String): Class<*> {
		val clazz = super.findClass(name)!!
		if(clazz.isSynthetic)
			return clazz

		if(name in persistentChecked)
			return clazz

		val kind = ReflectKotlinClass.create(clazz)?.classHeader?.kind
		if(kind != KotlinClassHeader.Kind.UNKNOWN && kind != KotlinClassHeader.Kind.CLASS && kind != null)
			return clazz

		println("Scanning \"$name\"")
		persistentChecked.add(name)
		try {
			val kotlin = clazz.kotlin
			if (Persistent.loadFor(kotlin)) {
				println("Found class with persistent")
				persistentClasses.add(clazz)
			}
		}catch(t: Throwable) {
			t.printStackTrace()
		}

		return clazz
	}

	fun onDisable() {
		persistentClasses.forEach {
			Persistent.saveFor(it.kotlin)
		}
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
