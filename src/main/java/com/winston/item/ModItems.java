package com.winston.item;

import com.winston.BlingBling;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item peridot = registerItem("peridot", new Item(new Item.Settings()));
    public static final Item olivine = registerItem("olivine", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BlingBling.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BlingBling.LOGGER.info("Registering Mod Items. Bling Bling!");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(peridot);
            entries.add(olivine);
        });
    }
}
