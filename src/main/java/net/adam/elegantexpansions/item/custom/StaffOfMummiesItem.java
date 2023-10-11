package net.adam.elegantexpansions.item.custom;

import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.enchantment.AncientPowerEnchantment;
import net.adam.elegantexpansions.enchantment.ModEnchantments;
import net.adam.elegantexpansions.entity.ModEntityTypes;
import net.adam.elegantexpansions.entity.custom.AnubisEntity;
import net.adam.elegantexpansions.item.client.StaffOfMummiesRenderer;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CryingObsidianBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.RenderUtils;

import java.util.function.Consumer;

import static net.adam.elegantexpansions.block.ModBlocks.WHITE_SANDSTONE;

public class StaffOfMummiesItem extends SwordItem implements GeoItem, Vanishable {

    public boolean cooldown;


    public AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);

    public StaffOfMummiesItem(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }


    private PlayState predicate(AnimationState animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    @Override
    public double getTick(Object itemStack) {
        return RenderUtils.getCurrentTick();
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private StaffOfMummiesRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) {
                    renderer = new StaffOfMummiesRenderer();
                }
                return this.renderer;
            }
        });
    }


    public InteractionResult useOn(UseOnContext use) {
        Player player = use.getPlayer();
        Level level = use.getLevel();

        if (!level.isClientSide()) {
            ServerLevel world = ((ServerLevel) level);
            BlockPos position = use.getClickedPos();
            BlockState blockState = level.getBlockState(position);
            Block block = blockState.getBlock();



            if (!player.getCooldowns().isOnCooldown(this)) {
                ModEntityTypes.PLAYERS_MUMMY.get().spawn(world, (ItemStack) null, null, position.east(1),
                                MobSpawnType.TRIGGERED, true, true)
                        .setLimitedLife(1200);
                ModEntityTypes.PLAYERS_MUMMY.get().spawn(world, (ItemStack) null, null, position.west(1),
                                MobSpawnType.TRIGGERED, true, true)
                        .setLimitedLife(1200);
                ModEntityTypes.PLAYERS_MUMMY.get().spawn(world, (ItemStack) null, null, position,
                                MobSpawnType.TRIGGERED, true, true)
                        .setLimitedLife(1200);
                player.getCooldowns().addCooldown(this, 1800);
                cooldown = true;

                if (player != null) {
                    use.getItemInHand().hurtAndBreak(1, player, (p_41303_) -> {
                        p_41303_.broadcastBreakEvent(use.getHand());

                                });
                            }
                        }
                    }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

}










