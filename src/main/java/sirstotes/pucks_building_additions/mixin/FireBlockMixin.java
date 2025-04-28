package sirstotes.pucks_building_additions.mixin;

import net.minecraft.block.FireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sirstotes.pucks_building_additions.GunpowderBlock;

@Mixin(FireBlock.class)
public class FireBlockMixin {
    @Inject(method = "Lnet/minecraft/block/FireBlock;trySpreadingFire(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;ILnet/minecraft/util/math/random/Random;I)V",
            at = @At("HEAD"))
    public void spreadToGunpowder(World world, BlockPos pos, int spreadFactor, Random random, int currentAge, CallbackInfo ci) {
        if (world.getBlockState(pos).getBlock() instanceof GunpowderBlock g) {
            g.light(world, pos);
        }
    }
}
