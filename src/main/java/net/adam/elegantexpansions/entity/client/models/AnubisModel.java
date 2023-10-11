package net.adam.elegantexpansions.entity.client.models;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.AnubisEntity;
import net.adam.elegantexpansions.entity.custom.MummyEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AnubisModel extends GeoModel<AnubisEntity> {
        @Override
        public ResourceLocation getModelResource(AnubisEntity object) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "geo/anubis.geo.json");
        }

        @Override
        public ResourceLocation getTextureResource(AnubisEntity object) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/anubis_texture.png");
        }

        @Override
        public ResourceLocation getAnimationResource(AnubisEntity animatable) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "animations/anubis.animation.json");
        }
    }
