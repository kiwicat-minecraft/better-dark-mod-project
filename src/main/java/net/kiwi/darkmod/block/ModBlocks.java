package net.kiwi.darkmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kiwi.darkmod.BetterDarkMod;
import net.kiwi.darkmod.block.custom.VoidAltar;
import net.kiwi.darkmod.block.custom.VoidLampBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.List;

public class ModBlocks {

    public static final Block TRUE_VOID_BLOCK = registerBlock("true_void_block",
            new Block(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .requiresTool()
                    .sounds(BlockSoundGroup.HONEY)){
                @Override
                public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
                    tooltip.add(Text.translatable("tooltip.better-dark-mod.true_void_block"));
                    super.appendTooltip(stack, context, tooltip, options);
                }
            });

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
    public static final Block VOID_BRICK_BLOCK = registerBlock("void_brick_block",
            new Block(AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(3f)));

    public static final Block VOID_ALTAR =registerBlock("void_altar",
            new VoidAltar(AbstractBlock.Settings.create().requiresTool().strength(3f)));

    public static final Block VOID_BRICK_STAIRS = registerBlock("void_brick_stairs",
            new StairsBlock(ModBlocks.VOID_BRICK_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block VOID_BRICK_SLAB = registerBlock("void_brick_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block VOID_BRICK_BUTTON = registerBlock("void_brick_button",
            new ButtonBlock(BlockSetType.IRON,2,
                    AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));

    public static final Block VOID_BRICK_PRESSURE_PLATE = registerBlock("void_brick_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block VOID_BRICK_FENCE = registerBlock("void_brick_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block VOID_BRICK_FENCE_GATE = registerBlock("void_brick_fence_gate",
            new FenceGateBlock(WoodType.BIRCH,
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block VOID_BRICK_WALL = registerBlock("void_brick_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block VOID_BRICK_DOOR = registerBlock("void_brick_door",
            new DoorBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    public static final Block VOID_BRICK_TRAPDOOR = registerBlock("void_brick_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    public static final Block VOID_LAMP = registerBlock("void_lamp",
            new VoidLampBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
                    .luminance(state -> state.get(VoidLampBlock.CLICKED) ? 15 : 0)));

    public static final Block TEST_BLOCK = registerBlock("test_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()));

    public static final Block TEST_STAIRS = registerBlock("test_stairs",
            new StairsBlock(ModBlocks.TEST_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block TEST_SLAB = registerBlock("test_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block TEST_BUTTON = registerBlock("test_button",
            new ButtonBlock(BlockSetType.IRON,2,
                    AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));

    public static final Block TEST_PRESSURE_PLATE = registerBlock("test_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block TEST_FENCE = registerBlock("test_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block TEST_FENCE_GATE = registerBlock("test_fence_gate",
            new FenceGateBlock(WoodType.BIRCH,
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block TEST_WALL = registerBlock("test_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block TEST_DOOR = registerBlock("test_door",
            new DoorBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    public static final Block TEST_TRAPDOOR = registerBlock("test_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));










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
