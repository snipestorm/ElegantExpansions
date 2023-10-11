package net.adam.elegantexpansions.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.adam.elegantexpansions.block.custom.GemCuttingStationBlock;
import net.adam.elegantexpansions.block.entity.custom.GemCuttingStationBlockEntity;
import net.adam.elegantexpansions.block.entity.custom.SapExtractorBlockEntity;
import net.adam.elegantexpansions.item.ModItems;
import net.adam.elegantexpansions.util.ModTags;
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

public class SapExtractorBlockEntityRenderer implements BlockEntityRenderer<SapExtractorBlockEntity> {
    public SapExtractorBlockEntityRenderer(BlockEntityRendererProvider.Context context) {


    }


    @Override
    public void render(SapExtractorBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack itemStack = pBlockEntity.getRenderStack();
        ItemStack itemStack1 = pBlockEntity.getWood();

        pPoseStack.pushPose();
        switch (pBlockEntity.getBlockState().getValue(GemCuttingStationBlock.FACING)) {
            case NORTH -> {

                pPoseStack.translate(0.5f, 0.08f, 0.19f);
                pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
            }
            case EAST -> {
                pPoseStack.translate(0.81f, 0.08f, 0.5f);
                pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
            }
            case SOUTH -> {
                pPoseStack.translate(0.5f, 0.08f, 0.81f);
                pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
            }
            case WEST -> {
                pPoseStack.translate(0.19f, 0.08f, 0.5f);
                pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                pPoseStack.mulPose(Axis.ZP.rotationDegrees(270));
            }
        }

        pPoseStack.scale(0.25f, 0.25f, 0.25f);
        itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
                pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
        pPoseStack.popPose();

        {

            pPoseStack.pushPose();

            switch (pBlockEntity.getBlockState().getValue(GemCuttingStationBlock.FACING)) {
                case NORTH -> {
                    pPoseStack.translate(0.5f, 0.2f, 0.85f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                }
                case EAST -> {
                    pPoseStack.translate(0.15f, 0.2f, 0.5f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
                }
                case SOUTH -> {
                    pPoseStack.translate(0.5f, 0.2f, 0.15f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
                }
                case WEST -> {
                    pPoseStack.translate(0.85f, 0.2f, 0.5f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(270));
                }
            }


            pPoseStack.scale(0.55f, 0.55f, 0.55f);
            itemRenderer.renderStatic(itemStack1,ItemDisplayContext.FIXED , getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()),
                    OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
            pPoseStack.popPose();
        }

    }



    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}