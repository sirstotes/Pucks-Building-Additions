package sirstotes.pucks_building_additions;

import net.minecraft.block.BlockState;

public class SugarBlock extends WireBlock {
    public SugarBlock(Settings settings) {
        super(settings, false);
    }

    public boolean connectsToBlock(BlockState state) {
        return state.getBlock() instanceof SugarBlock;
    }
}
