package net.cookiealien.cookiescuisine.datagen;

import net.cookiealien.cookiescuisine.CookiesCuisine;
import net.cookiealien.cookiescuisine.item.ModItems;
import net.cookiealien.cookiescuisine.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagLookup<Block>> tagLookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, completableFuture, tagLookupCompletableFuture, CookiesCuisine.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        this.tag(ModTags.Items.KITCHEN_KNIVES)
                .add(ModItems.STONE_KITCHEN_KNIFE.get(),
                        ModItems.IRON_KITCHEN_KNIFE.get(),
                        ModItems.GOLDEN_KITCHEN_KNIFE.get(),
                        ModItems.DIAMOND_KITCHEN_KNIFE.get(),
                        ModItems.NETHERITE_KITCHEN_KNIFE.get());
        this.tag(ModTags.Items.VEGETABLES)
                .add(ModItems.CABBAGE.get());
    }
}
