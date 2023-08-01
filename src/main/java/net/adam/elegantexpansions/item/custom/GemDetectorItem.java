package net.adam.elegantexpansions.item.custom;

import net.adam.elegantexpansions.item.ModItems;
import net.adam.elegantexpansions.sound.ModSounds;
import net.adam.elegantexpansions.util.InventoryUtil;
import net.adam.elegantexpansions.util.ModTags;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GemDetectorItem extends Item {
    public GemDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState blockState = pContext.getLevel().getBlockState(positionClicked.below(i));

                if(isValuableBlock(blockState)) {
                    outputValuableCoordinates(positionClicked.below(i), player, blockState.getBlock());
                    foundBlock = true;

                    if(InventoryUtil.hasPlayerStackInInventory(player, ModItems.DATA_TABLET.get())) {
                        addDataToDataTablet(player, positionClicked.below(i), blockState.getBlock());
                    }



                    pContext.getLevel().playSeededSound(null, player.getX(), player.getY(), player.getZ(),
                            ModSounds.GEM_DETECTOR_FOUND_GEM.get(), SoundSource.BLOCKS, 1f,1f,0);

                    spawnFoundParticles(pContext, positionClicked, blockState);

                    break;
                }
            }

            if(!foundBlock) {
                outputNoValuableFound(player);
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void addDataToDataTablet(Player player, BlockPos below, Block block) {
        ItemStack dataTablet = player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET.get()));

        CompoundTag data = new CompoundTag();
        data.putString("elegantexpansions.found_gem","Gem Found: " + I18n.get(block.getDescriptionId())
                + " at (" + below.getX() + ", " + below.getY() + ", " + below.getZ() + ")");

        dataTablet.setTag(data);

        }

    private void spawnFoundParticles(UseOnContext pContext, BlockPos positionClicked, BlockState blockState) {
        for(int i = 0; i < 20; i++) {
            ServerLevel level = (ServerLevel) pContext.getLevel();

            level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockState),
                    positionClicked.getX() + 0.5d, positionClicked.getY() + 1, positionClicked.getZ() + 0.5d, 1,
                    Math.cos(i * 18) * 0.15d, 0.15d, Math.sin(i * 18) * 0.15d, 0.1);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.translatable("tooltip.elegant_expansions.gem_detector.tooltip"));

        super.appendHoverText(stack, level, components, tooltipFlag);
    }

    private void outputNoValuableFound(Player player) {
        player.sendSystemMessage(Component.translatable("item.elegantexpansions.gem_detector.no_valuables"));
    }

    private void outputValuableCoordinates(BlockPos below, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Gem Found: " + I18n.get(block.getDescriptionId())
                + " at (" + below.getX() + ", " + below.getY() + ", " + below.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState blockState) {
        return blockState.is(ModTags.Blocks.GEM_DETECTOR_GEMS);
    }
}