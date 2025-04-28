package sirstotes.pucks_building_additions;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.block.entity.Sherds;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.inventory.LootableInventory;
import net.minecraft.inventory.SingleStackInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ColoredDecoratedPotBlockEntity extends BlockEntity implements LootableInventory, SingleStackInventory.SingleStackBlockEntityInventory {
    public static final String SHERDS_NBT_KEY = "sherds";
    public static final String ITEM_NBT_KEY = "item";
    public static final int field_46660 = 1;
    public long lastWobbleTime;
    @Nullable
    public DecoratedPotBlockEntity.WobbleType lastWobbleType;
    private Sherds sherds;
    private ItemStack stack;
    @Nullable
    protected RegistryKey<LootTable> lootTableId;
    protected long lootTableSeed;
    public String color;

    public ColoredDecoratedPotBlockEntity(BlockPos pos, BlockState state) {
        super(PucksBuildingAdditionsBlocks.COLORED_POT_BLOCK_ENTITY, pos, state);
        this.stack = ItemStack.EMPTY;
        this.sherds = Sherds.DEFAULT;
        this.color = "red";
    }
    public ColoredDecoratedPotBlockEntity(BlockPos pos, BlockState state, String color) {
        super(PucksBuildingAdditionsBlocks.COLORED_POT_BLOCK_ENTITY, pos, state);
        this.stack = ItemStack.EMPTY;
        this.sherds = Sherds.DEFAULT;
        this.color = color;
    }

    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.writeNbt(nbt, registries);
        this.sherds.toNbt(nbt);
        if (!this.writeLootTable(nbt) && !this.stack.isEmpty()) {
            nbt.put(ITEM_NBT_KEY, this.stack.toNbt(registries));
        }
    }

    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.readNbt(nbt, registries);
        this.sherds = Sherds.fromNbt(nbt);
        if (!this.readLootTable(nbt)) {
            if (nbt.contains(ITEM_NBT_KEY, 10)) {
                this.stack = ItemStack.fromNbt(registries, nbt.getCompound(ITEM_NBT_KEY)).orElse(ItemStack.EMPTY);
            } else {
                this.stack = ItemStack.EMPTY;
            }
        }
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registries) {
        return this.createComponentlessNbt(registries);
    }

    public Direction getHorizontalFacing() {
        return this.getCachedState().get(Properties.HORIZONTAL_FACING);
    }

    public Sherds getSherds() {
        return this.sherds;
    }

    public static ItemStack getStackWith(Sherds sherds) {
        ItemStack itemStack = Items.DECORATED_POT.getDefaultStack();
        itemStack.set(DataComponentTypes.POT_DECORATIONS, sherds);
        return itemStack;
    }

    @Nullable
    public RegistryKey<LootTable> getLootTable() {
        return this.lootTableId;
    }

    public void setLootTable(@Nullable RegistryKey<LootTable> lootTable) {
        this.lootTableId = lootTable;
    }

    public long getLootTableSeed() {
        return this.lootTableSeed;
    }

    public void setLootTableSeed(long lootTableSeed) {
        this.lootTableSeed = lootTableSeed;
    }

    protected void addComponents(ComponentMap.Builder builder) {
        super.addComponents(builder);
        builder.add(DataComponentTypes.POT_DECORATIONS, this.sherds);
        builder.add(DataComponentTypes.CONTAINER, ContainerComponent.fromStacks(List.of(this.stack)));
    }

    protected void readComponents(BlockEntity.ComponentsAccess components) {
        super.readComponents(components);
        this.sherds = components.getOrDefault(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT);
        this.stack = components.getOrDefault(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT).copyFirstStack();
    }

    public void removeFromCopiedStackNbt(NbtCompound nbt) {
        super.removeFromCopiedStackNbt(nbt);
        nbt.remove(SHERDS_NBT_KEY);
        nbt.remove(ITEM_NBT_KEY);
    }

    public ItemStack getStack() {
        this.generateLoot(null);
        return this.stack;
    }

    public ItemStack decreaseStack(int count) {
        this.generateLoot(null);
        ItemStack itemStack = this.stack.split(count);
        if (this.stack.isEmpty()) {
            this.stack = ItemStack.EMPTY;
        }

        return itemStack;
    }

    public void setStack(ItemStack stack) {
        this.generateLoot(null);
        this.stack = stack;
    }

    public BlockEntity asBlockEntity() {
        return this;
    }

    public void wobble(DecoratedPotBlockEntity.WobbleType wobbleType) {
        if (this.world != null && !this.world.isClient()) {
            this.world.addSyncedBlockEvent(this.getPos(), this.getCachedState().getBlock(), 1, wobbleType.ordinal());
        }
    }

    public boolean onSyncedBlockEvent(int type, int data) {
        if (this.world != null && type == 1 && data >= 0 && data < DecoratedPotBlockEntity.WobbleType.values().length) {
            this.lastWobbleTime = this.world.getTime();
            this.lastWobbleType = DecoratedPotBlockEntity.WobbleType.values()[data];
            return true;
        } else {
            return super.onSyncedBlockEvent(type, data);
        }
    }
}