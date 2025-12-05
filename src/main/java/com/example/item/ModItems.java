package com.example.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.example.LumeniteMod;

public class ModItems {
    
    // --- BASIC ITEM ---
    public static final Item LUMENITE = registerItem("lumenite", new Item(new Item.Settings()));
    
    // --- TOOLS ---
    public static final ToolMaterial LUMENITE_TOOL_MATERIAL = ModToolMaterials.LUMENITE;

    public static final Item LUMENITE_PICKAXE = registerItem("lumenite_pickaxe",
            new PickaxeItem(LUMENITE_TOOL_MATERIAL, new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(LUMENITE_TOOL_MATERIAL, 1.5f, -2.8f))));

    public static final Item LUMENITE_AXE = registerItem("lumenite_axe",
            new AxeItem(LUMENITE_TOOL_MATERIAL, new Item.Settings()
            .attributeModifiers(AxeItem.createAttributeModifiers(LUMENITE_TOOL_MATERIAL, 5.0f, -3.0f))));
            
    public static final Item LUMENITE_SHOVEL = registerItem("lumenite_shovel",
            new ShovelItem(LUMENITE_TOOL_MATERIAL, new Item.Settings()
            .attributeModifiers(ShovelItem.createAttributeModifiers(LUMENITE_TOOL_MATERIAL, 1.5f, -3.0f))));

    public static final Item LUMENITE_SWORD = registerItem("lumenite_sword",
            new SwordItem(LUMENITE_TOOL_MATERIAL, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(LUMENITE_TOOL_MATERIAL, 3, -2.4f))));
            
    public static final Item LUMENITE_HOE = registerItem("lumenite_hoe",
            new HoeItem(LUMENITE_TOOL_MATERIAL, new Item.Settings()
            .attributeModifiers(HoeItem.createAttributeModifiers(LUMENITE_TOOL_MATERIAL, -4.0f, 0.0f))));
            
    // --- ARMOR ---
    public static final ArmorMaterial LUMENITE_ARMOR_MATERIAL = ModArmorMaterials.LUMENITE;

    public static final Item LUMENITE_HELMET = registerItem("lumenite_helmet", 
            new ArmorItem(LUMENITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()));
            
    public static final Item LUMENITE_CHESTPLATE = registerItem("lumenite_chestplate", 
            new ArmorItem(LUMENITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
            
    public static final Item LUMENITE_LEGGINGS = registerItem("lumenite_leggings", 
            new ArmorItem(LUMENITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()));
            
    public static final Item LUMENITE_BOOTS = registerItem("lumenite_boots", 
            new ArmorItem(LUMENITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()));

    // --- REGISTRATION HELPERS ---
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LumeniteMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        // Registers the base item (Lumenite) to the INGREDIENTS tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(LUMENITE);
        });
        LumeniteMod.LOGGER.info("Registering Base Mod Items for " + LumeniteMod.MOD_ID);
    }
    
    public static void registerModToolsAndArmor() {
        // Registers Tools to the TOOLS tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(LUMENITE_PICKAXE);
            entries.add(LUMENITE_AXE);
            entries.add(LUMENITE_SHOVEL);
            entries.add(LUMENITE_HOE);
        });
        
        // Registers Armor to the COMBAT tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(LUMENITE_HELMET);
            entries.add(LUMENITE_CHESTPLATE);
            entries.add(LUMENITE_LEGGINGS);
            entries.add(LUMENITE_BOOTS);
        });
        LumeniteMod.LOGGER.info("Registered Tools and Armor for " + LumeniteMod.MOD_ID);
    }
}