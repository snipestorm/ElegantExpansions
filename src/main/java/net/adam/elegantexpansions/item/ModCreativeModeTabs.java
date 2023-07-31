package net.adam.elegantexpansions.item;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            ElegantExpansions.MOD_ID);

    public static RegistryObject<CreativeModeTab> ELEGANT_EXPANSIONS_ORES = CREATIVE_MODE_TABS.register("elegant_expansions_ores", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RUBY_ORE.get()))
                    .title(Component.translatable("creativemodetab.elegant_expansions_ores")).build());

    public static RegistryObject<CreativeModeTab> ELEGANT_EXPANSIONS_GEMS = CREATIVE_MODE_TABS.register("elegant_expansions_gems", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.INFUSED_ONYX.get()))
                    .title(Component.translatable("creativemodetab.elegant_expansions_gems")).build());

    public static RegistryObject<CreativeModeTab> ELEGANT_EXPANSIONS_ARMOR = CREATIVE_MODE_TABS.register("elegant_expansions_armor", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.INFUSED_DIAMOND_CHESTPLATE.get()))
                    .title(Component.translatable("creativemodetab.elegant_expansions_armor")).build());

    public static RegistryObject<CreativeModeTab> ELEGANT_EXPANSIONS_NATURE = CREATIVE_MODE_TABS.register("elegant_expansions_nature", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MAGIC_SAPLING.get()))
                    .title(Component.translatable("creativemodetab.elegant_expansions_nature")).build());

    public static RegistryObject<CreativeModeTab> ELEGANT_EXPANSIONS_MOBS = CREATIVE_MODE_TABS.register("elegant_expansions_mobs", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MUMMY_SPAWN_EGG.get()))
                    .title(Component.translatable("creativemodetab.elegant_expansions_mobs")).build());

    public static RegistryObject<CreativeModeTab> ELEGANT_EXPANSIONS_MISC = CREATIVE_MODE_TABS.register("elegant_expansions_misc", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SHREK_THEME_MUSIC_DISC.get()))
                    .title(Component.translatable("creativemodetab.elegant_expansions_misc")).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
