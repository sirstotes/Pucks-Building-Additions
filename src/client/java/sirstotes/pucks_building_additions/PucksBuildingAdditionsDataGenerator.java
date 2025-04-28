package sirstotes.pucks_building_additions;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.enums.StairShape;
import net.minecraft.client.data.*;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.item.Item;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import static sirstotes.pucks_building_additions.PucksBuildingAdditionsBlocks.CarpetsToStairs;

public class PucksBuildingAdditionsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		//pack.addProvider(BlockLootTableProvider::new);
		pack.addProvider(ModelGenerator::new);
		//pack.addProvider(RecipeProvider::new);
		//pack.addProvider(ItemTagGenerator::new);
		//pack.addProvider(BlockTagGenerator::new);
	}

	private static class ModelGenerator extends FabricModelProvider {
		private ModelGenerator(FabricDataOutput generator) {
			super(generator);
		}
		@Override
		public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
			registerSideTopBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.OAK_BENCH, "oak_bench", "minecraft:block/stripped_oak_log_top", "minecraft:block/stripped_oak_log");
			registerSideTopBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.SPRUCE_BENCH, "spruce_bench", "minecraft:block/stripped_spruce_log_top", "minecraft:block/stripped_spruce_log");
			registerSideTopBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BIRCH_BENCH, "birch_bench", "minecraft:block/stripped_birch_log_top", "minecraft:block/stripped_birch_log");
			registerSideTopBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.JUNGLE_BENCH, "jungle_bench", "minecraft:block/stripped_jungle_log_top", "minecraft:block/stripped_jungle_log");
			registerSideTopBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.ACACIA_BENCH, "acacia_bench", "minecraft:block/stripped_acacia_log_top", "minecraft:block/stripped_acacia_log");
			registerSideTopBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.DARK_OAK_BENCH, "dark_oak_bench", "minecraft:block/stripped_dark_oak_log_top", "minecraft:block/stripped_dark_oak_log");
			registerSideTopBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.MANGROVE_BENCH, "mangrove_bench", "minecraft:block/stripped_mangrove_log_top", "minecraft:block/stripped_mangrove_log");
			registerSideTopBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.CHERRY_BENCH, "cherry_bench", "minecraft:block/stripped_cherry_log_top", "minecraft:block/stripped_cherry_log");
			registerSideTopBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PALE_OAK_BENCH, "pale_oak_bench", "minecraft:block/stripped_pale_oak_log_top", "minecraft:block/stripped_pale_oak_log");
			registerSideTopBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.CRIMSON_BENCH, "crimson_bench", "minecraft:block/stripped_crimson_stem_top", "minecraft:block/stripped_crimson_stem");
			registerSideTopBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.WARPED_BENCH, "warped_bench", "minecraft:block/stripped_warped_stem_top", "minecraft:block/stripped_warped_stem");
			registerSideTopBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BAMBOO_BENCH, "bamboo_bench", "minecraft:block/bamboo_block_top", "minecraft:block/bamboo_block");

			registerSideTopStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.OAK_STOOL, "oak_stool", "minecraft:block/stripped_oak_log_top", "minecraft:block/oak_planks");
			registerSideTopStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.SPRUCE_STOOL, "spruce_stool", "minecraft:block/stripped_spruce_log_top", "minecraft:block/spruce_planks");
			registerSideTopStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BIRCH_STOOL, "birch_stool", "minecraft:block/stripped_birch_log_top", "minecraft:block/birch_planks");
			registerSideTopStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.JUNGLE_STOOL, "jungle_stool", "minecraft:block/stripped_jungle_log_top", "minecraft:block/jungle_planks");
			registerSideTopStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.ACACIA_STOOL, "acacia_stool", "minecraft:block/stripped_acacia_log_top", "minecraft:block/acacia_planks");
			registerSideTopStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.DARK_OAK_STOOL, "dark_oak_stool", "minecraft:block/stripped_dark_oak_log_top", "minecraft:block/dark_oak_planks");
			registerSideTopStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.MANGROVE_STOOL, "mangrove_stool", "minecraft:block/stripped_mangrove_log_top", "minecraft:block/mangrove_planks");
			registerSideTopStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.CHERRY_STOOL, "cherry_stool", "minecraft:block/stripped_cherry_log_top", "minecraft:block/cherry_planks");
			registerSideTopStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PALE_OAK_STOOL, "pale_oak_stool", "minecraft:block/stripped_pale_oak_log_top", "minecraft:block/pale_oak_planks");
			registerSideTopStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.CRIMSON_STOOL, "crimson_stool", "minecraft:block/stripped_crimson_stem_top", "minecraft:block/crimson_planks");
			registerSideTopStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.WARPED_STOOL, "warped_stool", "minecraft:block/stripped_warped_stem_top", "minecraft:block/warped_planks");
			registerSideTopStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BAMBOO_STOOL, "bamboo_stool", "minecraft:block/bamboo_block_top", "minecraft:block/bamboo_planks");

			registerSideTopSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.OAK_SEAT, "oak_seat", "minecraft:block/stripped_oak_log_top", "minecraft:block/stripped_oak_log");
			registerSideTopSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.SPRUCE_SEAT, "spruce_seat", "minecraft:block/stripped_spruce_log_top", "minecraft:block/stripped_spruce_log");
			registerSideTopSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BIRCH_SEAT, "birch_seat", "minecraft:block/stripped_birch_log_top", "minecraft:block/stripped_birch_log");
			registerSideTopSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.JUNGLE_SEAT, "jungle_seat", "minecraft:block/stripped_jungle_log_top", "minecraft:block/stripped_jungle_log");
			registerSideTopSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.ACACIA_SEAT, "acacia_seat", "minecraft:block/stripped_acacia_log_top", "minecraft:block/stripped_acacia_log");
			registerSideTopSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.DARK_OAK_SEAT, "dark_oak_seat", "minecraft:block/stripped_dark_oak_log_top", "minecraft:block/stripped_dark_oak_log");
			registerSideTopSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.MANGROVE_SEAT, "mangrove_seat", "minecraft:block/stripped_mangrove_log_top", "minecraft:block/stripped_mangrove_log");
			registerSideTopSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.CHERRY_SEAT, "cherry_seat", "minecraft:block/stripped_cherry_log_top", "minecraft:block/stripped_cherry_log");
			registerSideTopSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PALE_OAK_SEAT, "pale_oak_seat", "minecraft:block/stripped_pale_oak_log_top", "minecraft:block/stripped_pale_oak_log");
			registerSideTopSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.CRIMSON_SEAT, "crimson_seat", "minecraft:block/stripped_crimson_stem_top", "minecraft:block/stripped_crimson_stem");
			registerSideTopSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.WARPED_SEAT, "warped_seat", "minecraft:block/stripped_warped_stem_top", "minecraft:block/stripped_warped_stem");
			registerSideTopSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BAMBOO_SEAT, "bamboo_seat", "minecraft:block/bamboo_block_top", "minecraft:block/bamboo_block");

			registerWoolBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.RED_OTTOMAN, "red");
			registerWoolBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.ORANGE_OTTOMAN, "orange");
			registerWoolBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.YELLOW_OTTOMAN, "yellow");
			registerWoolBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIME_OTTOMAN, "lime");
			registerWoolBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GREEN_OTTOMAN, "green");
			registerWoolBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.CYAN_OTTOMAN, "cyan");
			registerWoolBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_BLUE_OTTOMAN, "light_blue");
			registerWoolBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLUE_OTTOMAN, "blue");
			registerWoolBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PURPLE_OTTOMAN, "purple");
			registerWoolBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.MAGENTA_OTTOMAN, "magenta");
			registerWoolBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PINK_OTTOMAN, "pink");
			registerWoolBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BROWN_OTTOMAN, "brown");
			registerWoolBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.WHITE_OTTOMAN, "white");
			registerWoolBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_GRAY_OTTOMAN, "light_gray");
			registerWoolBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GRAY_OTTOMAN, "gray");
			registerWoolBench(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLACK_OTTOMAN, "black");

			registerWoolCushion(blockStateModelGenerator, PucksBuildingAdditionsBlocks.RED_CUSHION, "red");
			registerWoolCushion(blockStateModelGenerator, PucksBuildingAdditionsBlocks.ORANGE_CUSHION, "orange");
			registerWoolCushion(blockStateModelGenerator, PucksBuildingAdditionsBlocks.YELLOW_CUSHION, "yellow");
			registerWoolCushion(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIME_CUSHION, "lime");
			registerWoolCushion(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GREEN_CUSHION, "green");
			registerWoolCushion(blockStateModelGenerator, PucksBuildingAdditionsBlocks.CYAN_CUSHION, "cyan");
			registerWoolCushion(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_BLUE_CUSHION, "light_blue");
			registerWoolCushion(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLUE_CUSHION, "blue");
			registerWoolCushion(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PURPLE_CUSHION, "purple");
			registerWoolCushion(blockStateModelGenerator, PucksBuildingAdditionsBlocks.MAGENTA_CUSHION, "magenta");
			registerWoolCushion(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PINK_CUSHION, "pink");
			registerWoolCushion(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BROWN_CUSHION, "brown");
			registerWoolCushion(blockStateModelGenerator, PucksBuildingAdditionsBlocks.WHITE_CUSHION, "white");
			registerWoolCushion(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_GRAY_CUSHION, "light_gray");
			registerWoolCushion(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GRAY_CUSHION, "gray");
			registerWoolCushion(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLACK_CUSHION, "black");

			registerWoolSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.RED_SEAT, "red");
			registerWoolSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.ORANGE_SEAT, "orange");
			registerWoolSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.YELLOW_SEAT, "yellow");
			registerWoolSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIME_SEAT, "lime");
			registerWoolSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GREEN_SEAT, "green");
			registerWoolSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.CYAN_SEAT, "cyan");
			registerWoolSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_BLUE_SEAT, "light_blue");
			registerWoolSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLUE_SEAT, "blue");
			registerWoolSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PURPLE_SEAT, "purple");
			registerWoolSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.MAGENTA_SEAT, "magenta");
			registerWoolSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PINK_SEAT, "pink");
			registerWoolSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BROWN_SEAT, "brown");
			registerWoolSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.WHITE_SEAT, "white");
			registerWoolSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_GRAY_SEAT, "light_gray");
			registerWoolSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GRAY_SEAT, "gray");
			registerWoolSeat(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLACK_SEAT, "black");

			registerWoolStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.RED_STOOL, "red");
			registerWoolStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.ORANGE_STOOL, "orange");
			registerWoolStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.YELLOW_STOOL, "yellow");
			registerWoolStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIME_STOOL, "lime");
			registerWoolStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GREEN_STOOL, "green");
			registerWoolStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.CYAN_STOOL, "cyan");
			registerWoolStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_BLUE_STOOL, "light_blue");
			registerWoolStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLUE_STOOL, "blue");
			registerWoolStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PURPLE_STOOL, "purple");
			registerWoolStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.MAGENTA_STOOL, "magenta");
			registerWoolStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PINK_STOOL, "pink");
			registerWoolStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BROWN_STOOL, "brown");
			registerWoolStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.WHITE_STOOL, "white");
			registerWoolStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_GRAY_STOOL, "light_gray");
			registerWoolStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GRAY_STOOL, "gray");
			registerWoolStool(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLACK_STOOL, "black");

			registerLightButton(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GLOWSTONE_BUTTON, "glowstone_button", "minecraft:block/glowstone", "pucks_building_additions:block/glowstone_off");
			registerLightButton(blockStateModelGenerator, PucksBuildingAdditionsBlocks.VERDANT_FROGLIGHT_BUTTON, "verdant_froglight_button", "minecraft:block/verdant_froglight_side", "pucks_building_additions:block/verdant_froglight_off");
			registerLightButton(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PEARLESCENT_FROGLIGHT_BUTTON, "pearlescent_froglight_button", "minecraft:block/pearlescent_froglight_side", "pucks_building_additions:block/pearlescent_froglight_off");
			registerLightButton(blockStateModelGenerator, PucksBuildingAdditionsBlocks.OCHRE_FROGLIGHT_BUTTON, "ochre_froglight_button", "minecraft:block/ochre_froglight_side", "pucks_building_additions:block/ochre_froglight_off");
			registerLightButton(blockStateModelGenerator, PucksBuildingAdditionsBlocks.REDSTONE_LAMP_BUTTON, "redstone_lamp_button", "minecraft:block/redstone_lamp_on", "minecraft:block/redstone_lamp");
			registerLightButton(blockStateModelGenerator, PucksBuildingAdditionsBlocks.SEA_LANTERN_BUTTON, "sea_lantern_button", "minecraft:block/sea_lantern", "pucks_building_additions:block/sea_lantern_off");
			registerLightButton(blockStateModelGenerator, PucksBuildingAdditionsBlocks.SHROOMLIGHT_BUTTON, "shroomlight_button", "minecraft:block/shroomlight", "pucks_building_additions:block/shroomlight_off");
			registerLightButton(blockStateModelGenerator, PucksBuildingAdditionsBlocks.COPPER_BUTTON, "copper_button", "minecraft:block/copper_bulb_lit", "minecraft:block/copper_bulb");
			registerLightButton(blockStateModelGenerator, PucksBuildingAdditionsBlocks.WEATHERED_COPPER_BUTTON, "weathered_copper_button", "minecraft:block/weathered_copper_bulb_lit", "minecraft:block/weathered_copper_bulb");
			registerLightButton(blockStateModelGenerator, PucksBuildingAdditionsBlocks.EXPOSED_COPPER_BUTTON, "exposed_copper_button", "minecraft:block/exposed_copper_bulb_lit", "minecraft:block/exposed_copper_bulb");
			registerLightButton(blockStateModelGenerator, PucksBuildingAdditionsBlocks.OXIDIZED_COPPER_BUTTON, "oxidized_copper_button", "minecraft:block/oxidized_copper_bulb_lit", "minecraft:block/oxidized_copper_bulb");
			registerLightButton(blockStateModelGenerator, PucksBuildingAdditionsBlocks.OBSIDIAN_BUTTON, "obsidian_button", "minecraft:block/crying_obsidian", "minecraft:block/obsidian");

			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.RED_DYE, "red_dye", true);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.ORANGE_DYE, "orange_dye", true);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.YELLOW_DYE, "yellow_dye", true);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIME_DYE, "lime_dye", true);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GREEN_DYE, "green_dye", true);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.CYAN_DYE, "cyan_dye", true);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_BLUE_DYE, "light_blue_dye", true);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLUE_DYE, "blue_dye", true);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PURPLE_DYE, "purple_dye", true);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.MAGENTA_DYE, "magenta_dye", true);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PINK_DYE, "pink_dye", true);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BROWN_DYE, "brown_dye", true);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.WHITE_DYE, "white_dye", true);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_GRAY_DYE, "light_gray_dye", true);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GRAY_DYE, "gray_dye", true);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLACK_DYE, "black_dye", true);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.RED_DYE_GLOWING, "glowing_red_dye", "red_dye", false);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.ORANGE_DYE_GLOWING, "glowing_orange_dye", "orange_dye", false);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.YELLOW_DYE_GLOWING, "glowing_yellow_dye", "yellow_dye", false);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIME_DYE_GLOWING, "glowing_lime_dye", "lime_dye", false);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GREEN_DYE_GLOWING, "glowing_green_dye", "green_dye", false);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.CYAN_DYE_GLOWING, "glowing_cyan_dye", "cyan_dye", false);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_BLUE_DYE_GLOWING, "glowing_light_blue_dye", "light_blue_dye", false);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLUE_DYE_GLOWING, "glowing_blue_dye", "blue_dye", false);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PURPLE_DYE_GLOWING, "glowing_purple_dye", "purple_dye", false);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.MAGENTA_DYE_GLOWING, "glowing_magenta_dye", "magenta_dye", false);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PINK_DYE_GLOWING, "glowing_pink_dye", "pink_dye", false);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BROWN_DYE_GLOWING, "glowing_brown_dye", "brown_dye", false);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.WHITE_DYE_GLOWING, "glowing_white_dye", "white_dye", false);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_GRAY_DYE_GLOWING, "glowing_light_gray_dye", "light_gray_dye", false);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GRAY_DYE_GLOWING, "glowing_gray_dye", "gray_dye", false);
			registerWire(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLACK_DYE_GLOWING, "glowing_black_dye", "black_dye", false);
			registerDust(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GLOWSTONE_DUST, "glowstone_dust", false);
			registerDust(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLAZE_POWDER, "blaze_powder", false);
			registerDust(blockStateModelGenerator, PucksBuildingAdditionsBlocks.SUGAR, "sugar", true);
			registerDust(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GUNPOWDER, "gunpowder", true);
			registerDust(blockStateModelGenerator, PucksBuildingAdditionsBlocks.SAWDUST, "sawdust", true);

			registerFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.RED_FLOWER_POTS, "red");
			registerFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.ORANGE_FLOWER_POTS, "orange");
			registerFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.YELLOW_FLOWER_POTS, "yellow");
			registerFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIME_FLOWER_POTS, "lime");
			registerFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GREEN_FLOWER_POTS, "green");
			registerFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.CYAN_FLOWER_POTS, "cyan");
			registerFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_BLUE_FLOWER_POTS, "light_blue");
			registerFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLUE_FLOWER_POTS, "blue");
			registerFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PURPLE_FLOWER_POTS, "purple");
			registerFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.MAGENTA_FLOWER_POTS, "magenta");
			registerFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PINK_FLOWER_POTS, "pink");
			registerFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BROWN_FLOWER_POTS, "brown");
			registerFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.WHITE_FLOWER_POTS, "white");
			registerFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_GRAY_FLOWER_POTS, "light_gray");
			registerFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GRAY_FLOWER_POTS, "gray");
			registerFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLACK_FLOWER_POTS, "black");

			registerLargeFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LARGE_FLOWER_POTS, "");
			registerLargeFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.RED_LARGE_FLOWER_POTS, "red_");
			registerLargeFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.ORANGE_LARGE_FLOWER_POTS, "orange_");
			registerLargeFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.YELLOW_LARGE_FLOWER_POTS, "yellow_");
			registerLargeFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIME_LARGE_FLOWER_POTS, "lime_");
			registerLargeFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GREEN_LARGE_FLOWER_POTS, "green_");
			registerLargeFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.CYAN_LARGE_FLOWER_POTS, "cyan_");
			registerLargeFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_BLUE_LARGE_FLOWER_POTS, "light_blue_");
			registerLargeFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLUE_LARGE_FLOWER_POTS, "blue_");
			registerLargeFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PURPLE_LARGE_FLOWER_POTS, "purple_");
			registerLargeFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.MAGENTA_LARGE_FLOWER_POTS, "magenta_");
			registerLargeFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PINK_LARGE_FLOWER_POTS, "pink_");
			registerLargeFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BROWN_LARGE_FLOWER_POTS, "brown_");
			registerLargeFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.WHITE_LARGE_FLOWER_POTS, "white_");
			registerLargeFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_GRAY_LARGE_FLOWER_POTS, "light_gray_");
			registerLargeFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GRAY_LARGE_FLOWER_POTS, "gray_");
			registerLargeFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLACK_LARGE_FLOWER_POTS, "black_");

			registerHangingFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.HANGING_FLOWER_POTS, "");
			registerHangingFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.RED_HANGING_FLOWER_POTS, "red_");
			registerHangingFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.ORANGE_HANGING_FLOWER_POTS, "orange_");
			registerHangingFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.YELLOW_HANGING_FLOWER_POTS, "yellow_");
			registerHangingFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIME_HANGING_FLOWER_POTS, "lime_");
			registerHangingFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GREEN_HANGING_FLOWER_POTS, "green_");
			registerHangingFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.CYAN_HANGING_FLOWER_POTS, "cyan_");
			registerHangingFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_BLUE_HANGING_FLOWER_POTS, "light_blue_");
			registerHangingFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLUE_HANGING_FLOWER_POTS, "blue_");
			registerHangingFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PURPLE_HANGING_FLOWER_POTS, "purple_");
			registerHangingFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.MAGENTA_HANGING_FLOWER_POTS, "magenta_");
			registerHangingFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PINK_HANGING_FLOWER_POTS, "pink_");
			registerHangingFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BROWN_HANGING_FLOWER_POTS, "brown_");
			registerHangingFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.WHITE_HANGING_FLOWER_POTS, "white_");
			registerHangingFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_GRAY_HANGING_FLOWER_POTS, "light_gray_");
			registerHangingFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GRAY_HANGING_FLOWER_POTS, "gray_");
			registerHangingFlowerPots(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLACK_HANGING_FLOWER_POTS, "black_");

			registerDecoratedPot(blockStateModelGenerator, PucksBuildingAdditionsBlocks.RED_DECORATED_POT);
			registerDecoratedPot(blockStateModelGenerator, PucksBuildingAdditionsBlocks.ORANGE_DECORATED_POT);
			registerDecoratedPot(blockStateModelGenerator, PucksBuildingAdditionsBlocks.YELLOW_DECORATED_POT);
			registerDecoratedPot(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIME_DECORATED_POT);
			registerDecoratedPot(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GREEN_DECORATED_POT);
			registerDecoratedPot(blockStateModelGenerator, PucksBuildingAdditionsBlocks.CYAN_DECORATED_POT);
			registerDecoratedPot(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_BLUE_DECORATED_POT);
			registerDecoratedPot(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLUE_DECORATED_POT);
			registerDecoratedPot(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PURPLE_DECORATED_POT);
			registerDecoratedPot(blockStateModelGenerator, PucksBuildingAdditionsBlocks.MAGENTA_DECORATED_POT);
			registerDecoratedPot(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PINK_DECORATED_POT);
			registerDecoratedPot(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BROWN_DECORATED_POT);
			registerDecoratedPot(blockStateModelGenerator, PucksBuildingAdditionsBlocks.WHITE_DECORATED_POT);
			registerDecoratedPot(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_GRAY_DECORATED_POT);
			registerDecoratedPot(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GRAY_DECORATED_POT);
			registerDecoratedPot(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLACK_DECORATED_POT);

			registerCarpet(blockStateModelGenerator, PucksBuildingAdditionsBlocks.RED_DECORATIVE_CARPET, "red_decorative_carpet");
			registerCarpet(blockStateModelGenerator, PucksBuildingAdditionsBlocks.ORANGE_DECORATIVE_CARPET, "orange_decorative_carpet");
			registerCarpet(blockStateModelGenerator, PucksBuildingAdditionsBlocks.YELLOW_DECORATIVE_CARPET, "yellow_decorative_carpet");
			registerCarpet(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIME_DECORATIVE_CARPET, "lime_decorative_carpet");
			registerCarpet(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GREEN_DECORATIVE_CARPET, "green_decorative_carpet");
			registerCarpet(blockStateModelGenerator, PucksBuildingAdditionsBlocks.CYAN_DECORATIVE_CARPET, "cyan_decorative_carpet");
			registerCarpet(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_BLUE_DECORATIVE_CARPET, "light_blue_decorative_carpet");
			registerCarpet(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLUE_DECORATIVE_CARPET, "blue_decorative_carpet");
			registerCarpet(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PURPLE_DECORATIVE_CARPET, "purple_decorative_carpet");
			registerCarpet(blockStateModelGenerator, PucksBuildingAdditionsBlocks.MAGENTA_DECORATIVE_CARPET, "magenta_decorative_carpet");
			registerCarpet(blockStateModelGenerator, PucksBuildingAdditionsBlocks.PINK_DECORATIVE_CARPET, "pink_decorative_carpet");
			registerCarpet(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BROWN_DECORATIVE_CARPET, "brown_decorative_carpet");
			registerCarpet(blockStateModelGenerator, PucksBuildingAdditionsBlocks.WHITE_DECORATIVE_CARPET, "white_decorative_carpet");
			registerCarpet(blockStateModelGenerator, PucksBuildingAdditionsBlocks.LIGHT_GRAY_DECORATIVE_CARPET, "light_gray_decorative_carpet");
			registerCarpet(blockStateModelGenerator, PucksBuildingAdditionsBlocks.GRAY_DECORATIVE_CARPET, "gray_decorative_carpet");
			registerCarpet(blockStateModelGenerator, PucksBuildingAdditionsBlocks.BLACK_DECORATIVE_CARPET, "black_decorative_carpet");

			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(Blocks.RED_CARPET), "red_", Identifier.ofVanilla("block/red_wool"), true);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(Blocks.ORANGE_CARPET), "orange_", Identifier.ofVanilla("block/orange_wool"), true);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(Blocks.YELLOW_CARPET), "yellow_", Identifier.ofVanilla("block/yellow_wool"), true);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(Blocks.LIME_CARPET), "lime_", Identifier.ofVanilla("block/lime_wool"), true);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(Blocks.GREEN_CARPET), "green_", Identifier.ofVanilla("block/green_wool"), true);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(Blocks.CYAN_CARPET), "cyan_", Identifier.ofVanilla("block/cyan_wool"), true);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(Blocks.LIGHT_BLUE_CARPET), "light_blue_", Identifier.ofVanilla("block/light_blue_wool"), true);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(Blocks.BLUE_CARPET), "blue_", Identifier.ofVanilla("block/blue_wool"), true);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(Blocks.PURPLE_CARPET), "purple_", Identifier.ofVanilla("block/purple_wool"), true);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(Blocks.MAGENTA_CARPET), "magenta_", Identifier.ofVanilla("block/magenta_wool"), true);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(Blocks.PINK_CARPET), "pink_", Identifier.ofVanilla("block/pink_wool"), true);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(Blocks.BROWN_CARPET), "brown_", Identifier.ofVanilla("block/brown_wool"), true);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(Blocks.WHITE_CARPET), "white_", Identifier.ofVanilla("block/white_wool"), true);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(Blocks.LIGHT_GRAY_CARPET), "light_gray_", Identifier.ofVanilla("block/light_gray_wool"), true);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(Blocks.GRAY_CARPET), "gray_", Identifier.ofVanilla("block/gray_wool"), true);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(Blocks.BLACK_CARPET), "black_", Identifier.ofVanilla("block/black_wool"), true);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PucksBuildingAdditionsBlocks.RED_DECORATIVE_CARPET), "red_decorative_", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/red_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PucksBuildingAdditionsBlocks.ORANGE_DECORATIVE_CARPET), "orange_decorative_", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/orange_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PucksBuildingAdditionsBlocks.YELLOW_DECORATIVE_CARPET), "yellow_decorative_", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/yellow_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PucksBuildingAdditionsBlocks.LIME_DECORATIVE_CARPET), "lime_decorative_", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/lime_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PucksBuildingAdditionsBlocks.GREEN_DECORATIVE_CARPET), "green_decorative_", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/green_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PucksBuildingAdditionsBlocks.CYAN_DECORATIVE_CARPET), "cyan_decorative_", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/cyan_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PucksBuildingAdditionsBlocks.LIGHT_BLUE_DECORATIVE_CARPET), "light_blue_decorative_", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/light_blue_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PucksBuildingAdditionsBlocks.BLUE_DECORATIVE_CARPET), "blue_decorative_", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/blue_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PucksBuildingAdditionsBlocks.PURPLE_DECORATIVE_CARPET), "purple_decorative_", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/purple_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PucksBuildingAdditionsBlocks.MAGENTA_DECORATIVE_CARPET), "magenta_decorative_", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/magenta_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PucksBuildingAdditionsBlocks.PINK_DECORATIVE_CARPET), "pink_decorative_", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/pink_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PucksBuildingAdditionsBlocks.BROWN_DECORATIVE_CARPET), "brown_decorative_", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/brown_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PucksBuildingAdditionsBlocks.WHITE_DECORATIVE_CARPET), "white_decorative_", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/white_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PucksBuildingAdditionsBlocks.LIGHT_GRAY_DECORATIVE_CARPET), "light_gray_decorative_", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/light_gray_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PucksBuildingAdditionsBlocks.GRAY_DECORATIVE_CARPET), "gray_decorative_", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/gray_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PucksBuildingAdditionsBlocks.BLACK_DECORATIVE_CARPET), "black_decorative_", Identifier.of(PucksBuildingAdditions.MOD_ID, "block/black_decorative_carpet"), false);
		}

		@Override
		public void generateItemModels(ItemModelGenerator itemModelGenerator) {
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.OAK_BENCH.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.SPRUCE_BENCH.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BIRCH_BENCH.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.JUNGLE_BENCH.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.ACACIA_BENCH.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.DARK_OAK_BENCH.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.MANGROVE_BENCH.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.CHERRY_BENCH.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.PALE_OAK_BENCH.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.CRIMSON_BENCH.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.WARPED_BENCH.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BAMBOO_BENCH.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.OAK_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.SPRUCE_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BIRCH_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.JUNGLE_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.ACACIA_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.DARK_OAK_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.MANGROVE_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.CHERRY_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.PALE_OAK_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.CRIMSON_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.WARPED_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BAMBOO_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.OAK_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.SPRUCE_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BIRCH_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.JUNGLE_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.ACACIA_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.DARK_OAK_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.MANGROVE_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.CHERRY_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.PALE_OAK_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.CRIMSON_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.WARPED_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BAMBOO_STOOL.asItem());

			itemModelGenerator.register(PucksBuildingAdditionsBlocks.RED_OTTOMAN.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.ORANGE_OTTOMAN.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.YELLOW_OTTOMAN.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.LIME_OTTOMAN.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.GREEN_OTTOMAN.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.CYAN_OTTOMAN.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.LIGHT_BLUE_OTTOMAN.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BLUE_OTTOMAN.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.PURPLE_OTTOMAN.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.MAGENTA_OTTOMAN.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.PINK_OTTOMAN.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BROWN_OTTOMAN.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.WHITE_OTTOMAN.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.LIGHT_GRAY_OTTOMAN.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.GRAY_OTTOMAN.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BLACK_OTTOMAN.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.RED_CUSHION.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.ORANGE_CUSHION.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.YELLOW_CUSHION.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.LIME_CUSHION.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.GREEN_CUSHION.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.CYAN_CUSHION.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.LIGHT_BLUE_CUSHION.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BLUE_CUSHION.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.PURPLE_CUSHION.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.MAGENTA_CUSHION.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.PINK_CUSHION.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BROWN_CUSHION.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.WHITE_CUSHION.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.LIGHT_GRAY_CUSHION.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.GRAY_CUSHION.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BLACK_CUSHION.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.RED_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.ORANGE_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.YELLOW_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.LIME_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.GREEN_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.CYAN_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.LIGHT_BLUE_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BLUE_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.PURPLE_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.MAGENTA_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.PINK_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BROWN_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.WHITE_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.LIGHT_GRAY_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.GRAY_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BLACK_SEAT.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.RED_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.ORANGE_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.YELLOW_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.LIME_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.GREEN_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.CYAN_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.LIGHT_BLUE_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BLUE_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.PURPLE_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.MAGENTA_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.PINK_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BROWN_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.WHITE_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.LIGHT_GRAY_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.GRAY_STOOL.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.BLACK_STOOL.asItem());

			itemModelGenerator.register(PucksBuildingAdditionsBlocks.GLOWSTONE_BUTTON.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.VERDANT_FROGLIGHT_BUTTON.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.PEARLESCENT_FROGLIGHT_BUTTON.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.OCHRE_FROGLIGHT_BUTTON.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.REDSTONE_LAMP_BUTTON.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.SEA_LANTERN_BUTTON.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.SHROOMLIGHT_BUTTON.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.COPPER_BUTTON.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.WEATHERED_COPPER_BUTTON.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.EXPOSED_COPPER_BUTTON.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.OXIDIZED_COPPER_BUTTON.asItem());
			itemModelGenerator.register(PucksBuildingAdditionsBlocks.OBSIDIAN_BUTTON.asItem());

			itemModelGenerator.register(PucksBuildingAdditionsBlocks.SAWDUST.asItem());
		}

		private void registerCarpet(BlockStateModelGenerator blockStateModelGenerator, Block carpet, String name) {
			TextureKey wool = TextureKey.of("wool");
			Identifier id = ModelIds.getBlockModelId(carpet);
			blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier
					.create(carpet).coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_FACING)
							.register(Direction.NORTH, BlockStateVariant.create().put(VariantSettings.MODEL, id).put(VariantSettings.Y, VariantSettings.Rotation.R180))
							.register(Direction.EAST, BlockStateVariant.create().put(VariantSettings.MODEL, id).put(VariantSettings.Y, VariantSettings.Rotation.R270))
							.register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.MODEL, id).put(VariantSettings.Y, VariantSettings.Rotation.R0))
							.register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.MODEL, id).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					));
			new Model(Optional.of(Identifier.ofVanilla("block/carpet")), Optional.of(name), wool)
					.upload(id, new TextureMap().put(wool, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/"+name)), blockStateModelGenerator.modelCollector);
		}

		private void registerFlowerPots(BlockStateModelGenerator blockStateModelGenerator, ColoredFlowerPotBlock[] flowerPots, String color) {
			Identifier texture = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/"+color+"_flower_pot");
			TextureKey pot = TextureKey.of("flowerpot");
			for (ColoredFlowerPotBlock b : flowerPots) {
				registerParented(blockStateModelGenerator, b, color+"_"+b.variantName, Identifier.ofVanilla("block/"+b.variantName),
						new TextureMap().put(TextureKey.PARTICLE, texture).put(pot, texture),
						new TextureKey[] {TextureKey.PARTICLE, pot});
			}
		}

		private void registerLargeFlowerPots(BlockStateModelGenerator blockStateModelGenerator, LargeFlowerPotBlock[] flowerPots, String color) {
			Identifier texture = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/"+color+"large_flower_pot");
			TextureKey pot = TextureKey.of("pot");
			TextureKey bottom = TextureKey.of("bottom");
			TextureKey top = TextureKey.of("top");
			for (LargeFlowerPotBlock b : flowerPots) {
				if (b.usesSpecialModel) {
					if (Objects.equals(color, "")) {
						blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(b, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + b.variantName))));
					} else {
						registerParented(blockStateModelGenerator, b, color+b.variantName, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/"+b.variantName),
								new TextureMap().put(TextureKey.PARTICLE, texture).put(pot, texture),
								new TextureKey[] {TextureKey.PARTICLE, pot});
					}
				} else {
					registerParented(blockStateModelGenerator, b, color+b.variantName, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/large_flower_pot_full"),
							new TextureMap().put(TextureKey.PARTICLE, texture).put(pot, texture).put(bottom, b.bottomTexture).put(top, b.topTexture),
							new TextureKey[] {TextureKey.PARTICLE, pot, bottom, top});
				}
			}
		}

		private void registerHangingFlowerPots(BlockStateModelGenerator blockStateModelGenerator, HangingFlowerPotBlock[] flowerPots, String color) {
			Identifier texture = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/"+color+"large_flower_pot");
			TextureKey pot = TextureKey.of("pot");
			TextureKey plant = TextureKey.of("plant");
			for (HangingFlowerPotBlock b : flowerPots) {
				if (b.usesSpecialModel) {
					if (Objects.equals(color, "")) {
						blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(b, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + b.variantName))));
					} else {
						registerParented(blockStateModelGenerator, b, color+b.variantName, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/"+b.variantName),
								new TextureMap().put(TextureKey.PARTICLE, texture).put(pot, texture),
								new TextureKey[] {TextureKey.PARTICLE, pot});
					}
				} else {
					registerParented(blockStateModelGenerator, b, color+b.variantName, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/hanging_flower_pot_full"),
							new TextureMap().put(TextureKey.PARTICLE, texture).put(pot, texture).put(plant, b.texture),
							new TextureKey[] {TextureKey.PARTICLE, pot, plant});
				}
			}
		}

		private void registerDecoratedPot(BlockStateModelGenerator blockStateModelGenerator, Block block) {
			blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.ofVanilla("block/decorated_pot"))));
			blockStateModelGenerator.modelCollector.accept(ModelIds.getItemModelId(block.asItem()), () -> getItemModelJSON(String.valueOf(Identifier.ofVanilla("block/decorated_pot")), new Vec3d(30, 45, 0), new Vec3d(0, 0, 0), new Vec3d(0.75, 0.75, 0.75)));
		}

		private void registerParented(BlockStateModelGenerator blockStateModelGenerator, Block block, String variant, Identifier parent, TextureMap textureMap, TextureKey[] textureKeys) {
			Identifier id = ModelIds.getBlockModelId(block);
			blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, id)));
			new Model(Optional.of(parent), Optional.of(variant), textureKeys)
					.upload(id, textureMap, blockStateModelGenerator.modelCollector);
		}

		private void registerStairCarpet(BlockStateModelGenerator blockStateModelGenerator, Block block, String color, Identifier texture, Boolean uvlock) {
			TextureMap textureMap = new TextureMap().put(TextureKey.WOOL, texture);
			Identifier id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/"+color+"stair_carpet");
			Identifier id_inner = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/"+color+"stair_carpet_inner");
			Identifier id_outer = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/"+color+"stair_carpet_outer");

			blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier
					.create(block).coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_FACING, Properties.STAIR_SHAPE)
							.register(Direction.NORTH, StairShape.STRAIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, id).put(VariantSettings.Y, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.NORTH, StairShape.INNER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, id_inner).put(VariantSettings.Y, VariantSettings.Rotation.R180).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.NORTH, StairShape.INNER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, id_inner).put(VariantSettings.Y, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.NORTH, StairShape.OUTER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, id_outer).put(VariantSettings.Y, VariantSettings.Rotation.R180).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.NORTH, StairShape.OUTER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, id_outer).put(VariantSettings.Y, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.EAST, StairShape.STRAIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, id).put(VariantSettings.Y, VariantSettings.Rotation.R0).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.EAST, StairShape.INNER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, id_inner).put(VariantSettings.Y, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.EAST, StairShape.INNER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, id_inner).put(VariantSettings.Y, VariantSettings.Rotation.R0).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.EAST, StairShape.OUTER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, id_outer).put(VariantSettings.Y, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.EAST, StairShape.OUTER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, id_outer).put(VariantSettings.Y, VariantSettings.Rotation.R0).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.SOUTH, StairShape.STRAIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, id).put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.SOUTH, StairShape.INNER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, id_inner).put(VariantSettings.Y, VariantSettings.Rotation.R0).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.SOUTH, StairShape.INNER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, id_inner).put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.SOUTH, StairShape.OUTER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, id_outer).put(VariantSettings.Y, VariantSettings.Rotation.R0).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.SOUTH, StairShape.OUTER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, id_outer).put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.WEST, StairShape.STRAIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, id).put(VariantSettings.Y, VariantSettings.Rotation.R180).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.WEST, StairShape.INNER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, id_inner).put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.WEST, StairShape.INNER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, id_inner).put(VariantSettings.Y, VariantSettings.Rotation.R180).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.WEST, StairShape.OUTER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, id_outer).put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, uvlock))
							.register(Direction.WEST, StairShape.OUTER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, id_outer).put(VariantSettings.Y, VariantSettings.Rotation.R180).put(VariantSettings.UVLOCK, uvlock))
					));

			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/stair_carpet")), Optional.of(id.getPath()), TextureKey.WOOL)
					.upload(id, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/stair_carpet_inner")), Optional.of(id_inner.getPath()), TextureKey.WOOL)
					.upload(id_inner, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/stair_carpet_outer")), Optional.of(id_outer.getPath()), TextureKey.WOOL)
					.upload(id_outer, textureMap, blockStateModelGenerator.modelCollector);
		}

		private void registerLightButton(BlockStateModelGenerator blockStateModelGenerator, Block block, String variant, String on_texture, String off_texture) {
			Identifier normal_id = ModelIds.getBlockModelId(block);
			Identifier active_id = ModelIds.getBlockSubModelId(block, "_on");
			Identifier powered_id = ModelIds.getBlockSubModelId(block, "_pressed");
			blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block)
				.coordinate(BlockStateVariantMap.create(Properties.FACING, Properties.POWERED, Properties.ACTIVE)
					.register(Direction.DOWN, false, false, BlockStateVariant.create().put(VariantSettings.MODEL, normal_id).put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R270))
					.register(Direction.DOWN, false, true, BlockStateVariant.create().put(VariantSettings.MODEL, active_id).put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R270))
					.register(Direction.DOWN, true, false, BlockStateVariant.create().put(VariantSettings.MODEL, powered_id).put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R270))
					.register(Direction.DOWN, true, true, BlockStateVariant.create().put(VariantSettings.MODEL, powered_id).put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R270))
					.register(Direction.UP, false, false, BlockStateVariant.create().put(VariantSettings.MODEL, normal_id).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.register(Direction.UP, false, true, BlockStateVariant.create().put(VariantSettings.MODEL, active_id).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.register(Direction.UP, true, false, BlockStateVariant.create().put(VariantSettings.MODEL, powered_id).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.register(Direction.UP, true, true, BlockStateVariant.create().put(VariantSettings.MODEL, powered_id).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.register(Direction.EAST, false, false, BlockStateVariant.create().put(VariantSettings.MODEL, normal_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.register(Direction.EAST, false, true, BlockStateVariant.create().put(VariantSettings.MODEL, active_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.register(Direction.EAST, true, false, BlockStateVariant.create().put(VariantSettings.MODEL, powered_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.register(Direction.EAST, true, true, BlockStateVariant.create().put(VariantSettings.MODEL, powered_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.register(Direction.NORTH, false, false, BlockStateVariant.create().put(VariantSettings.MODEL, normal_id).put(VariantSettings.X, VariantSettings.Rotation.R90))
					.register(Direction.NORTH, false, true, BlockStateVariant.create().put(VariantSettings.MODEL, active_id).put(VariantSettings.X, VariantSettings.Rotation.R90))
					.register(Direction.NORTH, true, false, BlockStateVariant.create().put(VariantSettings.MODEL, powered_id).put(VariantSettings.X, VariantSettings.Rotation.R90))
					.register(Direction.NORTH, true, true, BlockStateVariant.create().put(VariantSettings.MODEL, powered_id).put(VariantSettings.X, VariantSettings.Rotation.R90))
					.register(Direction.SOUTH, false, false, BlockStateVariant.create().put(VariantSettings.MODEL, normal_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.register(Direction.SOUTH, false, true, BlockStateVariant.create().put(VariantSettings.MODEL, active_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.register(Direction.SOUTH, true, false, BlockStateVariant.create().put(VariantSettings.MODEL, powered_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.register(Direction.SOUTH, true, true, BlockStateVariant.create().put(VariantSettings.MODEL, powered_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.register(Direction.WEST, false, false, BlockStateVariant.create().put(VariantSettings.MODEL, normal_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R270))
					.register(Direction.WEST, false, true, BlockStateVariant.create().put(VariantSettings.MODEL, active_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R270))
					.register(Direction.WEST, true, false, BlockStateVariant.create().put(VariantSettings.MODEL, powered_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R270))
					.register(Direction.WEST, true, true, BlockStateVariant.create().put(VariantSettings.MODEL, powered_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R270))
			));

			TextureMap textureMap1 = new TextureMap()
					.put(TextureKey.TEXTURE, Identifier.of(on_texture))
					.put(TextureKey.PARTICLE, Identifier.of(on_texture));
			TextureMap textureMap2 = new TextureMap()
					.put(TextureKey.TEXTURE, Identifier.of(off_texture))
					.put(TextureKey.PARTICLE, Identifier.of(off_texture));

			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/light_button_base")), Optional.of(variant), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(normal_id, textureMap2, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/light_button_on_base")), Optional.of(variant), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(active_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/light_button_pressed_base")), Optional.of(variant), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(powered_id, textureMap1, blockStateModelGenerator.modelCollector);

			blockStateModelGenerator.modelCollector.accept(ModelIds.getItemModelId(block.asItem()), () -> getItemModelJSON(String.valueOf(active_id), new Vec3d(30, -45, -90), new Vec3d(4, -2, 0), new Vec3d(0.75, 0.75, 0.75)));
		}

		private JsonObject getItemModelJSON(String parent) {
			return getItemModelJSON(parent, new Vec3d(30, 45, 0), new Vec3d(0, 0, 0), new Vec3d(0.6, 0.6, 0.6));
		}
		private JsonObject getItemModelJSON(String parent, Vec3d guiRotation, Vec3d guiTranslation, Vec3d guiScale) {
			JsonObject js1 = new JsonObject();
			js1.addProperty("parent", parent);
			js1.add("display", jsonObject(new String[] {"gui", "ground", "fixed"}, new JsonElement[] {
				jsonObject(new String[] {"rotation", "translation", "scale"}, new JsonElement[] {jsonArray(guiRotation.getX(), guiRotation.getY(), guiRotation.getZ()), jsonArray(guiTranslation.getX(), guiTranslation.getY(), guiTranslation.getZ()), jsonArray(guiScale.getX(), guiScale.getY(), guiScale.getZ())}),
				jsonObject(new String[] {"rotation", "translation", "scale"}, new JsonElement[] {jsonArray(0, 0, 0), jsonArray(0, 3, 0), jsonArray(0.25f, 0.25f, 0.25f)}),
				jsonObject(new String[] {"rotation", "translation", "scale"}, new JsonElement[] {jsonArray(0, 90, 0), jsonArray(0, 0, 0), jsonArray(0.5f, 0.5f, 0.5f)})
			}));
			return js1;
		}

		public static JsonObject jsonObject(String[] names, JsonElement[] objects) {
			JsonObject j = new JsonObject();
			for (int i = 0; i < names.length; i ++) {
				j.add(names[i], objects[i]);
			}
			return j;
		}

		public static JsonArray jsonArray(double... args) {
			JsonArray a = new JsonArray();
			for (double i : args) {
				a.add(i);
			}
			return a;
		}

		public static JsonArray jsonArray(int... args) {
			JsonArray a = new JsonArray();
			for (int i : args) {
				a.add(i);
			}
			return a;
		}

		public static JsonArray jsonArray(float... args) {
			JsonArray a = new JsonArray();
			for (float i : args) {
				a.add(i);
			}
			return a;
		}

		private static When whenProp1or2(Property<Integer> p) {
			return When.anyOf(When.create().set(p, 1), When.create().set(p, 2));
		}
		private static <T extends Comparable<T>> When.PropertyCondition whenPropsAre(Object... args) {
			Property<T> p = null;
			When.PropertyCondition w = When.create();
			for (Object arg : args) {
				if (p == null) {
					p = (Property<T>) arg;
				} else {
					w.set(p, (T) arg);
					p = null;
				}
			}
			return w;
		}
		
		private void registerWire(BlockStateModelGenerator blockStateModelGenerator, Block block, String variant, boolean shade) {
			registerWire(blockStateModelGenerator, block, variant, variant, true, shade);
		}
		private void registerWire(BlockStateModelGenerator blockStateModelGenerator, Block block, String variant, String texture, boolean shade) {
			registerWire(blockStateModelGenerator, block, variant, texture, true, shade);
		}
		private void registerWire(BlockStateModelGenerator blockStateModelGenerator, Block block, String variant, String texture, boolean fillEdges, boolean shade) {
			Identifier dot_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_dot");
			Identifier north_off_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_north_off");
			Identifier south_off_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_south_off");
			Identifier east_off_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_east_off");
			Identifier west_off_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_west_off");
			Identifier north_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_north");
			Identifier south_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_south");
			Identifier east_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_east");
			Identifier west_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_west");
			Identifier up_north_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_up_north");
			Identifier up_south_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_up_south");
			Identifier up_east_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_up_east");
			Identifier up_west_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant +  "_up_west");

			MultipartBlockStateSupplier m = MultipartBlockStateSupplier.create(block)
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.DOWN, WireBlock.NORTH, 0, WireBlock.EAST, 0, WireBlock.SOUTH, 0, WireBlock.WEST, 0)),
							BlockStateVariant.create().put(VariantSettings.MODEL, dot_id))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.DOWN), whenProp1or2(WireBlock.NORTH)),
							BlockStateVariant.create().put(VariantSettings.MODEL, north_id))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.DOWN), whenProp1or2(WireBlock.EAST)),
							BlockStateVariant.create().put(VariantSettings.MODEL, east_id))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.DOWN), whenProp1or2(WireBlock.SOUTH)),
							BlockStateVariant.create().put(VariantSettings.MODEL, south_id))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.DOWN), whenProp1or2(WireBlock.WEST)),
							BlockStateVariant.create().put(VariantSettings.MODEL, west_id))

					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.DOWN, WireBlock.NORTH, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_north_id))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.DOWN, WireBlock.EAST, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_east_id))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.DOWN, WireBlock.SOUTH, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_south_id))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.DOWN, WireBlock.WEST, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_west_id))

					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.UP, WireBlock.NORTH, 0, WireBlock.EAST, 0, WireBlock.SOUTH, 0, WireBlock.WEST, 0)),
							BlockStateVariant.create().put(VariantSettings.MODEL, dot_id).put(VariantSettings.X, VariantSettings.Rotation.R180))

					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.UP), whenProp1or2(WireBlock.NORTH)),
							BlockStateVariant.create().put(VariantSettings.MODEL, north_id).put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.UP), whenProp1or2(WireBlock.EAST)),
							BlockStateVariant.create().put(VariantSettings.MODEL, east_id).put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.UP), whenProp1or2(WireBlock.SOUTH)),
							BlockStateVariant.create().put(VariantSettings.MODEL, south_id).put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.UP), whenProp1or2(WireBlock.WEST)),
							BlockStateVariant.create().put(VariantSettings.MODEL, west_id).put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R180))

					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.UP, WireBlock.NORTH, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_north_id).put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.UP, WireBlock.EAST, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_east_id).put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.UP, WireBlock.SOUTH, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_south_id).put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.UP, WireBlock.WEST, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_west_id).put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R180))

					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.NORTH, WireBlock.NORTH, 0, WireBlock.EAST, 0, WireBlock.SOUTH, 0, WireBlock.WEST, 0)),
							BlockStateVariant.create().put(VariantSettings.MODEL, dot_id).put(VariantSettings.X, VariantSettings.Rotation.R270))

					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.NORTH), whenProp1or2(WireBlock.NORTH)),
							BlockStateVariant.create().put(VariantSettings.MODEL, north_id).put(VariantSettings.X, VariantSettings.Rotation.R270))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.NORTH), whenProp1or2(WireBlock.EAST)),
							BlockStateVariant.create().put(VariantSettings.MODEL, east_id).put(VariantSettings.X, VariantSettings.Rotation.R270))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.NORTH), whenProp1or2(WireBlock.SOUTH)),
							BlockStateVariant.create().put(VariantSettings.MODEL, south_id).put(VariantSettings.X, VariantSettings.Rotation.R270))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.NORTH), whenProp1or2(WireBlock.WEST)),
							BlockStateVariant.create().put(VariantSettings.MODEL, west_id).put(VariantSettings.X, VariantSettings.Rotation.R270))

					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.NORTH, WireBlock.NORTH, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_north_id).put(VariantSettings.X, VariantSettings.Rotation.R270))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.NORTH, WireBlock.EAST, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_east_id).put(VariantSettings.X, VariantSettings.Rotation.R270))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.NORTH, WireBlock.SOUTH, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_south_id).put(VariantSettings.X, VariantSettings.Rotation.R270))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.NORTH, WireBlock.WEST, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_west_id).put(VariantSettings.X, VariantSettings.Rotation.R270))

					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.EAST, WireBlock.NORTH, 0, WireBlock.EAST, 0, WireBlock.SOUTH, 0, WireBlock.WEST, 0)),
							BlockStateVariant.create().put(VariantSettings.MODEL, dot_id).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.Y, VariantSettings.Rotation.R90))

					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.EAST), whenProp1or2(WireBlock.NORTH)),
							BlockStateVariant.create().put(VariantSettings.MODEL, west_id).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.EAST), whenProp1or2(WireBlock.EAST)),
							BlockStateVariant.create().put(VariantSettings.MODEL, north_id).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.EAST), whenProp1or2(WireBlock.SOUTH)),
							BlockStateVariant.create().put(VariantSettings.MODEL, east_id).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.EAST), whenProp1or2(WireBlock.WEST)),
							BlockStateVariant.create().put(VariantSettings.MODEL, south_id).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.Y, VariantSettings.Rotation.R90))

					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.EAST, WireBlock.NORTH, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_west_id).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.EAST, WireBlock.EAST, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_north_id).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.EAST, WireBlock.SOUTH, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_east_id).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.EAST, WireBlock.WEST, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_south_id).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.Y, VariantSettings.Rotation.R90))

					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.SOUTH, WireBlock.NORTH, 0, WireBlock.EAST, 0, WireBlock.SOUTH, 0, WireBlock.WEST, 0)),
							BlockStateVariant.create().put(VariantSettings.MODEL, dot_id).put(VariantSettings.X, VariantSettings.Rotation.R90))

					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.SOUTH), whenProp1or2(WireBlock.NORTH)),
							BlockStateVariant.create().put(VariantSettings.MODEL, north_id).put(VariantSettings.X, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.SOUTH), whenProp1or2(WireBlock.EAST)),
							BlockStateVariant.create().put(VariantSettings.MODEL, east_id).put(VariantSettings.X, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.SOUTH), whenProp1or2(WireBlock.SOUTH)),
							BlockStateVariant.create().put(VariantSettings.MODEL, south_id).put(VariantSettings.X, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.SOUTH), whenProp1or2(WireBlock.WEST)),
							BlockStateVariant.create().put(VariantSettings.MODEL, west_id).put(VariantSettings.X, VariantSettings.Rotation.R90))

					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.SOUTH, WireBlock.NORTH, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_north_id).put(VariantSettings.X, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.SOUTH, WireBlock.EAST, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_east_id).put(VariantSettings.X, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.SOUTH, WireBlock.SOUTH, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_south_id).put(VariantSettings.X, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.SOUTH, WireBlock.WEST, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_west_id).put(VariantSettings.X, VariantSettings.Rotation.R90))

					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.WEST, WireBlock.NORTH, 0, WireBlock.EAST, 0, WireBlock.SOUTH, 0, WireBlock.WEST, 0)),
							BlockStateVariant.create().put(VariantSettings.MODEL, dot_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))

					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.WEST), whenProp1or2(WireBlock.NORTH)),
							BlockStateVariant.create().put(VariantSettings.MODEL, west_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.WEST), whenProp1or2(WireBlock.EAST)),
							BlockStateVariant.create().put(VariantSettings.MODEL, north_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.WEST), whenProp1or2(WireBlock.SOUTH)),
							BlockStateVariant.create().put(VariantSettings.MODEL, east_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.WEST), whenProp1or2(WireBlock.WEST)),
							BlockStateVariant.create().put(VariantSettings.MODEL, south_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))

					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.WEST, WireBlock.NORTH, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_west_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.WEST, WireBlock.EAST, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_north_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.WEST, WireBlock.SOUTH, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_east_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.WEST, WireBlock.WEST, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_south_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90));
			if(fillEdges) {
				m = m.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.DOWN, WireBlock.NORTH, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, north_off_id))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.DOWN, WireBlock.EAST, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, east_off_id))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.DOWN, WireBlock.SOUTH, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, south_off_id))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.DOWN, WireBlock.WEST, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, west_off_id))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.UP, WireBlock.NORTH, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, north_off_id).put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R180))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.UP, WireBlock.EAST, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, east_off_id).put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R180))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.UP, WireBlock.SOUTH, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, south_off_id).put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R180))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.UP, WireBlock.WEST, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, west_off_id).put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R180))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.NORTH, WireBlock.NORTH, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, north_off_id).put(VariantSettings.X, VariantSettings.Rotation.R270))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.NORTH, WireBlock.EAST, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, east_off_id).put(VariantSettings.X, VariantSettings.Rotation.R270))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.NORTH, WireBlock.SOUTH, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, south_off_id).put(VariantSettings.X, VariantSettings.Rotation.R270))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.NORTH, WireBlock.WEST, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, west_off_id).put(VariantSettings.X, VariantSettings.Rotation.R270))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.EAST, WireBlock.NORTH, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, west_off_id).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.Y, VariantSettings.Rotation.R90))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.EAST, WireBlock.EAST, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, north_off_id).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.Y, VariantSettings.Rotation.R90))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.EAST, WireBlock.SOUTH, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, east_off_id).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.Y, VariantSettings.Rotation.R90))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.EAST, WireBlock.WEST, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, south_off_id).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.Y, VariantSettings.Rotation.R90))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.SOUTH, WireBlock.NORTH, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, north_off_id).put(VariantSettings.X, VariantSettings.Rotation.R90))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.SOUTH, WireBlock.EAST, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, east_off_id).put(VariantSettings.X, VariantSettings.Rotation.R90))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.SOUTH, WireBlock.SOUTH, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, south_off_id).put(VariantSettings.X, VariantSettings.Rotation.R90))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.SOUTH, WireBlock.WEST, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, west_off_id).put(VariantSettings.X, VariantSettings.Rotation.R90))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.WEST, WireBlock.NORTH, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, west_off_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.WEST, WireBlock.EAST, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, north_off_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.WEST, WireBlock.SOUTH, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, east_off_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
						.with(When.allOf(whenPropsAre(WireBlock.FACING, Direction.WEST, WireBlock.WEST, 0)),
								BlockStateVariant.create().put(VariantSettings.MODEL, south_off_id).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90));
			}

			blockStateModelGenerator.blockStateCollector.accept(m);

			TextureMap textureMap = new TextureMap()
					.put(TextureKey.PARTICLE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + texture))
					.put(TextureKey.TEXTURE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + texture));
			TextureMap textureMap1 = new TextureMap()
					.put(TextureKey.PARTICLE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + texture))
					.put(TextureKey.TEXTURE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + texture + "1"));
			TextureMap textureMap2 = new TextureMap()
					.put(TextureKey.PARTICLE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + texture))
					.put(TextureKey.TEXTURE, Identifier.of(PucksBuildingAdditions.MOD_ID,"block/" + texture + "2"));
			TextureMap textureMap3 = new TextureMap()
					.put(TextureKey.PARTICLE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + texture))
					.put(TextureKey.TEXTURE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + texture + "3"));

			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_dot_base"+(shade?"":"_noshade"))), Optional.of(variant + "_dot"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(dot_id, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_north_base"+(shade?"":"_noshade"))), Optional.of(variant + "_north"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(north_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_east_base"+(shade?"":"_noshade"))), Optional.of(variant + "_east"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(east_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_south_base"+(shade?"":"_noshade"))), Optional.of(variant + "_south"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(south_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_west_base"+(shade?"":"_noshade"))), Optional.of(variant + "_west"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(west_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_north_base"+(shade?"":"_noshade"))), Optional.of(variant + "_north_off"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(north_off_id, textureMap2, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_east_base"+(shade?"":"_noshade"))), Optional.of(variant + "_east_off"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(east_off_id, textureMap2, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_south_base"+(shade?"":"_noshade"))), Optional.of(variant + "_south_off"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(south_off_id, textureMap2, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_west_base"+(shade?"":"_noshade"))), Optional.of(variant + "_west_off"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(west_off_id, textureMap2, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_up_north_base"+(shade?"":"_noshade"))), Optional.of(variant + "_up_north"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(up_north_id, textureMap3, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_up_east_base"+(shade?"":"_noshade"))), Optional.of(variant + "_up_east"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(up_east_id, textureMap3, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_up_south_base"+(shade?"":"_noshade"))), Optional.of(variant + "_up_south"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(up_south_id, textureMap3, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_up_west_base"+(shade?"":"_noshade"))), Optional.of(variant + "_up_west"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(up_west_id, textureMap3, blockStateModelGenerator.modelCollector);
		}

		private void registerDust(BlockStateModelGenerator blockStateModelGenerator, Block block, String variant, boolean shade) {
			Identifier dot_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_dot");
			Identifier north_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_north");
			Identifier south_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_south");
			Identifier east_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_east");
			Identifier west_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_west");
			Identifier up_north_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_up_north");
			Identifier up_south_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_up_south");
			Identifier up_east_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "_up_east");
			Identifier up_west_id = Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant +  "_up_west");

			MultipartBlockStateSupplier m = MultipartBlockStateSupplier.create(block)
					.with(When.anyOf(When.allOf(whenPropsAre(WireBlock.NORTH, 0, WireBlock.EAST, 0, WireBlock.SOUTH, 0, WireBlock.WEST, 0)),//All are empty
									When.allOf(whenProp1or2(WireBlock.NORTH), When.anyOf(whenProp1or2(WireBlock.EAST), whenProp1or2(WireBlock.WEST))),
									When.allOf(whenProp1or2(WireBlock.EAST), When.anyOf(whenProp1or2(WireBlock.NORTH), whenProp1or2(WireBlock.SOUTH))),
									When.allOf(whenProp1or2(WireBlock.SOUTH), When.anyOf(whenProp1or2(WireBlock.EAST), whenProp1or2(WireBlock.WEST))),
									When.allOf(whenProp1or2(WireBlock.WEST), When.anyOf(whenProp1or2(WireBlock.NORTH), whenProp1or2(WireBlock.SOUTH)))),
							BlockStateVariant.create().put(VariantSettings.MODEL, dot_id))

					.with(whenProp1or2(WireBlock.NORTH),
							BlockStateVariant.create().put(VariantSettings.MODEL, north_id))
					.with(whenProp1or2(WireBlock.EAST),
							BlockStateVariant.create().put(VariantSettings.MODEL, east_id))
					.with(whenProp1or2(WireBlock.SOUTH),
							BlockStateVariant.create().put(VariantSettings.MODEL, south_id))
					.with(whenProp1or2(WireBlock.WEST),
							BlockStateVariant.create().put(VariantSettings.MODEL, west_id))

					.with(When.allOf(whenProp1or2(WireBlock.NORTH), whenPropsAre(WireBlock.EAST, 0, WireBlock.SOUTH, 0, WireBlock.WEST, 0)),
							BlockStateVariant.create().put(VariantSettings.MODEL, south_id))
					.with(When.allOf(whenProp1or2(WireBlock.EAST),whenPropsAre(WireBlock.NORTH, 0, WireBlock.SOUTH, 0, WireBlock.WEST, 0)),
							BlockStateVariant.create().put(VariantSettings.MODEL, west_id))
					.with(When.allOf(whenProp1or2(WireBlock.SOUTH),whenPropsAre(WireBlock.EAST, 0, WireBlock.NORTH, 0, WireBlock.WEST, 0)),
							BlockStateVariant.create().put(VariantSettings.MODEL, north_id))
					.with(When.allOf(whenProp1or2(WireBlock.WEST),whenPropsAre(WireBlock.EAST, 0, WireBlock.SOUTH, 0, WireBlock.NORTH, 0)),
							BlockStateVariant.create().put(VariantSettings.MODEL, east_id))

					.with(When.allOf(whenPropsAre(WireBlock.NORTH, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_north_id))
					.with(When.allOf(whenPropsAre(WireBlock.EAST, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_east_id))
					.with(When.allOf(whenPropsAre(WireBlock.SOUTH, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_south_id))
					.with(When.allOf(whenPropsAre(WireBlock.WEST, 2)),
							BlockStateVariant.create().put(VariantSettings.MODEL, up_west_id));

			blockStateModelGenerator.blockStateCollector.accept(m);

			TextureMap textureMap = new TextureMap()
					.put(TextureKey.PARTICLE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant))
					.put(TextureKey.TEXTURE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant));
			TextureMap textureMap1 = new TextureMap()
					.put(TextureKey.PARTICLE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant))
					.put(TextureKey.TEXTURE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "3"));
			TextureMap textureMap3 = new TextureMap()
					.put(TextureKey.PARTICLE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant))
					.put(TextureKey.TEXTURE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + variant + "3"));

			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_dot_base"+(shade?"":"_noshade"))), Optional.of(variant + "_dot"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(dot_id, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_north_base"+(shade?"":"_noshade"))), Optional.of(variant + "_north"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(north_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_east_base"+(shade?"":"_noshade"))), Optional.of(variant + "_east"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(east_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_south_base"+(shade?"":"_noshade"))), Optional.of(variant + "_south"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(south_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_west_base"+(shade?"":"_noshade"))), Optional.of(variant + "_west"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(west_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_up_north_base"+(shade?"":"_noshade"))), Optional.of(variant + "_up_north"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(up_north_id, textureMap3, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_up_east_base"+(shade?"":"_noshade"))), Optional.of(variant + "_up_east"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(up_east_id, textureMap3, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_up_south_base"+(shade?"":"_noshade"))), Optional.of(variant + "_up_south"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(up_south_id, textureMap3, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/dust_up_west_base"+(shade?"":"_noshade"))), Optional.of(variant + "_up_west"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(up_west_id, textureMap3, blockStateModelGenerator.modelCollector);
		}

		private void registerSideTopBench(BlockStateModelGenerator blockStateModelGenerator, Block block, String variant, String top_texture, String side_texture) {
			Identifier id = ModelIds.getBlockModelId(block);
			blockStateModelGenerator.blockStateCollector
					.accept(VariantsBlockStateSupplier.create(block)
							.coordinate(BlockStateVariantMap.create(Properties.OCCUPIED)
									.register(false, BlockStateVariant.create().put(VariantSettings.MODEL, id))
									.register(true, BlockStateVariant.create().put(VariantSettings.MODEL, id))
							));

			TextureMap textureMap = new TextureMap()
					.put(TextureKey.TOP, Identifier.of(top_texture))
					.put(TextureKey.SIDE, Identifier.of(side_texture))
					.put(TextureKey.PARTICLE, Identifier.of(top_texture));

			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/bench_base")), Optional.of(variant), TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE)
					.upload(id, textureMap, blockStateModelGenerator.modelCollector);
			blockStateModelGenerator.modelCollector.accept(ModelIds.getItemModelId(block.asItem()), () -> getItemModelJSON(String.valueOf(id)));
		}

		private void registerSideTopStool(BlockStateModelGenerator blockStateModelGenerator, Block block, String variant, String top_texture, String side_texture) {
			Identifier id = ModelIds.getBlockModelId(block);
			blockStateModelGenerator.blockStateCollector
					.accept(VariantsBlockStateSupplier.create(block)
							.coordinate(BlockStateVariantMap.create(Properties.OCCUPIED)
									.register(false, BlockStateVariant.create().put(VariantSettings.MODEL, id))
									.register(true, BlockStateVariant.create().put(VariantSettings.MODEL, id))
							));

			TextureMap textureMap = new TextureMap()
					.put(TextureKey.TOP, Identifier.of(top_texture))
					.put(TextureKey.SIDE, Identifier.of(side_texture))
					.put(TextureKey.PARTICLE, Identifier.of(top_texture));

			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/wood_stool_base")), Optional.of(variant), TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE)
					.upload(id, textureMap, blockStateModelGenerator.modelCollector);
			blockStateModelGenerator.modelCollector.accept(ModelIds.getItemModelId(block.asItem()), () -> getItemModelJSON(String.valueOf(id), new Vec3d(30, 45, 0), new Vec3d(0, 0, 0), new Vec3d(0.75, 0.75, 0.75)));
		}

		private void registerSideTopSeat(BlockStateModelGenerator blockStateModelGenerator, Block block, String variant, String top_texture, String side_texture) {
			Identifier normal_id = ModelIds.getBlockModelId(block);
			Identifier inner_id = ModelIds.getBlockSubModelId(block, "_inner");
			Identifier outer_id = ModelIds.getBlockSubModelId(block, "_outer");
			blockStateModelGenerator.blockStateCollector
					.accept(VariantsBlockStateSupplier.create(block)
							.coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_FACING, Properties.STAIR_SHAPE)
									.register(Direction.EAST, StairShape.INNER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, inner_id).put(VariantSettings.Y, VariantSettings.Rotation.R270))
									.register(Direction.EAST, StairShape.INNER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, inner_id))
									.register(Direction.EAST, StairShape.OUTER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, outer_id).put(VariantSettings.Y, VariantSettings.Rotation.R270))
									.register(Direction.EAST, StairShape.OUTER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, outer_id))
									.register(Direction.EAST, StairShape.STRAIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, normal_id))
									.register(Direction.NORTH, StairShape.INNER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, inner_id).put(VariantSettings.Y, VariantSettings.Rotation.R180))
									.register(Direction.NORTH, StairShape.INNER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, inner_id).put(VariantSettings.Y, VariantSettings.Rotation.R270))
									.register(Direction.NORTH, StairShape.OUTER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, outer_id).put(VariantSettings.Y, VariantSettings.Rotation.R180))
									.register(Direction.NORTH, StairShape.OUTER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, outer_id).put(VariantSettings.Y, VariantSettings.Rotation.R270))
									.register(Direction.NORTH, StairShape.STRAIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, normal_id).put(VariantSettings.Y, VariantSettings.Rotation.R270))
									.register(Direction.SOUTH, StairShape.INNER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, inner_id))
									.register(Direction.SOUTH, StairShape.INNER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, inner_id).put(VariantSettings.Y, VariantSettings.Rotation.R90))
									.register(Direction.SOUTH, StairShape.OUTER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, outer_id))
									.register(Direction.SOUTH, StairShape.OUTER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, outer_id).put(VariantSettings.Y, VariantSettings.Rotation.R90))
									.register(Direction.SOUTH, StairShape.STRAIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, normal_id).put(VariantSettings.Y, VariantSettings.Rotation.R90))
									.register(Direction.WEST, StairShape.INNER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, inner_id).put(VariantSettings.Y, VariantSettings.Rotation.R90))
									.register(Direction.WEST, StairShape.INNER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, inner_id).put(VariantSettings.Y, VariantSettings.Rotation.R180))
									.register(Direction.WEST, StairShape.OUTER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, outer_id).put(VariantSettings.Y, VariantSettings.Rotation.R90))
									.register(Direction.WEST, StairShape.OUTER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, outer_id).put(VariantSettings.Y, VariantSettings.Rotation.R180))
									.register(Direction.WEST, StairShape.STRAIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, normal_id).put(VariantSettings.Y, VariantSettings.Rotation.R180))
							));

			TextureMap textureMap = new TextureMap()
					.put(TextureKey.TOP, Identifier.of(top_texture))
					.put(TextureKey.SIDE, Identifier.of(side_texture))
					.put(TextureKey.PARTICLE, Identifier.of(top_texture));

			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/seat_base")), Optional.of(variant), TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE)
					.upload(normal_id, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/seat_inner_base")), Optional.of(variant), TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE)
					.upload(inner_id, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/seat_outer_base")), Optional.of(variant), TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE)
					.upload(outer_id, textureMap, blockStateModelGenerator.modelCollector);
			blockStateModelGenerator.modelCollector.accept(ModelIds.getItemModelId(block.asItem()), () -> getItemModelJSON(String.valueOf(normal_id)));
		}

		private void registerWoolBench(BlockStateModelGenerator blockStateModelGenerator, Block block, String texture) {
			Identifier id = ModelIds.getBlockModelId(block);
			blockStateModelGenerator.blockStateCollector
					.accept(VariantsBlockStateSupplier.create(block)
							.coordinate(BlockStateVariantMap.create(Properties.OCCUPIED)
									.register(false, BlockStateVariant.create().put(VariantSettings.MODEL, id))
									.register(true, BlockStateVariant.create().put(VariantSettings.MODEL, id))
							));

			TextureMap textureMap = new TextureMap()
					.put(TextureKey.TEXTURE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + texture))
					.put(TextureKey.PARTICLE, Identifier.ofVanilla("block/oak_planks"));

			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/ottoman_base")), Optional.of(texture), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(id, textureMap, blockStateModelGenerator.modelCollector);
			blockStateModelGenerator.modelCollector.accept(ModelIds.getItemModelId(block.asItem()), () -> getItemModelJSON(String.valueOf(id)));
		}

		private void registerWoolStool(BlockStateModelGenerator blockStateModelGenerator, Block block, String texture) {
			Identifier id = ModelIds.getBlockModelId(block);
			blockStateModelGenerator.blockStateCollector
					.accept(VariantsBlockStateSupplier.create(block)
							.coordinate(BlockStateVariantMap.create(Properties.OCCUPIED)
									.register(false, BlockStateVariant.create().put(VariantSettings.MODEL, id))
									.register(true, BlockStateVariant.create().put(VariantSettings.MODEL, id))
							));

			TextureMap textureMap = new TextureMap()
					.put(TextureKey.TEXTURE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + texture))
					.put(TextureKey.PARTICLE, Identifier.ofVanilla("block/oak_planks"));

			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/wool_stool_base")), Optional.of(texture), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(id, textureMap, blockStateModelGenerator.modelCollector);
			blockStateModelGenerator.modelCollector.accept(ModelIds.getItemModelId(block.asItem()), () -> getItemModelJSON(String.valueOf(id), new Vec3d(30, 45, 0), new Vec3d(0, 0, 0), new Vec3d(0.75, 0.75, 0.75)));
		}

		private void registerWoolCushion(BlockStateModelGenerator blockStateModelGenerator, Block block, String texture) {
			Identifier id = ModelIds.getBlockModelId(block);
			blockStateModelGenerator.blockStateCollector
					.accept(VariantsBlockStateSupplier.create(block)
							.coordinate(BlockStateVariantMap.create(Properties.OCCUPIED)
									.register(false, BlockStateVariant.create().put(VariantSettings.MODEL, id))
									.register(true, BlockStateVariant.create().put(VariantSettings.MODEL, id))
							));

			TextureMap textureMap = new TextureMap()
					.put(TextureKey.TEXTURE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + texture))
					.put(TextureKey.PARTICLE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + texture));

			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/cushion_base")), Optional.of(texture), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(id, textureMap, blockStateModelGenerator.modelCollector);
			blockStateModelGenerator.modelCollector.accept(ModelIds.getItemModelId(block.asItem()), () -> getItemModelJSON(String.valueOf(id)));
		}

		private void registerWoolSeat(BlockStateModelGenerator blockStateModelGenerator, Block block, String texture) {
			Identifier normal_id = ModelIds.getBlockModelId(block);
			Identifier inner_id = ModelIds.getBlockSubModelId(block, "_inner");
			Identifier outer_id = ModelIds.getBlockSubModelId(block, "_outer");
			blockStateModelGenerator.blockStateCollector
					.accept(VariantsBlockStateSupplier.create(block)
							.coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_FACING, Properties.STAIR_SHAPE)
									.register(Direction.EAST, StairShape.INNER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, inner_id).put(VariantSettings.Y, VariantSettings.Rotation.R270))
									.register(Direction.EAST, StairShape.INNER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, inner_id))
									.register(Direction.EAST, StairShape.OUTER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, outer_id).put(VariantSettings.Y, VariantSettings.Rotation.R270))
									.register(Direction.EAST, StairShape.OUTER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, outer_id))
									.register(Direction.EAST, StairShape.STRAIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, normal_id))
									.register(Direction.NORTH, StairShape.INNER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, inner_id).put(VariantSettings.Y, VariantSettings.Rotation.R180))
									.register(Direction.NORTH, StairShape.INNER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, inner_id).put(VariantSettings.Y, VariantSettings.Rotation.R270))
									.register(Direction.NORTH, StairShape.OUTER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, outer_id).put(VariantSettings.Y, VariantSettings.Rotation.R180))
									.register(Direction.NORTH, StairShape.OUTER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, outer_id).put(VariantSettings.Y, VariantSettings.Rotation.R270))
									.register(Direction.NORTH, StairShape.STRAIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, normal_id).put(VariantSettings.Y, VariantSettings.Rotation.R270))
									.register(Direction.SOUTH, StairShape.INNER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, inner_id))
									.register(Direction.SOUTH, StairShape.INNER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, inner_id).put(VariantSettings.Y, VariantSettings.Rotation.R90))
									.register(Direction.SOUTH, StairShape.OUTER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, outer_id))
									.register(Direction.SOUTH, StairShape.OUTER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, outer_id).put(VariantSettings.Y, VariantSettings.Rotation.R90))
									.register(Direction.SOUTH, StairShape.STRAIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, normal_id).put(VariantSettings.Y, VariantSettings.Rotation.R90))
									.register(Direction.WEST, StairShape.INNER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, inner_id).put(VariantSettings.Y, VariantSettings.Rotation.R90))
									.register(Direction.WEST, StairShape.INNER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, inner_id).put(VariantSettings.Y, VariantSettings.Rotation.R180))
									.register(Direction.WEST, StairShape.OUTER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, outer_id).put(VariantSettings.Y, VariantSettings.Rotation.R90))
									.register(Direction.WEST, StairShape.OUTER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, outer_id).put(VariantSettings.Y, VariantSettings.Rotation.R180))
									.register(Direction.WEST, StairShape.STRAIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, normal_id).put(VariantSettings.Y, VariantSettings.Rotation.R180))
							));

			TextureMap textureMap = new TextureMap()
					.put(TextureKey.TEXTURE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/" + texture))
					.put(TextureKey.PARTICLE, Identifier.ofVanilla("block/oak_planks"));

			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/wool_seat_base")), Optional.of(texture), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(normal_id, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/wool_seat_inner_base")), Optional.of(texture), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(inner_id, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(PucksBuildingAdditions.MOD_ID, "block/wool_seat_outer_base")), Optional.of(texture), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(outer_id, textureMap, blockStateModelGenerator.modelCollector);
			blockStateModelGenerator.modelCollector.accept(ModelIds.getItemModelId(block.asItem()), () -> getItemModelJSON(String.valueOf(normal_id)));
		}
	}
}
