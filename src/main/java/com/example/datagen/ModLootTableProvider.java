package com.example.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import com.example.block.ModBlocks;
import com.example.item.ModItems;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        // Ore drops Lumenite item, supporting Fortune enchantment
        addDrop(ModBlocks.LUMENITE_ORE, oreDrops(ModBlocks.LUMENITE_ORE, ModItems.LUMENITE));
    }
}