package net.kiwi.darkmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kiwi.darkmod.block.ModBlocks;
import net.kiwi.darkmod.block.custom.VoidLampBlock;
import net.kiwi.darkmod.item.ModItems;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

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

        BlockStateModelGenerator.BlockTexturePool voidbrickpool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VOID_BRICK_BLOCK);

        voidbrickpool.stairs(ModBlocks.VOID_BRICK_STAIRS);
        voidbrickpool.button(ModBlocks.VOID_BRICK_BUTTON);
        voidbrickpool.fence(ModBlocks.VOID_BRICK_FENCE);
        voidbrickpool.fenceGate(ModBlocks.VOID_BRICK_FENCE_GATE);
        voidbrickpool.slab(ModBlocks.VOID_BRICK_SLAB);
        voidbrickpool.wall(ModBlocks.VOID_BRICK_WALL);
        voidbrickpool.pressurePlate(ModBlocks.VOID_BRICK_PRESSURE_PLATE);

        blockStateModelGenerator.registerDoor(ModBlocks.VOID_BRICK_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.VOID_BRICK_TRAPDOOR);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.VOID_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.VOID_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.VOID_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(VoidLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.VOID_ORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOID_GOO, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOID_BERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOID_STAFF, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOID_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOID_CLAY, Models.GENERATED);
    }
}
