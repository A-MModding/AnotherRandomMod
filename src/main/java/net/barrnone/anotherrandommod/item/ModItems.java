package net.barrnone.anotherrandommod.item;

import net.barrnone.anotherrandommod.AnotherRandomMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AnotherRandomMod.MODID);

    // Steps to add New Item,
    // 1. Register it here,
    // 2. add it to creative tab in Main
    // 3. Give it a name in Lang,
    // 4. make it a relevant model in models,
    // 5. plop down it's texture in textures.

    public static final DeferredItem<Item> RAW_VITALUM = ITEMS.register("raw_vitalum",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> VITALUM_INGOT = ITEMS.register("vitalum_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> VITALUM_NUGGET = ITEMS.register("vitalum_nugget",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
