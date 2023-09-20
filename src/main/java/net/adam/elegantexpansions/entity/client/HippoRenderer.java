package net.adam.elegantexpansions.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.HippoEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HippoRenderer extends GeoEntityRenderer<HippoEntity> {
    public HippoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HippoModel());
        this.shadowRadius = 0.8f;
    }

    @Override
    public ResourceLocation getTextureLocation(HippoEntity instance) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/hippo.png");
    }

    @Override
    public void render(HippoEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        }
            super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

   @Override
    public RenderType getRenderType(HippoEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}