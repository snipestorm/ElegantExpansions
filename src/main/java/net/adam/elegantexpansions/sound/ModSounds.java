package net.adam.elegantexpansions.sound;

import net.adam.elegantexpansions.ElegantExpansions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ElegantExpansions.MOD_ID);

    //golem//
    public static final SoundEvent GOLEM_ROAR = register("golem_roar");
    public static final SoundEvent GOLEM_WALK = register("golem_walk");
    public static final SoundEvent GOLEM_HURT = register("golem_hurt");
    public static final SoundEvent GOLEM_DEATH = register("golem_death");
    //Anubis//
    public static final SoundEvent ANUBIS_AMBIENT = register("anubis_ambient");
    public static final SoundEvent ANUBIS_HEAL1 = register("anubis_unstoppable");
    public static final SoundEvent ANUBIS_HEAL2 = register("anubis_bless_me_again");
    public static final SoundEvent ANUBIS_HEAL3 = register("anubis_restore_me");
    public static final SoundEvent ANUBIS_AWAKEN = register("anubis_awaken_friends");

    //shrek//
    public static final SoundEvent SHREK_DONKEY = register("shrek_donkey");
    public static final SoundEvent SHREK_AMBIENT = register("shrek_ambient");

    //tiger//
    private static SoundEvent register(String soundname) {
        return SoundEvent.createVariableRangeEvent(new ResourceLocation(ElegantExpansions.MOD_ID, soundname));}


    public static void register (IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
