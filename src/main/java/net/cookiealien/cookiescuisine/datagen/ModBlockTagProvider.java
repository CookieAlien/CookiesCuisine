package net.cookiealien.cookiescuisine.datagen;

import net.cookiealien.cookiescuisine.CookiesCuisine;
import net.cookiealien.cookiescuisine.block.ModBlocks;
import net.cookiealien.cookiescuisine.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CookiesCuisine.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.SALT_BLOCK.get());
        this.tag(ModTags.Blocks.HEAT_SOURCES)
                .add(Blocks.CAMPFIRE)
                .add(Blocks.SOUL_CAMPFIRE)
                .add(Blocks.LAVA)
                .add(Blocks.MAGMA_BLOCK)
                .add(Blocks.FURNACE)
                .add(Blocks.BLAST_FURNACE)
                .add(Blocks.SMOKER);
    }
}
