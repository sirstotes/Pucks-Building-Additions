package sirstotes.pucks_building_additions;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.util.math.BlockPos;

public class ColoredDecoratedPotBlockEntity extends DecoratedPotBlockEntity {
    public String color;

    public ColoredDecoratedPotBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
        this.color = "red";
    }
    public ColoredDecoratedPotBlockEntity(BlockPos pos, BlockState state, String color) {
        super(pos, state);
        this.color = color;
    }
}