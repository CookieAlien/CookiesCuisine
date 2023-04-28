package net.cookiealien.cookiescuisine.item;

import net.cookiealien.cookiescuisine.CookiesCuisine;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CookiesCuisine.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab COOKIESCUISINE_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        COOKIESCUISINE_TAB = event.registerCreativeModeTab(new ResourceLocation(CookiesCuisine.MODID, "cookiescuisine_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.SWEET_COOKIE.get()))
                        .title(Component.translatable("creativemodetab.cookiescuisine_tab")));
    }
}
