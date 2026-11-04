package ru.college.i923v.allinonetools;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class ModItems {

    public static final Item MULTITOOL = register(
            "multitool",
            new MultitoolItem(
                    Tiers.DIAMOND,
                    new Item.Properties()
                            .attributes(DiggerItem.createAttributes(Tiers.DIAMOND, 3.0f, -2.4f))
            )
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