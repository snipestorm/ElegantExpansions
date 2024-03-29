package net.adam.elegantexpansions.recipe;

import net.adam.elegantexpansions.ElegantExpansions;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ElegantExpansions.MOD_ID);

    public static final RegistryObject<RecipeSerializer<GemCuttingStationRecipe>> GEM_CUTTING_SERIALIZER =
            SERIALIZERS.register("gem_cutting", () -> GemCuttingStationRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<GemInfusingRecipe>> GEM_INFUSING_SERIALIZER =
            SERIALIZERS.register("gem_infusing", () -> GemInfusingRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}