package sirstotes.pucks_building_additions;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface Cardboard {
    void hydrate(World world, BlockPos pos);
    void dehydrate(World world, BlockPos pos);
}
