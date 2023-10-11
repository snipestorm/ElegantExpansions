package net.adam.elegantexpansions.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.entity.ModEntityTypes;
import net.adam.elegantexpansions.entity.custom.*;
import net.adam.elegantexpansions.item.ModItems;
import net.adam.elegantexpansions.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
@Mod.EventBusSubscriber(modid = ElegantExpansions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    @Mod.EventBusSubscriber(modid = ElegantExpansions.MOD_ID)
    public static class ForgeEvents {
        @Mod.EventBusSubscriber(modid = ElegantExpansions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class ModEventBusEvents {
            @SubscribeEvent
            public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
                event.put(ModEntityTypes.GOLEM.get(), GolemEntity.setAttributes());
                event.put(ModEntityTypes.MUMMY.get(), MummyEntity.setAttributes());
                event.put(ModEntityTypes.PLAYERS_MUMMY.get(), PlayersMummy.setAttributes());
                event.put(ModEntityTypes.ANUBIS.get(), AnubisEntity.setAttributes());
                event.put(ModEntityTypes.TIGER.get(), TigerEntity.setAttributes());
                event.put(ModEntityTypes.WHITE_TIGER.get(), WhiteTigerEntity.setAttributes());
                event.put(ModEntityTypes.ALBINO_TIGER.get(), AlbinoTigerEntity.setAttributes());
                event.put(ModEntityTypes.SHREK.get(), ShrekEntity.setAttributes());
                event.put(ModEntityTypes.SHARK.get(), SharkEntity.setAttributes());
                event.put(ModEntityTypes.CAPYBARA.get(), CapybaraEntity.setAttributes());
                event.put(ModEntityTypes.ELEPHANT.get(), ElephantEntity.setAttributes());
                event.put(ModEntityTypes.RACCOON.get(), RaccoonEntity.setAttributes());
                event.put(ModEntityTypes.LION.get(), LionEntity.setAttributes());
                event.put(ModEntityTypes.HIPPO.get(), HippoEntity.setAttributes());
                event.put(ModEntityTypes.VULTURE.get(), VultureEntity.setAttributes());
                event.put(ModEntityTypes.ECHO_SPIDER.get(), EchoSpider.setAttributes());
            }
        }
    }


    @SubscribeEvent
    public static void addVillagerTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.GEM_MASTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //level 1//
            trades.get(1).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ModItems.GEM_CUTTERS.get(), 1),
                    8, 2, 0.05f));

            trades.get(1).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ModBlocks.DEEPSLATE_RUBY_ORE.get(), 1),
                    8, 2, 0.05f));

            trades.get(1).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), 1),
                    8, 1, 0.05f));

            trades.get(1).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 5),
                    new ItemStack(Items.EMERALD, 1),
                    8, 1, 0.05f));

            trades.get(1).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 5),
                    new ItemStack(Items.EMERALD, 1),
                    8, 1, 0.05f));

            //level 2//

            trades.get(2).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 16),
                    new ItemStack(Blocks.CALCITE, 8)
                    ,4, 5, 0.1f));

           trades.get(2).add((p_219693_, p_219694_) -> new MerchantOffer(
                   new ItemStack(Items.EMERALD, 16),
                   new ItemStack(Blocks.BLACKSTONE, 8),
                   4, 5, 0.1f));

           trades.get(2).add((p_219693_, p_219694_) -> new MerchantOffer(
                   new ItemStack(Items.EMERALD, 12),
                   new ItemStack(Items.GLASS_BOTTLE, 16),
                   8, 5, 0.1f));


           trades.get(2).add((p_219693_, p_219694_) -> new MerchantOffer(
                   new ItemStack(ModItems.CUT_RUBY.get(), 3),
                   new ItemStack(Items.EMERALD, 1),
                   6, 3, 0.08f));

            trades.get(2).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(ModItems.CUT_SAPPHIRE.get(), 3),
                    new ItemStack(Items.EMERALD, 1),
                    6, 3, 0.08f));

            //level 3//

            trades.get(3).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 16),
                    new ItemStack(ModBlocks.GEM_INFUSING_STATION.get(), 1)
                    ,3, 10, 0.1f));

            trades.get(3).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 20),
                    new ItemStack(ModItems.MAGICAL_SAP_BUCKET.get(), 1)
                    ,3, 10, 0.1f));

            trades.get(3).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 20),
                    new ItemStack(ModItems.GEM_DETECTOR.get(), 1)
                    ,12, 10, 0.1f));

            trades.get(3).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(ModItems.CUT_AMETHYST.get(), 1),
                    new ItemStack(Items.EMERALD, 3)
                    ,4, 8, 0.1f));

            trades.get(3).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(ModItems.CUT_CITRINE.get(), 1),
                    new ItemStack(Items.EMERALD, 3)
                    ,4, 8, 0.1f));

            trades.get(3).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(ModItems.CUT_TANZANITE.get(), 1),
                    new ItemStack(Items.EMERALD, 3)
                    ,4, 8, 0.1f));

            //level 4//

            trades.get(4).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(ModItems.CUT_EMERALD.get(), 10),
                    new ItemStack(ModBlocks.SHARD_CREATION_STATION.get(), 1)
                    ,4, 10, 0.1f));

            trades.get(4).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(ModItems.CUT_EMERALD.get(), 32),
                    new ItemStack(ModItems.GEM_UPGRADE_TEMPLATE.get(), 1)
                    ,1, 15, 0.1f));

            trades.get(4).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(ModItems.CUT_EMERALD.get(), 32),
                    new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 1)
                    ,1, 15, 0.1f));


            trades.get(4).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(ModItems.INFUSED_CITRINE.get(), 1),
                    new ItemStack(Items.EMERALD, 8)
                    ,4, 10, 0f));

            trades.get(4).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(ModItems.INFUSED_TANZANITE.get(), 1),
                    new ItemStack(Items.EMERALD, 10)
                    ,4, 10, 0f));

            //level 5//

            trades.get(5).add((p_219693_, p_219694_) -> new MerchantOffer(
                    new ItemStack(ModItems.INFUSED_EMERALD.get(),16 ),
                    new ItemStack(ModBlocks.MYSTERIOUS_CUBE.get(), 1)
                    ,1, 80, 0f));




        }
    }
}





