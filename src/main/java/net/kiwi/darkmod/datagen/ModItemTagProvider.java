package net.kiwi.darkmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kiwi.darkmod.item.ModItems;
import net.kiwi.darkmod.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.VOID_GOO)
                .add(Items.DIAMOND)
                .add(Items.COAL)
                .add(Items.ENDERMAN_SPAWN_EGG);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.VOID_DIAMOND_SWORD);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.VOID_DIAMOND_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.VOID_DIAMOND_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.VOID_DIAMOND_HOE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.VOID_DIAMOND_PICKAXE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.VOID_DIAMOND_HELMET)
                .add(ModItems.VOID_DIAMOND_CHESTPLATE)
                .add(ModItems.VOID_DIAMOND_LEGGINGS)
                .add(ModItems.VOID_DIAMOND_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.VOID_DIAMOND);

        getOrCreateTagBuilder(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.VOID_DIAMOND_SMITHING_TEMPLATE);
    }
}
