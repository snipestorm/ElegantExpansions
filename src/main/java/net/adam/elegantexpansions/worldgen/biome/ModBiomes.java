package net.adam.elegantexpansions.worldgen.biome;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.ModEntityTypes;
import net.adam.elegantexpansions.particle.ModParticles;
import net.adam.elegantexpansions.worldgen.ModPlacedFeatures;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

import static net.minecraft.data.worldgen.BiomeDefaultFeatures.caveSpawns;
import static net.minecraft.data.worldgen.BiomeDefaultFeatures.monsters;

public class ModBiomes {

    public static final ResourceKey<Biome> MYSTICAL_FOREST = register ("mystical_forest");
    public static final ResourceKey<Biome> ANCIENT_SANDS = register ("ancient_sands");

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(MYSTICAL_FOREST, mysticalForest (context));
        context.register(ANCIENT_SANDS, ancientSands (context));
    }
    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);

    }



    public static Biome mysticalForest(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addForestGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);








        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_SUGAR_CANE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.MAGIC_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_MAGIC_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x6a32c9)
                        .waterFogColor(0x402470)
                        .skyColor(0x9429f2)
                        .grassColorOverride(0x35599c)
                        .foliageColorOverride(0x35599c)
                        .fogColor(0x22a1e6)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_GROVE))
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.ELECTRIC_SPARK, 0.018093334F))
                       // .ambientParticle(new AmbientParticleSettings(ModParticles.SAND_ASH_PARTICLE.get(), 1F))
                        .build())
                        .build();
    }


    public static Biome ancientSands(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        caveSpawns(spawnBuilder);
        monsters(spawnBuilder, 19, 1, 100, false);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntityTypes.MUMMY.get(), 80, 4, 4));


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDesertVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraDecoration(biomeBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.0f)
                .temperature(2f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .skyColor(7254527)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT))
                        .ambientParticle(new AmbientParticleSettings(ModParticles.SAND_ASH_PARTICLE.get(), 1F))
                        .build())
                .build();
    }





    public static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(ElegantExpansions.MOD_ID, name));
    }
}
