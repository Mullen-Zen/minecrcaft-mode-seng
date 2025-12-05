package com.example.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;
import com.example.LumeniteMod;
import java.util.List;
import java.util.Map;
import com.google.common.base.Suppliers;

public enum ModArmorMaterials implements ArmorMaterial {
    LUMENITE(Util.make(
            Map.of(
                ArmorItem.Type.BOOTS, 3,    
                ArmorItem.Type.LEGGINGS, 6, 
                ArmorItem.Type.CHESTPLATE, 8, 
                ArmorItem.Type.HELMET, 3
            ), 
            map -> map.put(ArmorItem.Type.BODY, 11)
        ), 18, 
        RegistryEntry.of(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND), 
        Suppliers.memoize(() -> Ingredient.ofItems(ModItems.LUMENITE)), 
        3.0F, // Toughness (Diamond is 2.0F, Netherite is 3.0F)
        0.1F  // Knockback Resistance
    );

    private final Map<ArmorItem.Type, Integer> baseProtection;
    private final int durabilityMultiplier;
    private final RegistryEntry<SoundEvent> equipSound;
    private final Supplier<Ingredient> repairIngredient;
    private final float toughness;
    private final float knockbackResistance;
    private final String name;
    
    ModArmorMaterials(Map<ArmorItem.Type, Integer> protectionMap, int durabilityMultiplier, 
                      RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredient, 
                      float toughness, float knockbackResistance) {
        this.baseProtection = protectionMap;
        this.durabilityMultiplier = durabilityMultiplier;
        this.equipSound = equipSound;
        this.repairIngredient = repairIngredient;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.name = LumeniteMod.MOD_ID + ":lumenite"; 
    }

    @Override public int getDurability(ArmorItem.Type type) { return this.durabilityMultiplier * List.of(new Integer[]{11, 16, 15, 13}).get(type.ordinal()); }
    @Override public int getProtection(ArmorItem.Type type) { return this.baseProtection.getOrDefault(type, 0); }
    @Override public int getEnchantability() { return 18; }
    @Override public RegistryEntry<SoundEvent> getEquipSound() { return this.equipSound; }
    @Override public Ingredient getRepairIngredient() { return this.repairIngredient.get(); }
    @Override public String getName() { return this.name; }
    @Override public float getToughness() { return this.toughness; }
    @Override public float getKnockbackResistance() { return this.knockbackResistance; }
}