package blue.sparse.kmc.api.util

inline class BlockPosition(private val positionID: Long) {

	val x: Int
		get() = positionID.shr(38).toInt()

	val y: Int
		get() = positionID.shr(26).and(0xFFF).toInt()

	val z: Int
		get() = positionID.shl(38).shr(38).toInt()

	operator fun plus(other: BlockPosition) = BlockPosition(x + other.x, y + other.y, z + other.z)
	operator fun minus(other: BlockPosition) = BlockPosition(x + other.x, y + other.y, z + other.z)
	operator fun times(other: BlockPosition) = BlockPosition(x + other.x, y + other.y, z + other.z)
	operator fun div(other: BlockPosition) = BlockPosition(x + other.x, y + other.y, z + other.z)
	operator fun rem(other: BlockPosition)   = BlockPosition(x + other.x, y + other.y, z + other.z)

	override fun toString() =  "BlockPosition(x=$x, y=$y, z=$z)"

	companion object {

		operator fun invoke(x: Int, y: Int, z: Int): BlockPosition {
			return BlockPosition(toLong(x, y, z))
		}

		private fun toLong(x: Int, y: Int, z: Int): Long {
			return toLong(x.toLong(), y.toLong(), z.toLong())
		}

		private fun toLong(x: Long, y: Long, z: Long): Long {
			return x.and(0x3FFFFFF).shl(38)
					.or(y.and(0xFFF).shl(26))
					.or(z.and(0x3FFFFFF))

		}

	}

}
