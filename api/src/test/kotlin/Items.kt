import blue.sparse.kmc.api.KMC
import blue.sparse.kmc.api.type.item.*
import java.util.zip.ZipFile
import java.util.zip.ZipOutputStream

//import Items.Apple
//import Items.Armor.Helmet
//import Items.Armor.Material.Diamond
//
//abstract class ItemType<V : Variation>
//abstract class ItemTypeDurable<V : Variation> : ItemType<V>()
//abstract class Variation
//
//object NoItemVariation : Variation()
//
//class Item<T : ItemType<V>, V : Variation>(
//		val type: T,
//		val variation: V
//) {
//
//	@Suppress("UNCHECKED_CAST")
//	inline fun <reified T : ItemType<V>, reified V : Variation> castVariation(): Item<T, V>? {
//		if (type is T && variation is V)
//			return this as Item<T, V>
//		return null
//	}
//
//	@Suppress("UNCHECKED_CAST")
//	inline fun <reified T : ItemType<*>> cast(): Item<T, *>? {
//		if (type is T)
//			return this as Item<T, *>
//		return null
//	}
//
//
//	companion object {
//		operator fun <T : ItemType<NoItemVariation>> invoke(type: T): Item<T, NoItemVariation> {
//			return Item(type, NoItemVariation)
//		}
//	}
//
//}
//
//var Item<out ItemTypeDurable<*>, *>.durability: Int
//	get() = TODO()
//	set(value) = TODO()
//
//typealias UnknownItem = Item<*, *>
//typealias SimpleItem<T> = Item<T, *>
//
//abstract class WoodType : Variation() {
//	object Oak : WoodType()
//	object Spruce : WoodType()
//	object Birch : WoodType()
//	object Jungle : WoodType()
//	object Acacia : WoodType()
//	object DarkOak : WoodType()
//}
//
//object Items {
//
//	object Apple : ItemType<NoItemVariation>()
//
//	object Boat : ItemType<WoodType>()
//
//	abstract class Tool : ItemTypeDurable<Tool.Material>() {
//		object Sword : Tool()
//		object Axe : Tool()
//		object Pickaxe : Tool()
//		object Shovel : Tool()
//		object Hoe : Tool()
//
//		abstract class Material : Variation() {
//			object Leather : Material()
//			object Stone : Material()
//			object Iron : Material()
//			object Gold : Material()
//			object Diamond : Material()
//		}
//	}
//
//	abstract class Armor : ItemTypeDurable<Armor.Material>() {
//		object Helmet : Armor()
//		object Chestplate : Armor()
//		object Leggings : Armor()
//		object Boots : Armor()
//
//		abstract class Material : Variation() {
//			object Leather : Material()
//			object Chain : Material()
//			object Iron : Material()
//			object Gold : Material()
//			object Diamond : Material()
//		}
//	}
//
//}
//
//fun main(args: Array<String>) {
//	val diamondHelmet = Item(Helmet, Diamond)
//	val apple = Item(Apple)
//
////	apple.durability = 0 //Compile error
//	diamondHelmet.durability = 64
//}
//
//fun UnknownItem.asDurable(): SimpleItem<ItemTypeDurable<*>>? = cast()
//
//fun isBroken(item: UnknownItem): Boolean {
//	return (item.asDurable() ?: return false).durability <= 0
//}


fun main(args: Array<String>) {

	val item = Item(Items.Apple)
	item.display.name = "It's an apple!"
	println(item.display.name)

}