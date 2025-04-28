package sirstotes.pucks_building_additions;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;

public class SittableEntityRenderer extends EntityRenderer {
    protected SittableEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public EntityRenderState createRenderState() {return new EntityRenderState();}
}
