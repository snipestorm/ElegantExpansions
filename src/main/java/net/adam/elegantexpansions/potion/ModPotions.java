package net.adam.elegantexpansions.potion;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, ElegantExpansions.MOD_ID);

    public static final RegistryObject<Potion> BLEED_POTION = POTIONS.register( "bleed_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.BLEED.get(),900)));

    public static final RegistryObject<Potion> STRONG_BLEED_POTION = POTIONS.register( "strong_bleed_potion",
            () -> new Potion("bleed_potion", new MobEffectInstance(ModEffects.BLEED.get(),450,1)));

    public static final RegistryObject<Potion> LONG_BLEED_POTION = POTIONS.register( "long_bleed_potion",
            () -> new Potion("bleed_potion", new MobEffectInstance(ModEffects.BLEED.get(),1800)));


    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
