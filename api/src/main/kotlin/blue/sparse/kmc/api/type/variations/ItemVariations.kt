package blue.sparse.kmc.api.type.variations

import blue.sparse.kmc.api.type.Variation

interface ItemVariation: Variation

object NoItemVariation: ItemVariation

interface BoatVariation: ItemVariation {
	object Oak: BoatVariation
	object Birch: BoatVariation
	object Spruce: BoatVariation
	object Jungle: BoatVariation
	object DarkOak: BoatVariation
	object Acacia: BoatVariation
}

interface ArmorVariation: ItemVariation {
	object Leather: ArmorVariation
	object Chain: ArmorVariation
	object Iron: ArmorVariation
	object Gold: ArmorVariation
	object Diamond: ArmorVariation
}

interface ToolVariation: ItemVariation {
	object Leather: ToolVariation
	object Stone: ToolVariation
	object Iron: ToolVariation
	object Gold: ToolVariation
	object Diamond: ToolVariation
}

interface SpawnEggVariation: ItemVariation {
	object Bat: SpawnEggVariation
	object Blaze: SpawnEggVariation
	object CaveSpider: SpawnEggVariation
	object Chicken: SpawnEggVariation
	object Cod: SpawnEggVariation
	object Cow: SpawnEggVariation
	object Creeper: SpawnEggVariation
	object Dolphin: SpawnEggVariation
	object Donkey: SpawnEggVariation
	object Drowned: SpawnEggVariation
	object ElderGuardian: SpawnEggVariation
	object Enderman: SpawnEggVariation
	object Endermite: SpawnEggVariation
	object Evoker: SpawnEggVariation
	object Ghast: SpawnEggVariation
	object Guardian: SpawnEggVariation
	object Horse: SpawnEggVariation
	object Husk: SpawnEggVariation
	object Llama: SpawnEggVariation
	object MagmaCube: SpawnEggVariation
	object Mooshroom: SpawnEggVariation
	object Mule: SpawnEggVariation
	object Ocelot: SpawnEggVariation
	object Parrot: SpawnEggVariation
	object Phantom: SpawnEggVariation
	object Pig: SpawnEggVariation
	object PolarBear: SpawnEggVariation
	object Pufferfish: SpawnEggVariation
	object Rabbit: SpawnEggVariation
	object Salmon: SpawnEggVariation
	object Sheep: SpawnEggVariation
	object Shulker: SpawnEggVariation
	object Silverfish: SpawnEggVariation
	object SkeletonHorse: SpawnEggVariation
	object Skeleton: SpawnEggVariation
	object Slime: SpawnEggVariation
	object Spider: SpawnEggVariation
	object Squid: SpawnEggVariation
	object Stray: SpawnEggVariation
	object TropicalFish: SpawnEggVariation
	object Turtle: SpawnEggVariation
	object Vex: SpawnEggVariation
	object Villager: SpawnEggVariation
	object Vindicator: SpawnEggVariation
	object Witch: SpawnEggVariation
	object WitherSkeleton: SpawnEggVariation
	object Wolf: SpawnEggVariation
	object ZombieHorse: SpawnEggVariation
	object ZombiePigman: SpawnEggVariation
	object Zombie: SpawnEggVariation
	object ZombieVillager: SpawnEggVariation
}

interface MusicDiscVariation: ItemVariation {
	object `11`: MusicDiscVariation
	object `13`: MusicDiscVariation
	object Blocks: MusicDiscVariation
	object Cat: MusicDiscVariation
	object Chirp: MusicDiscVariation
	object Far: MusicDiscVariation
	object Mall: MusicDiscVariation
	object Mellohi: MusicDiscVariation
	object Stal: MusicDiscVariation
	object Strad: MusicDiscVariation
	object Wait: MusicDiscVariation
	object Ward: MusicDiscVariation
}