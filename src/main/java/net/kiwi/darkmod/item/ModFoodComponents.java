package net.kiwi.darkmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static FoodComponent VOID_BERRY = new FoodComponent.Builder().snack().saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 600), 0.5f).nutrition(10).build();
    public static FoodComponent VOID_CARROT = new FoodComponent.Builder().snack().saturationModifier(0.7f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 600), 0.1f).nutrition(10).build();
}
