package sirstotes.pucks_building_additions;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;
import java.util.function.BiConsumer;
import java.util.function.ToIntFunction;
/*? if >1.20.1 {*/
import net.minecraft.world.block.OrientationHelper;
import net.minecraft.world.block.WireOrientation;
/*?}*/

public class LightButtonBlock extends Block {
    public static final BooleanProperty POWERED = Properties.POWERED;
    public static final EnumProperty<Direction> FACING = Properties.FACING;
    public static final BooleanProperty ACTIVE = /*? if >1.20.1 {*/Properties.ACTIVE/*?} else {*//*BooleanProperty.of("active")*//*?}*/;
    protected static final VoxelShape DOWN_SHAPE = Block.createCuboidShape(5.0, 14.0, 5.0, 11.0, 16.0, 11.0);
    protected static final VoxelShape UP_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 2.0, 11.0);
    protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(5.0, 5.0, 14.0, 11.0, 11.0, 16.0);
    protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(5.0, 5.0, 0.0, 11.0, 11.0, 2.0);
    protected static final VoxelShape WEST_SHAPE = Block.createCuboidShape(14.0, 5.0, 5.0, 16.0, 11.0, 11.0);
    protected static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0.0, 5.0, 5.0, 2.0, 11.0, 11.0);
    protected static final VoxelShape DOWN_ACTIVE_SHAPE = Block.createCuboidShape(5.0, 15.0, 5.0, 11.0, 16.0, 11.0);
    protected static final VoxelShape UP_ACTIVE_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 1.0, 11.0);
    protected static final VoxelShape NORTH_ACTIVE_SHAPE = Block.createCuboidShape(5.0, 5.0, 15.0, 11.0, 11.0, 16.0);
    protected static final VoxelShape SOUTH_ACTIVE_SHAPE = Block.createCuboidShape(5.0, 5.0, 0.0, 11.0, 11.0, 1.0);
    protected static final VoxelShape WEST_ACTIVE_SHAPE = Block.createCuboidShape(15.0, 5.0, 5.0, 16.0, 11.0, 11.0);
    protected static final VoxelShape EAST_ACTIVE_SHAPE = Block.createCuboidShape(0.0, 5.0, 5.0, 1.0, 11.0, 11.0);
    protected static final VoxelShape DOWN_PRESSED_SHAPE = Block.createCuboidShape(5.0, 15.5, 5.0, 11.0, 16.0, 11.0);
    protected static final VoxelShape UP_PRESSED_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 0.5, 11.0);
    protected static final VoxelShape NORTH_PRESSED_SHAPE = Block.createCuboidShape(5.0, 5.0, 15.5, 11.0, 11.0, 16.0);
    protected static final VoxelShape SOUTH_PRESSED_SHAPE = Block.createCuboidShape(5.0, 5.0, 0.0, 11.0, 11.0, 0.5);
    protected static final VoxelShape WEST_PRESSED_SHAPE = Block.createCuboidShape(15.5, 5.0, 5.0, 16.0, 11.0, 11.0);
    protected static final VoxelShape EAST_PRESSED_SHAPE = Block.createCuboidShape(0.0, 5.0, 5.0, 0.5, 11.0, 11.0);
    private final int pressTicks;
    
    public LightButtonBlock(int pressTicks, int lightLevel, Settings settings) {
        super(settings.luminance(getLuminanceFromLightButtonState(lightLevel)));
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(POWERED, false).with(ACTIVE, false));
        this.pressTicks = pressTicks;
    }
    public static ToIntFunction<BlockState> getLuminanceFromLightButtonState(int litLevel) {
        return (state) -> state.get(ACTIVE) || state.get(Properties.POWERED) ? litLevel : 0;
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction[] var2 = ctx.getPlacementDirections();

        for (Direction direction : var2) {
            BlockState blockState;
            blockState = this.getDefaultState().with(FACING, direction.getOpposite());

            if (blockState.canPlaceAt(ctx.getWorld(), ctx.getBlockPos())) {
                return blockState;
            }
        }

        return null;
    }

    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        boolean pressed = state.get(POWERED);
        boolean active = state.get(ACTIVE);

        return switch (direction) {
            case EAST -> pressed ? EAST_PRESSED_SHAPE : (active ? EAST_ACTIVE_SHAPE : EAST_SHAPE);
            case WEST -> pressed ? WEST_PRESSED_SHAPE : (active ? WEST_ACTIVE_SHAPE : WEST_SHAPE);
            case SOUTH -> pressed ? SOUTH_PRESSED_SHAPE : (active ? SOUTH_ACTIVE_SHAPE : SOUTH_SHAPE);
            case NORTH -> pressed ? NORTH_PRESSED_SHAPE : (active ? NORTH_ACTIVE_SHAPE : NORTH_SHAPE);
            case UP -> pressed ? UP_PRESSED_SHAPE : (active ? UP_ACTIVE_SHAPE : UP_SHAPE);
            case DOWN -> pressed ? DOWN_PRESSED_SHAPE : (active ? DOWN_ACTIVE_SHAPE : DOWN_SHAPE);
        };
    }
    /*? if >1.20.1 {*/
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
    /*?} else {*/
    /*public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
    *//*?}*/
        if (state.get(POWERED)) {
            return ActionResult.CONSUME;
        } else {
            this.powerOn(state, world, pos, player);
            return ActionResult.SUCCESS;
        }
    }

    /*? if >1.20.1 {*/
    protected void onExploded(BlockState state, ServerWorld world, BlockPos pos, Explosion explosion, BiConsumer<ItemStack, BlockPos> stackMerger) {
        if (explosion.canTriggerBlocks() && !state.get(POWERED)) {
            this.powerOn(state, world, pos, null);
        }

        super.onExploded(state, world, pos, explosion, stackMerger);
    }
    /*?}*/

    public void powerOn(BlockState state, World world, BlockPos pos, @Nullable PlayerEntity player) {
        world.setBlockState(pos, state.with(POWERED, true), 3);
        this.updateNeighbors(state, world, pos);
        world.scheduleBlockTick(pos, this, this.pressTicks);
        this.playClickSound(player, world, pos, true);
        world.emitGameEvent(player, GameEvent.BLOCK_ACTIVATE, pos);
    }

    protected void playClickSound(@Nullable PlayerEntity player, WorldAccess world, BlockPos pos, boolean powered) {
        world.playSound(powered ? player : null, pos, this.getClickSound(powered), SoundCategory.BLOCKS);
    }

    protected SoundEvent getClickSound(boolean powered) {
        return powered ? BlockSetType.STONE.buttonClickOn() : BlockSetType.STONE.buttonClickOff();
    }

    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!moved && !state.isOf(newState.getBlock())) {
            if (state.get(ACTIVE)) {
                this.updateNeighbors(state, world, pos);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(ACTIVE) ? 15 : 0;
    }

    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(ACTIVE) && state.get(FACING) == direction ? 15 : 0;
    }

    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(POWERED)) {
            this.tryPowerWithProjectiles(state, world, pos);
        }
    }

    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && /*? if >1.20.1 {*/BlockSetType.STONE.canButtonBeActivatedByArrows() &&/*?}*/ !state.get(POWERED)) {
            this.tryPowerWithProjectiles(state, world, pos);
        }
    }

    protected void tryPowerWithProjectiles(BlockState state, World world, BlockPos pos) {
        PersistentProjectileEntity persistentProjectileEntity = true/*? if >1.20.1 {*/&& BlockSetType.STONE.canButtonBeActivatedByArrows()/*?}*/ ? world.getNonSpectatingEntities(PersistentProjectileEntity.class, state.getOutlineShape(world, pos).getBoundingBox().offset(pos)).stream().findFirst().orElse(null) : null;
        boolean hasArrow = persistentProjectileEntity != null;
        if (hasArrow != state.get(POWERED)) {
            world.setBlockState(pos, state.with(POWERED, hasArrow).with(ACTIVE, !state.get(ACTIVE)), 3);
            updateNeighbors(state, world, pos);
            playClickSound(null, world, pos, hasArrow);
            world.emitGameEvent(persistentProjectileEntity, hasArrow ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pos);
        }

        if (hasArrow) {
            world.scheduleBlockTick(new BlockPos(pos), this, this.pressTicks);
        }

    }

    private void updateNeighbors(BlockState blockState, World world, BlockPos pos) {
        Direction direction = blockState.get(FACING).getOpposite();
        /*? if >1.20.1 {*/
        WireOrientation wireOrientation = OrientationHelper.getEmissionOrientation(world, direction, direction.getAxis().isHorizontal() ? Direction.UP : blockState.get(FACING));
        /*?}*/
        world.updateNeighborsAlways(pos, this/*? if >1.20.1 {*/, wireOrientation/*?}*/);
        world.updateNeighborsAlways(pos.offset(direction), this/*? if >1.20.1 {*/, wireOrientation/*?}*/);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, POWERED, ACTIVE);
    }
}