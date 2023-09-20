package net.adam.elegantexpansions.entity.client;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.GolemEntity;
import net.adam.elegantexpansions.entity.custom.LionEntity;
import net.adam.elegantexpansions.entity.custom.TigerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.DataTicket;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

import java.util.List;

public class LionModel extends GeoModel<LionEntity> {
    @Override
    public ResourceLocation getModelResource(LionEntity animatable) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "geo/lion.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LionEntity lion) {
        return lion.isSleeping() ? new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/lion_sleep.png") : new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/lion.png");
    }


    @Override
    public ResourceLocation getAnimationResource(LionEntity animatable) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "animations/lion.animation.json");
    }

    @Override
    public void setCustomAnimations(LionEntity lion, long uniqueID, AnimationState<LionEntity> animationState) {
        super.setCustomAnimations(lion, uniqueID, animationState);
        CoreGeoBone head = getAnimationProcessor().getBone("head");
        CoreGeoBone mane = getAnimationProcessor().getBone("mane");

        EntityModelData extraDataOfType = animationState.getData(DataTickets.ENTITY_MODEL_DATA);


        if (lion.isBaby()) {
            head.setScaleX(1.75F);
            head.setScaleY(1.75F);
            head.setScaleZ(1.75F);
        }

        mane.setHidden(!lion.hasMane() || lion.isBaby());

        if (!lion.isSleeping()) {
            head.setRotX(extraDataOfType.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(extraDataOfType.netHeadYaw() * Mth.DEG_TO_RAD);
        }


        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}