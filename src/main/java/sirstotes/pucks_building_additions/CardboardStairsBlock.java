package sirstotes.pucks_building_additions;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.jetbrains.annotations.Nullable;
/*? if >1.20.1 {*/
import net.minecraft.world.block.WireOrientation;
 /*?}*/

import static sirstotes.pucks_building_additions.PucksBuildingAdditionsBlocks.CardboardMap;

public class CardboardStairsBlock extends StairsBlock implements Cardboard {
    private final boolean dry;

    public CardboardStairsBlock(Settings settings, boolean dry) {
        super(PucksBuildingAdditionsBlocks.CARDBOARD_BOX.getDefaultState(), settings);
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
        entity.handleFallDamage(fallDistance, 0.1F, world.getDamageSources().fall());
        if (world instanceof ServerWorld && world.random.nextFloat()*2 < fallDistance - 3F) {
            world.setBlockState(pos, PucksBuildingAdditionsBlocks.COLLAPSED_CARDBOARD.getDefaultState());
        }
        super.onLandedUpon(world, state, pos, entity, fallDistance);
    }
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!dry) {
            state = PucksBuildingAdditionsBlocks.WET_COLLAPSED_CARDBOARD.getDefaultState();
            world.setBlockState(pos, state);
            world.scheduleBlockTick(pos, state.getBlock(), 5);
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}
