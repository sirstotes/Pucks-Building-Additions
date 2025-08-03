package sirstotes.pucks_building_additions;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class LargeFlowerPotBlock extends ColoredFlowerPotBlock {

    public Identifier bottomTexture;
    public Identifier topTexture;
    public final boolean usesSpecialModel;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 6.0, 13.0);

    public LargeFlowerPotBlock(Block content, Block parent, Settings settings, String variantName, Identifier bottom, Identifier top) {
        super(content, parent, settings, variantName);
        bottomTexture = bottom;
        topTexture = top;
        usesSpecialModel = false;
    }

    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public LargeFlowerPotBlock(Block content, Block parent, Settings settings, String variantName) {
        super(content, parent, settings, variantName);
        usesSpecialModel = true;
    }

    public LargeFlowerPotBlock(Block content, Settings settings, String variantName) {
        super(content, settings, variantName);
        usesSpecialModel = true;
    }
}
