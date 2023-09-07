package net.cookiealien.cookiescuisine.datagen;

import net.cookiealien.cookiescuisine.CookiesCuisine;
import net.cookiealien.cookiescuisine.block.ModBlocks;
import net.cookiealien.cookiescuisine.block.custom.RiceCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CookiesCuisine.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SALT_BLOCK);
        cropBlock(ModBlocks.RICE_CROP.get(),"rice", RiceCropBlock.AGE);
    }

    public void cropBlock(Block block, String cropName, IntegerProperty ageProperty){
        getVariantBuilder(block).forAllStates(blockState ->{
            int ageSuffix = blockState.getValue(ageProperty);
            String stageName = cropName + "_stage" + ageSuffix;
            return ConfiguredModel.builder()
                    .modelFile(models().crop(stageName,new ResourceLocation(CookiesCuisine.MODID,"block/"+ stageName)).renderType("cutout")).build();
        } );
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }
}
