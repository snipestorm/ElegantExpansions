package net.adam.elegantexpansions.entity.client.models;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.SharkEntity;
import net.adam.elegantexpansions.entity.custom.WhiteTigerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SharkModel extends GeoModel<SharkEntity> {
    @Override
    public ResourceLocation getModelResource(SharkEntity animatable) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "geo/shark.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SharkEntity animatable) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/shark_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SharkEntity animatable) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "animations/shark.animation.json");
    }

}