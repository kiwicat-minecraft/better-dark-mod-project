package net.kiwi.darkmod.util;

import net.kiwi.darkmod.BetterDarkMod;
import net.kiwi.darkmod.component.ModDataComponentTypes;
import net.kiwi.darkmod.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicats {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.VOID_STAFF, Identifier.of(BetterDarkMod.MOD_ID, "used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null ? 1f : 0f);


    }
}
