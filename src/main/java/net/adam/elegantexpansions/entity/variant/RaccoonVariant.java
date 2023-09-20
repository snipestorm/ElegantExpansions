package net.adam.elegantexpansions.entity.variant;

import com.mojang.serialization.Codec;
import net.adam.elegantexpansions.util.ModBiomeTags;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.level.biome.Biome;

import java.util.Arrays;
import java.util.Comparator;

public enum RaccoonVariant implements StringRepresentable {
    GREY(0,"grey",true),
    BROWN(1,"brown",true),
    RED(2,"red",true),
    BLACK(3,"black",true),
    BLUE(4,"blue",true),
    WHITE(5,"blue",true),
    GOLD(6,"gold",false);

    private final int id;
    private final String name;
    private final boolean common;

    private static final RaccoonVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(RaccoonVariant::getId)).toArray(RaccoonVariant[]::new);


    RaccoonVariant(int id, String name, boolean common) {
        this.id = id;
        this.name =name;
        this.common = common;

    }

    public int getId() {
        return this.id;
    }

    public static RaccoonVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }


    public static RaccoonVariant getRareSpawnVariant(RandomSource randomSource) {
        return getSpawnVariant(randomSource, false);
    }

    private static RaccoonVariant getSpawnVariant(RandomSource random, boolean common) {
        RaccoonVariant[] raccoonvariants = Arrays.stream(values()).filter((variant) -> {
            return variant.common == common;
        }).toArray((variant2) -> {
            return new RaccoonVariant[variant2];
        });
        return Util.getRandom(raccoonvariants, random);
    }




    @Override
    public String getSerializedName() {
        return this.name;
    }

}