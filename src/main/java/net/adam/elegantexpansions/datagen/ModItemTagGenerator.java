package net.adam.elegantexpansions.datagen;
import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.item.ModItems;
import net.adam.elegantexpansions.ElegantExpansions;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future,
                               CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, completableFuture, ElegantExpansions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Add Item Tags here
        this.tag(ItemTags.TRIMMABLE_ARMOR);


        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.SHREK_THEME_MUSIC_DISC.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.ASH_LOG.get().asItem())
                .add(ModBlocks.ASH_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_ASH_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_ASH_WOOD.get().asItem())

                .add(ModBlocks.WILLOW_LOG.get().asItem())
                .add(ModBlocks.WILLOW_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_WILLOW_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_WILLOW_WOOD.get().asItem())

                .add(ModBlocks.MAGIC_LOG.get().asItem())
                .add(ModBlocks.MAGIC_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_MAGIC_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_MAGIC_WOOD.get().asItem())

                .add(ModBlocks.BANANA_LOG.get().asItem())
                .add(ModBlocks.BANANA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_BANANA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_BANANA_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.ASH_PLANKS.get().asItem())
                .add(ModBlocks.WILLOW_PLANKS.get().asItem())
                .add(ModBlocks.MAGIC_PLANKS.get().asItem())
                .add(ModBlocks.BANANA_PLANKS.get().asItem());
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}