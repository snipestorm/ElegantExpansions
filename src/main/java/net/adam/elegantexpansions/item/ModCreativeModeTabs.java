package net.adam.elegantexpansions.item;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ElegantExpansions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab ELEGANT_EXPANSIONS_ORES;
    public static CreativeModeTab ELEGANT_EXPANSIONS_NATURE;
    public static CreativeModeTab ELEGANT_EXPANSIONS_MOBS;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        ELEGANT_EXPANSIONS_ORES = event.registerCreativeModeTab(new ResourceLocation(ElegantExpansions.MOD_ID, "elegant_expansions_ores"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.RUBY_ORE.get()))
                        .title(Component.translatable("creativemodetab.elegant_expansions_ores")));

        ELEGANT_EXPANSIONS_NATURE = event.registerCreativeModeTab(new ResourceLocation(ElegantExpansions.MOD_ID, "elegant_expansions_nature"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.MAGIC_SAPLING.get()))
                        .title(Component.translatable("creativemodetab.elegant_expansions_nature")));

        ELEGANT_EXPANSIONS_MOBS = event.registerCreativeModeTab(new ResourceLocation(ElegantExpansions.MOD_ID, "elegant_expansions_mobs"),
                builder -> builder.icon(() -> new ItemStack(ModItems.MUMMY_SPAWN_EGG.get()))
                        .title(Component.translatable("creativemodetab.elegant_expansions_mobs")));
    }

}
