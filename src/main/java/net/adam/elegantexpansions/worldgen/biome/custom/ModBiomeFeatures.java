package net.adam.elegantexpansions.worldgen.biome.custom;

import net.adam.elegantexpansions.worldgen.ModPlacedFeatures;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomeFeatures {
    public static void addMysticFlowers(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.MYSTICSHROOM_PLACED_KEY);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.MYSTIC_GLOWFLOWER_PLACED_KEY);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.ICY_IRIS_PLACED_KEY);
    }

    public static void addEEOres(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.OVERWORLD_ALEXANDRITE_ORE_PLACED_KEY);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.OVERWORLD_RUBY_ORE_PLACED_KEY);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.OVERWORLD_SAPPHIRE_ORE_PLACED_KEY);

    }

}
