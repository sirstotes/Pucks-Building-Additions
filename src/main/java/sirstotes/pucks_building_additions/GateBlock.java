package sirstotes.pucks_building_additions;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;
/*? if >1.20.1 {*/
import net.minecraft.world.block.WireOrientation;
/*?}*/

import java.util.function.BiConsumer;

public class GateBlock extends HorizontalFacingBlock {
    public MapCodec<CardboardGateBlock> getCodec() {
        return null;
    }
    public static final BooleanProperty OPEN = Properties.OPEN;
    public static final BooleanProperty POWERED = Properties.POWERED;
    protected static final VoxelShape Z_AXIS_SHAPE = Block.createCuboidShape(0, 0, 7, 16, 16, 9);
    protected static final VoxelShape X_AXIS_SHAPE = Block.createCuboidShape(7, 0, 0, 9, 16, 16);
    public GateBlock(Settings settings) {
        super(settings);
    }
    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(FACING).getAxis() == Direction.Axis.X ? X_AXIS_SHAPE : Z_AXIS_SHAPE;
    }
    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(OPEN)) {
            return VoxelShapes.empty();
        } else {
            return state.get(FACING).getAxis() == Direction.Axis.X ? X_AXIS_SHAPE : Z_AXIS_SHAPE;
        }
    }
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        switch (type) {
            case LAND, AIR -> {
                return state.get(OPEN);
            }
            default -> {
                return false;
            }
        }
    }
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        boolean bl = world.isReceivingRedstonePower(blockPos);
        Direction direction = ctx.getHorizontalPlayerFacing();
        return this.getDefaultState().with(FACING, direction).with(OPEN, bl).with(POWERED, bl);
    }

    /*? if >1.20.1 {*/
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
     /*?} else {*/
    /*public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
    *//*?}*/
        if (state.get(OPEN)) {
            state = state.with(OPEN, false);
            world.setBlockState(pos, state, 10);
        } else {
            Direction direction = player.getHorizontalFacing();
            if (state.get(FACING) == direction.getOpposite()) {
                state = state.with(FACING, direction);
            }

            state = state.with(OPEN, true);
            world.setBlockState(pos, state, 10);
        }

        boolean bl = state.get(OPEN);
        world.playSound(player, pos, bl ? WoodType.OAK.fenceGateOpen() : WoodType.OAK.fenceGateClose(), SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F);
        world.emitGameEvent(player, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
        return ActionResult.SUCCESS;
    }
    /*? if >1.20.1 {*/
    protected void onExploded(BlockState state, ServerWorld world, BlockPos pos, Explosion explosion, BiConsumer<ItemStack, BlockPos> stackMerger) {
        if (explosion.canTriggerBlocks() && !(Boolean)state.get(POWERED)) {
            boolean bl = state.get(OPEN);
            world.setBlockState(pos, state.with(OPEN, !bl));
            world.playSound(null, pos, bl ? WoodType.OAK.fenceGateClose() : WoodType.OAK.fenceGateOpen(), SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F);
            world.emitGameEvent(bl ? GameEvent.BLOCK_CLOSE : GameEvent.BLOCK_OPEN, pos, GameEvent.Emitter.of(state));
        }

        super.onExploded(state, world, pos, explosion, stackMerger);
    }
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        if (!world.isClient) {
            boolean bl = world.isReceivingRedstonePower(pos);
            if (state.get(POWERED) != bl) {
                world.setBlockState(pos, state.with(POWERED, bl).with(OPEN, bl), 2);
                if (state.get(OPEN) != bl) {
                    world.playSound(null, pos, bl ? WoodType.OAK.fenceGateOpen() : WoodType.OAK.fenceGateClose(), SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F);
                    world.emitGameEvent(null, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
                }
            }

        }
    }
    /*?} else {*/
    /*public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClient) {
            boolean bl = world.isReceivingRedstonePower(pos);
            if (state.get(POWERED) != bl) {
                world.setBlockState(pos, state.with(POWERED, bl).with(OPEN, bl), 2);
                if (state.get(OPEN) != bl) {
                    world.playSound(null, pos, bl ? WoodType.OAK.fenceGateOpen() : WoodType.OAK.fenceGateClose(), SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F);
                    world.emitGameEvent(null, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
                }
            }

        }
    }
    *//*?}*/
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN, POWERED);
    }
    public static boolean canWallConnect(BlockState state, Direction side) {
        return state.get(FACING).getAxis() == side.rotateYClockwise().getAxis();
    }
}
