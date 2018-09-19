import blue.sparse.kmc.api.scheduler.Scheduler
import blue.sparse.kmc.api.type.item.Item
import blue.sparse.kmc.api.type.item.Items
import blue.sparse.kmc.api.type.variations.DyeVariation
import blue.sparse.kmc.api.util.seconds

fun main(args: Array<String>) {

	val item = Item(Items.Dye, DyeVariation.Blue)
	item.display.name = "Hi"
//	val stack = ItemStack(item, 1)
//	val color = stack.item.variation as? DyeVariation
//	println("This item is colored $color")

//	val world: World = KMC.worlds[0]
//	val wool = Block(Blocks.Wool, DyeVariation.Red)
//	world[0, 64, 0].block = wool

	Scheduler.delayed(5.seconds) {
		println("5 seconds later")
	}

	Scheduler.repeatUntil(interval = 1.seconds, until = 5.seconds) {
		println("Every second for 5 seconds")
	}
}
