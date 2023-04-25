package net.adam.elegantexpansions.item.client;

import net.adam.elegantexpansions.item.custom.StaffOfMummiesItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class StaffOfMummiesRenderer extends GeoItemRenderer<StaffOfMummiesItem> {
    public StaffOfMummiesRenderer() {
        super(new StaffOfMummiesModel());
    }
}
