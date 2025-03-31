package net.kiwi.darkmod.item;

import net.kiwi.darkmod.BetterDarkMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> VOID_DIAMOND_ARMOR_MATERIAL = registerArmorMaterial("void_diamond",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 5);
                map.put(ArmorItem.Type.LEGGINGS, 8);
                map.put(ArmorItem.Type.CHESTPLATE, 10);
                map.put(ArmorItem.Type.HELMET, 5);
                map.put(ArmorItem.Type.BODY, 13);
            }), 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, ()-> Ingredient.ofItems(ModItems.VOID_DIAMOND),
                    List.of(new ArmorMaterial.Layer(Identifier.of(BetterDarkMod.MOD_ID, "void_diamond"))), 0, 0));


    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material){
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(BetterDarkMod.MOD_ID, name), material.get());
    }
}
