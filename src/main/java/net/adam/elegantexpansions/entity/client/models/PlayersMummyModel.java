package net.adam.elegantexpansions.entity.client.models;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.MummyEntity;
import net.adam.elegantexpansions.entity.custom.PlayersMummy;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlayersMummyModel extends GeoModel<PlayersMummy> {
        @Override
        public ResourceLocation getModelResource(PlayersMummy object) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "geo/mummy.geo.json");
        }

        @Override
        public ResourceLocation getTextureResource(PlayersMummy object) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/players_mummy_texture.png");
        }

        @Override
        public ResourceLocation getAnimationResource(PlayersMummy animatable) {
            return new ResourceLocation(ElegantExpansions.MOD_ID, "animations/mummy.animation.json");
        }
    }
