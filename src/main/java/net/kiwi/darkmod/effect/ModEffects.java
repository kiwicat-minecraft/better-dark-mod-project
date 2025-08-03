package net.kiwi.darkmod.effect;

import net.kiwi.darkmod.BetterDarkMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> TELEPORTY = registerStatusEffect("teleporty",
            new TeleportyEffect(StatusEffectCategory.NEUTRAL, 0x4b0082)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(BetterDarkMod.MOD_ID, "teleporty"), -0.15f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect StatusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BetterDarkMod.MOD_ID, name), StatusEffect);
    }

    public static void registerEffects() {
        BetterDarkMod.LOGGER.info("Registering Mod Effects for " + BetterDarkMod.MOD_ID);
    }

}
