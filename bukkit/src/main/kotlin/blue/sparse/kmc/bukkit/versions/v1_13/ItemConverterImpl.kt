package blue.sparse.kmc.bukkit.versions.v1_13

import blue.sparse.kmc.api.type.item.Item
import blue.sparse.kmc.api.type.item.Items
import blue.sparse.kmc.bukkit.ItemConverter
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ItemConverterImpl : ItemConverter {
	override fun convert(item: Item<*, *>): ItemStack {
		val material = when (item.type) {
			Items.Apple -> Material.APPLE
			Items.ArmorStand -> Material.ARMOR_STAND
			Items.Arrow -> Material.ARROW
			Items.BakedPotato -> Material.BAKED_POTATO
			Items.Beef -> Material.BEEF
			Items.Beetroot -> Material.BEETROOT
			Items.BeetrootSeeds -> Material.BEETROOT_SEEDS
			Items.BeetrootSoup -> Material.BEETROOT_SOUP
			Items.BlazePowder -> Material.BLAZE_POWDER
			Items.BlazeRod -> Material.BLAZE_ROD
			Items.Bone -> Material.BONE
			Items.Book -> Material.BOOK
			Items.Bow -> Material.BOW
			Items.Bowl -> Material.BOWL
			Items.Bread -> Material.BREAD
			Items.Brick -> Material.BRICK
			Items.Bucket -> Material.BUCKET
			Items.Carrot -> Material.CARROT
			Items.CarrotOnAStick -> Material.CARROT_ON_A_STICK
			Items.Charcoal -> Material.CHARCOAL
			Items.ChestMinecart -> Material.CHEST_MINECART
			Items.Chicken -> Material.CHICKEN
			Items.ChorusFruit -> Material.CHORUS_FRUIT
			Items.ClayBall -> Material.CLAY_BALL
			Items.Clock -> Material.CLOCK
			Items.Coal -> Material.COAL
			Items.Cod -> Material.COD
			Items.CodBucket -> Material.COD_BUCKET
			Items.CommandBlockMinecart -> Material.COMMAND_BLOCK_MINECART
			Items.Compass -> Material.COMPASS
			Items.CookedBeef -> Material.COOKED_BEEF
			Items.CookedChicken -> Material.COOKED_CHICKEN
			Items.CookedCod -> Material.COOKED_COD
			Items.CookedMutton -> Material.COOKED_MUTTON
			Items.CookedPorkchop -> Material.COOKED_PORKCHOP
			Items.CookedRabbit -> Material.COOKED_RABBIT
			Items.CookedSalmon -> Material.COOKED_SALMON
			Items.Cookie -> Material.COOKIE
			Items.DebugStick -> Material.DEBUG_STICK
			Items.Diamond -> Material.DIAMOND
			Items.DiamondHorseArmor -> Material.DIAMOND_HORSE_ARMOR
			Items.DragonBreath -> Material.DRAGON_BREATH
			Items.DriedKelp -> Material.DRIED_KELP
			Items.Egg -> Material.EGG
			Items.Elytra -> Material.ELYTRA
			Items.Emerald -> Material.EMERALD
			Items.EnchantedBook -> Material.ENCHANTED_BOOK
			Items.EnchantedGoldenApple -> Material.ENCHANTED_GOLDEN_APPLE
			Items.EnderEye -> Material.ENDER_EYE
			Items.EnderPearl -> Material.ENDER_PEARL
			Items.EndCrystal -> Material.END_CRYSTAL
			Items.ExperienceBottle -> Material.EXPERIENCE_BOTTLE
			Items.Feather -> Material.FEATHER
			Items.FermentedSpiderEye -> Material.FERMENTED_SPIDER_EYE
			Items.FilledMap -> Material.FILLED_MAP
			Items.FireworkRocket -> Material.FIREWORK_ROCKET
			Items.FireworkStar -> Material.FIREWORK_STAR
			Items.FireCharge -> Material.FIRE_CHARGE
			Items.FishingRod -> Material.FISHING_ROD
			Items.Flint -> Material.FLINT
			Items.FlintAndSteel -> Material.FLINT_AND_STEEL
			Items.FurnaceMinecart -> Material.FURNACE_MINECART
			Items.GhastTear -> Material.GHAST_TEAR
			Items.GlassBottle -> Material.GLASS_BOTTLE
			Items.GlisteringMelonSlice -> Material.GLISTERING_MELON_SLICE
			Items.GlowstoneDust -> Material.GLOWSTONE_DUST
			Items.GoldenApple -> Material.GOLDEN_APPLE
			Items.GoldenCarrot -> Material.GOLDEN_CARROT
			Items.GoldenHorseArmor -> Material.GOLDEN_HORSE_ARMOR
			Items.GoldIngot -> Material.GOLD_INGOT
			Items.GoldNugget -> Material.GOLD_NUGGET
			Items.Gunpowder -> Material.GUNPOWDER
			Items.HeartOfTheSea -> Material.HEART_OF_THE_SEA
			Items.HopperMinecart -> Material.HOPPER_MINECART
			Items.IronHorseArmor -> Material.IRON_HORSE_ARMOR
			Items.IronIngot -> Material.IRON_INGOT
			Items.IronNugget -> Material.IRON_NUGGET
			Items.ItemFrame -> Material.ITEM_FRAME
			Items.KnowledgeBook -> Material.KNOWLEDGE_BOOK
			Items.LavaBucket -> Material.LAVA_BUCKET
			Items.Lead -> Material.LEAD
			Items.Leather -> Material.LEATHER
			Items.LingeringPotion -> Material.LINGERING_POTION
			Items.MagmaCream -> Material.MAGMA_CREAM
			Items.Map -> Material.MAP
			Items.MelonSeeds -> Material.MELON_SEEDS
			Items.MelonSlice -> Material.MELON_SLICE
			Items.MilkBucket -> Material.MILK_BUCKET
			Items.Minecart -> Material.MINECART
			Items.MushroomStew -> Material.MUSHROOM_STEW
			Items.Mutton -> Material.MUTTON
			Items.NameTag -> Material.NAME_TAG
			Items.NautilusShell -> Material.NAUTILUS_SHELL
			Items.NetherBrick -> Material.NETHER_BRICK
			Items.NetherStar -> Material.NETHER_STAR
			Items.Painting -> Material.PAINTING
			Items.Paper -> Material.PAPER
			Items.PhantomMembrane -> Material.PHANTOM_MEMBRANE
			Items.PoisonousPotato -> Material.POISONOUS_POTATO
			Items.PoppedChorusFruit -> Material.POPPED_CHORUS_FRUIT
			Items.Porkchop -> Material.PORKCHOP
			Items.Potato -> Material.POTATO
			Items.Potion -> Material.POTION
			Items.PrismarineCrystals -> Material.PRISMARINE_CRYSTALS
			Items.PrismarineShard -> Material.PRISMARINE_SHARD
			Items.Pufferfish -> Material.PUFFERFISH
			Items.PufferfishBucket -> Material.PUFFERFISH_BUCKET
			Items.PumpkinPie -> Material.PUMPKIN_PIE
			Items.PumpkinSeeds -> Material.PUMPKIN_SEEDS
			Items.Quartz -> Material.QUARTZ
			Items.Rabbit -> Material.RABBIT
			Items.RabbitFoot -> Material.RABBIT_FOOT
			Items.RabbitHide -> Material.RABBIT_HIDE
			Items.RabbitStew -> Material.RABBIT_STEW
			Items.Redstone -> Material.REDSTONE
			Items.RottenFlesh -> Material.ROTTEN_FLESH
			Items.Saddle -> Material.SADDLE
			Items.Salmon -> Material.SALMON
			Items.SalmonBucket -> Material.SALMON_BUCKET
			Items.Scute -> Material.SCUTE
			Items.Shears -> Material.SHEARS
			Items.Shield -> Material.SHIELD
			Items.ShulkerShell -> Material.SHULKER_SHELL
			Items.SlimeBall -> Material.SLIME_BALL
			Items.Snowball -> Material.SNOWBALL
			Items.SpectralArrow -> Material.SPECTRAL_ARROW
			Items.SpiderEye -> Material.SPIDER_EYE
			Items.SplashPotion -> Material.SPLASH_POTION
			Items.Stick -> Material.STICK
			Items.String -> Material.STRING
			Items.Sugar -> Material.SUGAR
			Items.TippedArrow -> Material.TIPPED_ARROW
			Items.TntMinecart -> Material.TNT_MINECART
			Items.TotemOfUndying -> Material.TOTEM_OF_UNDYING
			Items.Trident -> Material.TRIDENT
			Items.TropicalFish -> Material.TROPICAL_FISH
			Items.TropicalFishBucket -> Material.TROPICAL_FISH_BUCKET
			Items.TurtleHelmet -> Material.TURTLE_HELMET
			Items.WaterBucket -> Material.WATER_BUCKET
			Items.WheatSeeds -> Material.WHEAT_SEEDS
			Items.WritableBook -> Material.WRITABLE_BOOK
			Items.WrittenBook -> Material.WRITTEN_BOOK
			else -> null
//			Items.MusicDisc -> Material.MUSIC_DISC
//			Items.Dye -> Material.DYE
//			Items.SpawnEgg -> Material.SPAWN_EGG
//			Items.Boat -> Material.BOAT
//			Items.Helmet -> Material.HELMET
//			Items.Chestplate -> Material.CHESTPLATE
//			Items.Leggings -> Material.LEGGINGS
//			Items.Boots -> Material.BOOTS
//			Items.Sword -> Material.SWORD
//			Items.Pickaxe -> Material.PICKAXE
//			Items.Shovel -> Material.SHOVEL
//			Items.Axe -> Material.AXE
//			Items.Hoe -> Material.HOE
		}

		TODO()
	}
}