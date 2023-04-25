package net.adam.elegantexpansions.sound;

import net.adam.elegantexpansions.ElegantExpansions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ElegantExpansions.MOD_ID);

    //golem//
    public static final RegistryObject<SoundEvent> GOLEM_ROAR = registerSoundEvent("golem_roar");
    public static final RegistryObject<SoundEvent> GOLEM_WALK = registerSoundEvent("golem_walk");
    public static final RegistryObject<SoundEvent> GOLEM_HURT = registerSoundEvent("golem_hurt");
    public static final RegistryObject<SoundEvent> GOLEM_DEATH = registerSoundEvent("golem_death");
    //Anubis//
    public static final RegistryObject<SoundEvent> ANUBIS_AMBIENT = registerSoundEvent("anubis_ambient");
    public static final RegistryObject<SoundEvent> ANUBIS_HEAL1 = registerSoundEvent("anubis_unstoppable");
    public static final RegistryObject<SoundEvent> ANUBIS_HEAL2 = registerSoundEvent("anubis_bless_me_again");
    public static final RegistryObject<SoundEvent> ANUBIS_HEAL3 = registerSoundEvent("anubis_restore_me");
    public static final RegistryObject<SoundEvent> ANUBIS_AWAKEN = registerSoundEvent("anubis_awaken_friends");

    //shrek//
    public static final RegistryObject<SoundEvent> SHREK_DONKEY = registerSoundEvent("shrek_donkey");
    public static final RegistryObject<SoundEvent> SHREK_AMBIENT = registerSoundEvent("shrek_ambient");

    //tiger//
    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(ElegantExpansions.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }


    public static void register (IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
