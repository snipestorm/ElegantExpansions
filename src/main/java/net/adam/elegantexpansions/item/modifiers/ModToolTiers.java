package net.adam.elegantexpansions.item.modifiers;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.item.ModItems;
import net.adam.elegantexpansions.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {

    public static final Tier ALEXANDRITE = TierSortingRegistry.registerTier(
            new ForgeTier(5,2501,10f,5f,26,
                    ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL, () -> Ingredient.of(ModItems.ALEXANDRITE.get())),
            new ResourceLocation(ElegantExpansions.MOD_ID, "alexandrite"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier WARDEN = TierSortingRegistry.registerTier(
            new ForgeTier(6,3001,10f,6f,31,
                    ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL, () -> Ingredient.of(Items.ECHO_SHARD)),
            new ResourceLocation(ElegantExpansions.MOD_ID, "warden"), List.of(Tiers.NETHERITE), List.of());


}
