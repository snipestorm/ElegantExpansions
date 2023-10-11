package net.adam.elegantexpansions.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.client.models.VultureModel;
import net.adam.elegantexpansions.entity.custom.VultureEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class VultureRenderer extends GeoEntityRenderer<VultureEntity> {
    public VultureRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new VultureModel());
        this.shadowRadius = 0.65f;
    }

    @Override
    public ResourceLocation getTextureLocation(VultureEntity instance) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/vulture_texture.png");
    }

    @Override
    public void render(VultureEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

   @Override
    public RenderType getRenderType(VultureEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }

 // @Override
 // public void renderRecursively(PoseStack stack, VultureEntity animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight,
 //                               int packedOverlay, float red, float green, float blue, float alpha) {
 //     if (bone.getName().equals("head")) {
 //         stack.pushPose();
 //         stack.mulPose(Axis.XP.rotationDegrees(-90));
 //         stack.mulPose(Axis.YP.rotationDegrees(0));
 //         stack.mulPose(Axis.ZP.rotationDegrees(0));
 //         stack.translate(0.0D, 0.6D, 0.2D);
 //           stack.scale(1.0F,1.0F,1.0F);
 //         Minecraft.getInstance().getItemRenderer().renderStatic(bone, ItemDisplayContext.GROUND, packedLight, packedOverlay, stack,this.rtb, 0);
 //         stack.popPose();
 //         buffer = rtb.getRenderType(RenderType.entityTranslucent(whTexture));
 //     }
 //     super.renderRecursively(stack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
 // }


}