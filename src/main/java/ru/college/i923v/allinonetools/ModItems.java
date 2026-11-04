package ru.college.i923v.allinonetools;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final Item MULTITOOL = register(
            "multitool",
            new Item(new Item.Properties().stacksTo(1))
    );

    private static Item register(String name, Item item) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                ResourceLocation.fromNamespaceAndPath(AllInOneTools.MOD_ID, name),
                item
        );
    }

    public static void initialize() {
    }
}