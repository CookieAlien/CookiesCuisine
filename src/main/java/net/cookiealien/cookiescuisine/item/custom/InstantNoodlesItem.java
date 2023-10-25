package net.cookiealien.cookiescuisine.item.custom;

import net.cookiealien.cookiescuisine.item.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class InstantNoodlesItem extends Item {
    private static final int EAT_DURATION = 30;
    public InstantNoodlesItem(Properties pProperties) {
        super(pProperties);
    }
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        super.finishUsingItem(stack, level, entity);
        if (entity instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, stack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (stack.isEmpty()) {
            return new ItemStack(ModItems.PAPER_CUP.get());
        } else {
            if (entity instanceof Player player && !((Player)entity).getAbilities().instabuild) {
                ItemStack itemstack = new ItemStack(ModItems.PAPER_CUP.get());
                if (!player.getInventory().add(itemstack)) {
                    player.drop(itemstack, false);
                }
            }

            return stack;
        }
    }

    @Override
    public int getUseDuration(@NotNull ItemStack pStack) {
        return EAT_DURATION;
    }
}
