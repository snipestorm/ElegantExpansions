package net.adam.elegantexpansions.item;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.ModEntityTypes;
import net.adam.elegantexpansions.fluid.ModFluids;
import net.adam.elegantexpansions.item.custom.*;
import net.adam.elegantexpansions.item.modifiers.ModArmorMaterials;
import net.adam.elegantexpansions.item.modifiers.ModFoodProperties;
import net.adam.elegantexpansions.item.modifiers.ModToolTiers;
import net.adam.elegantexpansions.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;



public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ElegantExpansions.MOD_ID);

    //GEMS//

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ONYX = ITEMS.register("onyx",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CITRINE = ITEMS.register("citrine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TANZANITE = ITEMS.register("tanzanite",
            () -> new Item(new Item.Properties()));

    //CUT//
    public static final RegistryObject<Item> CUT_RUBY = ITEMS.register("cut_ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CUT_ONYX = ITEMS.register("cut_onyx",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CUT_CITRINE = ITEMS.register("cut_citrine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CUT_SAPPHIRE = ITEMS.register("cut_sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CUT_TANZANITE = ITEMS.register("cut_tanzanite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CUT_EMERALD = ITEMS.register("cut_emerald",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CUT_DIAMOND = ITEMS.register("cut_diamond",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CUT_AMETHYST = ITEMS.register("cut_amethyst",
            () -> new Item(new Item.Properties()));

    //infused//
    public static final RegistryObject<Item> INFUSED_RUBY = ITEMS.register("infused_ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_ONYX = ITEMS.register("infused_onyx",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_CITRINE = ITEMS.register("infused_citrine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_SAPPHIRE = ITEMS.register("infused_sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_TANZANITE = ITEMS.register("infused_tanzanite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_EMERALD = ITEMS.register("infused_emerald",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_DIAMOND = ITEMS.register("infused_diamond",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_AMETHYST = ITEMS.register("infused_amethyst",
            () -> new InfusedAmethystItem(new Item.Properties()));

    public static final RegistryObject<Item> GEM_UPGRADE_TEMPLATE = ITEMS.register("gem_upgrade_template",
            () -> new GemUpgradeTemplateItem(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> WARDEN_UPGRADE_TEMPLATE = ITEMS.register("warden_upgrade_template",
            () -> new WardenUpgradeTemplateItem(new Item.Properties().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> HEART_OF_THE_DEEP = ITEMS.register("heart_of_the_deep",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new HammerItem(Tiers.IRON, 2,(float)-3, new Item.Properties()));

    //alexandrite//

    public static final RegistryObject<Item> ALEXANDRITE_SHARD = ITEMS.register("alexandrite_shard",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));


    public static final RegistryObject<Item> ALEXANDRITE_PAXEL = ITEMS.register("alexandrite_paxel",
            () -> new PaxelItem(ModToolTiers.ALEXANDRITE, 6,(float)-2.6, new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> ALEXANDRITE_SWORD = ITEMS.register("alexandrite_sword",
            () -> new SwordItem(ModToolTiers.ALEXANDRITE, 4,(float)-2.2, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ALEXANDRITE_AXE = ITEMS.register("alexandrite_axe",
            () -> new AxeItem(ModToolTiers.ALEXANDRITE, 6,(float)-2.8, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ALEXANDRITE_PICKAXE = ITEMS.register("alexandrite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ALEXANDRITE, 2,(float)-2.6, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ALEXANDRITE_SHOVEL = ITEMS.register("alexandrite_shovel",
            () -> new ShovelItem(ModToolTiers.ALEXANDRITE, (float)1.5,-3, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ALEXANDRITE_HOE = ITEMS.register("alexandrite_hoe",
            () -> new HoeItem(ModToolTiers.ALEXANDRITE, -5,1, new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> WARDEN_SWORD = ITEMS.register("warden_sword",
            () -> new SwordItem(ModToolTiers.WARDEN, 4,(float)-2.2, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> WARDEN_AXE = ITEMS.register("warden_axe",
            () -> new AxeItem(ModToolTiers.WARDEN, 6,(float)-2.8, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> WARDEN_PICKAXE = ITEMS.register("warden_pickaxe",
            () -> new PickaxeItem(ModToolTiers.WARDEN, 2,(float)-2.6, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> WARDEN_SHOVEL = ITEMS.register("warden_shovel",
            () -> new ShovelItem(ModToolTiers.WARDEN, (float)1.5,-3, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> WARDEN_HOE = ITEMS.register("warden_hoe",
            () -> new HoeItem(ModToolTiers.WARDEN, -5,1, new Item.Properties().rarity(Rarity.RARE)));

    //armors//

    public static final RegistryObject<Item> INFUSED_DIAMOND_HELMET = ITEMS.register("infused_diamond_helmet",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_DIAMOND, ArmorItem.Type.HELMET, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_DIAMOND_CHESTPLATE = ITEMS.register("infused_diamond_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_DIAMOND, ArmorItem.Type.CHESTPLATE, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_DIAMOND_LEGGINGS = ITEMS.register("infused_diamond_leggings",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_DIAMOND, ArmorItem.Type.LEGGINGS, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_DIAMOND_BOOTS = ITEMS.register("infused_diamond_boots",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_DIAMOND, ArmorItem.Type.BOOTS, new  Item.Properties()));

    public static final RegistryObject<Item> INFUSED_RUBY_HELMET = ITEMS.register("infused_ruby_helmet",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_RUBY, ArmorItem.Type.HELMET, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_RUBY_CHESTPLATE = ITEMS.register("infused_ruby_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_RUBY, ArmorItem.Type.CHESTPLATE, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_RUBY_LEGGINGS = ITEMS.register("infused_ruby_leggings",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_RUBY, ArmorItem.Type.LEGGINGS, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_RUBY_BOOTS = ITEMS.register("infused_ruby_boots",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_RUBY, ArmorItem.Type.BOOTS, new  Item.Properties()));

    public static final RegistryObject<Item> INFUSED_SAPPHIRE_HELMET = ITEMS.register("infused_sapphire_helmet",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_SAPPHIRE, ArmorItem.Type.HELMET, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_SAPPHIRE_CHESTPLATE = ITEMS.register("infused_sapphire_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_SAPPHIRE, ArmorItem.Type.CHESTPLATE, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_SAPPHIRE_LEGGINGS = ITEMS.register("infused_sapphire_leggings",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_SAPPHIRE, ArmorItem.Type.LEGGINGS, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_SAPPHIRE_BOOTS = ITEMS.register("infused_sapphire_boots",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_SAPPHIRE, ArmorItem.Type.BOOTS, new  Item.Properties()));

    public static final RegistryObject<Item> INFUSED_EMERALD_HELMET = ITEMS.register("infused_emerald_helmet",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_EMERALD, ArmorItem.Type.HELMET, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_EMERALD_CHESTPLATE = ITEMS.register("infused_emerald_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_EMERALD, ArmorItem.Type.CHESTPLATE, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_EMERALD_LEGGINGS = ITEMS.register("infused_emerald_leggings",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_EMERALD, ArmorItem.Type.LEGGINGS, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_EMERALD_BOOTS = ITEMS.register("infused_emerald_boots",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_EMERALD, ArmorItem.Type.BOOTS, new  Item.Properties()));

    public static final RegistryObject<Item> INFUSED_AMETHYST_HELMET = ITEMS.register("infused_amethyst_helmet",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_AMETHYST, ArmorItem.Type.HELMET, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_AMETHYST_CHESTPLATE = ITEMS.register("infused_amethyst_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_AMETHYST, ArmorItem.Type.CHESTPLATE, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_AMETHYST_LEGGINGS = ITEMS.register("infused_amethyst_leggings",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_AMETHYST, ArmorItem.Type.LEGGINGS, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_AMETHYST_BOOTS = ITEMS.register("infused_amethyst_boots",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_AMETHYST, ArmorItem.Type.BOOTS, new  Item.Properties()));

    public static final RegistryObject<Item> INFUSED_CITRINE_HELMET = ITEMS.register("infused_citrine_helmet",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_CITRINE, ArmorItem.Type.HELMET, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_CITRINE_CHESTPLATE = ITEMS.register("infused_citrine_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_CITRINE, ArmorItem.Type.CHESTPLATE, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_CITRINE_LEGGINGS = ITEMS.register("infused_citrine_leggings",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_CITRINE, ArmorItem.Type.LEGGINGS, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_CITRINE_BOOTS = ITEMS.register("infused_citrine_boots",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_CITRINE, ArmorItem.Type.BOOTS, new  Item.Properties()));

    public static final RegistryObject<Item> INFUSED_TANZANITE_HELMET = ITEMS.register("infused_tanzanite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_TANZANITE, ArmorItem.Type.HELMET, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_TANZANITE_CHESTPLATE = ITEMS.register("infused_tanzanite_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_TANZANITE, ArmorItem.Type.CHESTPLATE, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_TANZANITE_LEGGINGS = ITEMS.register("infused_tanzanite_leggings",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_TANZANITE, ArmorItem.Type.LEGGINGS, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_TANZANITE_BOOTS = ITEMS.register("infused_tanzanite_boots",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_TANZANITE, ArmorItem.Type.BOOTS, new  Item.Properties()));

    public static final RegistryObject<Item> INFUSED_ONYX_HELMET = ITEMS.register("infused_onyx_helmet",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_ONYX, ArmorItem.Type.HELMET, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_ONYX_CHESTPLATE = ITEMS.register("infused_onyx_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_ONYX, ArmorItem.Type.CHESTPLATE, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_ONYX_LEGGINGS = ITEMS.register("infused_onyx_leggings",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_ONYX, ArmorItem.Type.LEGGINGS, new  Item.Properties()));
    public static final RegistryObject<Item> INFUSED_ONYX_BOOTS = ITEMS.register("infused_onyx_boots",
            () -> new ModArmorItem(ModArmorMaterials.INFUSED_ONYX, ArmorItem.Type.BOOTS, new  Item.Properties()));

    public static final RegistryObject<Item> WARDEN_HELMET = ITEMS.register("warden_helmet",
            () -> new WardenArmorItem(ModArmorMaterials.WARDEN, ArmorItem.Type.HELMET, new  Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> WARDEN_CHESTPLATE = ITEMS.register("warden_chestplate",
            () -> new WardenArmorItem(ModArmorMaterials.WARDEN, ArmorItem.Type.CHESTPLATE, new  Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> WARDEN_LEGGINGS = ITEMS.register("warden_leggings",
            () -> new WardenArmorItem(ModArmorMaterials.WARDEN, ArmorItem.Type.LEGGINGS, new  Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> WARDEN_BOOTS = ITEMS.register("warden_boots",
            () -> new WardenArmorItem(ModArmorMaterials.WARDEN, ArmorItem.Type.BOOTS, new  Item.Properties().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> ALEXANDRITE_HELMET = ITEMS.register("alexandrite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ALEXANDRITE, ArmorItem.Type.HELMET, new  Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ALEXANDRITE_CHESTPLATE = ITEMS.register("alexandrite_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.ALEXANDRITE, ArmorItem.Type.CHESTPLATE, new  Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ALEXANDRITE_LEGGINGS = ITEMS.register("alexandrite_leggings",
            () -> new ModArmorItem(ModArmorMaterials.ALEXANDRITE, ArmorItem.Type.LEGGINGS, new  Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ALEXANDRITE_BOOTS = ITEMS.register("alexandrite_boots",
            () -> new ModArmorItem(ModArmorMaterials.ALEXANDRITE, ArmorItem.Type.BOOTS, new  Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> ANCIENT_SCROLL = ITEMS.register("ancient_scroll",
            () -> new AncientScrollItem(new Item.Properties().durability(1).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> SHARK_TOOTH = ITEMS.register("shark_tooth",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GEM_CUTTERS = ITEMS.register("gem_cutters",
            () -> new Item(new Item.Properties().durability(3)));

    public static final RegistryObject<Item> GEM_DETECTOR = ITEMS.register("gem_detector",
            () -> new GemDetectorItem(new Item.Properties().durability(100).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> DATA_TABLET = ITEMS.register("data_tablet",
            () -> new DataTabletItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> MAGICAL_SAP_BUCKET = ITEMS.register("magical_sap_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MAGICAL_SAP, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));


    public static final RegistryObject<Item> GOLEM_SPAWN_EGG = ITEMS.register("golem_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GOLEM, 0x363d42, 0xcc14b0, new Item.Properties()));

    public static final RegistryObject<Item> MUMMY_SPAWN_EGG = ITEMS.register("mummy_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.MUMMY, 0x3d281a, 0x96961b, new Item.Properties()));

    public static final RegistryObject<Item> PLAYERS_MUMMY_SPAWN_EGG = ITEMS.register("players_mummy_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PLAYERS_MUMMY, 0x3d281a, 0x96961b, new Item.Properties()));

    public static final RegistryObject<Item> ANUBIS_SPAWN_EGG = ITEMS.register("anubis_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ANUBIS, 0xFFD700, 0x0F52BA, new Item.Properties()));

    public static final RegistryObject<Item> TIGER_SPAWN_EGG = ITEMS.register("tiger_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.TIGER, 0xD57E36, 0x1D0D00, new Item.Properties()));

    public static final RegistryObject<Item> WHITE_TIGER_SPAWN_EGG = ITEMS.register("white_tiger_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.WHITE_TIGER, 0xc8d2e3, 0x1D0D00, new Item.Properties()));

    public static final RegistryObject<Item> SHREK_SPAWN_EGG = ITEMS.register("shrek_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SHREK, 0x362b21, 0x3aeb34, new Item.Properties()));

    public static final RegistryObject<Item> SHARK_SPAWN_EGG = ITEMS.register("shark_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SHARK, 0x34bdeb, 0xfcfcfc, new Item.Properties()));

    public static final RegistryObject<Item> CAPYBARA_SPAWN_EGG = ITEMS.register("capybara_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CAPYBARA, 0x332626, 0x080000, new Item.Properties()));

    public static final RegistryObject<Item> ELEPHANT_SPAWN_EGG = ITEMS.register("elephant_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ELEPHANT, 0x57524f, 0x4f2b15, new Item.Properties()));

    public static final RegistryObject<Item> RACCOON_SPAWN_EGG = ITEMS.register("raccoon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.RACCOON, 0x57524f, 0x4f2b15, new Item.Properties()));

    public static final RegistryObject<Item> LION_SPAWN_EGG = ITEMS.register("lion_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.LION, 0x57524f, 0x4f2b15, new Item.Properties()));

    public static final RegistryObject<Item> HIPPO_SPAWN_EGG = ITEMS.register("hippo_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.HIPPO, 0x57524f, 0x4f2b15, new Item.Properties()));

    public static final RegistryObject<Item> VULTURE_SPAWN_EGG = ITEMS.register("vulture_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.VULTURE, 0x57524f, 0x4f2b15, new Item.Properties()));

    public static final RegistryObject<Item> STAFF_OF_MUMMIES = ITEMS.register("staff_of_mummies",
            () -> new StaffOfMummiesItem(Tiers.DIAMOND, 1, (float) -2.8, new Item.Properties().stacksTo(1).fireResistant().durability(25).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> WARDEN_STAFF = ITEMS.register("warden_staff",
            () -> new WardenStaffItem(ModToolTiers.WARDEN,-3,-3, new Item.Properties().stacksTo(1).rarity(Rarity.RARE).fireResistant().durability(50)));

    public static final RegistryObject<Item> SHREK_THEME_MUSIC_DISC = ITEMS.register("shrek_theme_music_disc",
           () -> new RecordItem(4,ModSounds.SHREK_AMBIENT, new Item.Properties().stacksTo(1).rarity(Rarity.EPIC),1740));

    //food//

    public static final RegistryObject<Item> EXOTIC_MEAT = ITEMS.register("exotic_meat",
            () -> new Item(new Item.Properties().food(ModFoodProperties.EXOTIC_MEAT)));

    public static final RegistryObject<Item> COOKED_EXOTIC_MEAT = ITEMS.register("cooked_exotic_meat",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COOKED_EXOTIC_MEAT)));

    public static final RegistryObject<Item> LARGE_CAT_MEAT = ITEMS.register("large_cat_meat",
            () -> new Item(new Item.Properties().food(ModFoodProperties.LARGE_CAT_MEAT)));

    public static final RegistryObject<Item> COOKED_LARGE_CAT_MEAT= ITEMS.register("cooked_large_cat_meat",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COOKED_LARGE_CAT_MEAT)));


    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
