package com.example.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import com.example.LumeniteMod;

public class ModBlocks {

    // Define the Ore Block
    // Settings: strength(3.0f) is typical for stone/ore; requiresTool() is necessary for pickaxe interaction.
    public static final Block LUMENITE_ORE = registerBlock("lumenite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), // Drops 2-5 XP when mined
                    AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.STONE)));

    // Helper to register the Block and its corresponding Item (so you can hold and place it)
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(LumeniteMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = new BlockItem(block, new Item.Settings());
        return Registry.register(Registries.ITEM, Identifier.of(LumeniteMod.MOD_ID, name), item);
    }

    public static void registerModBlocks() {
        // Registers the block item to the NATURAL item group in the creative menu
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(LUMENITE_ORE);
        });
        LumeniteMod.LOGGER.info("Registering Mod Blocks for " + LumeniteMod.MOD_ID);
    }
}