package net.adam.elegantexpansions.datagen;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.item.ModItems;
import net.adam.elegantexpansions.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY.get(), RecipeCategory.MISC,
                ModBlocks.RUBY_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.SAPPHIRE.get(), RecipeCategory.MISC,
                ModBlocks.SAPPHIRE_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.CITRINE.get(), RecipeCategory.MISC,
                ModBlocks.CITRINE_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.TANZANITE.get(), RecipeCategory.MISC,
                ModBlocks.TANZANITE_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.ONYX.get(), RecipeCategory.MISC,
                ModBlocks.ONYX_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.ALEXANDRITE.get(), RecipeCategory.MISC,
                ModBlocks.ALEXANDRITE_BLOCK.get());


        planksFromLogs(consumer, ModBlocks.MAGIC_PLANKS.get().asItem(), ModTags.Items.MAGIC_LOGS, 4);
        planksFromLogs(consumer, ModBlocks.ASH_PLANKS.get().asItem(), ModTags.Items.ASH_LOGS, 4);
        planksFromLogs(consumer, ModBlocks.WILLOW_PLANKS.get().asItem(), ModTags.Items.WILLOW_LOGS, 4);
        planksFromLogs(consumer, ModBlocks.ECHO_PLANKS.get().asItem(), ModTags.Items.ECHO_LOGS, 4);
        planksFromLogs(consumer, ModBlocks.BANANA_PLANKS.get().asItem(), ModTags.Items.PALM_LOGS, 4);

        woodFromLogs(consumer, ModBlocks.ASH_WOOD.get().asItem(), ModBlocks.ASH_LOG.get().asItem());
        woodFromLogs(consumer, ModBlocks.MAGIC_WOOD.get().asItem(), ModBlocks.MAGIC_LOG.get().asItem());
        woodFromLogs(consumer, ModBlocks.WILLOW_WOOD.get().asItem(), ModBlocks.WILLOW_LOG.get().asItem());
        woodFromLogs(consumer, ModBlocks.ECHO_WOOD.get().asItem(), ModBlocks.ECHO_LOG.get().asItem());
        woodFromLogs(consumer, ModBlocks.BANANA_WOOD.get().asItem(), ModBlocks.BANANA_LOG.get().asItem());


        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_STONE_SLAB.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_SCULK_STONE_SLAB.get().asItem(), ModBlocks.SMOOTH_SCULK_STONE.get().asItem());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_SCULK_STONE_SLAB.get().asItem(), ModBlocks.COBBLED_SCULK_STONE.get().asItem());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_SCULK_STONE_SLAB.get().asItem(), ModBlocks.POLISHED_SCULK_STONE.get().asItem());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_STONE_BRICK_SLAB.get().asItem(), ModBlocks.SCULK_STONE_BRICKS.get().asItem());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASH_SLAB.get().asItem(), ModBlocks.ASH_PLANKS.get().asItem());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGIC_SLAB.get().asItem(), ModBlocks.MAGIC_PLANKS.get().asItem());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECHO_SLAB.get().asItem(), ModBlocks.ECHO_PLANKS.get().asItem());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WILLOW_SLAB.get().asItem(), ModBlocks.WILLOW_PLANKS.get().asItem());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_SLAB.get().asItem(), ModBlocks.BANANA_PLANKS.get().asItem());

        stair(consumer, ModBlocks.SCULK_STONE_STAIRS.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        stair(consumer, ModBlocks.COBBLED_SCULK_STONE_STAIRS.get().asItem(), ModBlocks.CHISELED_SCULK_STONE.get().asItem());
        stair(consumer, ModBlocks.POLISHED_SCULK_STONE_STAIRS.get().asItem(), ModBlocks.POLISHED_SCULK_STONE.get().asItem());
        stair(consumer, ModBlocks.SMOOTH_SCULK_STONE_STAIRS.get().asItem(), ModBlocks.SMOOTH_SCULK_STONE.get().asItem());
        stair(consumer, ModBlocks.SCULK_STONE_BRICK_STAIRS.get().asItem(), ModBlocks.SCULK_STONE_BRICKS.get().asItem());
        stair(consumer, ModBlocks.ASH_STAIRS.get().asItem(), ModBlocks.ASH_PLANKS.get().asItem());
        stair(consumer, ModBlocks.MAGIC_STAIRS.get().asItem(), ModBlocks.MAGIC_PLANKS.get().asItem());
        stair(consumer, ModBlocks.WILLOW_STAIRS.get().asItem(), ModBlocks.WILLOW_PLANKS.get().asItem());
        stair(consumer, ModBlocks.ECHO_STAIRS.get().asItem(), ModBlocks.ECHO_PLANKS.get().asItem());
        stair(consumer, ModBlocks.PALM_STAIRS.get().asItem(), ModBlocks.BANANA_PLANKS.get().asItem());

        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_STONE_WALL.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_SCULK_STONE_WALL.get().asItem(), ModBlocks.COBBLED_SCULK_STONE.get().asItem());
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_SCULK_STONE_WALL.get().asItem(), ModBlocks.POLISHED_SCULK_STONE.get().asItem());
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_STONE_BRICK_WALL.get().asItem(), ModBlocks.SCULK_STONE_BRICKS.get().asItem());
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASH_WALL.get().asItem(), ModBlocks.ASH_PLANKS.get().asItem());
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGIC_WALL.get().asItem(), ModBlocks.MAGIC_PLANKS.get().asItem());
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WILLOW_WALL.get().asItem(), ModBlocks.WILLOW_PLANKS.get().asItem());
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECHO_WALL.get().asItem(), ModBlocks.ECHO_PLANKS.get().asItem());
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_WALL.get().asItem(), ModBlocks.BANANA_PLANKS.get().asItem());

        fence(consumer, ModBlocks.ASH_FENCE.get().asItem(), ModBlocks.ASH_PLANKS.get().asItem());
        fence(consumer, ModBlocks.MAGIC_FENCE.get().asItem(), ModBlocks.MAGIC_PLANKS.get().asItem());
        fence(consumer, ModBlocks.WILLOW_FENCE.get().asItem(), ModBlocks.WILLOW_PLANKS.get().asItem());
        fence(consumer, ModBlocks.ECHO_FENCE.get().asItem(), ModBlocks.ECHO_PLANKS.get().asItem());
        fence(consumer, ModBlocks.PALM_FENCE.get().asItem(), ModBlocks.BANANA_PLANKS.get().asItem());

        fencegate(consumer, ModBlocks.ASH_FENCE_GATE.get().asItem(), ModBlocks.ASH_PLANKS.get().asItem());
        fencegate(consumer, ModBlocks.MAGIC_FENCE_GATE.get().asItem(), ModBlocks.MAGIC_PLANKS.get().asItem());
        fencegate(consumer, ModBlocks.WILLOW_FENCE_GATE.get().asItem(), ModBlocks.WILLOW_PLANKS.get().asItem());
        fencegate(consumer, ModBlocks.ECHO_FENCE_GATE.get().asItem(), ModBlocks.ECHO_PLANKS.get().asItem());
        fencegate(consumer, ModBlocks.PALM_FENCE_GATE.get().asItem(), ModBlocks.BANANA_PLANKS.get().asItem());

        button(consumer, ModBlocks.SCULK_STONE_BUTTON.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        button(consumer, ModBlocks.ASH_BUTTON.get().asItem(), ModBlocks.ASH_PLANKS.get().asItem());
        button(consumer, ModBlocks.MAGIC_BUTTON.get().asItem(), ModBlocks.MAGIC_PLANKS.get().asItem());
        button(consumer, ModBlocks.WILLOW_BUTTON.get().asItem(), ModBlocks.WILLOW_PLANKS.get().asItem());
        button(consumer, ModBlocks.ECHO_BUTTON.get().asItem(), ModBlocks.ECHO_PLANKS.get().asItem());
        button(consumer, ModBlocks.PALM_BUTTON.get().asItem(), ModBlocks.BANANA_PLANKS.get().asItem());

        pressurePlate(consumer, ModBlocks.SCULK_STONE_PRESSURE_PLATE.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        pressurePlate(consumer, ModBlocks.ASH_PRESSURE_PLATE.get().asItem(), ModBlocks.ASH_PLANKS.get().asItem());
        pressurePlate(consumer, ModBlocks.MAGIC_PRESSURE_PLATE.get().asItem(), ModBlocks.MAGIC_PLANKS.get().asItem());
        pressurePlate(consumer, ModBlocks.WILLOW_PRESSURE_PLATE.get().asItem(), ModBlocks.WILLOW_PLANKS.get().asItem());
        pressurePlate(consumer, ModBlocks.ECHO_PRESSURE_PLATE.get().asItem(), ModBlocks.ECHO_PLANKS.get().asItem());
        pressurePlate(consumer, ModBlocks.PALM_PRESSURE_PLATE.get().asItem(), ModBlocks.BANANA_PLANKS.get().asItem());

        door(consumer, ModBlocks.ASH_DOOR.get().asItem(), ModBlocks.ASH_PLANKS.get().asItem());
        door(consumer, ModBlocks.MAGIC_DOOR.get().asItem(), ModBlocks.MAGIC_PLANKS.get().asItem());
        door(consumer, ModBlocks.WILLOW_DOOR.get().asItem(), ModBlocks.WILLOW_PLANKS.get().asItem());
        door(consumer, ModBlocks.ECHO_DOOR.get().asItem(), ModBlocks.ECHO_PLANKS.get().asItem());
        door(consumer, ModBlocks.PALM_DOOR.get().asItem(), ModBlocks.BANANA_PLANKS.get().asItem());

        trapdoor(consumer, ModBlocks.ASH_TRAPDOOR.get().asItem(), ModBlocks.ASH_PLANKS.get().asItem());
        trapdoor(consumer, ModBlocks.MAGIC_TRAPDOOR.get().asItem(), ModBlocks.MAGIC_PLANKS.get().asItem());
        trapdoor(consumer, ModBlocks.WILLOW_TRAPDOOR.get().asItem(), ModBlocks.WILLOW_PLANKS.get().asItem());
        trapdoor(consumer, ModBlocks.ECHO_TRAPDOOR.get().asItem(), ModBlocks.ECHO_PLANKS.get().asItem());
        trapdoor(consumer, ModBlocks.PALM_TRAPDOOR.get().asItem(), ModBlocks.BANANA_PLANKS.get().asItem());


        smeltingResultFromBase(consumer, ModBlocks.SCULK_STONE.get().asItem(), ModBlocks.COBBLED_SCULK_STONE.get().asItem());
        smeltingResultFromBase(consumer, ModBlocks.SMOOTH_SCULK_STONE.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        smeltingResultFromBase(consumer, Blocks.GLASS.asItem(), ModBlocks.WHITE_SAND.get().asItem());



        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_STONE_STAIRS.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_STONE_SLAB.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_STONE_WALL.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_STONE_BRICKS.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_STONE_BRICK_SLAB.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_STONE_BRICK_STAIRS.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_STONE_BRICK_WALL.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_SCULK_STONE.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_SCULK_STONE_SLAB.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_SCULK_STONE_STAIRS.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_SCULK_STONE_WALL.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_SCULK_STONE.get().asItem(), ModBlocks.SCULK_STONE.get().asItem());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_SCULK_STONE_STAIRS.get().asItem(), ModBlocks.COBBLED_SCULK_STONE.get().asItem());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_SCULK_STONE_SLAB.get().asItem(), ModBlocks.COBBLED_SCULK_STONE.get().asItem());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_SCULK_STONE_WALL.get().asItem(), ModBlocks.COBBLED_SCULK_STONE.get().asItem());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_SCULK_STONE_STAIRS.get().asItem(), ModBlocks.SMOOTH_SCULK_STONE.get().asItem());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_SCULK_STONE_SLAB.get().asItem(), ModBlocks.SMOOTH_SCULK_STONE.get().asItem());
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float p_250789_, int p_252144_, String p_251687_) {
        oreCooking(p_250654_, RecipeSerializer.SMELTING_RECIPE, p_250172_, p_250588_, p_251868_, p_250789_, p_252144_, p_251687_, "_from_smelting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> p_250791_, RecipeSerializer<? extends AbstractCookingRecipe> p_251817_, List<ItemLike> p_249619_, RecipeCategory p_251154_, ItemLike p_250066_, float p_251871_, int p_251316_, String p_251450_, String p_249236_) {
        for(ItemLike itemlike : p_249619_) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), p_251154_, p_250066_, p_251871_, p_251316_, p_251817_).group(p_251450_)
                    .unlockedBy(getHasName(itemlike), has(itemlike)).save(p_250791_, new ResourceLocation(ElegantExpansions.MOD_ID, getItemName(p_250066_)) + p_249236_ + "_" + getItemName(itemlike));
        }
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_249580_, RecipeCategory p_251203_, ItemLike p_251689_, RecipeCategory p_251376_, ItemLike p_248771_) {
        nineBlockStorageRecipes(p_249580_, p_251203_, p_251689_, p_251376_, p_248771_, getSimpleRecipeName(p_248771_), (String)null, getSimpleRecipeName(p_251689_), (String)null);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_250423_, RecipeCategory p_250083_, ItemLike p_250042_,
                                                  RecipeCategory p_248977_, ItemLike p_251911_, String p_250475_, @Nullable String p_248641_,
                                                  String p_252237_, @Nullable String p_250414_) {
        ShapelessRecipeBuilder.shapeless(p_250083_, p_250042_, 9).requires(p_251911_).group(p_250414_).unlockedBy(getHasName(p_251911_), has(p_251911_))
                .save(p_250423_, new ResourceLocation(ElegantExpansions.MOD_ID, p_252237_));
        ShapedRecipeBuilder.shaped(p_248977_, p_251911_).define('#', p_250042_).pattern("###").pattern("###").pattern("###").group(p_248641_)
                .unlockedBy(getHasName(p_250042_), has(p_250042_)).save(p_250423_, new ResourceLocation(ElegantExpansions.MOD_ID, p_250475_));
    }

    protected static void stair(Consumer<FinishedRecipe> p_248880_, ItemLike p_249368_, ItemLike p_252133_) {
        stairBuilder(p_249368_, Ingredient.of(p_252133_)).unlockedBy(getHasName(p_252133_), has(p_252133_)).save(p_248880_);
    }

    protected static void button(Consumer<FinishedRecipe> p_248880_, ItemLike p_249368_, ItemLike p_252133_) {
        buttonBuilder(p_249368_, Ingredient.of(p_252133_)).unlockedBy(getHasName(p_252133_), has(p_252133_)).save(p_248880_);
    }

    protected static void door(Consumer<FinishedRecipe> p_248880_, ItemLike p_249368_, ItemLike p_252133_) {
        doorBuilder(p_249368_, Ingredient.of(p_252133_)).unlockedBy(getHasName(p_252133_), has(p_252133_)).save(p_248880_);
    }

    protected static void trapdoor(Consumer<FinishedRecipe> p_248880_, ItemLike p_249368_, ItemLike p_252133_) {
        trapdoorBuilder(p_249368_, Ingredient.of(p_252133_)).unlockedBy(getHasName(p_252133_), has(p_252133_)).save(p_248880_);
    }

    protected static void fence(Consumer<FinishedRecipe> p_248880_, ItemLike p_249368_, ItemLike p_252133_) {
        fenceBuilder(p_249368_, Ingredient.of(p_252133_)).unlockedBy(getHasName(p_252133_), has(p_252133_)).save(p_248880_);
    }
    protected static void fencegate(Consumer<FinishedRecipe> p_248880_, ItemLike p_249368_, ItemLike p_252133_) {
        fenceGateBuilder(p_249368_, Ingredient.of(p_252133_)).unlockedBy(getHasName(p_252133_), has(p_252133_)).save(p_248880_);
    }

}