package net.adam.elegantexpansions.worldgen;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.util.ModTags;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.grower.BirchTreeGrower;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TREE_MAGIC = registerKey("add_tree_magic");
    public static final ResourceKey<BiomeModifier> ADD_TREE_ASH = registerKey("add_tree_ash");
    public static final ResourceKey<BiomeModifier> ADD_TREE_BURNT_ASH = registerKey("add_tree_burnt_ash");
    public static final ResourceKey<BiomeModifier> ADD_TREE_WILLOW = registerKey("add_tree_willow");
    public static final ResourceKey<BiomeModifier> ADD_TREE_BANANA = registerKey("add_tree_banana");
    public static final ResourceKey<BiomeModifier> ADD_TREE_MAPLE = registerKey("add_tree_maple");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TREE_MAGIC, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BIRCH_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MAGIC_PLACED_KEY), placedFeatures.getOrThrow(ModPlacedFeatures.LARGE_MAGIC_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_ASH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.TAIGA)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ASH_PLACED_KEY), placedFeatures.getOrThrow(ModPlacedFeatures.LARGE_ASH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_BURNT_ASH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SAVANNA)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BURNT_ASH_PLACED_KEY), placedFeatures.getOrThrow(ModPlacedFeatures.LARGE_BURNT_ASH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_WILLOW, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SWAMP)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.WILLOW_PLACED_KEY), placedFeatures.getOrThrow(ModPlacedFeatures.LARGE_WILLOW_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_BANANA, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.JUNGLE)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BANANA_PLACED_KEY), placedFeatures.getOrThrow(ModPlacedFeatures.LARGE_BANANA_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_MAPLE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST), biomes.getOrThrow(Biomes.FLOWER_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MAPLE_PLACED_KEY), placedFeatures.getOrThrow(ModPlacedFeatures.LARGE_MAPLE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));



    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(ElegantExpansions.MOD_ID, name));
    }
}