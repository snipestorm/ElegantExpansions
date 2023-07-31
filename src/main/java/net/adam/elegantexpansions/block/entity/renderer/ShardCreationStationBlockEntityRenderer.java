package net.adam.elegantexpansions.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.adam.elegantexpansions.block.custom.GemCuttingStationBlock;
import net.adam.elegantexpansions.block.custom.ShardCreationStationBlock;
import net.adam.elegantexpansions.block.entity.custom.GemInfusingStationBlockEntity;
import net.adam.elegantexpansions.block.entity.custom.ShardCreationStationBlockEntity;
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

public class ShardCreationStationBlockEntityRenderer implements BlockEntityRenderer<ShardCreationStationBlockEntity> {
    public ShardCreationStationBlockEntityRenderer(BlockEntityRendererProvider.Context context) {


    }


    @Override
    public void render(ShardCreationStationBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {

        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = pBlockEntity.getRender();


            pPoseStack.pushPose();
            switch (pBlockEntity.getBlockState().getValue(ShardCreationStationBlock.FACING)) {
                case NORTH -> {

                    pPoseStack.translate(0.81f, 0.79f, 0.81f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                }
                case EAST -> {
                    pPoseStack.translate(0.19f, 0.79f, 0.81f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
                }
                case SOUTH -> {
                    pPoseStack.translate(0.19f, 0.79f, 0.19f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
                }
                case WEST -> {
                    pPoseStack.translate(0.81f, 0.79f, 0.19f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(270));
                }
            }


        pPoseStack.scale(0.2f, 0.2f, 0.2f);
        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
                pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
        pPoseStack.popPose();


        if (pBlockEntity.hasSapphire()) {

            pPoseStack.pushPose();
            switch (pBlockEntity.getBlockState().getValue(ShardCreationStationBlock.FACING)) {
                case NORTH -> {

                    pPoseStack.translate(0.5f, 0.79f, 0.81f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                }
                case EAST -> {
                    pPoseStack.translate(0.19f, 0.79f, 0.5f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
                }
                case SOUTH -> {
                    pPoseStack.translate(0.5f, 0.79f, 0.19f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
                }
                case WEST -> {
                    pPoseStack.translate(0.81f, 0.79f, 0.5f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(270));
                }
            }

            pPoseStack.scale(0.2f, 0.2f, 0.2f);
            itemRenderer.renderStatic(new ItemStack(ModItems.INFUSED_SAPPHIRE.get()), ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
                    pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
            pPoseStack.popPose();

        }

        if (pBlockEntity.hasCitrine()) {

            pPoseStack.pushPose();
            switch (pBlockEntity.getBlockState().getValue(ShardCreationStationBlock.FACING)) {
                case NORTH -> {

                    pPoseStack.translate(0.19f, 0.79f, 0.81f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                }
                case EAST -> {
                    pPoseStack.translate(0.19f, 0.79f, 0.19f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
                }
                case SOUTH -> {
                    pPoseStack.translate(0.81f, 0.79f, 0.19f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
                }
                case WEST -> {
                    pPoseStack.translate(0.81f, 0.79f, 0.81f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(270));
                }
            }

            pPoseStack.scale(0.2f, 0.2f, 0.2f);
            itemRenderer.renderStatic(new ItemStack(ModItems.INFUSED_CITRINE.get()), ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
                    pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
            pPoseStack.popPose();

        }

        if (pBlockEntity.hasDiamond()) {

            pPoseStack.pushPose();
            switch (pBlockEntity.getBlockState().getValue(ShardCreationStationBlock.FACING)) {
                case NORTH -> {

                    pPoseStack.translate(0.81f, 0.79f, 0.51f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                }
                case EAST -> {
                    pPoseStack.translate(0.49f, 0.79f, 0.81f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
                }
                case SOUTH -> {
                    pPoseStack.translate(0.19f, 0.79f, 0.49f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
                }
                case WEST -> {
                    pPoseStack.translate(0.51f, 0.79f, 0.19f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(270));
                }
            }

            pPoseStack.scale(0.2f, 0.2f, 0.2f);
            itemRenderer.renderStatic(new ItemStack(ModItems.INFUSED_DIAMOND.get()), ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
                    pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
            pPoseStack.popPose();

        }

        if (pBlockEntity.hasAmethyst()) {

            pPoseStack.pushPose();
            switch (pBlockEntity.getBlockState().getValue(ShardCreationStationBlock.FACING)) {
                case NORTH -> {

                    pPoseStack.translate(0.19f, 0.79f, 0.51f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                }
                case EAST -> {
                    pPoseStack.translate(0.49f, 0.79f, 0.19f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
                }
                case SOUTH -> {
                    pPoseStack.translate(0.81f, 0.79f, 0.49f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
                }
                case WEST -> {
                    pPoseStack.translate(0.51f, 0.79f, 0.81f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(270));
                }
            }

            pPoseStack.scale(0.2f, 0.2f, 0.2f);
            itemRenderer.renderStatic(new ItemStack(ModItems.INFUSED_AMETHYST.get()), ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
                    pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
            pPoseStack.popPose();

        }

        if (pBlockEntity.hasOnyx()) {

            pPoseStack.pushPose();
            switch (pBlockEntity.getBlockState().getValue(ShardCreationStationBlock.FACING)) {
                case NORTH -> {

                    pPoseStack.translate(0.81f, 0.79f, 0.2f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                }
                case EAST -> {
                    pPoseStack.translate(0.8f, 0.79f, 0.81f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
                }
                case SOUTH -> {
                    pPoseStack.translate(0.19f, 0.79f, 0.8f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
                }
                case WEST -> {
                    pPoseStack.translate(0.2f, 0.79f, 0.19f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(270));
                }
            }

            pPoseStack.scale(0.2f, 0.2f, 0.2f);
            itemRenderer.renderStatic(new ItemStack(ModItems.INFUSED_ONYX.get()), ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
                    pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
            pPoseStack.popPose();

        }

        if (pBlockEntity.hasTanzanite()) {

            pPoseStack.pushPose();
            switch (pBlockEntity.getBlockState().getValue(ShardCreationStationBlock.FACING)) {
                case NORTH -> {

                    pPoseStack.translate(0.5f, 0.79f, 0.2f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                }
                case EAST -> {
                    pPoseStack.translate(0.8f, 0.79f, 0.5f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
                }
                case SOUTH -> {
                    pPoseStack.translate(0.5f, 0.79f, 0.8f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
                }
                case WEST -> {
                    pPoseStack.translate(0.2f, 0.79f, 0.5f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(270));
                }
            }

            pPoseStack.scale(0.2f, 0.2f, 0.2f);
            itemRenderer.renderStatic(new ItemStack(ModItems.INFUSED_TANZANITE.get()), ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
                    pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
            pPoseStack.popPose();

        }

        if (pBlockEntity.hasEmerald()) {

            pPoseStack.pushPose();
            switch (pBlockEntity.getBlockState().getValue(ShardCreationStationBlock.FACING)) {
                case NORTH -> {

                    pPoseStack.translate(0.19f, 0.79f, 0.2f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                }
                case EAST -> {
                    pPoseStack.translate(0.8f, 0.79f, 0.19f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
                }
                case SOUTH -> {
                    pPoseStack.translate(0.81f, 0.79f, 0.8f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
                }
                case WEST -> {
                    pPoseStack.translate(0.2f, 0.79f, 0.81f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(270));
                }
            }

            pPoseStack.scale(0.2f, 0.2f, 0.2f);
            itemRenderer.renderStatic(new ItemStack(ModItems.INFUSED_EMERALD.get()), ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
                    pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
            pPoseStack.popPose();

        }

        if (pBlockEntity.hasShard()) {

            pPoseStack.pushPose();
            switch (pBlockEntity.getBlockState().getValue(ShardCreationStationBlock.FACING)) {
                case NORTH -> {

                    pPoseStack.translate(0.5f, 0.79f, 0.51f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                }
                case EAST -> {
                    pPoseStack.translate(0.49f, 0.79f, 0.5f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
                }
                case SOUTH -> {
                    pPoseStack.translate(0.5f, 0.79f, 0.49f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
                }
                case WEST -> {
                    pPoseStack.translate(0.51f, 0.79f, 0.5f);
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(270));
                }
            }

            pPoseStack.scale(0.2f, 0.2f, 0.2f);
            itemRenderer.renderStatic(new ItemStack(ModItems.ALEXANDRITE_SHARD.get()), ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
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