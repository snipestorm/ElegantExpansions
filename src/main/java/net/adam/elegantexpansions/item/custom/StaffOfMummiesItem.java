package net.adam.elegantexpansions.item.custom;

import net.adam.elegantexpansions.entity.ModEntityTypes;
import net.adam.elegantexpansions.item.client.StaffOfMummiesRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.RenderUtils;

import java.util.function.Consumer;

public class StaffOfMummiesItem extends Item implements GeoItem {

    public AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);
    public boolean isnotoncooldown;

    public StaffOfMummiesItem(Properties properties) {
        super(properties);
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
        BlockPos blockpos = use.getClickedPos();
        if (!level.isClientSide()) {
            BlockPos pos = blockpos.relative(use.getClickedFace());
            ServerLevel world = ((ServerLevel) level);
            BlockPos position = use.getClickedPos();

            if(!this.isnotoncooldown) {
                ModEntityTypes.PLAYERS_MUMMY.get().spawn(world, (ItemStack) null, null, position,
                        MobSpawnType.TRIGGERED, true, true);

            }
        }
            return InteractionResult.sidedSuccess(level.isClientSide());
        }
    }




