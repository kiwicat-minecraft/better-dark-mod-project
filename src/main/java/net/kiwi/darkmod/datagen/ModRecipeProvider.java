package net.kiwi.darkmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kiwi.darkmod.block.ModBlocks;
import net.kiwi.darkmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> VOID_ORE_SMELTABLES = List.of(ModBlocks.VOID_DIAMOND_ORE_BLOCK, ModBlocks.VOID_DIAMOND_ORE_DEEPSLATE_BLOCK);
        List<ItemConvertible> VOID_BRICK_SMELTABLES = List.of(ModItems.VOID_CLAY);
        offerSmelting(recipeExporter, VOID_ORE_SMELTABLES, RecipeCategory.MISC, ModItems.VOID_DIAMOND,1f, 200,"void_diamond");
        offerSmelting(recipeExporter, VOID_BRICK_SMELTABLES, RecipeCategory.MISC, ModItems.VOID_BRICK, 1f, 100,"void_brick");
        offerBlasting(recipeExporter, VOID_ORE_SMELTABLES, RecipeCategory.MISC, ModItems.VOID_DIAMOND,1f, 100,"void_diamond");
        offerBlasting(recipeExporter, VOID_BRICK_SMELTABLES, RecipeCategory.MISC, ModItems.VOID_BRICK, 1f, 40,"void_brick");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.VOID_DIAMOND, RecipeCategory.MISC, ModBlocks.VOID_DIAMOND_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.VOID_GOO, RecipeCategory.MISC, ModBlocks.TRUE_VOID_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.VOID_ALTAR)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("DDD")
                .input('G', ModItems.VOID_GOO)
                .input('D', ModItems.VOID_DIAMOND)
                .criterion(hasItem(ModItems.VOID_DIAMOND), conditionsFromItem(ModItems.VOID_DIAMOND))
                .offerTo(recipeExporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VOID_STAFF, 1)
                .input(ModItems.VOID_GOO)
                .criterion(hasItem(ModItems.VOID_GOO), conditionsFromItem(ModItems.VOID_GOO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VOID_CLAY)
                .pattern("GD ")
                .pattern("DG ")
                .input('G', ModItems.VOID_GOO)
                .input('D', ModItems.VOID_DIAMOND)
                .criterion(hasItem(ModItems.VOID_GOO), conditionsFromItem(ModItems.VOID_GOO))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.VOID_DIAMOND_SWORD)
                .pattern(" D ")
                .pattern(" D ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('D', ModItems.VOID_DIAMOND)
                .criterion(hasItem(ModItems.VOID_DIAMOND), conditionsFromItem(ModItems.VOID_DIAMOND))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.VOID_DIAMOND_AXE)
                .pattern(" DD")
                .pattern(" SD")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('D', ModItems.VOID_DIAMOND)
                .criterion(hasItem(ModItems.VOID_DIAMOND), conditionsFromItem(ModItems.VOID_DIAMOND))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.VOID_DIAMOND_PICKAXE)
                .pattern("DDD")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('D', ModItems.VOID_DIAMOND)
                .criterion(hasItem(ModItems.VOID_DIAMOND), conditionsFromItem(ModItems.VOID_DIAMOND))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.VOID_DIAMOND_SHOVEL)
                .pattern(" D ")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('D', ModItems.VOID_DIAMOND)
                .criterion(hasItem(ModItems.VOID_DIAMOND), conditionsFromItem(ModItems.VOID_DIAMOND))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.VOID_DIAMOND_HOE)
                .pattern(" DD")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('D', ModItems.VOID_DIAMOND)
                .criterion(hasItem(ModItems.VOID_DIAMOND), conditionsFromItem(ModItems.VOID_DIAMOND))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.VOID_DIAMOND_HAMMER)
                .pattern("DDD")
                .pattern("DDD")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('D', ModItems.VOID_DIAMOND)
                .criterion(hasItem(ModItems.VOID_DIAMOND), conditionsFromItem(ModItems.VOID_DIAMOND))
                .offerTo(recipeExporter);

        offer2x2CompactingRecipe(recipeExporter, RecipeCategory.MISC, ModBlocks.VOID_BRICK_BLOCK, ModItems.VOID_BRICK);

        offerSlabRecipe(recipeExporter, RecipeCategory.MISC, ModBlocks.VOID_BRICK_SLAB, ModItems.VOID_BRICK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModBlocks.VOID_BRICK_STAIRS, 6)
                .pattern("D  ")
                .pattern("DD ")
                .pattern("DDD")
                .input('D', ModItems.VOID_BRICK)
                .criterion(hasItem(ModItems.VOID_BRICK), conditionsFromItem(ModItems.VOID_BRICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModBlocks.VOID_BRICK_DOOR)
                .pattern("DD ")
                .pattern("DD ")
                .pattern("DD ")
                .input('D', ModItems.VOID_BRICK)
                .criterion(hasItem(ModItems.VOID_BRICK), conditionsFromItem(ModItems.VOID_BRICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.VOID_DIAMOND_CHESTPLATE)
                .pattern("D D")
                .pattern("DDD")
                .pattern("DDD")
                .input('D', ModItems.VOID_DIAMOND)
                .criterion(hasItem(ModItems.VOID_DIAMOND), conditionsFromItem(ModItems.VOID_DIAMOND))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.VOID_DIAMOND_BOOTS)
                .pattern("D D")
                .pattern("D D")
                .input('D', ModItems.VOID_DIAMOND)
                .criterion(hasItem(ModItems.VOID_DIAMOND), conditionsFromItem(ModItems.VOID_DIAMOND))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.VOID_DIAMOND_LEGGINGS)
                .pattern("DDD")
                .pattern("D D")
                .pattern("D D")
                .input('D', ModItems.VOID_DIAMOND)
                .criterion(hasItem(ModItems.VOID_DIAMOND), conditionsFromItem(ModItems.VOID_DIAMOND))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.VOID_DIAMOND_HELMET)
                .pattern("DDD")
                .pattern("D D")
                .input('D', ModItems.VOID_DIAMOND)
                .criterion(hasItem(ModItems.VOID_DIAMOND), conditionsFromItem(ModItems.VOID_DIAMOND))
                .offerTo(recipeExporter);





    }

}
