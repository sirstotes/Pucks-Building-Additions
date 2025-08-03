package sirstotes.pucks_building_additions;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;

public class WoolSittableBlockEntityRenderer implements BlockEntityRenderer<WoolSittableBlockEntity> {
    public WoolSittableBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(WoolSittableBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if(entity.getWorld() != null) {
            BlockState blockState = entity.getCachedState();

            matrices.push();
            BakedModel bakedmodel = MinecraftClient.getInstance().getBakedModelManager().getBlockModels().getModel(blockState);
            VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getSolid());
            MinecraftClient.getInstance().getBlockRenderManager().getModelRenderer().render(entity.getWorld(), bakedmodel, blockState, entity.getPos(), matrices, vertexConsumer, false, entity.getWorld().getRandom(), blockState.getRenderingSeed(entity.getPos()), overlay);

            matrices.pop();
        }
    }
}
