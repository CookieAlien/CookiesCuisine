package net.cookiealien.cookiescuisine;

import net.cookiealien.cookiescuisine.block.ModBlocks;
import net.cookiealien.cookiescuisine.item.ModCreativeModeTabs;
import net.cookiealien.cookiescuisine.item.ModItems;
import net.cookiealien.cookiescuisine.loot.ModLootModifiers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(CookiesCuisine.MODID)
public class CookiesCuisine
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "cookiescuisine";

    public CookiesCuisine()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        ModLootModifiers.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS){
            event.accept(ModItems.GREEN_APPLE);
            event.accept(ModItems.APPLE_JUICE);
            event.accept(ModItems.CARROT_JUICE);
            event.accept(ModItems.GREEN_APPLE_JUICE);
            event.accept(ModItems.SWEET_BERRY_JUICE);
            event.accept(ModItems.WATERMELON_JUICE);
            event.accept(ModItems.SWEET_COOKIE);
            event.accept(ModItems.FLOUR);
            event.accept(ModItems.DOUGH);
            event.accept(ModItems.SALT);
            event.accept(ModItems.BOILED_EGG);
            event.accept(ModItems.RAW_CHICKEN_CUTLET);
            event.accept(ModItems.CHICKEN_CUTLET);
            }
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(ModItems.MORTAR);
            event.accept(ModItems.JUICER);
            event.accept(ModItems.PAPER_CUP);
        }
    }



    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
