package sirstotes.pucks_building_additions;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class SittableBlockEntity extends BlockEntity {
    public Entity sittableEntity;
    public SittableBlockEntity(BlockPos pos, BlockState state) {
        super(PucksBuildingAdditionsBlocks.SITTABLE_BLOCK_ENTITY, pos, state);
    }
    public SittableBlockEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    public Entity getSittableEntity() {
        if ((sittableEntity == null || sittableEntity.isRemoved()) && getWorld() instanceof ServerWorld) {
            sittableEntity = new SittableEntity(PucksBuildingAdditions.SITTABLE, getWorld());
            getWorld().spawnEntity(sittableEntity);
            sittableEntity.setPosition(Vec3d.of(pos).add(0.5f, 0f, 0.5f));
        }
        return sittableEntity;
    }
}
