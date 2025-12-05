package com.example.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import com.example.block.ModBlocks;
import com.example.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) { super(output); }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // Generates the JSON files for the block and the block item
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LUMENITE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Basic item model
        itemModelGenerator.register(ModItems.LUMENITE, Models.GENERATED);
        
        // Tool models use HANDHELD
        itemModelGenerator.register(ModItems.LUMENITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LUMENITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LUMENITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LUMENITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LUMENITE_HOE, Models.HANDHELD);

        // Armor models use GENERATED, as they are rendered differently
        itemModelGenerator.registerArmor(ModItems.LUMENITE_HELMET);
        itemModelGenerator.registerArmor(ModItems.LUMENITE_CHESTPLATE);
        itemModelGenerator.registerArmor(ModItems.LUMENITE_LEGGINGS);
        itemModelGenerator.registerArmor(ModItems.LUMENITE_BOOTS);
    }
}