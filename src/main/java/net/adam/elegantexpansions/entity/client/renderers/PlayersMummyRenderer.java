package net.adam.elegantexpansions.entity.client.renderers;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.client.models.PlayersMummyModel;
import net.adam.elegantexpansions.entity.custom.PlayersMummy;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PlayersMummyRenderer extends GeoEntityRenderer<PlayersMummy> {
    public PlayersMummyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PlayersMummyModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(PlayersMummy instance) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/players_mummy_texture.png");
    }

   @Override
    public RenderType getRenderType(PlayersMummy animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}