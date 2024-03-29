package net.cookiealien.cookiescuisine.datagen;

import net.cookiealien.cookiescuisine.CookiesCuisine;
import net.cookiealien.cookiescuisine.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, CookiesCuisine.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.GREEN_APPLE);
        simpleItem(ModItems.SWEET_COOKIE);
        simpleItem(ModItems.BOILED_EGG);
        simpleItem(ModItems.RAW_CHICKEN_CUTLET);
        simpleItem(ModItems.CHICKEN_CUTLET);
        simpleItem(ModItems.APPLE_JUICE);
        simpleItem(ModItems.CARROT_JUICE);
        simpleItem(ModItems.GREEN_APPLE_JUICE);
        simpleItem(ModItems.SWEET_BERRY_JUICE);
        simpleItem(ModItems.WATERMELON_JUICE);
        simpleItem(ModItems.FLOUR);
        simpleItem(ModItems.DOUGH);
        simpleItem(ModItems.RAW_WATER);
        simpleItem(ModItems.SALT);
        simpleItem(ModItems.PAPER_CUP);
        simpleItem(ModItems.MORTAR);
        simpleItem(ModItems.JUICER);
        simpleItem(ModItems.RICE);
        simpleItem(ModItems.RICE_SEEDS);
        simpleItem(ModItems.RICE_PANICLE);
        simpleItem(ModItems.CABBAGE_SEEDS);
        simpleItem(ModItems.CABBAGE);
        simpleItem(ModItems.SHRED_CHICKEN);
        simpleItem(ModItems.SHRED_CHICKEN_RICE);
        simpleItem(ModItems.ONIGIRI);
        simpleItem(ModItems.BENTO_BOX);
        simpleItem(ModItems.BENTO);
        simpleItem(ModItems.WATER_CUP);
        simpleItem(ModItems.NOODLES_CUP);
        simpleItem(ModItems.INSTANT_NOODLES);
        simpleItem(ModItems.RAW_NOODLES);


        heldItem(ModItems.STONE_KITCHEN_KNIFE);
        heldItem(ModItems.GOLDEN_KITCHEN_KNIFE);
        heldItem(ModItems.IRON_KITCHEN_KNIFE);
        heldItem(ModItems.DIAMOND_KITCHEN_KNIFE);
        heldItem(ModItems.NETHERITE_KITCHEN_KNIFE);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CookiesCuisine.MODID, "item/"+item.getId().getPath()));
    }
    private ItemModelBuilder heldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(CookiesCuisine.MODID, "item/"+item.getId().getPath()));
    }
}
