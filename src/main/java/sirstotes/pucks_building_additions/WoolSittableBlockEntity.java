package sirstotes.pucks_building_additions;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class WoolSittableBlockEntity extends SittableBlockEntity {
    public WoolSittableBlockEntity(BlockPos pos, BlockState state) {
        super(PucksBuildingAdditionsBlocks.WOOL_SITTABLE_BLOCK_ENTITY, pos, state);
    }
    public WoolSittableBlockEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
