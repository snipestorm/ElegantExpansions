package net.adam.elegantexpansions.worldgen;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.worldgen.tree.custom.BananaFoliagePlacer;
import net.adam.elegantexpansions.worldgen.tree.custom.LargeBananaFoliagePlacer;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.UpwardsBranchingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;


public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAGIC_KEY = registerKey("magic");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_MAGIC_KEY = registerKey("large_magic");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_KEY = registerKey("willow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_WILLOW_KEY = registerKey("large_willow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_KEY = registerKey("maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_MAPLE_KEY = registerKey("large_maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASH_KEY = registerKey("ash");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_ASH_KEY = registerKey("large_ash");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BURNT_ASH_KEY = registerKey("burnt_ash");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BURNT_LARGE_ASH_KEY = registerKey("burnt_large_ash");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BANANA_KEY = registerKey("banana");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_BANANA_KEY = registerKey("large_banana");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_CITRINE_ORE_KEY = registerKey("nether_citrine_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_TANZANITE_ORE_KEY = registerKey("end_tanzanite_ore");


    public static final ResourceKey<ConfiguredFeature<?, ?>> MYSTICSHROOM_KEY = registerKey("mysticshroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MYSTIC_GLOWFLOWER_KEY = registerKey("mystic_glowflower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ICY_IRIS_KEY = registerKey("icy_iris");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceabeles = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceabeles = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceabeles = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceabeles = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldRubyOres = List.of(OreConfiguration.target(stoneReplaceabeles,
                        ModBlocks.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldSapphireOres = List.of(OreConfiguration.target(stoneReplaceabeles,
                        ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRubyOres, 7));
        register(context, OVERWORLD_SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSapphireOres, 7));
        register(context, NETHER_CITRINE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceabeles,
                ModBlocks.NETHER_CITRINE_ORE.get().defaultBlockState(), 5));
        register(context, END_TANZANITE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceabeles,
                ModBlocks.ENDSTONE_TANZANITE_ORE.get().defaultBlockState(), 3));

        register(context, MYSTICSHROOM_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(64, 6,2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MYSTICSHROOM.get())))));

        register(context, MYSTIC_GLOWFLOWER_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(16, 6,2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MYSTIC_GLOWFLOWER.get())))));

        register(context, ICY_IRIS_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6,2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ICY_IRIS.get())))));


        HolderGetter<Block> holdergetter = context.lookup(Registries.BLOCK);


        register(context, MAGIC_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.MAGIC_LOG.get()),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(ModBlocks.MAGIC_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, LARGE_MAGIC_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.MAGIC_LOG.get()),
                new FancyTrunkPlacer(3, 11, 0),
                BlockStateProvider.simple(ModBlocks.MAGIC_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0)).build());

        register(context, MAPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                new StraightTrunkPlacer(5, 2, 0),
                BlockStateProvider.simple(ModBlocks.MAPLE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, LARGE_MAPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                new FancyTrunkPlacer(3, 11, 0),
                BlockStateProvider.simple(ModBlocks.MAPLE_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0)).build());


        register(context, WILLOW_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.WILLOW_LOG.get()),
                new UpwardsBranchingTrunkPlacer(3,1,4, UniformInt.of(1,4),0.5F, UniformInt.of(0,1),holdergetter.getOrThrow(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH)),
                        BlockStateProvider.simple(ModBlocks.WILLOW_LEAVES.get()),
                new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2),70),
                new TwoLayersFeatureSize(2, 0, 2)).decorators(List.of(new LeaveVineDecorator(0.125F))).build());

        register(context, LARGE_WILLOW_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.WILLOW_LOG.get()),
                new UpwardsBranchingTrunkPlacer(5,1,9, UniformInt.of(1,6),0.5F, UniformInt.of(0,1),holdergetter.getOrThrow(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH)),
                BlockStateProvider.simple(ModBlocks.WILLOW_LEAVES.get()),
                new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2),70),
                new TwoLayersFeatureSize(3, 0, 2)).decorators(List.of(new LeaveVineDecorator(0.125F))).build());

        register(context, ASH_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ASH_LOG.get()),
                new StraightTrunkPlacer(5, 2, 0),
                BlockStateProvider.simple(ModBlocks.ASH_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, LARGE_ASH_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ASH_LOG.get()),
                new FancyTrunkPlacer(3, 11, 0),
                BlockStateProvider.simple(ModBlocks.ASH_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0)).build());

        register(context, BURNT_ASH_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ASH_LOG.get()),
                new StraightTrunkPlacer(5, 2, 0),
                BlockStateProvider.simple(ModBlocks.ASH_LEAVES.get()),
                new  RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2),0),
                new TwoLayersFeatureSize(2, 0, 2)).build());

        register(context, BURNT_LARGE_ASH_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ASH_LOG.get()),
                new FancyTrunkPlacer(3, 11, 0),
                BlockStateProvider.simple(ModBlocks.ASH_LEAVES.get()),
                new  RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2),0),
                new TwoLayersFeatureSize(0, 0, 0)).build());


        register(context, BANANA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.BANANA_LOG.get()),
                new StraightTrunkPlacer(5, 2, 0),
                BlockStateProvider.simple(ModBlocks.BANANA_LEAVES.get()),
                new BananaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2),
                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(Blocks.SAND)).build());

        register(context, LARGE_BANANA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.BANANA_LOG.get()),
                new StraightTrunkPlacer(10, 2, 0),
                BlockStateProvider.simple(ModBlocks.BANANA_LEAVES.get()),
                new LargeBananaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2),
                new TwoLayersFeatureSize(0, 0, 0)).dirt(BlockStateProvider.simple(Blocks.SAND)).build());

    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ElegantExpansions.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}


