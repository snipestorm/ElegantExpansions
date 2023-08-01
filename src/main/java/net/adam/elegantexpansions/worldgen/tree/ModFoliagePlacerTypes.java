package net.adam.elegantexpansions.worldgen.tree;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.worldgen.tree.custom.BananaFoliagePlacer;
import net.adam.elegantexpansions.worldgen.tree.custom.LargeBananaFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacerTypes {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, ElegantExpansions.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<BananaFoliagePlacer>> BANANA_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("banana_foliage_placer", () -> new FoliagePlacerType<>(BananaFoliagePlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<LargeBananaFoliagePlacer>> LARGE_BANANA_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("large_banana_foliage_placer", () -> new FoliagePlacerType<>(LargeBananaFoliagePlacer.CODEC));


    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}