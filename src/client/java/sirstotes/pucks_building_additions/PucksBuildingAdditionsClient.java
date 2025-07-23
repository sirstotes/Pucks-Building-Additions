package sirstotes.pucks_building_additions;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.client.rendering.SpecialBlockRendererRegistryImpl;
import net.fabricmc.fabric.mixin.client.rendering.BlockColorsMixin;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.DecoratedPotBlockEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.item.model.special.SpecialModelTypes;
import net.minecraft.util.Identifier;

public class PucksBuildingAdditionsClient implements ClientModInitializer {
	public static final EntityModelLayer SITTABLE_LAYER = new EntityModelLayer(Identifier.of(PucksBuildingAdditions.MOD_ID, "sittable"), "main");
	@Override
	public void onInitializeClient() {
		//EntityRendererRegistry.INSTANCE.register(PucksBuildingAdditions.SITTABLE, SittableEntityRenderer::new);
		// In 1.17+, use EntityRendererRegistry.register (seen below) instead of EntityRendererRegistry.INSTANCE.register (seen above)
		EntityRendererRegistry.register(PucksBuildingAdditions.SITTABLE, SittableEntityRenderer::new);

		EntityModelLayerRegistry.registerModelLayer(SITTABLE_LAYER, SittableEntityModel::getTexturedModelData);

		BlockEntityRendererFactories.register(PucksBuildingAdditionsBlocks.STOOL_BLOCK_ENTITY, StoolBlockEntityRenderer::new);
		BlockEntityRendererFactories.register(PucksBuildingAdditionsBlocks.WOOL_SITTABLE_BLOCK_ENTITY, WoolSittableBlockEntityRenderer::new);
		BlockEntityRendererFactories.register(PucksBuildingAdditionsBlocks.CUSHION_BLOCK_ENTITY, WoolSittableBlockEntityRenderer::new);
		//BlockEntityRendererFactories.register(PucksBuildingAdditionsBlocks.COLORED_POT_BLOCK_ENTITY, ColoredDecoratedPotBlockEntityRenderer::new);
		SpecialModelTypes.ID_MAPPER.put(Identifier.of(PucksBuildingAdditions.MOD_ID, "colored_decorated_pot"), ColoredDecoratedPotModelRenderer.Unbaked.CODEC);

		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.RED_DYE_GLOWING, PucksBuildingAdditionsBlocks.ORANGE_DYE_GLOWING, PucksBuildingAdditionsBlocks.YELLOW_DYE_GLOWING, PucksBuildingAdditionsBlocks.LIME_DYE_GLOWING, PucksBuildingAdditionsBlocks.GREEN_DYE_GLOWING, PucksBuildingAdditionsBlocks.CYAN_DYE_GLOWING, PucksBuildingAdditionsBlocks.LIGHT_BLUE_DYE_GLOWING, PucksBuildingAdditionsBlocks.BLUE_DYE_GLOWING, PucksBuildingAdditionsBlocks.PURPLE_DYE_GLOWING, PucksBuildingAdditionsBlocks.MAGENTA_DYE_GLOWING, PucksBuildingAdditionsBlocks.PINK_DYE_GLOWING, PucksBuildingAdditionsBlocks.BROWN_DYE_GLOWING, PucksBuildingAdditionsBlocks.WHITE_DYE_GLOWING, PucksBuildingAdditionsBlocks.LIGHT_GRAY_DYE_GLOWING, PucksBuildingAdditionsBlocks.GRAY_DYE_GLOWING, PucksBuildingAdditionsBlocks.BLACK_DYE_GLOWING,
				PucksBuildingAdditionsBlocks.RED_DYE, PucksBuildingAdditionsBlocks.ORANGE_DYE, PucksBuildingAdditionsBlocks.YELLOW_DYE, PucksBuildingAdditionsBlocks.LIME_DYE, PucksBuildingAdditionsBlocks.GREEN_DYE, PucksBuildingAdditionsBlocks.CYAN_DYE, PucksBuildingAdditionsBlocks.LIGHT_BLUE_DYE, PucksBuildingAdditionsBlocks.BLUE_DYE, PucksBuildingAdditionsBlocks.PURPLE_DYE, PucksBuildingAdditionsBlocks.MAGENTA_DYE, PucksBuildingAdditionsBlocks.PINK_DYE, PucksBuildingAdditionsBlocks.BROWN_DYE, PucksBuildingAdditionsBlocks.WHITE_DYE, PucksBuildingAdditionsBlocks.LIGHT_GRAY_DYE, PucksBuildingAdditionsBlocks.GRAY_DYE, PucksBuildingAdditionsBlocks.BLACK_DYE,
				PucksBuildingAdditionsBlocks.GLOWSTONE_DUST,
				PucksBuildingAdditionsBlocks.BLAZE_POWDER,
				PucksBuildingAdditionsBlocks.SUGAR,
				PucksBuildingAdditionsBlocks.GUNPOWDER);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.CARDBOARD_DOOR,
				PucksBuildingAdditionsBlocks.WAXED_CARDBOARD_DOOR,
				PucksBuildingAdditionsBlocks.WET_CARDBOARD_DOOR,
				PucksBuildingAdditionsBlocks.CARDBOARD_TRAPDOOR,
				PucksBuildingAdditionsBlocks.WAXED_CARDBOARD_TRAPDOOR,
				PucksBuildingAdditionsBlocks.WET_CARDBOARD_TRAPDOOR);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.RED_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.ORANGE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.YELLOW_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.LIME_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.GREEN_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.CYAN_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.LIGHT_BLUE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.BLUE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.PURPLE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.MAGENTA_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.PINK_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.BROWN_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.WHITE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.LIGHT_GRAY_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.GRAY_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.BLACK_FLOWER_POTS);

		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.LARGE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.RED_LARGE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.ORANGE_LARGE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.YELLOW_LARGE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.LIME_LARGE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.GREEN_LARGE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.CYAN_LARGE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.LIGHT_BLUE_LARGE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.BLUE_LARGE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.PURPLE_LARGE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.MAGENTA_LARGE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.PINK_LARGE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.BROWN_LARGE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.WHITE_LARGE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.LIGHT_GRAY_LARGE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.GRAY_LARGE_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.BLACK_LARGE_FLOWER_POTS);

		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.HANGING_FLOWER_POTS);

		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.RED_HANGING_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.ORANGE_HANGING_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.YELLOW_HANGING_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.LIME_HANGING_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.GREEN_HANGING_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.CYAN_HANGING_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.LIGHT_BLUE_HANGING_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.BLUE_HANGING_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.PURPLE_HANGING_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.MAGENTA_HANGING_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.PINK_HANGING_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.BROWN_HANGING_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.WHITE_HANGING_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.LIGHT_GRAY_HANGING_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.GRAY_HANGING_FLOWER_POTS);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PucksBuildingAdditionsBlocks.BLACK_HANGING_FLOWER_POTS);

//		BlockRenderLayerMap.INSTANCE.putBlocks(TexturedRenderLayers.getBeds(),
//				PucksBuildingAdditionsBlocks.RED_OTTOMAN,
//				PucksBuildingAdditionsBlocks.ORANGE_OTTOMAN,
//				PucksBuildingAdditionsBlocks.YELLOW_OTTOMAN,
//				PucksBuildingAdditionsBlocks.LIME_OTTOMAN,
//				PucksBuildingAdditionsBlocks.GREEN_OTTOMAN,
//				PucksBuildingAdditionsBlocks.CYAN_OTTOMAN,
//				PucksBuildingAdditionsBlocks.LIGHT_BLUE_OTTOMAN,
//				PucksBuildingAdditionsBlocks.BLUE_OTTOMAN,
//				PucksBuildingAdditionsBlocks.PURPLE_OTTOMAN,
//				PucksBuildingAdditionsBlocks.MAGENTA_OTTOMAN,
//				PucksBuildingAdditionsBlocks.PINK_OTTOMAN,
//				PucksBuildingAdditionsBlocks.BROWN_OTTOMAN,
//				PucksBuildingAdditionsBlocks.WHITE_OTTOMAN,
//				PucksBuildingAdditionsBlocks.LIGHT_GRAY_OTTOMAN,
//				PucksBuildingAdditionsBlocks.GRAY_OTTOMAN,
//				PucksBuildingAdditionsBlocks.BLACK_OTTOMAN);
	}
}