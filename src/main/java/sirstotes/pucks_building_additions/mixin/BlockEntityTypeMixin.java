package sirstotes.pucks_building_additions.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sirstotes.pucks_building_additions.PucksBuildingAdditionsBlocks;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin {
//    @ModifyExpressionValue(method = "<clinit>",
//    at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/BlockEntityType$Builder;create(Lnet/minecraft/block/entity/BlockEntityType$BlockEntityFactory;[Lnet/minecraft/block/Block;)Lnet/minecraft/block/entity/BlockEntityType$Builder;"))
//    private static BlockEntityType.Builder acceptNewDecoratedPots(BlockEntityType.Builder original) {
//        return BlockEntityType.Builder.create(DecoratedPotBlockEntity::new, Blocks.DECORATED_POT,
//                PucksBuildingAdditionsBlocks.RED_DECORATED_POT,
//                PucksBuildingAdditionsBlocks.ORANGE_DECORATED_POT,
//                PucksBuildingAdditionsBlocks.YELLOW_DECORATED_POT,
//                PucksBuildingAdditionsBlocks.LIME_DECORATED_POT,
//                PucksBuildingAdditionsBlocks.GREEN_DECORATED_POT,
//                PucksBuildingAdditionsBlocks.CYAN_DECORATED_POT,
//                PucksBuildingAdditionsBlocks.LIGHT_BLUE_DECORATED_POT,
//                PucksBuildingAdditionsBlocks.BLUE_DECORATED_POT,
//                PucksBuildingAdditionsBlocks.PURPLE_DECORATED_POT,
//                PucksBuildingAdditionsBlocks.MAGENTA_DECORATED_POT,
//                PucksBuildingAdditionsBlocks.PINK_DECORATED_POT,
//                PucksBuildingAdditionsBlocks.BROWN_DECORATED_POT,
//                PucksBuildingAdditionsBlocks.WHITE_DECORATED_POT,
//                PucksBuildingAdditionsBlocks.LIGHT_GRAY_DECORATED_POT,
//                PucksBuildingAdditionsBlocks.GRAY_DECORATED_POT,
//                PucksBuildingAdditionsBlocks.BLACK_DECORATED_POT);
//    }
}
