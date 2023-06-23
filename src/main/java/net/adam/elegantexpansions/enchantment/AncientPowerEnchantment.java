package net.adam.elegantexpansions.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class AncientPowerEnchantment extends Enchantment {


    protected AncientPowerEnchantment(Rarity p_44676_, EnchantmentCategory category, EquipmentSlot... p_44678_) {
        super(p_44676_, category, p_44678_);
    }



    @Override
    public boolean isTradeable() {
        return false;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}
