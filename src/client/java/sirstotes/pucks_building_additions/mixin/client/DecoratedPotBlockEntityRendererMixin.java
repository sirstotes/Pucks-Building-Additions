package sirstotes.pucks_building_additions.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.block.entity.Sherds;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.DecoratedPotBlockEntityRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import sirstotes.pucks_building_additions.ColoredDecoratedPotBlockEntity;
import sirstotes.pucks_building_additions.DecoratedPotBlockEntityRendererInterface;
import sirstotes.pucks_building_additions.PucksBuildingAdditions;

import java.util.Optional;

@Mixin(DecoratedPotBlockEntityRenderer.class)
public class DecoratedPotBlockEntityRendererMixin implements DecoratedPotBlockEntityRendererInterface {

    @Final
    @Shadow
    private ModelPart neck;
    @Final
    @Shadow
    private ModelPart front;
    @Final
    @Shadow
    private ModelPart back;
    @Final
    @Shadow
    private ModelPart left;
    @Final
    @Shadow
    private ModelPart right;
    @Final
    @Shadow
    private ModelPart top;
    @Final
    @Shadow
    private ModelPart bottom;

    @WrapOperation(method = "render(Lnet/minecraft/block/entity/DecoratedPotBlockEntity;FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;II)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/block/entity/DecoratedPotBlockEntityRenderer;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/block/entity/Sherds;)V"))
    public void renderColoredIfColored(DecoratedPotBlockEntityRenderer instance, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Sherds sherds, Operation<Void> original, @Local(argsOnly = true) DecoratedPotBlockEntity decoratedPotBlockEntity) {
        if (decoratedPotBlockEntity instanceof ColoredDecoratedPotBlockEntity c) {
            this.render(matrices, vertexConsumers, light, overlay, sherds, getSpriteIdentifier(c.color, "bottom"), getSpriteIdentifier(c.color, "side"));
        } else {
            original.call(instance, matrices, vertexConsumers, light, overlay, sherds);
        }
    }

//    @WrapOperation(method = "renderAsItem(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/block/entity/Sherds;)V",
//    at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/block/entity/DecoratedPotBlockEntityRenderer;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/block/entity/Sherds;)V"))
//    public void renderColoredItem(DecoratedPotBlockEntityRenderer instance, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Sherds sherds, Operation<Void> original) {
//        if (decoratedPotBlockEntity instanceof ColoredDecoratedPotBlockEntity c) {
//            this.render(matrices, vertexConsumers, light, overlay, sherds, getSpriteIdentifier(c.color, "bottom"), getSpriteIdentifier(c.color, "side"));
//        } else {
//            original.call(instance, matrices, vertexConsumers, light, overlay, sherds);
//        }
//    }

    @Unique
    private static SpriteIdentifier getTextureIdFromSherd(Optional<Item> sherd) {
        if (sherd.isPresent()) {
            String id = null;
            if (sherd.get().asItem() == Items.ANGLER_POTTERY_SHERD) id = "angler_pottery_pattern";
            else if (sherd.get() == Items.ARCHER_POTTERY_SHERD) id = "archer_pottery_pattern";
            else if (sherd.get() == Items.ARMS_UP_POTTERY_SHERD) id = "arms_up_pottery_pattern";
            else if (sherd.get() == Items.BLADE_POTTERY_SHERD) id = "blade_pottery_pattern";
            else if (sherd.get() == Items.BREWER_POTTERY_SHERD) id = "brewer_pottery_pattern";
            else if (sherd.get() == Items.BURN_POTTERY_SHERD) id = "burn_pottery_pattern";
            else if (sherd.get() == Items.DANGER_POTTERY_SHERD) id = "danger_pottery_pattern";
            else if (sherd.get() == Items.EXPLORER_POTTERY_SHERD) id = "explorer_pottery_pattern";
            else if (sherd.get() == Items.FLOW_POTTERY_SHERD) id = "flow_pottery_pattern";
            else if (sherd.get() == Items.FRIEND_POTTERY_SHERD) id = "friend_pottery_pattern";
            else if (sherd.get() == Items.GUSTER_POTTERY_SHERD) id = "guster_pottery_pattern";
            else if (sherd.get() == Items.HEART_POTTERY_SHERD) id = "heart_pottery_pattern";
            else if (sherd.get() == Items.HEARTBREAK_POTTERY_SHERD) id = "heartbreak_pottery_pattern";
            else if (sherd.get() == Items.HOWL_POTTERY_SHERD) id = "howl_pottery_pattern";
            else if (sherd.get() == Items.MINER_POTTERY_SHERD) id = "miner_pottery_pattern";
            else if (sherd.get() == Items.MOURNER_POTTERY_SHERD) id = "mourner_pottery_pattern";
            else if (sherd.get() == Items.PLENTY_POTTERY_SHERD) id = "plenty_pottery_pattern";
            else if (sherd.get() == Items.PRIZE_POTTERY_SHERD) id = "prize_pottery_pattern";
            else if (sherd.get() == Items.SCRAPE_POTTERY_SHERD) id = "scrape_pottery_pattern";
            else if (sherd.get() == Items.SHEAF_POTTERY_SHERD) id = "sheaf_pottery_pattern";
            else if (sherd.get() == Items.SHELTER_POTTERY_SHERD) id = "shelter_pottery_pattern";
            else if (sherd.get() == Items.SKULL_POTTERY_SHERD) id = "skull_pottery_pattern";
            else if (sherd.get() == Items.SNORT_POTTERY_SHERD) id = "snort_pottery_pattern";
            if (id != null) {
                return new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/decorated_pot/"+id));
            }
        }

        return new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/empty"));
    }

    private SpriteIdentifier getSpriteIdentifier(String color, String suffix) {
        return new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, Identifier.of(PucksBuildingAdditions.MOD_ID, "block/decorated_pot/"+color+"_decorated_pot_"+suffix));
    }

    private void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Sherds sherds, SpriteIdentifier topId, SpriteIdentifier sideId) {
        //VertexConsumer vertexConsumer = TexturedRenderLayers.DECORATED_POT_BASE.getVertexConsumer(vertexConsumers, RenderLayer::getEntitySolid);
        VertexConsumer vertexConsumer = topId.getVertexConsumer(vertexConsumers, RenderLayer::getEntitySolid);
        this.neck.render(matrices, vertexConsumer, light, overlay);
        this.top.render(matrices, vertexConsumer, light, overlay);
        this.bottom.render(matrices, vertexConsumer, light, overlay);
        this.renderDecoratedSide(this.front, matrices, vertexConsumers, light, overlay, sideId);
        this.renderDecoratedSide(this.back, matrices, vertexConsumers, light, overlay, sideId);
        this.renderDecoratedSide(this.left, matrices, vertexConsumers, light, overlay, sideId);
        this.renderDecoratedSide(this.right, matrices, vertexConsumers, light, overlay, sideId);

        if (sherds.front().isPresent()) this.renderDecoratedSide2(this.front, matrices, vertexConsumers, light, overlay, getTextureIdFromSherd(sherds.front()));
        if (sherds.back().isPresent()) this.renderDecoratedSide2(this.back, matrices, vertexConsumers, light, overlay, getTextureIdFromSherd(sherds.back()));
        if (sherds.left().isPresent()) this.renderDecoratedSide2(this.left, matrices, vertexConsumers, light, overlay, getTextureIdFromSherd(sherds.left()));
        if (sherds.right().isPresent()) this.renderDecoratedSide2(this.right, matrices, vertexConsumers, light, overlay, getTextureIdFromSherd(sherds.right()));
    }

    @Shadow
    private void renderDecoratedSide(ModelPart back, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, SpriteIdentifier sideId) {
    }

    @Unique
    private void renderDecoratedSide2(ModelPart part, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, SpriteIdentifier baseId) {
        part.render(matrices, baseId.getVertexConsumer(vertexConsumers, RenderLayer::getEntityCutout), light, overlay);
    }

    @Override
    public void pucks_Building_Additions$renderAsColoredItem(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Sherds sherds, String color) {
        this.render(matrices, vertexConsumers, light, overlay, sherds, getSpriteIdentifier(color, "bottom"), getSpriteIdentifier(color, "side"));
    }
}
