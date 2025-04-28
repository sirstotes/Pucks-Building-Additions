package sirstotes.pucks_building_additions;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class HangingFlowerPotBlock extends ColoredFlowerPotBlock {
    public Identifier texture;
    public final boolean usesSpecialModel;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 5.0, 4.0, 12.0, 11.0, 12.0);

    public HangingFlowerPotBlock(Block content, Block parent, Settings settings, String variantName, Identifier tex) {
        super(content, parent, settings, variantName);
        usesSpecialModel = false;
        texture = tex;
    }

    public HangingFlowerPotBlock(Block content, Block parent, Settings settings, String variantName) {
        super(content, parent, settings, variantName);
        usesSpecialModel = true;
    }

    public HangingFlowerPotBlock(Block content, Settings settings, String variantName) {
        super(content, settings, variantName);
        usesSpecialModel = true;
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return Block.sideCoversSmallSquare(world, pos.offset(Direction.UP), Direction.DOWN);
    }
}
