package net.adam.elegantexpansions.util;

import net.adam.elegantexpansions.ElegantExpansions;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Items {

        public static final TagKey<Item> CUT_GEMS = tag("cut_gems");
        public static final TagKey<Item> GEMS = tag("gems");
        public static final TagKey<Item> MAGIC_LOGS = tag("magic_logs");
        public static final TagKey<Item> WILLOW_LOGS = tag("willow_logs");
        public static final TagKey<Item> ECHO_LOGS = tag("echo_logs");
        public static final TagKey<Item> PALM_LOGS = tag("palm_logs");
        public static final TagKey<Item> ASH_LOGS = tag("ash_logs");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ElegantExpansions.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
    public static class EntityTypes {
        public static final TagKey<EntityType<?>> VULTURE_HOSTILES = tag("vulture_hostiles");

        private static TagKey<EntityType<?>> tag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE,new  ResourceLocation(ElegantExpansions.MOD_ID, name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> GEM_DETECTOR_GEMS = tag("gem_detector_gems");

        public static final TagKey<Block> NEEDS_ALEXANDRITE_TOOL = tag("needs_alexandrite_tool");
        public static final TagKey<Block> PAXEL_MINEABLE = tag("mineable/paxel");
        public static final TagKey<Block> ANUBIS_BASE_BLOCKS = tag("anubis_base");
        public static final TagKey<Block> VULTURE_PERCH_BLOCKS = tag("vulture_perch_blocks");
        public static final TagKey<Block> VULTURES_SPAWNABLE_ON = tag("vultures_spawnable_on");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ElegantExpansions.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    }