package net.cookiealien.cookiescuisine.item.custom;

import net.cookiealien.cookiescuisine.item.ModItems;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BentoItem extends Item {
    public BentoItem(Properties pProperties) {
        super(pProperties.defaultDurability(3));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        var copy = pStack.copy();
        copy.setDamageValue(pStack.getDamageValue() + 1);
        if (copy.getDamageValue() >= pStack.getMaxDamage()) {
            copy = new ItemStack(ModItems.BENTO_BOX.get());
        }

        super.finishUsingItem(pStack, pLevel, pLivingEntity);
        if (pLivingEntity instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, pStack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        return copy;
    }
}
