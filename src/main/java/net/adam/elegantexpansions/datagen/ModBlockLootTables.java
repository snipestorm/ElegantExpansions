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
        dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        dropSelf(ModBlocks.TANZANITE_BLOCK.get());
        dropSelf(ModBlocks.CITRINE_BLOCK.get());
        dropSelf(ModBlocks.ONYX_BLOCK.get());

        dropSelf(ModBlocks.GEM_CUTTING_STATION.get());
        dropSelf(ModBlocks.GEM_INFUSING_STATION.get());
        dropSelf(ModBlocks.SHARD_CREATION_STATION.get());


        add(ModBlocks.RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get()));
        add(ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModItems.RUBY.get()));

        add(ModBlocks.SAPPHIRE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));
        add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));

        add(ModBlocks.NETHER_CITRINE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHER_CITRINE_ORE.get(), ModItems.CITRINE.get()));

        add(ModBlocks.ENDSTONE_TANZANITE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.ENDSTONE_TANZANITE_ORE.get(), ModItems.TANZANITE.get()));


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
