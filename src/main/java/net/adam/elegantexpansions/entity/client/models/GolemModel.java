package net.adam.elegantexpansions.entity.client.models;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.GolemEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
public class GolemModel extends GeoModel<GolemEntity> {
        @Override
        public ResourceLocation getModelResource(GolemEntity object) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "geo/golem.geo.json");
        }

        @Override
        public ResourceLocation getTextureResource(GolemEntity object) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/golem_texture.png");
        }

        @Override
        public ResourceLocation getAnimationResource(GolemEntity animatable) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "animations/golem.animation.json");
        }
    }
