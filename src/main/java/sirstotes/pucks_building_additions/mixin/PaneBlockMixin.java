package sirstotes.pucks_building_additions.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sirstotes.pucks_building_additions.PaneDoorBlock;

@Mixin(PaneBlock.class)
public class PaneBlockMixin {
    @ModifyReturnValue(method = "connectsTo", at = @At("RETURN"))
    public boolean includePaneDoors (boolean original, BlockState state, boolean sideSolidFullSquare) {
        return original || state.getBlock() instanceof PaneDoorBlock;//TODO: Only connect to side of pane doors.
    }
}
