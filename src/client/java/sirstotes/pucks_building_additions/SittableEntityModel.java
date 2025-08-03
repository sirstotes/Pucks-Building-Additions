package sirstotes.pucks_building_additions;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
/*? if >1.20.1 {*/
import net.minecraft.client.render.entity.state.EntityRenderState;
/*?}*/

public class SittableEntityModel extends EntityModel/*? if >1.20.1 {*/<EntityRenderState>/*?}*/ {
    public SittableEntityModel(ModelPart modelPart) {
        /*? if >1.20.1 {*/
        super(modelPart);
        /*?} else {*/
        /*super();
        *//*?}*/
    }

    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.of(new ModelData(), 0, 0);
    }
    /*? if <1.21.4 {*/
    /*@Override
    public void setAngles(Entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {}
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {}
    *//*?}*/
}
