package net.adam.elegantexpansions.entity.client;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.ElephantEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ElephantModel extends GeoModel<ElephantEntity> {
    @Override
    public ResourceLocation getModelResource(ElephantEntity animatable) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "geo/elephant.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ElephantEntity animatable) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/elephant_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ElephantEntity animatable) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "animations/elephant.animation.json");
    }

    @Override
    public void setCustomAnimations(ElephantEntity animatable, long instanceId, AnimationState<ElephantEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}