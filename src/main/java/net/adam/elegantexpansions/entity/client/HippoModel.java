package net.adam.elegantexpansions.entity.client;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.HippoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HippoModel extends GeoModel<HippoEntity> {
        @Override
        public ResourceLocation getModelResource(HippoEntity object) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "geo/hippo.geo.json");
        }

        @Override
        public ResourceLocation getTextureResource(HippoEntity object) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/hippo.png");
        }

        @Override
        public ResourceLocation getAnimationResource(HippoEntity animatable) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "animations/hippo.animation.json");
        }
    }
