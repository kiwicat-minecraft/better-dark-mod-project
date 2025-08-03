package net.kiwi.darkmod.sound;

import net.kiwi.darkmod.BetterDarkMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent STAFF_USE = registerSoundEvent("staff_use");

    public static final SoundEvent ALTAR_BREAK = registerSoundEvent("altar_break");
    public static final SoundEvent ALTAR_STEP = registerSoundEvent("altar_step");
    public static final SoundEvent ALTAR_PLACE = registerSoundEvent("altar_place");
    public static final SoundEvent ALTAR_HIT = registerSoundEvent("altar_hit");
    public static final SoundEvent ALTAR_FALL = registerSoundEvent("altar_fall");

    public static final BlockSoundGroup ALTAR_SOUNDS = new BlockSoundGroup(1f, 1f,
            ALTAR_BREAK, ALTAR_STEP, ALTAR_PLACE, ALTAR_HIT, ALTAR_FALL);




    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(BetterDarkMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }


    public static void registerSounds(){
        BetterDarkMod.LOGGER.info("Registering Mod Sounds for " + BetterDarkMod.MOD_ID);
    }
}
