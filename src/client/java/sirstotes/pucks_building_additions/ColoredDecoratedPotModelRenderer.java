/*? if >1.20.1 {*/
package sirstotes.pucks_building_additions;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.Sherds;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.DecoratedPotBlockEntityRenderer;
import net.minecraft.client.render.entity.model.LoadedEntityModels;
import net.minecraft.client.render.item.model.special.SpecialModelRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class ColoredDecoratedPotModelRenderer implements SpecialModelRenderer<Sherds> {
    private final DecoratedPotBlockEntityRenderer blockEntityRenderer;
    private final String color;

    public ColoredDecoratedPotModelRenderer(DecoratedPotBlockEntityRenderer blockEntityRenderer, String color) {
        this.blockEntityRenderer = blockEntityRenderer;
        this.color = color;
    }
    @Nullable
    public Sherds getData(ItemStack itemStack) {return itemStack.get(DataComponentTypes.POT_DECORATIONS);}
    public void render(@Nullable Sherds sherds, ModelTransformationMode modelTransformationMode, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j, boolean bl) {
        ((DecoratedPotBlockEntityRendererInterface) this.blockEntityRenderer).pucks_Building_Additions$renderAsColoredItem(matrixStack, vertexConsumerProvider, i, j, Objects.requireNonNullElse(sherds, Sherds.DEFAULT), this.color);
    }

    @Environment(EnvType.CLIENT)
    public record Unbaked(String color) implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<Unbaked> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
                Codec.STRING.fieldOf("color").forGetter(Unbaked::color)
        ).apply(i, Unbaked::new));

        public MapCodec<Unbaked> getCodec() {
            return CODEC;
        }

        public SpecialModelRenderer<Sherds> bake(LoadedEntityModels entityModels) {
            return new ColoredDecoratedPotModelRenderer(new DecoratedPotBlockEntityRenderer(entityModels), this.color);
        }
    }
}
    /*?}*/