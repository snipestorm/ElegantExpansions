package net.adam.elegantexpansions.datagen;import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.block.custom.AnubisSummonBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

     public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ElegantExpansions.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // customLamp();
         blockWithItem(ModBlocks.RUBY_BLOCK);
         blockWithItem(ModBlocks.RUBY_ORE);
         blockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE);

        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

        blockWithItem(ModBlocks.TANZANITE_BLOCK);
        blockWithItem(ModBlocks.ENDSTONE_TANZANITE_ORE);

        blockWithItem(ModBlocks.CITRINE_BLOCK);
        blockWithItem(ModBlocks.NETHER_CITRINE_ORE);

        blockWithItem(ModBlocks.ONYX_BLOCK);

        blockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.ALEXANDRITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE);


        blockWithItem(ModBlocks.SCULK_GLEAM);
        blockWithItem(ModBlocks.SCULK_STONE);
        blockWithItem(ModBlocks.COBBLED_SCULK_STONE);
        blockWithItem(ModBlocks.SCULK_STONE_BRICKS);
        blockWithItem(ModBlocks.POLISHED_SCULK_STONE);
        blockWithItem(ModBlocks.CHISELED_SCULK_STONE);
        blockWithItem(ModBlocks.SMOOTH_SCULK_STONE);
        blockWithItem(ModBlocks.ECHO_SOIL);

        simpleBlockWithItem(ModBlocks.MYSTICSHROOM.get(),
                models().cross(blockTexture(ModBlocks.MYSTICSHROOM.get()).getPath(), blockTexture(ModBlocks.MYSTICSHROOM.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.MYSTIC_GLOWFLOWER.get(),
                models().cross(blockTexture(ModBlocks.MYSTIC_GLOWFLOWER.get()).getPath(), blockTexture(ModBlocks.MYSTIC_GLOWFLOWER.get())).renderType("cutout"));

        blockWithItem(ModBlocks.WHITE_SAND);
        blockWithItem(ModBlocks.EYE_OF_HORUS_GOLD);
        blockWithItem(ModBlocks.GLPYH_OF_ANUBIS_GOLD);
        blockWithItem(ModBlocks.ANKH_GOLD);




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

        logBlock(((RotatedPillarBlock) ModBlocks.ECHO_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.ECHO_WOOD.get(), blockTexture(ModBlocks.ECHO_LOG.get()), blockTexture(ModBlocks.ECHO_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_ECHO_LOG.get(), new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_echo_log"),
                new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_echo_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_ECHO_WOOD.get(), new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_echo_log"),
                new ResourceLocation(ElegantExpansions.MOD_ID, "block/stripped_echo_log"));

        blockWithItem(ModBlocks.ECHO_PLANKS);
        blockWithItem(ModBlocks.ECHO_LEAVES);
        saplingBlock(ModBlocks.ECHO_SAPLING);

        simpleBlockItem(ModBlocks.ECHO_LOG.get(), models().withExistingParent("elegantexpansions:echo_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.ECHO_WOOD.get(), models().withExistingParent("elegantexpansions:echo_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_ECHO_LOG.get(), models().withExistingParent("elegantexpansions:stripped_echo_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_ECHO_WOOD.get(), models().withExistingParent("elegantexpansions:stripped_echo_wood", "minecraft:block/cube_column"));

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

        stairsBlock(((StairBlock) ModBlocks.MAGIC_STAIRS.get()), blockTexture(ModBlocks.MAGIC_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.MAGIC_SLAB.get()), blockTexture(ModBlocks.MAGIC_PLANKS.get()), blockTexture(ModBlocks.MAGIC_PLANKS.get()));
        blockItem(ModBlocks.MAGIC_STAIRS);
        blockItem(ModBlocks.MAGIC_SLAB);
        blockItem(ModBlocks.MAGIC_PRESSURE_PLATE);
        blockItem(ModBlocks.MAGIC_FENCE_GATE);
        blockItem(ModBlocks.MAGIC_TRAPDOOR, "_bottom");
        buttonBlock(((ButtonBlock) ModBlocks.MAGIC_BUTTON.get()), blockTexture(ModBlocks.MAGIC_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.MAGIC_PRESSURE_PLATE.get()), blockTexture(ModBlocks.MAGIC_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.MAGIC_FENCE.get()), blockTexture(ModBlocks.MAGIC_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.MAGIC_FENCE_GATE.get()), blockTexture(ModBlocks.MAGIC_PLANKS.get()));
        wallBlock(((WallBlock) ModBlocks.MAGIC_WALL.get()), blockTexture(ModBlocks.MAGIC_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.MAGIC_DOOR.get()), modLoc("block/magic_door_bottom"), modLoc("block/magic_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.MAGIC_TRAPDOOR.get()), modLoc("block/magic_trapdoor"), true, "cutout");

        stairsBlock(((StairBlock) ModBlocks.ASH_STAIRS.get()), blockTexture(ModBlocks.ASH_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.ASH_SLAB.get()), blockTexture(ModBlocks.ASH_PLANKS.get()), blockTexture(ModBlocks.ASH_PLANKS.get()));
        blockItem(ModBlocks.ASH_STAIRS);
        blockItem(ModBlocks.ASH_SLAB);
        blockItem(ModBlocks.ASH_PRESSURE_PLATE);
        blockItem(ModBlocks.ASH_FENCE_GATE);
        blockItem(ModBlocks.ASH_TRAPDOOR, "_bottom");
        buttonBlock(((ButtonBlock) ModBlocks.ASH_BUTTON.get()), blockTexture(ModBlocks.ASH_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.ASH_PRESSURE_PLATE.get()), blockTexture(ModBlocks.ASH_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.ASH_FENCE.get()), blockTexture(ModBlocks.ASH_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.ASH_FENCE_GATE.get()), blockTexture(ModBlocks.ASH_PLANKS.get()));
        wallBlock(((WallBlock) ModBlocks.ASH_WALL.get()), blockTexture(ModBlocks.ASH_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.ASH_DOOR.get()), modLoc("block/ash_door_bottom"), modLoc("block/ash_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.ASH_TRAPDOOR.get()), modLoc("block/ash_trapdoor"), true, "cutout");

        stairsBlock(((StairBlock) ModBlocks.WILLOW_STAIRS.get()), blockTexture(ModBlocks.WILLOW_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.WILLOW_SLAB.get()), blockTexture(ModBlocks.WILLOW_PLANKS.get()), blockTexture(ModBlocks.WILLOW_PLANKS.get()));
        blockItem(ModBlocks.WILLOW_STAIRS);
        blockItem(ModBlocks.WILLOW_SLAB);
        blockItem(ModBlocks.WILLOW_PRESSURE_PLATE);
        blockItem(ModBlocks.WILLOW_FENCE_GATE);
        blockItem(ModBlocks.WILLOW_TRAPDOOR, "_bottom");
        buttonBlock(((ButtonBlock) ModBlocks.WILLOW_BUTTON.get()), blockTexture(ModBlocks.WILLOW_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.WILLOW_PRESSURE_PLATE.get()), blockTexture(ModBlocks.WILLOW_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.WILLOW_FENCE.get()), blockTexture(ModBlocks.WILLOW_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.WILLOW_FENCE_GATE.get()), blockTexture(ModBlocks.WILLOW_PLANKS.get()));
        wallBlock(((WallBlock) ModBlocks.WILLOW_WALL.get()), blockTexture(ModBlocks.WILLOW_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.WILLOW_DOOR.get()), modLoc("block/willow_door_bottom"), modLoc("block/willow_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.WILLOW_TRAPDOOR.get()), modLoc("block/willow_trapdoor"), true, "cutout");

        stairsBlock(((StairBlock) ModBlocks.PALM_STAIRS.get()), blockTexture(ModBlocks.BANANA_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.PALM_SLAB.get()), blockTexture(ModBlocks.BANANA_PLANKS.get()), blockTexture(ModBlocks.BANANA_PLANKS.get()));
        blockItem(ModBlocks.PALM_STAIRS);
        blockItem(ModBlocks.PALM_SLAB);
        blockItem(ModBlocks.PALM_PRESSURE_PLATE);
        blockItem(ModBlocks.PALM_FENCE_GATE);
        blockItem(ModBlocks.PALM_TRAPDOOR, "_bottom");
        buttonBlock(((ButtonBlock) ModBlocks.PALM_BUTTON.get()), blockTexture(ModBlocks.BANANA_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.PALM_PRESSURE_PLATE.get()), blockTexture(ModBlocks.BANANA_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.PALM_FENCE.get()), blockTexture(ModBlocks.BANANA_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.PALM_FENCE_GATE.get()), blockTexture(ModBlocks.BANANA_PLANKS.get()));
        wallBlock(((WallBlock) ModBlocks.PALM_WALL.get()), blockTexture(ModBlocks.BANANA_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.PALM_DOOR.get()), modLoc("block/palm_door_bottom"), modLoc("block/palm_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.PALM_TRAPDOOR.get()), modLoc("block/palm_trapdoor"), true, "cutout");

        stairsBlock(((StairBlock) ModBlocks.ECHO_STAIRS.get()), blockTexture(ModBlocks.BANANA_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.ECHO_SLAB.get()), blockTexture(ModBlocks.BANANA_PLANKS.get()), blockTexture(ModBlocks.BANANA_PLANKS.get()));
        blockItem(ModBlocks.ECHO_STAIRS);
        blockItem(ModBlocks.ECHO_SLAB);
        blockItem(ModBlocks.ECHO_PRESSURE_PLATE);
        blockItem(ModBlocks.ECHO_FENCE_GATE);
        blockItem(ModBlocks.ECHO_TRAPDOOR, "_bottom");
        buttonBlock(((ButtonBlock) ModBlocks.ECHO_BUTTON.get()), blockTexture(ModBlocks.ECHO_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.ECHO_PRESSURE_PLATE.get()), blockTexture(ModBlocks.ECHO_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.ECHO_FENCE.get()), blockTexture(ModBlocks.ECHO_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.ECHO_FENCE_GATE.get()), blockTexture(ModBlocks.ECHO_PLANKS.get()));
        wallBlock(((WallBlock) ModBlocks.ECHO_WALL.get()), blockTexture(ModBlocks.ECHO_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.ECHO_DOOR.get()), modLoc("block/echo_door_bottom"), modLoc("block/echo_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.ECHO_TRAPDOOR.get()), modLoc("block/echo_trapdoor"), true, "cutout");

        stairsBlock(((StairBlock) ModBlocks.SCULK_STONE_STAIRS.get()), blockTexture(ModBlocks.SCULK_STONE.get()));
        slabBlock(((SlabBlock) ModBlocks.SCULK_STONE_SLAB.get()), blockTexture(ModBlocks.SCULK_STONE.get()), blockTexture(ModBlocks.SCULK_STONE.get()));
        blockItem(ModBlocks.SCULK_STONE_STAIRS);
        blockItem(ModBlocks.SCULK_STONE_SLAB);
        blockItem(ModBlocks.SCULK_STONE_PRESSURE_PLATE);
        buttonBlock(((ButtonBlock) ModBlocks.SCULK_STONE_BUTTON.get()), blockTexture(ModBlocks.SCULK_STONE.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.SCULK_STONE_PRESSURE_PLATE.get()), blockTexture(ModBlocks.SCULK_STONE.get()));
        wallBlock(((WallBlock) ModBlocks.SCULK_STONE_WALL.get()), blockTexture(ModBlocks.SCULK_STONE.get()));

        stairsBlock(((StairBlock) ModBlocks.COBBLED_SCULK_STONE_STAIRS.get()), blockTexture(ModBlocks.COBBLED_SCULK_STONE.get()));
        slabBlock(((SlabBlock) ModBlocks.COBBLED_SCULK_STONE_SLAB.get()), blockTexture(ModBlocks.COBBLED_SCULK_STONE.get()), blockTexture(ModBlocks.COBBLED_SCULK_STONE.get()));
        blockItem(ModBlocks.COBBLED_SCULK_STONE_STAIRS);
        blockItem(ModBlocks.COBBLED_SCULK_STONE_SLAB);
        wallBlock(((WallBlock) ModBlocks.COBBLED_SCULK_STONE_WALL.get()), blockTexture(ModBlocks.COBBLED_SCULK_STONE.get()));

        stairsBlock(((StairBlock) ModBlocks.POLISHED_SCULK_STONE_STAIRS.get()), blockTexture(ModBlocks.POLISHED_SCULK_STONE.get()));
        slabBlock(((SlabBlock) ModBlocks.POLISHED_SCULK_STONE_SLAB.get()), blockTexture(ModBlocks.POLISHED_SCULK_STONE.get()), blockTexture(ModBlocks.POLISHED_SCULK_STONE.get()));
        blockItem(ModBlocks.POLISHED_SCULK_STONE_STAIRS);
        blockItem(ModBlocks.POLISHED_SCULK_STONE_SLAB);
        wallBlock(((WallBlock) ModBlocks.POLISHED_SCULK_STONE_WALL.get()), blockTexture(ModBlocks.POLISHED_SCULK_STONE.get()));

        stairsBlock(((StairBlock) ModBlocks.SCULK_STONE_BRICK_STAIRS.get()), blockTexture(ModBlocks.SCULK_STONE_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocks.SCULK_STONE_BRICK_SLAB.get()), blockTexture(ModBlocks.SCULK_STONE_BRICKS.get()), blockTexture(ModBlocks.SCULK_STONE_BRICKS.get()));
        blockItem(ModBlocks.SCULK_STONE_BRICK_STAIRS);
        blockItem(ModBlocks.SCULK_STONE_BRICK_SLAB);
        wallBlock(((WallBlock) ModBlocks.SCULK_STONE_BRICK_WALL.get()), blockTexture(ModBlocks.SCULK_STONE_BRICKS.get()));

        stairsBlock(((StairBlock) ModBlocks.SMOOTH_SCULK_STONE_STAIRS.get()), blockTexture(ModBlocks.SMOOTH_SCULK_STONE.get()));
        slabBlock(((SlabBlock) ModBlocks.SMOOTH_SCULK_STONE_SLAB.get()), blockTexture(ModBlocks.SMOOTH_SCULK_STONE.get()), blockTexture(ModBlocks.SMOOTH_SCULK_STONE.get()));
        blockItem(ModBlocks.SMOOTH_SCULK_STONE_STAIRS);
        blockItem(ModBlocks.SMOOTH_SCULK_STONE_SLAB);
    }


   // private void customLamp() {
   //     getVariantBuilder(ModBlocks.ANUBIS_SUMMON_BLOCK.get()).forAllStates(state -> {
   //         if(state.getValue(AnubisSummonBlock.LIT)) {
   //             return new ConfiguredModel[]{new ConfiguredModel(models().cubeTop("anubis_summon_block",
   //                     new ResourceLocation(ElegantExpansions.MOD_ID, "block/" + "anubis_summon_block"),
   //                     new ResourceLocation(ElegantExpansions.MOD_ID, "block/" + "anubis_summon_block")))};
   //         } else {
   //             return new ConfiguredModel[]{new ConfiguredModel(models().cubeTop("eye_of_horus_gold",
   //                     new ResourceLocation(ElegantExpansions.MOD_ID, "block/" + "eye_of_horus_gold"),
   //                     new ResourceLocation(ElegantExpansions.MOD_ID, "block/" + "eye_of_horus_gold")))};
   //         }
   //     });
   //     simpleBlockItem(ModBlocks.ANUBIS_SUMMON_BLOCK.get(), models().cubeAll("anubis_summon_block",
   //             new ResourceLocation(ElegantExpansions.MOD_ID, "block/" +"anubis_summon_block")));
   // }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
         simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("elegantexpansions:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("elegantexpansions:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

}
