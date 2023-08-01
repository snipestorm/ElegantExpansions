package net.adam.elegantexpansions.util;
import net.adam.elegantexpansions.ElegantExpansions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Items {

        public static final TagKey<Item> CUT_GEMS = tag("cut_gems");
        public static final TagKey<Item> GEMS = tag("gems");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ElegantExpansions.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> GEM_DETECTOR_GEMS = tag("gem_detector_gems");
        public static final TagKey<Block> NEEDS_ALEXANDRITE_TOOL = tag("needs_alexandrite_tool");
        public static final TagKey<Block> PAXEL_MINEABLE = tag("mineable/paxel");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ElegantExpansions.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
    }