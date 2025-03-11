package net.kiwi.darkmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kiwi.darkmod.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.VOID_DIAMOND_BLOCK)
                .add(ModBlocks.VOID_DIAMOND_ORE_BLOCK)
                .add(ModBlocks.VOID_GOO_DEEPSLATE_BLOCK)
                .add(ModBlocks.VOID_GOO_BLOCK)
                .add(ModBlocks.VOID_DIAMOND_ORE_DEEPSLATE_BLOCK)
                .add(ModBlocks.VOID_ALTAR);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.TRUE_VOID_BLOCK)
                .add(ModBlocks.VOID_ALTAR)
                .add(ModBlocks.VOID_DIAMOND_BLOCK)
                .add(ModBlocks.VOID_GOO_BLOCK)
                .add(ModBlocks.VOID_GOO_DEEPSLATE_BLOCK)
                .add(ModBlocks.VOID_DIAMOND_ORE_BLOCK)
                .add(ModBlocks.VOID_DIAMOND_ORE_DEEPSLATE_BLOCK);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.VOID_BRICK_FENCE)
                .add(ModBlocks.TEST_FENCE);


        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.VOID_BRICK_FENCE_GATE)
                .add(ModBlocks.TEST_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.VOID_BRICK_WALL)
                .add(ModBlocks.TEST_WALL);

    }
}
