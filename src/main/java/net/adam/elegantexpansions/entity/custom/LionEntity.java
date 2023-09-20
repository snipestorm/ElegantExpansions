package net.adam.elegantexpansions.entity.custom;

import net.adam.elegantexpansions.entity.custom.ai.goal.BabyHurtByTargetGoal;
import net.adam.elegantexpansions.entity.custom.ai.goal.BabyPanicGoal;
import net.adam.elegantexpansions.entity.custom.ai.goal.SleepGoal;
import net.adam.elegantexpansions.entity.ModEntityTypes;
import net.adam.elegantexpansions.sound.ModSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Path;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;


import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class LionEntity extends Animal implements GeoEntity, SleepingAnimal {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private static final EntityDataAccessor<Boolean> SLEEPING = SynchedEntityData.defineId(LionEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HAS_MANE = SynchedEntityData.defineId(LionEntity.class, EntityDataSerializers.BOOLEAN);

    private static final Predicate<LivingEntity> PREY_SELECTOR = (p_248371_) -> {
        EntityType<?> entitytype = p_248371_.getType();
        return entitytype == EntityType.SHEEP || entitytype == EntityType.RABBIT || entitytype == ModEntityTypes.CAPYBARA.get() ||
                entitytype == EntityType.FOX || entitytype == EntityType.COW||
                entitytype == EntityType.PIG|| entitytype == EntityType.LLAMA||
                entitytype == EntityType.CHICKEN|| entitytype == EntityType.CAT||
                entitytype == EntityType.HORSE|| entitytype == EntityType.DONKEY||
                entitytype == EntityType.MULE || entitytype == EntityType.GOAT;};

    public LionEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.maxUpStep = 1.0F;
    }

    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 24.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.ATTACK_DAMAGE, 6.0D)
                .add(Attributes.FOLLOW_RANGE, 32.0D).build();
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
        AgeableMobGroupData ageableMobGroupData;
        if (spawnData == null) {
            spawnData = new AgeableMobGroupData(true);
            this.setHasMane(true);
        }
        if ((ageableMobGroupData = (AgeableMobGroupData)spawnData).getGroupSize() > 2) {
            this.setAge(-24000);
        }
        ageableMobGroupData.increaseGroupSizeByOne();
        RandomSource random = level.getRandom();
        this.getAttribute(Attributes.FOLLOW_RANGE).addPermanentModifier
                (new AttributeModifier("Random spawn bonus", random.triangle(0.0, 0.11485000000000001),
                        AttributeModifier.Operation.MULTIPLY_BASE));
        return spawnData;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return ModEntityTypes.LION.get().create(serverLevel);
    }


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new LionPreyGoal(this));
        this.goalSelector.addGoal(2, new BabyPanicGoal(this, 2.0D));
        this.goalSelector.addGoal(3, new SleepGoal<>(this));
        this.goalSelector.addGoal(4, new LionFollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LionFollowLeaderGoal(this, 1.1D, 8.0F, 24.0F));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new BabyHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PathfinderMob.class, 10, true, true, entity -> entity.getType() == PREY_SELECTOR && !entity.isBaby() && !this.isSleeping() && !this.isBaby() && this.level().isNight()));
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return false;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SLEEPING, false);
        this.entityData.define(HAS_MANE, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("Mane", this.hasMane());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setHasMane(pCompound.getBoolean("Mane"));
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.isSleeping() || this.isImmobile()) {
            this.jumping = false;
            this.xxa = 0.0F;
            this.zza = 0.0F;
        }
    }

    @Override
    protected void ageBoundaryReached() {
        super.ageBoundaryReached();
        this.setHasMane(this.getRandom().nextBoolean());
    }

    @Override
    public boolean canSleep() {
        long dayTime = this.level().getDayTime();
        if (this.getTarget() != null || this.level().isWaterAt(this.blockPosition())) {
            return false;
        } else {
            return dayTime > 6000 && dayTime < 13000;
        }
    }

    @Override
    public void customServerAiStep() {
        if (this.getMoveControl().hasWanted()) {
            double speedModifier = this.getMoveControl().getSpeedModifier();
            if (speedModifier < 1.0D && this.onGround()) {
                this.setPose(Pose.CROUCHING);
                this.setSprinting(false);
            } else if (speedModifier >= 1.5D && this.onGround()) {
                this.setPose(Pose.STANDING);
                this.setSprinting(true);
            } else {
                this.setPose(Pose.STANDING);
                this.setSprinting(false);
            }
        } else {
            this.setPose(Pose.STANDING);
            this.setSprinting(false);
        }
    }

    @Override
    public boolean isSteppingCarefully() {
        return this.isCrouching() || super.isSteppingCarefully();
    }

    @Override
    public void setSleeping(boolean sleeping) {
        this.entityData.set(SLEEPING, sleeping);
    }

    @Override
    public boolean isSleeping() {
        return this.entityData.get(SLEEPING);
    }

    public void setHasMane(boolean hasMane) {
        this.entityData.set(HAS_MANE, hasMane);
    }

    public boolean hasMane() {
        return this.entityData.get(HAS_MANE);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return ModSounds.LION_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.LION_AMBIENT.get();
    }

    private <T extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState<T> animationState) {
        if (this.isSleeping()) {
            animationState.getController().setAnimation(RawAnimation.begin().then(this.hasMane() || this.isBaby() ? "lion.sleep2" : "lion.sleep", Animation.LoopType.LOOP));
            animationState.getController().setAnimationSpeed(1.0F);
        } else if (this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6) {
            if (this.isSprinting()) {
                animationState.getController().setAnimation(RawAnimation.begin().then("lion.run", Animation.LoopType.LOOP));
                animationState.getController().setAnimationSpeed(2.5F);
            } else if (this.isCrouching()) {
                animationState.getController().setAnimation(RawAnimation.begin().then("lion.prey", Animation.LoopType.LOOP));
                animationState.getController().setAnimationSpeed(0.8F);
            } else {
                animationState.getController().setAnimation(RawAnimation.begin().then("lion.walk", Animation.LoopType.LOOP));
                animationState.getController().setAnimationSpeed(1.0F);
            }
        } else {
            animationState.getController().setAnimation(RawAnimation.begin().then("lion.idle", Animation.LoopType.LOOP));
            animationState.getController().setAnimationSpeed(1.0F);
        }
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(software.bernie.geckolib.core.animation.AnimationState state) {
        if (this.swinging && state.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            state.getController().forceAnimationReset();
            state.getController().setAnimation(RawAnimation.begin().then("lion.swing", Animation.LoopType.PLAY_ONCE));
            this.swinging = false;
        }

        return PlayState.CONTINUE;
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
        controllerRegistrar.add(new AnimationController<>(this, "trumpet_controller", 0, this::attackPredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }


    static class LionFollowLeaderGoal extends Goal {
        private final LionEntity mob;
        private final Predicate<Mob> followPredicate;
        @Nullable
        private LionEntity followingMob;
        private final double speedModifier;
        private final PathNavigation navigation;
        private int timeToRecalcPath;
        private final float stopDistance;
        private float oldWaterCost;
        private final float areaSize;

        public LionFollowLeaderGoal(LionEntity mob, double speedModifier, float stopDistance, float areaSize) {
            this.mob = mob;
            this.followPredicate = followingMob -> followingMob != null && !followingMob.isBaby();
            this.speedModifier = speedModifier;
            this.navigation = mob.getNavigation();
            this.stopDistance = stopDistance;
            this.areaSize = areaSize;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            if (this.mob.isBaby() || this.mob.hasMane()) {
                return false;
            }
            List<LionEntity> nearbyLions = this.mob.level().getEntitiesOfClass(LionEntity.class, this.mob.getBoundingBox().inflate(this.areaSize), this.followPredicate);
            if (!nearbyLions.isEmpty()) {
                for (LionEntity lion : nearbyLions) {
                    if (!lion.hasMane()) continue;
                    if (lion.isInvisible()) continue;
                    this.followingMob = lion;
                    return true;
                }
                if (this.followingMob == null) {
                    for (LionEntity lion : nearbyLions) {
                        if (lion.isBaby()) continue;
                        if (lion.isInvisible()) continue;
                        this.followingMob = lion;
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public boolean canContinueToUse() {
            return this.followingMob != null && !this.navigation.isDone() && this.mob.distanceToSqr(this.followingMob) > (double)(this.stopDistance * this.stopDistance);
        }

        @Override
        public void start() {
            this.timeToRecalcPath = 0;
            this.oldWaterCost = this.mob.getPathfindingMalus(BlockPathTypes.WATER);
            this.mob.setPathfindingMalus(BlockPathTypes.WATER, 0.0f);
        }

        @Override
        public void stop() {
            this.followingMob = null;
            this.navigation.stop();
            this.mob.setPathfindingMalus(BlockPathTypes.WATER, this.oldWaterCost);
        }

        @Override
        public void tick() {
            double f;
            double e;
            if (this.followingMob == null || this.mob.isLeashed()) {
                return;
            }
            this.mob.getLookControl().setLookAt(this.followingMob, 10.0f, this.mob.getMaxHeadXRot());
            if (--this.timeToRecalcPath > 0) {
                return;
            }
            this.timeToRecalcPath = this.adjustedTickDelay(10);
            double d = this.mob.getX() - this.followingMob.getX();
            double g = d * d + (e = this.mob.getY() - this.followingMob.getY()) * e + (f = this.mob.getZ() - this.followingMob.getZ()) * f;
            if (g <= (double)(this.stopDistance * this.stopDistance)) {
                this.navigation.stop();
                LookControl lookControl = this.followingMob.getLookControl();
                if (g <= (double)this.stopDistance || lookControl.getWantedX() == this.mob.getX() && lookControl.getWantedY() == this.mob.getY() && lookControl.getWantedZ() == this.mob.getZ()) {
                    double h = this.followingMob.getX() - this.mob.getX();
                    double i = this.followingMob.getZ() - this.mob.getZ();
                    this.navigation.moveTo(this.mob.getX() - h, this.mob.getY(), this.mob.getZ() - i, this.speedModifier);
                }
                return;
            }
            this.navigation.moveTo(this.followingMob, this.speedModifier);
        }
    }

    static class LionPreyGoal extends Goal {
        protected final PathfinderMob mob;
        private double speedModifier = 0.5D;
        private Path path;
        private double pathedTargetX;
        private double pathedTargetY;
        private double pathedTargetZ;
        private int ticksUntilNextPathRecalculation;
        private int ticksUntilNextAttack;
        private long lastCanUseCheck;

        public LionPreyGoal(PathfinderMob pathfinderMob) {
            this.mob = pathfinderMob;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            if (this.mob.isBaby()) {
                return false;
            }
            long gameTime = this.mob.level().getGameTime();
            if (gameTime - this.lastCanUseCheck < 20L) {
                return false;
            }
            this.lastCanUseCheck = gameTime;
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) {
                return false;
            }
            if (!livingEntity.isAlive()) {
                return false;
            }
            this.path = this.mob.getNavigation().createPath(livingEntity, 0);
            if (this.path != null) {
                return true;
            }
            return this.getAttackReachSqr(livingEntity) >= this.mob.distanceToSqr(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
        }

        @Override
        public boolean canContinueToUse() {
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) {
                return false;
            }
            if (!livingEntity.isAlive()) {
                return false;
            }
            return !this.mob.getNavigation().isDone();
        }

        @Override
        public void start() {
            LivingEntity target = this.mob.getTarget();
            if (target == null) {
                return;
            }
            this.speedModifier = this.mob.distanceTo(target) > 12 ? 0.5D : 1.7D;
            this.mob.getNavigation().moveTo(this.path, this.speedModifier);
            this.mob.setAggressive(true);
            this.mob.playSound(ModSounds.LION_ROAR.get());
            this.ticksUntilNextPathRecalculation = 0;
            this.ticksUntilNextAttack = 0;
        }

        @Override
        public void stop() {
            LivingEntity livingEntity = this.mob.getTarget();
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingEntity)) {
                this.mob.setTarget(null);
            }
            this.mob.setAggressive(false);
            this.mob.getNavigation().stop();
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            LivingEntity target = this.mob.getTarget();
            if (target == null) {
                return;
            }
            this.speedModifier = this.mob.distanceTo(target) > 12 ? 0.5D : 1.7D;
            this.mob.getLookControl().setLookAt(target, 30.0f, 30.0f);
            double d = this.mob.distanceToSqr(target.getX(), target.getY(), target.getZ());
            this.ticksUntilNextPathRecalculation = Math.max(this.ticksUntilNextPathRecalculation - 1, 0);
            if (this.mob.getSensing().hasLineOfSight(target) && this.ticksUntilNextPathRecalculation <= 0 && (this.pathedTargetX == 0.0 && this.pathedTargetY == 0.0 && this.pathedTargetZ == 0.0 || target.distanceToSqr(this.pathedTargetX, this.pathedTargetY, this.pathedTargetZ) >= 1.0 || this.mob.getRandom().nextFloat() < 0.05f)) {
                this.pathedTargetX = target.getX();
                this.pathedTargetY = target.getY();
                this.pathedTargetZ = target.getZ();
                this.ticksUntilNextPathRecalculation = 4 + this.mob.getRandom().nextInt(7);
                if (d > 1024.0) {
                    this.ticksUntilNextPathRecalculation += 10;
                } else if (d > 256.0) {
                    this.ticksUntilNextPathRecalculation += 5;
                }
                if (!this.mob.getNavigation().moveTo(target, this.speedModifier)) {
                    this.ticksUntilNextPathRecalculation += 15;
                }
                this.ticksUntilNextPathRecalculation = this.adjustedTickDelay(this.ticksUntilNextPathRecalculation);
            }
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
            this.checkAndPerformAttack(target, d);
        }

        protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
            double d = this.getAttackReachSqr(enemy);
            if (distToEnemySqr <= d && this.ticksUntilNextAttack <= 0) {
                this.resetAttackCooldown();
                this.mob.swing(InteractionHand.MAIN_HAND);
                this.mob.doHurtTarget(enemy);
            }
        }

        protected void resetAttackCooldown() {
            this.ticksUntilNextAttack = this.adjustedTickDelay(20);
        }

        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return this.mob.getBbWidth() * 2.0f * (this.mob.getBbWidth() * 2.0f) + attackTarget.getBbWidth();
        }
    }

    static class LionFollowParentGoal extends FollowParentGoal {
        private final LionEntity lion;

        public LionFollowParentGoal(LionEntity animal, double speedModifier) {
            super(animal, speedModifier);
            this.lion = animal;
        }

        @Override
        public boolean canUse() {
            return !this.lion.isSleeping() && super.canUse();
        }

        @Override
        public boolean canContinueToUse() {
            return !this.lion.isSleeping() && super.canContinueToUse();
        }
    }
}
