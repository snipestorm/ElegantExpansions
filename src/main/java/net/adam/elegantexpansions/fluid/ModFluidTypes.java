package net.adam.elegantexpansions.fluid;

import net.adam.elegantexpansions.ElegantExpansions;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {

    public static final ResourceLocation MAGIC_STILL_RL =   new ResourceLocation(ElegantExpansions.MOD_ID,"block/magic_still");
    public static final ResourceLocation MAGIC_FLOWING_RL = new ResourceLocation(ElegantExpansions.MOD_ID,"block/magic_flow");
    public static final ResourceLocation MAGIC_OVERLAY_RL = new ResourceLocation(ElegantExpansions.MOD_ID,"block/magic_overlay");


    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, ElegantExpansions.MOD_ID);

    public static final RegistryObject<FluidType> MAGICAL_SAP_FLUID_TYPE = registerFluidType("magical_sap_fluid",
            new BaseFluidType(MAGIC_STILL_RL,MAGIC_FLOWING_RL,MAGIC_OVERLAY_RL, 0xA1941A9D, new Vector3f(148f / 255f, 26f / 255f, 157f / 255f), FluidType.Properties.create().lightLevel(2).viscosity(5).density(15)));

    private static RegistryObject<FluidType> registerFluidType(String name, FluidType fluidType) {
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register (IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
