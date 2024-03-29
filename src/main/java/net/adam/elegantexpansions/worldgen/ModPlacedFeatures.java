package net.adam.elegantexpansions.worldgen;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> MAGIC_PLACED_KEY = createKey("magic_placed");
    public static final ResourceKey<PlacedFeature> LARGE_MAGIC_PLACED_KEY = createKey("large_magic_placed");
    public static final ResourceKey<PlacedFeature> WILLOW_PLACED_KEY = createKey("willow_placed");
    public static final ResourceKey<PlacedFeature> LARGE_WILLOW_PLACED_KEY = createKey("large_willow_placed");
    public static final ResourceKey<PlacedFeature> MAPLE_PLACED_KEY = createKey("maple_placed");
    public static final ResourceKey<PlacedFeature> LARGE_MAPLE_PLACED_KEY = createKey("large_maple_placed");
    public static final ResourceKey<PlacedFeature> ASH_PLACED_KEY = createKey("ash_placed");
    public static final ResourceKey<PlacedFeature> LARGE_ASH_PLACED_KEY = createKey("large_ash_placed");
    public static final ResourceKey<PlacedFeature> BURNT_ASH_PLACED_KEY = createKey("burnt_ash_placed");
    public static final ResourceKey<PlacedFeature> LARGE_BURNT_ASH_PLACED_KEY = createKey("burnt_large_ash_placed");
    public static final ResourceKey<PlacedFeature> BANANA_PLACED_KEY = createKey("banana_placed");
    public static final ResourceKey<PlacedFeature> LARGE_BANANA_PLACED_KEY = createKey("large_banana_placed");

    public static final ResourceKey<PlacedFeature> OVERWORLD_RUBY_ORE_PLACED_KEY = createKey("ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> OVERWORLD_SAPPHIRE_ORE_PLACED_KEY = createKey("sapphire_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_CITRINE_ORE_PLACED_KEY = createKey("nether_citrine_ore_placed");
    public static final ResourceKey<PlacedFeature> END_TANZANITE_ORE_PLACED_KEY = createKey("end_tanzanite_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, OVERWORLD_RUBY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_RUBY_ORE_KEY),
                ModOrePlacement.commonOrePlacement(4,
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, OVERWORLD_SAPPHIRE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SAPPHIRE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(4,
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, NETHER_CITRINE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_CITRINE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(2,
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-2), VerticalAnchor.aboveBottom(50))));
        register(context, END_TANZANITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_TANZANITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(2,
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(25), VerticalAnchor.aboveBottom(65))));

        register(context, MAGIC_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MAGIC_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2), ModBlocks.MAGIC_SAPLING.get()));

        register(context, LARGE_MAGIC_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LARGE_MAGIC_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 2), ModBlocks.MAGIC_SAPLING.get()));

        register(context, MAPLE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MAPLE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2), ModBlocks.MAPLE_SAPLING.get()));

        register(context, LARGE_MAPLE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LARGE_MAPLE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 2), ModBlocks.MAPLE_SAPLING.get()));

        register(context, WILLOW_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WILLOW_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.1f, 2), ModBlocks.WILLOW_SAPLING.get()));

        register(context, LARGE_WILLOW_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LARGE_WILLOW_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 2), ModBlocks.WILLOW_SAPLING.get()));

        register(context, ASH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ASH_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.1f, 2), ModBlocks.ASH_SAPLING.get()));

        register(context, LARGE_ASH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LARGE_ASH_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 2), ModBlocks.ASH_SAPLING.get()));

        register(context, BURNT_ASH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BURNT_ASH_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.1f, 2), ModBlocks.ASH_SAPLING.get()));

        register(context, LARGE_BURNT_ASH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BURNT_LARGE_ASH_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 2), ModBlocks.ASH_SAPLING.get()));

        register(context, BANANA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BANANA_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2), ModBlocks.BANANA_SAPLING.get()));

        register(context, LARGE_BANANA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LARGE_BANANA_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 2), ModBlocks.BANANA_SAPLING.get()));

    }


    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ElegantExpansions.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }


}
