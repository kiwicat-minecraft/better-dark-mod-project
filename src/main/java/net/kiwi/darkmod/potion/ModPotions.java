package net.kiwi.darkmod.potion;

import net.kiwi.darkmod.BetterDarkMod;
import net.kiwi.darkmod.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {

    public static final RegistryEntry<Potion> TELEPORTY_POTION = registerPotion("teleporty_potion",
            new Potion(new StatusEffectInstance(ModEffects.TELEPORTY, 400, 1)));

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(BetterDarkMod.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        BetterDarkMod.LOGGER.info("Registering Potions for " + BetterDarkMod.MOD_ID);
    }
}
