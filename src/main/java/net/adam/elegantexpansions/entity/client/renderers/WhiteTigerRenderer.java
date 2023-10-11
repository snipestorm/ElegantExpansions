package net.adam.elegantexpansions.entity.client.renderers;
import com.mojang.blaze3d.vertex.PoseStack;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.client.models.WhiteTigerModel;
import net.adam.elegantexpansions.entity.custom.WhiteTigerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WhiteTigerRenderer extends GeoEntityRenderer<WhiteTigerEntity> {
    public WhiteTigerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WhiteTigerModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(WhiteTigerEntity instance) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/white_tiger_texture.png");
    }
    @Override
    public void render(WhiteTigerEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

   @Override
    public RenderType getRenderType(WhiteTigerEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}