package net.adam.elegantexpansions.item.custom;

import net.adam.elegantexpansions.util.ModTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.level.block.Block;

public class PaxelItem extends DiggerItem implements Vanishable {
    public PaxelItem(Tier p_204110_, float p_204108_, float p_204109_, Properties p_204112_) {
        super(p_204108_, p_204109_, p_204110_, ModTags.Blocks.PAXEL_MINEABLE, p_204112_);
    }
}
