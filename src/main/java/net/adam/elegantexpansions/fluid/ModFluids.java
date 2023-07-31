package net.adam.elegantexpansions.fluid;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, ElegantExpansions.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_MAGICAL_SAP = FLUIDS.register("magic_sap_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.MAGICAL_SAP_FLUID_PROPERTIES) {
        @Override
                public @NotNull Optional getPickupSound() {
            return Optional.of(SoundEvents.BUCKET_FILL);
        }
            });
    public static final RegistryObject<FlowingFluid> FLOWING_MAGICAL_SAP = FLUIDS.register("flowing_magic_sap_fluid",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MAGICAL_SAP_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties MAGICAL_SAP_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MAGICAL_SAP_FLUID_TYPE, SOURCE_MAGICAL_SAP, FLOWING_MAGICAL_SAP)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModBlocks.MAGICAL_SAP_BLOCK)
            .bucket(ModItems.MAGICAL_SAP_BUCKET);


    public static void register (IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
