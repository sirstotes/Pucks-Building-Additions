package sirstotes.pucks_building_additions.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.world.biome.GrassColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import sirstotes.pucks_building_additions.PucksBuildingAdditionsBlocks;

@Mixin (BlockColors.class)
public class BlockColorsMixin {
    @Inject(method = "create()Lnet/minecraft/client/color/block/BlockColors;", at = @At("TAIL"))
    private static void registerColors(CallbackInfoReturnable<BlockColors> cir, @Local BlockColors blockColors) {
        blockColors.registerColorProvider((state, world, pos, tintIndex) -> {
            return world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.getDefaultColor();
        }, PucksBuildingAdditionsBlocks.RED_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.ORANGE_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.YELLOW_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.LIME_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.GREEN_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.CYAN_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.LIGHT_BLUE_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.BLUE_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.PURPLE_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.MAGENTA_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.PINK_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.BROWN_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.WHITE_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.LIGHT_GRAY_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.GRAY_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.BLACK_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.LARGE_FLOWER_POTS[1], PucksBuildingAdditionsBlocks.LARGE_FLOWER_POTS[2],
                PucksBuildingAdditionsBlocks.RED_LARGE_FLOWER_POTS[1], PucksBuildingAdditionsBlocks.RED_LARGE_FLOWER_POTS[2],
                PucksBuildingAdditionsBlocks.ORANGE_LARGE_FLOWER_POTS[1], PucksBuildingAdditionsBlocks.ORANGE_LARGE_FLOWER_POTS[2],
                PucksBuildingAdditionsBlocks.YELLOW_LARGE_FLOWER_POTS[1], PucksBuildingAdditionsBlocks.YELLOW_LARGE_FLOWER_POTS[2],
                PucksBuildingAdditionsBlocks.LIME_LARGE_FLOWER_POTS[1], PucksBuildingAdditionsBlocks.LIME_LARGE_FLOWER_POTS[2],
                PucksBuildingAdditionsBlocks.GREEN_LARGE_FLOWER_POTS[1], PucksBuildingAdditionsBlocks.GREEN_LARGE_FLOWER_POTS[2],
                PucksBuildingAdditionsBlocks.CYAN_LARGE_FLOWER_POTS[1], PucksBuildingAdditionsBlocks.CYAN_LARGE_FLOWER_POTS[2],
                PucksBuildingAdditionsBlocks.LIGHT_BLUE_LARGE_FLOWER_POTS[1], PucksBuildingAdditionsBlocks.LIGHT_BLUE_LARGE_FLOWER_POTS[2],
                PucksBuildingAdditionsBlocks.BLUE_LARGE_FLOWER_POTS[1], PucksBuildingAdditionsBlocks.BLUE_LARGE_FLOWER_POTS[2],
                PucksBuildingAdditionsBlocks.PURPLE_LARGE_FLOWER_POTS[1], PucksBuildingAdditionsBlocks.PURPLE_LARGE_FLOWER_POTS[2],
                PucksBuildingAdditionsBlocks.MAGENTA_LARGE_FLOWER_POTS[1], PucksBuildingAdditionsBlocks.MAGENTA_LARGE_FLOWER_POTS[2],
                PucksBuildingAdditionsBlocks.PINK_LARGE_FLOWER_POTS[1], PucksBuildingAdditionsBlocks.PINK_LARGE_FLOWER_POTS[2],
                PucksBuildingAdditionsBlocks.BROWN_LARGE_FLOWER_POTS[1], PucksBuildingAdditionsBlocks.BROWN_LARGE_FLOWER_POTS[2],
                PucksBuildingAdditionsBlocks.WHITE_LARGE_FLOWER_POTS[1], PucksBuildingAdditionsBlocks.WHITE_LARGE_FLOWER_POTS[2],
                PucksBuildingAdditionsBlocks.LIGHT_GRAY_LARGE_FLOWER_POTS[1], PucksBuildingAdditionsBlocks.LIGHT_GRAY_LARGE_FLOWER_POTS[2],
                PucksBuildingAdditionsBlocks.GRAY_LARGE_FLOWER_POTS[1], PucksBuildingAdditionsBlocks.GRAY_LARGE_FLOWER_POTS[2],
                PucksBuildingAdditionsBlocks.BLACK_LARGE_FLOWER_POTS[1], PucksBuildingAdditionsBlocks.BLACK_LARGE_FLOWER_POTS[2],
                PucksBuildingAdditionsBlocks.HANGING_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.RED_HANGING_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.ORANGE_HANGING_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.YELLOW_HANGING_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.LIME_HANGING_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.GREEN_HANGING_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.CYAN_HANGING_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.LIGHT_BLUE_HANGING_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.BLUE_HANGING_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.PURPLE_HANGING_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.MAGENTA_HANGING_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.PINK_HANGING_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.BROWN_HANGING_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.WHITE_HANGING_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.LIGHT_GRAY_HANGING_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.GRAY_HANGING_FLOWER_POTS[1],
                PucksBuildingAdditionsBlocks.BLACK_HANGING_FLOWER_POTS[1]);
    }
}
