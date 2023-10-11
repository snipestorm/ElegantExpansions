package net.adam.elegantexpansions.entity.client.models;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.TigerEntity;
import net.adam.elegantexpansions.entity.custom.WhiteTigerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class WhiteTigerModel extends GeoModel<WhiteTigerEntity> {
    @Override
    public ResourceLocation getModelResource(WhiteTigerEntity animatable) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "geo/tiger.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WhiteTigerEntity animatable) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/white_tiger_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WhiteTigerEntity animatable) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "animations/tiger.animation.json");
    }

    @Override
    public void setCustomAnimations(WhiteTigerEntity animatable, long instanceId, AnimationState<WhiteTigerEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}