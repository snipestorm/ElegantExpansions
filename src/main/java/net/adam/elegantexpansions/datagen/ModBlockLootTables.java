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

        dropSelf(ModBlocks.WHITE_SANDSTONE.get());
        dropSelf(ModBlocks.SMOOTH_WHITE_SANDSTONE.get());
        dropSelf(ModBlocks.WHITE_SAND.get());
        dropSelf(ModBlocks.CHISELED_WHITE_SANDSTONE.get());
        dropSelf(ModBlocks.LANTERN_OF_ANUBIS.get());
        dropSelf(ModBlocks.EYE_OF_HORUS_GOLD.get());
        dropSelf(ModBlocks.GLPYH_OF_ANUBIS_GOLD.get());
        dropSelf(ModBlocks.ANKH_GOLD.get());
        dropSelf(ModBlocks.GOLD_CHAIN.get());

        dropSelf(ModBlocks.MYSTICSHROOM.get());
        add(ModBlocks.POTTED_MYSTICSHROOM.get(),
                createPotFlowerItemTable(ModBlocks.POTTED_MYSTICSHROOM.get()));

        dropSelf(ModBlocks.MYSTIC_GLOWFLOWER.get());

        add(ModBlocks.POTTED_MYSTIC_GLOWFLOWER.get(),
                createPotFlowerItemTable(ModBlocks.POTTED_MYSTIC_GLOWFLOWER.get()));

        dropSelf(ModBlocks.ICY_IRIS.get());

        this.dropSelf(ModBlocks.MAGIC_STAIRS.get());
        this.dropSelf(ModBlocks.MAGIC_BUTTON.get());
        this.dropSelf(ModBlocks.MAGIC_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.MAGIC_TRAPDOOR.get());
        this.dropSelf(ModBlocks.MAGIC_FENCE.get());
        this.dropSelf(ModBlocks.MAGIC_FENCE_GATE.get());
        this.dropSelf(ModBlocks.MAGIC_WALL.get());

        this.add(ModBlocks.MAGIC_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MAGIC_SLAB.get()));
        this.add(ModBlocks.MAGIC_DOOR.get(),
                block -> createDoorTable(ModBlocks.MAGIC_DOOR.get()));

        this.dropSelf(ModBlocks.ASH_STAIRS.get());
        this.dropSelf(ModBlocks.ASH_BUTTON.get());
        this.dropSelf(ModBlocks.ASH_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ASH_TRAPDOOR.get());
        this.dropSelf(ModBlocks.ASH_FENCE.get());
        this.dropSelf(ModBlocks.ASH_FENCE_GATE.get());
        this.dropSelf(ModBlocks.ASH_WALL.get());

        this.add(ModBlocks.ASH_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ASH_SLAB.get()));
        this.add(ModBlocks.ASH_DOOR.get(),
                block -> createDoorTable(ModBlocks.ASH_DOOR.get()));

        this.dropSelf(ModBlocks.WILLOW_STAIRS.get());
        this.dropSelf(ModBlocks.WILLOW_BUTTON.get());
        this.dropSelf(ModBlocks.WILLOW_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.WILLOW_TRAPDOOR.get());
        this.dropSelf(ModBlocks.WILLOW_FENCE.get());
        this.dropSelf(ModBlocks.WILLOW_FENCE_GATE.get());
        this.dropSelf(ModBlocks.WILLOW_WALL.get());

        this.add(ModBlocks.WILLOW_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WILLOW_SLAB.get()));
        this.add(ModBlocks.WILLOW_DOOR.get(),
                block -> createDoorTable(ModBlocks.WILLOW_DOOR.get()));


        this.dropSelf(ModBlocks.PALM_STAIRS.get());
        this.dropSelf(ModBlocks.PALM_BUTTON.get());
        this.dropSelf(ModBlocks.PALM_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.PALM_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PALM_FENCE.get());
        this.dropSelf(ModBlocks.PALM_FENCE_GATE.get());
        this.dropSelf(ModBlocks.PALM_WALL.get());

        this.add(ModBlocks.PALM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PALM_SLAB.get()));
        this.add(ModBlocks.PALM_DOOR.get(),
                block -> createDoorTable(ModBlocks.PALM_DOOR.get()));



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
