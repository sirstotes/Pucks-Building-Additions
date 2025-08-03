package sirstotes.pucks_building_additions;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class StoolBlock extends SittableBlock {

    public static final int MAX_ROTATION_INDEX = RotationPropertyHelper.getMax();
    private static final int MAX_ROTATIONS = MAX_ROTATION_INDEX + 1;
    public static final IntProperty ROTATION = Properties.ROTATION;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);

    public StoolBlock(Settings settings) {
        super(settings);
    }

    @Override

    /*? if >1.20.1 {*/
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
     /*?} else {*/
    /*public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
    *//*?}*/
        if (world.isClient) {
            return /*? if <1.21.2 {*//*ActionResult.SUCCESS*//*?} else {*/ActionResult.SUCCESS_SERVER/*?}*/;
        } else {
            if(world.getBlockEntity(pos) instanceof StoolBlockEntity) {
                if (state.get(OCCUPIED)) {
                    //remove villagers if sitting
                    return /*? if <1.21.2 {*//*ActionResult.SUCCESS*//*?} else {*/ActionResult.SUCCESS_SERVER/*?}*/;
                } else {
                    Entity s = ((StoolBlockEntity) Objects.requireNonNull(world.getBlockEntity(pos))).getSittableEntity();
                    if (player.shouldCancelInteraction()) {
                        return ActionResult.PASS;
                    } else {
                        return player.startRiding(s) ? ActionResult.CONSUME : ActionResult.PASS;
                    }
                }
            }
        }
        return ActionResult.PASS;
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(ROTATION, RotationPropertyHelper.fromYaw(ctx.getPlayerYaw()));
    }

    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    protected VoxelShape getCullingShape(BlockState state) {
        return VoxelShapes.empty();
    }

    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(ROTATION, rotation.rotate(state.get(ROTATION), MAX_ROTATIONS));
    }

    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.with(ROTATION, mirror.mirror(state.get(ROTATION), MAX_ROTATIONS));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(ROTATION);
    }
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    @Override
    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new StoolBlockEntity(pos, state);}
}
