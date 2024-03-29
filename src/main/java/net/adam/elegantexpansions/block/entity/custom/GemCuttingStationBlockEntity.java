package net.adam.elegantexpansions.block.entity.custom;

import net.adam.elegantexpansions.block.entity.ModBlockEntities;
import net.adam.elegantexpansions.item.ModItems;
import net.adam.elegantexpansions.recipe.GemCuttingStationRecipe;
import net.adam.elegantexpansions.screen.GemCuttingStationMenu;
import net.adam.elegantexpansions.sound.ModSounds;
import net.adam.elegantexpansions.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.function.Predicate;


public class GemCuttingStationBlockEntity extends BlockEntity implements MenuProvider {


    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }

            @Override
            public boolean isItemValid(int slot, @NotNull ItemStack stack) {
                return switch (slot) {
                    case 0 -> true;
                    case 1 -> stack.is(ModTags.Items.GEMS);
                    case 2 -> stack.getItem() == ModItems.GEM_CUTTERS.get();
                    case 3 -> false;
                    default -> super.isItemValid(slot, stack);
                };
            }

    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 200;





    public GemCuttingStationBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.GEM_CUTTING_STATION_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        this.data = new ContainerData() {
            public int get(int index) {
                switch (index) {
                    case 0:
                        return GemCuttingStationBlockEntity.this.progress;
                    case 1:
                        return GemCuttingStationBlockEntity.this.maxProgress;
                    default:
                        return 0;
                }
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        GemCuttingStationBlockEntity.this.progress = value;
                        break;
                    case 1:
                        GemCuttingStationBlockEntity.this.maxProgress = value;
                        break;
                }
            }

            public int getCount() {
                return 2;
            }
        };
    }


    @Override
    public Component getDisplayName() {
        return Component.literal("Gem Cutting Station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new GemCuttingStationMenu(pContainerId, pInventory, this, this.data);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("gem_cutting_station.progress", progress);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("gem_cutting_station.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, GemCuttingStationBlockEntity pBlockEntity) {
        pBlockEntity.canPlay(pLevel);
        if (hasRecipe(pBlockEntity)) {
            pBlockEntity.progress++;
            setChanged(pLevel, pPos, pState);



            if (pBlockEntity.progress > pBlockEntity.maxProgress) {
                craftItem(pBlockEntity);
            }
        } else {
            pBlockEntity.resetProgress();
            setChanged(pLevel, pPos, pState);

        }
    }

    public void canPlay(Level pLevel) {
        if (progress > 0) {
            pLevel.playLocalSound(getBlockPos(),ModSounds.GEM_CUTTING.get(), SoundSource.AMBIENT,0.2f, 0.2f, false);
        }
    }


    private static boolean hasRecipe(GemCuttingStationBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<GemCuttingStationRecipe> match = level.getRecipeManager()
                .getRecipeFor(GemCuttingStationRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem())
                && hasWaterInWaterSlot(entity) && hasToolsInToolSlot(entity);
    }

    private static boolean hasWaterInWaterSlot(GemCuttingStationBlockEntity entity) {
        return PotionUtils.getPotion(entity.itemHandler.getStackInSlot(0)) == Potions.WATER;
    }

    private static boolean hasToolsInToolSlot(GemCuttingStationBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(2).getItem() == ModItems.GEM_CUTTERS.get();
    }

    private static void craftItem(GemCuttingStationBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<GemCuttingStationRecipe> match = level.getRecipeManager()
                .getRecipeFor(GemCuttingStationRecipe.Type.INSTANCE, inventory, level);

        if (match.isPresent()) {
            entity.itemHandler.extractItem(0, 1, false);
            entity.itemHandler.extractItem(1, 1, false);
            if (entity.itemHandler.getStackInSlot(2).hurt(1, RandomSource.create(), null)) {
                entity.itemHandler.extractItem(2, 1, false);
            }

            entity.itemHandler.setStackInSlot(3, new ItemStack(match.get().getResultItem().getItem(),
                    entity.itemHandler.getStackInSlot(3).getCount() + 1));

            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }



    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(3).getItem() == output.getItem() || inventory.getItem(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(3).getMaxStackSize() > inventory.getItem(3).getCount();
    }



    //RENDERER//


    public ItemStack getRenderStack() {
        ItemStack stack = itemHandler.getStackInSlot(3);

        if (stack.isEmpty()) {
            stack = itemHandler.getStackInSlot(1);
        }
         return stack;
    }


    public boolean hasGemCuttingTools() {
        return this.itemHandler.getStackInSlot(2).getItem() == ModItems.GEM_CUTTERS.get();

    }
}





