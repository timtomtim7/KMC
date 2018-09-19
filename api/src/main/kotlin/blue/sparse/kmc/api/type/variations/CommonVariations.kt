package blue.sparse.kmc.api.type.variations

abstract class DyeVariation: ItemVariation, BlockVariation {
	object White: DyeVariation()
	object Orange: DyeVariation()
	object Magenta: DyeVariation()
	object LightBlue: DyeVariation()
	object Yellow: DyeVariation()
	object Lime: DyeVariation()
	object Pink: DyeVariation()
	object Gray: DyeVariation()
	object LightGray: DyeVariation()
	object Cyan: DyeVariation()
	object Purple: DyeVariation()
	object Blue: DyeVariation()
	object Brown: DyeVariation()
	object Green: DyeVariation()
	object Red: DyeVariation()
	object Black: DyeVariation()

	override fun toString(): String {
		return "DyeVariation.${javaClass.simpleName}"
	}
}