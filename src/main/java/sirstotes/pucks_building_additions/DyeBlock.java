package sirstotes.pucks_building_additions;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DyeBlock extends WireBlock {
    public final WireBlock glowing;
    public DyeBlock(Settings settings, WireBlock glowingVariant) {
        super(settings, true);
        glowing = glowingVariant;
    }

    /*? if >1.20.1 {*/
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(Items.GLOW_INK_SAC)) {
            world.setBlockState(pos, glowing.copyState(state));
            return ActionResult.SUCCESS;
        } else {
            return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
        }
    }/*?} else {*/
    /*protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(player.preferredHand);
        if (stack.isOf(Items.GLOW_INK_SAC)) {
            world.setBlockState(pos, glowing.copyState(state));
            return ActionResult.SUCCESS;
        } else {
            return super.onUse(state, world, pos, player, hit);
        }
    }
    *//*?}*/
}
