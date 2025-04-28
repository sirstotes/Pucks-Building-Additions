package sirstotes.pucks_building_additions;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.*;
import net.minecraft.block.enums.WireConnection;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.*;
import net.minecraft.world.block.OrientationHelper;
import net.minecraft.world.block.WireOrientation;
import net.minecraft.world.tick.ScheduledTickView;
import org.jetbrains.annotations.Nullable;
import org.joml.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WireBlock extends Block {
    public static final EnumProperty<Direction> FACING = Properties.FACING;
    public static final IntProperty NORTH = IntProperty.of("north", 0, 2);
    public static final IntProperty SOUTH = IntProperty.of("south", 0, 2);
    public static final IntProperty EAST = IntProperty.of("east", 0, 2);
    public static final IntProperty WEST = IntProperty.of("west", 0, 2);
    public static final BooleanProperty CONNECTED = BooleanProperty.of("connected");
    private static final VoxelShape UP_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
    private static final VoxelShape DOWN_SHAPE = Block.createCuboidShape(0.0, 15.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
    private static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
    private static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
    private static final VoxelShape WEST_SHAPE = Block.createCuboidShape(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    //public static Vec3i[] NEIGHBORS = new Vec3i[] {new Vec3i(0, 1, 0), new Vec3i(1, 0, 0), new Vec3i(-1, 0, 0), new Vec3i(0, 0, 1), new Vec3i(0, 0, -1), new Vec3i(1, 1, 0), new Vec3i(-1, 1, 0), new Vec3i(0, 1, 1), new Vec3i(0, 1, -1), new Vec3i(1, -1, 0), new Vec3i(-1, -1, 0), new Vec3i(0, -1, 1), new Vec3i(0, -1, -1)};
    public static Vec3i[] NEIGHBORS = new Vec3i[] {new Vec3i(1, 1, 0), new Vec3i(-1, 1, 0), new Vec3i(0, 1, 1), new Vec3i(1, 1, -1)};
    private final boolean canFloat;
    public WireBlock(AbstractBlock.Settings settings, Boolean canFloat) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState());
        this.canFloat = canFloat;
    }

    public WireBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState());
        this.canFloat = true;
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING).getOpposite()) {
            case DOWN -> DOWN_SHAPE;
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case EAST -> EAST_SHAPE;
            case WEST -> WEST_SHAPE;
            default -> UP_SHAPE;
        };
    }
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getPlacementState(ctx.getSide(), ctx.getBlockPos(), ctx.getWorld());
    }
    public BlockState getPlacementState(Direction side, BlockPos pos, WorldView world) {
        Direction facing = side.getOpposite();
        Direction north;
        Direction south;
        Direction east;
        Direction west;
        if (facing == Direction.DOWN || !canFloat) {
            north = facing.rotateCounterclockwise(Direction.Axis.X);
            south = facing.rotateClockwise(Direction.Axis.X);
            east = facing.rotateCounterclockwise(Direction.Axis.Z);
            west = facing.rotateClockwise(Direction.Axis.Z);
        } else if (facing == Direction.UP) {
            north = facing.rotateClockwise(Direction.Axis.X);
            south = facing.rotateCounterclockwise(Direction.Axis.X);
            east = facing.rotateCounterclockwise(Direction.Axis.Z);
            west = facing.rotateClockwise(Direction.Axis.Z);
        } else if (facing == Direction.SOUTH) {
            north = facing.rotateCounterclockwise(Direction.Axis.X);
            south = facing.rotateClockwise(Direction.Axis.X);
            east = facing.rotateCounterclockwise(Direction.Axis.Y);
            west = facing.rotateClockwise(Direction.Axis.Y);
        } else if (facing == Direction.NORTH) {
            north = facing.rotateCounterclockwise(Direction.Axis.X);
            south = facing.rotateClockwise(Direction.Axis.X);
            east = facing.rotateClockwise(Direction.Axis.Y);
            west = facing.rotateCounterclockwise(Direction.Axis.Y);
        } else if (facing == Direction.EAST) {
            north = facing.rotateCounterclockwise(Direction.Axis.Y);
            south = facing.rotateClockwise(Direction.Axis.Y);
            east = facing.rotateCounterclockwise(Direction.Axis.Z);
            west = facing.rotateClockwise(Direction.Axis.Z);
        } else {
            north = facing.rotateClockwise(Direction.Axis.Y);
            south = facing.rotateCounterclockwise(Direction.Axis.Y);
            east = facing.rotateCounterclockwise(Direction.Axis.Z);
            west = facing.rotateClockwise(Direction.Axis.Z);
        }
        BlockState state;
        if(!canFloat) {
            state = getDefaultState().with(FACING, Direction.DOWN);
        } else {
            state = getDefaultState().with(FACING, facing);
        }
        state = state.with(CONNECTED, false).with(NORTH, (connects(world, state, pos, pos.offset(side), north) || connects(world, state, pos, pos.offset(north).offset(side))) ? 2 : (connects(world, state, pos, pos.offset(north), north) || connects(world, state, pos, pos.offset(north).offset(facing)) ? 1 : 0))
                .with(SOUTH, (connects(world, state, pos, pos.offset(side), south) || connects(world, state, pos, pos.offset(south).offset(side))) ? 2 : (connects(world, state, pos, pos.offset(south), south) || connects(world, state, pos, pos.offset(south).offset(facing)) ? 1 : 0))
                .with(EAST, (connects(world, state, pos, pos.offset(side), east) || connects(world, state, pos, pos.offset(east).offset(side))) ? 2 : (connects(world, state, pos, pos.offset(east), east) || connects(world, state, pos, pos.offset(east).offset(facing)) ? 1 : 0))
                .with(WEST, (connects(world, state, pos, pos.offset(side), west) || connects(world, state, pos, pos.offset(west).offset(side))) ? 2 : (connects(world, state, pos, pos.offset(west), west) || connects(world, state, pos, pos.offset(west).offset(facing)) ? 1 : 0));

        if (state.get(NORTH) > 0 || state.get(SOUTH) > 0 || state.get(EAST) > 0 || state.get(WEST) > 0) {
            state = state.with(CONNECTED, true);
        }
        return state;
    }
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos baseBlock = WireBlock.getBaseBlock(state, pos);
        if (!canFloat) return canRunOnTop(world, pos.offset(Direction.DOWN), Direction.UP);
        return canRunOnTop(world, baseBlock, getDirectionBetweenBlocks(baseBlock, pos));
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, NORTH, EAST, SOUTH, WEST, CONNECTED);
    }
    public static Direction getDirectionBetweenBlocks(BlockPos base, BlockPos to) {
        if (to.getY() > base.getY()) return Direction.UP;
        if (to.getY() < base.getY()) return Direction.DOWN;
        if (to.getX() > base.getX()) return Direction.SOUTH;
        if (to.getX() < base.getX()) return Direction.NORTH;
        if (to.getZ() > base.getZ()) return Direction.EAST;
        return Direction.WEST;//TODO: Double check these values
    }
    public static BlockPos getBaseBlock(BlockState state, BlockPos pos) {
        return pos.offset(state.get(FACING));
    }
    public boolean connectsToBlock(BlockState other) {
        return other.getBlock() instanceof WireBlock;
    }
    public static boolean connectsToBlockOrFalse(BlockState state, BlockState other) {
        return state.getBlock() instanceof WireBlock && ((WireBlock) state.getBlock()).connectsToBlock(other);
    }
    public static boolean connects(WorldView world, BlockState state, BlockPos pos, BlockPos otherpos) {
        return connects(world, state, pos, otherpos, null);
    }
    public static boolean connects(WorldView world, BlockState state, BlockPos pos, BlockPos otherpos, @Nullable Direction testDirection) {
        BlockState other = world.getBlockState(otherpos);
        if (connectsToBlockOrFalse(state, other) && connectsToBlockOrFalse(other, state)) {
            return state.get(FACING) == other.get(FACING) ||
                    getBaseBlock(state, pos).getSquaredDistance(getBaseBlock(other, otherpos)) == 0 ||
                    (testDirection != null && other.get(FACING) == testDirection);
        }
        return false;
    }
    public BlockState copyState(BlockState other) {
        return getDefaultState().with(FACING, other.get(FACING)).with(NORTH, other.get(NORTH)).with(SOUTH, other.get(SOUTH)).with(EAST, other.get(EAST)).with(WEST, other.get(WEST)).with(CONNECTED, other.get(CONNECTED));
    }
//    public static IntProperty getConnectionProperty(BlockState state, Direction direction) {
//        var angle = state.get(FACING).getUnitVector().rotationTo(Direction.UP.getUnitVector(), Direction.UP.getRotationQuaternion());
//        var newVec = direction.getUnitVector().rotate(angle);
//        var dir = Direction.fromVector(new Vec3i((int) newVec.x, (int) newVec.y, (int) newVec.z), Direction.UP);
//        switch (dir) {
//            case SOUTH -> {
//                return NORTH;
//            }
//            case EAST -> {
//                return EAST;
//            }
//            case WEST -> {
//                return WEST;
//            }
//            default -> {
//                return SOUTH;
//            }
//        }
//    }
//    public static int getConnectionValue(BlockState state, BlockState other, Direction direction) {
//        return other.get(FACING) == state.get(FACING) ? 1 : 2;
//    }
    private boolean canRunOnTop(BlockView world, BlockPos pos, Direction facing) {
        return world.getBlockState(pos).isSideSolidFullSquare(world, pos, facing);
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        if (direction == state.get(FACING)) {
            return canRunOnTop(world, neighborPos, direction) ? state : Blocks.AIR.getDefaultState();
        } else if (direction == state.get(FACING).getOpposite()) {
            return state;
        } else {
            return getPlacementState(state.get(FACING).getOpposite(), pos, world);
                //return state.with(getConnectionProperty(state, direction), getConnectionValue(state, neighborState, direction));
        }
    }

    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        if (!world.isClient && sourceBlock != this && !state.canPlaceAt(world, pos)) {
            dropStacks(state, world, pos);
            world.removeBlock(pos, false);
        }
    }

    protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!oldState.isOf(state.getBlock()) && !world.isClient) {
            for(Vec3i vec : NEIGHBORS) {
                //state.get(FACING).getRotationQuaternion();
                world.updateNeighborsAlways(pos.add(vec), this);
            }
        }
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.PASS;
        } else {
            if (!state.get(CONNECTED)) {
                if(state.get(NORTH) > 0) {
                    state = state.with(NORTH, 0).with(SOUTH, 0).with(EAST, 0).with(WEST, 0);
                } else {
                    state = state.with(NORTH, 1).with(SOUTH, 1).with(EAST, 1).with(WEST, 1);
                }
                world.setBlockState(pos, state, 3);
                return ActionResult.SUCCESS;
            }

            return ActionResult.PASS;
        }
    }
}
