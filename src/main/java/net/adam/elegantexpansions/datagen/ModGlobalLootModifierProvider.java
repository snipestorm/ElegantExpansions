package net.adam.elegantexpansions.datagen;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.item.ModItems;
import net.adam.elegantexpansions.loot.AddItemModifier;
import net.adam.elegantexpansions.loot.AddSusSandItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, ElegantExpansions.MOD_ID);
    }

    @Override
    protected void start() {

        add("warden_upgrade_from_ancient_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.55f).build()},
                ModItems.WARDEN_UPGRADE_TEMPLATE.get()));

        add("heart_of_deep_from_warden", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/warden")).build() },
                ModItems.HEART_OF_THE_DEEP.get()));

        add("ancient_scroll_warm", new AddSusSandItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/ocean_ruin_warm")).build() },
                ModItems.ANCIENT_SCROLL.get()));

        add("ancient_scroll_cold", new AddSusSandItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/ocean_ruin_cold")).build() },
                ModItems.ANCIENT_SCROLL.get()));


    }
}
