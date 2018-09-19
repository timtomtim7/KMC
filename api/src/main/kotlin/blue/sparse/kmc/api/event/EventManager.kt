package blue.sparse.kmc.api.event

import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.full.allSuperclasses
import kotlin.reflect.full.isSubclassOf
import java.util.ArrayList

class EventManager {

	private val eventClass = Event::class
	private val receiverInvoke = EventReceiver<*>::receiveEvent

	private val receivers = WeakHashMap<KClass<out Event>, MutableCollection<EventReceiver<*>>>()
	private val cachedHierarchies = HashMap<KClass<out Event>, List<KClass<*>>>()

	private fun createReceiverCollection(): MutableCollection<EventReceiver<*>> {
		return object : ArrayList<EventReceiver<*>>() {
			override fun add(element: EventReceiver<*>): Boolean {
				var index = Collections.binarySearch(this, element)
				if (index < 0) index = index.inv()
				super.add(index, element)
				return true
			}
		}
	}

	/**
	 * Register an event receiver for [event]
	 */
	fun <E : Event> receiver(event: KClass<E>, receiver: EventReceiver<E>) {
		receivers.getOrPut(event, this::createReceiverCollection).add(receiver)
	}

	/**
	 * Register an event receiver for event [E]
	 */
	inline fun <reified E : Event> receiver(priority: Int = 0, crossinline body: (E) -> Unit) {
		receiver(E::class, object : EventReceiver<E>(priority) {
			override fun receiveEvent(event: E) = body(event)
		})
	}

	private fun getHierarchyReceivers(event: KClass<out Event>): List<EventReceiver<*>> {
		val classes = cachedHierarchies.getOrPut(event) {
			val result: MutableList<KClass<*>> = mutableListOf(event)
			event.allSuperclasses.filterTo(result) {
				it.isSubclassOf(eventClass)
			}
			result
		}

		val result = ArrayList<EventReceiver<*>>()
		classes.flatMapTo(result) { receivers[it] ?: emptySet() }
		result.sort()

		return result
	}

	/**
	 * Call all event receivers for the specified event.
	 */
	operator fun invoke(event: Event) {
		getHierarchyReceivers(event::class).forEach { receiverInvoke.call(it, event) }
	}

}