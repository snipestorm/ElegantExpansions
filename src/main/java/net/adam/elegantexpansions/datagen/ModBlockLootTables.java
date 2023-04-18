package net.adam.elegantexpansions.datagen;

import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }
    @Override
    protected void generate() {
        dropSelf(ModBlocks.RUBY_BLOCK.get());

        add(ModBlocks.RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get()));
        add(ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModItems.RUBY.get()));

        this.dropSelf(ModBlocks.MAGIC_LOG.get());
        this.dropSelf(ModBlocks.MAGIC_WOOD.get());
        this.dropSelf(ModBlocks.MAGIC_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_MAGIC_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_MAGIC_LOG.get());
        this.dropSelf(ModBlocks.MAGIC_SAPLING.get());

        this.add(ModBlocks.MAGIC_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.MAGIC_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ModBlocks.WILLOW_LOG.get());
        this.dropSelf(ModBlocks.WILLOW_WOOD.get());
        this.dropSelf(ModBlocks.WILLOW_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_WILLOW_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_WILLOW_LOG.get());
        this.dropSelf(ModBlocks.WILLOW_SAPLING.get());

        this.add(ModBlocks.WILLOW_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.WILLOW_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));

    this.dropSelf(ModBlocks.MAPLE_SAPLING.get());

        this.add(ModBlocks.MAPLE_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.MAPLE_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ModBlocks.ASH_LOG.get());
        this.dropSelf(ModBlocks.ASH_WOOD.get());
        this.dropSelf(ModBlocks.ASH_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_ASH_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_ASH_LOG.get());
        this.dropSelf(ModBlocks.ASH_SAPLING.get());

        this.add(ModBlocks.ASH_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.ASH_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ModBlocks.CHERRY_LOG.get());
        this.dropSelf(ModBlocks.CHERRY_WOOD.get());
        this.dropSelf(ModBlocks.CHERRY_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_CHERRY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_CHERRY_LOG.get());
        this.dropSelf(ModBlocks.CHERRY_SAPLING.get());

        this.add(ModBlocks.CHERRY_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.CHERRY_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));
     

        this.dropSelf(ModBlocks.BANANA_LOG.get());
        this.dropSelf(ModBlocks.BANANA_WOOD.get());
        this.dropSelf(ModBlocks.BANANA_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_BANANA_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_BANANA_LOG.get());
        this.dropSelf(ModBlocks.BANANA_SAPLING.get());

        this.add(ModBlocks.BANANA_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.BANANA_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
