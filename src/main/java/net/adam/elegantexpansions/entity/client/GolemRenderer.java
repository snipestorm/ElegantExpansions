package net.adam.elegantexpansions.entity.client;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.GolemEntity;
import net.minecraft.client.model.WitherBossModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.WitherArmorLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GolemRenderer extends GeoEntityRenderer<GolemEntity> {

    private static final ResourceLocation RAGE_GOLEM_LOCATION = new ResourceLocation(ElegantExpansions.MOD_ID,"textures/entity/rage_golem_texture.png");
    private static final ResourceLocation GOLEM_LOCATION = new ResourceLocation(ElegantExpansions.MOD_ID,"textures/entity/golem_texture.png");
    public GolemRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GolemModel());
        this.shadowRadius = 1.0f;
    }


    @Override
    public ResourceLocation getTextureLocation(GolemEntity instance) {
        if (instance.isRage()) {
        return RAGE_GOLEM_LOCATION;}
        else {
            return GOLEM_LOCATION;}
        }


    @Override
    public RenderType getRenderType(GolemEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}