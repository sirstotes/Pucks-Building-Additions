package sirstotes.pucks_building_additions;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class SittableEntity extends Entity {

    public SittableEntity(EntityType<SittableEntity> type, World world) {
        super(type, world);
        setInvulnerable(true);
        setInvisible(true);
    }

    @Override
    public void baseTick() {
        super.baseTick();
        if (!hasPassengers()) {
            remove(RemovalReason.DISCARDED);
        }
    }

    @Override
    protected void initDataTracker(/*? if >1.20.1 {*/DataTracker.Builder builder/*?}*/) {

    }

    @Override
    public boolean damage(/*? if >1.20.1 {*/ServerWorld world,/*?}*/ DamageSource source, float amount) {
        return false;
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }
}
