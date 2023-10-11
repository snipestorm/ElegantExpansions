package net.adam.elegantexpansions.worldgen.biome.surface;

import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.worldgen.biome.ModBiomes;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource WHITE_SAND = makeStateRule(ModBlocks.WHITE_SAND.get());
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource SCULKSTONE = makeStateRule(ModBlocks.SCULK_STONE.get());
    private static final SurfaceRules.RuleSource ECHO = makeStateRule(ModBlocks.ECHO_SOIL.get());
    private static final SurfaceRules.RuleSource WHITE_SANDSTONE = makeStateRule(ModBlocks.WHITE_SANDSTONE.get());
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);



    public static SurfaceRules.RuleSource makeRules() {

        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        SurfaceRules.RuleSource ancientSands = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, WHITE_SAND),SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,  WHITE_SAND), SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, WHITE_SANDSTONE), SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, STONE));

        return SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.ANCIENT_SANDS),ancientSands),
                // Default to a grass and dirt surface
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        );
    }
    public static SurfaceRules.RuleSource netherRules() {
        SurfaceRules.RuleSource echo = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK), SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), BEDROCK),SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,ECHO),SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,ECHO), SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SCULKSTONE), SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SCULKSTONE),SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SCULKSTONE), SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, ECHO));
        return SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.ECHOING_WASTES),echo);

    }



    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}