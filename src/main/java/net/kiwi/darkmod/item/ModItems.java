package net.kiwi.darkmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kiwi.darkmod.BetterDarkMod;
import net.kiwi.darkmod.item.custom.VoidStaffItem;
import net.minecraft.item.*;
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

    public static final Item VOID_DIAMOND_SWORD = registerItem("void_diamond_sword",
            new SwordItem(ModToolMaterials.VOID_DIAMOND, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.VOID_DIAMOND, 6, -2.4f))));

    public static final Item VOID_DIAMOND_PICKAXE = registerItem("void_diamond_pickaxe",
            new PickaxeItem(ModToolMaterials.VOID_DIAMOND, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.VOID_DIAMOND, 1.5f, -2.8f))));

    public static final Item VOID_DIAMOND_SHOVEL = registerItem("void_diamond_shovel",
            new ShovelItem(ModToolMaterials.VOID_DIAMOND, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.VOID_DIAMOND, 2, -3))));

    public static final Item VOID_DIAMOND_AXE = registerItem("void_diamond_axe",
            new AxeItem(ModToolMaterials.VOID_DIAMOND, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.VOID_DIAMOND, 9, -2.8f))));

    public static final Item VOID_DIAMOND_HOE = registerItem("void_diamond_hoe",
            new HoeItem(ModToolMaterials.VOID_DIAMOND, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.VOID_DIAMOND, 0.1f, -3f))));

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
