package net.adam.elegantexpansions.datagen;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

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
        
        trimmedArmorItem(ModItems.INFUSED_DIAMOND_HELMET);
        trimmedArmorItem(ModItems.INFUSED_DIAMOND_CHESTPLATE);
        trimmedArmorItem(ModItems.INFUSED_DIAMOND_LEGGINGS);
        trimmedArmorItem(ModItems.INFUSED_DIAMOND_BOOTS);

        trimmedArmorItem(ModItems.INFUSED_RUBY_HELMET);
        trimmedArmorItem(ModItems.INFUSED_RUBY_CHESTPLATE);
        trimmedArmorItem(ModItems.INFUSED_RUBY_LEGGINGS);
        trimmedArmorItem(ModItems.INFUSED_RUBY_BOOTS);

        trimmedArmorItem(ModItems.INFUSED_SAPPHIRE_HELMET);
        trimmedArmorItem(ModItems.INFUSED_SAPPHIRE_CHESTPLATE);
        trimmedArmorItem(ModItems.INFUSED_SAPPHIRE_LEGGINGS);
        trimmedArmorItem(ModItems.INFUSED_SAPPHIRE_BOOTS);

        trimmedArmorItem(ModItems.INFUSED_EMERALD_HELMET);
        trimmedArmorItem(ModItems.INFUSED_EMERALD_CHESTPLATE);
        trimmedArmorItem(ModItems.INFUSED_EMERALD_LEGGINGS);
        trimmedArmorItem(ModItems.INFUSED_EMERALD_BOOTS);

        trimmedArmorItem(ModItems.INFUSED_AMETHYST_HELMET);
        trimmedArmorItem(ModItems.INFUSED_AMETHYST_CHESTPLATE);
        trimmedArmorItem(ModItems.INFUSED_AMETHYST_LEGGINGS);
        trimmedArmorItem(ModItems.INFUSED_AMETHYST_BOOTS);

        trimmedArmorItem(ModItems.INFUSED_CITRINE_HELMET);
        trimmedArmorItem(ModItems.INFUSED_CITRINE_CHESTPLATE);
        trimmedArmorItem(ModItems.INFUSED_CITRINE_LEGGINGS);
        trimmedArmorItem(ModItems.INFUSED_CITRINE_BOOTS);

        trimmedArmorItem(ModItems.INFUSED_TANZANITE_HELMET);
        trimmedArmorItem(ModItems.INFUSED_TANZANITE_CHESTPLATE);
        trimmedArmorItem(ModItems.INFUSED_TANZANITE_LEGGINGS);
        trimmedArmorItem(ModItems.INFUSED_TANZANITE_BOOTS);

        trimmedArmorItem(ModItems.INFUSED_ONYX_HELMET);
        trimmedArmorItem(ModItems.INFUSED_ONYX_CHESTPLATE);
        trimmedArmorItem(ModItems.INFUSED_ONYX_LEGGINGS);
        trimmedArmorItem(ModItems.INFUSED_ONYX_BOOTS);

         trimmedArmorItem(ModItems.WARDEN_HELMET);
         trimmedArmorItem(ModItems.WARDEN_CHESTPLATE);
         trimmedArmorItem(ModItems.WARDEN_LEGGINGS);
         trimmedArmorItem(ModItems.WARDEN_BOOTS);

         trimmedArmorItem(ModItems.ALEXANDRITE_HELMET);
         trimmedArmorItem(ModItems.ALEXANDRITE_CHESTPLATE);
         trimmedArmorItem(ModItems.ALEXANDRITE_LEGGINGS);
         trimmedArmorItem(ModItems.ALEXANDRITE_BOOTS);

        simpleItem(ModItems.GEM_UPGRADE_TEMPLATE);
        simpleItem(ModItems.WARDEN_UPGRADE_TEMPLATE);
        simpleItem(ModItems.ANCIENT_SCROLL);
        simpleItem(ModItems.HEART_OF_THE_DEEP);
        simpleItem(ModItems.ALEXANDRITE_SHARD);
        simpleItem(ModItems.ALEXANDRITE);

        handheldItem(ModItems.ALEXANDRITE_PAXEL);
        handheldItem(ModItems.ALEXANDRITE_SWORD);
        handheldItem(ModItems.ALEXANDRITE_SHOVEL);
        handheldItem(ModItems.ALEXANDRITE_PICKAXE);
        handheldItem(ModItems.ALEXANDRITE_AXE);
        handheldItem(ModItems.ALEXANDRITE_HOE);

        handheldItem(ModItems.WARDEN_SWORD);
        handheldItem(ModItems.WARDEN_SHOVEL);
        handheldItem(ModItems.WARDEN_PICKAXE);
        handheldItem(ModItems.WARDEN_AXE);
        handheldItem(ModItems.WARDEN_HOE);
        handheldItem(ModItems.IRON_HAMMER);


        handheldItem(ModItems.EXOTIC_MEAT);
        handheldItem(ModItems.COOKED_EXOTIC_MEAT);
        handheldItem(ModItems.LARGE_CAT_MEAT);
        handheldItem(ModItems.COOKED_LARGE_CAT_MEAT);



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

        simpleBlockItem(ModBlocks.ECHO_DOOR);
        fenceItem(ModBlocks.ECHO_FENCE, ModBlocks.ECHO_PLANKS);
        buttonItem(ModBlocks.ECHO_BUTTON, ModBlocks.ECHO_PLANKS);
        wallItem(ModBlocks.ECHO_WALL, ModBlocks.ECHO_PLANKS);


        buttonItem(ModBlocks.SCULK_STONE_BUTTON, ModBlocks.SCULK_STONE);
        wallItem(ModBlocks.SCULK_STONE_WALL, ModBlocks.SCULK_STONE);
        wallItem(ModBlocks.COBBLED_SCULK_STONE_WALL, ModBlocks.COBBLED_SCULK_STONE);
        wallItem(ModBlocks.POLISHED_SCULK_STONE_WALL, ModBlocks.POLISHED_SCULK_STONE);
        wallItem(ModBlocks.SCULK_STONE_BRICK_WALL, ModBlocks.SCULK_STONE_BRICKS);


    }
    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = ElegantExpansions.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
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
