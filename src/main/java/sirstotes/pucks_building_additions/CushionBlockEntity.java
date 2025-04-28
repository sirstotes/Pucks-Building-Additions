package sirstotes.pucks_building_additions;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class CushionBlockEntity extends WoolSittableBlockEntity {
    public CushionBlockEntity(BlockPos pos, BlockState state) {
        super(PucksBuildingAdditionsBlocks.CUSHION_BLOCK_ENTITY, pos, state);
    }
    public Entity getSittableEntity() {
        if ((sittableEntity == null || sittableEntity.isRemoved()) && getWorld() instanceof ServerWorld) {
            sittableEntity = new SittableEntity(PucksBuildingAdditions.SITTABLE, getWorld());
            getWorld().spawnEntity(sittableEntity);
            sittableEntity.setPosition(Vec3d.of(pos).add(0.5f, -0.25f, 0.5f));
        }
        return sittableEntity;
    }
}