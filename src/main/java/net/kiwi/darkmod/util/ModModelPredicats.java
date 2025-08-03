package net.kiwi.darkmod.util;

import net.kiwi.darkmod.BetterDarkMod;
import net.kiwi.darkmod.component.ModDataComponentTypes;
import net.kiwi.darkmod.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModModelPredicats {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.VOID_STAFF, Identifier.of(BetterDarkMod.MOD_ID, "used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null ? 1f : 0f);

        registerCustomBow(ModItems.VOID_BOW);


    }

    private static  void registerCustomBow(Item item){

        ModelPredicateProviderRegistry.register(item, Identifier.ofVanilla("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float)(stack.getMaxUseTime(entity) - entity.getItemUseTimeLeft()) / 20.0F;
            }
        });
        ModelPredicateProviderRegistry.register(
                item,
                Identifier.ofVanilla("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
        );

    }
}
