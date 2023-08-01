package net.adam.elegantexpansions.datagen;

import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
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
                        ModBlocks.NETHER_CITRINE_ORE.get());

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

                  .add(ModBlocks.BANANA_LOG.get())
                .add(ModBlocks.BANANA_WOOD.get())
                .add(ModBlocks.STRIPPED_BANANA_LOG.get())
                .add(ModBlocks.STRIPPED_BANANA_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.ASH_PLANKS.get())
                .add(ModBlocks.WILLOW_PLANKS.get())
                .add(ModBlocks.MAGIC_PLANKS.get())
                .add(ModBlocks.BANANA_PLANKS.get());

    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}