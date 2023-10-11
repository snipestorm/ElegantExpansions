package net.adam.elegantexpansions.entity.client.models;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.ElephantEntity;
import net.adam.elegantexpansions.entity.custom.RaccoonEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class RaccoonModel extends GeoModel<RaccoonEntity> {
    @Override
    public ResourceLocation getModelResource(RaccoonEntity animatable) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "geo/raccoon.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RaccoonEntity animatable) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/raccoon_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RaccoonEntity animatable) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "animations/raccoon.animation.json");
    }

    @Override
    public void setCustomAnimations(RaccoonEntity animatable, long instanceId, AnimationState<RaccoonEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}