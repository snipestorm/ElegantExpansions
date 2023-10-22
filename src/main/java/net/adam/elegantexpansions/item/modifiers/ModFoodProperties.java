package net.adam.elegantexpansions.item.modifiers;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties EXOTIC_MEAT = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.3f).meat().build();

    public static final FoodProperties COOKED_EXOTIC_MEAT = new FoodProperties.Builder()
            .nutrition(10).saturationMod(1.0f).meat().build();

    public static final FoodProperties LARGE_CAT_MEAT = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.3f).meat().build();

    public static final FoodProperties COOKED_LARGE_CAT_MEAT = new FoodProperties.Builder()
            .nutrition(9).saturationMod(0.9f).meat().build();
}
