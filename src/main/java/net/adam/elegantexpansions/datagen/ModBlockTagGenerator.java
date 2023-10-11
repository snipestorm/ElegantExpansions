package net.adam.elegantexpansions.datagen;

import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ElegantExpansions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
             this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RUBY_BLOCK.get(),
                        ModBlocks.RUBY_ORE.get(),
                        ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                        ModBlocks.SAPPHIRE_BLOCK.get(),
                        ModBlocks.SAPPHIRE_ORE.get(),
                        ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                        ModBlocks.TANZANITE_BLOCK.get(),
                        ModBlocks.ENDSTONE_TANZANITE_ORE.get(),
                        ModBlocks.CITRINE_BLOCK.get(),
                        ModBlocks.NETHER_CITRINE_ORE.get(),
                        ModBlocks.GEM_CUTTING_STATION.get(),
                        ModBlocks.GEM_INFUSING_STATION.get(),
                        ModBlocks.SHARD_CREATION_STATION.get(),

                        ModBlocks.EYE_OF_HORUS_GOLD.get(),
                        ModBlocks.GLPYH_OF_ANUBIS_GOLD.get(),
                        ModBlocks.ANKH_GOLD.get(),
                        ModBlocks.GOLD_CHAIN.get(),
                        ModBlocks.WHITE_SANDSTONE.get(),
                        ModBlocks.SMOOTH_WHITE_SANDSTONE.get(),
                        ModBlocks.LANTERN_OF_ANUBIS.get(),
                        ModBlocks.CHISELED_WHITE_SANDSTONE.get(),
                        ModBlocks.SCULK_STONE.get(),
                        ModBlocks.COBBLED_SCULK_STONE.get(),
                        ModBlocks.SCULK_STONE_BRICKS.get(),
                        ModBlocks.POLISHED_SCULK_STONE.get(),
                        ModBlocks.CHISELED_SCULK_STONE.get(),
                        ModBlocks.SMOOTH_SCULK_STONE.get(),
                        ModBlocks.DISPLAY_CASE.get(),
                        ModBlocks.MYSTERIOUS_CUBE.get(),
                        ModBlocks.SCULK_STONE_STAIRS.get(),
                        ModBlocks.SCULK_STONE_SLAB.get(),
                        ModBlocks.SCULK_STONE_WALL.get(),
                        ModBlocks.COBBLED_SCULK_STONE_SLAB.get(),
                        ModBlocks.SCULK_STONE_BRICK_STAIRS.get(),
                        ModBlocks.COBBLED_SCULK_STONE_WALL.get(),
                        ModBlocks.POLISHED_SCULK_STONE_STAIRS.get(),
                        ModBlocks.POLISHED_SCULK_STONE_SLAB.get(),
                        ModBlocks.POLISHED_SCULK_STONE_WALL.get(),
                        ModBlocks.SCULK_STONE_BRICK_STAIRS.get(),
                        ModBlocks.SCULK_STONE_BRICK_SLAB.get(),
                        ModBlocks.SCULK_STONE_BRICK_WALL.get(),
                        ModBlocks.SMOOTH_SCULK_STONE_STAIRS.get(),
                        ModBlocks.SMOOTH_SCULK_STONE_SLAB.get());




        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RUBY_BLOCK.get(),
                        ModBlocks.RUBY_ORE.get(),
                        ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                        ModBlocks.SAPPHIRE_BLOCK.get(),
                        ModBlocks.SAPPHIRE_ORE.get(),
                        ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());



        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)

                .add(ModBlocks.TANZANITE_BLOCK.get(),
                        ModBlocks.ENDSTONE_TANZANITE_ORE.get(),
                        ModBlocks.CITRINE_BLOCK.get(),
                        ModBlocks.NETHER_CITRINE_ORE.get());

        this.tag(ModTags.Blocks.ANUBIS_BASE_BLOCKS)

                .add(Blocks.REINFORCED_DEEPSLATE);

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTags(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTags(BlockTags.MINEABLE_WITH_AXE)
                .addTags(BlockTags.MINEABLE_WITH_SHOVEL);



        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.ASH_LOG.get())
                .add(ModBlocks.ASH_WOOD.get())
                .add(ModBlocks.STRIPPED_ASH_LOG.get())
                .add(ModBlocks.STRIPPED_ASH_WOOD.get())

                .add(ModBlocks.WILLOW_LOG.get())
                .add(ModBlocks.WILLOW_WOOD.get())
                .add(ModBlocks.STRIPPED_WILLOW_LOG.get())
                .add(ModBlocks.STRIPPED_WILLOW_WOOD.get())

             .add(ModBlocks.MAGIC_LOG.get())
                .add(ModBlocks.MAGIC_WOOD.get())
                .add(ModBlocks.STRIPPED_MAGIC_LOG.get())
                .add(ModBlocks.STRIPPED_MAGIC_WOOD.get())

                .add(ModBlocks.ECHO_LOG.get())
                .add(ModBlocks.ECHO_WOOD.get())
                .add(ModBlocks.STRIPPED_ECHO_LOG.get())
                .add(ModBlocks.STRIPPED_ECHO_WOOD.get())

                  .add(ModBlocks.BANANA_LOG.get())
                .add(ModBlocks.BANANA_WOOD.get())
                .add(ModBlocks.STRIPPED_BANANA_LOG.get())
                .add(ModBlocks.STRIPPED_BANANA_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.ASH_PLANKS.get())
                .add(ModBlocks.WILLOW_PLANKS.get())
                .add(ModBlocks.ECHO_PLANKS.get())
                .add(ModBlocks.MAGIC_PLANKS.get())
                .add(ModBlocks.BANANA_PLANKS.get());


        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.SCULK_GLEAM.get());


        this.tag(BlockTags.FENCES)
                .add(ModBlocks.MAGIC_FENCE.get())
                .add(ModBlocks.ASH_FENCE.get())
                .add(ModBlocks.WILLOW_FENCE.get())
                .add(ModBlocks.PALM_FENCE.get())
                .add(ModBlocks.ECHO_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.MAGIC_FENCE_GATE.get())
                .add(ModBlocks.ASH_FENCE_GATE.get())
                .add(ModBlocks.PALM_FENCE_GATE.get())
                .add(ModBlocks.WILLOW_FENCE_GATE.get())
                .add(ModBlocks.ECHO_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.MAGIC_WALL.get())
                .add(ModBlocks.ASH_WALL.get())
                .add(ModBlocks.WILLOW_WALL.get())
                .add(ModBlocks.PALM_WALL.get())
                .add(ModBlocks.ECHO_WALL.get())
                .add(ModBlocks.SCULK_STONE_WALL.get())
                .add(ModBlocks.COBBLED_SCULK_STONE_WALL.get())
                .add(ModBlocks.POLISHED_SCULK_STONE_WALL.get())
                .add(ModBlocks.SCULK_STONE_BRICK_WALL.get());

        this.tag(BlockTags.SAND)
                .add(ModBlocks.WHITE_SAND.get());

    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}