package sirstotes.pucks_building_additions;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.DyeColor;

public class WoolSittableBlockEntityRenderer implements BlockEntityRenderer<WoolSittableBlockEntity> {
    public WoolSittableBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(WoolSittableBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if(entity.getWorld() != null) {
            BlockState blockState = entity.getCachedState();

//            SpriteIdentifier sprite;
//            if(blockState.getBlock() instanceof WoolSittableBlock block) {
//                sprite = TexturedRenderLayers.getBedTextureId(block.getColor());
//            } else {
//                sprite = TexturedRenderLayers.getBedTextureId(DyeColor.RED);
//            }

            matrices.push();
            BakedModel bakedmodel = MinecraftClient.getInstance().getBakedModelManager().getBlockModels().getModel(blockState);
            //VertexConsumer vertexConsumer = sprite.getVertexConsumer(vertexConsumers, RenderLayer::getEntitySolid);
            VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getSolid());
            //MinecraftClient.getInstance().getBlockRenderManager().getModelRenderer().render(matrices.peek(), vertexConsumer, blockState, bakedmodel, 1f, 0f, 1f, light, overlay);
            MinecraftClient.getInstance().getBlockRenderManager().getModelRenderer().render(entity.getWorld(), bakedmodel, blockState, entity.getPos(), matrices, vertexConsumer, false, entity.getWorld().getRandom(), blockState.getRenderingSeed(entity.getPos()), overlay);

            matrices.pop();
        }
    }
}
