package sirstotes.pucks_building_additions;

import net.minecraft.block.*;
import net.minecraft.block.enums.StairShape;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

import java.util.stream.IntStream;

public class BackedSittableBlock extends SittableBlock {
    public BackedSittableBlock(Settings settings) {
        super(settings);
    }
    public static final EnumProperty<Direction> FACING = HorizontalFacingBlock.FACING;
    public static final EnumProperty<StairShape> SHAPE = Properties.STAIR_SHAPE;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape NORTH_WEST_CORNER_SHAPE = Block.createCuboidShape(0.0, 9.0, 0.0, 4.0, 13.0, 4.0);
    protected static final VoxelShape SOUTH_WEST_CORNER_SHAPE = Block.createCuboidShape(0.0, 9.0, 12.0, 4.0, 13.0, 16.0);
    protected static final VoxelShape NORTH_EAST_CORNER_SHAPE = Block.createCuboidShape(12.0, 9.0, 0.0, 16.0, 13.0, 4.0);
    protected static final VoxelShape SOUTH_EAST_CORNER_SHAPE = Block.createCuboidShape(12.0, 9.0, 12.0, 16.0, 13.0, 16.0);
    protected static final VoxelShape[] SHAPES = composeShapes(BLOCK_SHAPE, NORTH_WEST_CORNER_SHAPE, NORTH_EAST_CORNER_SHAPE, SOUTH_WEST_CORNER_SHAPE, SOUTH_EAST_CORNER_SHAPE);
    private static final int[] SHAPE_INDICES = new int[]{12, 5, 3, 10, 14, 13, 7, 11, 13, 7, 11, 14, 8, 4, 1, 2, 4, 1, 2, 8};

    private static VoxelShape[] composeShapes(VoxelShape base, VoxelShape northWest, VoxelShape northEast, VoxelShape southWest, VoxelShape southEast) {
        return (VoxelShape[]) IntStream.range(0, 16).mapToObj((i) -> {
            return composeShape(i, base, northWest, northEast, southWest, southEast);
        }).toArray((i) -> {
            return new VoxelShape[i];
        });
    }
    private static VoxelShape composeShape(int i, VoxelShape base, VoxelShape northWest, VoxelShape northEast, VoxelShape southWest, VoxelShape southEast) {
        VoxelShape voxelShape = base;
        if ((i & 1) != 0) {
            voxelShape = VoxelShapes.union(voxelShape, northWest);
        }

        if ((i & 2) != 0) {
            voxelShape = VoxelShapes.union(voxelShape, northEast);
        }

        if ((i & 4) != 0) {
            voxelShape = VoxelShapes.union(voxelShape, southWest);
        }

        if ((i & 8) != 0) {
            voxelShape = VoxelShapes.union(voxelShape, southEast);
        }

        return voxelShape;
    }
    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES[SHAPE_INDICES[this.getShapeIndexIndex(state)]];
    }
    private int getShapeIndexIndex(BlockState state) {
        return state.get(SHAPE).ordinal() * 4 + state.get(FACING).getHorizontalQuarterTurns();
    }
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        FluidState fluidState = ctx.getWorld().getFluidState(blockPos);
        BlockState blockState = (this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing())).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        return blockState.with(SHAPE, getStairShape(blockState, ctx.getWorld(), blockPos));
    }
    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        if (state.get(WATERLOGGED)) {
            tickView.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return direction.getAxis().isHorizontal() ? state.with(SHAPE, getStairShape(state, world, pos)) : super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }
    private static boolean isDifferentOrientation(BlockState state, BlockView world, BlockPos pos, Direction dir) {
        BlockState blockState = world.getBlockState(pos.offset(dir));
        return !isSeat(blockState) || blockState.get(FACING) != state.get(FACING);
    }
    public static boolean isSeat(BlockState state) {
        return state.getBlock() instanceof BackedSittableBlock;
    }
    private static StairShape getStairShape(BlockState state, BlockView world, BlockPos pos) {
        Direction direction = state.get(FACING);
        BlockState blockState = world.getBlockState(pos.offset(direction));
        if (isSeat(blockState)) {
            Direction direction2 = blockState.get(FACING);
            if (direction2.getAxis() != (state.get(FACING)).getAxis() && isDifferentOrientation(state, world, pos, direction2.getOpposite())) {
                if (direction2 == direction.rotateYCounterclockwise()) {
                    return StairShape.OUTER_LEFT;
                }

                return StairShape.OUTER_RIGHT;
            }
        }

        BlockState blockState2 = world.getBlockState(pos.offset(direction.getOpposite()));
        if (isSeat(blockState2)) {
            Direction direction3 = blockState2.get(FACING);
            if (direction3.getAxis() != (state.get(FACING)).getAxis() && isDifferentOrientation(state, world, pos, direction3)) {
                if (direction3 == direction.rotateYCounterclockwise()) {
                    return StairShape.INNER_LEFT;
                }

                return StairShape.INNER_RIGHT;
            }
        }

        return StairShape.STRAIGHT;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(OCCUPIED, FACING, SHAPE, WATERLOGGED);
    }
    protected FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }
}
