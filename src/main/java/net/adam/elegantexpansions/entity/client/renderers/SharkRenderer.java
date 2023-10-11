package net.adam.elegantexpansions.entity.client.renderers;
import com.mojang.blaze3d.vertex.PoseStack;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.client.models.SharkModel;
import net.adam.elegantexpansions.entity.custom.SharkEntity;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SharkRenderer extends GeoEntityRenderer<SharkEntity> {
    public SharkRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SharkModel());
        this.shadowRadius = 1f;
    }

    @Override
    public ResourceLocation getTextureLocation(SharkEntity instance) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/shark_texture.png");
    }

    @Override
    public void render(SharkEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        {
           poseStack.scale(1.5f, 1.5f, 1.5f);
       }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }


    @Override
    public RenderType getRenderType(SharkEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}