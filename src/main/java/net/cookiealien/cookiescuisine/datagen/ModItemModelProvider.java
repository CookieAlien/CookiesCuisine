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
        simpleItem(ModItems.SALT);
        simpleItem(ModItems.PAPER_CUP);
        simpleItem(ModItems.MORTAR);
        simpleItem(ModItems.JUICER);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CookiesCuisine.MODID, "item/"+item.getId().getPath()));
    }
}
