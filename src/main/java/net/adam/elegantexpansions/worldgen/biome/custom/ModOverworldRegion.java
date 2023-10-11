package net.adam.elegantexpansions.worldgen.biome.custom;

import com.mojang.datafixers.util.Pair;
import net.adam.elegantexpansions.worldgen.biome.ModBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
    public ModOverworldRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint,
            ResourceKey<Biome>>> mapper) {


        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FOREST, ModBiomes.MYSTICAL_FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.DESERT, ModBiomes.ANCIENT_SANDS);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FLOWER_FOREST, ModBiomes.ASH_FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.BIRCH_FOREST, ModBiomes.MAPLE_FOREST);
        });
    }
}
