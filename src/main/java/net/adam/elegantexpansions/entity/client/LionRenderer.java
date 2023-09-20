package net.adam.elegantexpansions.entity.client;
import com.mojang.blaze3d.vertex.PoseStack;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.LionEntity;
import net.adam.elegantexpansions.entity.custom.TigerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LionRenderer extends GeoEntityRenderer<LionEntity> {
    public LionRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LionModel());
        this.shadowRadius = 1.1f;
    }

    @Override
    public ResourceLocation getTextureLocation(LionEntity instance) {
        return instance.isSleeping() ?
                new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/lion_sleep.png") :
                new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/lion.png");
    }
    @Override
    public void render(LionEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

   @Override
    public RenderType getRenderType(LionEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
       return RenderType.entityCutoutNoCull(texture);
    }
}