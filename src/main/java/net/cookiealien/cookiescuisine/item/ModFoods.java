package net.cookiealien.cookiescuisine.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties GREEN_APPLE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).build();
    public static final FoodProperties SWEET_COOKIE = (new FoodProperties.Builder()).fast().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties APPLE_JUICE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.4F).build();
}
