package net.kiwi.darkmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kiwi.darkmod.block.ModBlocks;
import net.kiwi.darkmod.block.custom.VoidBerryBushBlock;
import net.kiwi.darkmod.block.custom.VoidcarrotCropBlock;
import net.kiwi.darkmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        addDrop(ModBlocks.TRUE_VOID_BLOCK);
        addDrop(ModBlocks.VOID_DIAMOND_BLOCK);
        addDrop(ModBlocks.VOID_ALTAR);

        addDrop(ModBlocks.VOID_BRICK_STAIRS);
        addDrop(ModBlocks.VOID_BRICK_BUTTON);
        addDrop(ModBlocks.VOID_BRICK_FENCE);
        addDrop(ModBlocks.VOID_BRICK_FENCE_GATE);
        addDrop(ModBlocks.VOID_BRICK_SLAB, slabDrops(ModBlocks.VOID_BRICK_SLAB));
        addDrop(ModBlocks.VOID_BRICK_WALL);
        addDrop(ModBlocks.VOID_BRICK_DOOR, doorDrops(ModBlocks.VOID_BRICK_DOOR));
        addDrop(ModBlocks.VOID_BRICK_PRESSURE_PLATE);
        addDrop(ModBlocks.VOID_BRICK_TRAPDOOR);

        addDrop(ModBlocks.VOID_DIAMOND_ORE_BLOCK, oreDrops(ModBlocks.VOID_DIAMOND_ORE_BLOCK, ModItems.VOID_DIAMOND));
        addDrop(ModBlocks.VOID_DIAMOND_ORE_DEEPSLATE_BLOCK, multipleOreDrops(ModBlocks.VOID_DIAMOND_ORE_DEEPSLATE_BLOCK, ModItems.VOID_DIAMOND,2, 10));
        addDrop(ModBlocks.VOID_GOO_BLOCK, oreDrops(ModBlocks.VOID_GOO_BLOCK, ModItems.VOID_GOO));
        addDrop(ModBlocks.VOID_GOO_DEEPSLATE_BLOCK, multipleOreDrops(ModBlocks.VOID_GOO_DEEPSLATE_BLOCK, ModItems.VOID_GOO,2, 5));

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.VOIDCARROT_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(VoidcarrotCropBlock.AGE, VoidcarrotCropBlock.MAX_AGE));
        this.addDrop(ModBlocks.VOIDCARROT_CROP, this.cropDrops(ModBlocks.VOIDCARROT_CROP, ModItems.VOID_CARROT, ModItems.VOIDCARROT_SEEDS, builder2));

        this.addDrop(ModBlocks.VOID_BERRY_BUSH,


                block -> this.applyExplosionDecay(


                        block,LootTable.builder().pool(LootPool.builder().conditionally(
                                                BlockStatePropertyLootCondition.builder(ModBlocks.VOID_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(VoidBerryBushBlock.AGE, 3))
                                        )
                                .with(ItemEntry.builder(ModItems.VOID_BERRY))

                                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                            .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                        ).pool(LootPool.builder().conditionally(
                                            BlockStatePropertyLootCondition.builder(ModBlocks.VOID_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(VoidBerryBushBlock.AGE, 2))
                                )   .with(ItemEntry.builder(ModItems.VOID_BERRY))
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));
    }
    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)));
    }
}
