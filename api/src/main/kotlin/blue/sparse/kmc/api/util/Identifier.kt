package blue.sparse.kmc.api.util

import java.lang.IllegalArgumentException

data class Identifier(val namespace: String, val key: String) {

	constructor(key: String): this("minecraft", key)

	init {
		if(namespace.any { !it.isLetterOrDigit() && it != '_'})
			throw IllegalArgumentException("Namespace contains illegal characters")
		if(key.any { !it.isLetterOrDigit() && it != '_'})
			throw IllegalArgumentException("Key contains illegal characters")
	}

	companion object {
		fun fromString(string: String): Identifier {
			if(':' in string) {
				val split = string.split(':')
				return Identifier(split[0], split[1])
			}

			return Identifier(string)
		}
	}

}