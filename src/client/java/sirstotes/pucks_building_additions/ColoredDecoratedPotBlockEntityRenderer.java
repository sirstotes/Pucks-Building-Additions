package sirstotes.pucks_building_additions;

import net.minecraft.block.DecoratedPotPatterns;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.block.entity.Sherds;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.LoadedEntityModels;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

import java.util.EnumSet;
import java.util.Optional;

public class ColoredDecoratedPotBlockEntityRenderer implements BlockEntityRenderer<ColoredDecoratedPotBlockEntity> {
    private final ModelPart neck;
    private final ModelPart front;
    private final ModelPart back;
    private final ModelPart left;
    private final ModelPart right;
    private final ModelPart top;
    private final ModelPart bottom;
    private static final float field_46728 = 0.125F;

    public ColoredDecoratedPotBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        this(context.getLoadedEntityModels());
    }

    public ColoredDecoratedPotBlockEntityRenderer(LoadedEntityModels models) {
        ModelPart modelPart = models.getModelPart(EntityModelLayers.DECORATED_POT_BASE);
        this.neck = modelPart.getChild("neck");
        this.top = modelPart.getChild("top");
        this.bottom = modelPart.getChild("bottom");
        ModelPart modelPart2 = models.getModelPart(EntityModelLayers.DECORATED_POT_SIDES);
        this.front = modelPart2.getChild("front");
        this.back = modelPart2.getChild("back");
        this.left = modelPart2.getChild("left");
        this.right = modelPart2.getChild("right");
    }

    public static TexturedModelData getTopBottomNeckTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        Dilation dilation = new Dilation(0.2F);
        Dilation dilation2 = new Dilation(-0.1F);
        modelPartData.addChild("neck", ModelPartBuilder.create().uv(0, 0).cuboid(4.0F, 17.0F, 4.0F, 8.0F, 3.0F, 8.0F, dilation2).uv(0, 5).cuboid(5.0F, 20.0F, 5.0F, 6.0F, 1.0F, 6.0F, dilation), ModelTransform.of(0.0F, 37.0F, 16.0F, 3.1415927F, 0.0F, 0.0F));
        ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(-14, 13).cuboid(0.0F, 0.0F, 0.0F, 14.0F, 0.0F, 14.0F);
        modelPartData.addChild("top", modelPartBuilder, ModelTransform.of(1.0F, 16.0F, 1.0F, 0.0F, 0.0F, 0.0F));
        modelPartData.addChild("bottom", modelPartBuilder, ModelTransform.of(1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    public static TexturedModelData getSidesTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(1, 0).cuboid(0.0F, 0.0F, 0.0F, 14.0F, 16.0F, 0.0F, EnumSet.of(Direction.NORTH));
        modelPartData.addChild("back", modelPartBuilder, ModelTransform.of(15.0F, 16.0F, 1.0F, 0.0F, 0.0F, 3.1415927F));
        modelPartData.addChild("left", modelPartBuilder, ModelTransform.of(1.0F, 16.0F, 1.0F, 0.0F, -1.5707964F, 3.1415927F));
        modelPartData.addChild("right", modelPartBuilder, ModelTransform.of(15.0F, 16.0F, 15.0F, 0.0F, 1.5707964F, 3.1415927F));
        modelPartData.addChild("front", modelPartBuilder, ModelTransform.of(1.0F, 16.0F, 15.0F, 3.1415927F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 16, 16);
    }

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

    public void render(ColoredDecoratedPotBlockEntity decoratedPotBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
        matrixStack.push();
        Direction direction = decoratedPotBlockEntity.getHorizontalFacing();
        matrixStack.translate(0.5, 0.0, 0.5);
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - direction.getPositiveHorizontalDegrees()));
        matrixStack.translate(-0.5, 0.0, -0.5);
        DecoratedPotBlockEntity.WobbleType wobbleType = decoratedPotBlockEntity.lastWobbleType;
        if (wobbleType != null && decoratedPotBlockEntity.getWorld() != null) {
            float g = ((float)(decoratedPotBlockEntity.getWorld().getTime() - decoratedPotBlockEntity.lastWobbleTime) + f) / (float)wobbleType.lengthInTicks;
            if (g >= 0.0F && g <= 1.0F) {
                float h;
                float k;
                if (wobbleType == DecoratedPotBlockEntity.WobbleType.POSITIVE) {
                    h = 0.015625F;
                    k = g * 6.2831855F;
                    float l = -1.5F * (MathHelper.cos(k) + 0.5F) * MathHelper.sin(k / 2.0F);
                    matrixStack.multiply(RotationAxis.POSITIVE_X.rotation(l * 0.015625F), 0.5F, 0.0F, 0.5F);
                    float m = MathHelper.sin(k);
                    matrixStack.multiply(RotationAxis.POSITIVE_Z.rotation(m * 0.015625F), 0.5F, 0.0F, 0.5F);
                } else {
                    h = MathHelper.sin(-g * 3.0F * 3.1415927F) * 0.125F;
                    k = 1.0F - g;
                    matrixStack.multiply(RotationAxis.POSITIVE_Y.rotation(h * k), 0.5F, 0.0F, 0.5F);
                }
            }
        }
        //System.out.println(getSpriteIdentifier(decoratedPotBlockEntity.color, "bottom"));
        this.render(matrixStack, vertexConsumerProvider, i, j, decoratedPotBlockEntity.getSherds(), getSpriteIdentifier(decoratedPotBlockEntity.color, "bottom"), getSpriteIdentifier(decoratedPotBlockEntity.color, "side"));
        matrixStack.pop();
    }

    public void renderAsItem(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Sherds sherds) {
        //this.render(matrices, vertexConsumers, light, overlay, sherds);
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

    private void renderDecoratedSide(ModelPart part, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, SpriteIdentifier baseId) {
        part.render(matrices, baseId.getVertexConsumer(vertexConsumers, RenderLayer::getEntitySolid), light, overlay);
    }
    private void renderDecoratedSide2(ModelPart part, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, SpriteIdentifier baseId) {
        part.render(matrices, baseId.getVertexConsumer(vertexConsumers, RenderLayer::getEntityCutout), light, overlay);
    }
}
