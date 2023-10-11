package net.adam.elegantexpansions.block.entity.custom;

import net.adam.elegantexpansions.block.custom.GemInfusingStationBlock;
import net.adam.elegantexpansions.block.entity.ModBlockEntities;
import net.adam.elegantexpansions.fluid.ModFluids;
import net.adam.elegantexpansions.item.ModItems;
import net.adam.elegantexpansions.recipe.GemInfusingRecipe;
import net.adam.elegantexpansions.screen.GemInfusingStationMenu;
import net.adam.elegantexpansions.screen.ShardCreationStationMenu;
import net.adam.elegantexpansions.util.InventoryDirectionEntry;
import net.adam.elegantexpansions.util.InventoryDirectionWrapper;
import net.adam.elegantexpansions.util.WrappedHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class ShardCreationStationBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(10) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0 -> stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent();
                case 1 -> stack.getItem() == ModItems.INFUSED_RUBY.get();
                case 2 -> stack.getItem() == ModItems.INFUSED_SAPPHIRE.get();
                case 3 -> stack.getItem() == ModItems.INFUSED_CITRINE.get();
                case 4 -> stack.getItem() == ModItems.INFUSED_DIAMOND.get();
                case 5 -> false;
                case 6 -> stack.getItem() == ModItems.INFUSED_AMETHYST.get();
                case 7 -> stack.getItem() == ModItems.INFUSED_ONYX.get();
                case 8 -> stack.getItem() == ModItems.INFUSED_TANZANITE.get();
                case 9 -> stack.getItem() == ModItems.INFUSED_EMERALD.get();
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private static final int FLUID_INPUT_SLOT = 0;
    private static final int  RUBY_SLOT = 1;
    private static final int  SAPPHIRE_SLOT = 2;
    private static final int  CITRINE_SLOT = 3;
    private static final int  DIAMOND_SLOT = 4;
    private static final int  OUTPUT_SLOT = 5;
    private static final int  AMETHYST_SLOT = 6;
    private static final int  ONYX_SLOT = 7;
    private static final int  TANZANITE_SLOT = 8;
    private static final int  EMERALD_SLOT = 9;



    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    private LazyOptional<IFluidHandler> lazyFluidHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 3000;

    private final FluidTank FLUID_TANK = createFluidTank();

    private FluidTank createFluidTank() {
        return new FluidTank(10000) {
            @Override
            protected void onContentsChanged() {
                setChanged();
                if(!level.isClientSide()) {
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                }
            }

            @Override
            public boolean isFluidValid(FluidStack stack) {
                return stack.getFluid() == Fluids.LAVA;
            }
        };
    }


    public ItemStack getRender() {
        ItemStack stack = itemHandler.getStackInSlot(RUBY_SLOT);
        return stack;
    }

    public ShardCreationStationBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.SHARD_CREATION_STATION_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> ShardCreationStationBlockEntity.this.progress;
                    case 1 -> ShardCreationStationBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> ShardCreationStationBlockEntity.this.progress = pValue;
                    case 1 -> ShardCreationStationBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }



    public FluidStack getFluid() {
        return FLUID_TANK.getFluid();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }


    @Override
    public Component getDisplayName() {
        return Component.literal("Shard Creation Station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new ShardCreationStationMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {


        if(cap == ForgeCapabilities.FLUID_HANDLER) {
            return lazyFluidHandler.cast();
        }

        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            if(side == null) {
                return lazyItemHandler.cast();
            }

            }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
        lazyFluidHandler = LazyOptional.of(() -> FLUID_TANK);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyFluidHandler.invalidate();

    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("shard_creation_station.progress", progress);
        pTag = FLUID_TANK.writeToNBT(pTag);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("shard_creation_station.progress");
        FLUID_TANK.readFromNBT(pTag);

    }

    public void tick(Level level, BlockPos pPos, BlockState pState) {

        fillUpOnFluid();

        if (isOutputSlotEmptyOrReceivable() && hasRecipe()) {
            increaseCraftingProcess();
            extractFluid();

            setChanged(level, pPos, pState);

            if (hasProgressFinished()) {
                craftItem();

                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void extractFluid() {
        this.FLUID_TANK.drain(1, IFluidHandler.FluidAction.EXECUTE);

    }

    private void fillUpOnFluid() {
        if(hasFluidSourceInSlot(FLUID_INPUT_SLOT)) {
            transferItemFluidToTank(FLUID_INPUT_SLOT);
        }
    }

    private void transferItemFluidToTank(int fluidInputSlot) {
        this.itemHandler.getStackInSlot(fluidInputSlot).getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(iFluidHandlerItem -> {
            int drainAmount = Math.min(this.FLUID_TANK.getSpace(), 10000);

            FluidStack stack = iFluidHandlerItem.drain(drainAmount, IFluidHandler.FluidAction.SIMULATE);
            if(stack.getFluid() == Fluids.LAVA) {
                stack = iFluidHandlerItem.drain(drainAmount, IFluidHandler.FluidAction.EXECUTE);
                fillTankWithFluid(stack, iFluidHandlerItem.getContainer());
            }
        });
    }

    private void fillTankWithFluid(FluidStack stack, ItemStack container) {
        this.FLUID_TANK.fill(new FluidStack(stack.getFluid(), stack.getAmount()), IFluidHandler.FluidAction.EXECUTE);

        this.itemHandler.extractItem(FLUID_INPUT_SLOT, 1, false);
        this.itemHandler.insertItem(FLUID_INPUT_SLOT, container, false);
    }

    private boolean hasFluidSourceInSlot(int fluidInputSlot) {
        return this.itemHandler.getStackInSlot(fluidInputSlot).getCount() > 0 &&
                this.itemHandler.getStackInSlot(fluidInputSlot).getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent();
    }




    private void craftItem() {

        this.itemHandler.extractItem(RUBY_SLOT, 1, false);
        this.itemHandler.extractItem(SAPPHIRE_SLOT, 1, false);
        this.itemHandler.extractItem(CITRINE_SLOT, 1, false);
        this.itemHandler.extractItem(DIAMOND_SLOT, 1, false);
        this.itemHandler.extractItem(AMETHYST_SLOT, 1, false);
        this.itemHandler.extractItem(ONYX_SLOT, 1, false);
        this.itemHandler.extractItem(TANZANITE_SLOT, 1, false);
        this.itemHandler.extractItem(EMERALD_SLOT, 1, false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(ModItems.ALEXANDRITE_SHARD.get(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + 1));
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private boolean hasProgressFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProcess() {
        this.progress++;
    }

    private boolean hasRecipe() {
        return canInsertAmountIntoOutputSlot(1)
                && canInsertItemIntoOutputSlot(ModItems.ALEXANDRITE_SHARD.get()) && hasAllInputs() && hasEnoughFluidToCraft();
    }

    private boolean hasAllInputs() {
        return this.itemHandler.getStackInSlot(RUBY_SLOT).getItem() == ModItems.INFUSED_RUBY.get()
                && this.itemHandler.getStackInSlot(SAPPHIRE_SLOT).getItem() == ModItems.INFUSED_SAPPHIRE.get()
                && this.itemHandler.getStackInSlot(CITRINE_SLOT).getItem() == ModItems.INFUSED_CITRINE.get()
                && this.itemHandler.getStackInSlot(DIAMOND_SLOT).getItem() == ModItems.INFUSED_DIAMOND.get()
                && this.itemHandler.getStackInSlot(AMETHYST_SLOT).getItem() == ModItems.INFUSED_AMETHYST.get()
                && this.itemHandler.getStackInSlot(ONYX_SLOT).getItem() == ModItems.INFUSED_ONYX.get()
                && this.itemHandler.getStackInSlot(TANZANITE_SLOT).getItem() == ModItems.INFUSED_TANZANITE.get()
                && this.itemHandler.getStackInSlot(EMERALD_SLOT).getItem() == ModItems.INFUSED_EMERALD.get();
    }

    private boolean hasEnoughFluidToCraft() {
        return this.FLUID_TANK.getFluidAmount() >= 1;
    }



    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize() >=
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count;
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ||
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }


    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
    }

    public boolean hasSapphire() {
        return this.itemHandler.getStackInSlot(SAPPHIRE_SLOT).getItem() == ModItems.INFUSED_SAPPHIRE.get();
    }
    public boolean hasCitrine() {
        return this.itemHandler.getStackInSlot(CITRINE_SLOT).getItem() == ModItems.INFUSED_CITRINE.get();
    }
    public boolean hasDiamond() {
        return this.itemHandler.getStackInSlot(DIAMOND_SLOT).getItem() == ModItems.INFUSED_DIAMOND.get();
    }
    public boolean hasAmethyst() {
        return this.itemHandler.getStackInSlot(AMETHYST_SLOT).getItem() == ModItems.INFUSED_AMETHYST.get();
    }
    public boolean hasOnyx() {
        return this.itemHandler.getStackInSlot(ONYX_SLOT).getItem() == ModItems.INFUSED_ONYX.get();
    }
    public boolean hasTanzanite() {
        return this.itemHandler.getStackInSlot(TANZANITE_SLOT).getItem() == ModItems.INFUSED_TANZANITE.get();
    }
    public boolean hasEmerald() {
        return this.itemHandler.getStackInSlot(EMERALD_SLOT).getItem() == ModItems.INFUSED_EMERALD.get();
    }
    public boolean hasShard() {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getItem() == ModItems.ALEXANDRITE_SHARD.get();
    }
}




