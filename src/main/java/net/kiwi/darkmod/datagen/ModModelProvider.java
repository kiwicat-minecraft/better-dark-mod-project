package net.kiwi.darkmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kiwi.darkmod.block.ModBlocks;
import net.kiwi.darkmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VOID_GOO_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VOID_GOO_DEEPSLATE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRUE_VOID_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VOID_DIAMOND_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VOID_DIAMOND_ORE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VOID_DIAMOND_ORE_DEEPSLATE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VOID_ALTAR);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.VOID_ORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOID_GOO, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOID_BERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOID_STAFF, Models.GENERATED);

    }
}
