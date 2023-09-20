package net.adam.elegantexpansions.enchantment;

import net.adam.elegantexpansions.item.custom.StaffOfMummiesItem;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ModEnchantmentCategory {
    public static final EnchantmentCategory STAFF = EnchantmentCategory.create("staff",
            item -> item instanceof StaffOfMummiesItem);

}


