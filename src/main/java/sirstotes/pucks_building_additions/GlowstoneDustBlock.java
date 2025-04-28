package sirstotes.pucks_building_additions;

import net.minecraft.block.BlockState;

public class GlowstoneDustBlock extends WireBlock {
    public GlowstoneDustBlock(Settings settings) {
        super(settings, false);
    }

    public boolean connectsToBlock(BlockState state) {
        return state.getBlock() instanceof GlowstoneDustBlock;
    }
}