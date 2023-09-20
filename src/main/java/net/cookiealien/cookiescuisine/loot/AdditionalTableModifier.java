package net.cookiealien.cookiescuisine.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AdditionalTableModifier extends LootModifier {
    public static final Supplier<Codec<AdditionalTableModifier>> CODEC = Suppliers.memoize(()-> RecordCodecBuilder.create(inst -> codecStart(inst)
            .and(ResourceLocation.CODEC.fieldOf("tableRef").forGetter((m)->m.tableID))
            .apply(inst, AdditionalTableModifier::new)));

    private final ResourceLocation tableID;
    private final LootTableReference reference;
    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    public AdditionalTableModifier(LootItemCondition[] conditionsIn, ResourceLocation tableID) {
        super(conditionsIn);
        this.tableID = tableID;
        this.reference = (LootTableReference) LootTableReference.lootTableReference(tableID).build();
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        ObjectArrayList<ItemStack> items = new ObjectArrayList<>();
        reference.createItemStack(items::add,context);
        generatedLoot.addAll(items);
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
