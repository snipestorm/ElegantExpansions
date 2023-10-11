package net.adam.elegantexpansions.item.custom;

import net.adam.elegantexpansions.block.custom.MysteriousCube;
import net.adam.elegantexpansions.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class InfusedAmethystItem extends Item {
    public InfusedAmethystItem(Properties p_41383_) {
        super(p_41383_);
    }

    public InteractionResult useOn(UseOnContext use) {
        Player player = use.getPlayer();
        Level level = use.getLevel();
        if (!level.isClientSide()) {
            ServerLevel world = ((ServerLevel) level);
            BlockPos position = use.getClickedPos();
            BlockState blockState = level.getBlockState(position);
            Block block = blockState.getBlock();


            {
                if (block instanceof MysteriousCube golemCube) {
                    if (golemCube.getHatchLevel(blockState) == 0) {
                        BlockState blockState1 = golemCube.setHatchLevel(blockState);
                        level.setBlock(position, blockState1,11);
                        level.playSeededSound(null,position.getX(),position.getY(),position.getZ(), ModSounds.GOLEM_BLOCK_CRACK.get(), SoundSource.BLOCKS,1,1,0);

                        if (player != null) {
                            use.getItemInHand().shrink(1);
                        }

                    }
                }
            }
        }


        return InteractionResult.sidedSuccess(level.isClientSide());
    }
}
