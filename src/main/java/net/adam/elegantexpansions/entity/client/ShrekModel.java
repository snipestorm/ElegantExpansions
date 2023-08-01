package net.adam.elegantexpansions.entity.client;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.ShrekEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShrekModel extends GeoModel<ShrekEntity> {
        @Override
        public ResourceLocation getModelResource(ShrekEntity object) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "geo/shrek.geo.json");
        }

        @Override
        public ResourceLocation getTextureResource(ShrekEntity object) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/shrek_texture.png");
        }

        @Override
        public ResourceLocation getAnimationResource(ShrekEntity animatable) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "animations/shrek.animation.json");
        }
    }
