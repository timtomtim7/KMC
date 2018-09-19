package blue.sparse.kmc.api.event

abstract class EventReceiver<in E: Event>(
		val priority: Int
): Comparable<EventReceiver<*>> {
	abstract fun receiveEvent(event: E)

	override fun compareTo(other: EventReceiver<*>)
			= priority.compareTo(other.priority)
}