package com.example.item;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import com.google.common.base.Suppliers;
import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
    // Stats: durability: 2000 (Netherite is 2031), miningSpeed: 9.0F (Diamond is 8.0F)
    LUMENITE(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2000, 9.0F, 3.5F, 18, () -> Ingredient.ofItems(ModItems.LUMENITE));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(TagKey<Block> inverseTag, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient);
    }

    @Override public int getDurability() { return this.itemDurability; }
    @Override public float getMiningSpeedMultiplier() { return this.miningSpeed; }
    @Override public float getAttackDamage() { return this.attackDamage; }
    @Override public TagKey<Block> getInverseTag() { return this.inverseTag; }
    @Override public int getEnchantability() { return this.enchantability; }
    @Override public Ingredient getRepairIngredient() { return this.repairIngredient.get(); }
}