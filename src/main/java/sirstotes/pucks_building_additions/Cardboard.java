package sirstotes.pucks_building_additions;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface Cardboard {
    public void hydrate(World world, BlockPos pos);
    public void dehydrate(World world, BlockPos pos);
}
