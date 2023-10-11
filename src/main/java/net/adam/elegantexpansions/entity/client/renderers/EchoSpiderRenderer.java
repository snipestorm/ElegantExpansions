package net.adam.elegantexpansions.entity.client.renderers;


import com.mojang.blaze3d.vertex.PoseStack;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.EchoSpider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EchoSpiderRenderer extends SpiderRenderer<EchoSpider> {
    private static final ResourceLocation ECHO_SPIDER_LOCATION = new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/echo_spider.png");
    private static final float SCALE = 0.7F;

    public EchoSpiderRenderer(EntityRendererProvider.Context p_173946_) {
        super(p_173946_, ModelLayers.CAVE_SPIDER);
        this.shadowRadius *= 0.7F;
    }

    protected void scale(EchoSpider p_113974_, PoseStack p_113975_, float p_113976_) {
        p_113975_.scale(0.7F, 0.7F, 0.7F);
    }

    public ResourceLocation getTextureLocation(EchoSpider p_113972_) {
        return ECHO_SPIDER_LOCATION;
    }
}