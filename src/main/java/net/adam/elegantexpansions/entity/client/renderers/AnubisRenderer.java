package net.adam.elegantexpansions.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.client.models.AnubisModel;
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


    @Override
    public void render(AnubisEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        float f = 1.0F;
        int i = entity.getInvulnerableTicks();
        if (i > 0) {
            f -= ((float)i - partialTick) / 220.0F * 0.5F;
        }
        poseStack.scale(f, f, f);

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}