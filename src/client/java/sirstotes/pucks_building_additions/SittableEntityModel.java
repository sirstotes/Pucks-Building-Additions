package sirstotes.pucks_building_additions;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.EntityRenderState;

public class SittableEntityModel extends EntityModel<EntityRenderState> {
    public SittableEntityModel(ModelPart modelPart) {
        super(modelPart);
    }

    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.of(new ModelData(), 0, 0);
    }
}
