package net.kiwi.darkmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kiwi.darkmod.BetterDarkMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item VOID_ORE = registerItem("void_ore", new Item(new Item.Settings()));
    public static final Item VOID_GOO = registerItem("void_goo", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(BetterDarkMod.MOD_ID, name),item);
    }

    public static void registerModItems(){
        BetterDarkMod.LOGGER.info("Registering Mod Items for "+ BetterDarkMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(VOID_ORE);
            fabricItemGroupEntries.add(VOID_GOO);
        });
    }
}
