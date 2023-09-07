package net.cookiealien.cookiescuisine.item;
import net.cookiealien.cookiescuisine.CookiesCuisine;
import net.cookiealien.cookiescuisine.block.ModBlocks;
import net.cookiealien.cookiescuisine.item.custom.JuiceCupItem;
import net.cookiealien.cookiescuisine.item.custom.ModFoods;
import net.cookiealien.cookiescuisine.item.custom.ReusableItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CookiesCuisine.MODID);
    public static final RegistryObject<Item> GREEN_APPLE = ITEMS.register("green_apple", ()-> new Item(new Item.Properties().food(ModFoods.GREEN_APPLE)));
    public static final RegistryObject<Item> SWEET_COOKIE = ITEMS.register("sweet_cookie", ()-> new Item(new Item.Properties().food(ModFoods.SWEET_COOKIE)));
    public static final RegistryObject<Item> BOILED_EGG = ITEMS.register("boiled_egg", ()-> new Item(new Item.Properties().food(ModFoods.BOILED_EGG)));
    public static final RegistryObject<Item> RAW_CHICKEN_CUTLET = ITEMS.register("raw_chicken_cutlet", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHICKEN_CUTLET = ITEMS.register("chicken_cutlet", ()-> new Item(new Item.Properties().food(ModFoods.CHICKEN_CUTLET)));
    public static final RegistryObject<Item> APPLE_JUICE = ITEMS.register("apple_juice", ()-> new JuiceCupItem(new Item.Properties().food(ModFoods.APPLE_JUICE)));
    public static final RegistryObject<Item> CARROT_JUICE = ITEMS.register("carrot_juice", ()-> new JuiceCupItem(new Item.Properties().food(ModFoods.CARROT_JUICE)));
    public static final RegistryObject<Item> GREEN_APPLE_JUICE = ITEMS.register("green_apple_juice", ()-> new JuiceCupItem(new Item.Properties().food(ModFoods.GREEN_APPLE_JUICE)));
    public static final RegistryObject<Item> SWEET_BERRY_JUICE = ITEMS.register("sweet_berry_juice", ()-> new JuiceCupItem(new Item.Properties().food(ModFoods.SWEET_BERRY_JUICE)));
    public static final RegistryObject<Item> WATERMELON_JUICE = ITEMS.register("watermelon_juice", ()-> new JuiceCupItem(new Item.Properties().food(ModFoods.WATERMELON_JUICE)));
    public static final RegistryObject<Item> FLOUR = ITEMS.register("flour", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DOUGH = ITEMS.register("dough", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_WATER = ITEMS.register("raw_water", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SALT = ITEMS.register("salt", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PAPER_CUP = ITEMS.register("paper_cup", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RICE_SEEDS = ITEMS.register("rice_seeds", ()-> new ItemNameBlockItem(ModBlocks.RICE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> RICE_PANICLE = ITEMS.register("rice_panicle", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RICE = ITEMS.register("rice", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MORTAR = ITEMS.register("mortar", ()-> new ReusableItems(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JUICER = ITEMS.register("juicer", ()-> new ReusableItems(new Item.Properties().stacksTo(1)));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
