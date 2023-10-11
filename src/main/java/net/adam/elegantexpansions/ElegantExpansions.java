package net.adam.elegantexpansions;

import com.mojang.logging.LogUtils;
import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.block.entity.ModBlockEntities;
import net.adam.elegantexpansions.effect.ModEffects;
import net.adam.elegantexpansions.enchantment.ModEnchantments;
import net.adam.elegantexpansions.entity.ModEntityTypes;
import net.adam.elegantexpansions.entity.client.renderers.*;
import net.adam.elegantexpansions.entity.custom.EchoSpider;
import net.adam.elegantexpansions.entity.custom.VultureEntity;
import net.adam.elegantexpansions.fluid.ModFluidTypes;
import net.adam.elegantexpansions.fluid.ModFluids;
import net.adam.elegantexpansions.item.ModCreativeModeTabs;
import net.adam.elegantexpansions.item.ModItemProperties;
import net.adam.elegantexpansions.item.ModItems;
import net.adam.elegantexpansions.particle.ModParticles;
import net.adam.elegantexpansions.potion.ModPotions;
import net.adam.elegantexpansions.recipe.ModRecipes;
import net.adam.elegantexpansions.screen.*;
import net.adam.elegantexpansions.sound.ModSounds;
import net.adam.elegantexpansions.util.BetterBrewingRecipe;
import net.adam.elegantexpansions.villager.ModVillagers;
import net.adam.elegantexpansions.worldgen.biome.ModTerrablender;
import net.adam.elegantexpansions.worldgen.biome.surface.ModSurfaceRules;
import net.adam.elegantexpansions.worldgen.tree.ModFoliagePlacerTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.Heightmap;
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
import terrablender.api.SurfaceRuleManager;


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
        ModParticles.register(modEventBus);
        ModVillagers.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);
        ModFoliagePlacerTypes.register(modEventBus);

        ModTerrablender.registerRegions();





       





        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }


    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                ModItems.SHARK_TOOTH.get(), ModPotions.BLEED_POTION.get()));

            ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ModBlocks.MYSTICSHROOM.getId(), ModBlocks.POTTED_MYSTICSHROOM);
            ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ModBlocks.MYSTIC_GLOWFLOWER.getId(), ModBlocks.POTTED_MYSTIC_GLOWFLOWER);


            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, MOD_ID, ModSurfaceRules.netherRules());
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
            event.accept(ModBlocks.ECHO_LEAVES);
            event.accept(ModBlocks.ECHO_LOG);
            event.accept(ModBlocks.ECHO_WOOD);
            event.accept(ModBlocks.ECHO_PLANKS);
            event.accept(ModBlocks.STRIPPED_ECHO_LOG);
            event.accept(ModBlocks.STRIPPED_ECHO_WOOD);
            event.accept(ModBlocks.ECHO_SAPLING);
            event.accept(ModBlocks.SCULK_GLEAM);
            event.accept(ModBlocks.ECHO_SOIL);

            event.accept(ModBlocks.MYSTICSHROOM);
            event.accept(ModBlocks.MYSTIC_GLOWFLOWER);
            event.accept(ModBlocks.ICY_IRIS);

            event.accept(ModBlocks.MAGIC_STAIRS.get());
            event.accept(ModBlocks.MAGIC_SLAB.get());
            event.accept(ModBlocks.MAGIC_BUTTON.get());
            event.accept(ModBlocks.MAGIC_PRESSURE_PLATE.get());
            event.accept(ModBlocks.MAGIC_FENCE.get());
            event.accept(ModBlocks.MAGIC_FENCE_GATE.get());
            event.accept(ModBlocks.MAGIC_WALL.get());
            event.accept(ModBlocks.MAGIC_DOOR.get());
            event.accept(ModBlocks.MAGIC_TRAPDOOR.get());

            event.accept(ModBlocks.ASH_STAIRS.get());
            event.accept(ModBlocks.ASH_SLAB.get());
            event.accept(ModBlocks.ASH_BUTTON.get());
            event.accept(ModBlocks.ASH_PRESSURE_PLATE.get());
            event.accept(ModBlocks.ASH_FENCE.get());
            event.accept(ModBlocks.ASH_FENCE_GATE.get());
            event.accept(ModBlocks.ASH_WALL.get());
            event.accept(ModBlocks.ASH_DOOR.get());
            event.accept(ModBlocks.ASH_TRAPDOOR.get());

            event.accept(ModBlocks.WILLOW_STAIRS.get());
            event.accept(ModBlocks.WILLOW_SLAB.get());
            event.accept(ModBlocks.WILLOW_BUTTON.get());
            event.accept(ModBlocks.WILLOW_PRESSURE_PLATE.get());
            event.accept(ModBlocks.WILLOW_FENCE.get());
            event.accept(ModBlocks.WILLOW_FENCE_GATE.get());
            event.accept(ModBlocks.WILLOW_WALL.get());
            event.accept(ModBlocks.WILLOW_DOOR.get());
            event.accept(ModBlocks.WILLOW_TRAPDOOR.get());

            event.accept(ModBlocks.PALM_STAIRS.get());
            event.accept(ModBlocks.PALM_SLAB.get());
            event.accept(ModBlocks.PALM_BUTTON.get());
            event.accept(ModBlocks.PALM_PRESSURE_PLATE.get());
            event.accept(ModBlocks.PALM_FENCE.get());
            event.accept(ModBlocks.PALM_FENCE_GATE.get());
            event.accept(ModBlocks.PALM_WALL.get());
            event.accept(ModBlocks.PALM_DOOR.get());
            event.accept(ModBlocks.PALM_TRAPDOOR.get());

            event.accept(ModBlocks.ECHO_STAIRS.get());
            event.accept(ModBlocks.ECHO_SLAB.get());
            event.accept(ModBlocks.ECHO_BUTTON.get());
            event.accept(ModBlocks.ECHO_PRESSURE_PLATE.get());
            event.accept(ModBlocks.ECHO_FENCE.get());
            event.accept(ModBlocks.ECHO_FENCE_GATE.get());
            event.accept(ModBlocks.ECHO_WALL.get());
            event.accept(ModBlocks.ECHO_DOOR.get());
            event.accept(ModBlocks.ECHO_TRAPDOOR.get());

            event.accept(ModBlocks.WHITE_SAND);
            //event.accept(ModBlocks.WHITE_SUSPICIOUS_SAND);
            event.accept(ModBlocks.WHITE_SANDSTONE.get());
            event.accept(ModBlocks.SMOOTH_WHITE_SANDSTONE.get());
            event.accept(ModBlocks.CHISELED_WHITE_SANDSTONE.get());

            event.accept(ModBlocks.SCULK_STONE);
            event.accept(ModBlocks.SCULK_STONE_STAIRS);
            event.accept(ModBlocks.SCULK_STONE_SLAB);
            event.accept(ModBlocks.SCULK_STONE_WALL);
            event.accept(ModBlocks.SCULK_STONE_PRESSURE_PLATE);
            event.accept(ModBlocks.SCULK_STONE_BUTTON);
            event.accept(ModBlocks.COBBLED_SCULK_STONE);
            event.accept(ModBlocks.COBBLED_SCULK_STONE_STAIRS);
            event.accept(ModBlocks.COBBLED_SCULK_STONE_SLAB);
            event.accept(ModBlocks.COBBLED_SCULK_STONE_WALL);
            event.accept(ModBlocks.POLISHED_SCULK_STONE);
            event.accept(ModBlocks.POLISHED_SCULK_STONE_STAIRS);
            event.accept(ModBlocks.POLISHED_SCULK_STONE_SLAB);
            event.accept(ModBlocks.POLISHED_SCULK_STONE_WALL);
            event.accept(ModBlocks.SCULK_STONE_BRICKS);
            event.accept(ModBlocks.SCULK_STONE_BRICK_STAIRS);
            event.accept(ModBlocks.SCULK_STONE_BRICK_SLAB);
            event.accept(ModBlocks.SCULK_STONE_BRICK_WALL);
            event.accept(ModBlocks.SMOOTH_SCULK_STONE);
            event.accept(ModBlocks.SMOOTH_SCULK_STONE_STAIRS);
            event.accept(ModBlocks.SMOOTH_SCULK_STONE_SLAB);
            event.accept(ModBlocks.CHISELED_SCULK_STONE);

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
            event.accept(ModItems.ELEPHANT_SPAWN_EGG);
            event.accept(ModItems.RACCOON_SPAWN_EGG);
            event.accept(ModItems.LION_SPAWN_EGG);
            event.accept(ModItems.HIPPO_SPAWN_EGG);
            event.accept(ModItems.VULTURE_SPAWN_EGG);

        }

        if (event.getTab() == ModCreativeModeTabs.ELEGANT_EXPANSIONS_MISC.get()) {
            event.accept(ModItems.SHREK_THEME_MUSIC_DISC);
            event.accept(ModItems.MAGICAL_SAP_BUCKET);
            event.accept(ModItems.SHARK_TOOTH);
            event.accept(ModItems.ANCIENT_SCROLL);
            event.accept(ModBlocks.GOLD_CHAIN);
            event.accept(ModBlocks.LANTERN_OF_ANUBIS);
            event.accept(ModBlocks.EYE_OF_HORUS_GOLD);
            event.accept(ModBlocks.ANKH_GOLD);
            event.accept(ModBlocks.GLPYH_OF_ANUBIS_GOLD);
            event.accept(ModBlocks.ANUBIS_SUMMON_BLOCK);
            event.accept(ModBlocks.MYSTERIOUS_CUBE);
            event.accept(ModBlocks.DISPLAY_CASE);


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
            event.accept(ModBlocks.SAP_EXTRACTOR);

            event.accept(ModBlocks.GEM_CUTTING_STATION);
            event.accept(ModBlocks.GEM_INFUSING_STATION);
            event.accept(ModBlocks.SHARD_CREATION_STATION);

            event.accept(ModItems.GEM_DETECTOR);
            event.accept(ModItems.DATA_TABLET);
            event.accept(ModItems.ALEXANDRITE_SHARD);
            event.accept(ModItems.ALEXANDRITE);

        }

        if (event.getTab() == ModCreativeModeTabs.ELEGANT_EXPANSIONS_TOOLS.get()) {
            event.accept(ModItems.ALEXANDRITE_PAXEL);
            event.accept(ModItems.ALEXANDRITE_PICKAXE);
            event.accept(ModItems.ALEXANDRITE_AXE);
            event.accept(ModItems.ALEXANDRITE_SHOVEL);
            event.accept(ModItems.ALEXANDRITE_HOE);
            event.accept(ModItems.ALEXANDRITE_SWORD);
            event.accept(ModItems.STAFF_OF_MUMMIES);



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
            EntityRenderers.register(ModEntityTypes.ELEPHANT.get(), ElephantRenderer::new);
            EntityRenderers.register(ModEntityTypes.RACCOON.get(), RaccoonRenderer::new);
            EntityRenderers.register(ModEntityTypes.LION.get(), LionRenderer::new);
            EntityRenderers.register(ModEntityTypes.HIPPO.get(), HippoRenderer::new);
            EntityRenderers.register(ModEntityTypes.VULTURE.get(), VultureRenderer::new);
            EntityRenderers.register(ModEntityTypes.ECHO_SPIDER.get(), EchoSpiderRenderer::new);


            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GEM_CUTTING_STATION.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GEM_INFUSING_STATION.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SHARD_CREATION_STATION.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SAP_EXTRACTOR.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_MAGICAL_SAP.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_MAGICAL_SAP.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LANTERN_OF_ANUBIS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GOLD_CHAIN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MYSTERIOUS_CUBE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.DISPLAY_CASE.get(), RenderType.cutout());



            MenuScreens.register(ModMenuTypes.GEM_CUTTING_STATION_MENU.get(), GemCuttingStationScreen::new);
            MenuScreens.register(ModMenuTypes.GEM_INFUSING_STATION_MENU.get(), GemInfusingStationScreen::new);
            MenuScreens.register(ModMenuTypes.SHARD_CREATION_STATION_MENU.get(), ShardCreationStationScreen::new);
            MenuScreens.register(ModMenuTypes.DISPLAY_CASE_MENU.get(), DisplayCaseScreen::new);
            MenuScreens.register(ModMenuTypes.SAP_EXTRACTOR_MENU.get(), SapExtractorScreen::new);
        }
}
    }

