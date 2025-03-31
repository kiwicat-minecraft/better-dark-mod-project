package net.kiwi.darkmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kiwi.darkmod.block.ModBlocks;
import net.kiwi.darkmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
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
    }
    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)));
    }
}
