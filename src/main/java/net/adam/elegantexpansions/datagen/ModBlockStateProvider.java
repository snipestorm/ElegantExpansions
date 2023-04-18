package net.adam.elegantexpansions.datagen;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

     public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ElegantExpansions.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
         blockWithItem(ModBlocks.RUBY_BLOCK);
         blockWithItem(ModBlocks.RUBY_ORE);
         blockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE);

         logBlock(((RotatedPillarBlock) ModBlocks.MAGIC_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.MAGIC_WOOD.get(), blockTexture(ModBlocks.MAGIC_LOG.get()), blockTexture(ModBlocks.MAGIC_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_MAGIC_LOG.get(), new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_magic_log"),
                new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_magic_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_MAGIC_WOOD.get(), new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_magic_log"),
                new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_magic_log"));

        blockWithItem(ModBlocks.MAGIC_PLANKS);
        blockWithItem(ModBlocks.MAGIC_LEAVES);
        saplingBlock(ModBlocks.MAGIC_SAPLING);

        simpleBlockItem(ModBlocks.MAGIC_LOG.get(), models().withExistingParent("elegantexpansions:magic_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.MAGIC_WOOD.get(), models().withExistingParent("elegantexpansions:magic_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_MAGIC_LOG.get(), models().withExistingParent("elegantexpansions:stripped_magic_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_MAGIC_WOOD.get(), models().withExistingParent("elegantexpansions:stripped_magic_wood", "minecraft:block/cube_column"));

        logBlock(((RotatedPillarBlock) ModBlocks.WILLOW_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.WILLOW_WOOD.get(), blockTexture(ModBlocks.WILLOW_LOG.get()), blockTexture(ModBlocks.WILLOW_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_WILLOW_LOG.get(), new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_willow_log"),
                new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_willow_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_WILLOW_WOOD.get(), new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_willow_log"),
                new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_willow_log"));

        blockWithItem(ModBlocks.WILLOW_PLANKS);
        blockWithItem(ModBlocks.WILLOW_LEAVES);
        saplingBlock(ModBlocks.WILLOW_SAPLING);

        simpleBlockItem(ModBlocks.WILLOW_LOG.get(), models().withExistingParent("elegantexpansions:willow_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.WILLOW_WOOD.get(), models().withExistingParent("elegantexpansions:willow_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_WILLOW_LOG.get(), models().withExistingParent("elegantexpansions:stripped_willow_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_WILLOW_WOOD.get(), models().withExistingParent("elegantexpansions:stripped_willow_wood", "minecraft:block/cube_column"));


        blockWithItem(ModBlocks.MAPLE_LEAVES);
        saplingBlock(ModBlocks.MAPLE_SAPLING);

        logBlock(((RotatedPillarBlock) ModBlocks.ASH_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.ASH_WOOD.get(), blockTexture(ModBlocks.ASH_LOG.get()), blockTexture(ModBlocks.ASH_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_ASH_LOG.get(), new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_ash_log"),
                new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_ash_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_ASH_WOOD.get(), new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_ash_log"),
                new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_ash_log"));

        blockWithItem(ModBlocks.ASH_PLANKS);
        blockWithItem(ModBlocks.ASH_LEAVES);
        saplingBlock(ModBlocks.ASH_SAPLING);

        simpleBlockItem(ModBlocks.ASH_LOG.get(), models().withExistingParent("elegantexpansions:ash_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.ASH_WOOD.get(), models().withExistingParent("elegantexpansions:ash_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_ASH_LOG.get(), models().withExistingParent("elegantexpansions:stripped_ash_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_ASH_WOOD.get(), models().withExistingParent("elegantexpansions:stripped_ash_wood", "minecraft:block/cube_column"));

        logBlock(((RotatedPillarBlock) ModBlocks.CHERRY_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.CHERRY_WOOD.get(), blockTexture(ModBlocks.CHERRY_LOG.get()), blockTexture(ModBlocks.CHERRY_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_CHERRY_LOG.get(), new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_cherry_log"),
                new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_cherry_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_CHERRY_WOOD.get(), new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_cherry_log"),
                new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_cherry_log"));

        blockWithItem(ModBlocks.CHERRY_PLANKS);
        blockWithItem(ModBlocks.CHERRY_LEAVES);
        saplingBlock(ModBlocks.CHERRY_SAPLING);

        simpleBlockItem(ModBlocks.CHERRY_LOG.get(), models().withExistingParent("elegantexpansions:cherry_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.CHERRY_WOOD.get(), models().withExistingParent("elegantexpansions:cherry_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_CHERRY_LOG.get(), models().withExistingParent("elegantexpansions:stripped_cherry_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_CHERRY_WOOD.get(), models().withExistingParent("elegantexpansions:stripped_cherry_wood", "minecraft:block/cube_column"));
      

        logBlock(((RotatedPillarBlock) ModBlocks.BANANA_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.BANANA_WOOD.get(), blockTexture(ModBlocks.BANANA_LOG.get()), blockTexture(ModBlocks.BANANA_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_BANANA_LOG.get(), new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_banana_log"),
                new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_banana_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_BANANA_WOOD.get(), new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_banana_log"),
                new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_banana_log"));

        blockWithItem(ModBlocks.BANANA_PLANKS);
        blockWithItem(ModBlocks.BANANA_LEAVES);
        saplingBlock(ModBlocks.BANANA_SAPLING);

        simpleBlockItem(ModBlocks.BANANA_LOG.get(), models().withExistingParent("elegantexpansions:banana_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.BANANA_WOOD.get(), models().withExistingParent("elegantexpansions:banana_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_BANANA_LOG.get(), models().withExistingParent("elegantexpansions:stripped_banana_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_BANANA_WOOD.get(), models().withExistingParent("elegantexpansions:stripped_banana_wood", "minecraft:block/cube_column"));
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
         simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
