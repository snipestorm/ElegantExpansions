package net.adam.elegantexpansions.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.adam.elegantexpansions.block.custom.DisplayCaseBlock;
import net.adam.elegantexpansions.block.custom.GemCuttingStationBlock;
import net.adam.elegantexpansions.block.custom.ShardCreationStationBlock;
import net.adam.elegantexpansions.block.entity.custom.DisplayCaseBlockEntity;
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

public class DisplayCaseBlockEntityRenderer implements BlockEntityRenderer<DisplayCaseBlockEntity> {
    public DisplayCaseBlockEntityRenderer(BlockEntityRendererProvider.Context context) {


    }


    @Override
    public void render(DisplayCaseBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack itemToRender = pBlockEntity.getItemToRender();
        ItemStack podiumBase = pBlockEntity.getPodiumBase();
        ItemStack podiumTop = pBlockEntity.getPodiumTop();


        pPoseStack.pushPose();
        switch (pBlockEntity.getBlockState().getValue(ShardCreationStationBlock.FACING)) {
            //item//
            case NORTH -> {
                pPoseStack.translate(0.5f, 0.5f, 0.5f);
            }

            case EAST -> {
                pPoseStack.translate(0.5f, 0.5f, 0.5f);
                pPoseStack.mulPose(Axis.YP.rotationDegrees(90));
            }

            case SOUTH -> {
                pPoseStack.translate(0.5f, 0.5f, 0.5f);
                pPoseStack.mulPose(Axis.YP.rotationDegrees(180));
            }

            case WEST -> {
                pPoseStack.translate(0.5f, 0.5f, 0.5f);
                pPoseStack.mulPose(Axis.YP.rotationDegrees(270));
            }
        }

        pPoseStack.scale(0.5f, 0.5f, 0.5f);
        itemRenderer.renderStatic(itemToRender, ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
                pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);

        pPoseStack.popPose();

       {//base//

            pPoseStack.pushPose();
            {
                pPoseStack.translate(0.5f, 0.00f, 0.5f);


            }
           pPoseStack.scale(1.0f, 0.4f, 1.0f);
           itemRenderer.renderStatic(podiumBase, ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
                   pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);

           pPoseStack.popPose();

        }
        {//top//

            pPoseStack.pushPose();
            {
                pPoseStack.translate(0.5f, 0.1f, 0.5f);


            }
            pPoseStack.scale(0.6f, 0.5f, 0.6f);
            itemRenderer.renderStatic(podiumTop, ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
                    pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);

            pPoseStack.popPose();

        }

    }



    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}