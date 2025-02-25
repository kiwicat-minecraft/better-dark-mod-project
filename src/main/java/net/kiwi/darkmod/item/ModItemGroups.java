package net.kiwi.darkmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kiwi.darkmod.BetterDarkMod;
import net.kiwi.darkmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup VOID_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BetterDarkMod.MOD_ID, "void_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.VOID_ORE))
                    .displayName(Text.translatable("itemgroup.better-dark-mod.void_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.VOID_GOO);
                        entries.add(ModItems.VOID_ORE);

                        entries.add(ModItems.VOID_STAFF);
                    }).build());

    public static final ItemGroup VOID_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BetterDarkMod.MOD_ID, "void_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.VOID_DIAMOND_BLOCK))
                    .displayName(Text.translatable("itemgroup.better-dark-mod.void_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.VOID_DIAMOND_BLOCK);
                        entries.add(ModBlocks.TRUE_VOID_BLOCK);
                        entries.add(ModBlocks.VOID_GOO_BLOCK);
                        entries.add(ModBlocks.VOID_GOO_DEEPSLATE_BLOCK);
                        entries.add(ModBlocks.VOID_DIAMOND_ORE_BLOCK);
                        entries.add(ModBlocks.VOID_DIAMOND_ORE_DEEPSLATE_BLOCK);
                        entries.add(ModBlocks.VOID_ALTAR);

                    }).build());

    public static void registerItemGroups(){
        BetterDarkMod.LOGGER.info("Registering Item Groups for "+ BetterDarkMod.MOD_ID);
    }
}
