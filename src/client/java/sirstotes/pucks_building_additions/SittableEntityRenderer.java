package sirstotes.pucks_building_additions;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
/*? if >1.20.1 {*/
import net.minecraft.client.render.entity.state.EntityRenderState;
 /*?}*/

public class SittableEntityRenderer extends EntityRenderer {
    protected SittableEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }
    /*? if >1.20.1 {*/
    @Override
    public EntityRenderState createRenderState() {return new EntityRenderState();}
    /*?} else {*/
    /*@Override
    public Identifier getTexture(Entity entity) {
        return null;
    }
    *//*?}*/
}
