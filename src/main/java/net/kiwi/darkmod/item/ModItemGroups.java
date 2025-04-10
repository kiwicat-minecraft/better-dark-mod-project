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
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.VOID_DIAMOND))
                    .displayName(Text.translatable("itemgroup.better-dark-mod.void_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.VOID_GOO);
                        entries.add(ModItems.VOID_DIAMOND);
                        entries.add(ModItems.VOID_BERRY);
                        entries.add(ModItems.VOID_BRICK);
                        entries.add(ModItems.VOID_CLAY);

                        entries.add(ModItems.VOID_STAFF);

                        entries.add(ModItems.VOID_DIAMOND_SWORD);
                        entries.add(ModItems.VOID_DIAMOND_SHOVEL);
                        entries.add(ModItems.VOID_DIAMOND_AXE);
                        entries.add(ModItems.VOID_DIAMOND_HOE);
                        entries.add(ModItems.VOID_DIAMOND_PICKAXE);
                        entries.add(ModItems.VOID_DIAMOND_HAMMER);

                        entries.add(ModItems.VOID_DIAMOND_CHESTPLATE);
                        entries.add(ModItems.VOID_DIAMOND_BOOTS);
                        entries.add(ModItems.VOID_DIAMOND_LEGGINGS);
                        entries.add(ModItems.VOID_DIAMOND_HELMET);
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
                        entries.add(ModBlocks.VOID_BRICK_BLOCK);

                        entries.add(ModBlocks.VOID_BRICK_STAIRS);
                        entries.add(ModBlocks.VOID_BRICK_BUTTON);
                        entries.add(ModBlocks.VOID_BRICK_DOOR);
                        entries.add(ModBlocks.VOID_BRICK_FENCE);
                        entries.add(ModBlocks.VOID_BRICK_SLAB);
                        entries.add(ModBlocks.VOID_BRICK_FENCE_GATE);
                        entries.add(ModBlocks.VOID_BRICK_TRAPDOOR);
                        entries.add(ModBlocks.VOID_BRICK_WALL);
                        entries.add(ModBlocks.VOID_BRICK_PRESSURE_PLATE);


                        entries.add(ModBlocks.VOID_LAMP);

                    }).build());

    public static final ItemGroup VOID_TEST_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BetterDarkMod.MOD_ID, "void_test"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.TEST_BLOCK))
                    .displayName(Text.translatable("itemgroup.better-dark-mod.void_test"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.TEST_BLOCK);

                        entries.add(ModBlocks.TEST_STAIRS);
                        entries.add(ModBlocks.TEST_BUTTON);
                        entries.add(ModBlocks.TEST_DOOR);
                        entries.add(ModBlocks.TEST_FENCE);
                        entries.add(ModBlocks.TEST_SLAB);
                        entries.add(ModBlocks.TEST_FENCE_GATE);
                        entries.add(ModBlocks.TEST_TRAPDOOR);
                        entries.add(ModBlocks.TEST_WALL);
                        entries.add(ModBlocks.TEST_PRESSURE_PLATE);


                    }).build());

    public static void registerItemGroups(){
        BetterDarkMod.LOGGER.info("Registering Item Groups for "+ BetterDarkMod.MOD_ID);
    }
}
