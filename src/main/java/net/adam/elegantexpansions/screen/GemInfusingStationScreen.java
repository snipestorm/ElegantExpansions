package net.adam.elegantexpansions.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.screen.renderer.FluidTankRenderer;
import net.adam.elegantexpansions.util.MouseUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.fluids.FluidStack;

import java.util.Optional;

public class GemInfusingStationScreen extends AbstractContainerScreen<GemInfusingStationMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ElegantExpansions.MOD_ID,"textures/gui/gem_infusing_station_gui.png");

    private static final int[] BUBBLELENGTHS1 = new int[]{29, 24, 20, 16, 11, 6, 0};

    private FluidTankRenderer fluidRenderer;

    public GemInfusingStationScreen(GemInfusingStationMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        assignFluidRenderer();
    }

    private void assignFluidRenderer() {
        fluidRenderer = new FluidTankRenderer(10000, true, 16, 61);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int pMouseX, int pMouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        renderFluidTooltipArea(guiGraphics, pMouseX, pMouseY, x, y, menu.blockEntity.getFluid(), 80, 20, fluidRenderer);

        super.renderLabels(guiGraphics, pMouseX, pMouseY);
    }

    private void renderFluidTooltipArea(GuiGraphics guiGraphics, int pMouseX, int pMouseY, int x, int y,
                                        FluidStack stack, int offsetX, int offsetY, FluidTankRenderer renderer) {
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, offsetX, offsetY, renderer)) {
            guiGraphics.renderTooltip(this.font, renderer.getTooltip(stack, TooltipFlag.Default.NORMAL),
                    Optional.empty(), pMouseX - x, pMouseY - y);
        }
    }



    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
      // RenderSystem.setShader(GameRenderer::getPositionTexShader);
      // RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      // RenderSystem.setShaderTexture(0, TEXTURE);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(TEXTURE, i, j, 0, 0, this.imageWidth, this.imageHeight);


        fluidRenderer.render(guiGraphics, i + 80, j + 20, menu.blockEntity.getFluid());

        int i1 = this.menu.getCraftingTicks();
        if (i1 > 0) {
            int j1 = (int)(28.0F * (1.0F - (float)i1 / 400.0F));
            if (j1 > 0) {
            }

            j1 = BUBBLELENGTHS1[i1 / 2 % 7];
            if (j1 > 0) {
                guiGraphics.blit(TEXTURE, i + 140, j + 36 + 29 - j1, 184, 29 - j1, 11, j1);

            }
        }
        renderProgressArrow(guiGraphics,i,j);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 130, y + 38, 176, 0, 8, menu.getScaledProgress());
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, FluidTankRenderer renderer) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, renderer.getWidth(), renderer.getHeight());
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, int width, int height) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, width, height);
    }
}