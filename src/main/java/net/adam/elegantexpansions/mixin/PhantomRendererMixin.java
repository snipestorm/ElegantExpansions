package net.adam.elegantexpansions.mixin;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.worldgen.biome.ModBiomes;
import net.minecraft.client.renderer.entity.PhantomRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Phantom;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PhantomRenderer.class)
public class PhantomRendererMixin {
    @Inject(method = "getTextureLocation", at = @At("HEAD"), cancellable = true)
    public void getTextureLocation(Phantom entity, CallbackInfoReturnable<ResourceLocation> cir) {
        if(entity.level().getBiome(entity.blockPosition()).is(ModBiomes.ECHOING_WASTES.location())) {
            cir.setReturnValue(new ResourceLocation(ElegantExpansions.MOD_ID, "textures/entity/sculk_phantom.png"));
        }
    }
}