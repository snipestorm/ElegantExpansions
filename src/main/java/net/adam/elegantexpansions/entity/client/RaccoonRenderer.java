package net.adam.elegantexpansions.entity.client;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.ElephantEntity;
import net.adam.elegantexpansions.entity.custom.RaccoonEntity;
import net.adam.elegantexpansions.entity.variant.ElephantVariant;
import net.adam.elegantexpansions.entity.variant.RaccoonVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class RaccoonRenderer extends GeoEntityRenderer<RaccoonEntity> {
    private static final Map<RaccoonVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(RaccoonVariant.class), map -> {
                map.put(RaccoonVariant.GREY,
                        new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/raccoon.png"));
                map.put(RaccoonVariant.BROWN,
                        new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/brownraccoon.png"));
                map.put(RaccoonVariant.RED,
                        new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/redraccoon.png"));
                map.put(RaccoonVariant.BLACK,
                        new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/raccoondark.png"));
                map.put(RaccoonVariant.BLUE,
                        new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/blueraccoon.png"));
                map.put(RaccoonVariant.GOLD,
                        new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/goldraccoon.png"));
                map.put(RaccoonVariant.WHITE,
                        new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/whiteraccoon.png"));
            });
    public RaccoonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RaccoonModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(RaccoonEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }
    @Override
    public void render(RaccoonEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

   @Override
    public RenderType getRenderType(RaccoonEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}