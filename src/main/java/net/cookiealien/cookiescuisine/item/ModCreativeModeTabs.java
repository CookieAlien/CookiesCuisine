package net.cookiealien.cookiescuisine.item;

import net.cookiealien.cookiescuisine.CookiesCuisine;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB, CookiesCuisine.MODID);
    public static RegistryObject<CreativeModeTab> COOKIESCUISINE_TAB = CREATIVE_MODE_TABS.register("cookiescuisine_tab",() ->
        CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SWEET_COOKIE.get()))
                .title(Component.translatable("creativemodetab.cookiescuisine_tab")).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
