package blue.sparse.kmc.api.data

import blue.sparse.kmc.api.plugin.Plugin
import blue.sparse.kmc.api.plugin.PluginClassLoader
import blue.sparse.kmc.api.type.entity.Entities
import blue.sparse.kmc.api.type.entity.Entity
import blue.sparse.kmc.api.type.item.Item
import blue.sparse.kmc.api.type.item.Items
import blue.sparse.kmc.api.type.variations.ArmorVariation
import sun.security.provider.MD5
import java.io.File
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.jvmName

@Target(AnnotationTarget.FIELD)
annotation class Persistent {
	companion object {
		fun getFields(clazz: KClass<*>): List<KProperty1<out Any, Any?>>? {
			if(clazz.objectInstance == null)
				return null

			return clazz.memberProperties
					.filter { it.javaField?.isAnnotationPresent(Persistent::class.java) == true}
		}

		fun saveFor(clazz: KClass<*>) {
			val persistentFields = getFields(clazz) ?: return

			val data = persistentFields.associate {
				val field = it.javaField!!
				field.isAccessible = true
				it.name to field[clazz]
			}

			val name = Base64.getEncoder().encodeToString(clazz.jvmName.toByteArray())
			val file = File("persistent/$name.bin")
			file.parentFile.mkdirs()
			val obj = ObjectOutputStream(file.outputStream())
			obj.writeObject(data)
			obj.close()
		}

		@Suppress("UNCHECKED_CAST")
		fun loadFor(clazz: KClass<*>): Boolean {
			val persistentFields = getFields(clazz) ?: return false
			val name = Base64.getEncoder().encodeToString(clazz.jvmName.toByteArray())
			val file = File("persistent/$name.bin")
			if(file.exists()) {
				println("File exists")
				try {
					val obj = ObjectInputStream(file.inputStream())
					val data = obj.readObject() as? Map<String, Any?> ?: return true
					println(data)

					for (property in persistentFields) {
						val field = property.javaField!!
						val value = data[property.name] ?: continue
//						if(!field.type.isAssignableFrom(value.javaClass))
//							continue

						field.isAccessible = true
						field.set(clazz.objectInstance!!, value)
						println("Field set")
					}

					obj.close()
				} catch(t: Throwable) {
					t.printStackTrace()
				}
			}

//			println("Load persistent for \"${clazz.jvmName}\" ${persistentFields.map { it.name }}")

			return true
		}
	}
}