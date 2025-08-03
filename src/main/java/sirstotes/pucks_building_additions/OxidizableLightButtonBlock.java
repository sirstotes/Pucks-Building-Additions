package sirstotes.pucks_building_additions;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Degradable;
import net.minecraft.block.Oxidizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class OxidizableLightButtonBlock extends LightButtonBlock implements Oxidizable {
    //? if >1.20.1 {
    public static final MapCodec<OxidizableLightButtonBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(Oxidizable.OxidationLevel.CODEC.fieldOf("weathering_state").forGetter(Degradable::getDegradationLevel), createSettingsCodec())
                    .apply(instance, OxidizableLightButtonBlock::new)
    );
    //?}
    private final Oxidizable.OxidationLevel oxidationLevel;
    public OxidizableLightButtonBlock(OxidationLevel oxidationLevel, int pressTicks, int lightLevel, Settings settings) {
        super(pressTicks, lightLevel, settings);
        this.oxidationLevel = oxidationLevel;
    }

    public OxidizableLightButtonBlock(OxidationLevel oxidationLevel, Settings settings) {
        super(10, 10, settings);
        this.oxidationLevel = oxidationLevel;
    }

    @Override
    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickDegradation(state, world, pos, random);
    }

    @Override
    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    public Oxidizable.OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }
}
