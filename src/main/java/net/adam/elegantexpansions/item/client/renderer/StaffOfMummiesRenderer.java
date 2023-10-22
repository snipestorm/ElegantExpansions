package net.adam.elegantexpansions.item.client.renderer;

import net.adam.elegantexpansions.item.client.model.StaffOfMummiesModel;
import net.adam.elegantexpansions.item.custom.StaffOfMummiesItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class StaffOfMummiesRenderer extends GeoItemRenderer<StaffOfMummiesItem> {
    public StaffOfMummiesRenderer() {
        super(new StaffOfMummiesModel());
    }
}
