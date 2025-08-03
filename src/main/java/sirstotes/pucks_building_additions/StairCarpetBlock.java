package sirstotes.pucks_building_additions;

import net.minecraft.block.*;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
/*? if >1.20.1 {*/
import net.minecraft.world.tick.ScheduledTickView;
 /*?}*/

import java.util.Map;
import java.util.Objects;

import static sirstotes.pucks_building_additions.PucksBuildingAdditionsBlocks.CarpetsToStairs;

public class StairCarpetBlock extends Block {
    protected static final VoxelShape NORTH_WEST_CORNER_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 1.0, 8.0);
    protected static final VoxelShape SOUTH_WEST_CORNER_SHAPE = Block.createCuboidShape(0.0, 0.0, 8.0, 8.0, 1.0, 16.0);
    protected static final VoxelShape NORTH_EAST_CORNER_SHAPE = Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 1.0, 8.0);
    protected static final VoxelShape SOUTH_EAST_CORNER_SHAPE = Block.createCuboidShape(8.0, 0.0, 8.0, 16.0, 1.0, 16.0);

    public StairCarpetBlock(Settings settings) {
        super(settings);
    }

    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(Properties.STAIR_SHAPE)) {
            case STRAIGHT:
                if (state.get(Properties.HORIZONTAL_FACING) == Direction.NORTH) {
                    return VoxelShapes.union(NORTH_WEST_CORNER_SHAPE, NORTH_EAST_CORNER_SHAPE);
                } else if (state.get(Properties.HORIZONTAL_FACING) == Direction.EAST) {
                    return VoxelShapes.union(SOUTH_EAST_CORNER_SHAPE, NORTH_EAST_CORNER_SHAPE);
                } else if (state.get(Properties.HORIZONTAL_FACING) == Direction.SOUTH) {
                    return VoxelShapes.union(SOUTH_WEST_CORNER_SHAPE, SOUTH_EAST_CORNER_SHAPE);
                } else {
                    return VoxelShapes.union(NORTH_WEST_CORNER_SHAPE, SOUTH_WEST_CORNER_SHAPE);
                }
            case INNER_LEFT:
                if (state.get(Properties.HORIZONTAL_FACING) == Direction.NORTH) {
                    return VoxelShapes.union(NORTH_WEST_CORNER_SHAPE, NORTH_EAST_CORNER_SHAPE, SOUTH_WEST_CORNER_SHAPE);
                } else if (state.get(Properties.HORIZONTAL_FACING) == Direction.EAST) {
                    return VoxelShapes.union(SOUTH_EAST_CORNER_SHAPE, NORTH_EAST_CORNER_SHAPE, NORTH_WEST_CORNER_SHAPE);
                } else if (state.get(Properties.HORIZONTAL_FACING) == Direction.SOUTH) {
                    return VoxelShapes.union(SOUTH_WEST_CORNER_SHAPE, SOUTH_EAST_CORNER_SHAPE, NORTH_EAST_CORNER_SHAPE);
                } else {
                    return VoxelShapes.union(NORTH_WEST_CORNER_SHAPE, SOUTH_WEST_CORNER_SHAPE, SOUTH_EAST_CORNER_SHAPE);
                }
            case INNER_RIGHT:
                if (state.get(Properties.HORIZONTAL_FACING) == Direction.NORTH) {
                    return VoxelShapes.union(NORTH_WEST_CORNER_SHAPE, NORTH_EAST_CORNER_SHAPE, SOUTH_EAST_CORNER_SHAPE);
                } else if (state.get(Properties.HORIZONTAL_FACING) == Direction.EAST) {
                    return VoxelShapes.union(SOUTH_EAST_CORNER_SHAPE, NORTH_EAST_CORNER_SHAPE, SOUTH_WEST_CORNER_SHAPE);
                } else if (state.get(Properties.HORIZONTAL_FACING) == Direction.SOUTH) {
                    return VoxelShapes.union(SOUTH_WEST_CORNER_SHAPE, SOUTH_EAST_CORNER_SHAPE, NORTH_WEST_CORNER_SHAPE);
                } else {
                    return VoxelShapes.union(NORTH_WEST_CORNER_SHAPE, SOUTH_WEST_CORNER_SHAPE, NORTH_EAST_CORNER_SHAPE);
                }
            case OUTER_LEFT:
                if (state.get(Properties.HORIZONTAL_FACING) == Direction.NORTH) {
                    return VoxelShapes.union(NORTH_WEST_CORNER_SHAPE);
                } else if (state.get(Properties.HORIZONTAL_FACING) == Direction.EAST) {
                    return VoxelShapes.union(NORTH_EAST_CORNER_SHAPE);
                } else if (state.get(Properties.HORIZONTAL_FACING) == Direction.SOUTH) {
                    return VoxelShapes.union(SOUTH_EAST_CORNER_SHAPE);
                } else {
                    return VoxelShapes.union(SOUTH_WEST_CORNER_SHAPE);
                }
            case OUTER_RIGHT:
                if (state.get(Properties.HORIZONTAL_FACING) == Direction.NORTH) {
                    return VoxelShapes.union(NORTH_EAST_CORNER_SHAPE);
                } else if (state.get(Properties.HORIZONTAL_FACING) == Direction.EAST) {
                    return VoxelShapes.union(SOUTH_EAST_CORNER_SHAPE);
                } else if (state.get(Properties.HORIZONTAL_FACING) == Direction.SOUTH) {
                    return VoxelShapes.union(SOUTH_WEST_CORNER_SHAPE);
                } else {
                    return VoxelShapes.union(NORTH_WEST_CORNER_SHAPE);
                }
        }
        return VoxelShapes.empty();
    }

    /*? if >1.20.1 {*/
    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        BlockState stair = world.getBlockState(pos.down());
        return !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : getDefaultState().with(Properties.STAIR_SHAPE, stair.get(StairsBlock.SHAPE)).with(Properties.HORIZONTAL_FACING, stair.get(StairsBlock.FACING));
    }
    /*?} else {*/
    /*public BlockState getStateForNeighborUpdate(Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        BlockState stair = world.getBlockState(pos.down());
        return !neighborState.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : getDefaultState().with(Properties.STAIR_SHAPE, stair.get(StairsBlock.SHAPE)).with(Properties.HORIZONTAL_FACING, stair.get(StairsBlock.FACING));
    }
    *//*?}*/

    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState stair = world.getBlockState(pos.down());
        return stair.getBlock() instanceof StairsBlock && stair.get(Properties.BLOCK_HALF) == BlockHalf.BOTTOM;
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState stair = ctx.getWorld().getBlockState(ctx.getBlockPos().down());
        return getDefaultState().with(Properties.STAIR_SHAPE, stair.get(StairsBlock.SHAPE)).with(Properties.HORIZONTAL_FACING, stair.get(StairsBlock.FACING));
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.STAIR_SHAPE, Properties.HORIZONTAL_FACING);
    }

    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        Block b = Blocks.WHITE_CARPET;
        for (Map.Entry<Block, Block> entry : CarpetsToStairs.entrySet()) {
            if (Objects.equals(this, entry.getValue())) {
                b = entry.getKey();
            }
        }
        return new ItemStack(b.asItem());
    }
}