package ru.college.i923v.allinonetools;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;

public class MultitoolItem extends DiggerItem {

    public MultitoolItem(Tier tier, Item.Properties properties) {
        super(tier, ModTags.MINEABLE_MULTITOOL, properties);
    }

    // По желанию (функции топора и лопаты по ПКМ из ЛБ-1): снять кору, сделать тропинку
    @Override
    public InteractionResult useOn(UseOnContext context) {
        InteractionResult result = Items.DIAMOND_AXE.useOn(context);
        if (result != InteractionResult.PASS) {
            return result;
        }
        return Items.DIAMOND_SHOVEL.useOn(context);
    }
}