package sirstotes.pucks_building_additions;

/*? if >1.20.1 {*/
import net.minecraft.block.entity.Sherds;
 /*?} else*/
/*import net.minecraft.block.entity.DecoratedPotBlockEntity.Sherds;*/
/**/
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;

public interface DecoratedPotBlockEntityRendererInterface {
    void pucks_Building_Additions$renderAsColoredItem(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Sherds sherds, String color);
}
