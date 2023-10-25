package net.cookiealien.cookiescuisine.block;

import net.cookiealien.cookiescuisine.CookiesCuisine;
import net.cookiealien.cookiescuisine.block.custom.CabbageCropBlock;
import net.cookiealien.cookiescuisine.block.custom.RiceCropBlock;
import net.cookiealien.cookiescuisine.block.custom.WaterBoilerBlock;
import net.cookiealien.cookiescuisine.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CookiesCuisine.MODID);

    public static final RegistryObject<Block> SALT_BLOCK = registerBlock("salt_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.CLAY).mapColor(MapColor.SAND).sound(SoundType.SAND)));
    public static final RegistryObject<Block> GRILL_STATION = registerBlock("grill_station",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> WATER_BOILER = registerBlock("water_boiler",
            ()-> new WaterBoilerBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final RegistryObject<Block> RICE_CROP = BLOCKS.register("rice_crop",
                ()-> new RiceCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> CABBAGE_CROP = BLOCKS.register("cabbage_crop",
            ()-> new CabbageCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
