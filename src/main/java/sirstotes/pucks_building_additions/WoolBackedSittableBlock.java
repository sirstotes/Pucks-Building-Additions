package sirstotes.pucks_building_additions;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.state.StateManager;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WoolBackedSittableBlock extends BackedSittableBlock {
    public WoolBackedSittableBlock(DyeColor color, Settings settings) {
        super(settings);
        this.color = color;
    }
    public static final MapCodec<BedBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> {
        return instance.group(DyeColor.CODEC.fieldOf("color").forGetter(BedBlock::getColor), createSettingsCodec()).apply(instance, BedBlock::new);
    });
    public MapCodec<BedBlock> getCodec() {
        return CODEC;
    }

    private final DyeColor color;

    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        super.onLandedUpon(world, state, pos, entity, fallDistance * 0.5F);
    }

    public void onEntityLand(BlockView world, Entity entity) {
        if (entity.bypassesLandingEffects()) {
            super.onEntityLand(world, entity);
        } else {
            this.bounceEntity(entity);
        }

    }

    private void bounceEntity(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        if (vec3d.y < 0.0) {
            double d = entity instanceof LivingEntity ? 1.0 : 0.8;
            entity.setVelocity(vec3d.x, -vec3d.y * 0.6600000262260437 * d, vec3d.z);
        }
    }

    public DyeColor getColor() {
        return this.color;
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new WoolSittableBlockEntity(pos, state);}
}
