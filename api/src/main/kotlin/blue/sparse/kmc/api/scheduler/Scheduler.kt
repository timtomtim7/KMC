package blue.sparse.kmc.api.scheduler

import blue.sparse.kmc.api.KMC
import blue.sparse.kmc.api.util.Time

object Scheduler : SchedulerImpl by KMC.scheduler

typealias Task = () -> Unit

@Suppress("unused")
interface SchedulerImpl {
	val expectedTickRate: Double
	val currentTickRate: Double

	/**
	 * Executes the [task] after the the specified time.
	 *
	 * The specified time may not be matched exactly, depending on the server's current tick rate.
	 */
	fun delayed(delay: Time, task: Task)

	/**
	 * Executes the [task] the very next server tick.
	 */
	fun nextTick(task: Task)

	/**
	 * Repeatedly executes [task] every server tick.
	 */
	fun repeatTick(task: Task)

	/**
	 * Repeatedly executes [task] every server tick until the specified time ([until]) has passed.
	 */
	fun repeatTickUntil(until: Time, task: Task)

	/**
	 * Repeatedly executes [task] every [interval]
	 */
	fun repeat(interval: Time, task: Task)

	/**
	 * Repeatedly executes [task] every [interval] until the specified time ([until]) has passed.
	 */
	fun repeatUntil(interval: Time, until: Time, task: Task)
}
