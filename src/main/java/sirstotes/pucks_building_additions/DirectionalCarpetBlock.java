package sirstotes.pucks_building_additions;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

public class DirectionalCarpetBlock extends CarpetBlock {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public DirectionalCarpetBlock(Settings settings) {
        super(settings);
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if (ctx.getWorld().getBlockState(ctx.getBlockPos().down()).getBlock() instanceof StairsBlock) {
            return PucksBuildingAdditionsBlocks.CarpetsToStairs.get(this).getPlacementState(ctx);
        }
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}
