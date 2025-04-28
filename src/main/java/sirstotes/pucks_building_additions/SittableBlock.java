package sirstotes.pucks_building_additions;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class SittableBlock extends Block implements BlockEntityProvider {
    public static final BooleanProperty OCCUPIED = Properties.OCCUPIED;
    protected static final VoxelShape TOP_SHAPE = Block.createCuboidShape(0.0, 3.0, 0.0, 16.0, 9.0, 16.0);
    protected static final VoxelShape LEG_1_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 3.0, 3.0, 3.0);
    protected static final VoxelShape LEG_2_SHAPE = Block.createCuboidShape(0.0, 0.0, 13.0, 3.0, 3.0, 16.0);
    protected static final VoxelShape LEG_3_SHAPE = Block.createCuboidShape(13.0, 0.0, 0.0, 16.0, 3.0, 3.0);
    protected static final VoxelShape LEG_4_SHAPE = Block.createCuboidShape(13.0, 0.0, 13.0, 16.0, 3.0, 16.0);
    protected static final VoxelShape BLOCK_SHAPE = VoxelShapes.union(TOP_SHAPE, LEG_1_SHAPE, LEG_2_SHAPE, LEG_3_SHAPE, LEG_4_SHAPE);

    public SittableBlock(AbstractBlock.Settings settings) {
        super(settings);
        setDefaultState(stateManager.getDefaultState().with(OCCUPIED, false));
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS_SERVER;
        } else {
            if(world.getBlockEntity(pos) instanceof SittableBlockEntity) {
                if (state.get(OCCUPIED)) {
                    //remove villagers if sitting
                    return ActionResult.SUCCESS_SERVER;
                } else {
                    Entity s = ((SittableBlockEntity) Objects.requireNonNull(world.getBlockEntity(pos))).getSittableEntity();
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

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(OCCUPIED);
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BLOCK_SHAPE;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new SittableBlockEntity(pos, state);}
}
