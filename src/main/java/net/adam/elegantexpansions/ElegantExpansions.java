package net.adam.elegantexpansions;

import com.mojang.logging.LogUtils;
import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.effect.ModEffects;
import net.adam.elegantexpansions.enchantment.ModEnchantments;
import net.adam.elegantexpansions.entity.ModEntityTypes;
import net.adam.elegantexpansions.entity.client.*;
import net.adam.elegantexpansions.item.ModCreativeModeTabs;
import net.adam.elegantexpansions.item.ModItems;
import net.adam.elegantexpansions.potion.ModPotions;
import net.adam.elegantexpansions.sound.ModSounds;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;



// The value here should match an entry in the META-INF/mods.toml file
@Mod(ElegantExpansions.MOD_ID)
public class ElegantExpansions {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "elegantexpansions";
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ElegantExpansions.MOD_ID);

    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static ElegantExpansions instance;
    public ElegantExpansions() {

        instance = this;
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        GeckoLib.initialize();
        ModEntityTypes.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);
        ModEnchantments.register(modEventBus);



       





        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {


        if (event.getTab() == ModCreativeModeTabs.ELEGANT_EXPANSIONS_ORES) {
            event.accept(ModItems.RUBY);
            event.accept(ModBlocks.RUBY_BLOCK);
            event.accept(ModBlocks.RUBY_ORE);
            event.accept(ModBlocks.DEEPSLATE_RUBY_ORE);

        }
        if (event.getTab() == ModCreativeModeTabs.ELEGANT_EXPANSIONS_NATURE) {

            event.accept(ModBlocks.MAGIC_LEAVES);
            event.accept(ModBlocks.MAGIC_LOG);
            event.accept(ModBlocks.MAGIC_WOOD);
            event.accept(ModBlocks.MAGIC_PLANKS);
            event.accept(ModBlocks.STRIPPED_MAGIC_LOG);
            event.accept(ModBlocks.STRIPPED_MAGIC_WOOD);
            event.accept(ModBlocks.MAGIC_SAPLING);
            event.accept(ModBlocks.WILLOW_LEAVES);
            event.accept(ModBlocks.WILLOW_LOG);
            event.accept(ModBlocks.WILLOW_WOOD);
            event.accept(ModBlocks.WILLOW_PLANKS);
            event.accept(ModBlocks.STRIPPED_WILLOW_LOG);
            event.accept(ModBlocks.STRIPPED_WILLOW_WOOD);
            event.accept(ModBlocks.WILLOW_SAPLING);
            event.accept(ModBlocks.MAPLE_SAPLING);
            event.accept(ModBlocks.MAPLE_LEAVES);
            event.accept(ModBlocks.ASH_LEAVES);
            event.accept(ModBlocks.ASH_LOG);
            event.accept(ModBlocks.ASH_WOOD);
            event.accept(ModBlocks.ASH_PLANKS);
            event.accept(ModBlocks.STRIPPED_ASH_LOG);
            event.accept(ModBlocks.STRIPPED_ASH_WOOD);
            event.accept(ModBlocks.ASH_SAPLING);
            event.accept(ModBlocks.CHERRY_LEAVES);
            event.accept(ModBlocks.CHERRY_LOG);
            event.accept(ModBlocks.CHERRY_WOOD);
            event.accept(ModBlocks.CHERRY_PLANKS);
            event.accept(ModBlocks.STRIPPED_CHERRY_LOG);
            event.accept(ModBlocks.STRIPPED_CHERRY_WOOD);
            event.accept(ModBlocks.CHERRY_SAPLING);
            event.accept(ModBlocks.BANANA_LEAVES);
            event.accept(ModBlocks.BANANA_LOG);
            event.accept(ModBlocks.BANANA_WOOD);
            event.accept(ModBlocks.BANANA_PLANKS);
            event.accept(ModBlocks.STRIPPED_BANANA_LOG);
            event.accept(ModBlocks.STRIPPED_BANANA_WOOD);
            event.accept(ModBlocks.BANANA_SAPLING);
        }


        if (event.getTab() == ModCreativeModeTabs.ELEGANT_EXPANSIONS_MOBS) {

            event.accept(ModItems.GOLEM_SPAWN_EGG);
            event.accept(ModItems.MUMMY_SPAWN_EGG);
            event.accept(ModItems.PLAYERS_MUMMY_SPAWN_EGG);
            event.accept(ModItems.ANUBIS_SPAWN_EGG);
            event.accept(ModItems.TIGER_SPAWN_EGG);
            event.accept(ModItems.WHITE_TIGER_SPAWN_EGG);
            event.accept(ModItems.SHREK_SPAWN_EGG);
            event.accept(ModItems.SHARK_SPAWN_EGG);

        }

        if (event.getTab() == ModCreativeModeTabs.ELEGANT_EXPANSIONS_MISC) {
            event.accept(ModItems.SHREK_THEME_MUSIC_DISC);
            event.accept(ModItems.STAFF_OF_MUMMIES);

        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.GOLEM.get(), GolemRenderer::new);
            EntityRenderers.register(ModEntityTypes.MUMMY.get(), MummyRenderer::new);
            EntityRenderers.register(ModEntityTypes.PLAYERS_MUMMY.get(), PlayersMummyRenderer::new);
            EntityRenderers.register(ModEntityTypes.ANUBIS.get(), AnubisRenderer::new);
            EntityRenderers.register(ModEntityTypes.TIGER.get(), TigerRenderer::new);
            EntityRenderers.register(ModEntityTypes.WHITE_TIGER.get(), WhiteTigerRenderer::new);
            EntityRenderers.register(ModEntityTypes.ALBINO_TIGER.get(), AlbinoTigerRenderer::new);
            EntityRenderers.register(ModEntityTypes.SHREK.get(), ShrekRenderer::new);
            EntityRenderers.register(ModEntityTypes.SHARK.get(), SharkRenderer::new);
        }
}
    }

