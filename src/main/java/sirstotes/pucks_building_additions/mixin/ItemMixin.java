package sirstotes.pucks_building_additions.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import sirstotes.pucks_building_additions.PucksBuildingAdditionsBlocks;

import java.util.Iterator;
/*? if >1.20.1 {*/
import net.minecraft.component.DataComponentTypes;
/*?}*/

@Mixin(Item.class)
public class ItemMixin {
    @ModifyReturnValue(method = "useOnBlock(Lnet/minecraft/item/ItemUsageContext;)Lnet/minecraft/util/ActionResult;", at = @At("RETURN"))
    public ActionResult useOnBlock(ActionResult original, @Local(argsOnly = true) ItemUsageContext context) {
        Block block = PucksBuildingAdditionsBlocks.getItemPlacement(context.getStack().getItem());
        if (block != null) {
            ActionResult actionResult = pucksBuildingAdditions$placeBlockItem(block, new ItemPlacementContext(context));
            return !actionResult.isAccepted() /*? if >1.20.1 {*/&& context.getStack().contains(DataComponentTypes.CONSUMABLE)/*?}*/ ? original : actionResult;
        }
        return original;
    }

    @Unique
    public ActionResult pucksBuildingAdditions$placeBlockItem(Block block, ItemPlacementContext context) {
        if (!block.isEnabled(context.getWorld().getEnabledFeatures())) {
            return ActionResult.FAIL;
        } else if (!context.canPlace()) {
            return ActionResult.FAIL;
        } else {
            if (context == null) {
                return ActionResult.FAIL;
            } else {
                BlockState blockState = block.getPlacementState(context);
                if (blockState == null) {
                    return ActionResult.FAIL;
                } else if (!pucksBuildingAdditions$place(context, blockState)) {
                    return ActionResult.FAIL;
                } else {
                    BlockPos blockPos = context.getBlockPos();
                    World world = context.getWorld();
                    PlayerEntity playerEntity = context.getPlayer();
                    ItemStack itemStack = context.getStack();
                    BlockState blockState2 = world.getBlockState(blockPos);
//                    if (blockState2.isOf(blockState.getBlock())) {
//                        blockState2 = pucksBuildingAdditions$placeFromNbt(blockPos, world, itemStack, blockState2);
//                        pucksBuildingAdditions$writeNbtToBlockEntity(world, playerEntity, blockPos, itemStack);
//                        blockState2.getBlock().onPlaced(world, blockPos, blockState2, playerEntity, itemStack);
//                        if (playerEntity instanceof ServerPlayerEntity) {
//                            Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity)playerEntity, blockPos, itemStack);
//                        }
//                    }

                    BlockSoundGroup blockSoundGroup = blockState2.getSoundGroup();
                    world.playSound(playerEntity, blockPos, blockState2.getSoundGroup().getPlaceSound(), SoundCategory.BLOCKS, (blockSoundGroup.getVolume() + 1.0F) / 2.0F, blockSoundGroup.getPitch() * 0.8F);
                    world.emitGameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Emitter.of(playerEntity, blockState2));
                    if (playerEntity == null || !playerEntity.getAbilities().creativeMode) {
                        itemStack.decrement(1);
                    }
                    /*? if >1.20.1 {*/
                    return ActionResult.SUCCESS;
                    /*?} else {*/
                    /*return ActionResult.success(world.isClient);
                    *//*?}*/
                }
            }
        }
    }
    @Unique
    protected boolean pucksBuildingAdditions$place(ItemPlacementContext context, BlockState state) {
        return context.getWorld().setBlockState(context.getBlockPos(), state, 11);
    }
    @Unique
    private static <T extends Comparable<T>> BlockState pucksBuildingAdditions$with(BlockState state, Property<T> property, String name) {
        return property.parse(name).map((value) -> state.with(property, value)).orElse(state);
    }
}
