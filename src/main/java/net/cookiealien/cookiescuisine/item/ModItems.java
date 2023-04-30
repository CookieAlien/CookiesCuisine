package net.cookiealien.cookiescuisine.item;
import net.cookiealien.cookiescuisine.CookiesCuisine;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CookiesCuisine.MODID);
    public static final RegistryObject<Item> GREEN_APPLE = ITEMS.register("green_apple", ()-> new Item(new Item.Properties().food(ModFoods.GREEN_APPLE)));
    public static final RegistryObject<Item> SWEET_COOKIE = ITEMS.register("sweet_cookie", ()-> new Item(new Item.Properties().food(ModFoods.SWEET_COOKIE)));
    public static final RegistryObject<Item> FLOUR = ITEMS.register("flour", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PAPER_CUP = ITEMS.register("paper_cup", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MORTAR = ITEMS.register("mortar", ()-> new ReusableItems(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JUICER = ITEMS.register("juicer", ()-> new ReusableItems(new Item.Properties().stacksTo(1)));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
