package net.adam.elegantexpansions.event;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.block.entity.ModBlockEntities;

import net.adam.elegantexpansions.block.entity.renderer.GemCuttingStationBlockEntityRenderer;
import net.adam.elegantexpansions.block.entity.renderer.GemInfusingStationBlockEntityRenderer;
import net.adam.elegantexpansions.block.entity.renderer.ShardCreationStationBlockEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ElegantExpansions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.GEM_CUTTING_STATION_BLOCK_ENTITY.get(),
                GemCuttingStationBlockEntityRenderer::new);

        event.registerBlockEntityRenderer(ModBlockEntities.GEM_INFUSING_STATION_BLOCK_ENTITY.get(),
                GemInfusingStationBlockEntityRenderer::new);

        event.registerBlockEntityRenderer(ModBlockEntities.SHARD_CREATION_STATION_BLOCK_ENTITY.get(),
                ShardCreationStationBlockEntityRenderer::new);
    }

}