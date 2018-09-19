package blue.sparse.kmc.api.event

interface Cancellable {
	var cancelled: Boolean

	fun cancel() {
		cancelled = true
	}

	fun uncancel() {
		cancelled = false
	}
}