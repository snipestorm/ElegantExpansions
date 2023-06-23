package net.adam.elegantexpansions.entity.custom;

import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.entity.ModEntityTypes;
import net.adam.elegantexpansions.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;

import javax.annotation.Nullable;
import java.util.UUID;


public class GolemEntity extends Monster implements GeoEntity {
    private AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);

    private final ServerBossEvent bossEvent = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.GREEN, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private boolean ragehasPlayedOnce;
    private boolean summonAgain;


    public GolemEntity(EntityType<? extends GolemEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setHealth(this.getMaxHealth());
        this.xpReward = 150;


    }


    public void readAdditionalSaveData(CompoundTag p_31474_) {
        super.readAdditionalSaveData(p_31474_);
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
            this.bossEvent.setProgress(this.getMaxHealth());
        }

    }

    public void setCustomName(@Nullable Component p_31476_) {
        super.setCustomName(p_31476_);
        this.bossEvent.setName(this.getDisplayName());
    }

    public void startSeenByPlayer(ServerPlayer p_31483_) {
        super.startSeenByPlayer(p_31483_);
        this.bossEvent.addPlayer(p_31483_);
    }

    public void stopSeenByPlayer(ServerPlayer p_31488_) {
        super.stopSeenByPlayer(p_31488_);
        this.bossEvent.removePlayer(p_31488_);
    }

    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    protected void dropCustomDeathLoot(DamageSource p_31464_, int p_31465_, boolean p_31466_) {
        super.dropCustomDeathLoot(p_31464_, p_31465_, p_31466_);
        ItemEntity itementity = this.spawnAtLocation(ModBlocks.MAGIC_SAPLING.get());
        if (itementity != null) {
            itementity.setExtendedLifetime();
        }

    }

    public void checkDespawn() {
        if (this.level().getDifficulty() == Difficulty.PEACEFUL && this.shouldDespawnInPeaceful()) {
            this.discard();
        } else {
            this.noActionTime = 0;
        }
    }


    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()

                .add(Attributes.MAX_HEALTH, 300)
                .add(Attributes.ATTACK_DAMAGE, 12.00f)
                .add(Attributes.ATTACK_SPEED, 0.8f)
                .add(Attributes.MOVEMENT_SPEED, 0.285f)
                .add(Attributes.ATTACK_KNOCKBACK, 1.5f).build();

    }


    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));

    }


    private PlayState predicate(AnimationState animationState) {
        if (animationState.isMoving()) {
            animationState.getController().setAnimation(RawAnimation.begin().then("animation.golem.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        animationState.getController().setAnimation(RawAnimation.begin().then("animation.golem.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationState state) {
        if (this.swinging && state.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            state.getController().forceAnimationReset();
            state.getController().setAnimation(RawAnimation.begin().then("animation.golem.attack", Animation.LoopType.PLAY_ONCE));
            this.swinging = false;
        }

        return PlayState.CONTINUE;
    }


    private PlayState deathPredicate(AnimationState animationState) {
        if (this.dead) {
            animationState.getController().setAnimation(RawAnimation.begin().then("animation.golem.death", Animation.LoopType.PLAY_ONCE));

        }
        return PlayState.CONTINUE;
    }

    private PlayState ragePredicate(AnimationState state) {
        if (this.isRage()) {
            state.getController().setAnimation(RawAnimation.begin().then("animation.golem.rage", Animation.LoopType.PLAY_ONCE));


        }

        return PlayState.CONTINUE;


    }

    public boolean isRage() {
        return this.getHealth() <= this.getMaxHealth() / 2.0F;
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this, "controller",
                0, this::predicate));
        controllers.add(new AnimationController(this, "attackController",
                0, this::attackPredicate));
        controllers.add(new AnimationController<>(this, "deathController",
                0, this::deathPredicate));
        controllers.add(new AnimationController<>(this, "rageController",
                0, this::ragePredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return factory;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(ModSounds.GOLEM_WALK.get(), 0.25F, 1.0F);
    }


    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.GOLEM_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.GOLEM_DEATH.get();
    }


    protected float getSoundVolume() {
        return 3F;
    }

    public boolean hurt(DamageSource p_31461_, float p_31462_) {
        if (this.isRage()) {
            Entity entity = p_31461_.getDirectEntity();
            if (entity instanceof AbstractArrow && entity instanceof Projectile) {
                return false;
            }
        }
        return super.hurt(p_31461_, p_31462_);
    }


    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        {
            this.bossEvent.setProgress(1.0F / 220.0F);

            if (this.tickCount % 20 == 0) {
                this.heal(0.2F);
            }

            this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        }
        {
            if (this.isRage() && !this.ragehasPlayedOnce) {
                this.level().playSound(null, blockPosition(), ModSounds.GOLEM_ROAR.get(), SoundSource.HOSTILE, 1, 1);
                this.ragehasPlayedOnce = true;
            }

            }

        {
            if (this.isEnraged() && !this.summonAgain) {
                ServerLevel serverlevel = (ServerLevel) GolemEntity.this.level();
                this.heal(this.getMaxHealth() / 10);

                for (int i = 0; i < 5; ++i) {
                    BlockPos blockpos = GolemEntity.this.blockPosition().offset(-2 + GolemEntity.this.random.nextInt(5), 1, -2 + GolemEntity.this.random.nextInt(5));
                    MummyEntity mummy = ModEntityTypes.MUMMY.get().create(GolemEntity.this.level());
                    if (mummy != null) {
                        float f = this.level().getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
                        mummy.moveTo(blockpos, 0.0F, 0.0F);
                        mummy.finalizeSpawn(serverlevel, GolemEntity.this.level().getCurrentDifficultyAt(blockpos), MobSpawnType.MOB_SUMMONED, (SpawnGroupData) null, (CompoundTag) null);
                        serverlevel.addFreshEntityWithPassengers(mummy);
                        this.summonAgain = true;

                    }
                }
            }
        }


        }

    public boolean isEnraged() {
        return this.getHealth() <= this.getMaxHealth() / 3.0F;
    }

}





