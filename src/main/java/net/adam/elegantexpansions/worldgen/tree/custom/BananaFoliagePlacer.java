package net.adam.elegantexpansions.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.adam.elegantexpansions.worldgen.tree.ModFoliagePlacerTypes;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class BananaFoliagePlacer extends FoliagePlacer {
    public static final Codec<BananaFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) -> foliagePlacerParts(instance)
            .and(Codec.intRange(0,16).fieldOf("height").forGetter(fp -> fp.height)).apply(instance, BananaFoliagePlacer::new));

    protected final int height;

    public BananaFoliagePlacer(IntProvider p_161411_, IntProvider p_161412_, int height) {
        super(p_161411_, p_161412_);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacerTypes.BANANA_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter foliageSetter, RandomSource pRandom, TreeConfiguration pConfig, int maxFreeTreeHeight,
                                 FoliagePlacer.FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {

        for(int i = 0; i < 2; i++) {
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().above(i));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().relative(Direction.EAST,1));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().relative(Direction.EAST,2));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(1).relative(Direction.EAST,1));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(1).relative(Direction.EAST,2));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(2).relative(Direction.EAST,2));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(2).relative(Direction.EAST,3));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(3).relative(Direction.EAST,3));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(4).relative(Direction.EAST,3));

            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().relative(Direction.WEST,1));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().relative(Direction.WEST,2));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(1).relative(Direction.WEST,1));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(1).relative(Direction.WEST,2));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(2).relative(Direction.WEST,2));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(2).relative(Direction.WEST,3));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(3).relative(Direction.WEST,3));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(4).relative(Direction.WEST,3));

            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().relative(Direction.NORTH,1));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().relative(Direction.NORTH,2));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(1).relative(Direction.NORTH,1));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(1).relative(Direction.NORTH,2));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(2).relative(Direction.NORTH,2));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(2).relative(Direction.NORTH,3));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(3).relative(Direction.NORTH,3));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(4).relative(Direction.NORTH,3));

            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().relative(Direction.SOUTH,1));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().relative(Direction.SOUTH,2));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(1).relative(Direction.SOUTH,1));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(1).relative(Direction.SOUTH,2));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(2).relative(Direction.SOUTH,2));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(2).relative(Direction.SOUTH,3));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(3).relative(Direction.SOUTH,3));
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,  attachment.pos().below(4).relative(Direction.SOUTH,3));



        }



    }

    @Override
    public int foliageHeight(RandomSource p_225601_, int p_225602_, TreeConfiguration p_225603_) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource p_225595_, int p_225596_, int p_225597_, int p_225598_, int p_225599_, boolean p_225600_) {
        return false;
    }
}
