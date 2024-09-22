package com.winston.block;

import com.winston.BlingBling;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    private final static Block peridotite = registerBlock("peridotite", new Block(AbstractBlock.Settings.create()
            .strength(3f)
            .resistance(3f)
            .requiresTool()
            .sounds(BlockSoundGroup.STONE)));

    private final static Block deepslate_peridotite = registerBlock("deepslate_peridotite", new Block(AbstractBlock.Settings.create()
            .strength(4.5f)
            .resistance(3f)
            .requiresTool()
            .sounds(BlockSoundGroup.DEEPSLATE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BlingBling.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(BlingBling.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        BlingBling.LOGGER.info("Registering Mod Blocks. Bling Bling!");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(peridotite);
            entries.add(deepslate_peridotite);
        });
    }
}
