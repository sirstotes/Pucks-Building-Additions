package sirstotes.pucks_building_additions.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.ItemPlacementContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sirstotes.pucks_building_additions.PucksBuildingAdditionsBlocks;

@Mixin(CarpetBlock.class)
public class CarpetBlockMixin extends Block {
    public CarpetBlockMixin(Settings settings) {
        super(settings);
    }

    @Unique
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if (ctx.getWorld().getBlockState(ctx.getBlockPos().down()).getBlock() instanceof StairsBlock) {
            return PucksBuildingAdditionsBlocks.CarpetsToStairs.get(this).getPlacementState(ctx);
        }
        return this.getDefaultState();
    }
}
