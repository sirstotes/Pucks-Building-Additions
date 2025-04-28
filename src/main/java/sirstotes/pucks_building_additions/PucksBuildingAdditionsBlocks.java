package sirstotes.pucks_building_additions;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class PucksBuildingAdditionsBlocks {
    public static Block register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        Identifier id = Identifier.of(PucksBuildingAdditions.MOD_ID, name);
        //? if >1.21.3 {
        Block block = factory.apply(settings.registryKey(RegistryKey.of(RegistryKeys.BLOCK, id)));
        //?} else {
        /*Block block = factory.apply(settings);
         *///?}

        if (shouldRegisterItem) {
            Item.Settings s = new Item.Settings()
                    //? if >1.21.3 {
                    .useBlockPrefixedTranslationKey()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, id))
                    //?}
                    //? if <=1.19.2
                    /*.group(PucksParityModItems.CUSTOM_ITEM_GROUP)*/;
            //?if >1.21.3
            BlockItem blockItem = new BlockItem(block, s);
            Registry.register(/*? if >1.19.2 {*/Registries/*?} else {*//*Registry*//*?}*/.ITEM, id, blockItem);
        }

        return Registry.register(/*? if >1.19.2 {*/Registries/*?} else {*//*Registry*//*?}*/.BLOCK, id, block);
    }

    public static ColoredFlowerPotBlock[] registerFlowerPots(String color) {
        ColoredFlowerPotBlock parent = (ColoredFlowerPotBlock) register(color + "_flower_pot", (settings) -> new ColoredFlowerPotBlock(Blocks.AIR, settings, "flower_pot"), Blocks.createFlowerPotSettings(), true);
        return new ColoredFlowerPotBlock[] {
                parent,
                (ColoredFlowerPotBlock) register(color + "_potted_fern", (settings) -> new ColoredFlowerPotBlock(Blocks.FERN, parent, settings, "potted_fern"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_torchflower", (settings) -> new ColoredFlowerPotBlock(Blocks.TORCHFLOWER, parent, settings, "potted_torchflower"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_oak_sapling", (settings) -> new ColoredFlowerPotBlock(Blocks.OAK_SAPLING, parent, settings, "potted_oak_sapling"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_spruce_sapling", (settings) -> new ColoredFlowerPotBlock(Blocks.SPRUCE_SAPLING, parent, settings, "potted_spruce_sapling"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_birch_sapling", (settings) -> new ColoredFlowerPotBlock(Blocks.BIRCH_SAPLING, parent, settings, "potted_birch_sapling"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_jungle_sapling", (settings) -> new ColoredFlowerPotBlock(Blocks.JUNGLE_SAPLING, parent, settings, "potted_jungle_sapling"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_acacia_sapling", (settings) -> new ColoredFlowerPotBlock(Blocks.ACACIA_SAPLING, parent, settings, "potted_acacia_sapling"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_cherry_sapling", (settings) -> new ColoredFlowerPotBlock(Blocks.CHERRY_SAPLING, parent, settings, "potted_cherry_sapling"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_dark_oak_sapling", (settings) -> new ColoredFlowerPotBlock(Blocks.DARK_OAK_SAPLING, parent, settings, "potted_dark_oak_sapling"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_pale_oak_sapling", (settings) -> new ColoredFlowerPotBlock(Blocks.PALE_OAK_SAPLING, parent, settings, "potted_pale_oak_sapling"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_mangrove_propagule", (settings) -> new ColoredFlowerPotBlock(Blocks.MANGROVE_PROPAGULE, parent, settings, "potted_mangrove_propagule"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_dandelion", (settings) -> new ColoredFlowerPotBlock(Blocks.DANDELION, parent, settings, "potted_dandelion"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_poppy", (settings) -> new ColoredFlowerPotBlock(Blocks.POPPY, parent, settings, "potted_poppy"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_blue_orchid", (settings) -> new ColoredFlowerPotBlock(Blocks.BLUE_ORCHID, parent, settings, "potted_blue_orchid"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_allium", (settings) -> new ColoredFlowerPotBlock(Blocks.ALLIUM, parent, settings, "potted_allium"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_azure_bluet", (settings) -> new ColoredFlowerPotBlock(Blocks.AZURE_BLUET, parent, settings, "potted_azure_bluet"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_red_tulip", (settings) -> new ColoredFlowerPotBlock(Blocks.RED_TULIP, parent, settings, "potted_red_tulip"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_orange_tulip", (settings) -> new ColoredFlowerPotBlock(Blocks.ORANGE_TULIP, parent, settings, "potted_orange_tulip"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_white_tulip", (settings) -> new ColoredFlowerPotBlock(Blocks.WHITE_TULIP, parent, settings, "potted_white_tulip"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_pink_tulip", (settings) -> new ColoredFlowerPotBlock(Blocks.PINK_TULIP, parent, settings, "potted_pink_tulip"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_oxeye_daisy", (settings) -> new ColoredFlowerPotBlock(Blocks.OXEYE_DAISY, parent, settings, "potted_oxeye_daisy"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_cornflower", (settings) -> new ColoredFlowerPotBlock(Blocks.CORNFLOWER, parent, settings, "potted_cornflower"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_lily_of_the_valley", (settings) -> new ColoredFlowerPotBlock(Blocks.LILY_OF_THE_VALLEY, parent, settings, "potted_lily_of_the_valley"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_wither_rose", (settings) -> new ColoredFlowerPotBlock(Blocks.WITHER_ROSE, parent, settings, "potted_wither_rose"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_red_mushroom", (settings) -> new ColoredFlowerPotBlock(Blocks.RED_MUSHROOM, parent, settings, "potted_red_mushroom"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_brown_mushroom", (settings) -> new ColoredFlowerPotBlock(Blocks.BROWN_MUSHROOM, parent, settings, "potted_brown_mushroom"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_dead_bush", (settings) -> new ColoredFlowerPotBlock(Blocks.DEAD_BUSH, parent, settings, "potted_dead_bush"), Blocks.createFlowerPotSettings(), false),
                (ColoredFlowerPotBlock) register(color + "_potted_cactus", (settings) -> new ColoredFlowerPotBlock(Blocks.CACTUS, parent, settings, "potted_cactus"), Blocks.createFlowerPotSettings(), false)
        };
    }

    public static LargeFlowerPotBlock[] registerLargeFlowerPots(String color) {
        LargeFlowerPotBlock parent = (LargeFlowerPotBlock) register(color + "large_flower_pot", (settings) -> new LargeFlowerPotBlock(Blocks.AIR, settings, "large_flower_pot"), Blocks.createFlowerPotSettings(), true);
        return new LargeFlowerPotBlock[] {
                parent,
                (LargeFlowerPotBlock) register(color + "potted_tall_grass", (settings) -> new LargeFlowerPotBlock(Blocks.TALL_GRASS, parent, settings, "potted_tall_grass"), Blocks.createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_large_fern", (settings) -> new LargeFlowerPotBlock(Blocks.LARGE_FERN, parent, settings, "potted_large_fern"), Blocks.createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_bamboo", (settings) -> new LargeFlowerPotBlock(Blocks.BAMBOO, parent, settings, "potted_bamboo"), Blocks.createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_large_cactus", (settings) -> new LargeFlowerPotBlock(Blocks.CACTUS, parent, settings, "potted_large_cactus"), Blocks.createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_sugar_cane", (settings) -> new LargeFlowerPotBlock(Blocks.SUGAR_CANE, parent, settings, "potted_sugar_cane"), Blocks.createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_sunflower", (settings) -> new LargeFlowerPotBlock(Blocks.SUNFLOWER, parent, settings, "potted_sunflower"), Blocks.createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_small_dripleaf", (settings) -> new LargeFlowerPotBlock(Blocks.SMALL_DRIPLEAF, parent, settings, "potted_small_dripleaf"), Blocks.createFlowerPotSettings(), false),

                (LargeFlowerPotBlock) register(color + "potted_lilac", (settings) -> new LargeFlowerPotBlock(Blocks.LILAC, parent, settings, "potted_lilac", Identifier.ofVanilla("block/lilac_bottom"), Identifier.ofVanilla("block/lilac_top")), Blocks.createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_peony", (settings) -> new LargeFlowerPotBlock(Blocks.PEONY, parent, settings, "potted_peony", Identifier.ofVanilla("block/peony_bottom"), Identifier.ofVanilla("block/peony_top")), Blocks.createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_rose_bush", (settings) -> new LargeFlowerPotBlock(Blocks.ROSE_BUSH, parent, settings, "potted_rose_bush", Identifier.ofVanilla("block/rose_bush_bottom"), Identifier.ofVanilla("block/rose_bush_top")), Blocks.createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_pitcher_plant", (settings) -> new LargeFlowerPotBlock(Blocks.PITCHER_PLANT, parent, settings, "potted_pitcher_plant", Identifier.ofVanilla("block/pitcher_crop_bottom_stage_4"), Identifier.ofVanilla("block/pitcher_crop_top_stage_4")), Blocks.createFlowerPotSettings(), false),
                (LargeFlowerPotBlock) register(color + "potted_twisting_vines", (settings) -> new LargeFlowerPotBlock(Blocks.TWISTING_VINES, parent, settings, "potted_twisting_vines", Identifier.ofVanilla("block/twisting_vines_plant"), Identifier.ofVanilla("block/twisting_vines")), Blocks.createFlowerPotSettings(), false)
        };
    }

    public static HangingFlowerPotBlock[] registerHangingFlowerPots(String color) {
        HangingFlowerPotBlock parent = (HangingFlowerPotBlock) register(color + "hanging_flower_pot", (settings) -> new HangingFlowerPotBlock(Blocks.AIR, settings, "hanging_flower_pot"), Blocks.createFlowerPotSettings(), true);
        return new HangingFlowerPotBlock[]{
                parent,
                (HangingFlowerPotBlock) register(color + "potted_vines", (settings) -> new HangingFlowerPotBlock(Blocks.VINE, parent, settings, "potted_vines"), Blocks.createFlowerPotSettings(), false),
                (HangingFlowerPotBlock) register(color + "potted_cave_vines", (settings) -> new HangingFlowerPotBlock(Blocks.CAVE_VINES, parent, settings, "potted_cave_vines", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/cave_vines_berries")), Blocks.createFlowerPotSettings(), false),
                (HangingFlowerPotBlock) register(color + "potted_weeping_vines", (settings) -> new HangingFlowerPotBlock(Blocks.WEEPING_VINES, parent, settings, "potted_weeping_vines", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/weeping_vines")), Blocks.createFlowerPotSettings(), false),
                (HangingFlowerPotBlock) register(color + "potted_pale_hanging_moss", (settings) -> new HangingFlowerPotBlock(Blocks.PALE_HANGING_MOSS, parent, settings, "potted_pale_hanging_moss", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/pale_vines")), Blocks.createFlowerPotSettings(), false)
        };
    }

    public static <T extends BlockEntityType<?>> T registerBlockEntity(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(PucksBuildingAdditions.MOD_ID, path), blockEntityType);
    }

    public static final SittableBlock OAK_BENCH = (SittableBlock) register("oak_bench", SittableBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.IGNORE), true);
    public static final SittableBlock OAK_SEAT = (SittableBlock) register("oak_seat", BackedSittableBlock::new, AbstractBlock.Settings.create(), true);
    public static final SittableBlock OAK_STOOL = (SittableBlock) register("oak_stool", StoolBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock SPRUCE_BENCH = (SittableBlock) register("spruce_bench", SittableBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.IGNORE), true);
    public static final SittableBlock SPRUCE_SEAT = (SittableBlock) register("spruce_seat", BackedSittableBlock::new, AbstractBlock.Settings.create(), true);
    public static final SittableBlock SPRUCE_STOOL = (SittableBlock) register("spruce_stool", StoolBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock BIRCH_BENCH = (SittableBlock) register("birch_bench", SittableBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.IGNORE), true);
    public static final SittableBlock BIRCH_SEAT = (SittableBlock) register("birch_seat", BackedSittableBlock::new, AbstractBlock.Settings.create(), true);
    public static final SittableBlock BIRCH_STOOL = (SittableBlock) register("birch_stool", StoolBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock JUNGLE_BENCH = (SittableBlock) register("jungle_bench", SittableBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.IGNORE), true);
    public static final SittableBlock JUNGLE_SEAT = (SittableBlock) register("jungle_seat", BackedSittableBlock::new, AbstractBlock.Settings.create(), true);
    public static final SittableBlock JUNGLE_STOOL = (SittableBlock) register("jungle_stool", StoolBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock ACACIA_BENCH = (SittableBlock) register("acacia_bench", SittableBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.IGNORE), true);
    public static final SittableBlock ACACIA_SEAT = (SittableBlock) register("acacia_seat", BackedSittableBlock::new, AbstractBlock.Settings.create(), true);
    public static final SittableBlock ACACIA_STOOL = (SittableBlock) register("acacia_stool", StoolBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock DARK_OAK_BENCH = (SittableBlock) register("dark_oak_bench", SittableBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.IGNORE), true);
    public static final SittableBlock DARK_OAK_SEAT = (SittableBlock) register("dark_oak_seat", BackedSittableBlock::new, AbstractBlock.Settings.create(), true);
    public static final SittableBlock DARK_OAK_STOOL = (SittableBlock) register("dark_oak_stool", StoolBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock MANGROVE_BENCH = (SittableBlock) register("mangrove_bench", SittableBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.IGNORE), true);
    public static final SittableBlock MANGROVE_SEAT = (SittableBlock) register("mangrove_seat", BackedSittableBlock::new, AbstractBlock.Settings.create(), true);
    public static final SittableBlock MANGROVE_STOOL = (SittableBlock) register("mangrove_stool", StoolBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock CHERRY_BENCH = (SittableBlock) register("cherry_bench", SittableBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.IGNORE), true);
    public static final SittableBlock CHERRY_SEAT = (SittableBlock) register("cherry_seat", BackedSittableBlock::new, AbstractBlock.Settings.create(), true);
    public static final SittableBlock CHERRY_STOOL = (SittableBlock) register("cherry_stool", StoolBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock PALE_OAK_BENCH = (SittableBlock) register("pale_oak_bench", SittableBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.IGNORE), true);
    public static final SittableBlock PALE_OAK_SEAT = (SittableBlock) register("pale_oak_seat", BackedSittableBlock::new, AbstractBlock.Settings.create(), true);
    public static final SittableBlock PALE_OAK_STOOL = (SittableBlock) register("pale_oak_stool", StoolBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock CRIMSON_BENCH = (SittableBlock) register("crimson_bench", SittableBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.IGNORE), true);
    public static final SittableBlock CRIMSON_SEAT = (SittableBlock) register("crimson_seat", BackedSittableBlock::new, AbstractBlock.Settings.create(), true);
    public static final SittableBlock CRIMSON_STOOL = (SittableBlock) register("crimson_stool", StoolBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock WARPED_BENCH = (SittableBlock) register("warped_bench", SittableBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.IGNORE), true);
    public static final SittableBlock WARPED_SEAT = (SittableBlock) register("warped_seat", BackedSittableBlock::new, AbstractBlock.Settings.create(), true);
    public static final SittableBlock WARPED_STOOL = (SittableBlock) register("warped_stool", StoolBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock BAMBOO_BENCH = (SittableBlock) register("bamboo_bench", SittableBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.IGNORE), true);
    public static final SittableBlock BAMBOO_SEAT = (SittableBlock) register("bamboo_seat", BackedSittableBlock::new, AbstractBlock.Settings.create(), true);
    public static final SittableBlock BAMBOO_STOOL = (SittableBlock) register("bamboo_stool", StoolBlock::new, AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);

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

    public static final SittableBlock RED_CUSHION = (SittableBlock) register("red_cushion", (settings) -> new WoolCushionBlock(DyeColor.RED, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock ORANGE_CUSHION = (SittableBlock) register("orange_cushion", (settings) -> new WoolCushionBlock(DyeColor.ORANGE, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock YELLOW_CUSHION = (SittableBlock) register("yellow_cushion", (settings) -> new WoolCushionBlock(DyeColor.YELLOW, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock LIME_CUSHION = (SittableBlock) register("lime_cushion", (settings) -> new WoolCushionBlock(DyeColor.LIME, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock GREEN_CUSHION = (SittableBlock) register("green_cushion", (settings) -> new WoolCushionBlock(DyeColor.GREEN, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock CYAN_CUSHION = (SittableBlock) register("cyan_cushion", (settings) -> new WoolCushionBlock(DyeColor.CYAN, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock LIGHT_BLUE_CUSHION = (SittableBlock) register("light_blue_cushion", (settings) -> new WoolCushionBlock(DyeColor.LIGHT_BLUE, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock BLUE_CUSHION = (SittableBlock) register("blue_cushion", (settings) -> new WoolCushionBlock(DyeColor.BLUE, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock PURPLE_CUSHION = (SittableBlock) register("purple_cushion", (settings) -> new WoolCushionBlock(DyeColor.PURPLE, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock MAGENTA_CUSHION = (SittableBlock) register("magenta_cushion", (settings) -> new WoolCushionBlock(DyeColor.MAGENTA, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock PINK_CUSHION = (SittableBlock) register("pink_cushion", (settings) -> new WoolCushionBlock(DyeColor.PINK, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock BROWN_CUSHION = (SittableBlock) register("brown_cushion", (settings) -> new WoolCushionBlock(DyeColor.BROWN, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock WHITE_CUSHION = (SittableBlock) register("white_cushion", (settings) -> new WoolCushionBlock(DyeColor.WHITE, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock LIGHT_GRAY_CUSHION = (SittableBlock) register("light_gray_cushion", (settings) -> new WoolCushionBlock(DyeColor.LIGHT_GRAY, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock GRAY_CUSHION = (SittableBlock) register("gray_cushion", (settings) -> new WoolCushionBlock(DyeColor.GRAY, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock BLACK_CUSHION = (SittableBlock) register("black_cushion", (settings) -> new WoolCushionBlock(DyeColor.BLACK, settings), AbstractBlock.Settings.create(), true);

    public static final SittableBlock RED_OTTOMAN = (SittableBlock) register("red_ottoman", (settings) -> new WoolSittableBlock(DyeColor.RED, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock ORANGE_OTTOMAN = (SittableBlock) register("orange_ottoman", (settings) -> new WoolSittableBlock(DyeColor.ORANGE, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock YELLOW_OTTOMAN = (SittableBlock) register("yellow_ottoman", (settings) -> new WoolSittableBlock(DyeColor.YELLOW, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock LIME_OTTOMAN = (SittableBlock) register("lime_ottoman", (settings) -> new WoolSittableBlock(DyeColor.LIME, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock GREEN_OTTOMAN = (SittableBlock) register("green_ottoman", (settings) -> new WoolSittableBlock(DyeColor.GREEN, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock CYAN_OTTOMAN = (SittableBlock) register("cyan_ottoman", (settings) -> new WoolSittableBlock(DyeColor.CYAN, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock LIGHT_BLUE_OTTOMAN = (SittableBlock) register("light_blue_ottoman", (settings) -> new WoolSittableBlock(DyeColor.LIGHT_BLUE, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock BLUE_OTTOMAN = (SittableBlock) register("blue_ottoman", (settings) -> new WoolSittableBlock(DyeColor.BLUE, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock PURPLE_OTTOMAN = (SittableBlock) register("purple_ottoman", (settings) -> new WoolSittableBlock(DyeColor.PURPLE, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock MAGENTA_OTTOMAN = (SittableBlock) register("magenta_ottoman", (settings) -> new WoolSittableBlock(DyeColor.MAGENTA, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock PINK_OTTOMAN = (SittableBlock) register("pink_ottoman", (settings) -> new WoolSittableBlock(DyeColor.PINK, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock BROWN_OTTOMAN = (SittableBlock) register("brown_ottoman", (settings) -> new WoolSittableBlock(DyeColor.BROWN, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock WHITE_OTTOMAN = (SittableBlock) register("white_ottoman", (settings) -> new WoolSittableBlock(DyeColor.WHITE, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock LIGHT_GRAY_OTTOMAN = (SittableBlock) register("light_gray_ottoman", (settings) -> new WoolSittableBlock(DyeColor.LIGHT_GRAY, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock GRAY_OTTOMAN = (SittableBlock) register("gray_ottoman", (settings) -> new WoolSittableBlock(DyeColor.GRAY, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock BLACK_OTTOMAN = (SittableBlock) register("black_ottoman", (settings) -> new WoolSittableBlock(DyeColor.BLACK, settings), AbstractBlock.Settings.create(), true);

    public static final SittableBlock RED_SEAT = (SittableBlock) register("red_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.RED, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock ORANGE_SEAT = (SittableBlock) register("orange_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.ORANGE, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock YELLOW_SEAT = (SittableBlock) register("yellow_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.YELLOW, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock LIME_SEAT = (SittableBlock) register("lime_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.LIME, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock GREEN_SEAT = (SittableBlock) register("green_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.GREEN, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock CYAN_SEAT = (SittableBlock) register("cyan_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.CYAN, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock LIGHT_BLUE_SEAT = (SittableBlock) register("light_blue_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.LIGHT_BLUE, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock BLUE_SEAT = (SittableBlock) register("blue_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.BLUE, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock PURPLE_SEAT = (SittableBlock) register("purple_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.PURPLE, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock MAGENTA_SEAT = (SittableBlock) register("magenta_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.MAGENTA, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock PINK_SEAT = (SittableBlock) register("pink_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.PINK, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock BROWN_SEAT = (SittableBlock) register("brown_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.BROWN, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock WHITE_SEAT = (SittableBlock) register("white_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.WHITE, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock LIGHT_GRAY_SEAT = (SittableBlock) register("light_gray_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.LIGHT_GRAY, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock GRAY_SEAT = (SittableBlock) register("gray_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.GRAY, settings), AbstractBlock.Settings.create(), true);
    public static final SittableBlock BLACK_SEAT = (SittableBlock) register("black_seat", (settings) -> new WoolBackedSittableBlock(DyeColor.BLACK, settings), AbstractBlock.Settings.create(), true);

    public static final SittableBlock RED_STOOL = (SittableBlock) register("red_stool", (settings) -> new WoolStoolBlock(DyeColor.RED, settings), AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock ORANGE_STOOL = (SittableBlock) register("orange_stool", (settings) -> new WoolStoolBlock(DyeColor.ORANGE, settings), AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock YELLOW_STOOL = (SittableBlock) register("yellow_stool", (settings) -> new WoolStoolBlock(DyeColor.YELLOW, settings), AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock LIME_STOOL = (SittableBlock) register("lime_stool", (settings) -> new WoolStoolBlock(DyeColor.LIME, settings), AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock GREEN_STOOL = (SittableBlock) register("green_stool", (settings) -> new WoolStoolBlock(DyeColor.GREEN, settings), AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock CYAN_STOOL = (SittableBlock) register("cyan_stool", (settings) -> new WoolStoolBlock(DyeColor.CYAN, settings), AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock LIGHT_BLUE_STOOL = (SittableBlock) register("light_blue_stool", (settings) -> new WoolStoolBlock(DyeColor.LIGHT_BLUE, settings), AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock BLUE_STOOL = (SittableBlock) register("blue_stool", (settings) -> new WoolStoolBlock(DyeColor.BLUE, settings), AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock PURPLE_STOOL = (SittableBlock) register("purple_stool", (settings) -> new WoolStoolBlock(DyeColor.PURPLE, settings), AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock MAGENTA_STOOL = (SittableBlock) register("magenta_stool", (settings) -> new WoolStoolBlock(DyeColor.MAGENTA, settings), AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock PINK_STOOL = (SittableBlock) register("pink_stool", (settings) -> new WoolStoolBlock(DyeColor.PINK, settings), AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock BROWN_STOOL = (SittableBlock) register("brown_stool", (settings) -> new WoolStoolBlock(DyeColor.BROWN, settings), AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock WHITE_STOOL = (SittableBlock) register("white_stool", (settings) -> new WoolStoolBlock(DyeColor.WHITE, settings), AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock LIGHT_GRAY_STOOL = (SittableBlock) register("light_gray_stool", (settings) -> new WoolStoolBlock(DyeColor.LIGHT_GRAY, settings), AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock GRAY_STOOL = (SittableBlock) register("gray_stool", (settings) -> new WoolStoolBlock(DyeColor.GRAY, settings), AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final SittableBlock BLACK_STOOL = (SittableBlock) register("black_stool", (settings) -> new WoolStoolBlock(DyeColor.BLACK, settings), AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY), true);

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

    public static final LightButtonBlock GLOWSTONE_BUTTON = (LightButtonBlock) register("glowstone_button", (settings) -> new LightButtonBlock(10, 15, settings), Blocks.createButtonSettings(), true);
    public static final LightButtonBlock PEARLESCENT_FROGLIGHT_BUTTON = (LightButtonBlock) register("pearlescent_froglight_button", (settings) -> new LightButtonBlock( 10, 15, settings), Blocks.createButtonSettings(), true);
    public static final LightButtonBlock VERDANT_FROGLIGHT_BUTTON = (LightButtonBlock) register("verdant_froglight_button", (settings) -> new LightButtonBlock( 10, 15, settings), Blocks.createButtonSettings(), true);
    public static final LightButtonBlock OCHRE_FROGLIGHT_BUTTON = (LightButtonBlock) register("ochre_froglight_button", (settings) -> new LightButtonBlock( 10, 15, settings), Blocks.createButtonSettings(), true);
    public static final LightButtonBlock REDSTONE_LAMP_BUTTON = (LightButtonBlock) register("redstone_lamp_button", (settings) -> new LightButtonBlock( 10, 15, settings), Blocks.createButtonSettings(), true);
    public static final LightButtonBlock SEA_LANTERN_BUTTON = (LightButtonBlock) register("sea_lantern_button", (settings) -> new LightButtonBlock( 10, 15, settings), Blocks.createButtonSettings(), true);
    public static final LightButtonBlock SHROOMLIGHT_BUTTON = (LightButtonBlock) register("shroomlight_button", (settings) -> new LightButtonBlock( 10, 15, settings), Blocks.createButtonSettings(), true);
    public static final LightButtonBlock COPPER_BUTTON = (LightButtonBlock) register("copper_button", (settings) -> new LightButtonBlock( 10, 15, settings), Blocks.createButtonSettings(), true);
    public static final LightButtonBlock EXPOSED_COPPER_BUTTON = (LightButtonBlock) register("exposed_copper_button", (settings) -> new LightButtonBlock( 10, 15, settings), Blocks.createButtonSettings(), true);
    public static final LightButtonBlock WEATHERED_COPPER_BUTTON = (LightButtonBlock) register("weathered_copper_button", (settings) -> new LightButtonBlock( 10, 15, settings), Blocks.createButtonSettings(), true);
    public static final LightButtonBlock OXIDIZED_COPPER_BUTTON = (LightButtonBlock) register("oxidized_copper_button", (settings) -> new LightButtonBlock( 10, 15, settings), Blocks.createButtonSettings(), true);
    public static final LightButtonBlock OBSIDIAN_BUTTON = (LightButtonBlock) register("obsidian_button", (settings) -> new LightButtonBlock( 10, 10, settings), Blocks.createButtonSettings(), true);

    public static final Map<Block, Block> CarpetsToStairs = new HashMap<>();
    private static final Object2ObjectMap<Item, BlockItem> ItemPlacements = new Object2ObjectOpenHashMap<>();

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
    public static final DyeBlock RED_DYE = (DyeBlock) register("red_dye_block", (settings) -> new DyeBlock(settings, RED_DYE_GLOWING), wireSettings, true);
    public static final DyeBlock ORANGE_DYE = (DyeBlock) register("orange_dye_block", (settings) -> new DyeBlock(settings, ORANGE_DYE_GLOWING), wireSettings, true);
    public static final DyeBlock YELLOW_DYE = (DyeBlock) register("yellow_dye_block", (settings) -> new DyeBlock(settings, YELLOW_DYE_GLOWING), wireSettings, true);
    public static final DyeBlock LIME_DYE = (DyeBlock) register("lime_dye_block", (settings) -> new DyeBlock(settings, LIME_DYE_GLOWING), wireSettings, true);
    public static final DyeBlock GREEN_DYE = (DyeBlock) register("green_dye_block", (settings) -> new DyeBlock(settings, GREEN_DYE_GLOWING), wireSettings, true);
    public static final DyeBlock CYAN_DYE = (DyeBlock) register("cyan_dye_block", (settings) -> new DyeBlock(settings, CYAN_DYE_GLOWING), wireSettings, true);
    public static final DyeBlock LIGHT_BLUE_DYE = (DyeBlock) register("light_blue_dye_block", (settings) -> new DyeBlock(settings, LIGHT_BLUE_DYE_GLOWING), wireSettings, true);
    public static final DyeBlock BLUE_DYE = (DyeBlock) register("blue_dye_block", (settings) -> new DyeBlock(settings, BLUE_DYE_GLOWING), wireSettings, true);
    public static final DyeBlock PURPLE_DYE = (DyeBlock) register("purple_dye_block", (settings) -> new DyeBlock(settings, PURPLE_DYE_GLOWING), wireSettings, true);
    public static final DyeBlock MAGENTA_DYE = (DyeBlock) register("magenta_dye_block", (settings) -> new DyeBlock(settings, MAGENTA_DYE_GLOWING), wireSettings, true);
    public static final DyeBlock PINK_DYE = (DyeBlock) register("pink_dye_block", (settings) -> new DyeBlock(settings, PINK_DYE_GLOWING), wireSettings, true);
    public static final DyeBlock BROWN_DYE = (DyeBlock) register("brown_dye_block", (settings) -> new DyeBlock(settings, BROWN_DYE_GLOWING), wireSettings, true);
    public static final DyeBlock WHITE_DYE = (DyeBlock) register("white_dye_block", (settings) -> new DyeBlock(settings, WHITE_DYE_GLOWING), wireSettings, true);
    public static final DyeBlock LIGHT_GRAY_DYE = (DyeBlock) register("light_gray_dye_block", (settings) -> new DyeBlock(settings, LIGHT_GRAY_DYE_GLOWING), wireSettings, true);
    public static final DyeBlock GRAY_DYE = (DyeBlock) register("gray_dye_block", (settings) -> new DyeBlock(settings, GRAY_DYE_GLOWING), wireSettings, true);
    public static final DyeBlock BLACK_DYE = (DyeBlock) register("black_dye_block", (settings) -> new DyeBlock(settings, BLACK_DYE_GLOWING), wireSettings, true);
    public static final WireBlock SAWDUST = (WireBlock) register("sawdust", WireBlock::new, wireSettings, true);
    public static final GlowstoneDustBlock GLOWSTONE_DUST = (GlowstoneDustBlock) register("glowstone_dust_block", GlowstoneDustBlock::new, AbstractBlock.Settings.create().noCollision().breakInstantly().pistonBehavior(PistonBehavior.DESTROY).emissiveLighting(Blocks::always).luminance((state) -> {return 3;}), true);
    public static final BlazePowderBlock BLAZE_POWDER = (BlazePowderBlock) register("blaze_powder_block", BlazePowderBlock::new, wireSettings, true);
    public static final SugarBlock SUGAR = (SugarBlock) register("sugar_block", SugarBlock::new, wireSettings, true);
    public static final GunpowderBlock GUNPOWDER = (GunpowderBlock) register("gunpowder_block", GunpowderBlock::new, AbstractBlock.Settings.create().noCollision().breakInstantly().pistonBehavior(PistonBehavior.DESTROY).burnable(), true);

    public static final BlockEntityType<SittableBlockEntity> SITTABLE_BLOCK_ENTITY = registerBlockEntity("sittable", FabricBlockEntityTypeBuilder.create(SittableBlockEntity::new,
            OAK_BENCH, OAK_SEAT, SPRUCE_BENCH, SPRUCE_SEAT, BIRCH_BENCH, BIRCH_SEAT, JUNGLE_BENCH, JUNGLE_SEAT, ACACIA_BENCH, ACACIA_SEAT, DARK_OAK_BENCH, DARK_OAK_SEAT, MANGROVE_BENCH, MANGROVE_SEAT, CHERRY_BENCH, CHERRY_SEAT, PALE_OAK_BENCH, PALE_OAK_SEAT, CRIMSON_BENCH, CRIMSON_SEAT, WARPED_BENCH, WARPED_SEAT, BAMBOO_BENCH, BAMBOO_SEAT).build());
    public static final BlockEntityType<WoolSittableBlockEntity> WOOL_SITTABLE_BLOCK_ENTITY = registerBlockEntity("wool_sittable", FabricBlockEntityTypeBuilder.create(WoolSittableBlockEntity::new,
            RED_OTTOMAN, ORANGE_OTTOMAN, YELLOW_OTTOMAN, LIME_OTTOMAN, GREEN_OTTOMAN, CYAN_OTTOMAN, LIGHT_BLUE_OTTOMAN, BLUE_OTTOMAN, PURPLE_OTTOMAN, MAGENTA_OTTOMAN, PINK_OTTOMAN, BROWN_OTTOMAN, WHITE_OTTOMAN, LIGHT_GRAY_OTTOMAN, GRAY_OTTOMAN, BLACK_OTTOMAN,
            RED_SEAT, ORANGE_SEAT, YELLOW_SEAT, LIME_SEAT, GREEN_SEAT, CYAN_SEAT, LIGHT_BLUE_SEAT, BLUE_SEAT, PURPLE_SEAT, MAGENTA_SEAT, PINK_SEAT, BROWN_SEAT, WHITE_SEAT, LIGHT_GRAY_SEAT, GRAY_SEAT, BLACK_SEAT).build());
    public static final BlockEntityType<CushionBlockEntity> CUSHION_BLOCK_ENTITY = registerBlockEntity("cushion", FabricBlockEntityTypeBuilder.create(CushionBlockEntity::new,
            RED_CUSHION, ORANGE_CUSHION, YELLOW_CUSHION, LIME_CUSHION, GREEN_CUSHION, CYAN_CUSHION, LIGHT_BLUE_CUSHION, BLUE_CUSHION, PURPLE_CUSHION, MAGENTA_CUSHION, PINK_CUSHION, BROWN_CUSHION, WHITE_CUSHION, LIGHT_GRAY_CUSHION, GRAY_CUSHION, BLACK_CUSHION).build());
    public static final BlockEntityType<StoolBlockEntity> STOOL_BLOCK_ENTITY = registerBlockEntity("stool", FabricBlockEntityTypeBuilder.create(StoolBlockEntity::new,
            OAK_STOOL, SPRUCE_STOOL, BIRCH_STOOL, JUNGLE_STOOL, ACACIA_STOOL, DARK_OAK_STOOL, MANGROVE_STOOL, CHERRY_STOOL, PALE_OAK_STOOL, CRIMSON_STOOL, WARPED_STOOL, BAMBOO_STOOL,
            RED_STOOL, ORANGE_STOOL, YELLOW_STOOL, LIME_STOOL, GREEN_STOOL, CYAN_STOOL, LIGHT_BLUE_STOOL, BLUE_STOOL, PURPLE_STOOL, MAGENTA_STOOL, PINK_STOOL, BROWN_STOOL, WHITE_STOOL, LIGHT_GRAY_STOOL, GRAY_STOOL, BLACK_STOOL).build());
    public static final BlockEntityType<ColoredDecoratedPotBlockEntity> COLORED_POT_BLOCK_ENTITY = registerBlockEntity("colored_decorated_pot", FabricBlockEntityTypeBuilder.create(ColoredDecoratedPotBlockEntity::new,
            RED_DECORATED_POT, ORANGE_DECORATED_POT, YELLOW_DECORATED_POT, LIME_DECORATED_POT, GREEN_DECORATED_POT, CYAN_DECORATED_POT, LIGHT_BLUE_DECORATED_POT, BLUE_DECORATED_POT, PURPLE_DECORATED_POT, MAGENTA_DECORATED_POT, PINK_DECORATED_POT, BROWN_DECORATED_POT, WHITE_DECORATED_POT, LIGHT_GRAY_DECORATED_POT, GRAY_DECORATED_POT, BLACK_DECORATED_POT).build());

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register((itemGroup) -> {
            itemGroup.addAfter(Items.PINK_BED,
                new ItemStack(WHITE_CUSHION), new ItemStack(LIGHT_GRAY_CUSHION), new ItemStack(GRAY_CUSHION), new ItemStack(BLACK_CUSHION), new ItemStack(BROWN_CUSHION), new ItemStack(RED_CUSHION), new ItemStack(ORANGE_CUSHION), new ItemStack(YELLOW_CUSHION), new ItemStack(LIME_CUSHION), new ItemStack(GREEN_CUSHION), new ItemStack(CYAN_CUSHION), new ItemStack(LIGHT_BLUE_CUSHION), new ItemStack(BLUE_CUSHION), new ItemStack(PURPLE_CUSHION), new ItemStack(MAGENTA_CUSHION), new ItemStack(PINK_CUSHION),
                new ItemStack(WHITE_OTTOMAN), new ItemStack(LIGHT_GRAY_OTTOMAN), new ItemStack(GRAY_OTTOMAN), new ItemStack(BLACK_OTTOMAN), new ItemStack(BROWN_OTTOMAN), new ItemStack(RED_OTTOMAN), new ItemStack(ORANGE_OTTOMAN), new ItemStack(YELLOW_OTTOMAN), new ItemStack(LIME_OTTOMAN), new ItemStack(GREEN_OTTOMAN), new ItemStack(CYAN_OTTOMAN), new ItemStack(LIGHT_BLUE_OTTOMAN), new ItemStack(BLUE_OTTOMAN), new ItemStack(PURPLE_OTTOMAN), new ItemStack(MAGENTA_OTTOMAN), new ItemStack(PINK_OTTOMAN),
                new ItemStack(WHITE_SEAT), new ItemStack(LIGHT_GRAY_SEAT), new ItemStack(GRAY_SEAT), new ItemStack(BLACK_SEAT), new ItemStack(BROWN_SEAT), new ItemStack(RED_SEAT), new ItemStack(ORANGE_SEAT), new ItemStack(YELLOW_SEAT), new ItemStack(LIME_SEAT), new ItemStack(GREEN_SEAT), new ItemStack(CYAN_SEAT), new ItemStack(LIGHT_BLUE_SEAT), new ItemStack(BLUE_SEAT), new ItemStack(PURPLE_SEAT), new ItemStack(MAGENTA_SEAT), new ItemStack(PINK_SEAT),
                new ItemStack(WHITE_STOOL), new ItemStack(LIGHT_GRAY_STOOL), new ItemStack(GRAY_STOOL), new ItemStack(BLACK_STOOL), new ItemStack(BROWN_STOOL), new ItemStack(RED_STOOL), new ItemStack(ORANGE_STOOL), new ItemStack(YELLOW_STOOL), new ItemStack(LIME_STOOL), new ItemStack(GREEN_STOOL), new ItemStack(CYAN_STOOL), new ItemStack(LIGHT_BLUE_STOOL), new ItemStack(BLUE_STOOL), new ItemStack(PURPLE_STOOL), new ItemStack(MAGENTA_STOOL), new ItemStack(PINK_STOOL));
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> {
            itemGroup.addAfter(Items.MAGMA_BLOCK, new ItemStack(GLOWSTONE_BUTTON), new ItemStack(PEARLESCENT_FROGLIGHT_BUTTON), new ItemStack(VERDANT_FROGLIGHT_BUTTON), new ItemStack(OCHRE_FROGLIGHT_BUTTON), new ItemStack(REDSTONE_LAMP_BUTTON), new ItemStack(SEA_LANTERN_BUTTON), new ItemStack(SHROOMLIGHT_BUTTON), new ItemStack(COPPER_BUTTON), new ItemStack(WEATHERED_COPPER_BUTTON), new ItemStack(EXPOSED_COPPER_BUTTON), new ItemStack(OXIDIZED_COPPER_BUTTON), new ItemStack(OBSIDIAN_BUTTON));
            itemGroup.addAfter(Items.PINK_BED,
                new ItemStack(WHITE_CUSHION), new ItemStack(LIGHT_GRAY_CUSHION), new ItemStack(GRAY_CUSHION), new ItemStack(BLACK_CUSHION), new ItemStack(BROWN_CUSHION), new ItemStack(RED_CUSHION), new ItemStack(ORANGE_CUSHION), new ItemStack(YELLOW_CUSHION), new ItemStack(LIME_CUSHION), new ItemStack(GREEN_CUSHION), new ItemStack(CYAN_CUSHION), new ItemStack(LIGHT_BLUE_CUSHION), new ItemStack(BLUE_CUSHION), new ItemStack(PURPLE_CUSHION), new ItemStack(MAGENTA_CUSHION), new ItemStack(PINK_CUSHION),
                new ItemStack(WHITE_OTTOMAN), new ItemStack(LIGHT_GRAY_OTTOMAN), new ItemStack(GRAY_OTTOMAN), new ItemStack(BLACK_OTTOMAN), new ItemStack(BROWN_OTTOMAN), new ItemStack(RED_OTTOMAN), new ItemStack(ORANGE_OTTOMAN), new ItemStack(YELLOW_OTTOMAN), new ItemStack(LIME_OTTOMAN), new ItemStack(GREEN_OTTOMAN), new ItemStack(CYAN_OTTOMAN), new ItemStack(LIGHT_BLUE_OTTOMAN), new ItemStack(BLUE_OTTOMAN), new ItemStack(PURPLE_OTTOMAN), new ItemStack(MAGENTA_OTTOMAN), new ItemStack(PINK_OTTOMAN),
                new ItemStack(WHITE_SEAT), new ItemStack(LIGHT_GRAY_SEAT), new ItemStack(GRAY_SEAT), new ItemStack(BLACK_SEAT), new ItemStack(BROWN_SEAT), new ItemStack(RED_SEAT), new ItemStack(ORANGE_SEAT), new ItemStack(YELLOW_SEAT), new ItemStack(LIME_SEAT), new ItemStack(GREEN_SEAT), new ItemStack(CYAN_SEAT), new ItemStack(LIGHT_BLUE_SEAT), new ItemStack(BLUE_SEAT), new ItemStack(PURPLE_SEAT), new ItemStack(MAGENTA_SEAT), new ItemStack(PINK_SEAT),
                new ItemStack(WHITE_STOOL), new ItemStack(LIGHT_GRAY_STOOL), new ItemStack(GRAY_STOOL), new ItemStack(BLACK_STOOL), new ItemStack(BROWN_STOOL), new ItemStack(RED_STOOL), new ItemStack(ORANGE_STOOL), new ItemStack(YELLOW_STOOL), new ItemStack(LIME_STOOL), new ItemStack(GREEN_STOOL), new ItemStack(CYAN_STOOL), new ItemStack(LIGHT_BLUE_STOOL), new ItemStack(BLUE_STOOL), new ItemStack(PURPLE_STOOL), new ItemStack(MAGENTA_STOOL), new ItemStack(PINK_STOOL));
            itemGroup.addAfter(Items.WARPED_HANGING_SIGN,
                new ItemStack(OAK_BENCH), new ItemStack(SPRUCE_BENCH), new ItemStack(BIRCH_BENCH), new ItemStack(JUNGLE_BENCH), new ItemStack(ACACIA_BENCH), new ItemStack(DARK_OAK_BENCH), new ItemStack(MANGROVE_BENCH), new ItemStack(CHERRY_BENCH), new ItemStack(PALE_OAK_BENCH), new ItemStack(BAMBOO_BENCH), new ItemStack(CRIMSON_BENCH), new ItemStack(WARPED_BENCH),
                    new ItemStack(OAK_SEAT), new ItemStack(SPRUCE_SEAT), new ItemStack(BIRCH_SEAT), new ItemStack(JUNGLE_SEAT), new ItemStack(ACACIA_SEAT), new ItemStack(DARK_OAK_SEAT), new ItemStack(MANGROVE_SEAT), new ItemStack(CHERRY_SEAT), new ItemStack(PALE_OAK_SEAT), new ItemStack(BAMBOO_SEAT), new ItemStack(CRIMSON_SEAT), new ItemStack(WARPED_SEAT),
                    new ItemStack(OAK_STOOL), new ItemStack(SPRUCE_STOOL), new ItemStack(BIRCH_STOOL), new ItemStack(JUNGLE_STOOL), new ItemStack(ACACIA_STOOL), new ItemStack(DARK_OAK_STOOL), new ItemStack(MANGROVE_STOOL), new ItemStack(CHERRY_STOOL), new ItemStack(PALE_OAK_STOOL), new ItemStack(BAMBOO_STOOL), new ItemStack(CRIMSON_STOOL), new ItemStack(WARPED_STOOL));
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register((itemGroup) -> {
            itemGroup.addAfter(Items.STONE_BUTTON, new ItemStack(SEA_LANTERN_BUTTON));
        });

        FireBlock fireBlock = (FireBlock) Blocks.FIRE;
        fireBlock.registerFlammableBlock(GUNPOWDER, 100, 0);
        fireBlock.registerFlammableBlock(SAWDUST, 20, 30);

        registerItemPlacement(Items.RED_DYE, (BlockItem) RED_DYE.asItem());
        registerItemPlacement(Items.ORANGE_DYE, (BlockItem) ORANGE_DYE.asItem());
        registerItemPlacement(Items.YELLOW_DYE, (BlockItem) YELLOW_DYE.asItem());
        registerItemPlacement(Items.LIME_DYE, (BlockItem) LIME_DYE.asItem());
        registerItemPlacement(Items.GREEN_DYE, (BlockItem) GREEN_DYE.asItem());
        registerItemPlacement(Items.CYAN_DYE, (BlockItem) CYAN_DYE.asItem());
        registerItemPlacement(Items.LIGHT_BLUE_DYE, (BlockItem) LIGHT_BLUE_DYE.asItem());
        registerItemPlacement(Items.BLUE_DYE, (BlockItem) BLUE_DYE.asItem());
        registerItemPlacement(Items.PURPLE_DYE, (BlockItem) PURPLE_DYE.asItem());
        registerItemPlacement(Items.MAGENTA_DYE, (BlockItem) MAGENTA_DYE.asItem());
        registerItemPlacement(Items.PINK_DYE, (BlockItem) PINK_DYE.asItem());
        registerItemPlacement(Items.BROWN_DYE, (BlockItem) BROWN_DYE.asItem());
        registerItemPlacement(Items.WHITE_DYE, (BlockItem) WHITE_DYE.asItem());
        registerItemPlacement(Items.LIGHT_GRAY_DYE, (BlockItem) LIGHT_GRAY_DYE.asItem());
        registerItemPlacement(Items.GRAY_DYE, (BlockItem) GRAY_DYE.asItem());
        registerItemPlacement(Items.BLACK_DYE, (BlockItem) BLACK_DYE.asItem());
        registerItemPlacement(Items.GLOWSTONE_DUST, (BlockItem) GLOWSTONE_DUST.asItem());
        registerItemPlacement(Items.BLAZE_POWDER, (BlockItem) BLAZE_POWDER.asItem());
        registerItemPlacement(Items.SUGAR, (BlockItem) SUGAR.asItem());
        registerItemPlacement(Items.GUNPOWDER, (BlockItem) GUNPOWDER.asItem());


    }

    public static void registerItemPlacement(Item item, BlockItem blockItem) {
        ItemPlacements.put(item, blockItem);
    }
    public static BlockItem getItemPlacement(Item item) {
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
    }
}
