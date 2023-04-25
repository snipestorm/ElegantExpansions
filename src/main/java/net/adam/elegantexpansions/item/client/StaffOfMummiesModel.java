package net.adam.elegantexpansions.item.client;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.item.custom.StaffOfMummiesItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class StaffOfMummiesModel extends GeoModel<StaffOfMummiesItem> {
    @Override
    public ResourceLocation getModelResource(StaffOfMummiesItem animatable) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "geo/staff.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StaffOfMummiesItem animatable) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "textures/item/stafftextureon.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StaffOfMummiesItem animatable) {
        return new ResourceLocation(ElegantExpansions.MOD_ID, "animations/staff.animation.json");
    }
}
