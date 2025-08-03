package sirstotes.pucks_building_additions;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/*? if >1.20.1 {*/
import net.fabricmc.fabric.impl.tag.convention.v2.TagRegistration;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
/*?} else {*/
/*import net.fabricmc.fabric.impl.tag.convention.TagRegistration;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.enums.Instrument;
*//*?}*/

public class PucksBuildingAdditionsBlocks {
    public static Block register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        Identifier id = Identifier.of(PucksBuildingAdditions.MOD_ID, name);
        //? if >1.20.1 {
        Block block = factory.apply(settings.registryKey(RegistryKey.of(RegistryKeys.BLOCK, id)));
        //?} else {
        /*Block block = factory.apply(settings);
        *///?}

        if (shouldRegisterItem) {
            Item.Settings s = new Item.Settings()
                    //? if >1.20.1 {
                    .useBlockPrefixedTranslationKey()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, id))
                    //?}
                    //? if <=1.19.2
                    /*.group(PucksBuildingAdditions.CUSTOM_ITEM_GROUP)*/;
            BlockItem blockItem = new BlockItem(block, s);
            Registry.register(/*? if >1.19.2 {*/Registries/*?} else {*//*Registry*//*?}*/.ITEM, id, blockItem);
        }

        return Registry.register(/*? if >1.19.2 {*/Registries/*?} else {*//*Registry*//*?}*/.BLOCK, id, block);
    }

    public static AbstractBlock.Settings createFlowerPotSettings() {
        //? if >1.20.1 {
        return Blocks.createFlowerPotSettings();
        //?} else {
        /*return AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY);
        *///?}
    }
    
    public static ColoredFlowerPotBlock[] registerFlowerPots(String color) {
        ColoredFlowerPotBlock parent = (ColoredFlowerPotBlock) register(color + "_flower_pot", (settings) -> new ColoredFlowerPotBlock(null, settings, "flower_pot"), createFlowerPotSettings(), true);
        return new ColoredFlowerPotBlock[] {
                parent,
                (ColoredFlowerPotBlock) register(color + "_potted_fern", (settings) -> new ColoredFlowerPotBlock(Blocks.FERN, parent, settings, "potted_fern"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_torchflower", (settings) -> new ColoredFlowerPotBlock(Blocks.TORCHFLOWER, parent, settings, "potted_torchflower"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_oak_sapling", (settings) -> new ColoredFlowerPotBlock(Blocks.OAK_SAPLING, parent, settings, "potted_oak_sapling"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_spruce_sapling", (settings) -> new ColoredFlowerPotBlock(Blocks.SPRUCE_SAPLING, parent, settings, "potted_spruce_sapling"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_birch_sapling", (settings) -> new ColoredFlowerPotBlock(Blocks.BIRCH_SAPLING, parent, settings, "potted_birch_sapling"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_jungle_sapling", (settings) -> new ColoredFlowerPotBlock(Blocks.JUNGLE_SAPLING, parent, settings, "potted_jungle_sapling"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_acacia_sapling", (settings) -> new ColoredFlowerPotBlock(Blocks.ACACIA_SAPLING, parent, settings, "potted_acacia_sapling"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_cherry_sapling", (settings) -> new ColoredFlowerPotBlock(Blocks.CHERRY_SAPLING, parent, settings, "potted_cherry_sapling"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_dark_oak_sapling", (settings) -> new ColoredFlowerPotBlock(Blocks.DARK_OAK_SAPLING, parent, settings, "potted_dark_oak_sapling"), createFlowerPotSettings(), false),
                //? if >1.20.1
                (ColoredFlowerPotBlock) register(color + "_potted_pale_oak_sapling", (settings) -> new ColoredFlowerPotBlock(Blocks.PALE_OAK_SAPLING, parent, settings, "potted_pale_oak_sapling"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_mangrove_propagule", (settings) -> new ColoredFlowerPotBlock(Blocks.MANGROVE_PROPAGULE, parent, settings, "potted_mangrove_propagule"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_dandelion", (settings) -> new ColoredFlowerPotBlock(Blocks.DANDELION, parent, settings, "potted_dandelion"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_poppy", (settings) -> new ColoredFlowerPotBlock(Blocks.POPPY, parent, settings, "potted_poppy"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_blue_orchid", (settings) -> new ColoredFlowerPotBlock(Blocks.BLUE_ORCHID, parent, settings, "potted_blue_orchid"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_allium", (settings) -> new ColoredFlowerPotBlock(Blocks.ALLIUM, parent, settings, "potted_allium"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_azure_bluet", (settings) -> new ColoredFlowerPotBlock(Blocks.AZURE_BLUET, parent, settings, "potted_azure_bluet"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_red_tulip", (settings) -> new ColoredFlowerPotBlock(Blocks.RED_TULIP, parent, settings, "potted_red_tulip"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_orange_tulip", (settings) -> new ColoredFlowerPotBlock(Blocks.ORANGE_TULIP, parent, settings, "potted_orange_tulip"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_white_tulip", (settings) -> new ColoredFlowerPotBlock(Blocks.WHITE_TULIP, parent, settings, "potted_white_tulip"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_pink_tulip", (settings) -> new ColoredFlowerPotBlock(Blocks.PINK_TULIP, parent, settings, "potted_pink_tulip"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_oxeye_daisy", (settings) -> new ColoredFlowerPotBlock(Blocks.OXEYE_DAISY, parent, settings, "potted_oxeye_daisy"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_cornflower", (settings) -> new ColoredFlowerPotBlock(Blocks.CORNFLOWER, parent, settings, "potted_cornflower"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_lily_of_the_valley", (settings) -> new ColoredFlowerPotBlock(Blocks.LILY_OF_THE_VALLEY, parent, settings, "potted_lily_of_the_valley"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_wither_rose", (settings) -> new ColoredFlowerPotBlock(Blocks.WITHER_ROSE, parent, settings, "potted_wither_rose"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_red_mushroom", (settings) -> new ColoredFlowerPotBlock(Blocks.RED_MUSHROOM, parent, settings, "potted_red_mushroom"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_brown_mushroom", (settings) -> new ColoredFlowerPotBlock(Blocks.BROWN_MUSHROOM, parent, settings, "potted_brown_mushroom"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_dead_bush", (settings) -> new ColoredFlowerPotBlock(Blocks.DEAD_BUSH, parent, settings, "potted_dead_bush"), createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_cactus", (settings) -> new ColoredFlowerPotBlock(Blocks.CACTUS, parent, settings, "potted_cactus"), createFlowerPotSettings(), false)
        };
    }

    public static Identifier ofVanilla(String path) {
        /*? if >1.20.1 {*/
        return Identifier.ofVanilla(path);
        /*?} else {*/
        /*return Identifier.of("minecraft", path);
        *//*?}*/
    }
    
    public static LargeFlowerPotBlock[] registerLargeFlowerPots(String color) {
        LargeFlowerPotBlock parent = (LargeFlowerPotBlock) register(color + "large_flower_pot", (settings) -> new LargeFlowerPotBlock(Blocks.AIR, settings, "large_flower_pot"), createFlowerPotSettings(), true);
        return new LargeFlowerPotBlock[] {
                parent,
                (LargeFlowerPotBlock) register(color + "potted_tall_grass", (settings) -> new LargeFlowerPotBlock(Blocks.TALL_GRASS, parent, settings, "potted_tall_grass"), createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_large_fern", (settings) -> new LargeFlowerPotBlock(Blocks.LARGE_FERN, parent, settings, "potted_large_fern"), createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_bamboo", (settings) -> new LargeFlowerPotBlock(Blocks.BAMBOO, parent, settings, "potted_bamboo"), createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_large_cactus", (settings) -> new LargeFlowerPotBlock(Blocks.CACTUS, parent, settings, "potted_large_cactus"), createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_sugar_cane", (settings) -> new LargeFlowerPotBlock(Blocks.SUGAR_CANE, parent, settings, "potted_sugar_cane"), createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_sunflower", (settings) -> new LargeFlowerPotBlock(Blocks.SUNFLOWER, parent, settings, "potted_sunflower"), createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_small_dripleaf", (settings) -> new LargeFlowerPotBlock(Blocks.SMALL_DRIPLEAF, parent, settings, "potted_small_dripleaf"), createFlowerPotSettings(), false),

                (LargeFlowerPotBlock) register(color + "potted_lilac", (settings) -> new LargeFlowerPotBlock(Blocks.LILAC, parent, settings, "potted_lilac", ofVanilla("block/lilac_bottom"), ofVanilla("block/lilac_top")), createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_peony", (settings) -> new LargeFlowerPotBlock(Blocks.PEONY, parent, settings, "potted_peony", ofVanilla("block/peony_bottom"), ofVanilla("block/peony_top")), createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_rose_bush", (settings) -> new LargeFlowerPotBlock(Blocks.ROSE_BUSH, parent, settings, "potted_rose_bush", ofVanilla("block/rose_bush_bottom"), ofVanilla("block/rose_bush_top")), createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_pitcher_plant", (settings) -> new LargeFlowerPotBlock(Blocks.PITCHER_PLANT, parent, settings, "potted_pitcher_plant", ofVanilla("block/pitcher_crop_bottom_stage_4"), ofVanilla("block/pitcher_crop_top_stage_4")), createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_twisting_vines", (settings) -> new LargeFlowerPotBlock(Blocks.TWISTING_VINES, parent, settings, "potted_twisting_vines", ofVanilla("block/twisting_vines_plant"), ofVanilla("block/twisting_vines")), createFlowerPotSettings(), false)
        };
    }

    public static HangingFlowerPotBlock[] registerHangingFlowerPots(String color) {
        HangingFlowerPotBlock parent = (HangingFlowerPotBlock) register(color + "hanging_flower_pot", (settings) -> new HangingFlowerPotBlock(Blocks.AIR, settings, "hanging_flower_pot"), createFlowerPotSettings(), true);
        return new HangingFlowerPotBlock[]{
                parent,
                (HangingFlowerPotBlock) register(color + "potted_vines", (settings) -> new HangingFlowerPotBlock(Blocks.VINE, parent, settings, "potted_vines"), createFlowerPotSettings(), false),
                (HangingFlowerPotBlock) register(color + "potted_cave_vines", (settings) -> new HangingFlowerPotBlock(Blocks.CAVE_VINES, parent, settings, "potted_cave_vines", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/cave_vines_berries")), createFlowerPotSettings(), false),
                (HangingFlowerPotBlock) register(color + "potted_weeping_vines", (settings) -> new HangingFlowerPotBlock(Blocks.WEEPING_VINES, parent, settings, "potted_weeping_vines", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/weeping_vines")), createFlowerPotSettings(), false),
                //? if >1.20.1
                (HangingFlowerPotBlock) register(color + "potted_pale_hanging_moss", (settings) -> new HangingFlowerPotBlock(Blocks.PALE_HANGING_MOSS, parent, settings, "potted_pale_hanging_moss", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/pale_vines")), createFlowerPotSettings(), false)
        };
    }

    public static <T extends BlockEntityType<?>> T registerBlockEntity(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(PucksBuildingAdditions.MOD_ID, path), blockEntityType);
    }

    private static final AbstractBlock.Settings woodenSettings = AbstractBlock.Settings.create().strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable().pistonBehavior(PistonBehavior.IGNORE);
    public static final SittableBlock OAK_BENCH = (SittableBlock) register("oak_bench", SittableBlock::new, woodenSettings, true);
    public static final SittableBlock OAK_SEAT = (SittableBlock) register("oak_seat", BackedSittableBlock::new, woodenSettings, true);
    public static final SittableBlock OAK_STOOL = (SittableBlock) register("oak_stool", StoolBlock::new, woodenSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock SPRUCE_BENCH = (SittableBlock) register("spruce_bench", SittableBlock::new, woodenSettings, true);
    public static final SittableBlock SPRUCE_SEAT = (SittableBlock) register("spruce_seat", BackedSittableBlock::new, woodenSettings, true);
    public static final SittableBlock SPRUCE_STOOL = (SittableBlock) register("spruce_stool", StoolBlock::new, woodenSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock BIRCH_BENCH = (SittableBlock) register("birch_bench", SittableBlock::new, woodenSettings, true);
    public static final SittableBlock BIRCH_SEAT = (SittableBlock) register("birch_seat", BackedSittableBlock::new, woodenSettings, true);
    public static final SittableBlock BIRCH_STOOL = (SittableBlock) register("birch_stool", StoolBlock::new, woodenSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock JUNGLE_BENCH = (SittableBlock) register("jungle_bench", SittableBlock::new, woodenSettings, true);
    public static final SittableBlock JUNGLE_SEAT = (SittableBlock) register("jungle_seat", BackedSittableBlock::new, woodenSettings, true);
    public static final SittableBlock JUNGLE_STOOL = (SittableBlock) register("jungle_stool", StoolBlock::new, woodenSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock ACACIA_BENCH = (SittableBlock) register("acacia_bench", SittableBlock::new, woodenSettings, true);
    public static final SittableBlock ACACIA_SEAT = (SittableBlock) register("acacia_seat", BackedSittableBlock::new, woodenSettings, true);
    public static final SittableBlock ACACIA_STOOL = (SittableBlock) register("acacia_stool", StoolBlock::new, woodenSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock DARK_OAK_BENCH = (SittableBlock) register("dark_oak_bench", SittableBlock::new, woodenSettings, true);
    public static final SittableBlock DARK_OAK_SEAT = (SittableBlock) register("dark_oak_seat", BackedSittableBlock::new, woodenSettings, true);
    public static final SittableBlock DARK_OAK_STOOL = (SittableBlock) register("dark_oak_stool", StoolBlock::new, woodenSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock MANGROVE_BENCH = (SittableBlock) register("mangrove_bench", SittableBlock::new, woodenSettings, true);
    public static final SittableBlock MANGROVE_SEAT = (SittableBlock) register("mangrove_seat", BackedSittableBlock::new, woodenSettings, true);
    public static final SittableBlock MANGROVE_STOOL = (SittableBlock) register("mangrove_stool", StoolBlock::new, woodenSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock CHERRY_BENCH = (SittableBlock) register("cherry_bench", SittableBlock::new, woodenSettings, true);
    public static final SittableBlock CHERRY_SEAT = (SittableBlock) register("cherry_seat", BackedSittableBlock::new, woodenSettings, true);
    public static final SittableBlock CHERRY_STOOL = (SittableBlock) register("cherry_stool", StoolBlock::new, woodenSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    /*? if >1.20.1 {*/
    public static final SittableBlock PALE_OAK_BENCH = (SittableBlock) register("pale_oak_bench", SittableBlock::new, woodenSettings, true);
    public static final SittableBlock PALE_OAK_SEAT = (SittableBlock) register("pale_oak_seat", BackedSittableBlock::new, woodenSettings, true);
    public static final SittableBlock PALE_OAK_STOOL = (SittableBlock) register("pale_oak_stool", StoolBlock::new, woodenSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    /*?}*/
    public static final SittableBlock CRIMSON_BENCH = (SittableBlock) register("crimson_bench", SittableBlock::new, woodenSettings, true);
    public static final SittableBlock CRIMSON_SEAT = (SittableBlock) register("crimson_seat", BackedSittableBlock::new, woodenSettings, true);
    public static final SittableBlock CRIMSON_STOOL = (SittableBlock) register("crimson_stool", StoolBlock::new, woodenSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock WARPED_BENCH = (SittableBlock) register("warped_bench", SittableBlock::new, woodenSettings, true);
    public static final SittableBlock WARPED_SEAT = (SittableBlock) register("warped_seat", BackedSittableBlock::new, woodenSettings, true);
    public static final SittableBlock WARPED_STOOL = (SittableBlock) register("warped_stool", StoolBlock::new, woodenSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock BAMBOO_BENCH = (SittableBlock) register("bamboo_bench", SittableBlock::new, woodenSettings, true);
    public static final SittableBlock BAMBOO_SEAT = (SittableBlock) register("bamboo_seat", BackedSittableBlock::new, woodenSettings, true);
    public static final SittableBlock BAMBOO_STOOL = (SittableBlock) register("bamboo_stool", StoolBlock::new, woodenSettings.pistonBehavior(PistonBehavior.DESTROY), true);

    /*? if >1.20.1 {*/
    public static final TagKey<Item> FLOWER_POT_ITEM_TAG = TagRegistration.ITEM_TAG.registerFabric("flower_pot");
    public static final TagKey<Item> LARGE_FLOWER_POT_ITEM_TAG = TagRegistration.ITEM_TAG.registerFabric("large_flower_pot");
    public static final TagKey<Item> HANGING_FLOWER_POT_ITEM_TAG = TagRegistration.ITEM_TAG.registerFabric("hanging_flower_pot");
    /*?} else {*/
    /*public static final TagKey<Item> FLOWER_POT_ITEM_TAG = TagRegistration.ITEM_TAG_REGISTRATION.registerFabric("flower_pot");
    public static final TagKey<Item> LARGE_FLOWER_POT_ITEM_TAG = TagRegistration.ITEM_TAG_REGISTRATION.registerFabric("large_flower_pot");
    public static final TagKey<Item> HANGING_FLOWER_POT_ITEM_TAG = TagRegistration.ITEM_TAG_REGISTRATION.registerFabric("hanging_flower_pot");
    *//*?}*/
    public static final ColoredFlowerPotBlock[] RED_FLOWER_POTS = registerFlowerPots("red");
    public static final ColoredFlowerPotBlock[] ORANGE_FLOWER_POTS = registerFlowerPots("orange");
    public static final ColoredFlowerPotBlock[] YELLOW_FLOWER_POTS = registerFlowerPots("yellow");
    public static final ColoredFlowerPotBlock[] LIME_FLOWER_POTS = registerFlowerPots("lime");
    public static final ColoredFlowerPotBlock[] GREEN_FLOWER_POTS = registerFlowerPots("green");
    public static final ColoredFlowerPotBlock[] CYAN_FLOWER_POTS = registerFlowerPots("cyan");
    public static final ColoredFlowerPotBlock[] LIGHT_BLUE_FLOWER_POTS = registerFlowerPots("light_blue");
    public static final ColoredFlowerPotBlock[] BLUE_FLOWER_POTS = registerFlowerPots("blue");
    public static final ColoredFlowerPotBlock[] PURPLE_FLOWER_POTS = registerFlowerPots("purple");
    public static final ColoredFlowerPotBlock[] MAGENTA_FLOWER_POTS = registerFlowerPots("magenta");
    public static final ColoredFlowerPotBlock[] PINK_FLOWER_POTS = registerFlowerPots("pink");
    public static final ColoredFlowerPotBlock[] BROWN_FLOWER_POTS = registerFlowerPots("brown");
    public static final ColoredFlowerPotBlock[] WHITE_FLOWER_POTS = registerFlowerPots("white");
    public static final ColoredFlowerPotBlock[] LIGHT_GRAY_FLOWER_POTS = registerFlowerPots("light_gray");
    public static final ColoredFlowerPotBlock[] GRAY_FLOWER_POTS = registerFlowerPots("gray");
    public static final ColoredFlowerPotBlock[] BLACK_FLOWER_POTS = registerFlowerPots("black");

    public static final LargeFlowerPotBlock[] LARGE_FLOWER_POTS = registerLargeFlowerPots("");
    public static final LargeFlowerPotBlock[] RED_LARGE_FLOWER_POTS = registerLargeFlowerPots("red_");
    public static final LargeFlowerPotBlock[] ORANGE_LARGE_FLOWER_POTS = registerLargeFlowerPots("orange_");
    public static final LargeFlowerPotBlock[] YELLOW_LARGE_FLOWER_POTS = registerLargeFlowerPots("yellow_");
    public static final LargeFlowerPotBlock[] LIME_LARGE_FLOWER_POTS = registerLargeFlowerPots("lime_");
    public static final LargeFlowerPotBlock[] GREEN_LARGE_FLOWER_POTS = registerLargeFlowerPots("green_");
    public static final LargeFlowerPotBlock[] CYAN_LARGE_FLOWER_POTS = registerLargeFlowerPots("cyan_");
    public static final LargeFlowerPotBlock[] LIGHT_BLUE_LARGE_FLOWER_POTS = registerLargeFlowerPots("light_blue_");
    public static final LargeFlowerPotBlock[] BLUE_LARGE_FLOWER_POTS = registerLargeFlowerPots("blue_");
    public static final LargeFlowerPotBlock[] PURPLE_LARGE_FLOWER_POTS = registerLargeFlowerPots("purple_");
    public static final LargeFlowerPotBlock[] MAGENTA_LARGE_FLOWER_POTS = registerLargeFlowerPots("magenta_");
    public static final LargeFlowerPotBlock[] PINK_LARGE_FLOWER_POTS = registerLargeFlowerPots("pink_");
    public static final LargeFlowerPotBlock[] BROWN_LARGE_FLOWER_POTS = registerLargeFlowerPots("brown_");
    public static final LargeFlowerPotBlock[] WHITE_LARGE_FLOWER_POTS = registerLargeFlowerPots("white_");
    public static final LargeFlowerPotBlock[] LIGHT_GRAY_LARGE_FLOWER_POTS = registerLargeFlowerPots("light_gray_");
    public static final LargeFlowerPotBlock[] GRAY_LARGE_FLOWER_POTS = registerLargeFlowerPots("gray_");
    public static final LargeFlowerPotBlock[] BLACK_LARGE_FLOWER_POTS = registerLargeFlowerPots("black_");

    public static final HangingFlowerPotBlock[] HANGING_FLOWER_POTS = registerHangingFlowerPots("");
    public static final HangingFlowerPotBlock[] RED_HANGING_FLOWER_POTS = registerHangingFlowerPots("red_");
    public static final HangingFlowerPotBlock[] ORANGE_HANGING_FLOWER_POTS = registerHangingFlowerPots("orange_");
    public static final HangingFlowerPotBlock[] YELLOW_HANGING_FLOWER_POTS = registerHangingFlowerPots("yellow_");
    public static final HangingFlowerPotBlock[] LIME_HANGING_FLOWER_POTS = registerHangingFlowerPots("lime_");
    public static final HangingFlowerPotBlock[] GREEN_HANGING_FLOWER_POTS = registerHangingFlowerPots("green_");
    public static final HangingFlowerPotBlock[] CYAN_HANGING_FLOWER_POTS = registerHangingFlowerPots("cyan_");
    public static final HangingFlowerPotBlock[] LIGHT_BLUE_HANGING_FLOWER_POTS = registerHangingFlowerPots("light_blue_");
    public static final HangingFlowerPotBlock[] BLUE_HANGING_FLOWER_POTS = registerHangingFlowerPots("blue_");
    public static final HangingFlowerPotBlock[] PURPLE_HANGING_FLOWER_POTS = registerHangingFlowerPots("purple_");
    public static final HangingFlowerPotBlock[] MAGENTA_HANGING_FLOWER_POTS = registerHangingFlowerPots("magenta_");
    public static final HangingFlowerPotBlock[] PINK_HANGING_FLOWER_POTS = registerHangingFlowerPots("pink_");
    public static final HangingFlowerPotBlock[] BROWN_HANGING_FLOWER_POTS = registerHangingFlowerPots("brown_");
    public static final HangingFlowerPotBlock[] WHITE_HANGING_FLOWER_POTS = registerHangingFlowerPots("white_");
    public static final HangingFlowerPotBlock[] LIGHT_GRAY_HANGING_FLOWER_POTS = registerHangingFlowerPots("light_gray_");
    public static final HangingFlowerPotBlock[] GRAY_HANGING_FLOWER_POTS = registerHangingFlowerPots("gray_");
    public static final HangingFlowerPotBlock[] BLACK_HANGING_FLOWER_POTS = registerHangingFlowerPots("black_");

    /*? if >1.20.1 {*/
    public static final DecoratedPotBlock RED_DECORATED_POT = (DecoratedPotBlock) register("red_decorated_pot", (settings) -> new DecoratedPotBlock(settings) {@Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new ColoredDecoratedPotBlockEntity(pos, state, "red");}}, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_RED).strength(0.0F, 0.0F).pistonBehavior(PistonBehavior.DESTROY).nonOpaque(), true);
    public static final DecoratedPotBlock ORANGE_DECORATED_POT = (DecoratedPotBlock) register("orange_decorated_pot", (settings) -> new DecoratedPotBlock(settings) {@Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new ColoredDecoratedPotBlockEntity(pos, state, "orange");}}, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_ORANGE).strength(0.0F, 0.0F).pistonBehavior(PistonBehavior.DESTROY).nonOpaque(), true);
    public static final DecoratedPotBlock YELLOW_DECORATED_POT = (DecoratedPotBlock) register("yellow_decorated_pot", (settings) -> new DecoratedPotBlock(settings) {@Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new ColoredDecoratedPotBlockEntity(pos, state, "yellow");}}, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.0F, 0.0F).pistonBehavior(PistonBehavior.DESTROY).nonOpaque(), true);
    public static final DecoratedPotBlock LIME_DECORATED_POT = (DecoratedPotBlock) register("lime_decorated_pot", (settings) -> new DecoratedPotBlock(settings) {@Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new ColoredDecoratedPotBlockEntity(pos, state, "lime");}}, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_LIME).strength(0.0F, 0.0F).pistonBehavior(PistonBehavior.DESTROY).nonOpaque(), true);
    public static final DecoratedPotBlock GREEN_DECORATED_POT = (DecoratedPotBlock) register("green_decorated_pot", (settings) -> new DecoratedPotBlock(settings) {@Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new ColoredDecoratedPotBlockEntity(pos, state, "green");}}, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_GREEN).strength(0.0F, 0.0F).pistonBehavior(PistonBehavior.DESTROY).nonOpaque(), true);
    public static final DecoratedPotBlock CYAN_DECORATED_POT = (DecoratedPotBlock) register("cyan_decorated_pot", (settings) -> new DecoratedPotBlock(settings) {@Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new ColoredDecoratedPotBlockEntity(pos, state, "cyan");}}, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_CYAN).strength(0.0F, 0.0F).pistonBehavior(PistonBehavior.DESTROY).nonOpaque(), true);
    public static final DecoratedPotBlock LIGHT_BLUE_DECORATED_POT = (DecoratedPotBlock) register("light_blue_decorated_pot", (settings) -> new DecoratedPotBlock(settings) {@Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new ColoredDecoratedPotBlockEntity(pos, state, "light_blue");}}, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).strength(0.0F, 0.0F).pistonBehavior(PistonBehavior.DESTROY).nonOpaque(), true);
    public static final DecoratedPotBlock BLUE_DECORATED_POT = (DecoratedPotBlock) register("blue_decorated_pot", (settings) -> new DecoratedPotBlock(settings) {@Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new ColoredDecoratedPotBlockEntity(pos, state, "blue");}}, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_BLUE).strength(0.0F, 0.0F).pistonBehavior(PistonBehavior.DESTROY).nonOpaque(), true);
    public static final DecoratedPotBlock PURPLE_DECORATED_POT = (DecoratedPotBlock) register("purple_decorated_pot", (settings) -> new DecoratedPotBlock(settings) {@Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new ColoredDecoratedPotBlockEntity(pos, state, "purple");}}, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_PURPLE).strength(0.0F, 0.0F).pistonBehavior(PistonBehavior.DESTROY).nonOpaque(), true);
    public static final DecoratedPotBlock MAGENTA_DECORATED_POT = (DecoratedPotBlock) register("magenta_decorated_pot", (settings) -> new DecoratedPotBlock(settings) {@Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new ColoredDecoratedPotBlockEntity(pos, state, "magenta");}}, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_MAGENTA).strength(0.0F, 0.0F).pistonBehavior(PistonBehavior.DESTROY).nonOpaque(), true);
    public static final DecoratedPotBlock PINK_DECORATED_POT = (DecoratedPotBlock) register("pink_decorated_pot", (settings) -> new DecoratedPotBlock(settings) {@Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new ColoredDecoratedPotBlockEntity(pos, state, "pink");}}, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_PINK).strength(0.0F, 0.0F).pistonBehavior(PistonBehavior.DESTROY).nonOpaque(), true);
    public static final DecoratedPotBlock BROWN_DECORATED_POT = (DecoratedPotBlock) register("brown_decorated_pot", (settings) -> new DecoratedPotBlock(settings) {@Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new ColoredDecoratedPotBlockEntity(pos, state, "brown");}}, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_BROWN).strength(0.0F, 0.0F).pistonBehavior(PistonBehavior.DESTROY).nonOpaque(), true);
    public static final DecoratedPotBlock WHITE_DECORATED_POT = (DecoratedPotBlock) register("white_decorated_pot", (settings) -> new DecoratedPotBlock(settings) {@Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new ColoredDecoratedPotBlockEntity(pos, state, "white");}}, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_WHITE).strength(0.0F, 0.0F).pistonBehavior(PistonBehavior.DESTROY).nonOpaque(), true);
    public static final DecoratedPotBlock LIGHT_GRAY_DECORATED_POT = (DecoratedPotBlock) register("light_gray_decorated_pot", (settings) -> new DecoratedPotBlock(settings) {@Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new ColoredDecoratedPotBlockEntity(pos, state, "light_gray");}}, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).strength(0.0F, 0.0F).pistonBehavior(PistonBehavior.DESTROY).nonOpaque(), true);
    public static final DecoratedPotBlock GRAY_DECORATED_POT = (DecoratedPotBlock) register("gray_decorated_pot", (settings) -> new DecoratedPotBlock(settings) {@Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new ColoredDecoratedPotBlockEntity(pos, state, "gray");}}, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_GRAY).strength(0.0F, 0.0F).pistonBehavior(PistonBehavior.DESTROY).nonOpaque(), true);
    public static final DecoratedPotBlock BLACK_DECORATED_POT = (DecoratedPotBlock) register("black_decorated_pot", (settings) -> new DecoratedPotBlock(settings) {@Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new ColoredDecoratedPotBlockEntity(pos, state, "black");}}, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_BLACK).strength(0.0F, 0.0F).pistonBehavior(PistonBehavior.DESTROY).nonOpaque(), true);
    /*?}*/
    private static final AbstractBlock.Settings woolSeatSettings = AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(0.2F).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY);
    public static final SittableBlock RED_CUSHION = (SittableBlock) register("red_cushion", (settings) -> new WoolCushionBlock(DyeColor.RED, settings), woolSeatSettings, true);
    public static final SittableBlock ORANGE_CUSHION = (SittableBlock) register("orange_cushion", (settings) -> new WoolCushionBlock(DyeColor.ORANGE, settings), woolSeatSettings, true);
    public static final SittableBlock YELLOW_CUSHION = (SittableBlock) register("yellow_cushion", (settings) -> new WoolCushionBlock(DyeColor.YELLOW, settings), woolSeatSettings, true);
    public static final SittableBlock LIME_CUSHION = (SittableBlock) register("lime_cushion", (settings) -> new WoolCushionBlock(DyeColor.LIME, settings), woolSeatSettings, true);
    public static final SittableBlock GREEN_CUSHION = (SittableBlock) register("green_cushion", (settings) -> new WoolCushionBlock(DyeColor.GREEN, settings), woolSeatSettings, true);
    public static final SittableBlock CYAN_CUSHION = (SittableBlock) register("cyan_cushion", (settings) -> new WoolCushionBlock(DyeColor.CYAN, settings), woolSeatSettings, true);
    public static final SittableBlock LIGHT_BLUE_CUSHION = (SittableBlock) register("light_blue_cushion", (settings) -> new WoolCushionBlock(DyeColor.LIGHT_BLUE, settings), woolSeatSettings, true);
    public static final SittableBlock BLUE_CUSHION = (SittableBlock) register("blue_cushion", (settings) -> new WoolCushionBlock(DyeColor.BLUE, settings), woolSeatSettings, true);
    public static final SittableBlock PURPLE_CUSHION = (SittableBlock) register("purple_cushion", (settings) -> new WoolCushionBlock(DyeColor.PURPLE, settings), woolSeatSettings, true);
    public static final SittableBlock MAGENTA_CUSHION = (SittableBlock) register("magenta_cushion", (settings) -> new WoolCushionBlock(DyeColor.MAGENTA, settings), woolSeatSettings, true);
    public static final SittableBlock PINK_CUSHION = (SittableBlock) register("pink_cushion", (settings) -> new WoolCushionBlock(DyeColor.PINK, settings), woolSeatSettings, true);
    public static final SittableBlock BROWN_CUSHION = (SittableBlock) register("brown_cushion", (settings) -> new WoolCushionBlock(DyeColor.BROWN, settings), woolSeatSettings, true);
    public static final SittableBlock WHITE_CUSHION = (SittableBlock) register("white_cushion", (settings) -> new WoolCushionBlock(DyeColor.WHITE, settings), woolSeatSettings, true);
    public static final SittableBlock LIGHT_GRAY_CUSHION = (SittableBlock) register("light_gray_cushion", (settings) -> new WoolCushionBlock(DyeColor.LIGHT_GRAY, settings), woolSeatSettings, true);
    public static final SittableBlock GRAY_CUSHION = (SittableBlock) register("gray_cushion", (settings) -> new WoolCushionBlock(DyeColor.GRAY, settings), woolSeatSettings, true);
    public static final SittableBlock BLACK_CUSHION = (SittableBlock) register("black_cushion", (settings) -> new WoolCushionBlock(DyeColor.BLACK, settings), woolSeatSettings, true);

    public static final SittableBlock RED_OTTOMAN = (SittableBlock) register("red_ottoman", (settings) -> new WoolSittableBlock(DyeColor.RED, settings), woolSeatSettings, true);
    public static final SittableBlock ORANGE_OTTOMAN = (SittableBlock) register("orange_ottoman", (settings) -> new WoolSittableBlock(DyeColor.ORANGE, settings), woolSeatSettings, true);
    public static final SittableBlock YELLOW_OTTOMAN = (SittableBlock) register("yellow_ottoman", (settings) -> new WoolSittableBlock(DyeColor.YELLOW, settings), woolSeatSettings, true);
    public static final SittableBlock LIME_OTTOMAN = (SittableBlock) register("lime_ottoman", (settings) -> new WoolSittableBlock(DyeColor.LIME, settings), woolSeatSettings, true);
    public static final SittableBlock GREEN_OTTOMAN = (SittableBlock) register("green_ottoman", (settings) -> new WoolSittableBlock(DyeColor.GREEN, settings), woolSeatSettings, true);
    public static final SittableBlock CYAN_OTTOMAN = (SittableBlock) register("cyan_ottoman", (settings) -> new WoolSittableBlock(DyeColor.CYAN, settings), woolSeatSettings, true);
    public static final SittableBlock LIGHT_BLUE_OTTOMAN = (SittableBlock) register("light_blue_ottoman", (settings) -> new WoolSittableBlock(DyeColor.LIGHT_BLUE, settings), woolSeatSettings, true);
    public static final SittableBlock BLUE_OTTOMAN = (SittableBlock) register("blue_ottoman", (settings) -> new WoolSittableBlock(DyeColor.BLUE, settings), woolSeatSettings, true);
    public static final SittableBlock PURPLE_OTTOMAN = (SittableBlock) register("purple_ottoman", (settings) -> new WoolSittableBlock(DyeColor.PURPLE, settings), woolSeatSettings, true);
    public static final SittableBlock MAGENTA_OTTOMAN = (SittableBlock) register("magenta_ottoman", (settings) -> new WoolSittableBlock(DyeColor.MAGENTA, settings), woolSeatSettings, true);
    public static final SittableBlock PINK_OTTOMAN = (SittableBlock) register("pink_ottoman", (settings) -> new WoolSittableBlock(DyeColor.PINK, settings), woolSeatSettings, true);
    public static final SittableBlock BROWN_OTTOMAN = (SittableBlock) register("brown_ottoman", (settings) -> new WoolSittableBlock(DyeColor.BROWN, settings), woolSeatSettings, true);
    public static final SittableBlock WHITE_OTTOMAN = (SittableBlock) register("white_ottoman", (settings) -> new WoolSittableBlock(DyeColor.WHITE, settings), woolSeatSettings, true);
    public static final SittableBlock LIGHT_GRAY_OTTOMAN = (SittableBlock) register("light_gray_ottoman", (settings) -> new WoolSittableBlock(DyeColor.LIGHT_GRAY, settings), woolSeatSettings, true);
    public static final SittableBlock GRAY_OTTOMAN = (SittableBlock) register("gray_ottoman", (settings) -> new WoolSittableBlock(DyeColor.GRAY, settings), woolSeatSettings, true);
    public static final SittableBlock BLACK_OTTOMAN = (SittableBlock) register("black_ottoman", (settings) -> new WoolSittableBlock(DyeColor.BLACK, settings), woolSeatSettings, true);

    public static final SittableBlock RED_SEAT = (SittableBlock) register("red_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.RED, settings), woolSeatSettings, true);
    public static final SittableBlock ORANGE_SEAT = (SittableBlock) register("orange_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.ORANGE, settings), woolSeatSettings, true);
    public static final SittableBlock YELLOW_SEAT = (SittableBlock) register("yellow_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.YELLOW, settings), woolSeatSettings, true);
    public static final SittableBlock LIME_SEAT = (SittableBlock) register("lime_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.LIME, settings), woolSeatSettings, true);
    public static final SittableBlock GREEN_SEAT = (SittableBlock) register("green_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.GREEN, settings), woolSeatSettings, true);
    public static final SittableBlock CYAN_SEAT = (SittableBlock) register("cyan_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.CYAN, settings), woolSeatSettings, true);
    public static final SittableBlock LIGHT_BLUE_SEAT = (SittableBlock) register("light_blue_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.LIGHT_BLUE, settings), woolSeatSettings, true);
    public static final SittableBlock BLUE_SEAT = (SittableBlock) register("blue_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.BLUE, settings), woolSeatSettings, true);
    public static final SittableBlock PURPLE_SEAT = (SittableBlock) register("purple_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.PURPLE, settings), woolSeatSettings, true);
    public static final SittableBlock MAGENTA_SEAT = (SittableBlock) register("magenta_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.MAGENTA, settings), woolSeatSettings, true);
    public static final SittableBlock PINK_SEAT = (SittableBlock) register("pink_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.PINK, settings), woolSeatSettings, true);
    public static final SittableBlock BROWN_SEAT = (SittableBlock) register("brown_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.BROWN, settings), woolSeatSettings, true);
    public static final SittableBlock WHITE_SEAT = (SittableBlock) register("white_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.WHITE, settings), woolSeatSettings, true);
    public static final SittableBlock LIGHT_GRAY_SEAT = (SittableBlock) register("light_gray_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.LIGHT_GRAY, settings), woolSeatSettings, true);
    public static final SittableBlock GRAY_SEAT = (SittableBlock) register("gray_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.GRAY, settings), woolSeatSettings, true);
    public static final SittableBlock BLACK_SEAT = (SittableBlock) register("black_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.BLACK, settings), woolSeatSettings, true);

    public static final SittableBlock RED_STOOL = (SittableBlock) register("red_stool", (settings) -> new WoolStoolBlock(DyeColor.RED, settings), woolSeatSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock ORANGE_STOOL = (SittableBlock) register("orange_stool", (settings) -> new WoolStoolBlock(DyeColor.ORANGE, settings), woolSeatSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock YELLOW_STOOL = (SittableBlock) register("yellow_stool", (settings) -> new WoolStoolBlock(DyeColor.YELLOW, settings), woolSeatSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock LIME_STOOL = (SittableBlock) register("lime_stool", (settings) -> new WoolStoolBlock(DyeColor.LIME, settings), woolSeatSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock GREEN_STOOL = (SittableBlock) register("green_stool", (settings) -> new WoolStoolBlock(DyeColor.GREEN, settings), woolSeatSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock CYAN_STOOL = (SittableBlock) register("cyan_stool", (settings) -> new WoolStoolBlock(DyeColor.CYAN, settings), woolSeatSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock LIGHT_BLUE_STOOL = (SittableBlock) register("light_blue_stool", (settings) -> new WoolStoolBlock(DyeColor.LIGHT_BLUE, settings), woolSeatSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock BLUE_STOOL = (SittableBlock) register("blue_stool", (settings) -> new WoolStoolBlock(DyeColor.BLUE, settings), woolSeatSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock PURPLE_STOOL = (SittableBlock) register("purple_stool", (settings) -> new WoolStoolBlock(DyeColor.PURPLE, settings), woolSeatSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock MAGENTA_STOOL = (SittableBlock) register("magenta_stool", (settings) -> new WoolStoolBlock(DyeColor.MAGENTA, settings), woolSeatSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock PINK_STOOL = (SittableBlock) register("pink_stool", (settings) -> new WoolStoolBlock(DyeColor.PINK, settings), woolSeatSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock BROWN_STOOL = (SittableBlock) register("brown_stool", (settings) -> new WoolStoolBlock(DyeColor.BROWN, settings), woolSeatSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock WHITE_STOOL = (SittableBlock) register("white_stool", (settings) -> new WoolStoolBlock(DyeColor.WHITE, settings), woolSeatSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock LIGHT_GRAY_STOOL = (SittableBlock) register("light_gray_stool", (settings) -> new WoolStoolBlock(DyeColor.LIGHT_GRAY, settings), woolSeatSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock GRAY_STOOL = (SittableBlock) register("gray_stool", (settings) -> new WoolStoolBlock(DyeColor.GRAY, settings), woolSeatSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock BLACK_STOOL = (SittableBlock) register("black_stool", (settings) -> new WoolStoolBlock(DyeColor.BLACK, settings), woolSeatSettings.pistonBehavior(PistonBehavior.DESTROY), true);

    public static final DirectionalCarpetBlock RED_DECORATIVE_CARPET = (DirectionalCarpetBlock) register("red_decorative_carpet", DirectionalCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.RED_CARPET), true);
    public static final DirectionalCarpetBlock ORANGE_DECORATIVE_CARPET = (DirectionalCarpetBlock) register("orange_decorative_carpet", DirectionalCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.ORANGE_CARPET), true);
    public static final DirectionalCarpetBlock YELLOW_DECORATIVE_CARPET = (DirectionalCarpetBlock) register("yellow_decorative_carpet", DirectionalCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.YELLOW_CARPET), true);
    public static final DirectionalCarpetBlock LIME_DECORATIVE_CARPET = (DirectionalCarpetBlock) register("lime_decorative_carpet", DirectionalCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.LIME_CARPET), true);
    public static final DirectionalCarpetBlock GREEN_DECORATIVE_CARPET = (DirectionalCarpetBlock) register("green_decorative_carpet", DirectionalCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.GREEN_CARPET), true);
    public static final DirectionalCarpetBlock CYAN_DECORATIVE_CARPET = (DirectionalCarpetBlock) register("cyan_decorative_carpet", DirectionalCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.CYAN_CARPET), true);
    public static final DirectionalCarpetBlock LIGHT_BLUE_DECORATIVE_CARPET = (DirectionalCarpetBlock) register("light_blue_decorative_carpet", DirectionalCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CARPET), true);
    public static final DirectionalCarpetBlock BLUE_DECORATIVE_CARPET = (DirectionalCarpetBlock) register("blue_decorative_carpet", DirectionalCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.BLUE_CARPET), true);
    public static final DirectionalCarpetBlock PURPLE_DECORATIVE_CARPET = (DirectionalCarpetBlock) register("purple_decorative_carpet", DirectionalCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.PURPLE_CARPET), true);
    public static final DirectionalCarpetBlock MAGENTA_DECORATIVE_CARPET = (DirectionalCarpetBlock) register("magenta_decorative_carpet", DirectionalCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.MAGENTA_CARPET), true);
    public static final DirectionalCarpetBlock PINK_DECORATIVE_CARPET = (DirectionalCarpetBlock) register("pink_decorative_carpet", DirectionalCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.PINK_CARPET), true);
    public static final DirectionalCarpetBlock BROWN_DECORATIVE_CARPET = (DirectionalCarpetBlock) register("brown_decorative_carpet", DirectionalCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.BROWN_CARPET), true);
    public static final DirectionalCarpetBlock WHITE_DECORATIVE_CARPET = (DirectionalCarpetBlock) register("white_decorative_carpet", DirectionalCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.WHITE_CARPET), true);
    public static final DirectionalCarpetBlock LIGHT_GRAY_DECORATIVE_CARPET = (DirectionalCarpetBlock) register("light_gray_decorative_carpet", DirectionalCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_CARPET), true);
    public static final DirectionalCarpetBlock GRAY_DECORATIVE_CARPET = (DirectionalCarpetBlock) register("gray_decorative_carpet", DirectionalCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.GRAY_CARPET), true);
    public static final DirectionalCarpetBlock BLACK_DECORATIVE_CARPET = (DirectionalCarpetBlock) register("black_decorative_carpet", DirectionalCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.BLACK_CARPET), true);

    public static AbstractBlock.Settings createButtonSettings() {
        /*? if >1.20.1 {*/
        return Blocks.createButtonSettings();
        /*?} else {*/
        /*return AbstractBlock.Settings.create().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY);
        *//*?}*/
    }
    
    public static final LightButtonBlock GLOWSTONE_BUTTON = (LightButtonBlock) register("glowstone_button", (settings) -> new LightButtonBlock(10, 15, settings), createButtonSettings(), true);
    public static final LightButtonBlock PEARLESCENT_FROGLIGHT_BUTTON = (LightButtonBlock) register("pearlescent_froglight_button", (settings) -> new LightButtonBlock( 10, 15, settings), createButtonSettings(), true);
    public static final LightButtonBlock VERDANT_FROGLIGHT_BUTTON = (LightButtonBlock) register("verdant_froglight_button", (settings) -> new LightButtonBlock( 10, 15, settings), createButtonSettings(), true);
    public static final LightButtonBlock OCHRE_FROGLIGHT_BUTTON = (LightButtonBlock) register("ochre_froglight_button", (settings) -> new LightButtonBlock( 10, 15, settings), createButtonSettings(), true);
    public static final LightButtonBlock REDSTONE_LAMP_BUTTON = (LightButtonBlock) register("redstone_lamp_button", (settings) -> new LightButtonBlock( 10, 15, settings), createButtonSettings(), true);
    public static final LightButtonBlock SEA_LANTERN_BUTTON = (LightButtonBlock) register("sea_lantern_button", (settings) -> new LightButtonBlock( 10, 15, settings), createButtonSettings(), true);
    public static final LightButtonBlock SHROOMLIGHT_BUTTON = (LightButtonBlock) register("shroomlight_button", (settings) -> new LightButtonBlock( 10, 15, settings), createButtonSettings(), true);
    public static final LightButtonBlock OBSIDIAN_BUTTON = (LightButtonBlock) register("obsidian_button", (settings) -> new LightButtonBlock( 10, 10, settings), createButtonSettings(), true);
    /*? if >1.20.1 {*/
    public static final OxidizableLightButtonBlock COPPER_BUTTON = (OxidizableLightButtonBlock) register("copper_button", (settings) -> new OxidizableLightButtonBlock( Oxidizable.OxidationLevel.UNAFFECTED, 10, 15, settings), createButtonSettings(), true);
    public static final OxidizableLightButtonBlock EXPOSED_COPPER_BUTTON = (OxidizableLightButtonBlock) register("exposed_copper_button", (settings) -> new OxidizableLightButtonBlock( Oxidizable.OxidationLevel.EXPOSED, 20, 12, settings), createButtonSettings(), true);
    public static final OxidizableLightButtonBlock WEATHERED_COPPER_BUTTON = (OxidizableLightButtonBlock) register("weathered_copper_button", (settings) -> new OxidizableLightButtonBlock( Oxidizable.OxidationLevel.WEATHERED, 30, 19, settings), createButtonSettings(), true);
    public static final OxidizableLightButtonBlock OXIDIZED_COPPER_BUTTON = (OxidizableLightButtonBlock) register("oxidized_copper_button", (settings) -> new OxidizableLightButtonBlock( Oxidizable.OxidationLevel.OXIDIZED, 40, 6, settings), createButtonSettings(), true);
    public static final LightButtonBlock WAXED_COPPER_BUTTON = (LightButtonBlock) register("waxed_copper_button", (settings) -> new LightButtonBlock( 10, 15, settings), createButtonSettings(), true);
    public static final LightButtonBlock WAXED_EXPOSED_COPPER_BUTTON = (LightButtonBlock) register("waxed_exposed_copper_button", (settings) -> new LightButtonBlock( 20, 12, settings), createButtonSettings(), true);
    public static final LightButtonBlock WAXED_WEATHERED_COPPER_BUTTON = (LightButtonBlock) register("waxed_weathered_copper_button", (settings) -> new LightButtonBlock( 30, 19, settings), createButtonSettings(), true);
    public static final LightButtonBlock WAXED_OXIDIZED_COPPER_BUTTON = (LightButtonBlock) register("waxed_oxidized_copper_button", (settings) -> new LightButtonBlock( 40, 6, settings), createButtonSettings(), true);
    /*?}*/

    public static final Block WAXED_PAPER_BLOCK = register("waxed_paper_block", Block::new, AbstractBlock.Settings.create().mapColor(MapColor.WHITE).instrument(/*? if >1.20.1 {*/NoteBlockInstrument.BASS/*?} else {*//*Instrument.BASS*//*?}*/).strength(1.0F, 1.0F).sounds(BlockSoundGroup.BAMBOO_WOOD), true);
    public static final Block PAPER_BLOCK = register("paper_block", Block::new, AbstractBlock.Settings.copy(WAXED_PAPER_BLOCK).burnable(), true);

    public static final PaperPaneBlock HORIZONTAL_PAPER_PANEL = (PaperPaneBlock) register("horizontal_paper_panel", (settings) -> new PaperPaneBlock(settings, false) {
        public BlockState getPlacementState(ItemPlacementContext ctx) {
            if (Block.isFaceFullSquare(ctx.getWorld().getBlockState(ctx.getBlockPos().down()).getSidesShape(ctx.getWorld(), ctx.getBlockPos().down()), Direction.UP)) {
                return HORIZONTAL_PAPER_PANEL_BOTTOM.getPlacementState(ctx);
            }
            return super.getPlacementState(ctx);
        }
    }, AbstractBlock.Settings.copy(PAPER_BLOCK), true);
    public static final PaperPaneBlock WAXED_HORIZONTAL_PAPER_PANEL = (PaperPaneBlock) register("waxed_horizontal_paper_panel", (settings) -> new PaperPaneBlock(settings, true) {
        public BlockState getPlacementState(ItemPlacementContext ctx) {
            if (Block.isFaceFullSquare(ctx.getWorld().getBlockState(ctx.getBlockPos().down()).getSidesShape(ctx.getWorld(), ctx.getBlockPos().down()), Direction.UP)) {
                return WAXED_HORIZONTAL_PAPER_PANEL_BOTTOM.getPlacementState(ctx);
            }
            return super.getPlacementState(ctx);
        }
    }, AbstractBlock.Settings.copy(WAXED_PAPER_BLOCK), true);
    public static final PaperPaneBlock HORIZONTAL_PAPER_PANEL_BOTTOM = (PaperPaneBlock) register("horizontal_paper_panel_bottom", (settings) -> new PaperPaneBlock(settings, false)  {public Item asItem() {return HORIZONTAL_PAPER_PANEL.asItem();}}, AbstractBlock.Settings.copy(PAPER_BLOCK), false);
    public static final PaperPaneBlock WAXED_HORIZONTAL_PAPER_PANEL_BOTTOM = (PaperPaneBlock) register("waxed_horizontal_paper_panel_bottom", (settings) -> new PaperPaneBlock(settings, true) {public Item asItem() {return WAXED_HORIZONTAL_PAPER_PANEL.asItem();}}, AbstractBlock.Settings.copy(WAXED_PAPER_BLOCK), false);
    public static final PaperPaneBlock PAPER_PANEL = (PaperPaneBlock) register("paper_panel", (settings) -> new PaperPaneBlock(settings, false) {
        public BlockState getPlacementState(ItemPlacementContext ctx) {
            if (!ctx.getWorld().getBlockState(ctx.getBlockPos().down()).isOf(PAPER_PANEL_BOTTOM) && !ctx.getWorld().getBlockState(ctx.getBlockPos().down()).isOf(WAXED_PAPER_PANEL_BOTTOM)) {
                return PAPER_PANEL_BOTTOM.getPlacementState(ctx);
            }
            return super.getPlacementState(ctx);
        }
    }, AbstractBlock.Settings.copy(PAPER_BLOCK), true);
    public static final PaperPaneBlock WAXED_PAPER_PANEL = (PaperPaneBlock) register("waxed_paper_panel", (settings) -> new PaperPaneBlock(settings, true) {
        public BlockState getPlacementState(ItemPlacementContext ctx) {
            if (!ctx.getWorld().getBlockState(ctx.getBlockPos().down()).isOf(PAPER_PANEL_BOTTOM) && !ctx.getWorld().getBlockState(ctx.getBlockPos().down()).isOf(WAXED_PAPER_PANEL_BOTTOM)) {
                return PAPER_PANEL_BOTTOM.getPlacementState(ctx);
            }
            return super.getPlacementState(ctx);
        }
    }, AbstractBlock.Settings.copy(WAXED_PAPER_BLOCK), true);
    public static final PaperPaneBlock PAPER_PANEL_BOTTOM = (PaperPaneBlock) register("paper_panel_bottom", (settings) -> new PaperPaneBlock(settings, false)  {public Item asItem() {return PAPER_PANEL.asItem();}}, AbstractBlock.Settings.copy(PAPER_BLOCK), false);
    public static final PaperPaneBlock WAXED_PAPER_PANEL_BOTTOM = (PaperPaneBlock) register("waxed_paper_panel_bottom", (settings) -> new PaperPaneBlock(settings, true)  {public Item asItem() {return WAXED_PAPER_PANEL.asItem();}}, AbstractBlock.Settings.copy(WAXED_PAPER_BLOCK), false);
    public static final PaneDoorBlock HORIZONTAL_PAPER_PANEL_DOOR = (PaneDoorBlock) register("horizontal_paper_panel_door", (settings) -> new PaneDoorBlock(BlockSetType.BAMBOO, settings), AbstractBlock.Settings.copy(PAPER_BLOCK), true);
    public static final PaneDoorBlock PAPER_PANEL_DOOR = (PaneDoorBlock) register("paper_panel_door", (settings) -> new PaneDoorBlock(BlockSetType.BAMBOO, settings), AbstractBlock.Settings.copy(PAPER_BLOCK), true);

    public static final Map<Block, Block> CarpetsToStairs = new HashMap<>();
    private static final Object2ObjectMap<Item, Block> ItemPlacements = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectMap<Block, Block> CardboardMap = new Object2ObjectOpenHashMap<>();

    private static final AbstractBlock.Settings cardboardSettings = AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(/*? if >1.20.1 {*/NoteBlockInstrument.BASS/*?} else {*//*Instrument.BASS*//*?}*/).strength(0.2F, 0.5F).sounds(BlockSoundGroup.BAMBOO);
    public static final CollapsedCardboardBlock COLLAPSED_CARDBOARD = (CollapsedCardboardBlock) register("collapsed_cardboard", settings -> new CollapsedCardboardBlock(settings, true), cardboardSettings.burnable(), true);
    public static final CollapsedCardboardBlock WET_COLLAPSED_CARDBOARD = (CollapsedCardboardBlock) register("wet_collapsed_cardboard", settings -> new CollapsedCardboardBlock(settings, false), cardboardSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final CardboardPillarBlock CARDBOARD_BLOCK = (CardboardPillarBlock) register("cardboard_block", (settings -> new CardboardPillarBlock(settings, true)), cardboardSettings.burnable(), true);
    public static final PillarBlock WAXED_CARDBOARD_BLOCK = (PillarBlock) register("waxed_cardboard_block", PillarBlock::new, cardboardSettings, true);
    public static final CardboardPillarBlock WET_CARDBOARD_BLOCK = (CardboardPillarBlock) register("wet_cardboard_block", (settings -> new CardboardPillarBlock(settings, false)), cardboardSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final CardboardBlock CARDBOARD_BOX = (CardboardBlock) register("cardboard_box", (settings -> new CardboardBlock(settings, true)), cardboardSettings.burnable(), true);
    public static final Block WAXED_CARDBOARD_BOX = register("waxed_cardboard_box", Block::new, cardboardSettings, true);
    public static final CardboardBlock WET_CARDBOARD_BOX = (CardboardBlock) register("wet_cardboard_box", (settings -> new CardboardBlock(settings, false)), cardboardSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final CardboardDoorBlock CARDBOARD_DOOR = (CardboardDoorBlock) register("cardboard_door", settings -> new CardboardDoorBlock(settings, true), cardboardSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final DoorBlock WAXED_CARDBOARD_DOOR = (DoorBlock) register("waxed_cardboard_door", settings -> new DoorBlock(/*? if >1.20.1 {*/BlockSetType.OAK, settings/*?} else {*//*settings, BlockSetType.OAK*//*?}*/), AbstractBlock.Settings.copy(CARDBOARD_DOOR), true);
    public static final CardboardDoorBlock WET_CARDBOARD_DOOR = (CardboardDoorBlock) register("wet_cardboard_door", settings -> new CardboardDoorBlock(settings, false), AbstractBlock.Settings.copy(CARDBOARD_DOOR), true);
    public static final CardboardPaneBlock CARDBOARD_PANE = (CardboardPaneBlock) register("cardboard_pane", settings -> new CardboardPaneBlock(settings, true), cardboardSettings.burnable(), true);
    public static final PaneBlock WAXED_CARDBOARD_PANE = (PaneBlock) register("waxed_cardboard_pane", PaneBlock::new, cardboardSettings, true);
    public static final CardboardPaneBlock WET_CARDBOARD_PANE = (CardboardPaneBlock) register("wet_cardboard_pane", settings -> new CardboardPaneBlock(settings, false), cardboardSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final CardboardGateBlock CARDBOARD_GATE = (CardboardGateBlock) register("cardboard_gate", settings -> new CardboardGateBlock(settings, true), cardboardSettings.burnable(), true);
    public static final GateBlock WAXED_CARDBOARD_GATE = (GateBlock) register("waxed_cardboard_gate", GateBlock::new, cardboardSettings, true);
    public static final CardboardGateBlock WET_CARDBOARD_GATE = (CardboardGateBlock) register("wet_cardboard_gate", settings -> new CardboardGateBlock(settings, false), cardboardSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final CardboardTrapdoorBlock CARDBOARD_TRAPDOOR = (CardboardTrapdoorBlock) register("cardboard_trapdoor", settings -> new CardboardTrapdoorBlock(settings, true), cardboardSettings.burnable(), true);
    public static final TrapdoorBlock WAXED_CARDBOARD_TRAPDOOR = (TrapdoorBlock) register("waxed_cardboard_trapdoor", settings -> new TrapdoorBlock(/*? if >1.20.1 {*/BlockSetType.OAK, settings/*?} else {*//*settings, BlockSetType.OAK*//*?}*/), cardboardSettings, true);
    public static final CardboardTrapdoorBlock WET_CARDBOARD_TRAPDOOR = (CardboardTrapdoorBlock) register("wet_cardboard_trapdoor", settings -> new CardboardTrapdoorBlock(settings, false), cardboardSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final CardboardSlabBlock CARDBOARD_SLAB = (CardboardSlabBlock) register("cardboard_slab", (settings -> new CardboardSlabBlock(settings, true)), cardboardSettings.burnable(), true);
    public static final SlabBlock WAXED_CARDBOARD_SLAB = (SlabBlock) register("waxed_cardboard_slab", SlabBlock::new, cardboardSettings, true);
    public static final CardboardSlabBlock WET_CARDBOARD_SLAB = (CardboardSlabBlock) register("wet_cardboard_slab", (settings -> new CardboardSlabBlock(settings, false)), cardboardSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final CardboardStairsBlock CARDBOARD_STAIRS = (CardboardStairsBlock) register("cardboard_stairs", (settings -> new CardboardStairsBlock(settings, true)), cardboardSettings.burnable(), true);
    public static final StairsBlock WAXED_CARDBOARD_STAIRS = (StairsBlock) register("waxed_cardboard_stairs", settings -> new StairsBlock(WAXED_CARDBOARD_BOX.getDefaultState(), settings), cardboardSettings, true);
    public static final CardboardStairsBlock WET_CARDBOARD_STAIRS = (CardboardStairsBlock) register("wet_cardboard_stairs", (settings -> new CardboardStairsBlock(settings, false)), cardboardSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final CardboardSlabBlock CARDBOARD_BOX_SLAB = (CardboardSlabBlock) register("cardboard_box_slab", (settings -> new CardboardSlabBlock(settings, true)), cardboardSettings.burnable(), true);
    public static final SlabBlock WAXED_CARDBOARD_BOX_SLAB = (SlabBlock) register("waxed_cardboard_box_slab", SlabBlock::new, cardboardSettings, true);
    public static final CardboardSlabBlock WET_CARDBOARD_BOX_SLAB = (CardboardSlabBlock) register("wet_cardboard_box_slab", (settings -> new CardboardSlabBlock(settings, false)), cardboardSettings.pistonBehavior(PistonBehavior.DESTROY), true);
    public static final CardboardStairsBlock CARDBOARD_BOX_STAIRS = (CardboardStairsBlock) register("cardboard_box_stairs", (settings -> new CardboardStairsBlock(settings, true)), cardboardSettings.burnable(), true);
    public static final StairsBlock WAXED_CARDBOARD_BOX_STAIRS = (StairsBlock) register("waxed_cardboard_box_stairs", settings -> new StairsBlock(WAXED_CARDBOARD_BOX.getDefaultState(), settings), cardboardSettings, true);
    public static final CardboardStairsBlock WET_CARDBOARD_BOX_STAIRS = (CardboardStairsBlock) register("wet_cardboard_box_stairs", (settings -> new CardboardStairsBlock(settings, false)), cardboardSettings.pistonBehavior(PistonBehavior.DESTROY), true);

    private static final AbstractBlock.Settings wireSettings = AbstractBlock.Settings.create().noCollision().breakInstantly().pistonBehavior(PistonBehavior.DESTROY);
    public static final WireBlock RED_DYE_GLOWING = (WireBlock) register("glowing_red_dye_block", WireBlock::new, wireSettings, false);
    public static final WireBlock ORANGE_DYE_GLOWING = (WireBlock) register("glowing_orange_dye_block", WireBlock::new, wireSettings, false);
    public static final WireBlock YELLOW_DYE_GLOWING = (WireBlock) register("glowing_yellow_dye_block", WireBlock::new, wireSettings, false);
    public static final WireBlock LIME_DYE_GLOWING = (WireBlock) register("glowing_lime_dye_block", WireBlock::new, wireSettings, false);
    public static final WireBlock GREEN_DYE_GLOWING = (WireBlock) register("glowing_green_dye_block", WireBlock::new, wireSettings, false);
    public static final WireBlock CYAN_DYE_GLOWING = (WireBlock) register("glowing_cyan_dye_block", WireBlock::new, wireSettings, false);
    public static final WireBlock LIGHT_BLUE_DYE_GLOWING = (WireBlock) register("glowing_light_blue_dye_block", WireBlock::new, wireSettings, false);
    public static final WireBlock BLUE_DYE_GLOWING = (WireBlock) register("glowing_blue_dye_block", WireBlock::new, wireSettings, false);
    public static final WireBlock PURPLE_DYE_GLOWING = (WireBlock) register("glowing_purple_dye_block", WireBlock::new, wireSettings, false);
    public static final WireBlock MAGENTA_DYE_GLOWING = (WireBlock) register("glowing_magenta_dye_block", WireBlock::new, wireSettings, false);
    public static final WireBlock PINK_DYE_GLOWING = (WireBlock) register("glowing_pink_dye_block", WireBlock::new, wireSettings, false);
    public static final WireBlock BROWN_DYE_GLOWING = (WireBlock) register("glowing_brown_dye_block", WireBlock::new, wireSettings, false);
    public static final WireBlock WHITE_DYE_GLOWING = (WireBlock) register("glowing_white_dye_block", WireBlock::new, wireSettings, false);
    public static final WireBlock LIGHT_GRAY_DYE_GLOWING = (WireBlock) register("glowing_light_gray_dye_block", WireBlock::new, wireSettings, false);
    public static final WireBlock GRAY_DYE_GLOWING = (WireBlock) register("glowing_gray_dye_block", WireBlock::new, wireSettings, false);
    public static final WireBlock BLACK_DYE_GLOWING = (WireBlock) register("glowing_black_dye_block", WireBlock::new, wireSettings, false);
    public static final DyeBlock RED_DYE = (DyeBlock) register("red_dye_block", (settings) -> new DyeBlock(settings, RED_DYE_GLOWING), wireSettings, false);
    public static final DyeBlock ORANGE_DYE = (DyeBlock) register("orange_dye_block", (settings) -> new DyeBlock(settings, ORANGE_DYE_GLOWING), wireSettings, false);
    public static final DyeBlock YELLOW_DYE = (DyeBlock) register("yellow_dye_block", (settings) -> new DyeBlock(settings, YELLOW_DYE_GLOWING), wireSettings, false);
    public static final DyeBlock LIME_DYE = (DyeBlock) register("lime_dye_block", (settings) -> new DyeBlock(settings, LIME_DYE_GLOWING), wireSettings, false);
    public static final DyeBlock GREEN_DYE = (DyeBlock) register("green_dye_block", (settings) -> new DyeBlock(settings, GREEN_DYE_GLOWING), wireSettings, false);
    public static final DyeBlock CYAN_DYE = (DyeBlock) register("cyan_dye_block", (settings) -> new DyeBlock(settings, CYAN_DYE_GLOWING), wireSettings, false);
    public static final DyeBlock LIGHT_BLUE_DYE = (DyeBlock) register("light_blue_dye_block", (settings) -> new DyeBlock(settings, LIGHT_BLUE_DYE_GLOWING), wireSettings, false);
    public static final DyeBlock BLUE_DYE = (DyeBlock) register("blue_dye_block", (settings) -> new DyeBlock(settings, BLUE_DYE_GLOWING), wireSettings, false);
    public static final DyeBlock PURPLE_DYE = (DyeBlock) register("purple_dye_block", (settings) -> new DyeBlock(settings, PURPLE_DYE_GLOWING), wireSettings, false);
    public static final DyeBlock MAGENTA_DYE = (DyeBlock) register("magenta_dye_block", (settings) -> new DyeBlock(settings, MAGENTA_DYE_GLOWING), wireSettings, false);
    public static final DyeBlock PINK_DYE = (DyeBlock) register("pink_dye_block", (settings) -> new DyeBlock(settings, PINK_DYE_GLOWING), wireSettings, false);
    public static final DyeBlock BROWN_DYE = (DyeBlock) register("brown_dye_block", (settings) -> new DyeBlock(settings, BROWN_DYE_GLOWING), wireSettings, false);
    public static final DyeBlock WHITE_DYE = (DyeBlock) register("white_dye_block", (settings) -> new DyeBlock(settings, WHITE_DYE_GLOWING), wireSettings, false);
    public static final DyeBlock LIGHT_GRAY_DYE = (DyeBlock) register("light_gray_dye_block", (settings) -> new DyeBlock(settings, LIGHT_GRAY_DYE_GLOWING), wireSettings, false);
    public static final DyeBlock GRAY_DYE = (DyeBlock) register("gray_dye_block", (settings) -> new DyeBlock(settings, GRAY_DYE_GLOWING), wireSettings, false);
    public static final DyeBlock BLACK_DYE = (DyeBlock) register("black_dye_block", (settings) -> new DyeBlock(settings, BLACK_DYE_GLOWING), wireSettings, false);
    public static final WireBlock SAWDUST = (WireBlock) register("sawdust", WireBlock::new, wireSettings, true);
    public static final GlowstoneDustBlock GLOWSTONE_DUST = (GlowstoneDustBlock) register("glowstone_dust_block", GlowstoneDustBlock::new, AbstractBlock.Settings.create().noCollision().breakInstantly().pistonBehavior(PistonBehavior.DESTROY) /*? if >1.20.1 {*/.emissiveLighting(Blocks::always)/*?}*/.luminance((state) -> 3), false);
    public static final BlazePowderBlock BLAZE_POWDER = (BlazePowderBlock) register("blaze_powder_block", BlazePowderBlock::new, wireSettings, false);
    public static final SugarBlock SUGAR = (SugarBlock) register("sugar_block", SugarBlock::new, wireSettings, false);
    public static final GunpowderBlock GUNPOWDER = (GunpowderBlock) register("gunpowder_block", GunpowderBlock::new, AbstractBlock.Settings.create().noCollision().breakInstantly().pistonBehavior(PistonBehavior.DESTROY).burnable(), false);

    public static final BlockEntityType<SittableBlockEntity> SITTABLE_BLOCK_ENTITY = registerBlockEntity("sittable", FabricBlockEntityTypeBuilder.create(SittableBlockEntity::new,
            OAK_BENCH, OAK_SEAT, SPRUCE_BENCH, SPRUCE_SEAT, BIRCH_BENCH, BIRCH_SEAT, JUNGLE_BENCH, JUNGLE_SEAT, ACACIA_BENCH, ACACIA_SEAT, DARK_OAK_BENCH, DARK_OAK_SEAT, MANGROVE_BENCH, MANGROVE_SEAT, CHERRY_BENCH, CHERRY_SEAT, /*? if >1.20.1 {*/PALE_OAK_BENCH, PALE_OAK_SEAT,/*?}*/ CRIMSON_BENCH, CRIMSON_SEAT, WARPED_BENCH, WARPED_SEAT, BAMBOO_BENCH, BAMBOO_SEAT).build());
    public static final BlockEntityType<WoolSittableBlockEntity> WOOL_SITTABLE_BLOCK_ENTITY = registerBlockEntity("wool_sittable", FabricBlockEntityTypeBuilder.create(WoolSittableBlockEntity::new,
            RED_OTTOMAN, ORANGE_OTTOMAN, YELLOW_OTTOMAN, LIME_OTTOMAN, GREEN_OTTOMAN, CYAN_OTTOMAN, LIGHT_BLUE_OTTOMAN, BLUE_OTTOMAN, PURPLE_OTTOMAN, MAGENTA_OTTOMAN, PINK_OTTOMAN, BROWN_OTTOMAN, WHITE_OTTOMAN, LIGHT_GRAY_OTTOMAN, GRAY_OTTOMAN, BLACK_OTTOMAN,
            RED_SEAT, ORANGE_SEAT, YELLOW_SEAT, LIME_SEAT, GREEN_SEAT, CYAN_SEAT, LIGHT_BLUE_SEAT, BLUE_SEAT, PURPLE_SEAT, MAGENTA_SEAT, PINK_SEAT, BROWN_SEAT, WHITE_SEAT, LIGHT_GRAY_SEAT, GRAY_SEAT, BLACK_SEAT).build());
    public static final BlockEntityType<CushionBlockEntity> CUSHION_BLOCK_ENTITY = registerBlockEntity("cushion", FabricBlockEntityTypeBuilder.create(CushionBlockEntity::new,
            RED_CUSHION, ORANGE_CUSHION, YELLOW_CUSHION, LIME_CUSHION, GREEN_CUSHION, CYAN_CUSHION, LIGHT_BLUE_CUSHION, BLUE_CUSHION, PURPLE_CUSHION, MAGENTA_CUSHION, PINK_CUSHION, BROWN_CUSHION, WHITE_CUSHION, LIGHT_GRAY_CUSHION, GRAY_CUSHION, BLACK_CUSHION).build());
    public static final BlockEntityType<StoolBlockEntity> STOOL_BLOCK_ENTITY = registerBlockEntity("stool", FabricBlockEntityTypeBuilder.create(StoolBlockEntity::new,
            OAK_STOOL, SPRUCE_STOOL, BIRCH_STOOL, JUNGLE_STOOL, ACACIA_STOOL, DARK_OAK_STOOL, MANGROVE_STOOL, CHERRY_STOOL, /*? if >1.20.1 {*/PALE_OAK_STOOL,/*?}*/ CRIMSON_STOOL, WARPED_STOOL, BAMBOO_STOOL,
            RED_STOOL, ORANGE_STOOL, YELLOW_STOOL, LIME_STOOL, GREEN_STOOL, CYAN_STOOL, LIGHT_BLUE_STOOL, BLUE_STOOL, PURPLE_STOOL, MAGENTA_STOOL, PINK_STOOL, BROWN_STOOL, WHITE_STOOL, LIGHT_GRAY_STOOL, GRAY_STOOL, BLACK_STOOL).build());

    public static void initialize() {
        /*? if >1.20.1 {*/
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((itemGroup) -> {
                itemGroup.add(PAPER_BLOCK); itemGroup.add(WAXED_PAPER_BLOCK);
                itemGroup.add(PAPER_PANEL); itemGroup.add(WAXED_PAPER_PANEL);
                itemGroup.add(HORIZONTAL_PAPER_PANEL); itemGroup.add(WAXED_HORIZONTAL_PAPER_PANEL);
                itemGroup.add(PAPER_PANEL_DOOR); itemGroup.add(HORIZONTAL_PAPER_PANEL_DOOR);
                itemGroup.add(COLLAPSED_CARDBOARD); itemGroup.add(WET_COLLAPSED_CARDBOARD);
                itemGroup.add(CARDBOARD_BLOCK); itemGroup.add(WAXED_CARDBOARD_BLOCK); itemGroup.add(WET_CARDBOARD_BLOCK);
                itemGroup.add(CARDBOARD_STAIRS); itemGroup.add(WAXED_CARDBOARD_STAIRS); itemGroup.add(WET_CARDBOARD_STAIRS);
                itemGroup.add(CARDBOARD_SLAB); itemGroup.add(WAXED_CARDBOARD_SLAB); itemGroup.add(WET_CARDBOARD_SLAB);
                itemGroup.add(CARDBOARD_PANE); itemGroup.add(WAXED_CARDBOARD_PANE); itemGroup.add(WET_CARDBOARD_PANE);
                itemGroup.add(CARDBOARD_GATE); itemGroup.add(WAXED_CARDBOARD_GATE); itemGroup.add(WET_CARDBOARD_GATE);
                itemGroup.add(CARDBOARD_DOOR); itemGroup.add(WAXED_CARDBOARD_DOOR); itemGroup.add(WET_CARDBOARD_DOOR);
                itemGroup.add(CARDBOARD_TRAPDOOR); itemGroup.add(WAXED_CARDBOARD_TRAPDOOR); itemGroup.add(WET_CARDBOARD_TRAPDOOR);
                itemGroup.add(CARDBOARD_BOX); itemGroup.add(WAXED_CARDBOARD_BOX); itemGroup.add(WET_CARDBOARD_BOX);
                itemGroup.add(CARDBOARD_BOX_STAIRS); itemGroup.add(WAXED_CARDBOARD_BOX_STAIRS); itemGroup.add(WET_CARDBOARD_BOX_STAIRS);
                itemGroup.add(CARDBOARD_BOX_SLAB); itemGroup.add(WAXED_CARDBOARD_BOX_SLAB); itemGroup.add(WET_CARDBOARD_BOX_SLAB);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register((itemGroup) -> {
            itemGroup.addAfter(Items.PINK_BED,
                new ItemStack(WHITE_CUSHION), new ItemStack(LIGHT_GRAY_CUSHION), new ItemStack(GRAY_CUSHION), new ItemStack(BLACK_CUSHION), new ItemStack(BROWN_CUSHION), new ItemStack(RED_CUSHION), new ItemStack(ORANGE_CUSHION), new ItemStack(YELLOW_CUSHION), new ItemStack(LIME_CUSHION), new ItemStack(GREEN_CUSHION), new ItemStack(CYAN_CUSHION), new ItemStack(LIGHT_BLUE_CUSHION), new ItemStack(BLUE_CUSHION), new ItemStack(PURPLE_CUSHION), new ItemStack(MAGENTA_CUSHION), new ItemStack(PINK_CUSHION),
                new ItemStack(WHITE_OTTOMAN), new ItemStack(LIGHT_GRAY_OTTOMAN), new ItemStack(GRAY_OTTOMAN), new ItemStack(BLACK_OTTOMAN), new ItemStack(BROWN_OTTOMAN), new ItemStack(RED_OTTOMAN), new ItemStack(ORANGE_OTTOMAN), new ItemStack(YELLOW_OTTOMAN), new ItemStack(LIME_OTTOMAN), new ItemStack(GREEN_OTTOMAN), new ItemStack(CYAN_OTTOMAN), new ItemStack(LIGHT_BLUE_OTTOMAN), new ItemStack(BLUE_OTTOMAN), new ItemStack(PURPLE_OTTOMAN), new ItemStack(MAGENTA_OTTOMAN), new ItemStack(PINK_OTTOMAN),
                new ItemStack(WHITE_SEAT), new ItemStack(LIGHT_GRAY_SEAT), new ItemStack(GRAY_SEAT), new ItemStack(BLACK_SEAT), new ItemStack(BROWN_SEAT), new ItemStack(RED_SEAT), new ItemStack(ORANGE_SEAT), new ItemStack(YELLOW_SEAT), new ItemStack(LIME_SEAT), new ItemStack(GREEN_SEAT), new ItemStack(CYAN_SEAT), new ItemStack(LIGHT_BLUE_SEAT), new ItemStack(BLUE_SEAT), new ItemStack(PURPLE_SEAT), new ItemStack(MAGENTA_SEAT), new ItemStack(PINK_SEAT),
                new ItemStack(WHITE_STOOL), new ItemStack(LIGHT_GRAY_STOOL), new ItemStack(GRAY_STOOL), new ItemStack(BLACK_STOOL), new ItemStack(BROWN_STOOL), new ItemStack(RED_STOOL), new ItemStack(ORANGE_STOOL), new ItemStack(YELLOW_STOOL), new ItemStack(LIME_STOOL), new ItemStack(GREEN_STOOL), new ItemStack(CYAN_STOOL), new ItemStack(LIGHT_BLUE_STOOL), new ItemStack(BLUE_STOOL), new ItemStack(PURPLE_STOOL), new ItemStack(MAGENTA_STOOL), new ItemStack(PINK_STOOL),
                new ItemStack(Items.FLOWER_POT), new ItemStack(WHITE_FLOWER_POTS[0]), new ItemStack(LIGHT_GRAY_FLOWER_POTS[0]), new ItemStack(GRAY_FLOWER_POTS[0]), new ItemStack(BLACK_FLOWER_POTS[0]), new ItemStack(BROWN_FLOWER_POTS[0]), new ItemStack(RED_FLOWER_POTS[0]), new ItemStack(ORANGE_FLOWER_POTS[0]), new ItemStack(YELLOW_FLOWER_POTS[0]), new ItemStack(LIME_FLOWER_POTS[0]), new ItemStack(GREEN_FLOWER_POTS[0]), new ItemStack(CYAN_FLOWER_POTS[0]), new ItemStack(LIGHT_BLUE_FLOWER_POTS[0]), new ItemStack(BLUE_FLOWER_POTS[0]), new ItemStack(PURPLE_FLOWER_POTS[0]), new ItemStack(MAGENTA_FLOWER_POTS[0]), new ItemStack(PINK_FLOWER_POTS[0]),
                new ItemStack(LARGE_FLOWER_POTS[0]), new ItemStack(WHITE_LARGE_FLOWER_POTS[0]), new ItemStack(LIGHT_GRAY_LARGE_FLOWER_POTS[0]), new ItemStack(GRAY_LARGE_FLOWER_POTS[0]), new ItemStack(BLACK_LARGE_FLOWER_POTS[0]), new ItemStack(BROWN_LARGE_FLOWER_POTS[0]), new ItemStack(RED_LARGE_FLOWER_POTS[0]), new ItemStack(ORANGE_FLOWER_POTS[0]), new ItemStack(YELLOW_LARGE_FLOWER_POTS[0]), new ItemStack(LIME_LARGE_FLOWER_POTS[0]), new ItemStack(GREEN_LARGE_FLOWER_POTS[0]), new ItemStack(CYAN_LARGE_FLOWER_POTS[0]), new ItemStack(LIGHT_BLUE_LARGE_FLOWER_POTS[0]), new ItemStack(BLUE_LARGE_FLOWER_POTS[0]), new ItemStack(PURPLE_LARGE_FLOWER_POTS[0]), new ItemStack(MAGENTA_LARGE_FLOWER_POTS[0]), new ItemStack(PINK_LARGE_FLOWER_POTS[0]),
                new ItemStack(HANGING_FLOWER_POTS[0]), new ItemStack(WHITE_HANGING_FLOWER_POTS[0]), new ItemStack(LIGHT_GRAY_HANGING_FLOWER_POTS[0]), new ItemStack(GRAY_HANGING_FLOWER_POTS[0]), new ItemStack(BLACK_HANGING_FLOWER_POTS[0]), new ItemStack(BROWN_HANGING_FLOWER_POTS[0]), new ItemStack(RED_HANGING_FLOWER_POTS[0]), new ItemStack(ORANGE_HANGING_FLOWER_POTS[0]), new ItemStack(YELLOW_HANGING_FLOWER_POTS[0]), new ItemStack(LIME_HANGING_FLOWER_POTS[0]), new ItemStack(GREEN_HANGING_FLOWER_POTS[0]), new ItemStack(CYAN_HANGING_FLOWER_POTS[0]), new ItemStack(LIGHT_BLUE_HANGING_FLOWER_POTS[0]), new ItemStack(BLUE_HANGING_FLOWER_POTS[0]), new ItemStack(PURPLE_HANGING_FLOWER_POTS[0]), new ItemStack(MAGENTA_HANGING_FLOWER_POTS[0]), new ItemStack(PINK_HANGING_FLOWER_POTS[0]),
                new ItemStack(Items.DECORATED_POT), new ItemStack(WHITE_DECORATED_POT), new ItemStack(LIGHT_GRAY_DECORATED_POT), new ItemStack(GRAY_DECORATED_POT), new ItemStack(BLACK_DECORATED_POT), new ItemStack(BROWN_FLOWER_POTS[0]), new ItemStack(RED_DECORATED_POT), new ItemStack(ORANGE_DECORATED_POT), new ItemStack(YELLOW_DECORATED_POT), new ItemStack(LIME_DECORATED_POT), new ItemStack(GREEN_DECORATED_POT), new ItemStack(CYAN_DECORATED_POT), new ItemStack(LIGHT_BLUE_DECORATED_POT), new ItemStack(BLUE_DECORATED_POT), new ItemStack(PURPLE_DECORATED_POT), new ItemStack(MAGENTA_DECORATED_POT), new ItemStack(PINK_DECORATED_POT)
            );

            itemGroup.addAfter(Items.PINK_CARPET,
                    new ItemStack(WHITE_DECORATIVE_CARPET), new ItemStack(LIGHT_GRAY_DECORATIVE_CARPET), new ItemStack(GRAY_DECORATIVE_CARPET), new ItemStack(BLACK_DECORATIVE_CARPET), new ItemStack(BROWN_DECORATIVE_CARPET), new ItemStack(RED_DECORATIVE_CARPET), new ItemStack(ORANGE_DECORATIVE_CARPET), new ItemStack(YELLOW_DECORATIVE_CARPET), new ItemStack(LIME_DECORATIVE_CARPET), new ItemStack(GREEN_DECORATIVE_CARPET), new ItemStack(CYAN_DECORATIVE_CARPET), new ItemStack(LIGHT_BLUE_DECORATIVE_CARPET), new ItemStack(BLUE_DECORATIVE_CARPET), new ItemStack(PURPLE_DECORATIVE_CARPET), new ItemStack(MAGENTA_DECORATIVE_CARPET), new ItemStack(PINK_DECORATIVE_CARPET));
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> {
            itemGroup.addAfter(Items.MAGMA_BLOCK, new ItemStack(GLOWSTONE_BUTTON), new ItemStack(PEARLESCENT_FROGLIGHT_BUTTON), new ItemStack(VERDANT_FROGLIGHT_BUTTON), new ItemStack(OCHRE_FROGLIGHT_BUTTON), new ItemStack(REDSTONE_LAMP_BUTTON), new ItemStack(SEA_LANTERN_BUTTON), new ItemStack(SHROOMLIGHT_BUTTON), new ItemStack(OBSIDIAN_BUTTON)/*? if >1.20.1 {*/, new ItemStack(COPPER_BUTTON), new ItemStack(WEATHERED_COPPER_BUTTON), new ItemStack(EXPOSED_COPPER_BUTTON), new ItemStack(OXIDIZED_COPPER_BUTTON)/*?}*/);
            itemGroup.addAfter(Items.PINK_BED,
                new ItemStack(WHITE_CUSHION), new ItemStack(LIGHT_GRAY_CUSHION), new ItemStack(GRAY_CUSHION), new ItemStack(BLACK_CUSHION), new ItemStack(BROWN_CUSHION), new ItemStack(RED_CUSHION), new ItemStack(ORANGE_CUSHION), new ItemStack(YELLOW_CUSHION), new ItemStack(LIME_CUSHION), new ItemStack(GREEN_CUSHION), new ItemStack(CYAN_CUSHION), new ItemStack(LIGHT_BLUE_CUSHION), new ItemStack(BLUE_CUSHION), new ItemStack(PURPLE_CUSHION), new ItemStack(MAGENTA_CUSHION), new ItemStack(PINK_CUSHION),
                new ItemStack(WHITE_OTTOMAN), new ItemStack(LIGHT_GRAY_OTTOMAN), new ItemStack(GRAY_OTTOMAN), new ItemStack(BLACK_OTTOMAN), new ItemStack(BROWN_OTTOMAN), new ItemStack(RED_OTTOMAN), new ItemStack(ORANGE_OTTOMAN), new ItemStack(YELLOW_OTTOMAN), new ItemStack(LIME_OTTOMAN), new ItemStack(GREEN_OTTOMAN), new ItemStack(CYAN_OTTOMAN), new ItemStack(LIGHT_BLUE_OTTOMAN), new ItemStack(BLUE_OTTOMAN), new ItemStack(PURPLE_OTTOMAN), new ItemStack(MAGENTA_OTTOMAN), new ItemStack(PINK_OTTOMAN),
                new ItemStack(WHITE_SEAT), new ItemStack(LIGHT_GRAY_SEAT), new ItemStack(GRAY_SEAT), new ItemStack(BLACK_SEAT), new ItemStack(BROWN_SEAT), new ItemStack(RED_SEAT), new ItemStack(ORANGE_SEAT), new ItemStack(YELLOW_SEAT), new ItemStack(LIME_SEAT), new ItemStack(GREEN_SEAT), new ItemStack(CYAN_SEAT), new ItemStack(LIGHT_BLUE_SEAT), new ItemStack(BLUE_SEAT), new ItemStack(PURPLE_SEAT), new ItemStack(MAGENTA_SEAT), new ItemStack(PINK_SEAT),
                new ItemStack(WHITE_STOOL), new ItemStack(LIGHT_GRAY_STOOL), new ItemStack(GRAY_STOOL), new ItemStack(BLACK_STOOL), new ItemStack(BROWN_STOOL), new ItemStack(RED_STOOL), new ItemStack(ORANGE_STOOL), new ItemStack(YELLOW_STOOL), new ItemStack(LIME_STOOL), new ItemStack(GREEN_STOOL), new ItemStack(CYAN_STOOL), new ItemStack(LIGHT_BLUE_STOOL), new ItemStack(BLUE_STOOL), new ItemStack(PURPLE_STOOL), new ItemStack(MAGENTA_STOOL), new ItemStack(PINK_STOOL));
            itemGroup.addAfter(Items.WARPED_HANGING_SIGN,
                new ItemStack(OAK_BENCH), new ItemStack(SPRUCE_BENCH), new ItemStack(BIRCH_BENCH), new ItemStack(JUNGLE_BENCH), new ItemStack(ACACIA_BENCH), new ItemStack(DARK_OAK_BENCH), new ItemStack(MANGROVE_BENCH), new ItemStack(CHERRY_BENCH), /*? if >1.20.1 {*/new ItemStack(PALE_OAK_BENCH),/*?}*/ new ItemStack(BAMBOO_BENCH), new ItemStack(CRIMSON_BENCH), new ItemStack(WARPED_BENCH),
                    new ItemStack(OAK_SEAT), new ItemStack(SPRUCE_SEAT), new ItemStack(BIRCH_SEAT), new ItemStack(JUNGLE_SEAT), new ItemStack(ACACIA_SEAT), new ItemStack(DARK_OAK_SEAT), new ItemStack(MANGROVE_SEAT), new ItemStack(CHERRY_SEAT), /*? if >1.20.1 {*/new ItemStack(PALE_OAK_SEAT),/*?}*/ new ItemStack(BAMBOO_SEAT), new ItemStack(CRIMSON_SEAT), new ItemStack(WARPED_SEAT),
                    new ItemStack(OAK_STOOL), new ItemStack(SPRUCE_STOOL), new ItemStack(BIRCH_STOOL), new ItemStack(JUNGLE_STOOL), new ItemStack(ACACIA_STOOL), new ItemStack(DARK_OAK_STOOL), new ItemStack(MANGROVE_STOOL), new ItemStack(CHERRY_STOOL), /*? if >1.20.1 {*/new ItemStack(PALE_OAK_STOOL),/*?}*/ new ItemStack(BAMBOO_STOOL), new ItemStack(CRIMSON_STOOL), new ItemStack(WARPED_STOOL));
            itemGroup.addAfter(Items.FLOWER_POT, new ItemStack(WHITE_FLOWER_POTS[0]), new ItemStack(LIGHT_GRAY_FLOWER_POTS[0]), new ItemStack(GRAY_FLOWER_POTS[0]), new ItemStack(BLACK_FLOWER_POTS[0]), new ItemStack(BROWN_FLOWER_POTS[0]), new ItemStack(RED_FLOWER_POTS[0]), new ItemStack(ORANGE_FLOWER_POTS[0]), new ItemStack(YELLOW_FLOWER_POTS[0]), new ItemStack(LIME_FLOWER_POTS[0]), new ItemStack(GREEN_FLOWER_POTS[0]), new ItemStack(CYAN_FLOWER_POTS[0]), new ItemStack(LIGHT_BLUE_FLOWER_POTS[0]), new ItemStack(BLUE_FLOWER_POTS[0]), new ItemStack(PURPLE_FLOWER_POTS[0]), new ItemStack(MAGENTA_FLOWER_POTS[0]), new ItemStack(PINK_FLOWER_POTS[0]),
                    new ItemStack(WHITE_LARGE_FLOWER_POTS[0]), new ItemStack(LIGHT_GRAY_LARGE_FLOWER_POTS[0]), new ItemStack(GRAY_LARGE_FLOWER_POTS[0]), new ItemStack(BLACK_LARGE_FLOWER_POTS[0]), new ItemStack(BROWN_LARGE_FLOWER_POTS[0]), new ItemStack(RED_LARGE_FLOWER_POTS[0]), new ItemStack(ORANGE_FLOWER_POTS[0]), new ItemStack(YELLOW_LARGE_FLOWER_POTS[0]), new ItemStack(LIME_LARGE_FLOWER_POTS[0]), new ItemStack(GREEN_LARGE_FLOWER_POTS[0]), new ItemStack(CYAN_LARGE_FLOWER_POTS[0]), new ItemStack(LIGHT_BLUE_LARGE_FLOWER_POTS[0]), new ItemStack(BLUE_LARGE_FLOWER_POTS[0]), new ItemStack(PURPLE_LARGE_FLOWER_POTS[0]), new ItemStack(MAGENTA_LARGE_FLOWER_POTS[0]), new ItemStack(PINK_LARGE_FLOWER_POTS[0]),
                    new ItemStack(HANGING_FLOWER_POTS[0]), new ItemStack(WHITE_HANGING_FLOWER_POTS[0]), new ItemStack(LIGHT_GRAY_HANGING_FLOWER_POTS[0]), new ItemStack(GRAY_HANGING_FLOWER_POTS[0]), new ItemStack(BLACK_HANGING_FLOWER_POTS[0]), new ItemStack(BROWN_HANGING_FLOWER_POTS[0]), new ItemStack(RED_HANGING_FLOWER_POTS[0]), new ItemStack(ORANGE_HANGING_FLOWER_POTS[0]), new ItemStack(YELLOW_HANGING_FLOWER_POTS[0]), new ItemStack(LIME_HANGING_FLOWER_POTS[0]), new ItemStack(GREEN_HANGING_FLOWER_POTS[0]), new ItemStack(CYAN_HANGING_FLOWER_POTS[0]), new ItemStack(LIGHT_BLUE_HANGING_FLOWER_POTS[0]), new ItemStack(BLUE_HANGING_FLOWER_POTS[0]), new ItemStack(PURPLE_HANGING_FLOWER_POTS[0]), new ItemStack(MAGENTA_HANGING_FLOWER_POTS[0]), new ItemStack(PINK_HANGING_FLOWER_POTS[0]));
            itemGroup.addAfter(Items.DECORATED_POT, new ItemStack(WHITE_DECORATED_POT), new ItemStack(LIGHT_GRAY_DECORATED_POT), new ItemStack(GRAY_DECORATED_POT), new ItemStack(BLACK_DECORATED_POT), new ItemStack(BROWN_FLOWER_POTS[0]), new ItemStack(RED_DECORATED_POT), new ItemStack(ORANGE_DECORATED_POT), new ItemStack(YELLOW_DECORATED_POT), new ItemStack(LIME_DECORATED_POT), new ItemStack(GREEN_DECORATED_POT), new ItemStack(CYAN_DECORATED_POT), new ItemStack(LIGHT_BLUE_DECORATED_POT), new ItemStack(BLUE_DECORATED_POT), new ItemStack(PURPLE_DECORATED_POT), new ItemStack(MAGENTA_DECORATED_POT), new ItemStack(PINK_DECORATED_POT));
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register((itemGroup) -> itemGroup.addAfter(Items.STONE_BUTTON, new ItemStack(SEA_LANTERN_BUTTON)));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> itemGroup.addAfter(Items.GUNPOWDER, new ItemStack(SAWDUST)));

        Registry.register(Registries.ITEM_GROUP, PucksBuildingAdditions.CUSTOM_ITEM_GROUP_KEY, PucksBuildingAdditions.CUSTOM_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(PucksBuildingAdditions.CUSTOM_ITEM_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(OAK_BENCH);itemGroup.add(OAK_SEAT);itemGroup.add(OAK_STOOL);
            itemGroup.add(SPRUCE_BENCH);itemGroup.add(SPRUCE_SEAT);itemGroup.add(SPRUCE_STOOL);
            itemGroup.add(BIRCH_BENCH);itemGroup.add(BIRCH_SEAT);itemGroup.add(BIRCH_STOOL);
            itemGroup.add(JUNGLE_BENCH);itemGroup.add(JUNGLE_SEAT);itemGroup.add(JUNGLE_STOOL);
            itemGroup.add(ACACIA_BENCH);itemGroup.add(ACACIA_SEAT);itemGroup.add(ACACIA_STOOL);
            itemGroup.add(DARK_OAK_BENCH);itemGroup.add(DARK_OAK_SEAT);itemGroup.add(DARK_OAK_STOOL);
            itemGroup.add(MANGROVE_BENCH);itemGroup.add(MANGROVE_SEAT);itemGroup.add(MANGROVE_STOOL);
            itemGroup.add(CHERRY_BENCH);itemGroup.add(CHERRY_SEAT);itemGroup.add(CHERRY_STOOL);
            /*? if >1.20.1 {*/itemGroup.add(PALE_OAK_BENCH);itemGroup.add(PALE_OAK_SEAT);itemGroup.add(PALE_OAK_STOOL);/*?}*/
            itemGroup.add(CRIMSON_BENCH);itemGroup.add(CRIMSON_SEAT);itemGroup.add(CRIMSON_STOOL);
            itemGroup.add(WARPED_BENCH);itemGroup.add(WARPED_SEAT);itemGroup.add(WARPED_STOOL);
            itemGroup.add(BAMBOO_BENCH);itemGroup.add(BAMBOO_SEAT);itemGroup.add(BAMBOO_STOOL);

            itemGroup.add(WHITE_CUSHION);itemGroup.add(WHITE_OTTOMAN);itemGroup.add(WHITE_SEAT);itemGroup.add(WHITE_STOOL);
            itemGroup.add(LIGHT_GRAY_CUSHION);itemGroup.add(LIGHT_GRAY_OTTOMAN);itemGroup.add(LIGHT_GRAY_SEAT);itemGroup.add(LIGHT_GRAY_STOOL);
            itemGroup.add(GRAY_CUSHION);itemGroup.add(GRAY_OTTOMAN);itemGroup.add(GRAY_SEAT);itemGroup.add(GRAY_STOOL);
            itemGroup.add(BLACK_CUSHION);itemGroup.add(BLACK_OTTOMAN);itemGroup.add(BLACK_SEAT);itemGroup.add(BLACK_STOOL);
            itemGroup.add(BROWN_CUSHION);itemGroup.add(BROWN_OTTOMAN);itemGroup.add(BROWN_SEAT);itemGroup.add(BROWN_STOOL);
            itemGroup.add(RED_CUSHION);itemGroup.add(RED_OTTOMAN);itemGroup.add(RED_SEAT);itemGroup.add(RED_STOOL);
            itemGroup.add(ORANGE_CUSHION);itemGroup.add(ORANGE_OTTOMAN);itemGroup.add(ORANGE_SEAT);itemGroup.add(ORANGE_STOOL);
            itemGroup.add(YELLOW_CUSHION);itemGroup.add(YELLOW_OTTOMAN);itemGroup.add(YELLOW_SEAT);itemGroup.add(YELLOW_STOOL);
            itemGroup.add(LIME_CUSHION);itemGroup.add(LIME_OTTOMAN);itemGroup.add(LIME_SEAT);itemGroup.add(LIME_STOOL);
            itemGroup.add(GREEN_CUSHION);itemGroup.add(GREEN_OTTOMAN);itemGroup.add(GREEN_SEAT);itemGroup.add(GREEN_STOOL);
            itemGroup.add(CYAN_CUSHION);itemGroup.add(CYAN_OTTOMAN);itemGroup.add(CYAN_SEAT);itemGroup.add(CYAN_STOOL);
            itemGroup.add(LIGHT_BLUE_CUSHION);itemGroup.add(LIGHT_BLUE_OTTOMAN);itemGroup.add(LIGHT_BLUE_SEAT);itemGroup.add(LIGHT_BLUE_STOOL);
            itemGroup.add(BLUE_CUSHION);itemGroup.add(BLUE_OTTOMAN);itemGroup.add(BLUE_SEAT);itemGroup.add(BLUE_STOOL);
            itemGroup.add(PURPLE_CUSHION);itemGroup.add(PURPLE_OTTOMAN);itemGroup.add(PURPLE_SEAT);itemGroup.add(PURPLE_STOOL);
            itemGroup.add(MAGENTA_CUSHION);itemGroup.add(MAGENTA_OTTOMAN);itemGroup.add(MAGENTA_SEAT);itemGroup.add(MAGENTA_STOOL);
            itemGroup.add(PINK_CUSHION);itemGroup.add(PINK_OTTOMAN);itemGroup.add(PINK_SEAT);itemGroup.add(PINK_STOOL);

            itemGroup.add(Items.FLOWER_POT);itemGroup.add(LARGE_FLOWER_POTS[0]);itemGroup.add(HANGING_FLOWER_POTS[0]);itemGroup.add(Items.DECORATED_POT);
            itemGroup.add(WHITE_FLOWER_POTS[0]);itemGroup.add(WHITE_LARGE_FLOWER_POTS[0]);itemGroup.add(WHITE_HANGING_FLOWER_POTS[0]);itemGroup.add(WHITE_DECORATED_POT);
            itemGroup.add(LIGHT_GRAY_FLOWER_POTS[0]);itemGroup.add(LIGHT_GRAY_LARGE_FLOWER_POTS[0]);itemGroup.add(LIGHT_GRAY_HANGING_FLOWER_POTS[0]);itemGroup.add(LIGHT_GRAY_DECORATED_POT);
            itemGroup.add(GRAY_FLOWER_POTS[0]);itemGroup.add(GRAY_LARGE_FLOWER_POTS[0]);itemGroup.add(GRAY_HANGING_FLOWER_POTS[0]);itemGroup.add(GRAY_DECORATED_POT);
            itemGroup.add(BLACK_FLOWER_POTS[0]);itemGroup.add(BLACK_LARGE_FLOWER_POTS[0]);itemGroup.add(BLACK_HANGING_FLOWER_POTS[0]);itemGroup.add(BLACK_DECORATED_POT);
            itemGroup.add(BROWN_FLOWER_POTS[0]);itemGroup.add(BROWN_LARGE_FLOWER_POTS[0]);itemGroup.add(BROWN_HANGING_FLOWER_POTS[0]);itemGroup.add(BROWN_DECORATED_POT);
            itemGroup.add(RED_FLOWER_POTS[0]);itemGroup.add(RED_LARGE_FLOWER_POTS[0]);itemGroup.add(RED_HANGING_FLOWER_POTS[0]);itemGroup.add(RED_DECORATED_POT);
            itemGroup.add(ORANGE_FLOWER_POTS[0]);itemGroup.add(ORANGE_LARGE_FLOWER_POTS[0]);itemGroup.add(ORANGE_HANGING_FLOWER_POTS[0]);itemGroup.add(ORANGE_DECORATED_POT);
            itemGroup.add(YELLOW_FLOWER_POTS[0]);itemGroup.add(YELLOW_LARGE_FLOWER_POTS[0]);itemGroup.add(YELLOW_HANGING_FLOWER_POTS[0]);itemGroup.add(YELLOW_DECORATED_POT);
            itemGroup.add(LIME_FLOWER_POTS[0]);itemGroup.add(LIME_LARGE_FLOWER_POTS[0]);itemGroup.add(LIME_HANGING_FLOWER_POTS[0]);itemGroup.add(LIME_DECORATED_POT);
            itemGroup.add(GREEN_FLOWER_POTS[0]);itemGroup.add(GREEN_LARGE_FLOWER_POTS[0]);itemGroup.add(GREEN_HANGING_FLOWER_POTS[0]);itemGroup.add(GREEN_DECORATED_POT);
            itemGroup.add(CYAN_FLOWER_POTS[0]);itemGroup.add(CYAN_LARGE_FLOWER_POTS[0]);itemGroup.add(CYAN_HANGING_FLOWER_POTS[0]);itemGroup.add(CYAN_DECORATED_POT);
            itemGroup.add(LIGHT_BLUE_FLOWER_POTS[0]);itemGroup.add(LIGHT_BLUE_LARGE_FLOWER_POTS[0]);itemGroup.add(LIGHT_BLUE_HANGING_FLOWER_POTS[0]);itemGroup.add(LIGHT_BLUE_DECORATED_POT);
            itemGroup.add(BLUE_FLOWER_POTS[0]);itemGroup.add(BLUE_LARGE_FLOWER_POTS[0]);itemGroup.add(BLUE_HANGING_FLOWER_POTS[0]);itemGroup.add(BLUE_DECORATED_POT);
            itemGroup.add(PURPLE_FLOWER_POTS[0]);itemGroup.add(PURPLE_LARGE_FLOWER_POTS[0]);itemGroup.add(PURPLE_HANGING_FLOWER_POTS[0]);itemGroup.add(PURPLE_DECORATED_POT);
            itemGroup.add(MAGENTA_FLOWER_POTS[0]);itemGroup.add(MAGENTA_LARGE_FLOWER_POTS[0]);itemGroup.add(MAGENTA_HANGING_FLOWER_POTS[0]);itemGroup.add(MAGENTA_DECORATED_POT);
            itemGroup.add(PINK_FLOWER_POTS[0]);itemGroup.add(PINK_LARGE_FLOWER_POTS[0]);itemGroup.add(PINK_HANGING_FLOWER_POTS[0]);itemGroup.add(PINK_DECORATED_POT);

            itemGroup.add(PAPER_BLOCK); itemGroup.add(WAXED_PAPER_BLOCK);
            itemGroup.add(PAPER_PANEL); itemGroup.add(WAXED_PAPER_PANEL);
            itemGroup.add(HORIZONTAL_PAPER_PANEL); itemGroup.add(WAXED_HORIZONTAL_PAPER_PANEL);
            itemGroup.add(PAPER_PANEL_DOOR); itemGroup.add(HORIZONTAL_PAPER_PANEL_DOOR);
            itemGroup.add(COLLAPSED_CARDBOARD); itemGroup.add(WET_COLLAPSED_CARDBOARD);
            itemGroup.add(CARDBOARD_BLOCK); itemGroup.add(WAXED_CARDBOARD_BLOCK); itemGroup.add(WET_CARDBOARD_BLOCK);
            itemGroup.add(CARDBOARD_STAIRS); itemGroup.add(WAXED_CARDBOARD_STAIRS); itemGroup.add(WET_CARDBOARD_STAIRS);
            itemGroup.add(CARDBOARD_SLAB); itemGroup.add(WAXED_CARDBOARD_SLAB); itemGroup.add(WET_CARDBOARD_SLAB);
            itemGroup.add(CARDBOARD_PANE); itemGroup.add(WAXED_CARDBOARD_PANE); itemGroup.add(WET_CARDBOARD_PANE);
            itemGroup.add(CARDBOARD_GATE); itemGroup.add(WAXED_CARDBOARD_GATE); itemGroup.add(WET_CARDBOARD_GATE);
            itemGroup.add(CARDBOARD_DOOR); itemGroup.add(WAXED_CARDBOARD_DOOR); itemGroup.add(WET_CARDBOARD_DOOR);
            itemGroup.add(CARDBOARD_TRAPDOOR); itemGroup.add(WAXED_CARDBOARD_TRAPDOOR); itemGroup.add(WET_CARDBOARD_TRAPDOOR);
            itemGroup.add(CARDBOARD_BOX); itemGroup.add(WAXED_CARDBOARD_BOX); itemGroup.add(WET_CARDBOARD_BOX);
            itemGroup.add(CARDBOARD_BOX_STAIRS); itemGroup.add(WAXED_CARDBOARD_BOX_STAIRS); itemGroup.add(WET_CARDBOARD_BOX_STAIRS);
            itemGroup.add(CARDBOARD_BOX_SLAB); itemGroup.add(WAXED_CARDBOARD_BOX_SLAB); itemGroup.add(WET_CARDBOARD_BOX_SLAB);

            itemGroup.add(GLOWSTONE_BUTTON);
            itemGroup.add(PEARLESCENT_FROGLIGHT_BUTTON);
            itemGroup.add(VERDANT_FROGLIGHT_BUTTON);
            itemGroup.add(OCHRE_FROGLIGHT_BUTTON);
            itemGroup.add(REDSTONE_LAMP_BUTTON);
            itemGroup.add(SEA_LANTERN_BUTTON);
            itemGroup.add(OBSIDIAN_BUTTON);
            /*? if >1.20.1 {*/
            itemGroup.add(COPPER_BUTTON);
            itemGroup.add(WAXED_COPPER_BUTTON);
            itemGroup.add(EXPOSED_COPPER_BUTTON);
            itemGroup.add(WAXED_EXPOSED_COPPER_BUTTON);
            itemGroup.add(WEATHERED_COPPER_BUTTON);
            itemGroup.add(WAXED_WEATHERED_COPPER_BUTTON);
            itemGroup.add(OXIDIZED_COPPER_BUTTON);
            itemGroup.add(WAXED_OXIDIZED_COPPER_BUTTON);
            /*?}*/

            itemGroup.add(SAWDUST);
            itemGroup.add(Items.GLOWSTONE_DUST);
            itemGroup.add(Items.SUGAR);
            itemGroup.add(Items.BLAZE_POWDER);
            itemGroup.add(Items.GUNPOWDER);

            itemGroup.add(Items.WHITE_DYE);
            itemGroup.add(Items.LIGHT_GRAY_DYE);
            itemGroup.add(Items.GRAY_DYE);
            itemGroup.add(Items.BLACK_DYE);
            itemGroup.add(Items.BROWN_DYE);
            itemGroup.add(Items.RED_DYE);
            itemGroup.add(Items.ORANGE_DYE);
            itemGroup.add(Items.YELLOW_DYE);
            itemGroup.add(Items.LIME_DYE);
            itemGroup.add(Items.GREEN_DYE);
            itemGroup.add(Items.CYAN_DYE);
            itemGroup.add(Items.LIGHT_BLUE_DYE);
            itemGroup.add(Items.BLUE_DYE);
            itemGroup.add(Items.PURPLE_DYE);
            itemGroup.add(Items.MAGENTA_DYE);
            itemGroup.add(Items.PINK_DYE);
        });
        /*?}*/

        FireBlock fireBlock = (FireBlock) Blocks.FIRE;
        fireBlock.registerFlammableBlock(GUNPOWDER, 100, 0);
        fireBlock.registerFlammableBlock(SAWDUST, 20, 30);

        registerItemPlacement(Items.RED_DYE, RED_DYE);
        registerItemPlacement(Items.ORANGE_DYE, ORANGE_DYE);
        registerItemPlacement(Items.YELLOW_DYE, YELLOW_DYE);
        registerItemPlacement(Items.LIME_DYE, LIME_DYE);
        registerItemPlacement(Items.GREEN_DYE, GREEN_DYE);
        registerItemPlacement(Items.CYAN_DYE, CYAN_DYE);
        registerItemPlacement(Items.LIGHT_BLUE_DYE, LIGHT_BLUE_DYE);
        registerItemPlacement(Items.BLUE_DYE, BLUE_DYE);
        registerItemPlacement(Items.PURPLE_DYE, PURPLE_DYE);
        registerItemPlacement(Items.MAGENTA_DYE, MAGENTA_DYE);
        registerItemPlacement(Items.PINK_DYE, PINK_DYE);
        registerItemPlacement(Items.BROWN_DYE, BROWN_DYE);
        registerItemPlacement(Items.WHITE_DYE, WHITE_DYE);
        registerItemPlacement(Items.LIGHT_GRAY_DYE, LIGHT_GRAY_DYE);
        registerItemPlacement(Items.GRAY_DYE, GRAY_DYE);
        registerItemPlacement(Items.BLACK_DYE, BLACK_DYE);
        registerItemPlacement(Items.GLOWSTONE_DUST, GLOWSTONE_DUST);
        registerItemPlacement(Items.BLAZE_POWDER, BLAZE_POWDER);
        registerItemPlacement(Items.SUGAR, SUGAR);
        registerItemPlacement(Items.GUNPOWDER, GUNPOWDER);

        OxidizableBlocksRegistry.registerWaxableBlockPair(CARDBOARD_BLOCK, WAXED_CARDBOARD_BLOCK);
        OxidizableBlocksRegistry.registerWaxableBlockPair(CARDBOARD_SLAB, WAXED_CARDBOARD_SLAB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(CARDBOARD_STAIRS, WAXED_CARDBOARD_STAIRS);
        OxidizableBlocksRegistry.registerWaxableBlockPair(CARDBOARD_DOOR, WAXED_CARDBOARD_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(CARDBOARD_PANE, WAXED_CARDBOARD_PANE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(CARDBOARD_GATE, WAXED_CARDBOARD_GATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(CARDBOARD_BOX, WAXED_CARDBOARD_BOX);
        OxidizableBlocksRegistry.registerWaxableBlockPair(CARDBOARD_BOX_SLAB, WAXED_CARDBOARD_BOX_SLAB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(CARDBOARD_BOX_STAIRS, WAXED_CARDBOARD_BOX_STAIRS);
        OxidizableBlocksRegistry.registerWaxableBlockPair(CARDBOARD_TRAPDOOR, WAXED_CARDBOARD_TRAPDOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(HORIZONTAL_PAPER_PANEL, WAXED_HORIZONTAL_PAPER_PANEL);
        OxidizableBlocksRegistry.registerWaxableBlockPair(HORIZONTAL_PAPER_PANEL_BOTTOM, WAXED_HORIZONTAL_PAPER_PANEL_BOTTOM);
        OxidizableBlocksRegistry.registerWaxableBlockPair(PAPER_PANEL, WAXED_PAPER_PANEL);
        OxidizableBlocksRegistry.registerWaxableBlockPair(PAPER_PANEL_BOTTOM, WAXED_PAPER_PANEL_BOTTOM);
        OxidizableBlocksRegistry.registerWaxableBlockPair(PAPER_BLOCK, WAXED_PAPER_BLOCK);
        /*? if >1.20.1 {*/
        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_BUTTON, WAXED_COPPER_BUTTON);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_BUTTON, WAXED_EXPOSED_COPPER_BUTTON);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_BUTTON, WAXED_WEATHERED_COPPER_BUTTON);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_BUTTON, WAXED_OXIDIZED_COPPER_BUTTON);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_BUTTON, EXPOSED_COPPER_BUTTON);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_BUTTON, WEATHERED_COPPER_BUTTON);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_BUTTON, OXIDIZED_COPPER_BUTTON);

        BlockEntityType.DECORATED_POT.addSupportedBlock(WHITE_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(LIGHT_GRAY_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(GRAY_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(BLACK_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(RED_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(ORANGE_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(YELLOW_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(LIME_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(GREEN_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(CYAN_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(LIGHT_BLUE_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(BLUE_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(PURPLE_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(MAGENTA_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(PINK_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(BROWN_DECORATED_POT);
        /*?}*/
    }

    public static void registerItemPlacement(Item item, Block block) {
        ItemPlacements.put(item, block);
    }
    public static Block getItemPlacement(Item item) {
        return ItemPlacements.get(item);
    }

    static {
        CarpetsToStairs.put(Blocks.RED_CARPET, register("red_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.RED_CARPET), false));
        CarpetsToStairs.put(Blocks.ORANGE_CARPET, register("orange_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.ORANGE_CARPET), false));
        CarpetsToStairs.put(Blocks.YELLOW_CARPET, register("yellow_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.YELLOW_CARPET), false));
        CarpetsToStairs.put(Blocks.LIME_CARPET, register("lime_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.LIME_CARPET), false));
        CarpetsToStairs.put(Blocks.GREEN_CARPET, register("green_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.GREEN_CARPET), false));
        CarpetsToStairs.put(Blocks.CYAN_CARPET, register("cyan_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.CYAN_CARPET), false));
        CarpetsToStairs.put(Blocks.LIGHT_BLUE_CARPET, register("light_blue_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CARPET), false));
        CarpetsToStairs.put(Blocks.BLUE_CARPET, register("blue_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.BLUE_CARPET), false));
        CarpetsToStairs.put(Blocks.PURPLE_CARPET, register("purple_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.PURPLE_CARPET), false));
        CarpetsToStairs.put(Blocks.MAGENTA_CARPET, register("magenta_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.MAGENTA_CARPET), false));
        CarpetsToStairs.put(Blocks.PINK_CARPET, register("pink_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.PINK_CARPET), false));
        CarpetsToStairs.put(Blocks.BROWN_CARPET, register("brown_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.BROWN_CARPET), false));
        CarpetsToStairs.put(Blocks.WHITE_CARPET, register("white_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.WHITE_CARPET), false));
        CarpetsToStairs.put(Blocks.LIGHT_GRAY_CARPET, register("light_gray_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_CARPET), false));
        CarpetsToStairs.put(Blocks.GRAY_CARPET, register("gray_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.GRAY_CARPET), false));
        CarpetsToStairs.put(Blocks.BLACK_CARPET, register("black_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.BLACK_CARPET), false));
        CarpetsToStairs.put(RED_DECORATIVE_CARPET, register("red_decorative_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.RED_CARPET), false));
        CarpetsToStairs.put(ORANGE_DECORATIVE_CARPET, register("orange_decorative_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.ORANGE_CARPET), false));
        CarpetsToStairs.put(YELLOW_DECORATIVE_CARPET, register("yellow_decorative_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.YELLOW_CARPET), false));
        CarpetsToStairs.put(LIME_DECORATIVE_CARPET, register("lime_decorative_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.LIME_CARPET), false));
        CarpetsToStairs.put(GREEN_DECORATIVE_CARPET, register("green_decorative_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.GREEN_CARPET), false));
        CarpetsToStairs.put(CYAN_DECORATIVE_CARPET, register("cyan_decorative_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.CYAN_CARPET), false));
        CarpetsToStairs.put(LIGHT_BLUE_DECORATIVE_CARPET, register("light_blue_decorative_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CARPET), false));
        CarpetsToStairs.put(BLUE_DECORATIVE_CARPET, register("blue_decorative_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.BLUE_CARPET), false));
        CarpetsToStairs.put(PURPLE_DECORATIVE_CARPET, register("purple_decorative_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.PURPLE_CARPET), false));
        CarpetsToStairs.put(MAGENTA_DECORATIVE_CARPET, register("magenta_decorative_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.MAGENTA_CARPET), false));
        CarpetsToStairs.put(PINK_DECORATIVE_CARPET, register("pink_decorative_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.PINK_CARPET), false));
        CarpetsToStairs.put(BROWN_DECORATIVE_CARPET, register("brown_decorative_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.BROWN_CARPET), false));
        CarpetsToStairs.put(WHITE_DECORATIVE_CARPET, register("white_decorative_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.WHITE_CARPET), false));
        CarpetsToStairs.put(LIGHT_GRAY_DECORATIVE_CARPET, register("light_gray_decorative_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_CARPET), false));
        CarpetsToStairs.put(GRAY_DECORATIVE_CARPET, register("gray_decorative_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.GRAY_CARPET), false));
        CarpetsToStairs.put(BLACK_DECORATIVE_CARPET, register("black_decorative_stair_carpet", StairCarpetBlock::new, AbstractBlock.Settings.copy(Blocks.BLACK_CARPET), false));

        CardboardMap.put(COLLAPSED_CARDBOARD, WET_COLLAPSED_CARDBOARD);
        CardboardMap.put(WET_COLLAPSED_CARDBOARD, COLLAPSED_CARDBOARD);
        CardboardMap.put(CARDBOARD_BOX, WET_CARDBOARD_BOX);
        CardboardMap.put(WET_CARDBOARD_BOX, CARDBOARD_BOX);
        CardboardMap.put(CARDBOARD_BOX_STAIRS, WET_CARDBOARD_BOX_STAIRS);
        CardboardMap.put(WET_CARDBOARD_BOX_STAIRS, CARDBOARD_BOX_STAIRS);
        CardboardMap.put(CARDBOARD_DOOR, WET_CARDBOARD_DOOR);
        CardboardMap.put(WET_CARDBOARD_DOOR, CARDBOARD_DOOR);
        CardboardMap.put(CARDBOARD_PANE, WET_CARDBOARD_PANE);
        CardboardMap.put(WET_CARDBOARD_PANE, CARDBOARD_PANE);
        CardboardMap.put(CARDBOARD_SLAB, WET_CARDBOARD_SLAB);
        CardboardMap.put(WET_CARDBOARD_SLAB, CARDBOARD_SLAB);
        CardboardMap.put(CARDBOARD_BLOCK, WET_CARDBOARD_BLOCK);
        CardboardMap.put(WET_CARDBOARD_BLOCK, CARDBOARD_BLOCK);
        CardboardMap.put(CARDBOARD_STAIRS, WET_CARDBOARD_STAIRS);
        CardboardMap.put(WET_CARDBOARD_STAIRS, CARDBOARD_STAIRS);
        CardboardMap.put(CARDBOARD_TRAPDOOR, WET_CARDBOARD_TRAPDOOR);
        CardboardMap.put(WET_CARDBOARD_TRAPDOOR, CARDBOARD_TRAPDOOR);
        CardboardMap.put(CARDBOARD_GATE, WET_CARDBOARD_GATE);
        CardboardMap.put(WET_CARDBOARD_GATE, CARDBOARD_GATE);
    }
}
