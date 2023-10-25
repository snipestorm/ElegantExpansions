package net.adam.elegantexpansions.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class BleedEffect extends MobEffect {
    public BleedEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level().isClientSide()) {
            pLivingEntity.hurt(pLivingEntity.damageSources().generic(), 1.5F);
        }
    }

    public boolean isDurationEffectTick(int p_19455_, int p_19456_) {
        if (this == ModEffects.BLEED.get()) {
            int i = 20 >> p_19456_;
            if (i > 0) {
                return p_19455_ % i == 0;
            } else {
                return true;
            }
        } else {
            return this == MobEffects.HUNGER;
        }
    }
}


