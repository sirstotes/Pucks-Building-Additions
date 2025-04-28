package sirstotes.pucks_building_additions.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.Block;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sirstotes.pucks_building_additions.PucksBuildingAdditionsBlocks;

@Mixin(Item.class)
public class ItemMixin {
    @ModifyReturnValue(method = "useOnBlock(Lnet/minecraft/item/ItemUsageContext;)Lnet/minecraft/util/ActionResult;", at = @At("RETURN"))
    public ActionResult useOnBlock(ActionResult original, @Local(argsOnly = true) ItemUsageContext context) {
        BlockItem item = PucksBuildingAdditionsBlocks.getItemPlacement(context.getStack().getItem());
        if (item != null) {
            ActionResult actionResult = item.place(new ItemPlacementContext(context));
            return !actionResult.isAccepted() && context.getStack().contains(DataComponentTypes.CONSUMABLE) ? original : actionResult;
        }
        return original;
    }
}
