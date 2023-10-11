package net.adam.elegantexpansions.entity.client.renderers;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.client.models.ShrekModel;
import net.adam.elegantexpansions.entity.custom.ShrekEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ShrekRenderer extends GeoEntityRenderer<ShrekEntity> {
    public ShrekRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ShrekModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(ShrekEntity instance) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/shrek_texture.png");
    }

   @Override
    public RenderType getRenderType(ShrekEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}