package net.adam.elegantexpansions.worldgen.biome;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.worldgen.biome.custom.ModOverworldRegion;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {

    public static void registerRegions() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(ElegantExpansions.MOD_ID, "overworld"), 20));
    }
}
