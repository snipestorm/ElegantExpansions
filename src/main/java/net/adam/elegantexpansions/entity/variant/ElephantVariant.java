package net.adam.elegantexpansions.entity.variant;

import net.adam.elegantexpansions.util.ModBiomeTags;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;

import java.util.Arrays;
import java.util.Comparator;

public enum ElephantVariant {
    GREY(0),
    BROWN(1);

    private static final ElephantVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ElephantVariant::getId)).toArray(ElephantVariant[]::new);
    private final int id;

    ElephantVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static ElephantVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

    public static ElephantVariant byBiome(Holder<Biome> biomeHolder) {
        return biomeHolder.is(ModBiomeTags.SPAWNS_JUNGLE_ELEPHANT) ? BROWN : GREY;
    }
}