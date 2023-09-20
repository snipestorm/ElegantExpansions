package net.adam.elegantexpansions.util;

import net.adam.elegantexpansions.ElegantExpansions;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ModBiomeTags {

    public static final TagKey<Biome> SPAWNS_JUNGLE_ELEPHANT = tag("spawns_jungle_elephant");
    public static final TagKey<Biome> SPAWNS_BROWN_RACCOON = tag("spawns_brown_raccoon");
    public static final TagKey<Biome> SPAWNS_RED_RACCOON = tag("spawns_red_raccoon");
    public static final TagKey<Biome> SPAWNS_BLACK_RACCOON = tag("spawns_black_raccoon");
    public static final TagKey<Biome> SPAWNS_BLUE_RACCOON = tag("spawns_blue_raccoon");
    public static final TagKey<Biome> SPAWNS_WHITE_RACCOON = tag("spawns_white_raccoon");





    private static TagKey<Biome> tag(String name) {
        return ModBiomeTags.create(String.valueOf(new ResourceLocation(ElegantExpansions.MOD_ID, name)));
    }

    private static TagKey<Biome> forgeTag(String name) {
        return ModBiomeTags.create(String.valueOf(new ResourceLocation("forge", name)));
    }
    private ModBiomeTags() {
    }
    private static TagKey<Biome> create(String name) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(name));
    }
}
