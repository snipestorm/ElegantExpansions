package net.adam.elegantexpansions.event;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.block.entity.ModBlockEntities;

import net.adam.elegantexpansions.block.entity.renderer.*;
import net.adam.elegantexpansions.particle.ModParticles;
import net.adam.elegantexpansions.particle.SandAshParticle;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
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

        event.registerBlockEntityRenderer(ModBlockEntities.DISPLAY_CASE_BLOCK_ENTITY.get(),
                DisplayCaseBlockEntityRenderer::new);

        event.registerBlockEntityRenderer(ModBlockEntities.SAP_EXTRACTOR_BLOCK_ENTITY.get(),
                SapExtractorBlockEntityRenderer::new);
    }
    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.SAND_ASH_PARTICLE.get(), SandAshParticle.Provider::new);
    }

}