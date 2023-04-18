package net.adam.elegantexpansions.worldgen.tree;

import net.adam.elegantexpansions.worldgen.ModConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class BananaTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_, boolean p_222911_) {
        return  p_222911_ ? ModConfiguredFeatures.BANANA_KEY : ModConfiguredFeatures.LARGE_BANANA_KEY;
    }
}
