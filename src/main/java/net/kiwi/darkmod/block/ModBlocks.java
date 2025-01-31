package net.kiwi.darkmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kiwi.darkmod.BetterDarkMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block TRUE_VOID_BLOCK = registerBlock("true_void_block",
            new Block(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .requiresTool()
                    .sounds(BlockSoundGroup.HONEY)));

    public static final Block VOID_DIAMOND_BLOCK = registerBlock("void_diamond_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .requiresTool()));

    public static final Block VOID_DIAMOND_ORE_BLOCK = registerBlock("void_diamond_ore_block",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create()
                            .strength(3f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.NETHERITE)));

    public static final Block VOID_GOO_BLOCK = registerBlock("void_goo_block",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create()
                            .strength(2f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.MUD)));

    public static final Block VOID_DIAMOND_ORE_DEEPSLATE_BLOCK = registerBlock("void_diamond_ore_deepslate_block",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create()
                            .strength(3f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.NETHERITE)));

    public static final Block VOID_GOO_DEEPSLATE_BLOCK = registerBlock("void_goo_deepslate_block",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create()
                            .strength(2f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.MUD)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BetterDarkMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(BetterDarkMod.MOD_ID, name ),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        BetterDarkMod.LOGGER.info("Registering Mod Blocks for " + BetterDarkMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.TRUE_VOID_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.VOID_DIAMOND_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.VOID_GOO_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.VOID_GOO_DEEPSLATE_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.VOID_DIAMOND_ORE_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.VOID_DIAMOND_ORE_DEEPSLATE_BLOCK);

        });
    }
}
