package sirstotes.pucks_building_additions;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class StoolBlockEntity extends SittableBlockEntity {
    public StoolBlockEntity(BlockPos pos, BlockState state) {
        super(PucksBuildingAdditionsBlocks.STOOL_BLOCK_ENTITY, pos, state);
    }
}