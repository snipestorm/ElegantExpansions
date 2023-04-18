package net.adam.elegantexpansions.item;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.ModEntityTypes;
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

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLEM_SPAWN_EGG = ITEMS.register("golem_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GOLEM, 0x363d42, 0xcc14b0, new Item.Properties()));
    public static final RegistryObject<Item> MUMMY_SPAWN_EGG = ITEMS.register("mummy_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.MUMMY, 0xFFD700, 0x0F52BA, new Item.Properties()));

    public static final RegistryObject<Item> ANUBIS_SPAWN_EGG = ITEMS.register("anubis_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ANUBIS, 0x3d281a, 0x96961b, new Item.Properties()));
    public static final RegistryObject<Item> TIGER_SPAWN_EGG = ITEMS.register("tiger_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.TIGER, 0xD57E36, 0x1D0D00, new Item.Properties()));

    public static final RegistryObject<Item> WHITE_TIGER_SPAWN_EGG = ITEMS.register("white_tiger_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.WHITE_TIGER, 0xc8d2e3, 0x1D0D00, new Item.Properties()));

    public static final RegistryObject<Item> SHREK_SPAWN_EGG = ITEMS.register("shrek_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SHREK, 0x362b21, 0x3aeb34, new Item.Properties()));

    public static final RegistryObject<Item> SHARK_SPAWN_EGG = ITEMS.register("shark_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SHARK, 0x34bdeb, 0xfcfcfc, new Item.Properties()));


  //  public static final RegistryObject<Item> SHREK_THEME_MUSIC_DISC = ITEMS.register("shrek_theme_music_disc",
    //       () -> new RecordItem(4,ModSounds.SHREK_AMBIENT, new Item.Properties().stacksTo(1).rarity(Rarity.EPIC),87));


    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
