package net.cookiealien.cookiescuisine.util;

import net.cookiealien.cookiescuisine.CookiesCuisine;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(CookiesCuisine.MODID,name));
        }
        private static TagKey<Block> forgeTag(String name){
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items{
        public static final TagKey<Item> STONE = forgeTag("stone");
        public static final TagKey<Item> VEGETABLES = forgeTag("vegetables");
        public static final TagKey<Item> KITCHEN_KNIVES = tag("kitchen_knives");
        public static final TagKey<Item> BENTO_MAIN_DISHES = tag("bento_main_dishes");
        public static final TagKey<Item> BENTO_SIDES = tag("bento_sides");
        public static final TagKey<Item> WATER_HOLDERS = tag("water_holders");
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(CookiesCuisine.MODID,name));
        }
        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
