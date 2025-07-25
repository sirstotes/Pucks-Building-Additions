package sirstotes.pucks_building_additions;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PaneBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.block.WireOrientation;
import org.jetbrains.annotations.Nullable;

public class PaperPaneBlock extends PaneBlock {
    private final boolean isWaxed;
    public PaperPaneBlock(Settings settings, boolean waxed) {
        super(settings);
        isWaxed = waxed;
    }

    public void precipitationTick(BlockState state, World world, BlockPos pos, Biome.Precipitation precipitation) {
        if (precipitation.equals(Biome.Precipitation.RAIN) && !isWaxed) {
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
            world.playSound(null, pos, SoundEvents.BLOCK_BAMBOO_WOOD_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }

    protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        this.update(world, pos);
    }

    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        this.update(world, pos);
        super.neighborUpdate(state, world, pos, sourceBlock, wireOrientation, notify);
    }

    protected void update(World world, BlockPos pos) {
        if (!isWaxed && !(world.getFluidState(pos.up()).isEmpty() && world.getFluidState(pos.down()).isEmpty() && world.getFluidState(pos.north()).isEmpty() && world.getFluidState(pos.east()).isEmpty() && world.getFluidState(pos.south()).isEmpty() && world.getFluidState(pos.west()).isEmpty())) {
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
            world.playSound(null, pos, SoundEvents.BLOCK_BAMBOO_WOOD_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }
}
