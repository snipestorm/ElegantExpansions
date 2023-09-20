package net.adam.elegantexpansions.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.BaseAshSmokeParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SandAshParticle extends BaseAshSmokeParticle {
    private static final int COLOR_RGB24 = 13947530;

    protected SandAshParticle(ClientLevel p_108512_, double p_108513_, double p_108514_, double p_108515_, double p_108516_, double p_108517_, double p_108518_, float p_108519_, SpriteSet p_108520_) {
        super(p_108512_, p_108513_, p_108514_, p_108515_, 0.1F, -0.1F, 0.1F, p_108516_, p_108517_, p_108518_, p_108519_, p_108520_, 0.0F, 20, 0.0125F, false);
        this.rCol = 0.95703125F;
        this.gCol = 0.94140625F;
        this.bCol = 0.8515625F;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet p_108523_) {
            this.sprites = p_108523_;
        }

        public Particle createParticle(SimpleParticleType p_108534_, ClientLevel p_108535_, double p_108536_, double p_108537_, double p_108538_, double p_108539_, double p_108540_, double p_108541_) {
            RandomSource randomsource = p_108535_.random;
            double d0 = (double)randomsource.nextFloat() * -1.9D * (double)randomsource.nextFloat() * 0.05D * 50D;
            double d1 = (double)randomsource.nextFloat() * -0.5D * (double)randomsource.nextFloat() * 0.05D * 50.0D;
            double d2 = (double)randomsource.nextFloat() * -1.9D * (double)randomsource.nextFloat() * 0.05D * 50D;
            return new SandAshParticle(p_108535_, p_108536_, p_108537_, p_108538_, d0, d1, d2, 2.5F, this.sprites);
        }
    }
}