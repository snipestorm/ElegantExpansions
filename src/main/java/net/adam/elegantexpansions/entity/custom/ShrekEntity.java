package net.adam.elegantexpansions.entity.custom;

import net.adam.elegantexpansions.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
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

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;


public class ShrekEntity extends PathfinderMob implements  GeoEntity, NeutralMob {
    private final AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);
    private int remainingPersistentAngerTime;
    public boolean donkeysoundhasPlayedOnce;
    public boolean donkeySummoned;
    protected int castingTickCount;
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    @javax.annotation.Nullable
    private UUID persistentAngerTarget;
    public boolean isSummoning;
    public static final EntityDataAccessor<Boolean> SUMMON = SynchedEntityData.defineId(ShrekEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> YELL = SynchedEntityData.defineId(ShrekEntity.class, EntityDataSerializers.BOOLEAN);
    private static final Predicate<Player> NOT_PLAYER_PREDICATE = new Predicate<Player>() {
        public boolean test(@javax.annotation.Nullable Player p_29453_) {
            return p_29453_ != null;
        }
    };

    public ShrekEntity(EntityType<? extends ShrekEntity> entityType, Level level) {
        super(entityType, level);
        this.setHealth(this.getMaxHealth());
        this.xpReward = 150;
    }

    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 750f)
                .add(Attributes.ATTACK_DAMAGE, 3f)
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
        p_30418_.putBoolean("Yell", this.isYelling());
        p_30418_.putBoolean("Summon", this.isSummoning());
    }

    public void readAdditionalSaveData(CompoundTag p_30402_) {
        super.readAdditionalSaveData(p_30402_);
        this.readPersistentAngerSaveData(this.level(), p_30402_);
        this.setYellStatus(p_30402_.getBoolean("Yell"));
        this.setSummonStatus(p_30402_.getBoolean("Summon"));
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(YELL, false);
        entityData.define(SUMMON, false);
    }

    public boolean isSummoning() {
        return this.entityData.get(SUMMON);
    }

    public void setSummonStatus(boolean summon) {
        this.entityData.set(SUMMON, Boolean.valueOf(summon));
    }
    public boolean isYelling() {
        return this.entityData.get(YELL);
    }

    public void setYellStatus(boolean yell) {
        this.entityData.set(YELL, Boolean.valueOf(yell));
    }

    private PlayState predicate(AnimationState animationState) {
        if (animationState.isMoving()) {
            animationState.getController().setAnimation(RawAnimation.begin().then("animation.shrek.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        animationState.getController().setAnimation(RawAnimation.begin().then("animation.shrek.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    private PlayState seeingPredicate(AnimationState state) {
        if (isYelling()) {
            state.getController().setAnimation(RawAnimation.begin().then("animation.shrek.what", Animation.LoopType.PLAY_ONCE));

        return PlayState.CONTINUE;
    } else {
        state.getController().forceAnimationReset();
        return PlayState.STOP;
    }
}

    private PlayState donkeyPredicate(AnimationState state) {

        if (isSummoning()) {
            state.getController().setAnimation(RawAnimation.begin().then("animation.shrek.donkey", Animation.LoopType.PLAY_ONCE));

            return PlayState.CONTINUE;
        } else {

            state.getController().forceAnimationReset();
            return PlayState.STOP;
        }
    }


    private PlayState attackPredicate(AnimationState state) {
        if (this.swinging && state.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            state.getController().forceAnimationReset();
            state.getController().setAnimation(RawAnimation.begin().then("animation.shrek.attack", Animation.LoopType.PLAY_ONCE));
            this.swinging = false;
        }

        return PlayState.CONTINUE;
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



    public boolean yellAtPlayer(Level level, Entity entity) {
        if (entity.isAlive() && !isYelling() && !entity.isSilent() && level.random.nextInt(2) == 0) {
            List<Player> list = level.getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(10.0D), NOT_PLAYER_PREDICATE);
            if (!list.isEmpty()) {
                Player player = list.get(level.random.nextInt(list.size()));
                SoundEvent soundevent = getYellSound();
                level.playSound((Player) null, entity.getX(), entity.getY(), entity.getZ(), soundevent, entity.getSoundSource(), 0.7F, 1F);
                setYellStatus(true);
                return true;
            }
            return false;

        } else {
            return false;
        }
    }


    private static SoundEvent getYellSound() {
        return ModSounds.SHREK_WHAT.get();
    }

    public void aiStep() {

        if (this.level().random.nextInt(100) == 0) {
            yellAtPlayer(this.level(), this);
        }

        if (this.level().random.nextInt(10000) == 0) {
            setYellFalse();
        }
        super.aiStep();
    }

    public void setYellFalse() {
        this.setYellStatus(false);
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
                return ShrekEntity.this.tickCount >= this.nextCastTickCount && random.nextInt(1000) == 0;
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
                        setSummonStatus(true);

                    }
                    donkeySummoned = true;

                }
            }
        }
    }
    

}
    


