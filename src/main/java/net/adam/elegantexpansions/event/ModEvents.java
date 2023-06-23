package net.adam.elegantexpansions.event;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.ModEntityTypes;
import net.adam.elegantexpansions.entity.custom.*;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

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
                event.put(ModEntityTypes.ANUBIS.get(),AnubisEntity.setAttributes());
                event.put(ModEntityTypes.TIGER.get(), TigerEntity.setAttributes());
                event.put(ModEntityTypes.WHITE_TIGER.get(), WhiteTigerEntity.setAttributes());
                event.put(ModEntityTypes.ALBINO_TIGER.get(), AlbinoTigerEntity.setAttributes());
                event.put(ModEntityTypes.SHREK.get(), ShrekEntity.setAttributes());
                event.put(ModEntityTypes.SHARK.get(), SharkEntity.setAttributes());
            }
        }
    }
}