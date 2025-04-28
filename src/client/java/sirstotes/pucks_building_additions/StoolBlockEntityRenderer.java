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
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.RotationPropertyHelper;

public class StoolBlockEntityRenderer implements BlockEntityRenderer<StoolBlockEntity> {
    public StoolBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(StoolBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState blockState = entity.getCachedState();
        boolean bl = blockState.getBlock() instanceof WallStoolBlock;
        Direction direction = bl ? blockState.get(WallStoolBlock.FACING) : null;
        int k = bl ? RotationPropertyHelper.fromDirection(direction.getOpposite()) : blockState.get(StoolBlock.ROTATION);
        float yaw = RotationPropertyHelper.toDegrees(k);

        matrices.push();
        if (direction == null) {
            matrices.translate(0.5f, 0f, 0.5f);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(yaw));
            matrices.translate(-0.5f, 0f, -0.5f);
        } else {

        }

        BakedModel bakedmodel = MinecraftClient.getInstance().getBakedModelManager().getBlockModels().getModel(blockState);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getSolid());
        //MinecraftClient.getInstance().getBlockRenderManager().getModelRenderer().render(matrices.peek(), vertexConsumer, blockState, bakedmodel, 1f, 1f, 1f, light, overlay);
        MinecraftClient.getInstance().getBlockRenderManager().getModelRenderer().render(entity.getWorld(), bakedmodel, blockState, entity.getPos(), matrices, vertexConsumer, false, entity.getWorld().getRandom(), blockState.getRenderingSeed(entity.getPos()), overlay);

        matrices.pop();

//        if (direction == null) {
//            matrices.translate(0.5F, 0.0F, 0.5F);
//        } else {
//            float f = 0.25F;
//            matrices.translate(0.5F - (float)direction.getOffsetX() * 0.25F, 0.0F, 0.5F - (float)direction.getOffsetZ() * 0.25F);
//        }
//        matrices.scale(-1.0F, -1.0F, 1.0F);
//
//        MinecraftClient.getInstance().getBlockRenderManager().renderBlockAsEntity(blockState, matrices, vertexConsumers, light, overlay);
//        rotate model
//        render model
//        model.setStoolRotation(yaw, 0.0F);
//        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);
    }
}
