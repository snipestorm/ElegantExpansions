package net.adam.elegantexpansions.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.adam.elegantexpansions.block.custom.GemCuttingStationBlock;
import net.adam.elegantexpansions.block.entity.custom.GemCuttingStationBlockEntity;
import net.adam.elegantexpansions.item.ModItems;
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

public class GemCuttingStationBlockEntityRenderer implements BlockEntityRenderer<GemCuttingStationBlockEntity> {
    public GemCuttingStationBlockEntityRenderer(BlockEntityRendererProvider.Context context) {


    }


    @Override
    public void render(GemCuttingStationBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack itemStack = pBlockEntity.getRenderStack();

        pPoseStack.pushPose();
        switch (pBlockEntity.getBlockState().getValue(GemCuttingStationBlock.FACING)) {
            case NORTH -> {

                pPoseStack.translate(0.6f, 0.79f, 0.225f);
                pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
            }
            case EAST -> {
                pPoseStack.translate(0.775f, 0.79f, 0.6f);
                pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
            }
            case SOUTH -> {
                pPoseStack.translate(0.4f, 0.79f, 0.775f);
                pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
            }
            case WEST -> {
                pPoseStack.translate(0.225f, 0.79f, 0.4f);
                pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                pPoseStack.mulPose(Axis.ZP.rotationDegrees(270));
            }
        }

        pPoseStack.scale(0.35f, 0.35f, 0.35f);
        itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
                pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
        pPoseStack.popPose();



        if(pBlockEntity.hasGemCuttingTools()) {

            pPoseStack.pushPose();

            switch (pBlockEntity.getBlockState().getValue(GemCuttingStationBlock.FACING)) {
                case NORTH -> {
                    pPoseStack.translate(0.35f, 0.75f, 0.75f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                }
                case EAST -> {
                    pPoseStack.translate(0.25f, 0.75f, 0.35f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
                }
                case SOUTH -> {
                    pPoseStack.translate(0.65f, 0.75f, 0.25f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
                }
                case WEST -> {
                    pPoseStack.translate(0.75f, 0.75f, 0.65f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(270));
                }
            }








            pPoseStack.scale(0.35f, 0.35f, 0.35f);
            itemRenderer.renderStatic(new ItemStack(ModItems.GEM_CUTTERS.get()),ItemDisplayContext.FIXED , getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()),
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