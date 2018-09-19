package blue.sparse.kmc.api.util

data class Time(val amount: Int, val unit: TimeUnit) {
	enum class TimeUnit {
		TICK,
		MILLISECOND,
		SECOND,
		MINUTE,
		HOUR
	}
}

val Int.ticks get() = Time(this, Time.TimeUnit.TICK)
val Int.milliseconds get() = Time(this, Time.TimeUnit.MILLISECOND)
val Int.seconds get() = Time(this, Time.TimeUnit.SECOND)
val Int.minutes get() = Time(this, Time.TimeUnit.MINUTE)
val Int.hours get() = Time(this, Time.TimeUnit.HOUR)