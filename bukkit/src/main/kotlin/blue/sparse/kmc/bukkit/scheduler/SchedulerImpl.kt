package blue.sparse.kmc.bukkit.scheduler

import blue.sparse.kmc.api.scheduler.SchedulerAPI
import blue.sparse.kmc.api.scheduler.Task
import blue.sparse.kmc.api.util.Time

object SchedulerImpl : SchedulerAPI {
	override val expectedTickRate: Double
		get() = TODO("not implemented")
	override val currentTickRate: Double
		get() = TODO("not implemented")

	override fun delayed(delay: Time, task: Task) = TODO("not implemented")
	override fun nextTick(task: Task) = TODO("not implemented")
	override fun repeatTick(task: Task) = TODO("not implemented")
	override fun repeatTickUntil(until: Time, task: Task) = TODO("not implemented")
	override fun repeat(interval: Time, task: Task) = TODO("not implemented")
	override fun repeatUntil(interval: Time, until: Time, task: Task) = TODO("not implemented")
}