package sirstotes.pucks_building_additions;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;


public class BlazePowderBlock extends WireBlock {
    public BlazePowderBlock(Settings settings) {
        super(settings, false);
    }

    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity) {
            entity.setOnFireFor(5);
        }
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextFloat() < 0.2f) {
            world.addParticle(ParticleTypes.FLAME, pos.getX() + random.nextFloat(), pos.getY() + 0.01f, pos.getZ() + random.nextFloat(), 0.0, 0.0, 0.0);
        }
    }

    public boolean connectsToBlock(BlockState state) {
        return state.getBlock() instanceof BlazePowderBlock;
    }
}
