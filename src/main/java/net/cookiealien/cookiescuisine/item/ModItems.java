package net.cookiealien.cookiescuisine.item;
import net.cookiealien.cookiescuisine.CookiesCuisine;
import net.cookiealien.cookiescuisine.block.ModBlocks;
import net.cookiealien.cookiescuisine.item.custom.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Tiers;
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
    public static final RegistryObject<Item> SHRED_CHICKEN = ITEMS.register("shred_chicken", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SHRED_CHICKEN_RICE = ITEMS.register("shred_chicken_rice", ()-> new ModBowlFoodItem(new Item.Properties().food(ModFoods.SHRED_CHICKEN_RICE).stacksTo(16)));
    public static final RegistryObject<Item> APPLE_JUICE = ITEMS.register("apple_juice", ()-> new JuiceCupItem(new Item.Properties().food(ModFoods.APPLE_JUICE)));
    public static final RegistryObject<Item> CARROT_JUICE = ITEMS.register("carrot_juice", ()-> new JuiceCupItem(new Item.Properties().food(ModFoods.CARROT_JUICE)));
    public static final RegistryObject<Item> GREEN_APPLE_JUICE = ITEMS.register("green_apple_juice", ()-> new JuiceCupItem(new Item.Properties().food(ModFoods.GREEN_APPLE_JUICE)));
    public static final RegistryObject<Item> SWEET_BERRY_JUICE = ITEMS.register("sweet_berry_juice", ()-> new JuiceCupItem(new Item.Properties().food(ModFoods.SWEET_BERRY_JUICE)));
    public static final RegistryObject<Item> WATERMELON_JUICE = ITEMS.register("watermelon_juice", ()-> new JuiceCupItem(new Item.Properties().food(ModFoods.WATERMELON_JUICE)));
    public static final RegistryObject<Item> FLOUR = ITEMS.register("flour", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DOUGH = ITEMS.register("dough", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_NOODLES = ITEMS.register("raw_noodles", ()-> new Item(new Item.Properties().food(ModFoods.RAW_NOODLES)));
    public static final RegistryObject<Item> NOODLES_CUP = ITEMS.register("noodles_cup", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INSTANT_NOODLES = ITEMS.register("instant_noodles", ()-> new InstantNoodlesItem(new Item.Properties().food(ModFoods.INSTANT_NOODLES)));
    public static final RegistryObject<Item> RAW_WATER = ITEMS.register("raw_water", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SALT = ITEMS.register("salt", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PAPER_CUP = ITEMS.register("paper_cup", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATER_CUP = ITEMS.register("water_cup", ()-> new JuiceCupItem(new Item.Properties().craftRemainder(ModItems.PAPER_CUP.get())));
    public static final RegistryObject<Item> BENTO_BOX = ITEMS.register("bento_box", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BENTO = ITEMS.register("bento", ()-> new BentoItem(new Item.Properties().food(ModFoods.BENTO)));
    public static final RegistryObject<Item> RICE_SEEDS = ITEMS.register("rice_seeds", ()-> new ItemNameBlockItem(ModBlocks.RICE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> RICE_PANICLE = ITEMS.register("rice_panicle", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RICE = ITEMS.register("rice", ()-> new Item(new Item.Properties().food(ModFoods.RICE)));
    public static final RegistryObject<Item> ONIGIRI = ITEMS.register("onigiri", ()-> new Item(new Item.Properties().food(ModFoods.ONIGIRI)));
    public static final RegistryObject<Item> CABBAGE_SEEDS = ITEMS.register("cabbage_seeds", ()-> new ItemNameBlockItem(ModBlocks.CABBAGE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> CABBAGE = ITEMS.register("cabbage", ()-> new Item(new Item.Properties().food(ModFoods.CABBAGE)));
    public static final RegistryObject<Item> MORTAR = ITEMS.register("mortar", ()-> new ReusableItems(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JUICER = ITEMS.register("juicer", ()-> new ReusableItems(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> STONE_KITCHEN_KNIFE = ITEMS.register("stone_kitchen_knife", ()-> new KnifeItem(Tiers.STONE, 2, -2.2F, new Item.Properties()));
    public static final RegistryObject<Item> IRON_KITCHEN_KNIFE = ITEMS.register("iron_kitchen_knife", ()-> new KnifeItem(Tiers.IRON, 2, -2.2F, new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_KITCHEN_KNIFE = ITEMS.register("golden_kitchen_knife", ()-> new KnifeItem(Tiers.GOLD, 2, -2.2F, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_KITCHEN_KNIFE = ITEMS.register("diamond_kitchen_knife", ()-> new KnifeItem(Tiers.DIAMOND, 2, -2.2F, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_KITCHEN_KNIFE = ITEMS.register("netherite_kitchen_knife", ()-> new KnifeItem(Tiers.NETHERITE, 2, -2.2F, new Item.Properties()));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
