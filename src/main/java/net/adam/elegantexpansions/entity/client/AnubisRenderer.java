package net.adam.elegantexpansions.entity.client;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.AnubisEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AnubisRenderer extends GeoEntityRenderer<AnubisEntity> {
    public AnubisRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AnubisModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(AnubisEntity instance) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/anubis_texture.png");
    }

   @Override
    public RenderType getRenderType(AnubisEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}