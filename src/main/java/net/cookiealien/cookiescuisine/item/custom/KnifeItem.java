package net.cookiealien.cookiescuisine.item.custom;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.DigDurabilityEnchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;

public class KnifeItem extends SwordItem {
    public KnifeItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        var copy = itemStack.copy();
        copy.setCount(1);
        var unbreaking = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.UNBREAKING,itemStack);

        for (var i = 0; i < unbreaking;i++){
            if(DigDurabilityEnchantment.shouldIgnoreDurabilityDrop(itemStack, unbreaking, RandomSource.create())){
                return copy;
            }
        }
        copy.setDamageValue(itemStack.getDamageValue() + 1);

        if (copy.getDamageValue() > itemStack.getMaxDamage()){
            return ItemStack.EMPTY;
        }
        return copy;
    }
}
