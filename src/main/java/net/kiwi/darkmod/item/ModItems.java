package net.kiwi.darkmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kiwi.darkmod.BetterDarkMod;
import net.kiwi.darkmod.item.custom.VoidStaffItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item VOID_ORE = registerItem("void_ore", new Item(new Item.Settings()));
    public static final Item VOID_GOO = registerItem("void_goo", new Item(new Item.Settings()));
    public static final Item VOID_BRICK = registerItem("void_brick", new Item(new Item.Settings()));
    public static final Item VOID_CLAY = registerItem("void_clay", new Item(new Item.Settings()));
    public static final Item VOID_BERRY = registerItem("void_berry", new Item(new Item.Settings().food(ModFoodComponents.VOID_BERRY)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.better-dark-mod.void_berry"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item VOID_STAFF = registerItem("void_staff", new VoidStaffItem(new Item.Settings().maxDamage(32)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(BetterDarkMod.MOD_ID, name),item);
    }

    public static void registerModItems(){
        BetterDarkMod.LOGGER.info("Registering Mod Items for "+ BetterDarkMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(VOID_ORE);
            fabricItemGroupEntries.add(VOID_GOO);
            fabricItemGroupEntries.add(VOID_BRICK);
        });
    }
}
