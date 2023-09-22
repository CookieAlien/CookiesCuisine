package net.cookiealien.cookiescuisine.item.custom;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties GREEN_APPLE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).build();
    public static final FoodProperties SWEET_COOKIE = (new FoodProperties.Builder()).fast().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties APPLE_JUICE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.4F).build();
    public static final FoodProperties CARROT_JUICE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.4F).build();
    public static final FoodProperties GREEN_APPLE_JUICE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.4F).build();
    public static final FoodProperties SWEET_BERRY_JUICE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.4F).build();
    public static final FoodProperties WATERMELON_JUICE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.4F).build();
    public static final FoodProperties BOILED_EGG = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).build();
    public static final FoodProperties CHICKEN_CUTLET = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.6F).meat().build();
    public static final FoodProperties RICE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties CABBAGE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).build();
    public static final FoodProperties SHRED_CHICKEN_RICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build();
}
