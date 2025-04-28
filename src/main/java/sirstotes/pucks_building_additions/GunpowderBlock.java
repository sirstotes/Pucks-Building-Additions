package sirstotes.pucks_building_additions;

import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class GunpowderBlock extends WireBlock {
    public GunpowderBlock(Settings settings) {
        super(settings, false);
    }

    public boolean connectsToBlock(BlockState state) {
        return state.getBlock() instanceof GunpowderBlock;
    }

    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(Items.FLINT_AND_STEEL) || stack.isOf(Items.FIRE_CHARGE)) {
            if (!world.isClient) light((ServerWorld) world, pos);
            return ActionResult.SUCCESS;
        }
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

//    @Override
//    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
//        if (neighborState.getBlock() instanceof FireBlock) {
//            return FireBlock.getState(world, pos);
//        }
//        return super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
//    }
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        light(world, pos);
    }

    public void light(World world, BlockPos pos) {
        world.scheduleBlockTick(pos.offset(Direction.NORTH), PucksBuildingAdditionsBlocks.GUNPOWDER, 5);
        world.scheduleBlockTick(pos.offset(Direction.SOUTH), PucksBuildingAdditionsBlocks.GUNPOWDER, 5);
        world.scheduleBlockTick(pos.offset(Direction.EAST), PucksBuildingAdditionsBlocks.GUNPOWDER, 5);
        world.scheduleBlockTick(pos.offset(Direction.WEST), PucksBuildingAdditionsBlocks.GUNPOWDER, 5);
        world.scheduleBlockTick(pos.offset(Direction.NORTH).offset(Direction.UP), PucksBuildingAdditionsBlocks.GUNPOWDER, 5);
        world.scheduleBlockTick(pos.offset(Direction.SOUTH).offset(Direction.UP), PucksBuildingAdditionsBlocks.GUNPOWDER, 5);
        world.scheduleBlockTick(pos.offset(Direction.EAST).offset(Direction.UP), PucksBuildingAdditionsBlocks.GUNPOWDER, 5);
        world.scheduleBlockTick(pos.offset(Direction.WEST).offset(Direction.UP), PucksBuildingAdditionsBlocks.GUNPOWDER, 5);
        world.scheduleBlockTick(pos.offset(Direction.NORTH).offset(Direction.DOWN), PucksBuildingAdditionsBlocks.GUNPOWDER, 5);
        world.scheduleBlockTick(pos.offset(Direction.SOUTH).offset(Direction.DOWN), PucksBuildingAdditionsBlocks.GUNPOWDER, 5);
        world.scheduleBlockTick(pos.offset(Direction.EAST).offset(Direction.DOWN), PucksBuildingAdditionsBlocks.GUNPOWDER, 5);
        world.scheduleBlockTick(pos.offset(Direction.WEST).offset(Direction.DOWN), PucksBuildingAdditionsBlocks.GUNPOWDER, 5);
        world.setBlockState(pos, FireBlock.getState(world, pos));
    }
}