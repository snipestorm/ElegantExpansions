package net.adam.elegantexpansions.datagen;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ElegantExpansions.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerModels() {
        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.CITRINE);
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.TANZANITE);
        simpleItem(ModItems.ONYX);

        simpleItem(ModItems.CUT_CITRINE);
        simpleItem(ModItems.CUT_TANZANITE);
        simpleItem(ModItems.CUT_SAPPHIRE);
        simpleItem(ModItems.CUT_AMETHYST);
        simpleItem(ModItems.CUT_DIAMOND);
        simpleItem(ModItems.CUT_RUBY);
        simpleItem(ModItems.CUT_ONYX);
        simpleItem(ModItems.CUT_EMERALD);

        simpleItem(ModItems.INFUSED_CITRINE);
        simpleItem(ModItems.INFUSED_TANZANITE);
        simpleItem(ModItems.INFUSED_SAPPHIRE);
        simpleItem(ModItems.INFUSED_AMETHYST);
        simpleItem(ModItems.INFUSED_DIAMOND);
        simpleItem(ModItems.INFUSED_RUBY);
        simpleItem(ModItems.INFUSED_ONYX);
        simpleItem(ModItems.INFUSED_EMERALD);
        
        simpleItem(ModItems.INFUSED_DIAMOND_HELMET);
        simpleItem(ModItems.INFUSED_DIAMOND_CHESTPLATE);
        simpleItem(ModItems.INFUSED_DIAMOND_LEGGINGS);
        simpleItem(ModItems.INFUSED_DIAMOND_BOOTS);

        simpleItem(ModItems.INFUSED_RUBY_HELMET);
        simpleItem(ModItems.INFUSED_RUBY_CHESTPLATE);
        simpleItem(ModItems.INFUSED_RUBY_LEGGINGS);
        simpleItem(ModItems.INFUSED_RUBY_BOOTS);

        simpleItem(ModItems.INFUSED_SAPPHIRE_HELMET);
        simpleItem(ModItems.INFUSED_SAPPHIRE_CHESTPLATE);
        simpleItem(ModItems.INFUSED_SAPPHIRE_LEGGINGS);
        simpleItem(ModItems.INFUSED_SAPPHIRE_BOOTS);

        simpleItem(ModItems.INFUSED_EMERALD_HELMET);
        simpleItem(ModItems.INFUSED_EMERALD_CHESTPLATE);
        simpleItem(ModItems.INFUSED_EMERALD_LEGGINGS);
        simpleItem(ModItems.INFUSED_EMERALD_BOOTS);

        simpleItem(ModItems.INFUSED_AMETHYST_HELMET);
        simpleItem(ModItems.INFUSED_AMETHYST_CHESTPLATE);
        simpleItem(ModItems.INFUSED_AMETHYST_LEGGINGS);
        simpleItem(ModItems.INFUSED_AMETHYST_BOOTS);

        simpleItem(ModItems.INFUSED_CITRINE_HELMET);
        simpleItem(ModItems.INFUSED_CITRINE_CHESTPLATE);
        simpleItem(ModItems.INFUSED_CITRINE_LEGGINGS);
        simpleItem(ModItems.INFUSED_CITRINE_BOOTS);

        simpleItem(ModItems.INFUSED_TANZANITE_HELMET);
        simpleItem(ModItems.INFUSED_TANZANITE_CHESTPLATE);
        simpleItem(ModItems.INFUSED_TANZANITE_LEGGINGS);
        simpleItem(ModItems.INFUSED_TANZANITE_BOOTS);

        simpleItem(ModItems.INFUSED_ONYX_HELMET);
        simpleItem(ModItems.INFUSED_ONYX_CHESTPLATE);
        simpleItem(ModItems.INFUSED_ONYX_LEGGINGS);
        simpleItem(ModItems.INFUSED_ONYX_BOOTS);

        simpleItem(ModItems.GEM_UPGRADE_TEMPLATE);
        simpleItem(ModItems.ANCIENT_SCROLL);
        simpleItem(ModItems.ALEXANDRITE_SHARD);
        simpleItem(ModItems.ALEXANDRITE);

        handheldItem(ModItems.ALEXANDRITE_PAXEL);
        handheldItem(ModItems.ALEXANDRITE_SWORD);
        handheldItem(ModItems.ALEXANDRITE_SHOVEL);
        handheldItem(ModItems.ALEXANDRITE_PICKAXE);
        handheldItem(ModItems.ALEXANDRITE_AXE);
        handheldItem(ModItems.ALEXANDRITE_HOE);



        simpleItem(ModItems.SHARK_TOOTH);
        simpleItem(ModItems.GEM_CUTTERS);
        simpleItem(ModItems.GEM_DETECTOR);
        simpleItem(ModItems.MAGICAL_SAP_BUCKET);

        simpleItem(ModItems.SHREK_THEME_MUSIC_DISC);
        saplingItem(ModBlocks.MAGIC_SAPLING);
        saplingItem(ModBlocks.ECHO_SAPLING);
        saplingItem(ModBlocks.WILLOW_SAPLING);
        saplingItem(ModBlocks.MAPLE_SAPLING);
        saplingItem(ModBlocks.ASH_SAPLING);
        saplingItem(ModBlocks.BANANA_SAPLING);

        withExistingParent(ModItems.TIGER_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.WHITE_TIGER_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.MUMMY_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.PLAYERS_MUMMY_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.ANUBIS_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.GOLEM_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.SHREK_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.SHARK_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.CAPYBARA_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.ELEPHANT_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.RACCOON_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.LION_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.HIPPO_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.VULTURE_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));

        simpleBlockItem(ModBlocks.MAGIC_DOOR);
        fenceItem(ModBlocks.MAGIC_FENCE, ModBlocks.MAGIC_PLANKS);
        buttonItem(ModBlocks.MAGIC_BUTTON, ModBlocks.MAGIC_PLANKS);
        wallItem(ModBlocks.MAGIC_WALL, ModBlocks.MAGIC_PLANKS);

        simpleBlockItem(ModBlocks.ASH_DOOR);
        fenceItem(ModBlocks.ASH_FENCE, ModBlocks.ASH_PLANKS);
        buttonItem(ModBlocks.ASH_BUTTON, ModBlocks.ASH_PLANKS);
        wallItem(ModBlocks.ASH_WALL, ModBlocks.ASH_PLANKS);

        simpleBlockItem(ModBlocks.WILLOW_DOOR);
        fenceItem(ModBlocks.WILLOW_FENCE, ModBlocks.WILLOW_PLANKS);
        buttonItem(ModBlocks.WILLOW_BUTTON, ModBlocks.WILLOW_PLANKS);
        wallItem(ModBlocks.WILLOW_WALL, ModBlocks.WILLOW_PLANKS);

        simpleBlockItem(ModBlocks.PALM_DOOR);
        fenceItem(ModBlocks.PALM_FENCE, ModBlocks.BANANA_PLANKS);
        buttonItem(ModBlocks.PALM_BUTTON, ModBlocks.BANANA_PLANKS);
        wallItem(ModBlocks.PALM_WALL, ModBlocks.BANANA_PLANKS);

        buttonItem(ModBlocks.SCULK_STONE_BUTTON, ModBlocks.SCULK_STONE);
        wallItem(ModBlocks.SCULK_STONE_WALL, ModBlocks.SCULK_STONE);
        wallItem(ModBlocks.COBBLED_SCULK_STONE_WALL, ModBlocks.COBBLED_SCULK_STONE);
        wallItem(ModBlocks.POLISHED_SCULK_STONE_WALL, ModBlocks.POLISHED_SCULK_STONE);
        wallItem(ModBlocks.SCULK_STONE_BRICK_WALL, ModBlocks.SCULK_STONE_BRICKS);


    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ElegantExpansions.MOD_ID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ElegantExpansions.MOD_ID, "block/" + item.getId().getPath()));
    }


    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(ElegantExpansions.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(ElegantExpansions.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(ElegantExpansions.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(ElegantExpansions.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ElegantExpansions.MOD_ID,"item/" + item.getId().getPath()));
    }
}
