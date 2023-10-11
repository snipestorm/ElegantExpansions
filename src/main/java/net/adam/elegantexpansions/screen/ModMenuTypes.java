package net.adam.elegantexpansions.screen;

import net.adam.elegantexpansions.ElegantExpansions;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, ElegantExpansions.MOD_ID);

    public static final RegistryObject<MenuType<GemCuttingStationMenu>> GEM_CUTTING_STATION_MENU =
            registerMenuType(GemCuttingStationMenu::new, "gem_cutting_station_menu");

    public static final RegistryObject<MenuType<GemInfusingStationMenu>> GEM_INFUSING_STATION_MENU =
            registerMenuType(GemInfusingStationMenu::new, "gem_infusing_station_menu");

    public static final RegistryObject<MenuType<ShardCreationStationMenu>> SHARD_CREATION_STATION_MENU =
            registerMenuType(ShardCreationStationMenu::new, "shard_creation_station_menu");

    public static final RegistryObject<MenuType<DisplayCaseMenu>> DISPLAY_CASE_MENU =
            registerMenuType(DisplayCaseMenu::new, "display_case_menu");

    public static final RegistryObject<MenuType<SapExtractorMenu>> SAP_EXTRACTOR_MENU =
            registerMenuType(SapExtractorMenu::new, "sap_extractor_menu");


    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                 String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
