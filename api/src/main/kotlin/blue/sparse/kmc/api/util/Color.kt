package blue.sparse.kmc.api.util

import kotlin.math.abs

inline class Color(val rgb: Int) {

	val r: Int
		get() = (rgb shr 16) and 0xFF

	val g: Int
		get() = (rgb shr 8) and 0xFF

	val b: Int
		get() = rgb and 0xFF

	constructor(r: Int, g: Int, b: Int): this(
			((r and 0xFF) shl 16) or ((g and 0xFF) shl 8) or b
	)

	fun red(red: Int): Color {
		return Color((rgb and 0x00FFFF) or (red shl 16))
	}

	fun green(green: Int): Color {
		return Color((rgb and 0x00FFFF) or (green shl 16))
	}

	fun blue(blue: Int): Color {
		return Color((rgb and 0x00FFFF) or (blue shl 16))
	}

	fun difference(other: Color): Int {
		return abs(r - other.r) + abs(g - other.g) + abs(b - other.b)
	}

	companion object {
		val black = Color(0x000000)
		val green = Color(0x00AA00)
		val blue = Color(0x0000AA)
		val aqua = Color(0x00AAAA)
		val red = Color(0xAA0000)
		val purple = Color(0xAA00AA)
		val orange = Color(0xFFAA00)
		val gray = Color(0xAAAAAA)
		val darkGray = Color(0x555555)
		val lightBlue = Color(0x5555FF)
		val lime = Color(0x55FF55)
		val cyan = Color(0x55FFFF)
		val lightRed = Color(0xFF5555)
		val pink = Color(0xFF55FF)
		val yellow = Color(0xFFFF55)
		val white = Color(0xFFFFFF)
	}

}