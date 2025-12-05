package com.example.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import com.example.item.ModItems;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        String L = "L";
        String S = "S";
        
        // --- TOOL RECIPES (Using Lumenite 'L' and Stick 'S') ---
        // Pickaxe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LUMENITE_PICKAXE)
                .pattern("LLL")
                .pattern(" S ")
                .pattern(" S ")
                .input('L', ModItems.LUMENITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.LUMENITE), conditionsFromItem(ModItems.LUMENITE))
                .offerTo(exporter);

        // Axe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LUMENITE_AXE)
                .pattern("LL")
                .pattern("LS")
                .pattern(" S")
                .input('L', ModItems.LUMENITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.LUMENITE), conditionsFromItem(ModItems.LUMENITE))
                .offerTo(exporter);
                
        // Sword
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMENITE_SWORD)
                .pattern("L")
                .pattern("L")
                .pattern("S")
                .input('L', ModItems.LUMENITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.LUMENITE), conditionsFromItem(ModItems.LUMENITE))
                .offerTo(exporter);

        // --- ARMOR RECIPES ---
        // Helmet
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMENITE_HELMET)
                .pattern("LLL")
                .pattern("L L")
                .pattern("   ")
                .input('L', ModItems.LUMENITE)
                .criterion(hasItem(ModItems.LUMENITE), conditionsFromItem(ModItems.LUMENITE))
                .offerTo(exporter);

        // Chestplate
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMENITE_CHESTPLATE)
                .pattern("L L")
                .pattern("LLL")
                .pattern("LLL")
                .input('L', ModItems.LUMENITE)
                .criterion(hasItem(ModItems.LUMENITE), conditionsFromItem(ModItems.LUMENITE))
                .offerTo(exporter);
        
        // Leggings
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMENITE_LEGGINGS)
                .pattern("LLL")
                .pattern("L L")
                .pattern("L L")
                .input('L', ModItems.LUMENITE)
                .criterion(hasItem(ModItems.LUMENITE), conditionsFromItem(ModItems.LUMENITE))
                .offerTo(exporter);
                
        // Boots
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMENITE_BOOTS)
                .pattern("   ")
                .pattern("L L")
                .pattern("L L")
                .input('L', ModItems.LUMENITE)
                .criterion(hasItem(ModItems.LUMENITE), conditionsFromItem(ModItems.LUMENITE))
                .offerTo(exporter);
    }
}