package net.cookiealien.cookiescuisine.datagen;

import net.cookiealien.cookiescuisine.CookiesCuisine;
import net.cookiealien.cookiescuisine.block.ModBlocks;
import net.cookiealien.cookiescuisine.item.ModItems;
import net.cookiealien.cookiescuisine.util.ModTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        foodCookingRecipes(Items.EGG,ModItems.BOILED_EGG.get(),0.35F, pWriter);
        foodCookingRecipes(ModItems.RAW_CHICKEN_CUTLET.get(), ModItems.CHICKEN_CUTLET.get(),0.35F,pWriter);
        JuiceRecipes(Items.APPLE,ModItems.APPLE_JUICE.get(),1,pWriter);
        JuiceRecipes(Items.CARROT,ModItems.CARROT_JUICE.get(),1,pWriter);
        JuiceRecipes(Items.SWEET_BERRIES,ModItems.SWEET_BERRY_JUICE.get(),2,pWriter);
        JuiceRecipes(Items.MELON,ModItems.WATERMELON_JUICE.get(),2,pWriter);
        JuiceRecipes(ModItems.GREEN_APPLE.get(), ModItems.GREEN_APPLE_JUICE.get(),1,pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.STONE_KITCHEN_KNIFE.get())
                .pattern("m  ")
                .pattern(" m ")
                .pattern("  s")
                .define('m',ItemTags.STONE_TOOL_MATERIALS)
                .define('s',Items.STICK)
                .unlockedBy(getHasName(ModItems.STONE_KITCHEN_KNIFE.get()),has(ModItems.STONE_KITCHEN_KNIFE.get()))
                .save(pWriter);
        KnifeRecipes(Items.IRON_INGOT,ModItems.IRON_KITCHEN_KNIFE.get(),pWriter);
        KnifeRecipes(Items.GOLD_INGOT,ModItems.GOLDEN_KITCHEN_KNIFE.get(),pWriter);
        KnifeRecipes(Items.DIAMOND,ModItems.DIAMOND_KITCHEN_KNIFE.get(),pWriter);
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),Ingredient.of(ModItems.DIAMOND_KITCHEN_KNIFE.get()),Ingredient.of(Items.NETHERITE_INGOT),
                RecipeCategory.TOOLS,ModItems.NETHERITE_KITCHEN_KNIFE.get()).unlocks("has_netherite_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_INGOT)).save(pWriter,CookiesCuisine.MODID + ":netherite_kitchen_knife");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SALT_BLOCK.get())
                .pattern("XX")
                .pattern("XX")
                .define('X',ModItems.SALT.get())
                .unlockedBy(getHasName(ModBlocks.SALT_BLOCK.get()),has(ModBlocks.SALT_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.MORTAR.get())
                .pattern("SWS")
                .pattern(" S ")
                .define('S', ModTags.Items.STONE)
                .define('W',Items.STICK)
                .unlockedBy(getHasName(ModItems.MORTAR.get()),has(ModItems.MORTAR.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.JUICER.get())
                .pattern(" s ")
                .pattern("sps")
                .define( 's',ModTags.Items.STONE)
                .define('p', Blocks.STONE_PRESSURE_PLATE)
                .unlockedBy(getHasName(ModItems.JUICER.get()),has(ModItems.JUICER.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.PAPER_CUP.get(),3)
                .pattern("p p")
                .pattern(" p ")
                .define('p',Items.PAPER)
                .unlockedBy(getHasName(ModItems.PAPER_CUP.get()),has(ModItems.PAPER_CUP.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD,ModItems.SWEET_COOKIE.get(),8)
                .pattern("#X#")
                .define('#',ModItems.DOUGH.get())
                .define('X',Items.SUGAR)
                .unlockedBy(getHasName(ModItems.SWEET_COOKIE.get()),has(ModItems.SWEET_COOKIE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.FLOUR.get())
                .requires(ModItems.MORTAR.get())
                .requires(Items.WHEAT)
                .unlockedBy(getHasName(ModItems.FLOUR.get()),has(ModItems.FLOUR.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.DOUGH.get(),4)
                .requires(Items.WATER_BUCKET)
                .requires(ModItems.FLOUR.get(),4)
                .unlockedBy(getHasName(ModItems.DOUGH.get()),has(ModItems.DOUGH.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.RAW_WATER.get(),8)
                .requires(Items.WATER_BUCKET)
                .unlockedBy(getHasName(ModItems.RAW_WATER.get()),has(ModItems.RAW_WATER.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.DOUGH.get(),4)
                .requires(ModItems.RAW_WATER.get())
                .requires(ModItems.FLOUR.get(),4)
                .unlockedBy(getHasName(ModItems.DOUGH.get()),has(ModItems.DOUGH.get()))
                .save(pWriter,new ResourceLocation(CookiesCuisine.MODID, "flour_from_raw_water"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.RICE_SEEDS.get())
                .requires(ModItems.RICE_PANICLE.get())
                .unlockedBy(getHasName(ModItems.RICE_SEEDS.get()),has(ModItems.RICE_SEEDS.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,ModItems.RICE.get())
                .requires(ModItems.MORTAR.get())
                .requires(ModItems.RICE_PANICLE.get())
                .unlockedBy(getHasName(ModItems.RICE.get()),has(ModItems.RICE.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,ModItems.SHRED_CHICKEN.get(),2)
                .requires(ModTags.Items.KITCHEN_KNIVES)
                .requires(Items.CHICKEN)
                .unlockedBy(getHasName(Items.CHICKEN),has(Items.CHICKEN))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SHRED_CHICKEN_RICE.get())
                .requires(Items.BOWL)
                .requires(ModItems.RICE.get())
                .requires(ModItems.SHRED_CHICKEN.get())
                .unlockedBy(getHasName(ModItems.RICE.get()),has(ModItems.RICE.get()))
                .save(pWriter);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_WATER.get()),RecipeCategory.FOOD,ModItems.SALT.get(), 0.35F,200)
                .unlockedBy(getHasName(ModItems.SALT.get()),has(ModItems.SALT.get()))
                .save(pWriter);
    }

    private static void foodCookingRecipes(ItemLike ingredient, ItemLike result, float exp, Consumer<FinishedRecipe> consumer){
        String namePrefix = new ResourceLocation(CookiesCuisine.MODID, getItemName(result)).toString();
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, result, exp,200).unlockedBy(getHasName(result),has(result)).save(consumer);
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.FOOD, result,exp,100).unlockedBy(getHasName(result),has(result)).save(consumer,namePrefix + "_from_smoking");
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result,exp,600).unlockedBy(getHasName(result),has(result)).save(consumer,namePrefix + "_from_campfire_cooking");
    }
    private static void JuiceRecipes(ItemLike ingredient, ItemLike result, int quantity, Consumer<FinishedRecipe> consumer){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result)
                .requires(ModItems.JUICER.get())
                .requires(ingredient,quantity)
                .requires(ModItems.PAPER_CUP.get())
                .unlockedBy(getHasName(result),has(result))
                .save(consumer);
    }

    private static void KnifeRecipes(ItemLike ingredient, ItemLike result, Consumer<FinishedRecipe> consumer){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,result)
                .pattern("m  ")
                .pattern(" m ")
                .pattern("  s")
                .define('m',ingredient)
                .define('s',Items.STICK)
                .unlockedBy(getHasName(result),has(result))
                .save(consumer);
    }
}
