package sirstotes.pucks_building_additions;

import net.minecraft.block.entity.Sherds;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;

public interface DecoratedPotBlockEntityRendererInterface {
    void pucks_Building_Additions$renderAsColoredItem(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Sherds sherds, String color);
}
