package net.adam.elegantexpansions.entity.client;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.CapybaraEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CapybaraModel extends GeoModel<CapybaraEntity> {
        @Override
        public ResourceLocation getModelResource(CapybaraEntity object) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "geo/capybara.geo.json");
        }

        @Override
        public ResourceLocation getTextureResource(CapybaraEntity object) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/capybara_texture.png");
        }

        @Override
        public ResourceLocation getAnimationResource(CapybaraEntity animatable) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "animations/capybara.animation.json");
        }
    }
