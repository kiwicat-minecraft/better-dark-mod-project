package net.kiwi.darkmod.enchantment;

import com.mojang.serialization.MapCodec;
import net.kiwi.darkmod.BetterDarkMod;
import net.kiwi.darkmod.enchantment.custom.CatifyEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> CATIFY =
            registerEntityEffect("catify", CatifyEnchantmentEffect.CODEC);


    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(BetterDarkMod.MOD_ID, name), codec);
    }


    public static void registerEnchantmentEffects() {
        BetterDarkMod.LOGGER.info("Registering Mod Enchantment Effects for " + BetterDarkMod.MOD_ID);
    }
}
