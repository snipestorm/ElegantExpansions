package net.adam.elegantexpansions.item.custom;

import net.adam.elegantexpansions.block.custom.AnubisSummonBlock;
import net.adam.elegantexpansions.entity.ModEntityTypes;
import net.adam.elegantexpansions.entity.custom.AnubisEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class AncientScrollItem extends Item {
    public AncientScrollItem(Properties pProperties) {
        super(pProperties);
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
                if (block instanceof AnubisSummonBlock anubisSummonBlock) {
                    if (anubisSummonBlock.activeBlockState(blockState)) {

                        AnubisEntity anubis = ModEntityTypes.ANUBIS.get().spawn(world, position.above(), MobSpawnType.TRIGGERED);
                        anubis.makeInvulnerable();
                        world.addFreshEntity(anubis);

                        if (player != null) {
                            use.getItemInHand().hurtAndBreak(10, player, (p_41303_) -> {
                                p_41303_.broadcastBreakEvent(use.getHand());

                            });
                        }

                    }
                }
            }
        }


            return InteractionResult.sidedSuccess(level.isClientSide());
        }

}
