package com.example.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import com.example.block.ModBlocks;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        // Defines the Lumenite Ore as mineable by a Pickaxe
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.LUMENITE_ORE);

        // Defines that the Lumenite Ore requires at least a Diamond Level tool (or higher) to drop loot
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL) 
                .add(ModBlocks.LUMENITE_ORE);
    }
}