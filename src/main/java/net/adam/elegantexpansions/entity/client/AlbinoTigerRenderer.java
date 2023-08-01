package net.adam.elegantexpansions.entity.client;
import com.mojang.blaze3d.vertex.PoseStack;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.AlbinoTigerEntity;
import net.adam.elegantexpansions.entity.custom.TigerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AlbinoTigerRenderer extends GeoEntityRenderer<AlbinoTigerEntity> {
    public AlbinoTigerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AlbinoTigerModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(AlbinoTigerEntity instance) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/albino_tiger_texture.png");
    }
    @Override
    public void render(AlbinoTigerEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

   @Override
    public RenderType getRenderType(AlbinoTigerEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}