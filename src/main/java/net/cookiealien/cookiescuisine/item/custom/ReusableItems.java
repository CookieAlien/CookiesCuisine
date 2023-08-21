package net.cookiealien.cookiescuisine.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ReusableItems extends Item {
    public ReusableItems(Properties properties) {
        super(properties);
    }
    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        var copy = stack.copy();
        copy.setCount(1);
        return copy;
    }
}
