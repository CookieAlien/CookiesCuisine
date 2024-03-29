package net.cookiealien.cookiescuisine.loot;

import com.mojang.serialization.Codec;
import net.cookiealien.cookiescuisine.CookiesCuisine;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, CookiesCuisine.MODID);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM =
            LOOT_MODIFIER_SERIALIZERS.register("add_item",AddItemModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADDITIONAL_TABLE =
            LOOT_MODIFIER_SERIALIZERS.register("additional_table",AdditionalTableModifier.CODEC);

    public static void register(IEventBus Bus) {
        LOOT_MODIFIER_SERIALIZERS.register(Bus);
    }
}
