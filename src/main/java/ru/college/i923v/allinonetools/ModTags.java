package ru.college.i923v.allinonetools;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static final TagKey<Block> MINEABLE_MULTITOOL = TagKey.create(
            Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(AllInOneTools.MOD_ID, "mineable/multitool")
    );
}