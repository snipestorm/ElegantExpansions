package net.adam.elegantexpansions.enchantment;

import net.adam.elegantexpansions.ElegantExpansions;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ElegantExpansions.MOD_ID);

public static RegistryObject<Enchantment> LIGHTNING_STRIKE =
        ENCHANTMENTS.register("lightning_strike",
                () -> new LightningStrikeEnchantment(Enchantment.Rarity.VERY_RARE,
                        EnchantmentCategory.BOW));


    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }

}
