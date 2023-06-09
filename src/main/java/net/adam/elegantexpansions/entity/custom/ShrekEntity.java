package net.adam.elegantexpansions.entity.custom;

import net.adam.elegantexpansions.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.EnumSet;
import java.util.Random;
import java.util.UUID;



public class ShrekEntity extends PathfinderMob implements  GeoEntity, NeutralMob {
    private final AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);
    private int remainingPersistentAngerTime;

    public boolean donkeysoundhasPlayedOnce;
    private boolean canDoAnimation;
    public boolean donkeySummoned;
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    @javax.annotation.Nullable
    private UUID persistentAngerTarget;
    boolean isSummoning;

    protected int castingTickCount;

    public ShrekEntity(EntityType<? extends ShrekEntity> entityType, Level level) {
        super(entityType, level);
        this.setHealth(this.getMaxHealth());
        this.xpReward = 150;
    }

    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 750f)
                .add(Attributes.ATTACK_DAMAGE, (double) 3f)
                .add(Attributes.ATTACK_SPEED, 0.2)
                .add(Attributes.FOLLOW_RANGE, 20D)
                .add(Attributes.MOVEMENT_SPEED, 0.175).build();

    }




    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(9, new ShrekSummonGoal());


        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(3, new ResetUniversalAngerTargetGoal<>(this, true));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)));
    }

    public MobType getMobType() {
        return MobType.UNDEFINED;
    }





    public void addAdditionalSaveData(CompoundTag p_30418_) {
        super.addAdditionalSaveData(p_30418_);
        this.addPersistentAngerSaveData(p_30418_);
    }

    public void readAdditionalSaveData(CompoundTag p_30402_) {
        super.readAdditionalSaveData(p_30402_);
        this.readPersistentAngerSaveData(this.level(), p_30402_);
    }

    private PlayState predicate(software.bernie.geckolib.core.animation.AnimationState animationState) {
        if (animationState.isMoving()) {
            animationState.getController().setAnimation(RawAnimation.begin().then("animation.shrek.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        animationState.getController().setAnimation(RawAnimation.begin().then("animation.shrek.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    private PlayState seeingPredicate(AnimationState state) {
        if (this.canDoAnimation && state.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            state.getController().forceAnimationReset();
            state.getController().setAnimation(RawAnimation.begin().then("animation.shrek.what", Animation.LoopType.PLAY_ONCE));
            setCantDoAnimation();
        }

        return PlayState.CONTINUE;
    }

    private PlayState donkeyPredicate(AnimationState state) {

            if (isSummoning && state.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
                state.getController().forceAnimationReset();
                state.getController().setAnimation(RawAnimation.begin().then("animation.shrek.donkey", Animation.LoopType.PLAY_ONCE));

            }

        return PlayState.CONTINUE;
    }


    private PlayState attackPredicate(AnimationState state) {
        if (this.swinging && state.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            state.getController().forceAnimationReset();
            state.getController().setAnimation(RawAnimation.begin().then("animation.shrek.attack", Animation.LoopType.PLAY_ONCE));
            this.swinging = false;
        }

        return PlayState.CONTINUE;
    }

    public void setCantDoAnimation() {
        canDoAnimation = false;
    }
    public boolean DoAnimation() {
        return donkeySummoned;
    }


      public void setCanDoAnimation() {
        canDoAnimation = true;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this, "controller",
                0, this::predicate));
        controllers.add(new AnimationController(this, "attackController",
                0, this::attackPredicate));
        controllers.add(new AnimationController(this, "seeingController",
                0, this::seeingPredicate));
        controllers.add(new AnimationController(this, "donkeyController",
                0, this::donkeyPredicate));

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


    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            this.updatePersistentAnger((ServerLevel) this.level(), true);
        }
    }

@Override
    protected void customServerAiStep() {
    super.customServerAiStep();

    {
        if (this.isSummoning && !this.donkeysoundhasPlayedOnce) {
            this.level().playSound(null, blockPosition(), ModSounds.SHREK_DONKEY.get(), SoundSource.NEUTRAL, 3, 1);
            this.donkeysoundhasPlayedOnce = true;
        }

    }
}






    public boolean doHurtTarget(Entity p_30372_) {
        boolean flag = p_30372_.hurt(damageSources().mobAttack(this), (float) ((int) this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
        if (flag) {
            this.doEnchantDamageEffects(this, p_30372_);
        }

        return flag;
    }

    public boolean hurt(DamageSource p_30386_, float p_30387_) {
        if (this.isInvulnerableTo(p_30386_)) {
            return false;
        } else {
            Entity entity = p_30386_.getEntity();
            if (entity != null && !(entity instanceof Player) && !(entity instanceof AbstractArrow)) {
                p_30387_ = (p_30387_ + 1.0F) / 2.0F;
            }

            return super.hurt(p_30386_, p_30387_);
        }
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return this.remainingPersistentAngerTime;
    }

    @Override
    public void setRemainingPersistentAngerTime(int p_21673_) {
        this.remainingPersistentAngerTime = p_21673_;
    }

    @Nullable
    @Override
    public UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    @Override
    @Nullable
    public void setPersistentAngerTarget(UUID p_21672_) {
        this.persistentAngerTarget = p_21672_;
    }

    @Override
    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));

    }


    public class ShrekSummonGoal extends Goal {


        private final Random random = new Random();

        public ShrekSummonGoal() {

        }

        @Override
        public boolean canUse() {
            LivingEntity livingentity = ShrekEntity.this;
            if (livingentity != null && livingentity.isAlive()) {
                return ShrekEntity.this.tickCount >= this.nextCastTickCount && random.nextInt(1000) == 3;

            }
            if (donkeySummoned) {
                return false;
            }
            if (isSummoning) {
                return false;
            } else {
                return false;
            }

        }

        public boolean canContinueToUse() {
            LivingEntity livingentity = ShrekEntity.this;
            return livingentity != null && livingentity.isAlive() && this.castWarmupDelay > 0;
        }

        public void start() {
            this.castWarmupDelay = this.adjustedTickDelay(this.getCastWarmupTime());
            ShrekEntity.this.castingTickCount = this.getCastingTime();
            this.nextCastTickCount = ShrekEntity.this.tickCount + this.getCastingInterval();

        }

        public void tick() {
            --this.castWarmupDelay;
            if (this.castWarmupDelay == 0) {
                this.performSpellCasting();
                isSummoning = true;
            }

        }

        protected int getCastingInterval() {
            return 300;
        }

        protected int getCastingTime() {
            return 60;
        }

        protected int getCastWarmupTime() {
            return 40;
        }

        protected int nextCastTickCount;
        protected int castWarmupDelay;

        public void performSpellCasting() {
            if (!donkeySummoned && !isSummoning) {
                ServerLevel serverlevel = (ServerLevel) ShrekEntity.this.level();


                for (int i = 0; i < 1; ++i) {
                    BlockPos blockpos = ShrekEntity.this.blockPosition().offset(-2 + ShrekEntity.this.random.nextInt(5), 1, -2 + ShrekEntity.this.random.nextInt(5));
                    Donkey donkey = EntityType.DONKEY.create(ShrekEntity.this.level());
                    if (donkey != null) {
                        donkey.moveTo(blockpos, 0.0F, 0.0F);
                        donkey.finalizeSpawn(serverlevel, ShrekEntity.this.level().getCurrentDifficultyAt(blockpos), MobSpawnType.MOB_SUMMONED, (SpawnGroupData) null, (CompoundTag) null);
                        serverlevel.addFreshEntityWithPassengers(donkey);

                    }
                    donkeySummoned = true;

                }
            }
        }
    }
    

}
    


