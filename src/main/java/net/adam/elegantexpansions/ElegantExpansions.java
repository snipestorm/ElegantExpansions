package net.adam.elegantexpansions;

import com.mojang.logging.LogUtils;
import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.block.entity.ModBlockEntities;
import net.adam.elegantexpansions.effect.ModEffects;
import net.adam.elegantexpansions.enchantment.ModEnchantments;
import net.adam.elegantexpansions.entity.ModEntityTypes;
import net.adam.elegantexpansions.entity.client.*;
import net.adam.elegantexpansions.fluid.ModFluidTypes;
import net.adam.elegantexpansions.fluid.ModFluids;
import net.adam.elegantexpansions.item.ModCreativeModeTabs;
import net.adam.elegantexpansions.item.ModItemProperties;
import net.adam.elegantexpansions.item.ModItems;
import net.adam.elegantexpansions.potion.ModPotions;
import net.adam.elegantexpansions.recipe.ModRecipes;
import net.adam.elegantexpansions.screen.*;
import net.adam.elegantexpansions.sound.ModSounds;
import net.adam.elegantexpansions.util.BetterBrewingRecipe;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
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

import java.util.function.Supplier;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(ElegantExpansions.MOD_ID)
public class ElegantExpansions {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "elegantexpansions";

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ElegantExpansions.MOD_ID);

    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public ElegantExpansions() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        GeckoLib.initialize();
        ModEntityTypes.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);
        ModEnchantments.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);





       





        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                ModItems.SHARK_TOOTH.get(), ModPotions.BLEED_POTION.get()));
    });
    }



    private void addCreative(BuildCreativeModeTabContentsEvent event) {


        if (event.getTab() == ModCreativeModeTabs.ELEGANT_EXPANSIONS_ORES.get()) {

            event.accept(ModBlocks.RUBY_ORE);
            event.accept(ModBlocks.DEEPSLATE_RUBY_ORE);
            event.accept(ModBlocks.SAPPHIRE_ORE);
            event.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
            event.accept(ModBlocks.ENDSTONE_TANZANITE_ORE);
            event.accept(ModBlocks.NETHER_CITRINE_ORE);


        }
        if (event.getTab() == ModCreativeModeTabs.ELEGANT_EXPANSIONS_NATURE.get()) {

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
            event.accept(ModBlocks.BANANA_LEAVES);
            event.accept(ModBlocks.BANANA_LOG);
            event.accept(ModBlocks.BANANA_WOOD);
            event.accept(ModBlocks.BANANA_PLANKS);
            event.accept(ModBlocks.STRIPPED_BANANA_LOG);
            event.accept(ModBlocks.STRIPPED_BANANA_WOOD);
            event.accept(ModBlocks.BANANA_SAPLING);
            event.accept(ModItems.SHARK_TOOTH);
        }


        if (event.getTab() == ModCreativeModeTabs.ELEGANT_EXPANSIONS_MOBS.get()) {

            event.accept(ModItems.GOLEM_SPAWN_EGG);
            event.accept(ModItems.MUMMY_SPAWN_EGG);
            event.accept(ModItems.PLAYERS_MUMMY_SPAWN_EGG);
            event.accept(ModItems.ANUBIS_SPAWN_EGG);
            event.accept(ModItems.TIGER_SPAWN_EGG);
            event.accept(ModItems.WHITE_TIGER_SPAWN_EGG);
            event.accept(ModItems.SHREK_SPAWN_EGG);
            event.accept(ModItems.SHARK_SPAWN_EGG);
            event.accept(ModItems.CAPYBARA_SPAWN_EGG);

        }

        if (event.getTab() == ModCreativeModeTabs.ELEGANT_EXPANSIONS_MISC.get()) {
            event.accept(ModItems.SHREK_THEME_MUSIC_DISC);
            event.accept(ModItems.STAFF_OF_MUMMIES);
            event.accept(ModItems.MAGICAL_SAP_BUCKET);

        }

        if (event.getTab() == ModCreativeModeTabs.ELEGANT_EXPANSIONS_GEMS.get()) {
            event.accept(ModItems.RUBY);
            event.accept(ModItems.CITRINE);
            event.accept(ModItems.ONYX);
            event.accept(ModItems.SAPPHIRE);
            event.accept(ModItems.TANZANITE);
            event.accept(Items.DIAMOND);
            event.accept(Items.EMERALD);
            event.accept(Items.AMETHYST_SHARD);

            event.accept(ModItems.CUT_RUBY);
            event.accept(ModItems.CUT_CITRINE);
            event.accept(ModItems.CUT_ONYX);
            event.accept(ModItems.CUT_SAPPHIRE);
            event.accept(ModItems.CUT_TANZANITE);
            event.accept(ModItems.CUT_DIAMOND);
            event.accept(ModItems.CUT_EMERALD);
            event.accept(ModItems.CUT_AMETHYST);

            event.accept(ModItems.INFUSED_RUBY);
            event.accept(ModItems.INFUSED_CITRINE);
            event.accept(ModItems.INFUSED_ONYX);
            event.accept(ModItems.INFUSED_SAPPHIRE);
            event.accept(ModItems.INFUSED_TANZANITE);
            event.accept(ModItems.INFUSED_DIAMOND);
            event.accept(ModItems.INFUSED_EMERALD);
            event.accept(ModItems.INFUSED_AMETHYST);

            event.accept(ModBlocks.RUBY_BLOCK);
            event.accept(ModBlocks.CITRINE_BLOCK);
            event.accept(ModBlocks.ONYX_BLOCK);
            event.accept(ModBlocks.SAPPHIRE_BLOCK);
            event.accept(ModBlocks.TANZANITE_BLOCK);
            event.accept(Blocks.DIAMOND_BLOCK);
            event.accept(Blocks.EMERALD_BLOCK);
            event.accept(Blocks.AMETHYST_BLOCK);

            event.accept(ModItems.GEM_UPGRADE_TEMPLATE);



            event.accept(ModItems.GEM_CUTTERS);

            event.accept(ModBlocks.GEM_CUTTING_STATION);
            event.accept(ModBlocks.GEM_INFUSING_STATION);
            event.accept(ModBlocks.SHARD_CREATION_STATION);

            event.accept(ModItems.GEM_DETECTOR);
            event.accept(ModItems.DATA_TABLET);
            event.accept(ModItems.ALEXANDRITE_SHARD);

        }

        if (event.getTab() == ModCreativeModeTabs.ELEGANT_EXPANSIONS_ARMOR.get()) {
            event.accept(ModItems.INFUSED_DIAMOND_HELMET);
            event.accept(ModItems.INFUSED_DIAMOND_CHESTPLATE);
            event.accept(ModItems.INFUSED_DIAMOND_LEGGINGS);
            event.accept(ModItems.INFUSED_DIAMOND_BOOTS);

            event.accept(ModItems.INFUSED_RUBY_HELMET);
            event.accept(ModItems.INFUSED_RUBY_CHESTPLATE);
            event.accept(ModItems.INFUSED_RUBY_LEGGINGS);
            event.accept(ModItems.INFUSED_RUBY_BOOTS);

            event.accept(ModItems.INFUSED_SAPPHIRE_HELMET);
            event.accept(ModItems.INFUSED_SAPPHIRE_CHESTPLATE);
            event.accept(ModItems.INFUSED_SAPPHIRE_LEGGINGS);
            event.accept(ModItems.INFUSED_SAPPHIRE_BOOTS);

            event.accept(ModItems.INFUSED_EMERALD_HELMET);
            event.accept(ModItems.INFUSED_EMERALD_CHESTPLATE);
            event.accept(ModItems.INFUSED_EMERALD_LEGGINGS);
            event.accept(ModItems.INFUSED_EMERALD_BOOTS);

            event.accept(ModItems.INFUSED_AMETHYST_HELMET);
            event.accept(ModItems.INFUSED_AMETHYST_CHESTPLATE);
            event.accept(ModItems.INFUSED_AMETHYST_LEGGINGS);
            event.accept(ModItems.INFUSED_AMETHYST_BOOTS);

            event.accept(ModItems.INFUSED_CITRINE_HELMET);
            event.accept(ModItems.INFUSED_CITRINE_CHESTPLATE);
            event.accept(ModItems.INFUSED_CITRINE_LEGGINGS);
            event.accept(ModItems.INFUSED_CITRINE_BOOTS);

            event.accept(ModItems.INFUSED_TANZANITE_HELMET);
            event.accept(ModItems.INFUSED_TANZANITE_CHESTPLATE);
            event.accept(ModItems.INFUSED_TANZANITE_LEGGINGS);
            event.accept(ModItems.INFUSED_TANZANITE_BOOTS);

            event.accept(ModItems.INFUSED_ONYX_HELMET);
            event.accept(ModItems.INFUSED_ONYX_CHESTPLATE);
            event.accept(ModItems.INFUSED_ONYX_LEGGINGS);
            event.accept(ModItems.INFUSED_ONYX_BOOTS);


        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            event.enqueueWork(() -> {
                        ModItemProperties.addCustomItemProperties();
                    });

            EntityRenderers.register(ModEntityTypes.GOLEM.get(), GolemRenderer::new);
            EntityRenderers.register(ModEntityTypes.MUMMY.get(), MummyRenderer::new);
            EntityRenderers.register(ModEntityTypes.PLAYERS_MUMMY.get(), PlayersMummyRenderer::new);
            EntityRenderers.register(ModEntityTypes.ANUBIS.get(), AnubisRenderer::new);
            EntityRenderers.register(ModEntityTypes.TIGER.get(), TigerRenderer::new);
            EntityRenderers.register(ModEntityTypes.WHITE_TIGER.get(), WhiteTigerRenderer::new);
            EntityRenderers.register(ModEntityTypes.ALBINO_TIGER.get(), AlbinoTigerRenderer::new);
            EntityRenderers.register(ModEntityTypes.SHREK.get(), ShrekRenderer::new);
            EntityRenderers.register(ModEntityTypes.SHARK.get(), SharkRenderer::new);
            EntityRenderers.register(ModEntityTypes.CAPYBARA.get(), CapybaraRenderer::new);


            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GEM_CUTTING_STATION.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GEM_INFUSING_STATION.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SHARD_CREATION_STATION.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_MAGICAL_SAP.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_MAGICAL_SAP.get(), RenderType.translucent());

            MenuScreens.register(ModMenuTypes.GEM_CUTTING_STATION_MENU.get(), GemCuttingStationScreen::new);
            MenuScreens.register(ModMenuTypes.GEM_INFUSING_STATION_MENU.get(), GemInfusingStationScreen::new);
            MenuScreens.register(ModMenuTypes.SHARD_CREATION_STATION_MENU.get(), ShardCreationStationScreen::new);
        }
}
    }

