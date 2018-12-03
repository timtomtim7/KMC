import blue.sparse.kmc.api.util.AnyItem
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

val plugin = Unit

class Persistent<K, V>(val plugin: Unit, val default: (K) -> V) : ReadWriteProperty<K, V> {
	override fun getValue(thisRef: K, property: KProperty<*>): V {
		println("$thisRef $property")
		TODO()
	}

	override fun setValue(thisRef: K, property: KProperty<*>, value: V) {
		println("$thisRef $property $value")
	}
}

var AnyItem.test: Int by Persistent(plugin) {
	it.display.name.hashCode()
}

infix fun AnyItem.attach(any: Any) {}

fun main(args: Array<String>) {

//	player.send(ChatText.Color.GRAY, "Hello! This is ", ChatText.Color.RED, ChatText.Effect.BOLD, "bold red text.")


//	0.test
//	5.test
//	3.test
//	(-53).test


//	val resources = listOf(
//			Item(Items.Redstone),
//			Item(Items.Dye, DyeVariation.Blue),
//			Item(Items.Emerald),
//			Item(Items.Coal),
//			Item(Items.Diamond),
//			Item(Items.GoldIngot),
//			Item(Items.IronIngot)
//	)
//
//	val item = Item(Items.Dye, DyeVariation.Blue)
//	item.display.name = "Hi"

//	val stack = ItemStack(item, 1)
//	val color = stack.item.variation as? DyeVariation
//	println("This item is colored $color")
//
//	val world: World = null as World// = KMC.worlds[0]
//	val wool = Block(Blocks.Wool, DyeVariation.Red)
//	world[0, 64, 0].block = wool

//	world.blocks[0, 64, 0].block = wool

//	Scheduler.delayed(5.minutes) {
//		println("5 seconds later")
//	}
//
//	Scheduler.repeatUntil(interval = 1.seconds, until = 5.seconds) {
//		println("Every second for 5 seconds")
//	}
}
