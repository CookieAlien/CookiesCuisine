package net.cookiealien.cookiescuisine.datagen;

import net.cookiealien.cookiescuisine.CookiesCuisine;
import net.cookiealien.cookiescuisine.item.ModItems;
import net.cookiealien.cookiescuisine.loot.AddItemModifier;
import net.cookiealien.cookiescuisine.loot.AdditionalTableModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, CookiesCuisine.MODID);
    }

    @Override
    protected void start() {
        add("green_apple_from_oak_leaves",new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.OAK_LEAVES).build(),
                BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE,0.05F,0.075F,0.09F,0.12F,0.15F).build()
        }, ModItems.GREEN_APPLE.get()));

        add("rice_seeds_from_grass",new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.2F).build()
        },ModItems.RICE_SEEDS.get()));
        add("village_plains_house_test",new AdditionalTableModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("chests/village/village_plains_house")).build()
        },new ResourceLocation(CookiesCuisine.MODID,"chests/cc_village_plains_house")));
        add("village_savanna_house_test",new AdditionalTableModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("chests/village/village_savanna_house")).build()
        },new ResourceLocation(CookiesCuisine.MODID,"chests/cc_village_savanna_house")));
    }
}
