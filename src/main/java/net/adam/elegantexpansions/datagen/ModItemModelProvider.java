package net.adam.elegantexpansions.datagen;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
        
        
        
        simpleItem(ModItems.SHARK_TOOTH);
        simpleItem(ModItems.GEM_CUTTERS);

        simpleItem(ModItems.SHREK_THEME_MUSIC_DISC);
        saplingItem(ModBlocks.MAGIC_SAPLING);
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
}
