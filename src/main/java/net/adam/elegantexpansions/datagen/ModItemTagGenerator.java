package net.adam.elegantexpansions.datagen;
import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.item.ModItems;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.util.ModTags;
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
        this.tag(ItemTags.TRIMMABLE_ARMOR)
        .add(ModItems.ALEXANDRITE_HELMET.get())
        .add(ModItems.ALEXANDRITE_CHESTPLATE.get())
        .add(ModItems.ALEXANDRITE_LEGGINGS.get())
        .add(ModItems.ALEXANDRITE_BOOTS.get())

        .add(ModItems.WARDEN_HELMET.get())
        .add(ModItems.WARDEN_CHESTPLATE.get())
        .add(ModItems.WARDEN_LEGGINGS.get())
        .add(ModItems.WARDEN_BOOTS.get())

        .add(ModItems.INFUSED_DIAMOND_HELMET.get())
        .add(ModItems.INFUSED_DIAMOND_CHESTPLATE.get())
        .add(ModItems.INFUSED_DIAMOND_LEGGINGS.get())
        .add(ModItems.INFUSED_DIAMOND_BOOTS.get())

        .add(ModItems.INFUSED_RUBY_HELMET.get())
        .add(ModItems.INFUSED_RUBY_CHESTPLATE.get())
        .add(ModItems.INFUSED_RUBY_LEGGINGS.get())
        .add(ModItems.INFUSED_RUBY_BOOTS.get())

        .add(ModItems.INFUSED_SAPPHIRE_HELMET.get())
        .add(ModItems.INFUSED_SAPPHIRE_CHESTPLATE.get())
        .add(ModItems.INFUSED_SAPPHIRE_LEGGINGS.get())
        .add(ModItems.INFUSED_SAPPHIRE_BOOTS.get())

        .add(ModItems.INFUSED_EMERALD_HELMET.get())
        .add(ModItems.INFUSED_EMERALD_CHESTPLATE.get())
        .add(ModItems.INFUSED_EMERALD_LEGGINGS.get())
        .add(ModItems.INFUSED_EMERALD_BOOTS.get())

        .add(ModItems.INFUSED_AMETHYST_HELMET.get())
        .add(ModItems.INFUSED_AMETHYST_CHESTPLATE.get())
        .add(ModItems.INFUSED_AMETHYST_LEGGINGS.get())
        .add(ModItems.INFUSED_AMETHYST_BOOTS.get())

        .add(ModItems.INFUSED_CITRINE_HELMET.get())
        .add(ModItems.INFUSED_CITRINE_CHESTPLATE.get())
        .add(ModItems.INFUSED_CITRINE_LEGGINGS.get())
        .add(ModItems.INFUSED_CITRINE_BOOTS.get())

        .add(ModItems.INFUSED_TANZANITE_HELMET.get())
        .add(ModItems.INFUSED_TANZANITE_CHESTPLATE.get())
        .add(ModItems.INFUSED_TANZANITE_LEGGINGS.get())
        .add(ModItems.INFUSED_TANZANITE_BOOTS.get())

        .add(ModItems.INFUSED_ONYX_HELMET.get())
        .add(ModItems.INFUSED_ONYX_CHESTPLATE.get())
        .add(ModItems.INFUSED_ONYX_LEGGINGS.get())
        .add(ModItems.INFUSED_ONYX_BOOTS.get());


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

                .add(ModBlocks.ECHO_LOG.get().asItem())
                .add(ModBlocks.ECHO_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_ECHO_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_ECHO_WOOD.get().asItem())


                .add(ModBlocks.BANANA_LOG.get().asItem())
                .add(ModBlocks.BANANA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_BANANA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_BANANA_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.ASH_PLANKS.get().asItem())
                .add(ModBlocks.WILLOW_PLANKS.get().asItem())
                .add(ModBlocks.ECHO_PLANKS.get().asItem())
                .add(ModBlocks.MAGIC_PLANKS.get().asItem())
                .add(ModBlocks.BANANA_PLANKS.get().asItem());


        this.tag(ModTags.Items.MAGIC_LOGS)
                .add(ModBlocks.MAGIC_LOG.get().asItem())
                .add(ModBlocks.MAGIC_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_MAGIC_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_MAGIC_WOOD.get().asItem());

        this.tag(ModTags.Items.ASH_LOGS)
                .add(ModBlocks.ASH_LOG.get().asItem())
                .add(ModBlocks.ASH_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_ASH_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_ASH_WOOD.get().asItem());

        this.tag(ModTags.Items.WILLOW_LOGS)
                .add(ModBlocks.WILLOW_LOG.get().asItem())
                .add(ModBlocks.WILLOW_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_WILLOW_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_WILLOW_WOOD.get().asItem());

        this.tag(ModTags.Items.ECHO_LOGS)
                .add(ModBlocks.ECHO_LOG.get().asItem())
                .add(ModBlocks.ECHO_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_ECHO_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_ECHO_WOOD.get().asItem());

        this.tag(ModTags.Items.PALM_LOGS)
                .add(ModBlocks.BANANA_LOG.get().asItem())
                .add(ModBlocks.BANANA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_BANANA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_BANANA_WOOD.get().asItem());

    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}