package blue.sparse.kmc.api.util

interface Registry<K, V> {
	operator fun get(key: K): V {
		return optional(key) ?: throw IllegalArgumentException("No value in registry associated with the provided key.")
	}

	fun optional(key: K): V?

	interface ManualKey<K, V>: Registry<K, V> {
		fun register(key: K, value: V)
	}

	interface AutoKey<K, V>: Registry<K, V> {
		fun register(value: V)
	}
}