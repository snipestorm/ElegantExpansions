package net.adam.elegantexpansions.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WardenUpgradeTemplateItem extends Item {


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.translatable("tooltip.elegant_expansions.warden_upgrade_template.tooltip"));

        super.appendHoverText(stack, level, components, tooltipFlag);
    }

    public WardenUpgradeTemplateItem(Properties p_41383_) {
        super(p_41383_);

    }
}
