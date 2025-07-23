package sirstotes.pucks_building_additions;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.*;
import net.minecraft.block.enums.*;
import net.minecraft.client.data.*;
import net.minecraft.client.render.item.model.special.DecoratedPotModelRenderer;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.DynamicEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.CopyComponentsLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static sirstotes.pucks_building_additions.PucksBuildingAdditions.MOD_ID;
import static sirstotes.pucks_building_additions.PucksBuildingAdditionsBlocks.*;

public class PucksBuildingAdditionsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(BlockLootTableProvider::new);
		pack.addProvider(ModelGenerator::new);
		pack.addProvider(RecipeProvider::new);
		pack.addProvider(ItemTagGenerator::new);
		pack.addProvider(BlockTagGenerator::new);
	}
	private static class BlockLootTableProvider extends FabricBlockLootTableProvider {

		protected BlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
			super(dataOutput, registryLookup);
		}

		@Override
		public void generate() {
			addDrop(OAK_BENCH, drops(OAK_BENCH));
			addDrop(OAK_SEAT, drops(OAK_SEAT));
			addDrop(OAK_STOOL, drops(OAK_STOOL));
			addDrop(SPRUCE_BENCH, drops(SPRUCE_BENCH));
			addDrop(SPRUCE_SEAT, drops(SPRUCE_SEAT));
			addDrop(SPRUCE_STOOL, drops(SPRUCE_STOOL));
			addDrop(BIRCH_BENCH, drops(BIRCH_BENCH));
			addDrop(BIRCH_SEAT, drops(BIRCH_SEAT));
			addDrop(BIRCH_STOOL, drops(BIRCH_STOOL));
			addDrop(JUNGLE_BENCH, drops(JUNGLE_BENCH));
			addDrop(JUNGLE_SEAT, drops(JUNGLE_SEAT));
			addDrop(JUNGLE_STOOL, drops(JUNGLE_STOOL));
			addDrop(ACACIA_BENCH, drops(ACACIA_BENCH));
			addDrop(ACACIA_SEAT, drops(ACACIA_SEAT));
			addDrop(ACACIA_STOOL, drops(ACACIA_STOOL));
			addDrop(DARK_OAK_BENCH, drops(DARK_OAK_BENCH));
			addDrop(DARK_OAK_SEAT, drops(DARK_OAK_SEAT));
			addDrop(DARK_OAK_STOOL, drops(DARK_OAK_STOOL));
			addDrop(MANGROVE_BENCH, drops(MANGROVE_BENCH));
			addDrop(MANGROVE_SEAT, drops(MANGROVE_SEAT));
			addDrop(MANGROVE_STOOL, drops(MANGROVE_STOOL));
			addDrop(CHERRY_BENCH, drops(CHERRY_BENCH));
			addDrop(CHERRY_SEAT, drops(CHERRY_SEAT));
			addDrop(CHERRY_STOOL, drops(CHERRY_STOOL));
			addDrop(PALE_OAK_BENCH, drops(PALE_OAK_BENCH));
			addDrop(PALE_OAK_SEAT, drops(PALE_OAK_SEAT));
			addDrop(PALE_OAK_STOOL, drops(PALE_OAK_STOOL));
			addDrop(CRIMSON_BENCH, drops(CRIMSON_BENCH));
			addDrop(CRIMSON_SEAT, drops(CRIMSON_SEAT));
			addDrop(CRIMSON_STOOL, drops(CRIMSON_STOOL));
			addDrop(WARPED_BENCH, drops(WARPED_BENCH));
			addDrop(WARPED_SEAT, drops(WARPED_SEAT));
			addDrop(WARPED_STOOL, drops(WARPED_STOOL));
			addDrop(BAMBOO_BENCH, drops(BAMBOO_BENCH));
			addDrop(BAMBOO_SEAT, drops(BAMBOO_SEAT));
			addDrop(BAMBOO_STOOL, drops(BAMBOO_STOOL));
			addDrop(RED_CUSHION, drops(RED_CUSHION));
			addDrop(RED_OTTOMAN, drops(RED_OTTOMAN));
			addDrop(RED_SEAT, drops(RED_SEAT));
			addDrop(RED_STOOL, drops(RED_STOOL));
			addDrop(RED_DECORATIVE_CARPET, drops(RED_DECORATIVE_CARPET));
			addDrop(ORANGE_CUSHION, drops(ORANGE_CUSHION));
			addDrop(ORANGE_OTTOMAN, drops(ORANGE_OTTOMAN));
			addDrop(ORANGE_SEAT, drops(ORANGE_SEAT));
			addDrop(ORANGE_STOOL, drops(ORANGE_STOOL));
			addDrop(ORANGE_DECORATIVE_CARPET, drops(ORANGE_DECORATIVE_CARPET));
			addDrop(YELLOW_CUSHION, drops(YELLOW_CUSHION));
			addDrop(YELLOW_OTTOMAN, drops(YELLOW_OTTOMAN));
			addDrop(YELLOW_SEAT, drops(YELLOW_SEAT));
			addDrop(YELLOW_STOOL, drops(YELLOW_STOOL));
			addDrop(YELLOW_DECORATIVE_CARPET, drops(YELLOW_DECORATIVE_CARPET));
			addDrop(LIME_CUSHION, drops(LIME_CUSHION));
			addDrop(LIME_OTTOMAN, drops(LIME_OTTOMAN));
			addDrop(LIME_SEAT, drops(LIME_SEAT));
			addDrop(LIME_STOOL, drops(LIME_STOOL));
			addDrop(LIME_DECORATIVE_CARPET, drops(LIME_DECORATIVE_CARPET));
			addDrop(GREEN_CUSHION, drops(GREEN_CUSHION));
			addDrop(GREEN_OTTOMAN, drops(GREEN_OTTOMAN));
			addDrop(GREEN_SEAT, drops(GREEN_SEAT));
			addDrop(GREEN_STOOL, drops(GREEN_STOOL));
			addDrop(GREEN_DECORATIVE_CARPET, drops(GREEN_DECORATIVE_CARPET));
			addDrop(CYAN_CUSHION, drops(CYAN_CUSHION));
			addDrop(CYAN_OTTOMAN, drops(CYAN_OTTOMAN));
			addDrop(CYAN_SEAT, drops(CYAN_SEAT));
			addDrop(CYAN_STOOL, drops(CYAN_STOOL));
			addDrop(CYAN_DECORATIVE_CARPET, drops(CYAN_DECORATIVE_CARPET));
			addDrop(LIGHT_BLUE_CUSHION, drops(LIGHT_BLUE_CUSHION));
			addDrop(LIGHT_BLUE_OTTOMAN, drops(LIGHT_BLUE_OTTOMAN));
			addDrop(LIGHT_BLUE_SEAT, drops(LIGHT_BLUE_SEAT));
			addDrop(LIGHT_BLUE_STOOL, drops(LIGHT_BLUE_STOOL));
			addDrop(LIGHT_BLUE_DECORATIVE_CARPET, drops(LIGHT_BLUE_DECORATIVE_CARPET));
			addDrop(BLUE_CUSHION, drops(BLUE_CUSHION));
			addDrop(BLUE_OTTOMAN, drops(BLUE_OTTOMAN));
			addDrop(BLUE_SEAT, drops(BLUE_SEAT));
			addDrop(BLUE_STOOL, drops(BLUE_STOOL));
			addDrop(BLUE_DECORATIVE_CARPET, drops(BLUE_DECORATIVE_CARPET));
			addDrop(PURPLE_CUSHION, drops(PURPLE_CUSHION));
			addDrop(PURPLE_OTTOMAN, drops(PURPLE_OTTOMAN));
			addDrop(PURPLE_SEAT, drops(PURPLE_SEAT));
			addDrop(PURPLE_STOOL, drops(PURPLE_STOOL));
			addDrop(PURPLE_DECORATIVE_CARPET, drops(PURPLE_DECORATIVE_CARPET));
			addDrop(MAGENTA_CUSHION, drops(MAGENTA_CUSHION));
			addDrop(MAGENTA_OTTOMAN, drops(MAGENTA_OTTOMAN));
			addDrop(MAGENTA_SEAT, drops(MAGENTA_SEAT));
			addDrop(MAGENTA_STOOL, drops(MAGENTA_STOOL));
			addDrop(MAGENTA_DECORATIVE_CARPET, drops(MAGENTA_DECORATIVE_CARPET));
			addDrop(PINK_CUSHION, drops(PINK_CUSHION));
			addDrop(PINK_OTTOMAN, drops(PINK_OTTOMAN));
			addDrop(PINK_SEAT, drops(PINK_SEAT));
			addDrop(PINK_STOOL, drops(PINK_STOOL));
			addDrop(PINK_DECORATIVE_CARPET, drops(PINK_DECORATIVE_CARPET));
			addDrop(BROWN_CUSHION, drops(BROWN_CUSHION));
			addDrop(BROWN_OTTOMAN, drops(BROWN_OTTOMAN));
			addDrop(BROWN_SEAT, drops(BROWN_SEAT));
			addDrop(BROWN_STOOL, drops(BROWN_STOOL));
			addDrop(BROWN_DECORATIVE_CARPET, drops(BROWN_DECORATIVE_CARPET));
			addDrop(WHITE_CUSHION, drops(WHITE_CUSHION));
			addDrop(WHITE_OTTOMAN, drops(WHITE_OTTOMAN));
			addDrop(WHITE_SEAT, drops(WHITE_SEAT));
			addDrop(WHITE_STOOL, drops(WHITE_STOOL));
			addDrop(WHITE_DECORATIVE_CARPET, drops(WHITE_DECORATIVE_CARPET));
			addDrop(LIGHT_GRAY_CUSHION, drops(LIGHT_GRAY_CUSHION));
			addDrop(LIGHT_GRAY_OTTOMAN, drops(LIGHT_GRAY_OTTOMAN));
			addDrop(LIGHT_GRAY_SEAT, drops(LIGHT_GRAY_SEAT));
			addDrop(LIGHT_GRAY_STOOL, drops(LIGHT_GRAY_STOOL));
			addDrop(LIGHT_GRAY_DECORATIVE_CARPET, drops(LIGHT_GRAY_DECORATIVE_CARPET));
			addDrop(GRAY_CUSHION, drops(GRAY_CUSHION));
			addDrop(GRAY_OTTOMAN, drops(GRAY_OTTOMAN));
			addDrop(GRAY_SEAT, drops(GRAY_SEAT));
			addDrop(GRAY_STOOL, drops(GRAY_STOOL));
			addDrop(GRAY_DECORATIVE_CARPET, drops(GRAY_DECORATIVE_CARPET));
			addDrop(BLACK_CUSHION, drops(BLACK_CUSHION));
			addDrop(BLACK_OTTOMAN, drops(BLACK_OTTOMAN));
			addDrop(BLACK_SEAT, drops(BLACK_SEAT));
			addDrop(BLACK_STOOL, drops(BLACK_STOOL));
			addDrop(BLACK_DECORATIVE_CARPET, drops(BLACK_DECORATIVE_CARPET));
			addDrop(GLOWSTONE_BUTTON, drops(GLOWSTONE_BUTTON));
			addDrop(PEARLESCENT_FROGLIGHT_BUTTON, drops(PEARLESCENT_FROGLIGHT_BUTTON));
			addDrop(VERDANT_FROGLIGHT_BUTTON, drops(VERDANT_FROGLIGHT_BUTTON));
			addDrop(OCHRE_FROGLIGHT_BUTTON, drops(OCHRE_FROGLIGHT_BUTTON));
			addDrop(REDSTONE_LAMP_BUTTON, drops(REDSTONE_LAMP_BUTTON));
			addDrop(SEA_LANTERN_BUTTON, drops(SEA_LANTERN_BUTTON));
			addDrop(SHROOMLIGHT_BUTTON, drops(SHROOMLIGHT_BUTTON));
			addDrop(COPPER_BUTTON, drops(COPPER_BUTTON));
			addDrop(EXPOSED_COPPER_BUTTON, drops(EXPOSED_COPPER_BUTTON));
			addDrop(WEATHERED_COPPER_BUTTON, drops(WEATHERED_COPPER_BUTTON));
			addDrop(OXIDIZED_COPPER_BUTTON, drops(OXIDIZED_COPPER_BUTTON));
			addDrop(OBSIDIAN_BUTTON, drops(OBSIDIAN_BUTTON));
			addDrop(PAPER_BLOCK, drops(PAPER_BLOCK));
			addDrop(WAXED_PAPER_BLOCK, drops(WAXED_PAPER_BLOCK));
			addDrop(PAPER_PANEL, drops(PAPER_PANEL));
			addDrop(WAXED_PAPER_PANEL, drops(WAXED_PAPER_PANEL));
			addDrop(PAPER_PANEL_BOTTOM, drops(PAPER_PANEL));
			addDrop(WAXED_PAPER_PANEL_BOTTOM, drops(WAXED_PAPER_PANEL));
			addDrop(HORIZONTAL_PAPER_PANEL, drops(HORIZONTAL_PAPER_PANEL));
			addDrop(WAXED_HORIZONTAL_PAPER_PANEL, drops(WAXED_HORIZONTAL_PAPER_PANEL));
			addDrop(HORIZONTAL_PAPER_PANEL_BOTTOM, drops(HORIZONTAL_PAPER_PANEL));
			addDrop(WAXED_HORIZONTAL_PAPER_PANEL_BOTTOM, drops(WAXED_HORIZONTAL_PAPER_PANEL));
			addDrop(PAPER_PANEL_DOOR, this::doorDrops);
			addDrop(HORIZONTAL_PAPER_PANEL_DOOR, this::doorDrops);
			addDrop(COLLAPSED_CARDBOARD, drops(COLLAPSED_CARDBOARD));
			addDrop(WET_COLLAPSED_CARDBOARD, drops(SAWDUST));
			addDropWithSilkTouch(WET_COLLAPSED_CARDBOARD);
			addDrop(CARDBOARD_BLOCK);
			addDrop(CARDBOARD_SLAB);
			addDrop(CARDBOARD_STAIRS);
			addDrop(WAXED_CARDBOARD_BLOCK);
			addDrop(WAXED_CARDBOARD_SLAB);
			addDrop(WAXED_CARDBOARD_STAIRS);
			addDrop(WET_CARDBOARD_BLOCK, drops(SAWDUST));
			addDrop(WET_CARDBOARD_SLAB, drops(SAWDUST));
			addDrop(WET_CARDBOARD_STAIRS, drops(SAWDUST));
			addDropWithSilkTouch(WET_CARDBOARD_BLOCK);
			addDropWithSilkTouch(WET_CARDBOARD_SLAB);
			addDropWithSilkTouch(WET_CARDBOARD_STAIRS);
			addDrop(CARDBOARD_GATE);
			addDrop(WAXED_CARDBOARD_GATE);
			addDrop(WET_CARDBOARD_GATE, drops(SAWDUST));
			addDropWithSilkTouch(WET_CARDBOARD_GATE);
			addDrop(CARDBOARD_BOX, drops(CARDBOARD_BOX));
			addDrop(WAXED_CARDBOARD_BOX, drops(WAXED_CARDBOARD_BOX));
			addDrop(WET_CARDBOARD_BOX, drops(SAWDUST));
			addDropWithSilkTouch(WET_CARDBOARD_BOX);
			addDrop(CARDBOARD_DOOR, this::doorDrops);
			addDrop(WAXED_CARDBOARD_DOOR, this::doorDrops);
			addDrop(WET_CARDBOARD_DOOR, drops(SAWDUST));
			addDrop(CARDBOARD_PANE, drops(CARDBOARD_PANE));
			addDrop(WAXED_CARDBOARD_PANE, drops(WAXED_CARDBOARD_PANE));
			addDrop(WET_CARDBOARD_PANE, drops(SAWDUST));
			addDropWithSilkTouch(WET_CARDBOARD_PANE);
			addDrop(CARDBOARD_TRAPDOOR, drops(CARDBOARD_TRAPDOOR));
			addDrop(WAXED_CARDBOARD_TRAPDOOR, drops(WAXED_CARDBOARD_TRAPDOOR));
			addDrop(WET_CARDBOARD_TRAPDOOR, drops(SAWDUST));
			addDropWithSilkTouch(WET_CARDBOARD_TRAPDOOR);
			addDrop(CARDBOARD_SLAB, slabDrops(CARDBOARD_SLAB));
			addDrop(WAXED_CARDBOARD_SLAB, slabDrops(WAXED_CARDBOARD_SLAB));
			addDrop(WET_CARDBOARD_SLAB, slabDrops(SAWDUST));
			addDropWithSilkTouch(WET_CARDBOARD_SLAB);
			addDrop(CARDBOARD_STAIRS, drops(CARDBOARD_STAIRS));
			addDrop(WAXED_CARDBOARD_STAIRS, drops(WAXED_CARDBOARD_STAIRS));
			addDrop(WET_CARDBOARD_STAIRS, drops(SAWDUST));
			addDropWithSilkTouch(WET_CARDBOARD_STAIRS);
			addDrop(RED_DYE_GLOWING, drops(Items.RED_DYE));
			addDrop(RED_DYE_GLOWING, drops(Items.GLOW_INK_SAC));
			addDrop(ORANGE_DYE_GLOWING, drops(Items.ORANGE_DYE));
			addDrop(ORANGE_DYE_GLOWING, drops(Items.GLOW_INK_SAC));
			addDrop(YELLOW_DYE_GLOWING, drops(Items.YELLOW_DYE));
			addDrop(YELLOW_DYE_GLOWING, drops(Items.GLOW_INK_SAC));
			addDrop(LIME_DYE_GLOWING, drops(Items.LIME_DYE));
			addDrop(LIME_DYE_GLOWING, drops(Items.GLOW_INK_SAC));
			addDrop(GREEN_DYE_GLOWING, drops(Items.GREEN_DYE));
			addDrop(GREEN_DYE_GLOWING, drops(Items.GLOW_INK_SAC));
			addDrop(CYAN_DYE_GLOWING, drops(Items.CYAN_DYE));
			addDrop(CYAN_DYE_GLOWING, drops(Items.GLOW_INK_SAC));
			addDrop(LIGHT_BLUE_DYE_GLOWING, drops(Items.LIGHT_BLUE_DYE));
			addDrop(LIGHT_BLUE_DYE_GLOWING, drops(Items.GLOW_INK_SAC));
			addDrop(BLUE_DYE_GLOWING, drops(Items.BLUE_DYE));
			addDrop(BLUE_DYE_GLOWING, drops(Items.GLOW_INK_SAC));
			addDrop(PURPLE_DYE_GLOWING, drops(Items.PURPLE_DYE));
			addDrop(PURPLE_DYE_GLOWING, drops(Items.GLOW_INK_SAC));
			addDrop(MAGENTA_DYE_GLOWING, drops(Items.MAGENTA_DYE));
			addDrop(MAGENTA_DYE_GLOWING, drops(Items.GLOW_INK_SAC));
			addDrop(PINK_DYE_GLOWING, drops(Items.PINK_DYE));
			addDrop(PINK_DYE_GLOWING, drops(Items.GLOW_INK_SAC));
			addDrop(BROWN_DYE_GLOWING, drops(Items.BROWN_DYE));
			addDrop(BROWN_DYE_GLOWING, drops(Items.GLOW_INK_SAC));
			addDrop(WHITE_DYE_GLOWING, drops(Items.WHITE_DYE));
			addDrop(WHITE_DYE_GLOWING, drops(Items.GLOW_INK_SAC));
			addDrop(LIGHT_GRAY_DYE_GLOWING, drops(Items.LIGHT_GRAY_DYE));
			addDrop(LIGHT_GRAY_DYE_GLOWING, drops(Items.GLOW_INK_SAC));
			addDrop(GRAY_DYE_GLOWING, drops(Items.GRAY_DYE));
			addDrop(GRAY_DYE_GLOWING, drops(Items.GLOW_INK_SAC));
			addDrop(BLACK_DYE_GLOWING, drops(Items.BLACK_DYE));
			addDrop(BLACK_DYE_GLOWING, drops(Items.GLOW_INK_SAC));
			addDrop(RED_DYE, drops(Items.RED_DYE));
			addDrop(ORANGE_DYE, drops(Items.ORANGE_DYE));
			addDrop(YELLOW_DYE, drops(Items.YELLOW_DYE));
			addDrop(LIME_DYE, drops(Items.LIME_DYE));
			addDrop(GREEN_DYE, drops(Items.GREEN_DYE));
			addDrop(CYAN_DYE, drops(Items.CYAN_DYE));
			addDrop(LIGHT_BLUE_DYE, drops(Items.LIGHT_BLUE_DYE));
			addDrop(BLUE_DYE, drops(Items.BLUE_DYE));
			addDrop(PURPLE_DYE, drops(Items.PURPLE_DYE));
			addDrop(MAGENTA_DYE, drops(Items.MAGENTA_DYE));
			addDrop(PINK_DYE, drops(Items.PINK_DYE));
			addDrop(BROWN_DYE, drops(Items.BROWN_DYE));
			addDrop(WHITE_DYE, drops(Items.WHITE_DYE));
			addDrop(LIGHT_GRAY_DYE, drops(Items.LIGHT_GRAY_DYE));
			addDrop(GRAY_DYE, drops(Items.GRAY_DYE));
			addDrop(BLACK_DYE, drops(Items.BLACK_DYE));
			addDrop(CarpetsToStairs.get(Blocks.RED_CARPET), drops(Blocks.RED_CARPET));
			addDrop(CarpetsToStairs.get(Blocks.ORANGE_CARPET), drops(Blocks.ORANGE_CARPET));
			addDrop(CarpetsToStairs.get(Blocks.YELLOW_CARPET), drops(Blocks.YELLOW_CARPET));
			addDrop(CarpetsToStairs.get(Blocks.LIME_CARPET), drops(Blocks.LIME_CARPET));
			addDrop(CarpetsToStairs.get(Blocks.GREEN_CARPET), drops(Blocks.GREEN_CARPET));
			addDrop(CarpetsToStairs.get(Blocks.CYAN_CARPET), drops(Blocks.CYAN_CARPET));
			addDrop(CarpetsToStairs.get(Blocks.LIGHT_BLUE_CARPET), drops(Blocks.LIGHT_BLUE_CARPET));
			addDrop(CarpetsToStairs.get(Blocks.BLUE_CARPET), drops(Blocks.BLUE_CARPET));
			addDrop(CarpetsToStairs.get(Blocks.PURPLE_CARPET), drops(Blocks.PURPLE_CARPET));
			addDrop(CarpetsToStairs.get(Blocks.MAGENTA_CARPET), drops(Blocks.MAGENTA_CARPET));
			addDrop(CarpetsToStairs.get(Blocks.PINK_CARPET), drops(Blocks.PINK_CARPET));
			addDrop(CarpetsToStairs.get(Blocks.BROWN_CARPET), drops(Blocks.BROWN_CARPET));
			addDrop(CarpetsToStairs.get(Blocks.WHITE_CARPET), drops(Blocks.WHITE_CARPET));
			addDrop(CarpetsToStairs.get(Blocks.LIGHT_GRAY_CARPET), drops(Blocks.LIGHT_GRAY_CARPET));
			addDrop(CarpetsToStairs.get(Blocks.GRAY_CARPET), drops(Blocks.GRAY_CARPET));
			addDrop(CarpetsToStairs.get(Blocks.BLACK_CARPET), drops(Blocks.BLACK_CARPET));
			addDrop(SAWDUST, drops(SAWDUST));
			addDrop(GLOWSTONE_DUST, drops(Items.GLOWSTONE_DUST));
			addDrop(BLAZE_POWDER, drops(Items.BLAZE_POWDER));
			addDrop(SUGAR, drops(Items.SUGAR));
			addDrop(GUNPOWDER, drops(Items.GUNPOWDER));
			addColoredPottedPlantDrops(HANGING_FLOWER_POTS);
			addColoredPottedPlantDrops(LARGE_FLOWER_POTS);
			addDrop(RED_DECORATED_POT, this::decoratedPotDrops);
			addColoredPottedPlantDrops(RED_FLOWER_POTS);
			addColoredPottedPlantDrops(RED_HANGING_FLOWER_POTS);
			addColoredPottedPlantDrops(RED_LARGE_FLOWER_POTS);
			addDrop(ORANGE_DECORATED_POT, this::decoratedPotDrops);
			addColoredPottedPlantDrops(ORANGE_FLOWER_POTS);
			addColoredPottedPlantDrops(ORANGE_HANGING_FLOWER_POTS);
			addColoredPottedPlantDrops(ORANGE_LARGE_FLOWER_POTS);
			addDrop(YELLOW_DECORATED_POT, this::decoratedPotDrops);
			addColoredPottedPlantDrops(YELLOW_FLOWER_POTS);
			addColoredPottedPlantDrops(YELLOW_HANGING_FLOWER_POTS);
			addColoredPottedPlantDrops(YELLOW_LARGE_FLOWER_POTS);
			addDrop(LIME_DECORATED_POT, this::decoratedPotDrops);
			addColoredPottedPlantDrops(LIME_FLOWER_POTS);
			addColoredPottedPlantDrops(LIME_HANGING_FLOWER_POTS);
			addColoredPottedPlantDrops(LIME_LARGE_FLOWER_POTS);
			addDrop(GREEN_DECORATED_POT, this::decoratedPotDrops);
			addColoredPottedPlantDrops(GREEN_FLOWER_POTS);
			addColoredPottedPlantDrops(GREEN_HANGING_FLOWER_POTS);
			addColoredPottedPlantDrops(GREEN_LARGE_FLOWER_POTS);
			addDrop(CYAN_DECORATED_POT, this::decoratedPotDrops);
			addColoredPottedPlantDrops(CYAN_FLOWER_POTS);
			addColoredPottedPlantDrops(CYAN_HANGING_FLOWER_POTS);
			addColoredPottedPlantDrops(CYAN_LARGE_FLOWER_POTS);
			addDrop(LIGHT_BLUE_DECORATED_POT, this::decoratedPotDrops);
			addColoredPottedPlantDrops(LIGHT_BLUE_FLOWER_POTS);
			addColoredPottedPlantDrops(LIGHT_BLUE_HANGING_FLOWER_POTS);
			addColoredPottedPlantDrops(LIGHT_BLUE_LARGE_FLOWER_POTS);
			addDrop(BLUE_DECORATED_POT, this::decoratedPotDrops);
			addColoredPottedPlantDrops(BLUE_FLOWER_POTS);
			addColoredPottedPlantDrops(BLUE_HANGING_FLOWER_POTS);
			addColoredPottedPlantDrops(BLUE_LARGE_FLOWER_POTS);
			addDrop(PURPLE_DECORATED_POT, this::decoratedPotDrops);
			addColoredPottedPlantDrops(PURPLE_FLOWER_POTS);
			addColoredPottedPlantDrops(PURPLE_HANGING_FLOWER_POTS);
			addColoredPottedPlantDrops(PURPLE_LARGE_FLOWER_POTS);
			addDrop(MAGENTA_DECORATED_POT, this::decoratedPotDrops);
			addColoredPottedPlantDrops(MAGENTA_FLOWER_POTS);
			addColoredPottedPlantDrops(MAGENTA_HANGING_FLOWER_POTS);
			addColoredPottedPlantDrops(MAGENTA_LARGE_FLOWER_POTS);
			addDrop(PINK_DECORATED_POT, this::decoratedPotDrops);
			addColoredPottedPlantDrops(PINK_FLOWER_POTS);
			addColoredPottedPlantDrops(PINK_HANGING_FLOWER_POTS);
			addColoredPottedPlantDrops(PINK_LARGE_FLOWER_POTS);
			addDrop(BROWN_DECORATED_POT, this::decoratedPotDrops);
			addColoredPottedPlantDrops(BROWN_FLOWER_POTS);
			addColoredPottedPlantDrops(BROWN_HANGING_FLOWER_POTS);
			addColoredPottedPlantDrops(BROWN_LARGE_FLOWER_POTS);
			addDrop(WHITE_DECORATED_POT, this::decoratedPotDrops);
			addColoredPottedPlantDrops(WHITE_FLOWER_POTS);
			addColoredPottedPlantDrops(WHITE_HANGING_FLOWER_POTS);
			addColoredPottedPlantDrops(WHITE_LARGE_FLOWER_POTS);
			addDrop(LIGHT_GRAY_DECORATED_POT, this::decoratedPotDrops);
			addColoredPottedPlantDrops(LIGHT_GRAY_FLOWER_POTS);
			addColoredPottedPlantDrops(LIGHT_GRAY_HANGING_FLOWER_POTS);
			addColoredPottedPlantDrops(LIGHT_GRAY_LARGE_FLOWER_POTS);
			addDrop(GRAY_DECORATED_POT, this::decoratedPotDrops);
			addColoredPottedPlantDrops(GRAY_FLOWER_POTS);
			addColoredPottedPlantDrops(GRAY_HANGING_FLOWER_POTS);
			addColoredPottedPlantDrops(GRAY_LARGE_FLOWER_POTS);
			addDrop(BLACK_DECORATED_POT, this::decoratedPotDrops);
			addColoredPottedPlantDrops(BLACK_FLOWER_POTS);
			addColoredPottedPlantDrops(BLACK_HANGING_FLOWER_POTS);
			addColoredPottedPlantDrops(BLACK_LARGE_FLOWER_POTS);
		}
		private LootTable.Builder decoratedPotDrops(Block block) {
			return LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with((DynamicEntry.builder(DecoratedPotBlock.SHERDS_DYNAMIC_DROP_ID).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(DecoratedPotBlock.CRACKED, true)))).alternatively(ItemEntry.builder(block).apply(CopyComponentsLootFunction.builder(CopyComponentsLootFunction.Source.BLOCK_ENTITY).include(DataComponentTypes.POT_DECORATIONS)))));
		}
		public void addColoredPottedPlantDrops(ColoredFlowerPotBlock[] blocks) {
			for (ColoredFlowerPotBlock block : blocks) {
				if (block.isEmpty()) {
					this.addDrop(block);
				} else {
					//this.addDrop(block, this.coloredPottedPlantDrops(block, block.getContent()));
					this.addDrop(block, drops(block.getContent()));
				}
			}
		}
		public final LootTable.Builder coloredPottedPlantDrops(ItemConvertible container, ItemConvertible drop) {
			return LootTable.builder().pool(this.addSurvivesExplosionCondition(container, LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(ItemEntry.builder(container))))
										.pool(this.addSurvivesExplosionCondition(drop, LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(ItemEntry.builder(drop))));
		}
	}

	private static class ModelGenerator extends FabricModelProvider {
		public Model SpecialSlab = new Model(Optional.of(Identifier.of(MOD_ID, "block/special_slab_base")), Optional.of("bottom"), TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.FRONT);
		public Model SpecialSlabTop = new Model(Optional.of(Identifier.of(MOD_ID, "block/special_slab_top_base")), Optional.of("top"), TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.FRONT);
		public Model SpecialCube = new Model(Optional.of(Identifier.of(MOD_ID, "block/cardboard_box_base")), Optional.empty(), TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.FRONT);
		public Model SpecialStairs = new Model(Optional.of(Identifier.of(MOD_ID, "block/special_stairs_base")), Optional.empty(), TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.FRONT, TextureKey.END, TextureKey.BACK);
		public Model SpecialStairsInner = new Model(Optional.of(Identifier.of(MOD_ID, "block/special_stairs_inner_base")), Optional.of("inner"), TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.FRONT, TextureKey.END, TextureKey.BACK);
		public Model SpecialStairsOuter = new Model(Optional.of(Identifier.of(MOD_ID, "block/special_stairs_outer_base")), Optional.of("outer"), TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.FRONT, TextureKey.END);

		private ModelGenerator(FabricDataOutput generator) {
			super(generator);
		}
		@Override
		public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
			registerSideTopBench(blockStateModelGenerator, OAK_BENCH, "oak_bench", "minecraft:block/stripped_oak_log_top", "minecraft:block/stripped_oak_log");
			registerSideTopBench(blockStateModelGenerator, SPRUCE_BENCH, "spruce_bench", "minecraft:block/stripped_spruce_log_top", "minecraft:block/stripped_spruce_log");
			registerSideTopBench(blockStateModelGenerator, BIRCH_BENCH, "birch_bench", "minecraft:block/stripped_birch_log_top", "minecraft:block/stripped_birch_log");
			registerSideTopBench(blockStateModelGenerator, JUNGLE_BENCH, "jungle_bench", "minecraft:block/stripped_jungle_log_top", "minecraft:block/stripped_jungle_log");
			registerSideTopBench(blockStateModelGenerator, ACACIA_BENCH, "acacia_bench", "minecraft:block/stripped_acacia_log_top", "minecraft:block/stripped_acacia_log");
			registerSideTopBench(blockStateModelGenerator, DARK_OAK_BENCH, "dark_oak_bench", "minecraft:block/stripped_dark_oak_log_top", "minecraft:block/stripped_dark_oak_log");
			registerSideTopBench(blockStateModelGenerator, MANGROVE_BENCH, "mangrove_bench", "minecraft:block/stripped_mangrove_log_top", "minecraft:block/stripped_mangrove_log");
			registerSideTopBench(blockStateModelGenerator, CHERRY_BENCH, "cherry_bench", "minecraft:block/stripped_cherry_log_top", "minecraft:block/stripped_cherry_log");
			registerSideTopBench(blockStateModelGenerator, PALE_OAK_BENCH, "pale_oak_bench", "minecraft:block/stripped_pale_oak_log_top", "minecraft:block/stripped_pale_oak_log");
			registerSideTopBench(blockStateModelGenerator, CRIMSON_BENCH, "crimson_bench", "minecraft:block/stripped_crimson_stem_top", "minecraft:block/stripped_crimson_stem");
			registerSideTopBench(blockStateModelGenerator, WARPED_BENCH, "warped_bench", "minecraft:block/stripped_warped_stem_top", "minecraft:block/stripped_warped_stem");
			registerSideTopBench(blockStateModelGenerator, BAMBOO_BENCH, "bamboo_bench", "minecraft:block/bamboo_block_top", "minecraft:block/bamboo_block");

			registerSideTopStool(blockStateModelGenerator, OAK_STOOL, "oak_stool", "minecraft:block/stripped_oak_log_top", "minecraft:block/oak_planks");
			registerSideTopStool(blockStateModelGenerator, SPRUCE_STOOL, "spruce_stool", "minecraft:block/stripped_spruce_log_top", "minecraft:block/spruce_planks");
			registerSideTopStool(blockStateModelGenerator, BIRCH_STOOL, "birch_stool", "minecraft:block/stripped_birch_log_top", "minecraft:block/birch_planks");
			registerSideTopStool(blockStateModelGenerator, JUNGLE_STOOL, "jungle_stool", "minecraft:block/stripped_jungle_log_top", "minecraft:block/jungle_planks");
			registerSideTopStool(blockStateModelGenerator, ACACIA_STOOL, "acacia_stool", "minecraft:block/stripped_acacia_log_top", "minecraft:block/acacia_planks");
			registerSideTopStool(blockStateModelGenerator, DARK_OAK_STOOL, "dark_oak_stool", "minecraft:block/stripped_dark_oak_log_top", "minecraft:block/dark_oak_planks");
			registerSideTopStool(blockStateModelGenerator, MANGROVE_STOOL, "mangrove_stool", "minecraft:block/stripped_mangrove_log_top", "minecraft:block/mangrove_planks");
			registerSideTopStool(blockStateModelGenerator, CHERRY_STOOL, "cherry_stool", "minecraft:block/stripped_cherry_log_top", "minecraft:block/cherry_planks");
			registerSideTopStool(blockStateModelGenerator, PALE_OAK_STOOL, "pale_oak_stool", "minecraft:block/stripped_pale_oak_log_top", "minecraft:block/pale_oak_planks");
			registerSideTopStool(blockStateModelGenerator, CRIMSON_STOOL, "crimson_stool", "minecraft:block/stripped_crimson_stem_top", "minecraft:block/crimson_planks");
			registerSideTopStool(blockStateModelGenerator, WARPED_STOOL, "warped_stool", "minecraft:block/stripped_warped_stem_top", "minecraft:block/warped_planks");
			registerSideTopStool(blockStateModelGenerator, BAMBOO_STOOL, "bamboo_stool", "minecraft:block/bamboo_block_top", "minecraft:block/bamboo_planks");

			registerSideTopSeat(blockStateModelGenerator, OAK_SEAT, "oak_seat", "minecraft:block/stripped_oak_log_top", "minecraft:block/stripped_oak_log");
			registerSideTopSeat(blockStateModelGenerator, SPRUCE_SEAT, "spruce_seat", "minecraft:block/stripped_spruce_log_top", "minecraft:block/stripped_spruce_log");
			registerSideTopSeat(blockStateModelGenerator, BIRCH_SEAT, "birch_seat", "minecraft:block/stripped_birch_log_top", "minecraft:block/stripped_birch_log");
			registerSideTopSeat(blockStateModelGenerator, JUNGLE_SEAT, "jungle_seat", "minecraft:block/stripped_jungle_log_top", "minecraft:block/stripped_jungle_log");
			registerSideTopSeat(blockStateModelGenerator, ACACIA_SEAT, "acacia_seat", "minecraft:block/stripped_acacia_log_top", "minecraft:block/stripped_acacia_log");
			registerSideTopSeat(blockStateModelGenerator, DARK_OAK_SEAT, "dark_oak_seat", "minecraft:block/stripped_dark_oak_log_top", "minecraft:block/stripped_dark_oak_log");
			registerSideTopSeat(blockStateModelGenerator, MANGROVE_SEAT, "mangrove_seat", "minecraft:block/stripped_mangrove_log_top", "minecraft:block/stripped_mangrove_log");
			registerSideTopSeat(blockStateModelGenerator, CHERRY_SEAT, "cherry_seat", "minecraft:block/stripped_cherry_log_top", "minecraft:block/stripped_cherry_log");
			registerSideTopSeat(blockStateModelGenerator, PALE_OAK_SEAT, "pale_oak_seat", "minecraft:block/stripped_pale_oak_log_top", "minecraft:block/stripped_pale_oak_log");
			registerSideTopSeat(blockStateModelGenerator, CRIMSON_SEAT, "crimson_seat", "minecraft:block/stripped_crimson_stem_top", "minecraft:block/stripped_crimson_stem");
			registerSideTopSeat(blockStateModelGenerator, WARPED_SEAT, "warped_seat", "minecraft:block/stripped_warped_stem_top", "minecraft:block/stripped_warped_stem");
			registerSideTopSeat(blockStateModelGenerator, BAMBOO_SEAT, "bamboo_seat", "minecraft:block/bamboo_block_top", "minecraft:block/bamboo_block");

			registerWoolBench(blockStateModelGenerator, RED_OTTOMAN, "red");
			registerWoolBench(blockStateModelGenerator, ORANGE_OTTOMAN, "orange");
			registerWoolBench(blockStateModelGenerator, YELLOW_OTTOMAN, "yellow");
			registerWoolBench(blockStateModelGenerator, LIME_OTTOMAN, "lime");
			registerWoolBench(blockStateModelGenerator, GREEN_OTTOMAN, "green");
			registerWoolBench(blockStateModelGenerator, CYAN_OTTOMAN, "cyan");
			registerWoolBench(blockStateModelGenerator, LIGHT_BLUE_OTTOMAN, "light_blue");
			registerWoolBench(blockStateModelGenerator, BLUE_OTTOMAN, "blue");
			registerWoolBench(blockStateModelGenerator, PURPLE_OTTOMAN, "purple");
			registerWoolBench(blockStateModelGenerator, MAGENTA_OTTOMAN, "magenta");
			registerWoolBench(blockStateModelGenerator, PINK_OTTOMAN, "pink");
			registerWoolBench(blockStateModelGenerator, BROWN_OTTOMAN, "brown");
			registerWoolBench(blockStateModelGenerator, WHITE_OTTOMAN, "white");
			registerWoolBench(blockStateModelGenerator, LIGHT_GRAY_OTTOMAN, "light_gray");
			registerWoolBench(blockStateModelGenerator, GRAY_OTTOMAN, "gray");
			registerWoolBench(blockStateModelGenerator, BLACK_OTTOMAN, "black");

			registerWoolCushion(blockStateModelGenerator, RED_CUSHION, "red");
			registerWoolCushion(blockStateModelGenerator, ORANGE_CUSHION, "orange");
			registerWoolCushion(blockStateModelGenerator, YELLOW_CUSHION, "yellow");
			registerWoolCushion(blockStateModelGenerator, LIME_CUSHION, "lime");
			registerWoolCushion(blockStateModelGenerator, GREEN_CUSHION, "green");
			registerWoolCushion(blockStateModelGenerator, CYAN_CUSHION, "cyan");
			registerWoolCushion(blockStateModelGenerator, LIGHT_BLUE_CUSHION, "light_blue");
			registerWoolCushion(blockStateModelGenerator, BLUE_CUSHION, "blue");
			registerWoolCushion(blockStateModelGenerator, PURPLE_CUSHION, "purple");
			registerWoolCushion(blockStateModelGenerator, MAGENTA_CUSHION, "magenta");
			registerWoolCushion(blockStateModelGenerator, PINK_CUSHION, "pink");
			registerWoolCushion(blockStateModelGenerator, BROWN_CUSHION, "brown");
			registerWoolCushion(blockStateModelGenerator, WHITE_CUSHION, "white");
			registerWoolCushion(blockStateModelGenerator, LIGHT_GRAY_CUSHION, "light_gray");
			registerWoolCushion(blockStateModelGenerator, GRAY_CUSHION, "gray");
			registerWoolCushion(blockStateModelGenerator, BLACK_CUSHION, "black");

			registerWoolSeat(blockStateModelGenerator, RED_SEAT, "red");
			registerWoolSeat(blockStateModelGenerator, ORANGE_SEAT, "orange");
			registerWoolSeat(blockStateModelGenerator, YELLOW_SEAT, "yellow");
			registerWoolSeat(blockStateModelGenerator, LIME_SEAT, "lime");
			registerWoolSeat(blockStateModelGenerator, GREEN_SEAT, "green");
			registerWoolSeat(blockStateModelGenerator, CYAN_SEAT, "cyan");
			registerWoolSeat(blockStateModelGenerator, LIGHT_BLUE_SEAT, "light_blue");
			registerWoolSeat(blockStateModelGenerator, BLUE_SEAT, "blue");
			registerWoolSeat(blockStateModelGenerator, PURPLE_SEAT, "purple");
			registerWoolSeat(blockStateModelGenerator, MAGENTA_SEAT, "magenta");
			registerWoolSeat(blockStateModelGenerator, PINK_SEAT, "pink");
			registerWoolSeat(blockStateModelGenerator, BROWN_SEAT, "brown");
			registerWoolSeat(blockStateModelGenerator, WHITE_SEAT, "white");
			registerWoolSeat(blockStateModelGenerator, LIGHT_GRAY_SEAT, "light_gray");
			registerWoolSeat(blockStateModelGenerator, GRAY_SEAT, "gray");
			registerWoolSeat(blockStateModelGenerator, BLACK_SEAT, "black");

			registerWoolStool(blockStateModelGenerator, RED_STOOL, "red");
			registerWoolStool(blockStateModelGenerator, ORANGE_STOOL, "orange");
			registerWoolStool(blockStateModelGenerator, YELLOW_STOOL, "yellow");
			registerWoolStool(blockStateModelGenerator, LIME_STOOL, "lime");
			registerWoolStool(blockStateModelGenerator, GREEN_STOOL, "green");
			registerWoolStool(blockStateModelGenerator, CYAN_STOOL, "cyan");
			registerWoolStool(blockStateModelGenerator, LIGHT_BLUE_STOOL, "light_blue");
			registerWoolStool(blockStateModelGenerator, BLUE_STOOL, "blue");
			registerWoolStool(blockStateModelGenerator, PURPLE_STOOL, "purple");
			registerWoolStool(blockStateModelGenerator, MAGENTA_STOOL, "magenta");
			registerWoolStool(blockStateModelGenerator, PINK_STOOL, "pink");
			registerWoolStool(blockStateModelGenerator, BROWN_STOOL, "brown");
			registerWoolStool(blockStateModelGenerator, WHITE_STOOL, "white");
			registerWoolStool(blockStateModelGenerator, LIGHT_GRAY_STOOL, "light_gray");
			registerWoolStool(blockStateModelGenerator, GRAY_STOOL, "gray");
			registerWoolStool(blockStateModelGenerator, BLACK_STOOL, "black");

			registerLightButton(blockStateModelGenerator, GLOWSTONE_BUTTON, "glowstone_button", "minecraft:block/glowstone", "pucks_building_additions:block/glowstone_off");
			registerLightButton(blockStateModelGenerator, VERDANT_FROGLIGHT_BUTTON, "verdant_froglight_button", "minecraft:block/verdant_froglight_side", "pucks_building_additions:block/verdant_froglight_off");
			registerLightButton(blockStateModelGenerator, PEARLESCENT_FROGLIGHT_BUTTON, "pearlescent_froglight_button", "minecraft:block/pearlescent_froglight_side", "pucks_building_additions:block/pearlescent_froglight_off");
			registerLightButton(blockStateModelGenerator, OCHRE_FROGLIGHT_BUTTON, "ochre_froglight_button", "minecraft:block/ochre_froglight_side", "pucks_building_additions:block/ochre_froglight_off");
			registerLightButton(blockStateModelGenerator, REDSTONE_LAMP_BUTTON, "redstone_lamp_button", "minecraft:block/redstone_lamp_on", "minecraft:block/redstone_lamp");
			registerLightButton(blockStateModelGenerator, SEA_LANTERN_BUTTON, "sea_lantern_button", "minecraft:block/sea_lantern", "pucks_building_additions:block/sea_lantern_off");
			registerLightButton(blockStateModelGenerator, SHROOMLIGHT_BUTTON, "shroomlight_button", "minecraft:block/shroomlight", "pucks_building_additions:block/shroomlight_off");
			registerLightButton(blockStateModelGenerator, COPPER_BUTTON, "copper_button", "minecraft:block/copper_bulb_lit", "minecraft:block/copper_bulb");
			registerLightButton(blockStateModelGenerator, WEATHERED_COPPER_BUTTON, "weathered_copper_button", "minecraft:block/weathered_copper_bulb_lit", "minecraft:block/weathered_copper_bulb");
			registerLightButton(blockStateModelGenerator, EXPOSED_COPPER_BUTTON, "exposed_copper_button", "minecraft:block/exposed_copper_bulb_lit", "minecraft:block/exposed_copper_bulb");
			registerLightButton(blockStateModelGenerator, OXIDIZED_COPPER_BUTTON, "oxidized_copper_button", "minecraft:block/oxidized_copper_bulb_lit", "minecraft:block/oxidized_copper_bulb");
			registerLightButton(blockStateModelGenerator, OBSIDIAN_BUTTON, "obsidian_button", "minecraft:block/crying_obsidian", "minecraft:block/obsidian");

			registerWire(blockStateModelGenerator, RED_DYE, "red_dye", true);
			registerWire(blockStateModelGenerator, ORANGE_DYE, "orange_dye", true);
			registerWire(blockStateModelGenerator, YELLOW_DYE, "yellow_dye", true);
			registerWire(blockStateModelGenerator, LIME_DYE, "lime_dye", true);
			registerWire(blockStateModelGenerator, GREEN_DYE, "green_dye", true);
			registerWire(blockStateModelGenerator, CYAN_DYE, "cyan_dye", true);
			registerWire(blockStateModelGenerator, LIGHT_BLUE_DYE, "light_blue_dye", true);
			registerWire(blockStateModelGenerator, BLUE_DYE, "blue_dye", true);
			registerWire(blockStateModelGenerator, PURPLE_DYE, "purple_dye", true);
			registerWire(blockStateModelGenerator, MAGENTA_DYE, "magenta_dye", true);
			registerWire(blockStateModelGenerator, PINK_DYE, "pink_dye", true);
			registerWire(blockStateModelGenerator, BROWN_DYE, "brown_dye", true);
			registerWire(blockStateModelGenerator, WHITE_DYE, "white_dye", true);
			registerWire(blockStateModelGenerator, LIGHT_GRAY_DYE, "light_gray_dye", true);
			registerWire(blockStateModelGenerator, GRAY_DYE, "gray_dye", true);
			registerWire(blockStateModelGenerator, BLACK_DYE, "black_dye", true);
			registerWire(blockStateModelGenerator, RED_DYE_GLOWING, "glowing_red_dye", "red_dye", false);
			registerWire(blockStateModelGenerator, ORANGE_DYE_GLOWING, "glowing_orange_dye", "orange_dye", false);
			registerWire(blockStateModelGenerator, YELLOW_DYE_GLOWING, "glowing_yellow_dye", "yellow_dye", false);
			registerWire(blockStateModelGenerator, LIME_DYE_GLOWING, "glowing_lime_dye", "lime_dye", false);
			registerWire(blockStateModelGenerator, GREEN_DYE_GLOWING, "glowing_green_dye", "green_dye", false);
			registerWire(blockStateModelGenerator, CYAN_DYE_GLOWING, "glowing_cyan_dye", "cyan_dye", false);
			registerWire(blockStateModelGenerator, LIGHT_BLUE_DYE_GLOWING, "glowing_light_blue_dye", "light_blue_dye", false);
			registerWire(blockStateModelGenerator, BLUE_DYE_GLOWING, "glowing_blue_dye", "blue_dye", false);
			registerWire(blockStateModelGenerator, PURPLE_DYE_GLOWING, "glowing_purple_dye", "purple_dye", false);
			registerWire(blockStateModelGenerator, MAGENTA_DYE_GLOWING, "glowing_magenta_dye", "magenta_dye", false);
			registerWire(blockStateModelGenerator, PINK_DYE_GLOWING, "glowing_pink_dye", "pink_dye", false);
			registerWire(blockStateModelGenerator, BROWN_DYE_GLOWING, "glowing_brown_dye", "brown_dye", false);
			registerWire(blockStateModelGenerator, WHITE_DYE_GLOWING, "glowing_white_dye", "white_dye", false);
			registerWire(blockStateModelGenerator, LIGHT_GRAY_DYE_GLOWING, "glowing_light_gray_dye", "light_gray_dye", false);
			registerWire(blockStateModelGenerator, GRAY_DYE_GLOWING, "glowing_gray_dye", "gray_dye", false);
			registerWire(blockStateModelGenerator, BLACK_DYE_GLOWING, "glowing_black_dye", "black_dye", false);
			registerDust(blockStateModelGenerator, GLOWSTONE_DUST, "glowstone_dust", false);
			registerDust(blockStateModelGenerator, BLAZE_POWDER, "blaze_powder", false);
			registerDust(blockStateModelGenerator, SUGAR, "sugar", true);
			registerDust(blockStateModelGenerator, GUNPOWDER, "gunpowder", true);
			registerDust(blockStateModelGenerator, SAWDUST, "sawdust", true);

			registerFlowerPots(blockStateModelGenerator, RED_FLOWER_POTS, "red");
			registerFlowerPots(blockStateModelGenerator, ORANGE_FLOWER_POTS, "orange");
			registerFlowerPots(blockStateModelGenerator, YELLOW_FLOWER_POTS, "yellow");
			registerFlowerPots(blockStateModelGenerator, LIME_FLOWER_POTS, "lime");
			registerFlowerPots(blockStateModelGenerator, GREEN_FLOWER_POTS, "green");
			registerFlowerPots(blockStateModelGenerator, CYAN_FLOWER_POTS, "cyan");
			registerFlowerPots(blockStateModelGenerator, LIGHT_BLUE_FLOWER_POTS, "light_blue");
			registerFlowerPots(blockStateModelGenerator, BLUE_FLOWER_POTS, "blue");
			registerFlowerPots(blockStateModelGenerator, PURPLE_FLOWER_POTS, "purple");
			registerFlowerPots(blockStateModelGenerator, MAGENTA_FLOWER_POTS, "magenta");
			registerFlowerPots(blockStateModelGenerator, PINK_FLOWER_POTS, "pink");
			registerFlowerPots(blockStateModelGenerator, BROWN_FLOWER_POTS, "brown");
			registerFlowerPots(blockStateModelGenerator, WHITE_FLOWER_POTS, "white");
			registerFlowerPots(blockStateModelGenerator, LIGHT_GRAY_FLOWER_POTS, "light_gray");
			registerFlowerPots(blockStateModelGenerator, GRAY_FLOWER_POTS, "gray");
			registerFlowerPots(blockStateModelGenerator, BLACK_FLOWER_POTS, "black");

			registerLargeFlowerPots(blockStateModelGenerator, LARGE_FLOWER_POTS, "");
			registerLargeFlowerPots(blockStateModelGenerator, RED_LARGE_FLOWER_POTS, "red_");
			registerLargeFlowerPots(blockStateModelGenerator, ORANGE_LARGE_FLOWER_POTS, "orange_");
			registerLargeFlowerPots(blockStateModelGenerator, YELLOW_LARGE_FLOWER_POTS, "yellow_");
			registerLargeFlowerPots(blockStateModelGenerator, LIME_LARGE_FLOWER_POTS, "lime_");
			registerLargeFlowerPots(blockStateModelGenerator, GREEN_LARGE_FLOWER_POTS, "green_");
			registerLargeFlowerPots(blockStateModelGenerator, CYAN_LARGE_FLOWER_POTS, "cyan_");
			registerLargeFlowerPots(blockStateModelGenerator, LIGHT_BLUE_LARGE_FLOWER_POTS, "light_blue_");
			registerLargeFlowerPots(blockStateModelGenerator, BLUE_LARGE_FLOWER_POTS, "blue_");
			registerLargeFlowerPots(blockStateModelGenerator, PURPLE_LARGE_FLOWER_POTS, "purple_");
			registerLargeFlowerPots(blockStateModelGenerator, MAGENTA_LARGE_FLOWER_POTS, "magenta_");
			registerLargeFlowerPots(blockStateModelGenerator, PINK_LARGE_FLOWER_POTS, "pink_");
			registerLargeFlowerPots(blockStateModelGenerator, BROWN_LARGE_FLOWER_POTS, "brown_");
			registerLargeFlowerPots(blockStateModelGenerator, WHITE_LARGE_FLOWER_POTS, "white_");
			registerLargeFlowerPots(blockStateModelGenerator, LIGHT_GRAY_LARGE_FLOWER_POTS, "light_gray_");
			registerLargeFlowerPots(blockStateModelGenerator, GRAY_LARGE_FLOWER_POTS, "gray_");
			registerLargeFlowerPots(blockStateModelGenerator, BLACK_LARGE_FLOWER_POTS, "black_");

			registerHangingFlowerPots(blockStateModelGenerator, HANGING_FLOWER_POTS, "");
			registerHangingFlowerPots(blockStateModelGenerator, RED_HANGING_FLOWER_POTS, "red_");
			registerHangingFlowerPots(blockStateModelGenerator, ORANGE_HANGING_FLOWER_POTS, "orange_");
			registerHangingFlowerPots(blockStateModelGenerator, YELLOW_HANGING_FLOWER_POTS, "yellow_");
			registerHangingFlowerPots(blockStateModelGenerator, LIME_HANGING_FLOWER_POTS, "lime_");
			registerHangingFlowerPots(blockStateModelGenerator, GREEN_HANGING_FLOWER_POTS, "green_");
			registerHangingFlowerPots(blockStateModelGenerator, CYAN_HANGING_FLOWER_POTS, "cyan_");
			registerHangingFlowerPots(blockStateModelGenerator, LIGHT_BLUE_HANGING_FLOWER_POTS, "light_blue_");
			registerHangingFlowerPots(blockStateModelGenerator, BLUE_HANGING_FLOWER_POTS, "blue_");
			registerHangingFlowerPots(blockStateModelGenerator, PURPLE_HANGING_FLOWER_POTS, "purple_");
			registerHangingFlowerPots(blockStateModelGenerator, MAGENTA_HANGING_FLOWER_POTS, "magenta_");
			registerHangingFlowerPots(blockStateModelGenerator, PINK_HANGING_FLOWER_POTS, "pink_");
			registerHangingFlowerPots(blockStateModelGenerator, BROWN_HANGING_FLOWER_POTS, "brown_");
			registerHangingFlowerPots(blockStateModelGenerator, WHITE_HANGING_FLOWER_POTS, "white_");
			registerHangingFlowerPots(blockStateModelGenerator, LIGHT_GRAY_HANGING_FLOWER_POTS, "light_gray_");
			registerHangingFlowerPots(blockStateModelGenerator, GRAY_HANGING_FLOWER_POTS, "gray_");
			registerHangingFlowerPots(blockStateModelGenerator, BLACK_HANGING_FLOWER_POTS, "black_");

			registerDecoratedPot(blockStateModelGenerator, RED_DECORATED_POT, "red");
			registerDecoratedPot(blockStateModelGenerator, ORANGE_DECORATED_POT, "orange");
			registerDecoratedPot(blockStateModelGenerator, YELLOW_DECORATED_POT, "yellow");
			registerDecoratedPot(blockStateModelGenerator, LIME_DECORATED_POT, "lime");
			registerDecoratedPot(blockStateModelGenerator, GREEN_DECORATED_POT, "green");
			registerDecoratedPot(blockStateModelGenerator, CYAN_DECORATED_POT, "cyan");
			registerDecoratedPot(blockStateModelGenerator, LIGHT_BLUE_DECORATED_POT, "light_blue");
			registerDecoratedPot(blockStateModelGenerator, BLUE_DECORATED_POT, "blue");
			registerDecoratedPot(blockStateModelGenerator, PURPLE_DECORATED_POT, "purple");
			registerDecoratedPot(blockStateModelGenerator, MAGENTA_DECORATED_POT, "magenta");
			registerDecoratedPot(blockStateModelGenerator, PINK_DECORATED_POT, "pink");
			registerDecoratedPot(blockStateModelGenerator, BROWN_DECORATED_POT, "brown");
			registerDecoratedPot(blockStateModelGenerator, WHITE_DECORATED_POT, "white");
			registerDecoratedPot(blockStateModelGenerator, LIGHT_GRAY_DECORATED_POT, "light_gray");
			registerDecoratedPot(blockStateModelGenerator, GRAY_DECORATED_POT, "gray");
			registerDecoratedPot(blockStateModelGenerator, BLACK_DECORATED_POT, "black");

			registerCarpet(blockStateModelGenerator, RED_DECORATIVE_CARPET, "red_decorative_carpet");
			registerCarpet(blockStateModelGenerator, ORANGE_DECORATIVE_CARPET, "orange_decorative_carpet");
			registerCarpet(blockStateModelGenerator, YELLOW_DECORATIVE_CARPET, "yellow_decorative_carpet");
			registerCarpet(blockStateModelGenerator, LIME_DECORATIVE_CARPET, "lime_decorative_carpet");
			registerCarpet(blockStateModelGenerator, GREEN_DECORATIVE_CARPET, "green_decorative_carpet");
			registerCarpet(blockStateModelGenerator, CYAN_DECORATIVE_CARPET, "cyan_decorative_carpet");
			registerCarpet(blockStateModelGenerator, LIGHT_BLUE_DECORATIVE_CARPET, "light_blue_decorative_carpet");
			registerCarpet(blockStateModelGenerator, BLUE_DECORATIVE_CARPET, "blue_decorative_carpet");
			registerCarpet(blockStateModelGenerator, PURPLE_DECORATIVE_CARPET, "purple_decorative_carpet");
			registerCarpet(blockStateModelGenerator, MAGENTA_DECORATIVE_CARPET, "magenta_decorative_carpet");
			registerCarpet(blockStateModelGenerator, PINK_DECORATIVE_CARPET, "pink_decorative_carpet");
			registerCarpet(blockStateModelGenerator, BROWN_DECORATIVE_CARPET, "brown_decorative_carpet");
			registerCarpet(blockStateModelGenerator, WHITE_DECORATIVE_CARPET, "white_decorative_carpet");
			registerCarpet(blockStateModelGenerator, LIGHT_GRAY_DECORATIVE_CARPET, "light_gray_decorative_carpet");
			registerCarpet(blockStateModelGenerator, GRAY_DECORATIVE_CARPET, "gray_decorative_carpet");
			registerCarpet(blockStateModelGenerator, BLACK_DECORATIVE_CARPET, "black_decorative_carpet");

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
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(RED_DECORATIVE_CARPET), "red_decorative_", Identifier.of(MOD_ID, "block/red_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(ORANGE_DECORATIVE_CARPET), "orange_decorative_", Identifier.of(MOD_ID, "block/orange_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(YELLOW_DECORATIVE_CARPET), "yellow_decorative_", Identifier.of(MOD_ID, "block/yellow_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(LIME_DECORATIVE_CARPET), "lime_decorative_", Identifier.of(MOD_ID, "block/lime_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(GREEN_DECORATIVE_CARPET), "green_decorative_", Identifier.of(MOD_ID, "block/green_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(CYAN_DECORATIVE_CARPET), "cyan_decorative_", Identifier.of(MOD_ID, "block/cyan_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(LIGHT_BLUE_DECORATIVE_CARPET), "light_blue_decorative_", Identifier.of(MOD_ID, "block/light_blue_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(BLUE_DECORATIVE_CARPET), "blue_decorative_", Identifier.of(MOD_ID, "block/blue_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PURPLE_DECORATIVE_CARPET), "purple_decorative_", Identifier.of(MOD_ID, "block/purple_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(MAGENTA_DECORATIVE_CARPET), "magenta_decorative_", Identifier.of(MOD_ID, "block/magenta_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(PINK_DECORATIVE_CARPET), "pink_decorative_", Identifier.of(MOD_ID, "block/pink_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(BROWN_DECORATIVE_CARPET), "brown_decorative_", Identifier.of(MOD_ID, "block/brown_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(WHITE_DECORATIVE_CARPET), "white_decorative_", Identifier.of(MOD_ID, "block/white_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(LIGHT_GRAY_DECORATIVE_CARPET), "light_gray_decorative_", Identifier.of(MOD_ID, "block/light_gray_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(GRAY_DECORATIVE_CARPET), "gray_decorative_", Identifier.of(MOD_ID, "block/gray_decorative_carpet"), false);
			registerStairCarpet(blockStateModelGenerator, CarpetsToStairs.get(BLACK_DECORATIVE_CARPET), "black_decorative_", Identifier.of(MOD_ID, "block/black_decorative_carpet"), false);

			blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(CARDBOARD_BOX, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MOD_ID, "block/cardboard_box_base"))));
			blockStateModelGenerator.registerParentedItemModel(CARDBOARD_BOX, Identifier.of(MOD_ID, "block/cardboard_box_base"));
			blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(WAXED_CARDBOARD_BOX, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MOD_ID, "block/cardboard_box_base"))));
			blockStateModelGenerator.registerParentedItemModel(WAXED_CARDBOARD_BOX, Identifier.of(MOD_ID, "block/cardboard_box_base"));
			blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(WET_CARDBOARD_BOX, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MOD_ID, "block/wet_cardboard_box"))));
			blockStateModelGenerator.registerParentedItemModel(WET_CARDBOARD_BOX, Identifier.of(MOD_ID, "block/wet_cardboard_box"));
			blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(COLLAPSED_CARDBOARD, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MOD_ID, "block/collapsed_cardboard"))));
			blockStateModelGenerator.registerParentedItemModel(COLLAPSED_CARDBOARD, Identifier.of(MOD_ID, "block/collapsed_cardboard"));
			blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(WET_COLLAPSED_CARDBOARD, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MOD_ID, "block/wet_collapsed_cardboard"))));
			blockStateModelGenerator.registerParentedItemModel(WET_COLLAPSED_CARDBOARD, Identifier.of(MOD_ID, "block/wet_collapsed_cardboard"));
			blockStateModelGenerator.registerDoor(CARDBOARD_DOOR);
			blockStateModelGenerator.registerDoor(WAXED_CARDBOARD_DOOR);
			blockStateModelGenerator.registerDoor(WET_CARDBOARD_DOOR);
			blockStateModelGenerator.registerTrapdoor(CARDBOARD_TRAPDOOR);
			blockStateModelGenerator.registerTrapdoor(WAXED_CARDBOARD_TRAPDOOR);
			blockStateModelGenerator.registerTrapdoor(WET_CARDBOARD_TRAPDOOR);
			registerPane(blockStateModelGenerator, CARDBOARD_PANE, CARDBOARD_PANE, Identifier.of(MOD_ID, "block/cardboard_pane_edge"), CARDBOARD_PANE);
			registerPane(blockStateModelGenerator, WAXED_CARDBOARD_PANE, CARDBOARD_PANE, Identifier.of(MOD_ID, "block/cardboard_pane_edge"), CARDBOARD_PANE);
			registerPane(blockStateModelGenerator, WET_CARDBOARD_PANE, WET_CARDBOARD_PANE, Identifier.of(MOD_ID, "block/wet_cardboard_pane_edge"), WET_CARDBOARD_PANE);
			registerSpecialSlab(blockStateModelGenerator, CARDBOARD_BOX_SLAB, Identifier.of(MOD_ID, "block/cardboard_box_bottom"), Identifier.of(MOD_ID, "block/cardboard_box_top"), Identifier.of(MOD_ID, "block/cardboard_slab_side"), Identifier.of(MOD_ID, "block/cardboard_slab_side1"));
			registerSpecialSlab(blockStateModelGenerator, WAXED_CARDBOARD_BOX_SLAB, Identifier.of(MOD_ID, "block/cardboard_box_bottom"), Identifier.of(MOD_ID, "block/cardboard_box_top"), Identifier.of(MOD_ID, "block/cardboard_slab_side"), Identifier.of(MOD_ID, "block/cardboard_slab_side1"));
			registerSpecialSlab(blockStateModelGenerator, WET_CARDBOARD_BOX_SLAB, Identifier.of(MOD_ID, "block/wet_cardboard_box_bottom"), Identifier.of(MOD_ID, "block/wet_cardboard_box_top"), Identifier.of(MOD_ID, "block/wet_cardboard_slab_side"), Identifier.of(MOD_ID, "block/wet_cardboard_slab_side1"));
			registerSpecialStairs(blockStateModelGenerator, CARDBOARD_BOX_STAIRS, Identifier.of(MOD_ID, "block/cardboard_box_bottom"), Identifier.of(MOD_ID, "block/cardboard_box_top"), Identifier.of(MOD_ID, "block/cardboard_slab_side"), Identifier.of(MOD_ID, "block/cardboard_slab_side1"), Identifier.of(MOD_ID, "block/cardboard_stair_end1"), Identifier.of(MOD_ID, "block/cardboard_stair_end"), Identifier.of(MOD_ID, "block/cardboard_slab_side2"));
			registerSpecialStairs(blockStateModelGenerator, WAXED_CARDBOARD_BOX_STAIRS, Identifier.of(MOD_ID, "block/cardboard_box_bottom"), Identifier.of(MOD_ID, "block/cardboard_box_top"), Identifier.of(MOD_ID, "block/cardboard_slab_side"), Identifier.of(MOD_ID, "block/cardboard_slab_side1"), Identifier.of(MOD_ID, "block/cardboard_stair_end1"), Identifier.of(MOD_ID, "block/cardboard_stair_end"), Identifier.of(MOD_ID, "block/cardboard_slab_side2"));
			registerSpecialStairs(blockStateModelGenerator, WET_CARDBOARD_BOX_STAIRS, Identifier.of(MOD_ID, "block/wet_cardboard_box_bottom"), Identifier.of(MOD_ID, "block/wet_cardboard_box_top"), Identifier.of(MOD_ID, "block/wet_cardboard_slab_side"), Identifier.of(MOD_ID, "block/wet_cardboard_slab_side1"), Identifier.of(MOD_ID, "block/wet_cardboard_stair_end1"), Identifier.of(MOD_ID, "block/wet_cardboard_stair_end"), Identifier.of(MOD_ID, "block/wet_cardboard_slab_side2"));
			blockStateModelGenerator.registerAxisRotated(CARDBOARD_BLOCK, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
			blockStateModelGenerator.registerAxisRotated(WAXED_CARDBOARD_BLOCK, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
			blockStateModelGenerator.registerAxisRotated(WET_CARDBOARD_BLOCK, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
			blockStateModelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(CARDBOARD_SLAB)
					.with(When.create().set(Properties.SLAB_TYPE, SlabType.BOTTOM), BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MOD_ID, "block/cardboard_slab")))
					.with(When.create().set(Properties.SLAB_TYPE, SlabType.TOP), BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MOD_ID, "block/cardboard_slab_top")))
					.with(When.create().set(Properties.SLAB_TYPE, SlabType.DOUBLE), BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MOD_ID, "block/cardboard_block"))));
			blockStateModelGenerator.registerParentedItemModel(CARDBOARD_SLAB, Identifier.of(MOD_ID, "block/cardboard_slab"));
			blockStateModelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(WAXED_CARDBOARD_SLAB)
					.with(When.create().set(Properties.SLAB_TYPE, SlabType.BOTTOM), BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MOD_ID, "block/cardboard_slab")))
					.with(When.create().set(Properties.SLAB_TYPE, SlabType.TOP), BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MOD_ID, "block/cardboard_slab_top")))
					.with(When.create().set(Properties.SLAB_TYPE, SlabType.DOUBLE), BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MOD_ID, "block/cardboard_block"))));
			blockStateModelGenerator.registerParentedItemModel(WAXED_CARDBOARD_SLAB, Identifier.of(MOD_ID, "block/cardboard_slab"));
			blockStateModelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(WET_CARDBOARD_SLAB)
					.with(When.create().set(Properties.SLAB_TYPE, SlabType.BOTTOM), BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MOD_ID, "block/wet_cardboard_slab")))
					.with(When.create().set(Properties.SLAB_TYPE, SlabType.TOP), BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MOD_ID, "block/wet_cardboard_slab_top")))
					.with(When.create().set(Properties.SLAB_TYPE, SlabType.DOUBLE), BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MOD_ID, "block/wet_cardboard_block"))));
			blockStateModelGenerator.registerParentedItemModel(WET_CARDBOARD_SLAB, Identifier.of(MOD_ID, "block/wet_cardboard_slab"));
			registerCardboardStairs(blockStateModelGenerator, CARDBOARD_STAIRS, Identifier.of(MOD_ID, "block/cardboard_stairs"), Identifier.of(MOD_ID, "block/cardboard_stairs_inner"), Identifier.of(MOD_ID, "block/cardboard_stairs_outer"));
			registerCardboardStairs(blockStateModelGenerator, WAXED_CARDBOARD_STAIRS, Identifier.of(MOD_ID, "block/cardboard_stairs"), Identifier.of(MOD_ID, "block/cardboard_stairs_inner"), Identifier.of(MOD_ID, "block/cardboard_stairs_outer"));
			registerCardboardStairs(blockStateModelGenerator, WET_CARDBOARD_STAIRS, Identifier.of(MOD_ID, "block/wet_cardboard_stairs"), Identifier.of(MOD_ID, "block/wet_cardboard_stairs_inner"), Identifier.of(MOD_ID, "block/wet_cardboard_stairs_outer"));
			registerGateBlockStates(blockStateModelGenerator, CARDBOARD_GATE, Identifier.of(MOD_ID, "block/cardboard_gate"), Identifier.of(MOD_ID, "block/cardboard_gate_open"));
			registerGateBlockStates(blockStateModelGenerator, WAXED_CARDBOARD_GATE, Identifier.of(MOD_ID, "block/cardboard_gate"), Identifier.of(MOD_ID, "block/cardboard_gate_open"));
			registerGateBlockStates(blockStateModelGenerator, WET_CARDBOARD_GATE, Identifier.of(MOD_ID, "block/wet_cardboard_gate"), Identifier.of(MOD_ID, "block/wet_cardboard_gate_open"));

			blockStateModelGenerator.registerCubeAllModelTexturePool(PAPER_BLOCK);
			blockStateModelGenerator.registerParented(PAPER_BLOCK, WAXED_PAPER_BLOCK);
			registerPane(blockStateModelGenerator, PAPER_PANEL, PAPER_PANEL, Identifier.of(MOD_ID, "block/paper_panel_edge"), PAPER_PANEL);
			registerPane(blockStateModelGenerator, WAXED_PAPER_PANEL, PAPER_PANEL, Identifier.of(MOD_ID, "block/paper_panel_edge"), PAPER_PANEL);
			registerPane(blockStateModelGenerator, PAPER_PANEL_BOTTOM, PAPER_PANEL_BOTTOM, Identifier.of(MOD_ID, "block/paper_panel_edge"), null);
			registerPane(blockStateModelGenerator, WAXED_PAPER_PANEL_BOTTOM, PAPER_PANEL_BOTTOM, Identifier.of(MOD_ID, "block/paper_panel_edge"), null);
			registerPane(blockStateModelGenerator, HORIZONTAL_PAPER_PANEL, HORIZONTAL_PAPER_PANEL, Identifier.of(MOD_ID, "block/paper_panel_edge"), HORIZONTAL_PAPER_PANEL);
			registerPane(blockStateModelGenerator, WAXED_HORIZONTAL_PAPER_PANEL, HORIZONTAL_PAPER_PANEL, Identifier.of(MOD_ID, "block/paper_panel_edge"), HORIZONTAL_PAPER_PANEL);
			registerPane(blockStateModelGenerator, HORIZONTAL_PAPER_PANEL_BOTTOM, HORIZONTAL_PAPER_PANEL_BOTTOM, Identifier.of(MOD_ID, "block/paper_panel_edge"), null);
			registerPane(blockStateModelGenerator, WAXED_HORIZONTAL_PAPER_PANEL_BOTTOM, HORIZONTAL_PAPER_PANEL_BOTTOM, Identifier.of(MOD_ID, "block/paper_panel_edge"), null);
			registerPaneDoor(blockStateModelGenerator, HORIZONTAL_PAPER_PANEL_DOOR, "horizontal_paper_panel_door");
			registerPaneDoor(blockStateModelGenerator, PAPER_PANEL_DOOR, "paper_panel_door");
		}

		@Override
		public void generateItemModels(ItemModelGenerator itemModelGenerator) {
			itemModelGenerator.register(SAWDUST.asItem());
		}

		public final void registerSpecialStairs(BlockStateModelGenerator generator, Block block, Identifier bottomTexture, Identifier topTexture, Identifier slabTexture, Identifier slabTexture2, Identifier endTexture, Identifier backTexture, Identifier slabSide2Texture) {
			TextureMap textureMap = new TextureMap().put(TextureKey.BOTTOM, bottomTexture).put(TextureKey.TOP, topTexture).put(TextureKey.SIDE, slabTexture).put(TextureKey.FRONT, slabTexture2).put(TextureKey.END, endTexture).put(TextureKey.BACK, backTexture);
			Identifier stairs = SpecialStairs.upload(block, textureMap, generator.modelCollector);
			Identifier stairsInner = SpecialStairsInner.upload(block, new TextureMap().put(TextureKey.BOTTOM, bottomTexture).put(TextureKey.TOP, topTexture).put(TextureKey.SIDE, slabTexture).put(TextureKey.FRONT, slabTexture2).put(TextureKey.END, endTexture).put(TextureKey.BACK, slabSide2Texture), generator.modelCollector);
			Identifier stairsOuter = SpecialStairsOuter.upload(block, textureMap, generator.modelCollector);
			generator.registerParentedItemModel(block, stairs);
			generator.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(block, stairsInner, stairs, stairsOuter));
		}

		public final void registerSpecialSlab(BlockStateModelGenerator generator, Block block, Identifier bottomTexture, Identifier topTexture, Identifier sideTexture, Identifier sideTexture2) {
			TextureMap textureMap = new TextureMap().put(TextureKey.BOTTOM, bottomTexture).put(TextureKey.TOP, topTexture).put(TextureKey.SIDE, sideTexture).put(TextureKey.FRONT, sideTexture2);
			Identifier bottom = SpecialSlab.upload(block, textureMap, generator.modelCollector);
			Identifier top = SpecialSlabTop.upload(block, textureMap, generator.modelCollector);
			Identifier doubleSlab = SpecialCube.upload(block, textureMap, generator.modelCollector);
			generator.registerParentedItemModel(block, bottom);
			generator.blockStateCollector.accept(MultipartBlockStateSupplier.create(block)
					.with(When.create().set(Properties.SLAB_TYPE, SlabType.BOTTOM), BlockStateVariant.create().put(VariantSettings.MODEL, bottom))
					.with(When.create().set(Properties.SLAB_TYPE, SlabType.TOP), BlockStateVariant.create().put(VariantSettings.MODEL, top))
					.with(When.create().set(Properties.SLAB_TYPE, SlabType.DOUBLE), BlockStateVariant.create().put(VariantSettings.MODEL, doubleSlab)));
		}

		public final void registerCardboardStairs(BlockStateModelGenerator generator, Block block, Identifier stairs, Identifier stairsInner, Identifier stairsOuter) {
			generator.registerParentedItemModel(block, stairs);
			generator.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(block, stairsInner, stairs, stairsOuter));
		}

		public final void registerGateBlockStates(BlockStateModelGenerator generator, Block block, Identifier closedModelId, Identifier openModelId) {
			generator.registerParentedItemModel(block, closedModelId);
			generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create())
					.coordinate(generator.createSouthDefaultHorizontalRotationStates())
					.coordinate(BlockStateVariantMap.create(Properties.OPEN)
							.register(false, BlockStateVariant.create().put(VariantSettings.MODEL, closedModelId))
							.register(true, BlockStateVariant.create().put(VariantSettings.MODEL, openModelId))));
		}

		public final void registerPane(BlockStateModelGenerator generator, Block block, Block textureSource, Identifier edgeTexture, @Nullable Block itemModel) {
			TextureMap textureMap = new TextureMap().put(TextureKey.PANE, TextureMap.getId(textureSource)).put(TextureKey.EDGE, edgeTexture);
			Identifier identifier = Models.TEMPLATE_GLASS_PANE_POST.upload(block, textureMap, generator.modelCollector);
			Identifier identifier2 = Models.TEMPLATE_GLASS_PANE_SIDE.upload(block, textureMap, generator.modelCollector);
			Identifier identifier3 = Models.TEMPLATE_GLASS_PANE_SIDE_ALT.upload(block, textureMap, generator.modelCollector);
			Identifier identifier4 = Models.TEMPLATE_GLASS_PANE_NOSIDE.upload(block, textureMap, generator.modelCollector);
			Identifier identifier5 = Models.TEMPLATE_GLASS_PANE_NOSIDE_ALT.upload(block, textureMap, generator.modelCollector);
			if (itemModel != null) {
				generator.registerItemModel(block.asItem(), generator.uploadBlockItemModel(block.asItem(), itemModel));
			}
			generator.blockStateCollector.accept(MultipartBlockStateSupplier.create(block).with(BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).with(When.create().set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2)).with(When.create().set(Properties.EAST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with(When.create().set(Properties.SOUTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier3)).with(When.create().set(Properties.WEST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier3).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with(When.create().set(Properties.NORTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier4)).with(When.create().set(Properties.EAST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5)).with(When.create().set(Properties.SOUTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with(When.create().set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier4).put(VariantSettings.Y, VariantSettings.Rotation.R270)));
		}

		private void registerPaneDoor(BlockStateModelGenerator blockStateModelGenerator, Block block, String texture) {
			Identifier top_normal = ModelIds.getBlockSubModelId(block, "_top");
			Identifier top_open = ModelIds.getBlockSubModelId(block, "_top_open");
			Identifier top_open_flipped = ModelIds.getBlockSubModelId(block, "_top_open_flipped");
			Identifier bottom_normal = ModelIds.getBlockSubModelId(block, "_bottom");
			Identifier bottom_open = ModelIds.getBlockSubModelId(block, "_bottom_open");
			Identifier bottom_open_flipped = ModelIds.getBlockSubModelId(block, "_bottom_open_flipped");
			blockStateModelGenerator.registerItemModel(block.asItem());
			blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_FACING, Properties.DOOR_HINGE, Properties.OPEN, Properties.DOUBLE_BLOCK_HALF)
					.register(Direction.NORTH, DoorHinge.LEFT, true, DoubleBlockHalf.UPPER,
							BlockStateVariant.create().put(VariantSettings.MODEL, top_open_flipped).put(VariantSettings.Y, VariantSettings.Rotation.R0))
					.register(Direction.NORTH, DoorHinge.RIGHT, true, DoubleBlockHalf.UPPER,
							BlockStateVariant.create().put(VariantSettings.MODEL, top_open).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.register(Direction.NORTH, DoorHinge.LEFT, false, DoubleBlockHalf.UPPER,
							BlockStateVariant.create().put(VariantSettings.MODEL, top_normal).put(VariantSettings.Y, VariantSettings.Rotation.R0))
					.register(Direction.NORTH, DoorHinge.RIGHT, false, DoubleBlockHalf.UPPER,
							BlockStateVariant.create().put(VariantSettings.MODEL, top_normal).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.register(Direction.SOUTH, DoorHinge.LEFT, true, DoubleBlockHalf.UPPER,
							BlockStateVariant.create().put(VariantSettings.MODEL, top_open_flipped).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.register(Direction.SOUTH, DoorHinge.RIGHT, true, DoubleBlockHalf.UPPER,
							BlockStateVariant.create().put(VariantSettings.MODEL, top_open).put(VariantSettings.Y, VariantSettings.Rotation.R0))
					.register(Direction.SOUTH, DoorHinge.LEFT, false, DoubleBlockHalf.UPPER,
							BlockStateVariant.create().put(VariantSettings.MODEL, top_normal).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.register(Direction.SOUTH, DoorHinge.RIGHT, false, DoubleBlockHalf.UPPER,
							BlockStateVariant.create().put(VariantSettings.MODEL, top_normal).put(VariantSettings.Y, VariantSettings.Rotation.R0))
					.register(Direction.EAST, DoorHinge.LEFT, true, DoubleBlockHalf.UPPER,
							BlockStateVariant.create().put(VariantSettings.MODEL, top_open_flipped).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.register(Direction.EAST, DoorHinge.RIGHT, true, DoubleBlockHalf.UPPER,
							BlockStateVariant.create().put(VariantSettings.MODEL, top_open).put(VariantSettings.Y, VariantSettings.Rotation.R270))
					.register(Direction.EAST, DoorHinge.LEFT, false, DoubleBlockHalf.UPPER,
							BlockStateVariant.create().put(VariantSettings.MODEL, top_normal).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.register(Direction.EAST, DoorHinge.RIGHT, false, DoubleBlockHalf.UPPER,
							BlockStateVariant.create().put(VariantSettings.MODEL, top_normal).put(VariantSettings.Y, VariantSettings.Rotation.R270))
					.register(Direction.WEST, DoorHinge.LEFT, true, DoubleBlockHalf.UPPER,
							BlockStateVariant.create().put(VariantSettings.MODEL, top_open_flipped).put(VariantSettings.Y, VariantSettings.Rotation.R270))
					.register(Direction.WEST, DoorHinge.RIGHT, true, DoubleBlockHalf.UPPER,
							BlockStateVariant.create().put(VariantSettings.MODEL, top_open).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.register(Direction.WEST, DoorHinge.LEFT, false, DoubleBlockHalf.UPPER,
							BlockStateVariant.create().put(VariantSettings.MODEL, top_normal).put(VariantSettings.Y, VariantSettings.Rotation.R270))
					.register(Direction.WEST, DoorHinge.RIGHT, false, DoubleBlockHalf.UPPER,
							BlockStateVariant.create().put(VariantSettings.MODEL, top_normal).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.register(Direction.NORTH, DoorHinge.LEFT, true, DoubleBlockHalf.LOWER,
							BlockStateVariant.create().put(VariantSettings.MODEL, bottom_open_flipped).put(VariantSettings.Y, VariantSettings.Rotation.R0))
					.register(Direction.NORTH, DoorHinge.RIGHT, true, DoubleBlockHalf.LOWER,
							BlockStateVariant.create().put(VariantSettings.MODEL, bottom_open).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.register(Direction.NORTH, DoorHinge.LEFT, false, DoubleBlockHalf.LOWER,
							BlockStateVariant.create().put(VariantSettings.MODEL, bottom_normal).put(VariantSettings.Y, VariantSettings.Rotation.R0))
					.register(Direction.NORTH, DoorHinge.RIGHT, false, DoubleBlockHalf.LOWER,
							BlockStateVariant.create().put(VariantSettings.MODEL, bottom_normal).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.register(Direction.SOUTH, DoorHinge.LEFT, true, DoubleBlockHalf.LOWER,
							BlockStateVariant.create().put(VariantSettings.MODEL, bottom_open_flipped).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.register(Direction.SOUTH, DoorHinge.RIGHT, true, DoubleBlockHalf.LOWER,
							BlockStateVariant.create().put(VariantSettings.MODEL, bottom_open).put(VariantSettings.Y, VariantSettings.Rotation.R0))
					.register(Direction.SOUTH, DoorHinge.LEFT, false, DoubleBlockHalf.LOWER,
							BlockStateVariant.create().put(VariantSettings.MODEL, bottom_normal).put(VariantSettings.Y, VariantSettings.Rotation.R180))
					.register(Direction.SOUTH, DoorHinge.RIGHT, false, DoubleBlockHalf.LOWER,
							BlockStateVariant.create().put(VariantSettings.MODEL, bottom_normal).put(VariantSettings.Y, VariantSettings.Rotation.R0))
					.register(Direction.EAST, DoorHinge.LEFT, true, DoubleBlockHalf.LOWER,
							BlockStateVariant.create().put(VariantSettings.MODEL, bottom_open_flipped).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.register(Direction.EAST, DoorHinge.RIGHT, true, DoubleBlockHalf.LOWER,
							BlockStateVariant.create().put(VariantSettings.MODEL, bottom_open).put(VariantSettings.Y, VariantSettings.Rotation.R270))
					.register(Direction.EAST, DoorHinge.LEFT, false, DoubleBlockHalf.LOWER,
							BlockStateVariant.create().put(VariantSettings.MODEL, bottom_normal).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.register(Direction.EAST, DoorHinge.RIGHT, false, DoubleBlockHalf.LOWER,
							BlockStateVariant.create().put(VariantSettings.MODEL, bottom_normal).put(VariantSettings.Y, VariantSettings.Rotation.R270))
					.register(Direction.WEST, DoorHinge.LEFT, true, DoubleBlockHalf.LOWER,
							BlockStateVariant.create().put(VariantSettings.MODEL, bottom_open_flipped).put(VariantSettings.Y, VariantSettings.Rotation.R270))
					.register(Direction.WEST, DoorHinge.RIGHT, true, DoubleBlockHalf.LOWER,
							BlockStateVariant.create().put(VariantSettings.MODEL, bottom_open).put(VariantSettings.Y, VariantSettings.Rotation.R90))
					.register(Direction.WEST, DoorHinge.LEFT, false, DoubleBlockHalf.LOWER,
							BlockStateVariant.create().put(VariantSettings.MODEL, bottom_normal).put(VariantSettings.Y, VariantSettings.Rotation.R270))
					.register(Direction.WEST, DoorHinge.RIGHT, false, DoubleBlockHalf.LOWER,
							BlockStateVariant.create().put(VariantSettings.MODEL, bottom_normal).put(VariantSettings.Y, VariantSettings.Rotation.R90))
			));
			TextureMap textureMap = new TextureMap()
					.put(TextureKey.PARTICLE, Identifier.of(MOD_ID, "block/" + texture + "_top"))
					.put(TextureKey.TOP, Identifier.of(MOD_ID, "block/" + texture + "_top"))
					.put(TextureKey.BOTTOM, Identifier.of(MOD_ID, "block/" + texture + "_bottom"))
					.put(TextureKey.END, Identifier.of(MOD_ID, "block/" + texture + "_end"));

			new Model(Optional.of(Identifier.of(MOD_ID, "block/sliding_pane_top_base")), Optional.of(texture), TextureKey.PARTICLE, TextureKey.TOP, TextureKey.BOTTOM, TextureKey.END)
					.upload(top_normal, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/sliding_pane_top_open_base")), Optional.of(texture), TextureKey.PARTICLE, TextureKey.TOP, TextureKey.BOTTOM, TextureKey.END)
					.upload(top_open, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/sliding_pane_top_open_flipped_base")), Optional.of(texture), TextureKey.PARTICLE, TextureKey.TOP, TextureKey.BOTTOM, TextureKey.END)
					.upload(top_open_flipped, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/sliding_pane_bottom_base")), Optional.of(texture), TextureKey.PARTICLE, TextureKey.TOP, TextureKey.BOTTOM, TextureKey.END)
					.upload(bottom_normal, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/sliding_pane_bottom_open_base")), Optional.of(texture), TextureKey.PARTICLE, TextureKey.TOP, TextureKey.BOTTOM, TextureKey.END)
					.upload(bottom_open, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/sliding_pane_bottom_open_flipped_base")), Optional.of(texture), TextureKey.PARTICLE, TextureKey.TOP, TextureKey.BOTTOM, TextureKey.END)
					.upload(bottom_open_flipped, textureMap, blockStateModelGenerator.modelCollector);
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
					.upload(id, new TextureMap().put(wool, Identifier.of(MOD_ID, "block/"+name)), blockStateModelGenerator.modelCollector);
		}

		private void registerFlowerPots(BlockStateModelGenerator blockStateModelGenerator, ColoredFlowerPotBlock[] flowerPots, String color) {
			Identifier texture = Identifier.of(MOD_ID, "block/"+color+"_flower_pot");
			TextureKey pot = TextureKey.of("flowerpot");
			for (ColoredFlowerPotBlock b : flowerPots) {
				registerParented(blockStateModelGenerator, b, color+"_"+b.variantName, Identifier.ofVanilla("block/"+b.variantName),
						new TextureMap().put(TextureKey.PARTICLE, texture).put(pot, texture),
						new TextureKey[] {TextureKey.PARTICLE, pot});
			}
			blockStateModelGenerator.registerItemModel(flowerPots[0].asItem());
		}

		private void registerLargeFlowerPots(BlockStateModelGenerator blockStateModelGenerator, LargeFlowerPotBlock[] flowerPots, String color) {
			Identifier texture = Identifier.of(MOD_ID, "block/"+color+"large_flower_pot");
			TextureKey pot = TextureKey.of("pot");
			TextureKey bottom = TextureKey.of("bottom");
			TextureKey top = TextureKey.of("top");
			for (LargeFlowerPotBlock b : flowerPots) {
				if (b.usesSpecialModel) {
					if (Objects.equals(color, "")) {
						blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(b, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MOD_ID, "block/" + b.variantName))));
					} else {
						registerParented(blockStateModelGenerator, b, color+b.variantName, Identifier.of(MOD_ID, "block/"+b.variantName),
								new TextureMap().put(TextureKey.PARTICLE, texture).put(pot, texture),
								new TextureKey[] {TextureKey.PARTICLE, pot});
					}
				} else {
					registerParented(blockStateModelGenerator, b, color+b.variantName, Identifier.of(MOD_ID, "block/large_flower_pot_full"),
							new TextureMap().put(TextureKey.PARTICLE, texture).put(pot, texture).put(bottom, b.bottomTexture).put(top, b.topTexture),
							new TextureKey[] {TextureKey.PARTICLE, pot, bottom, top});
				}
			}
			blockStateModelGenerator.registerItemModel(flowerPots[0].asItem());
		}

		private void registerHangingFlowerPots(BlockStateModelGenerator blockStateModelGenerator, HangingFlowerPotBlock[] flowerPots, String color) {
			Identifier texture = Identifier.of(MOD_ID, "block/"+color+"large_flower_pot");
			TextureKey pot = TextureKey.of("pot");
			TextureKey plant = TextureKey.of("plant");
			for (HangingFlowerPotBlock b : flowerPots) {
				if (b.usesSpecialModel) {
					if (Objects.equals(color, "")) {
						blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(b, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MOD_ID, "block/" + b.variantName))));
					} else {
						registerParented(blockStateModelGenerator, b, color+b.variantName, Identifier.of(MOD_ID, "block/"+b.variantName),
								new TextureMap().put(TextureKey.PARTICLE, texture).put(pot, texture),
								new TextureKey[] {TextureKey.PARTICLE, pot});
					}
				} else {
					registerParented(blockStateModelGenerator, b, color+b.variantName, Identifier.of(MOD_ID, "block/hanging_flower_pot_full"),
							new TextureMap().put(TextureKey.PARTICLE, texture).put(pot, texture).put(plant, b.texture),
							new TextureKey[] {TextureKey.PARTICLE, pot, plant});
				}
			}
			blockStateModelGenerator.registerItemModel(flowerPots[0].asItem());
		}

		private void registerDecoratedPot(BlockStateModelGenerator blockStateModelGenerator, Block block, String color) {
			blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.ofVanilla("block/decorated_pot"))));
			blockStateModelGenerator.modelCollector.accept(ModelIds.getItemModelId(block.asItem()), () -> getItemModelJSON(String.valueOf(Identifier.ofVanilla("block/decorated_pot")), new Vec3d(30, 45, 0), new Vec3d(0, 0, 0), new Vec3d(0.6, 0.6, 0.6)));
			blockStateModelGenerator.registerSpecialItemModel(block, new ColoredDecoratedPotModelRenderer.Unbaked(color));
		}

		private void registerParented(BlockStateModelGenerator blockStateModelGenerator, Block block, String variant, Identifier parent, TextureMap textureMap, TextureKey[] textureKeys) {
			Identifier id = ModelIds.getBlockModelId(block);
			blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, id)));
			new Model(Optional.of(parent), Optional.of(variant), textureKeys)
					.upload(id, textureMap, blockStateModelGenerator.modelCollector);
		}

		private void registerStairCarpet(BlockStateModelGenerator blockStateModelGenerator, Block block, String color, Identifier texture, Boolean uvlock) {
			TextureMap textureMap = new TextureMap().put(TextureKey.WOOL, texture).put(TextureKey.PARTICLE, texture);
			Identifier id = Identifier.of(MOD_ID, "block/"+color+"stair_carpet");
			Identifier id_inner = Identifier.of(MOD_ID, "block/"+color+"stair_carpet_inner");
			Identifier id_outer = Identifier.of(MOD_ID, "block/"+color+"stair_carpet_outer");

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

			new Model(Optional.of(Identifier.of(MOD_ID, "block/stair_carpet")), Optional.of(id.getPath()), TextureKey.WOOL, TextureKey.PARTICLE)
					.upload(id, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/stair_carpet_inner")), Optional.of(id_inner.getPath()), TextureKey.WOOL, TextureKey.PARTICLE)
					.upload(id_inner, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/stair_carpet_outer")), Optional.of(id_outer.getPath()), TextureKey.WOOL, TextureKey.PARTICLE)
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

			new Model(Optional.of(Identifier.of(MOD_ID, "block/light_button_base")), Optional.of(variant), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(normal_id, textureMap2, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/light_button_on_base")), Optional.of(variant), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(active_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/light_button_pressed_base")), Optional.of(variant), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(powered_id, textureMap1, blockStateModelGenerator.modelCollector);

			blockStateModelGenerator.registerParentedItemModel(block, normal_id);
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
			Identifier dot_id = Identifier.of(MOD_ID, "block/" + variant + "_dot");
			Identifier north_off_id = Identifier.of(MOD_ID, "block/" + variant + "_north_off");
			Identifier south_off_id = Identifier.of(MOD_ID, "block/" + variant + "_south_off");
			Identifier east_off_id = Identifier.of(MOD_ID, "block/" + variant + "_east_off");
			Identifier west_off_id = Identifier.of(MOD_ID, "block/" + variant + "_west_off");
			Identifier north_id = Identifier.of(MOD_ID, "block/" + variant + "_north");
			Identifier south_id = Identifier.of(MOD_ID, "block/" + variant + "_south");
			Identifier east_id = Identifier.of(MOD_ID, "block/" + variant + "_east");
			Identifier west_id = Identifier.of(MOD_ID, "block/" + variant + "_west");
			Identifier up_north_id = Identifier.of(MOD_ID, "block/" + variant + "_up_north");
			Identifier up_south_id = Identifier.of(MOD_ID, "block/" + variant + "_up_south");
			Identifier up_east_id = Identifier.of(MOD_ID, "block/" + variant + "_up_east");
			Identifier up_west_id = Identifier.of(MOD_ID, "block/" + variant +  "_up_west");

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
					.put(TextureKey.PARTICLE, Identifier.of(MOD_ID, "block/" + texture))
					.put(TextureKey.TEXTURE, Identifier.of(MOD_ID, "block/" + texture));
			TextureMap textureMap1 = new TextureMap()
					.put(TextureKey.PARTICLE, Identifier.of(MOD_ID, "block/" + texture))
					.put(TextureKey.TEXTURE, Identifier.of(MOD_ID, "block/" + texture + "1"));
			TextureMap textureMap2 = new TextureMap()
					.put(TextureKey.PARTICLE, Identifier.of(MOD_ID, "block/" + texture))
					.put(TextureKey.TEXTURE, Identifier.of(MOD_ID,"block/" + texture + "2"));
			TextureMap textureMap3 = new TextureMap()
					.put(TextureKey.PARTICLE, Identifier.of(MOD_ID, "block/" + texture))
					.put(TextureKey.TEXTURE, Identifier.of(MOD_ID, "block/" + texture + "3"));

			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_dot_base"+(shade?"":"_noshade"))), Optional.of(variant + "_dot"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(dot_id, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_north_base"+(shade?"":"_noshade"))), Optional.of(variant + "_north"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(north_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_east_base"+(shade?"":"_noshade"))), Optional.of(variant + "_east"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(east_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_south_base"+(shade?"":"_noshade"))), Optional.of(variant + "_south"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(south_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_west_base"+(shade?"":"_noshade"))), Optional.of(variant + "_west"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(west_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_north_base"+(shade?"":"_noshade"))), Optional.of(variant + "_north_off"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(north_off_id, textureMap2, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_east_base"+(shade?"":"_noshade"))), Optional.of(variant + "_east_off"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(east_off_id, textureMap2, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_south_base"+(shade?"":"_noshade"))), Optional.of(variant + "_south_off"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(south_off_id, textureMap2, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_west_base"+(shade?"":"_noshade"))), Optional.of(variant + "_west_off"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(west_off_id, textureMap2, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_up_north_base"+(shade?"":"_noshade"))), Optional.of(variant + "_up_north"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(up_north_id, textureMap3, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_up_east_base"+(shade?"":"_noshade"))), Optional.of(variant + "_up_east"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(up_east_id, textureMap3, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_up_south_base"+(shade?"":"_noshade"))), Optional.of(variant + "_up_south"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(up_south_id, textureMap3, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_up_west_base"+(shade?"":"_noshade"))), Optional.of(variant + "_up_west"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(up_west_id, textureMap3, blockStateModelGenerator.modelCollector);
		}

		private void registerDust(BlockStateModelGenerator blockStateModelGenerator, Block block, String variant, boolean shade) {
			Identifier dot_id = Identifier.of(MOD_ID, "block/" + variant + "_dot");
			Identifier north_id = Identifier.of(MOD_ID, "block/" + variant + "_north");
			Identifier south_id = Identifier.of(MOD_ID, "block/" + variant + "_south");
			Identifier east_id = Identifier.of(MOD_ID, "block/" + variant + "_east");
			Identifier west_id = Identifier.of(MOD_ID, "block/" + variant + "_west");
			Identifier up_north_id = Identifier.of(MOD_ID, "block/" + variant + "_up_north");
			Identifier up_south_id = Identifier.of(MOD_ID, "block/" + variant + "_up_south");
			Identifier up_east_id = Identifier.of(MOD_ID, "block/" + variant + "_up_east");
			Identifier up_west_id = Identifier.of(MOD_ID, "block/" + variant +  "_up_west");

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
					.put(TextureKey.PARTICLE, Identifier.of(MOD_ID, "block/" + variant))
					.put(TextureKey.TEXTURE, Identifier.of(MOD_ID, "block/" + variant));
			TextureMap textureMap1 = new TextureMap()
					.put(TextureKey.PARTICLE, Identifier.of(MOD_ID, "block/" + variant))
					.put(TextureKey.TEXTURE, Identifier.of(MOD_ID, "block/" + variant + "3"));
			TextureMap textureMap3 = new TextureMap()
					.put(TextureKey.PARTICLE, Identifier.of(MOD_ID, "block/" + variant))
					.put(TextureKey.TEXTURE, Identifier.of(MOD_ID, "block/" + variant + "3"));

			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_dot_base"+(shade?"":"_noshade"))), Optional.of(variant + "_dot"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(dot_id, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_north_base"+(shade?"":"_noshade"))), Optional.of(variant + "_north"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(north_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_east_base"+(shade?"":"_noshade"))), Optional.of(variant + "_east"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(east_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_south_base"+(shade?"":"_noshade"))), Optional.of(variant + "_south"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(south_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_west_base"+(shade?"":"_noshade"))), Optional.of(variant + "_west"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(west_id, textureMap1, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_up_north_base"+(shade?"":"_noshade"))), Optional.of(variant + "_up_north"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(up_north_id, textureMap3, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_up_east_base"+(shade?"":"_noshade"))), Optional.of(variant + "_up_east"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(up_east_id, textureMap3, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_up_south_base"+(shade?"":"_noshade"))), Optional.of(variant + "_up_south"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(up_south_id, textureMap3, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/dust_up_west_base"+(shade?"":"_noshade"))), Optional.of(variant + "_up_west"), TextureKey.PARTICLE, TextureKey.TEXTURE)
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

			new Model(Optional.of(Identifier.of(MOD_ID, "block/bench_base")), Optional.of(variant), TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE)
					.upload(id, textureMap, blockStateModelGenerator.modelCollector);
			blockStateModelGenerator.registerParentedItemModel(block, id);
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

			new Model(Optional.of(Identifier.of(MOD_ID, "block/wood_stool_base")), Optional.of(variant), TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE)
					.upload(id, textureMap, blockStateModelGenerator.modelCollector);
			blockStateModelGenerator.registerParentedItemModel(block, id);
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

			new Model(Optional.of(Identifier.of(MOD_ID, "block/seat_base")), Optional.of(variant), TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE)
					.upload(normal_id, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/seat_inner_base")), Optional.of(variant), TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE)
					.upload(inner_id, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/seat_outer_base")), Optional.of(variant), TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE)
					.upload(outer_id, textureMap, blockStateModelGenerator.modelCollector);
			blockStateModelGenerator.registerParentedItemModel(block, normal_id);
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
					.put(TextureKey.TEXTURE, Identifier.of(MOD_ID, "block/" + texture))
					.put(TextureKey.PARTICLE, Identifier.ofVanilla("block/oak_planks"));

			new Model(Optional.of(Identifier.of(MOD_ID, "block/ottoman_base")), Optional.of(texture), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(id, textureMap, blockStateModelGenerator.modelCollector);
			blockStateModelGenerator.registerParentedItemModel(block, id);
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
					.put(TextureKey.TEXTURE, Identifier.of(MOD_ID, "block/" + texture))
					.put(TextureKey.PARTICLE, Identifier.ofVanilla("block/oak_planks"));

			new Model(Optional.of(Identifier.of(MOD_ID, "block/wool_stool_base")), Optional.of(texture), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(id, textureMap, blockStateModelGenerator.modelCollector);
			blockStateModelGenerator.registerParentedItemModel(block, id);
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
					.put(TextureKey.TEXTURE, Identifier.of(MOD_ID, "block/" + texture))
					.put(TextureKey.PARTICLE, Identifier.of(MOD_ID, "block/" + texture));

			new Model(Optional.of(Identifier.of(MOD_ID, "block/cushion_base")), Optional.of(texture), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(id, textureMap, blockStateModelGenerator.modelCollector);
			blockStateModelGenerator.registerParentedItemModel(block, id);
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
					.put(TextureKey.TEXTURE, Identifier.of(MOD_ID, "block/" + texture))
					.put(TextureKey.PARTICLE, Identifier.ofVanilla("block/oak_planks"));

			new Model(Optional.of(Identifier.of(MOD_ID, "block/wool_seat_base")), Optional.of(texture), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(normal_id, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/wool_seat_inner_base")), Optional.of(texture), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(inner_id, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of(MOD_ID, "block/wool_seat_outer_base")), Optional.of(texture), TextureKey.TEXTURE, TextureKey.PARTICLE)
					.upload(outer_id, textureMap, blockStateModelGenerator.modelCollector);
			blockStateModelGenerator.registerParentedItemModel(block, normal_id);
		}
	}

	private static class RecipeProvider extends FabricRecipeProvider {
		private RecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
			super(output, registriesFuture);
		}

		@Override
		public String getName() {
			return MOD_ID + ":recipe_provider";
		}

		@Override
		public net.minecraft.data.recipe.RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup lookup, RecipeExporter exporter) {
			return new RecipeGenerator(lookup, exporter) {
				@Override
				public void generate() {
					offerBench(OAK_BENCH, Items.OAK_SLAB, Items.OAK_PLANKS);
					offerWoodenSeat(OAK_SEAT, Items.OAK_SLAB, Items.OAK_PLANKS);
					offerWoodenStool(OAK_STOOL, Items.OAK_SLAB, Items.OAK_PLANKS);
					offerBench(SPRUCE_BENCH, Items.SPRUCE_SLAB, Items.SPRUCE_PLANKS);
					offerWoodenSeat(SPRUCE_SEAT, Items.SPRUCE_SLAB, Items.SPRUCE_PLANKS);
					offerWoodenStool(SPRUCE_STOOL, Items.SPRUCE_SLAB, Items.SPRUCE_PLANKS);
					offerBench(BIRCH_BENCH, Items.BIRCH_SLAB, Items.BIRCH_PLANKS);
					offerWoodenSeat(BIRCH_SEAT, Items.BIRCH_SLAB, Items.BIRCH_PLANKS);
					offerWoodenStool(BIRCH_STOOL, Items.BIRCH_SLAB, Items.BIRCH_PLANKS);
					offerBench(JUNGLE_BENCH, Items.JUNGLE_SLAB, Items.JUNGLE_PLANKS);
					offerWoodenSeat(JUNGLE_SEAT, Items.JUNGLE_SLAB, Items.JUNGLE_PLANKS);
					offerWoodenStool(JUNGLE_STOOL, Items.JUNGLE_SLAB, Items.JUNGLE_PLANKS);
					offerBench(ACACIA_BENCH, Items.ACACIA_SLAB, Items.ACACIA_PLANKS);
					offerWoodenSeat(ACACIA_SEAT, Items.ACACIA_SLAB, Items.ACACIA_PLANKS);
					offerWoodenStool(ACACIA_STOOL, Items.ACACIA_SLAB, Items.ACACIA_PLANKS);
					offerBench(DARK_OAK_BENCH, Items.DARK_OAK_SLAB, Items.DARK_OAK_PLANKS);
					offerWoodenSeat(DARK_OAK_SEAT, Items.DARK_OAK_SLAB, Items.DARK_OAK_PLANKS);
					offerWoodenStool(DARK_OAK_STOOL, Items.DARK_OAK_SLAB, Items.DARK_OAK_PLANKS);
					offerBench(MANGROVE_BENCH, Items.MANGROVE_SLAB, Items.MANGROVE_PLANKS);
					offerWoodenSeat(MANGROVE_SEAT, Items.MANGROVE_SLAB, Items.MANGROVE_PLANKS);
					offerWoodenStool(MANGROVE_STOOL, Items.MANGROVE_SLAB, Items.MANGROVE_PLANKS);
					offerBench(CHERRY_BENCH, Items.CHERRY_SLAB, Items.CHERRY_PLANKS);
					offerWoodenSeat(CHERRY_SEAT, Items.CHERRY_SLAB, Items.CHERRY_PLANKS);
					offerWoodenStool(CHERRY_STOOL, Items.CHERRY_SLAB, Items.CHERRY_PLANKS);
					offerBench(PALE_OAK_BENCH, Items.PALE_OAK_SLAB, Items.PALE_OAK_PLANKS);
					offerWoodenSeat(PALE_OAK_SEAT, Items.PALE_OAK_SLAB, Items.PALE_OAK_PLANKS);
					offerWoodenStool(PALE_OAK_STOOL, Items.PALE_OAK_SLAB, Items.PALE_OAK_PLANKS);
					offerBench(CRIMSON_BENCH, Items.CRIMSON_SLAB, Items.CRIMSON_PLANKS);
					offerWoodenSeat(CRIMSON_SEAT, Items.CRIMSON_SLAB, Items.CRIMSON_PLANKS);
					offerWoodenStool(CRIMSON_STOOL, Items.CRIMSON_SLAB, Items.CRIMSON_PLANKS);
					offerBench(WARPED_BENCH, Items.WARPED_SLAB, Items.WARPED_PLANKS);
					offerWoodenSeat(WARPED_SEAT, Items.WARPED_SLAB, Items.WARPED_PLANKS);
					offerWoodenStool(WARPED_STOOL, Items.WARPED_SLAB, Items.WARPED_PLANKS);
					offerBench(BAMBOO_BENCH, Items.BAMBOO_SLAB, Items.BAMBOO_PLANKS);
					offerWoodenSeat(BAMBOO_SEAT, Items.BAMBOO_SLAB, Items.BAMBOO_PLANKS);
					offerWoodenStool(BAMBOO_STOOL, Items.BAMBOO_SLAB, Items.BAMBOO_PLANKS);

					offerColoredFlowerPot(RED_FLOWER_POTS[0], Items.RED_DYE, "red");
					offerColoredFlowerPot(ORANGE_FLOWER_POTS[0], Items.ORANGE_DYE, "orange");
					offerColoredFlowerPot(YELLOW_FLOWER_POTS[0], Items.YELLOW_DYE, "yellow");
					offerColoredFlowerPot(LIME_FLOWER_POTS[0], Items.LIME_DYE, "lime");
					offerColoredFlowerPot(GREEN_FLOWER_POTS[0], Items.GREEN_DYE, "green");
					offerColoredFlowerPot(CYAN_FLOWER_POTS[0], Items.CYAN_DYE, "cyan");
					offerColoredFlowerPot(LIGHT_BLUE_FLOWER_POTS[0], Items.LIGHT_BLUE_DYE, "light_blue");
					offerColoredFlowerPot(BLUE_FLOWER_POTS[0], Items.BLUE_DYE, "blue");
					offerColoredFlowerPot(PURPLE_FLOWER_POTS[0], Items.PURPLE_DYE, "purple");
					offerColoredFlowerPot(MAGENTA_FLOWER_POTS[0], Items.MAGENTA_DYE, "magenta");
					offerColoredFlowerPot(PINK_FLOWER_POTS[0], Items.PINK_DYE, "pink");
					offerColoredFlowerPot(BROWN_FLOWER_POTS[0], Items.BROWN_DYE, "brown");
					offerColoredFlowerPot(WHITE_FLOWER_POTS[0], Items.WHITE_DYE, "white");
					offerColoredFlowerPot(LIGHT_GRAY_FLOWER_POTS[0], Items.LIGHT_GRAY_DYE, "light_gray");
					offerColoredFlowerPot(GRAY_FLOWER_POTS[0], Items.GRAY_DYE, "gray");
					offerColoredFlowerPot(BLACK_FLOWER_POTS[0], Items.BLACK_DYE, "black");

					createShaped(RecipeCategory.DECORATIONS, LARGE_FLOWER_POTS[0], 1).input('X', Items.BRICK).pattern("X X").pattern("XXX").criterion("has_brick", this.conditionsFromItem(Items.BRICK)).offerTo(exporter);
					offerLargeFlowerPot(RED_LARGE_FLOWER_POTS[0], Items.RED_DYE, "red");
					offerLargeFlowerPot(ORANGE_LARGE_FLOWER_POTS[0], Items.ORANGE_DYE, "orange");
					offerLargeFlowerPot(YELLOW_LARGE_FLOWER_POTS[0], Items.YELLOW_DYE, "yellow");
					offerLargeFlowerPot(LIME_LARGE_FLOWER_POTS[0], Items.LIME_DYE, "lime");
					offerLargeFlowerPot(GREEN_LARGE_FLOWER_POTS[0], Items.GREEN_DYE, "green");
					offerLargeFlowerPot(CYAN_LARGE_FLOWER_POTS[0], Items.CYAN_DYE, "cyan");
					offerLargeFlowerPot(LIGHT_BLUE_LARGE_FLOWER_POTS[0], Items.LIGHT_BLUE_DYE, "light_blue");
					offerLargeFlowerPot(BLUE_LARGE_FLOWER_POTS[0], Items.BLUE_DYE, "blue");
					offerLargeFlowerPot(PURPLE_LARGE_FLOWER_POTS[0], Items.PURPLE_DYE, "purple");
					offerLargeFlowerPot(MAGENTA_LARGE_FLOWER_POTS[0], Items.MAGENTA_DYE, "magenta");
					offerLargeFlowerPot(PINK_LARGE_FLOWER_POTS[0], Items.PINK_DYE, "pink");
					offerLargeFlowerPot(BROWN_LARGE_FLOWER_POTS[0], Items.BROWN_DYE, "brown");
					offerLargeFlowerPot(WHITE_LARGE_FLOWER_POTS[0], Items.WHITE_DYE, "white");
					offerLargeFlowerPot(LIGHT_GRAY_LARGE_FLOWER_POTS[0], Items.LIGHT_GRAY_DYE, "light_gray");
					offerLargeFlowerPot(GRAY_LARGE_FLOWER_POTS[0], Items.GRAY_DYE, "gray");
					offerLargeFlowerPot(BLACK_LARGE_FLOWER_POTS[0], Items.BLACK_DYE, "black");

					offerHangingFlowerPot(HANGING_FLOWER_POTS[0], Items.FLOWER_POT, null, null);
					offerHangingFlowerPot(RED_HANGING_FLOWER_POTS[0], RED_FLOWER_POTS[0], Items.RED_DYE, "red");
					offerHangingFlowerPot(ORANGE_HANGING_FLOWER_POTS[0], ORANGE_FLOWER_POTS[0], Items.ORANGE_DYE, "orange");
					offerHangingFlowerPot(YELLOW_HANGING_FLOWER_POTS[0], YELLOW_FLOWER_POTS[0], Items.YELLOW_DYE, "yellow");
					offerHangingFlowerPot(LIME_HANGING_FLOWER_POTS[0], LIME_FLOWER_POTS[0], Items.LIME_DYE, "lime");
					offerHangingFlowerPot(GREEN_HANGING_FLOWER_POTS[0], GREEN_FLOWER_POTS[0], Items.GREEN_DYE, "green");
					offerHangingFlowerPot(CYAN_HANGING_FLOWER_POTS[0], CYAN_FLOWER_POTS[0], Items.CYAN_DYE, "cyan");
					offerHangingFlowerPot(LIGHT_BLUE_HANGING_FLOWER_POTS[0], LIGHT_BLUE_FLOWER_POTS[0], Items.LIGHT_BLUE_DYE, "light_blue");
					offerHangingFlowerPot(BLUE_HANGING_FLOWER_POTS[0], BLUE_FLOWER_POTS[0], Items.BLUE_DYE, "blue");
					offerHangingFlowerPot(PURPLE_HANGING_FLOWER_POTS[0], PURPLE_FLOWER_POTS[0], Items.PURPLE_DYE, "purple");
					offerHangingFlowerPot(MAGENTA_HANGING_FLOWER_POTS[0], MAGENTA_FLOWER_POTS[0], Items.MAGENTA_DYE, "magenta");
					offerHangingFlowerPot(PINK_HANGING_FLOWER_POTS[0], PINK_FLOWER_POTS[0], Items.PINK_DYE, "pink");
					offerHangingFlowerPot(BROWN_HANGING_FLOWER_POTS[0], BROWN_FLOWER_POTS[0], Items.BROWN_DYE, "brown");
					offerHangingFlowerPot(WHITE_HANGING_FLOWER_POTS[0], WHITE_FLOWER_POTS[0], Items.WHITE_DYE, "white");
					offerHangingFlowerPot(LIGHT_GRAY_HANGING_FLOWER_POTS[0], LIGHT_GRAY_FLOWER_POTS[0], Items.LIGHT_GRAY_DYE, "light_gray");
					offerHangingFlowerPot(GRAY_HANGING_FLOWER_POTS[0], GRAY_FLOWER_POTS[0], Items.GRAY_DYE, "gray");
					offerHangingFlowerPot(BLACK_HANGING_FLOWER_POTS[0], BLACK_FLOWER_POTS[0], Items.BLACK_DYE, "black");

					offerCushion(RED_CUSHION, Items.RED_CARPET, Items.RED_WOOL);
					offerOttoman(RED_OTTOMAN, Items.RED_WOOL);
					offerSeat(RED_SEAT, Items.RED_WOOL);
					offerStool(RED_STOOL, RED_CUSHION);
					offerCushion(ORANGE_CUSHION, Items.ORANGE_CARPET, Items.ORANGE_WOOL);
					offerOttoman(ORANGE_OTTOMAN, Items.ORANGE_WOOL);
					offerSeat(ORANGE_SEAT, Items.ORANGE_WOOL);
					offerStool(ORANGE_STOOL, ORANGE_CUSHION);
					offerCushion(YELLOW_CUSHION, Items.YELLOW_CARPET, Items.YELLOW_WOOL);
					offerOttoman(YELLOW_OTTOMAN, Items.YELLOW_WOOL);
					offerSeat(YELLOW_SEAT, Items.YELLOW_WOOL);
					offerStool(YELLOW_STOOL, YELLOW_CUSHION);
					offerCushion(LIME_CUSHION, Items.LIME_CARPET, Items.LIME_WOOL);
					offerOttoman(LIME_OTTOMAN, Items.LIME_WOOL);
					offerSeat(LIME_SEAT, Items.LIME_WOOL);
					offerStool(LIME_STOOL, LIME_CUSHION);
					offerCushion(GREEN_CUSHION, Items.GREEN_CARPET, Items.GREEN_WOOL);
					offerOttoman(GREEN_OTTOMAN, Items.GREEN_WOOL);
					offerSeat(GREEN_SEAT, Items.GREEN_WOOL);
					offerStool(GREEN_STOOL, GREEN_CUSHION);
					offerCushion(CYAN_CUSHION, Items.CYAN_CARPET, Items.CYAN_WOOL);
					offerOttoman(CYAN_OTTOMAN, Items.CYAN_WOOL);
					offerSeat(CYAN_SEAT, Items.CYAN_WOOL);
					offerStool(CYAN_STOOL, CYAN_CUSHION);
					offerCushion(LIGHT_BLUE_CUSHION, Items.LIGHT_BLUE_CARPET, Items.LIGHT_BLUE_WOOL);
					offerOttoman(LIGHT_BLUE_OTTOMAN, Items.LIGHT_BLUE_WOOL);
					offerSeat(LIGHT_BLUE_SEAT, Items.LIGHT_BLUE_WOOL);
					offerStool(LIGHT_BLUE_STOOL, LIGHT_BLUE_CUSHION);
					offerCushion(BLUE_CUSHION, Items.BLUE_CARPET, Items.BLUE_WOOL);
					offerOttoman(BLUE_OTTOMAN, Items.BLUE_WOOL);
					offerSeat(BLUE_SEAT, Items.BLUE_WOOL);
					offerStool(BLUE_STOOL, BLUE_CUSHION);
					offerCushion(PURPLE_CUSHION, Items.PURPLE_CARPET, Items.PURPLE_WOOL);
					offerOttoman(PURPLE_OTTOMAN, Items.PURPLE_WOOL);
					offerSeat(PURPLE_SEAT, Items.PURPLE_WOOL);
					offerStool(PURPLE_STOOL, PURPLE_CUSHION);
					offerCushion(MAGENTA_CUSHION, Items.MAGENTA_CARPET, Items.MAGENTA_WOOL);
					offerOttoman(MAGENTA_OTTOMAN, Items.MAGENTA_WOOL);
					offerSeat(MAGENTA_SEAT, Items.MAGENTA_WOOL);
					offerStool(MAGENTA_STOOL, MAGENTA_CUSHION);
					offerCushion(PINK_CUSHION, Items.PINK_CARPET, Items.PINK_WOOL);
					offerOttoman(PINK_OTTOMAN, Items.PINK_WOOL);
					offerSeat(PINK_SEAT, Items.PINK_WOOL);
					offerStool(PINK_STOOL, PINK_CUSHION);
					offerCushion(BROWN_CUSHION, Items.BROWN_CARPET, Items.BROWN_WOOL);
					offerOttoman(BROWN_OTTOMAN, Items.BROWN_WOOL);
					offerSeat(BROWN_SEAT, Items.BROWN_WOOL);
					offerStool(BROWN_STOOL, BROWN_CUSHION);
					offerCushion(WHITE_CUSHION, Items.WHITE_CARPET, Items.WHITE_WOOL);
					offerOttoman(WHITE_OTTOMAN, Items.WHITE_WOOL);
					offerSeat(WHITE_SEAT, Items.WHITE_WOOL);
					offerStool(WHITE_STOOL, WHITE_CUSHION);
					offerCushion(LIGHT_GRAY_CUSHION, Items.LIGHT_GRAY_CARPET, Items.LIGHT_GRAY_WOOL);
					offerOttoman(LIGHT_GRAY_OTTOMAN, Items.LIGHT_GRAY_WOOL);
					offerSeat(LIGHT_GRAY_SEAT, Items.LIGHT_GRAY_WOOL);
					offerStool(LIGHT_GRAY_STOOL, LIGHT_GRAY_CUSHION);
					offerCushion(GRAY_CUSHION, Items.GRAY_CARPET, Items.GRAY_WOOL);
					offerOttoman(GRAY_OTTOMAN, Items.GRAY_WOOL);
					offerSeat(GRAY_SEAT, Items.GRAY_WOOL);
					offerStool(GRAY_STOOL, GRAY_CUSHION);
					offerCushion(BLACK_CUSHION, Items.BLACK_CARPET, Items.BLACK_WOOL);
					offerOttoman(BLACK_OTTOMAN, Items.BLACK_WOOL);
					offerSeat(BLACK_SEAT, Items.BLACK_WOOL);
					offerStool(BLACK_STOOL, BLACK_CUSHION);

					offerDecorativeCarpet(RED_DECORATIVE_CARPET, Items.RED_CARPET, Items.RED_GLAZED_TERRACOTTA);
					offerDecorativeCarpet(ORANGE_DECORATIVE_CARPET, Items.ORANGE_CARPET, Items.ORANGE_GLAZED_TERRACOTTA);
					offerDecorativeCarpet(YELLOW_DECORATIVE_CARPET, Items.YELLOW_CARPET, Items.YELLOW_GLAZED_TERRACOTTA);
					offerDecorativeCarpet(LIME_DECORATIVE_CARPET, Items.LIME_CARPET, Items.LIME_GLAZED_TERRACOTTA);
					offerDecorativeCarpet(GREEN_DECORATIVE_CARPET, Items.GREEN_CARPET, Items.GREEN_GLAZED_TERRACOTTA);
					offerDecorativeCarpet(CYAN_DECORATIVE_CARPET, Items.CYAN_CARPET, Items.CYAN_GLAZED_TERRACOTTA);
					offerDecorativeCarpet(LIGHT_BLUE_DECORATIVE_CARPET, Items.LIGHT_BLUE_CARPET, Items.LIGHT_BLUE_GLAZED_TERRACOTTA);
					offerDecorativeCarpet(BLUE_DECORATIVE_CARPET, Items.BLUE_CARPET, Items.BLUE_GLAZED_TERRACOTTA);
					offerDecorativeCarpet(PURPLE_DECORATIVE_CARPET, Items.PURPLE_CARPET, Items.PURPLE_GLAZED_TERRACOTTA);
					offerDecorativeCarpet(MAGENTA_DECORATIVE_CARPET, Items.MAGENTA_CARPET, Items.MAGENTA_GLAZED_TERRACOTTA);
					offerDecorativeCarpet(PINK_DECORATIVE_CARPET, Items.PINK_CARPET, Items.PINK_GLAZED_TERRACOTTA);
					offerDecorativeCarpet(BROWN_DECORATIVE_CARPET, Items.BROWN_CARPET, Items.BROWN_GLAZED_TERRACOTTA);
					offerDecorativeCarpet(WHITE_DECORATIVE_CARPET, Items.WHITE_CARPET, Items.WHITE_GLAZED_TERRACOTTA);
					offerDecorativeCarpet(LIGHT_GRAY_DECORATIVE_CARPET, Items.LIGHT_GRAY_CARPET, Items.LIGHT_GRAY_GLAZED_TERRACOTTA);
					offerDecorativeCarpet(GRAY_DECORATIVE_CARPET, Items.GRAY_CARPET, Items.GRAY_GLAZED_TERRACOTTA);
					offerDecorativeCarpet(BLACK_DECORATIVE_CARPET, Items.BLACK_CARPET, Items.BLACK_GLAZED_TERRACOTTA);

					offerButton(GLOWSTONE_BUTTON, Items.GLOWSTONE);
					offerButton(PEARLESCENT_FROGLIGHT_BUTTON, Items.PEARLESCENT_FROGLIGHT);
					offerButton(OCHRE_FROGLIGHT_BUTTON, Items.OCHRE_FROGLIGHT);
					offerButton(VERDANT_FROGLIGHT_BUTTON, Items.VERDANT_FROGLIGHT);
					offerButton(REDSTONE_LAMP_BUTTON, Items.REDSTONE_LAMP);
					offerButton(SEA_LANTERN_BUTTON, Items.SEA_LANTERN);
					offerButton(SHROOMLIGHT_BUTTON, Items.SHROOMLIGHT);
					offerButton(COPPER_BUTTON, Items.COPPER_BULB);
					offerButton(EXPOSED_COPPER_BUTTON, Items.EXPOSED_COPPER_BULB);
					offerButton(WEATHERED_COPPER_BUTTON, Items.WEATHERED_COPPER_BULB);
					offerButton(OXIDIZED_COPPER_BUTTON, Items.OXIDIZED_COPPER_BULB);
					offerButton(OBSIDIAN_BUTTON, Items.CRYING_OBSIDIAN);

					createShaped(RecipeCategory.BUILDING_BLOCKS, PAPER_BLOCK, 1)
							.input('#', Items.PAPER).input('/', Items.STICK)
							.pattern("###")
							.pattern("#/#")
							.pattern("###")
							.criterion("has_paper", conditionsFromItem(Items.PAPER))
							.offerTo(exporter);
					createShaped(RecipeCategory.BUILDING_BLOCKS, PAPER_PANEL, 16)
							.input('#', PAPER_BLOCK)
							.pattern("###")
							.pattern("###")
							.criterion("has_paper_block", conditionsFromItem(PAPER_BLOCK))
							.offerTo(exporter);
					createShapeless(RecipeCategory.BUILDING_BLOCKS, PAPER_PANEL, 1)
							.input(HORIZONTAL_PAPER_PANEL)
							.criterion("has_paper_panel", conditionsFromItem(PAPER_PANEL))
							.offerTo(exporter, "paper_panel_from_horizontal");
					createShapeless(RecipeCategory.BUILDING_BLOCKS, WAXED_PAPER_PANEL, 1)
							.input(WAXED_HORIZONTAL_PAPER_PANEL)
							.criterion("has_paper_panel", conditionsFromItem(PAPER_PANEL))
							.offerTo(exporter, "waxed_paper_panel_from_horizontal");
					createShapeless(RecipeCategory.BUILDING_BLOCKS, HORIZONTAL_PAPER_PANEL, 1)
							.input(PAPER_PANEL)
							.criterion("has_paper_panel", conditionsFromItem(PAPER_PANEL))
							.offerTo(exporter, "horizontal_panel_from_normal");
					createShapeless(RecipeCategory.BUILDING_BLOCKS, WAXED_HORIZONTAL_PAPER_PANEL, 1)
							.input(WAXED_PAPER_PANEL)
							.criterion("has_paper_panel", conditionsFromItem(PAPER_PANEL))
							.offerTo(exporter, "waxed_horizontal_panel_from_normal");
					createShaped(RecipeCategory.BUILDING_BLOCKS, PAPER_PANEL_DOOR, 1)
							.input('#', PAPER_PANEL)
							.pattern("##")
							.pattern("##")
							.pattern("##")
							.criterion("has_paper_panel", conditionsFromItem(PAPER_PANEL))
							.offerTo(exporter);
					createShaped(RecipeCategory.BUILDING_BLOCKS, HORIZONTAL_PAPER_PANEL_DOOR, 1)
							.input('#', HORIZONTAL_PAPER_PANEL)
							.pattern("##")
							.pattern("##")
							.pattern("##")
							.criterion("has_paper_panel", conditionsFromItem(PAPER_PANEL))
							.offerTo(exporter);
					createShapeless(RecipeCategory.BUILDING_BLOCKS, CARDBOARD_BLOCK, 1)
							.input(SAWDUST, 9)
							.criterion("has_sawdust", conditionsFromItem(SAWDUST))
							.offerTo(exporter);
					createShaped(RecipeCategory.BUILDING_BLOCKS, CARDBOARD_BOX, 4)
							.input('#', CARDBOARD_BLOCK)
							.pattern("###")
							.pattern("# #")
							.pattern("###")
							.criterion("has_cardboard_block", conditionsFromItem(CARDBOARD_BLOCK))
							.offerTo(exporter);
					createShaped(RecipeCategory.BUILDING_BLOCKS, CARDBOARD_DOOR, 3)
							.input('#', CARDBOARD_BLOCK)
							.pattern("##")
							.pattern("##")
							.pattern("##")
							.criterion("has_cardboard_block", conditionsFromItem(CARDBOARD_BLOCK))
							.offerTo(exporter);
					createShaped(RecipeCategory.BUILDING_BLOCKS, WAXED_CARDBOARD_DOOR, 3)
							.input('#', WAXED_CARDBOARD_BLOCK)
							.pattern("##")
							.pattern("##")
							.pattern("##")
							.criterion("has_cardboard_block", conditionsFromItem(CARDBOARD_BLOCK))
							.offerTo(exporter);
					createShaped(RecipeCategory.BUILDING_BLOCKS, CARDBOARD_PANE, 16)
							.input('#', CARDBOARD_BLOCK)
							.pattern("###")
							.pattern("###")
							.criterion("has_cardboard_block", conditionsFromItem(CARDBOARD_BLOCK))
							.offerTo(exporter);
					createShaped(RecipeCategory.BUILDING_BLOCKS, WAXED_CARDBOARD_PANE, 16)
							.input('#', WAXED_CARDBOARD_BLOCK)
							.pattern("###")
							.pattern("###")
							.criterion("has_cardboard_block", conditionsFromItem(CARDBOARD_BLOCK))
							.offerTo(exporter);
					createShaped(RecipeCategory.BUILDING_BLOCKS, CARDBOARD_TRAPDOOR, 2)
							.input('#', CARDBOARD_BLOCK)
							.pattern("##")
							.pattern("##")
							.criterion("has_cardboard_block", conditionsFromItem(CARDBOARD_BLOCK))
							.offerTo(exporter);
					createShaped(RecipeCategory.BUILDING_BLOCKS, WAXED_CARDBOARD_TRAPDOOR, 2)
							.input('#', WAXED_CARDBOARD_BLOCK)
							.pattern("##")
							.pattern("##")
							.criterion("has_cardboard_block", conditionsFromItem(CARDBOARD_BLOCK))
							.offerTo(exporter);
					createShaped(RecipeCategory.BUILDING_BLOCKS, CARDBOARD_GATE, 4)
							.input('B', CARDBOARD_BLOCK)
							.input('#', CARDBOARD_PANE)
							.pattern("#B#")
							.pattern("#B#")
							.criterion("has_cardboard_block", conditionsFromItem(CARDBOARD_BLOCK))
							.offerTo(exporter);
					createShaped(RecipeCategory.BUILDING_BLOCKS, WAXED_CARDBOARD_GATE, 4)
							.input('B', WAXED_CARDBOARD_BLOCK)
							.input('#', WAXED_CARDBOARD_PANE)
							.pattern("#B#")
							.pattern("#B#")
							.criterion("has_cardboard_block", conditionsFromItem(CARDBOARD_BLOCK))
							.offerTo(exporter);
					createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, CARDBOARD_SLAB, Ingredient.ofItem(CARDBOARD_BLOCK))
							.criterion("has_cardboard_block", conditionsFromItem(CARDBOARD_BLOCK))
							.offerTo(exporter);
					createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, WAXED_CARDBOARD_SLAB, Ingredient.ofItem(WAXED_CARDBOARD_BLOCK))
							.criterion("has_cardboard_block", conditionsFromItem(CARDBOARD_BLOCK))
							.offerTo(exporter);
					createStairsRecipe(CARDBOARD_STAIRS, Ingredient.ofItem(CARDBOARD_BLOCK))
							.criterion("has_cardboard_block", conditionsFromItem(CARDBOARD_BLOCK))
							.offerTo(exporter);
					createStairsRecipe(WAXED_CARDBOARD_STAIRS, Ingredient.ofItem(WAXED_CARDBOARD_BLOCK))
							.criterion("has_cardboard_block", conditionsFromItem(CARDBOARD_BLOCK))
							.offerTo(exporter);
					createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, CARDBOARD_BOX_SLAB, Ingredient.ofItem(CARDBOARD_BOX))
							.criterion("has_cardboard_box", conditionsFromItem(CARDBOARD_BLOCK))
							.offerTo(exporter);
					createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, WAXED_CARDBOARD_BOX_SLAB, Ingredient.ofItem(WAXED_CARDBOARD_BOX))
							.criterion("has_cardboard_box", conditionsFromItem(CARDBOARD_BLOCK))
							.offerTo(exporter);
					createStairsRecipe(CARDBOARD_BOX_STAIRS, Ingredient.ofItem(CARDBOARD_BOX))
							.criterion("has_cardboard_box", conditionsFromItem(CARDBOARD_BOX))
							.offerTo(exporter);
					createStairsRecipe(WAXED_CARDBOARD_BOX_STAIRS, Ingredient.ofItem(WAXED_CARDBOARD_BOX))
							.criterion("has_cardboard_box", conditionsFromItem(CARDBOARD_BOX))
							.offerTo(exporter);
				}

				private void offerCushion(ItemConvertible output, ItemConvertible carpet, ItemConvertible wool) {
					createShaped(RecipeCategory.DECORATIONS, output, 1)
							.input('_', carpet)
							.input('X', wool)
							.pattern("_")
							.pattern("X")
							.criterion(hasItem(wool), conditionsFromItem(wool))
							.criterion(hasItem(carpet), conditionsFromItem(carpet))
							.group("cushion")
							.offerTo(exporter);
				}
				private void offerOttoman(ItemConvertible output, ItemConvertible wool) {
					createShaped(RecipeCategory.DECORATIONS, output, 1)
							.input('X', wool)
							.input('O', ItemTags.PLANKS)
							.pattern("XX")
							.pattern("OO")
							.group("ottoman")
							.criterion(hasItem(wool), conditionsFromItem(wool))
							.offerTo(exporter);
				}
				private void offerSeat(ItemConvertible output, ItemConvertible wool) {
					createShaped(RecipeCategory.DECORATIONS, output, 1)
							.input('X', wool)
							.input('O', ItemTags.PLANKS)
							.pattern("X ")
							.pattern("XX")
							.pattern("OO")
							.group("seat")
							.criterion(hasItem(wool), conditionsFromItem(wool))
							.offerTo(exporter);
				}
				private void offerStool(ItemConvertible output, ItemConvertible cushion) {
					createShaped(RecipeCategory.DECORATIONS, output, 1)
							.input('X', cushion)
							.input('O', ItemTags.PLANKS)
							.pattern("X")
							.pattern("O")
							.group("wool_stool")
							.criterion(hasItem(cushion), conditionsFromItem(cushion))
							.offerTo(exporter);
				}
				private void offerBench(ItemConvertible output, ItemConvertible slab, ItemConvertible planks) {
					createShaped(RecipeCategory.DECORATIONS, output, 1)
							.input('X', slab)
							.input('O', planks)
							.pattern("XX")
							.pattern("OO")
							.group("wood_stool")
							.criterion("has_planks", this.conditionsFromTag(ItemTags.PLANKS))
							.offerTo(exporter);
				}
				private void offerWoodenSeat(ItemConvertible output, ItemConvertible slab, ItemConvertible planks) {
					createShaped(RecipeCategory.DECORATIONS, output, 1)
							.input('X', slab)
							.input('O', planks)
							.pattern("X ")
							.pattern("XX")
							.pattern("OO")
							.group("wood_stool")
							.criterion("has_planks", this.conditionsFromTag(ItemTags.PLANKS))
							.offerTo(exporter);
				}
				private void offerWoodenStool(ItemConvertible output, ItemConvertible slab, ItemConvertible planks) {
					createShaped(RecipeCategory.DECORATIONS, output, 1)
							.input('X', slab)
							.input('O', planks)
							.pattern("X")
							.pattern("O")
							.group("wood_stool")
							.criterion("has_planks", this.conditionsFromTag(ItemTags.PLANKS))
							.offerTo(exporter);
				}
				private void offerDecorativeCarpet(ItemConvertible output, ItemConvertible carpet, ItemConvertible glazedTerracotta) {
					createShapeless(RecipeCategory.DECORATIONS, output, 2)
							.input(carpet)
							.input(glazedTerracotta)
							.group("decorative_carpet")
							.criterion("has_carpet", this.conditionsFromTag(ItemTags.WOOL_CARPETS))
							.offerTo(this.exporter);
				}
				private void offerButton(ItemConvertible output, ItemConvertible material) {
					createShapeless(RecipeCategory.REDSTONE, output, 1)
							.input(material)
							.input(Items.REDSTONE)
							.criterion("has_redstone", this.conditionsFromItem(Items.REDSTONE))
							.group("button")
							.offerTo(this.exporter);
				}
				private void offerColoredFlowerPot(ItemConvertible output, ItemConvertible dye, String color) {
					createShapeless(RecipeCategory.DECORATIONS, output, 1)
							.input(dye)
							.input(FLOWER_POT_ITEM_TAG)
							.criterion("has_"+color+"_dye", this.conditionsFromItem(dye))
							.group("flower_pot")
							.offerTo(this.exporter);
				}
				private void offerHangingFlowerPot(ItemConvertible output, ItemConvertible pot, @Nullable ItemConvertible dye, @Nullable String color) {
					if (color != null) {
						createShapeless(RecipeCategory.DECORATIONS, output, 1)
								.input(dye)
								.input(HANGING_FLOWER_POT_ITEM_TAG)
								.criterion("has_"+color+"_dye", this.conditionsFromItem(dye))
								.offerTo(this.exporter, color+"_hanging_flower_pot_dyed");
					}
					createShaped(RecipeCategory.DECORATIONS, output, 1)
							.input('U', pot)
							.input('@', ConventionalItemTags.STRINGS)
							.pattern(" @ ")
							.pattern("@ @")
							.pattern(" U ")
							.criterion("has_string", this.conditionsFromItem(Items.STRING))
							.offerTo(this.exporter);
				}
				private void offerLargeFlowerPot(ItemConvertible output, ItemConvertible dye, String color) {
					createShapeless(RecipeCategory.DECORATIONS, output, 1)
							.input(dye)
							.input(LARGE_FLOWER_POT_ITEM_TAG)
							.criterion("has_"+color+"_dye", this.conditionsFromItem(dye))
							.offerTo(this.exporter);
				}
			};
		}

	}

	private static class ItemTagGenerator extends FabricTagProvider<Item> {
		public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
			super(output, RegistryKeys.ITEM, registriesFuture);
		}

		@Override
		protected void configure(RegistryWrapper.WrapperLookup lookup) {
			var tag = getOrCreateTagBuilder(FLOWER_POT_ITEM_TAG);
			tag.add(Items.FLOWER_POT);
			for(ColoredFlowerPotBlock b : RED_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : ORANGE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : YELLOW_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : LIME_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : GREEN_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : CYAN_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : LIGHT_BLUE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : BLUE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : PURPLE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : MAGENTA_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : PINK_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : BROWN_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : WHITE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : LIGHT_GRAY_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : GRAY_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : BLACK_FLOWER_POTS) {tag.add(b.asItem());}
			tag = getOrCreateTagBuilder(LARGE_FLOWER_POT_ITEM_TAG);
			for(ColoredFlowerPotBlock b : LARGE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : RED_LARGE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : ORANGE_LARGE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : YELLOW_LARGE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : LIME_LARGE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : GREEN_LARGE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : CYAN_LARGE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : LIGHT_BLUE_LARGE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : BLUE_LARGE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : PURPLE_LARGE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : MAGENTA_LARGE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : PINK_LARGE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : BROWN_LARGE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : WHITE_LARGE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : LIGHT_GRAY_LARGE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : GRAY_LARGE_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : BLACK_LARGE_FLOWER_POTS) {tag.add(b.asItem());}
			tag = getOrCreateTagBuilder(HANGING_FLOWER_POT_ITEM_TAG);
			for(ColoredFlowerPotBlock b : HANGING_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : RED_HANGING_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : ORANGE_HANGING_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : YELLOW_HANGING_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : LIME_HANGING_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : GREEN_HANGING_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : CYAN_HANGING_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : LIGHT_BLUE_HANGING_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : BLUE_HANGING_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : PURPLE_HANGING_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : MAGENTA_HANGING_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : PINK_HANGING_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : BROWN_HANGING_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : WHITE_HANGING_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : LIGHT_GRAY_HANGING_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : GRAY_HANGING_FLOWER_POTS) {tag.add(b.asItem());}
			for(ColoredFlowerPotBlock b : BLACK_HANGING_FLOWER_POTS) {tag.add(b.asItem());}
		}
	}

	private static class BlockTagGenerator extends FabricTagProvider<Block> {
		public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
			super(output, RegistryKeys.BLOCK, registriesFuture);
		}

		@Override
		protected void configure(RegistryWrapper.WrapperLookup lookup) {
			getOrCreateTagBuilder(BlockTags.WALLS).add(CARDBOARD_GATE).add(WAXED_CARDBOARD_GATE).add(WET_CARDBOARD_GATE);
			getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
					.add(OAK_BENCH).add(OAK_SEAT).add(OAK_STOOL)
					.add(SPRUCE_BENCH).add(SPRUCE_SEAT).add(SPRUCE_STOOL)
					.add(BIRCH_BENCH).add(BIRCH_SEAT).add(BIRCH_STOOL)
					.add(JUNGLE_BENCH).add(JUNGLE_SEAT).add(JUNGLE_STOOL)
					.add(ACACIA_BENCH).add(ACACIA_SEAT).add(ACACIA_STOOL)
					.add(DARK_OAK_BENCH).add(DARK_OAK_SEAT).add(DARK_OAK_STOOL)
					.add(MANGROVE_BENCH).add(MANGROVE_SEAT).add(MANGROVE_STOOL)
					.add(CHERRY_BENCH).add(CHERRY_SEAT).add(CHERRY_STOOL)
					.add(PALE_OAK_BENCH).add(PALE_OAK_SEAT).add(PALE_OAK_STOOL)
					.add(CRIMSON_BENCH).add(CRIMSON_SEAT).add(CRIMSON_STOOL)
					.add(WARPED_BENCH).add(WARPED_SEAT).add(WARPED_STOOL)
					.add(BAMBOO_BENCH).add(BAMBOO_SEAT).add(BAMBOO_STOOL)
					.add(RED_CUSHION).add(RED_OTTOMAN).add(RED_SEAT).add(RED_STOOL)
					.add(ORANGE_CUSHION).add(ORANGE_OTTOMAN).add(ORANGE_SEAT).add(ORANGE_STOOL)
					.add(YELLOW_CUSHION).add(YELLOW_OTTOMAN).add(YELLOW_SEAT).add(YELLOW_STOOL)
					.add(LIME_CUSHION).add(LIME_OTTOMAN).add(LIME_SEAT).add(LIME_STOOL)
					.add(GREEN_CUSHION).add(GREEN_OTTOMAN).add(GREEN_SEAT).add(GREEN_STOOL)
					.add(CYAN_CUSHION).add(CYAN_OTTOMAN).add(CYAN_SEAT).add(CYAN_STOOL)
					.add(LIGHT_BLUE_CUSHION).add(LIGHT_BLUE_OTTOMAN).add(LIGHT_BLUE_SEAT).add(LIGHT_BLUE_STOOL)
					.add(BLUE_CUSHION).add(BLUE_OTTOMAN).add(BLUE_SEAT).add(BLUE_STOOL)
					.add(PURPLE_CUSHION).add(PURPLE_OTTOMAN).add(PURPLE_SEAT).add(PURPLE_STOOL)
					.add(MAGENTA_CUSHION).add(MAGENTA_OTTOMAN).add(MAGENTA_SEAT).add(MAGENTA_STOOL)
					.add(PINK_CUSHION).add(PINK_OTTOMAN).add(PINK_SEAT).add(PINK_STOOL)
					.add(BROWN_CUSHION).add(BROWN_OTTOMAN).add(BROWN_SEAT).add(BROWN_STOOL)
					.add(WHITE_CUSHION).add(WHITE_OTTOMAN).add(WHITE_SEAT).add(WHITE_STOOL)
					.add(LIGHT_GRAY_CUSHION).add(LIGHT_GRAY_OTTOMAN).add(LIGHT_GRAY_SEAT).add(LIGHT_GRAY_STOOL)
					.add(GRAY_CUSHION).add(GRAY_OTTOMAN).add(GRAY_SEAT).add(GRAY_STOOL)
					.add(BLACK_CUSHION).add(BLACK_OTTOMAN).add(BLACK_SEAT).add(BLACK_STOOL);
		}
	}
}
