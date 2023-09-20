package net.adam.elegantexpansions.entity.client;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.ElephantEntity;
import net.adam.elegantexpansions.entity.custom.TigerEntity;
import net.adam.elegantexpansions.entity.variant.ElephantVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class ElephantRenderer extends GeoEntityRenderer<ElephantEntity> {
    private static final Map<ElephantVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(ElephantVariant.class), map -> {
                map.put(ElephantVariant.GREY,
                        new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/elephant_texture.png"));
                map.put(ElephantVariant.BROWN,
                        new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/brown_elephant_texture.png"));
            });

    private static final Map<ElephantVariant, ResourceLocation> MUDDY_VARIANT =
            Util.make(Maps.newEnumMap(ElephantVariant.class), map -> {
                map.put(ElephantVariant.GREY,
                        new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/muddy_elephant_texture.png"));
                map.put(ElephantVariant.BROWN,
                        new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/muddy_brown_elephant_texture.png"));
            });
    public ElephantRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ElephantModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(ElephantEntity instance) {
        if (instance.isMuddy()) {
            return MUDDY_VARIANT.get(instance.getVariant());
        } else {
            return LOCATION_BY_VARIANT.get(instance.getVariant());
        }
    }
    @Override
    public void render(ElephantEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

   @Override
    public RenderType getRenderType(ElephantEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}