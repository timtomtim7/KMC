package blue.sparse.kmc.api.type.variations

import blue.sparse.kmc.api.type.Variation

interface BlockVariation: Variation

object NoBlockVariation: BlockVariation

interface FlowerPotVariation: BlockVariation {
	object Empty: FlowerPotVariation
	object Allium: FlowerPotVariation
	object AzureBluet: FlowerPotVariation
	object BlueOrchid: FlowerPotVariation
	object BrownMushroom: FlowerPotVariation
	object Cactus: FlowerPotVariation
	object Dandelion: FlowerPotVariation
	object DeadBush: FlowerPotVariation
	object Fern: FlowerPotVariation
	object OrangeTulip: FlowerPotVariation
	object OxeyeDaisy: FlowerPotVariation
	object PinkTulip: FlowerPotVariation
	object Poppy: FlowerPotVariation
	object RedMushroom: FlowerPotVariation
	object RedTulip: FlowerPotVariation
	object WhiteTulip: FlowerPotVariation
	object AcaciaSapling: FlowerPotVariation
	object BirchSapling: FlowerPotVariation
	object DarkOakSapling: FlowerPotVariation
	object JungleSapling: FlowerPotVariation
	object OakSapling: FlowerPotVariation
	object SpruceSapling: FlowerPotVariation
}

interface CoralVariation: BlockVariation {
	object Brain: CoralVariation
	object Bubble: CoralVariation
	object Fire: CoralVariation
	object Horn: CoralVariation
	object Tube: CoralVariation
}

interface ButtonVariation: BlockVariation {
	object Stone: ButtonVariation
}

interface DoorVariation: BlockVariation {
	object Iron: DoorVariation
}

interface TrapdoorVariation: BlockVariation {
	object Iron: DoorVariation
}

interface FenceVariation: BlockVariation {
	object NetherBrick: FenceVariation
}

interface FenceGateVariation: BlockVariation
interface LeavesVariation: BlockVariation
interface LogVariation: BlockVariation
interface PlanksVariation: BlockVariation
interface SaplingVariation: BlockVariation
interface StrippedWoodVariation: BlockVariation
interface StrippedLogVariation: BlockVariation

interface WoodVariation: BlockVariation,
						 SaplingVariation,
						 PlanksVariation,
						 LogVariation,
						 LeavesVariation,
						 FenceGateVariation,
						 FenceVariation,
						 DoorVariation,
						 ButtonVariation,
						 StrippedWoodVariation,
						 StrippedLogVariation,
						 StairVariation,
						 PressurePlateVariation,
						 SlabVariation
{
	object Acacia: WoodVariation
	object Birch: WoodVariation
	object DarkOak: WoodVariation
	object Jungle: WoodVariation
	object Oak: WoodVariation
	object Spruce: WoodVariation
}

interface PressurePlateVariation: BlockVariation {
	object HeavyWeighted: PressurePlateVariation
	object LightWeighted: PressurePlateVariation
	object Stone: PressurePlateVariation
}

interface OreVariation: BlockVariation {
	object Coal: OreVariation
	object Diamond: OreVariation
	object Emerald: OreVariation
	object Gold: OreVariation
	object Iron: OreVariation
	object Lapis: OreVariation
	object NetherQuartz: OreVariation
	object Redstone: OreVariation
}

interface AnvilVariation: BlockVariation {
	object Normal: AnvilVariation
	object Chipped: AnvilVariation
	object Damaged: AnvilVariation
}

interface IceVariation: BlockVariation {
	object Normal: IceVariation
	object Frosted: IceVariation
	object Packed: IceVariation
	object Blue: IceVariation
}

interface StairVariation: BlockVariation {
	object Brick: StairVariation
	object Cobblestone: StairVariation
	object DarkPrismarine: StairVariation
	object NetherBrick: StairVariation
	object PrismarineBrick: StairVariation
	object Prismarine: StairVariation
	object Purpur: StairVariation
	object Quartz: StairVariation
	object Sandstone: StairVariation
	object StoneBrick: StairVariation
	object RedSandstone: StairVariation
}

interface SlabVariation: BlockVariation {
	object Brick: SlabVariation
	object Cobblestone: SlabVariation
	object DarkPrismarine: SlabVariation
	object NetherBrick: SlabVariation
	object PrismarineBrick: SlabVariation
	object Prismarine: SlabVariation
	object Purpur: SlabVariation
	object Quartz: SlabVariation
	object Sandstone: SlabVariation
	object StoneBrick: SlabVariation
	object Stone: SlabVariation
	object PetrifiedOak: SlabVariation
	object RedSandstone: SlabVariation
}

interface SpongeVariation: BlockVariation {
	object Dry: SpongeVariation
	object Wet: SpongeVariation
}

interface AirVariation: BlockVariation {
	object Normal: AirVariation
	object Void: AirVariation
	object Cave: AirVariation
}

interface StoneVariation: BlockVariation {
	object Normal: StoneVariation
	object Andesite: StoneVariation
	object Diorite: StoneVariation
	object Granite: StoneVariation
}

interface PolishedStoneVariation: BlockVariation {
	object Andesite: StoneVariation
	object Diorite: StoneVariation
	object Granite: StoneVariation
}