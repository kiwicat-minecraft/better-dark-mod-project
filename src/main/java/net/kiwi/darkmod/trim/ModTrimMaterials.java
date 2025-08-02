package net.kiwi.darkmod.trim;

import net.kiwi.darkmod.BetterDarkMod;
import net.kiwi.darkmod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class ModTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> VOID_DIAMOND = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(BetterDarkMod.MOD_ID, "void_diamond"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable){
        register(registerable, VOID_DIAMOND, Registries.ITEM.getEntry(ModItems.VOID_DIAMOND),
                Style.EMPTY.withColor(TextColor.parse("#4b0082").getOrThrow()), 1.0f);
    }




    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimKey,
                                 RegistryEntry<Item> item, Style style, float itemModelIndex){
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(armorTrimKey.getValue().getPath(), item, itemModelIndex, Map.of(),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimKey.getValue())).fillStyle(style));

        registerable.register(armorTrimKey, trimMaterial);
    }
}
