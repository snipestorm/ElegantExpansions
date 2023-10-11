package net.adam.elegantexpansions.entity.client.models;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.VultureEntity;
import net.adam.elegantexpansions.entity.custom.VultureEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VultureModel extends GeoModel<VultureEntity> {
        @Override
        public ResourceLocation getModelResource(VultureEntity object) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "geo/vulture.geo.json");
        }

        @Override
        public ResourceLocation getTextureResource(VultureEntity object) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/vulture_texture.png");
        }

        @Override
        public ResourceLocation getAnimationResource(VultureEntity animatable) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "animations/vulture.animation.json");
        }
    }
