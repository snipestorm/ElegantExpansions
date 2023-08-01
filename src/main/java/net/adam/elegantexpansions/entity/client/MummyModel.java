package net.adam.elegantexpansions.entity.client;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.MummyEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MummyModel extends GeoModel<MummyEntity> {
        @Override
        public ResourceLocation getModelResource(MummyEntity object) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "geo/mummy.geo.json");
        }

        @Override
        public ResourceLocation getTextureResource(MummyEntity object) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/mummy_texture.png");
        }

        @Override
        public ResourceLocation getAnimationResource(MummyEntity animatable) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "animations/mummy.animation.json");
        }
    }
