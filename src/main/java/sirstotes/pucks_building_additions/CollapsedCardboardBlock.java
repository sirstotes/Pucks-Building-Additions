package sirstotes.pucks_building_additions;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.DebugInfoSender;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
/*? if >1.20.1 {*/
import net.minecraft.world.block.WireOrientation;
import net.minecraft.world.tick.ScheduledTickView;
/*?}*/
import org.jetbrains.annotations.Nullable;

import static sirstotes.pucks_building_additions.PucksBuildingAdditionsBlocks.CardboardMap;

public class CollapsedCardboardBlock extends FallingBlock implements Cardboard {
    /*? if >1.20.1 {*/
    @Override
    protected MapCodec<? extends FallingBlock> getCodec() {
        return null;
    }
    /*?}*/
    private final boolean dry;
    protected static final VoxelShape SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
            Block.createCuboidShape(0.0, 4.0, 0.0, 16.0, 8.0,1.0),
            Block.createCuboidShape(0.0, 4.0, 15.0, 16.0, 8.0, 16.0),
            Block.createCuboidShape(0.0, 4.0, 1.0, 1.0, 8.0,15.0),
            Block.createCuboidShape(15.0, 4.0, 1.0, 16.0, 8.0,15.0));
    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public CollapsedCardboardBlock(Settings settings, boolean dry) {
        super(settings);
        this.dry = dry;
    }
    public void precipitationTick(BlockState state, World world, BlockPos pos, Biome.Precipitation precipitation) {
        if (precipitation.equals(Biome.Precipitation.RAIN)) {
            hydrate(world, pos);
        } else if (precipitation.equals(Biome.Precipitation.NONE)) {
            dehydrate(world, pos);
        }
    }
    public void hydrate(World world, BlockPos pos) {
        if (dry) {
            world.setBlockState(pos, CardboardMap.get(this).getDefaultState());
        } else if (world.getBlockState(pos.down()).getBlock() instanceof Cardboard c) {
            c.hydrate(world, pos.down());
        }
    }
    public void dehydrate(World world, BlockPos pos) {
        if (!dry) {
            world.setBlockState(pos, CardboardMap.get(this).getDefaultState());
        } else if (world.getBlockState(pos.down()).getBlock() instanceof Cardboard c) {
            c.dehydrate(world, pos.down());
        }
    }
    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        this.update(world, pos);
        world.scheduleBlockTick(pos, this, this.getFallDelay());
    }
    /*? if >1.20.1 {*/
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        this.update(world, pos);
        super.neighborUpdate(state, world, pos, sourceBlock, wireOrientation, notify);
    }
    /*?} else {*/
    /*public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        this.update(world, pos);
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }
    *//*?}*/
    protected void update(World world, BlockPos pos) {
        if (!(world.getFluidState(pos.up()).isEmpty() && world.getFluidState(pos.down()).isEmpty() && world.getFluidState(pos.north()).isEmpty() && world.getFluidState(pos.east()).isEmpty() && world.getFluidState(pos.south()).isEmpty() && world.getFluidState(pos.west()).isEmpty())) {
            hydrate(world, pos);
        }
    }
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (world.random.nextFloat()*2 < fallDistance - 3F || !dry) {
            world.breakBlock(pos, false);
        }
        super.onLandedUpon(world, state, pos, entity, fallDistance);
    }
}
