package net.adam.elegantexpansions.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.adam.elegantexpansions.block.custom.GemCuttingStationBlock;
import net.adam.elegantexpansions.block.entity.custom.GemInfusingStationBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class GemInfusingStationBlockEntityRenderer implements BlockEntityRenderer<GemInfusingStationBlockEntity> {
    public GemInfusingStationBlockEntityRenderer(BlockEntityRendererProvider.Context context) {


    }


    @Override
    public void render(GemInfusingStationBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack itemStack = pBlockEntity.getRenderStack();

        pPoseStack.pushPose();
        switch (pBlockEntity.getBlockState().getValue(GemCuttingStationBlock.FACING)) {
            case NORTH -> {

                pPoseStack.translate(0.5f, 0.79f, 0.5f);
                pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
            }
            case EAST -> {
                pPoseStack.translate(0.5f, 0.79f, 0.5f);
                pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
            }
            case SOUTH -> {
                pPoseStack.translate(0.5f, 0.79f, 0.5f);
                pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
            }
            case WEST -> {
                pPoseStack.translate(0.5f, 0.79f, 0.5f);
                pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                pPoseStack.mulPose(Axis.ZP.rotationDegrees(270));
            }
        }

        pPoseStack.scale(0.35f, 0.35f, 0.35f);
        itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
                pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);

        pPoseStack.popPose();


    }



    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}