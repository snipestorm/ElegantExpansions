package net.adam.elegantexpansions.entity.custom;

import com.google.common.collect.Maps;
import net.adam.elegantexpansions.entity.ModEntityTypes;
import net.adam.elegantexpansions.entity.custom.ai.goal.AttackPlayerNearBabiesGoal;
import net.adam.elegantexpansions.entity.custom.ai.goal.BabyHurtByTargetGoal;
import net.adam.elegantexpansions.entity.custom.ai.goal.BabyPanicGoal;
import net.adam.elegantexpansions.entity.custom.ai.goal.DistancedFollowParentGoal;
import net.adam.elegantexpansions.entity.variant.ElephantVariant;
import net.adam.elegantexpansions.sound.ModSounds;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;


public class ElephantEntity extends Animal implements GeoEntity, PlayerRideable {
    private static final Predicate<LivingEntity> PARENT_ELEPHANT_SELECTOR = (parent) -> {
        return parent instanceof ElephantEntity && ((ElephantEntity) parent).isBred();
    };
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.COCOA_BEANS);
    private static final TargetingConditions MOMMY_TARGETING = TargetingConditions.forNonCombat().range(16.0D).ignoreLineOfSight().selector(PARENT_ELEPHANT_SELECTOR);
    private static final int FLAG_BRED = 8;
    private static final EntityDataAccessor<Byte> DATA_ID_FLAGS = SynchedEntityData.defineId(ElephantEntity.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(ElephantEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DIRTY_TICKS = SynchedEntityData.defineId(ElephantEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Boolean> TRUMPET = SynchedEntityData.defineId(ElephantEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DRINKING = SynchedEntityData.defineId(ElephantEntity.class, EntityDataSerializers.BOOLEAN);
    private static final Predicate<Mob> NOT_ELEPHANT_PREDICATE = new Predicate<Mob>() {
        public boolean test(@javax.annotation.Nullable Mob p_29453_) {
            return p_29453_ != null && ElephantEntity.MOB_SOUND_MAP.containsKey(p_29453_.getType());
        }
    };
    @Nullable
    protected BlockPos waterPos;

    static final Map<EntityType<?>, SoundEvent> MOB_SOUND_MAP = Util.make(Maps.newHashMap(), (p_29398_) -> {
        p_29398_.put(EntityType.BLAZE, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.CAVE_SPIDER,ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.CREEPER, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.DROWNED, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.ELDER_GUARDIAN, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.ENDER_DRAGON, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.ENDERMITE, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.EVOKER, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.GHAST, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.GUARDIAN, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.HOGLIN, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.HUSK, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.ILLUSIONER, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.MAGMA_CUBE, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.PHANTOM, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.PIGLIN, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.PIGLIN_BRUTE, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.PILLAGER, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.RAVAGER, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.SHULKER, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.SILVERFISH, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.SKELETON, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.SLIME, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.SPIDER, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.STRAY, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.VEX, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.VINDICATOR, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.WARDEN, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.WITCH, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.WITHER, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.WITHER_SKELETON,ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.ZOGLIN,ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.ZOMBIE, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(EntityType.ZOMBIE_VILLAGER, ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(ModEntityTypes.MUMMY.get(), ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(ModEntityTypes.GOLEM.get(), ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(ModEntityTypes.ANUBIS.get(), ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(ModEntityTypes.TIGER.get(), ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(ModEntityTypes.WHITE_TIGER.get(), ModSounds.ELEPHANT_TRUMPET.get());
        p_29398_.put(ModEntityTypes.ALBINO_TIGER.get(), ModSounds.ELEPHANT_TRUMPET.get());
    });

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);


    public ElephantEntity(EntityType<? extends ElephantEntity> entityType, Level level) {
        super(entityType, level);
    }

    protected boolean getFlag(int p_30648_) {
        return (this.entityData.get(DATA_ID_FLAGS) & p_30648_) != 0;
    }

    protected void setFlag(int p_30598_, boolean p_30599_) {
        byte b0 = this.entityData.get(DATA_ID_FLAGS);
        if (p_30599_) {
            this.entityData.set(DATA_ID_FLAGS, (byte) (b0 | p_30598_));
        } else {
            this.entityData.set(DATA_ID_FLAGS, (byte) (b0 & ~p_30598_));
        }
    }


    public boolean imitateNearbyMobs(Level p_29383_, Entity p_29384_) {
        if (p_29384_.isAlive() && !isTrumpeting() && !p_29384_.isSilent() && p_29383_.random.nextInt(2) == 0) {
            List<Mob> list = p_29383_.getEntitiesOfClass(Mob.class, p_29384_.getBoundingBox().inflate(20.0D), NOT_ELEPHANT_PREDICATE);
            if (!list.isEmpty()) {
                Mob mob = list.get(p_29383_.random.nextInt(list.size()));
                if (!mob.isSilent()) {
                    SoundEvent soundevent = getImitatedSound(mob.getType());
                    p_29383_.playSound(null, p_29384_.getX(), p_29384_.getY(), p_29384_.getZ(), soundevent, p_29384_.getSoundSource(), 2F, 1F);
                    setTrumpetStatus(true);
                }

                    return true;

            }

            return false;

        } else {

            return false;

        }
    }

    private static SoundEvent getImitatedSound(EntityType<?> p_29409_) {
        return MOB_SOUND_MAP.getOrDefault(p_29409_, SoundEvents.PARROT_AMBIENT);
    }

    public static float getPitch(RandomSource p_218237_) {
        return (p_218237_.nextFloat() - p_218237_.nextFloat()) * 0.2F + 1.0F;
    }

    public boolean canBeLeashed(Player p_21418_) {
        return false;
    }

    public void addAdditionalSaveData(CompoundTag elephantadd) {
        super.addAdditionalSaveData(elephantadd);
        elephantadd.putBoolean("Bred", this.isBred());
        elephantadd.putInt("Variant", this.getTypeVariant());
        elephantadd.putInt("DirtyTicks", this.getDirtyTicks());
    }

    public void readAdditionalSaveData(CompoundTag elephantread) {
        super.readAdditionalSaveData(elephantread);
        this.setBred(elephantread.getBoolean("Bred"));
        this.entityData.set(DATA_ID_TYPE_VARIANT, elephantread.getInt("Variant"));
        this.setDirtyTicks(elephantread.getInt("DirtyTicks"));
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_FLAGS, (byte) 0);
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
        this.entityData.define(TRUMPET, false);
        this.entityData.define(DIRTY_TICKS, 0);
        this.entityData.define(DRINKING, false);
    }

    public void setDirtyTicks(int ticks) {
        this.entityData.set(DIRTY_TICKS, ticks);
    }

    public int getDirtyTicks() {
        return this.entityData.get(DIRTY_TICKS);
    }

    public boolean isMuddy() {
        return this.getDirtyTicks() > 0;
    }

    public void setDrinking(boolean drinking) {
        this.entityData.set(DRINKING, drinking);
    }

    public boolean isDrinking() {
        return this.entityData.get(DRINKING);
    }

    public boolean isTrumpeting() {
        return this.entityData.get(TRUMPET);
    }

    public void setTrumpetStatus(boolean trumpeting) {
        this.entityData.set(TRUMPET, Boolean.valueOf(trumpeting));
    }

    public ElephantVariant getVariant() {
        return ElephantVariant.byId(this.getTypeVariant() & 255);
    }

    public void setFalse() {
        this.setTrumpetStatus(false);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(ElephantVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {

        if (pSpawnData == null) {
            pSpawnData = new AgeableMob.AgeableMobGroupData(1.0F);
        }
        Holder<Biome> holder = pLevel.getBiome(this.blockPosition());
        ElephantVariant variant = ElephantVariant.byBiome(holder);
        this.setVariant(variant);

        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    public boolean isBred() {
        return this.getFlag(8);
    }

    public void setBred(boolean babyelephant) {
        this.setFlag(8, babyelephant);
    }

    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 50D)
                .add(Attributes.FOLLOW_RANGE, 20D)
                .add(Attributes.ATTACK_DAMAGE, 6D)
                .add(Attributes.ATTACK_KNOCKBACK, 1.2D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.75D)
                .add(Attributes.MOVEMENT_SPEED, 0.175f).build();
    }

    @SubscribeEvent
    public static void entitySpawnRestriction(SpawnPlacementRegisterEvent event) {
        event.register(ModEntityTypes.ELEPHANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Bee.class, 8.0f, 1.5, 1.5));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.25D, FOOD_ITEMS, false));
        this.goalSelector.addGoal(2, new ElephantMeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(3, new BabyPanicGoal(this, 2.0D));
        this.goalSelector.addGoal(4, new DistancedFollowParentGoal(this, 1.25D, 24.0D, 6.0D, 12.0D));
        this.goalSelector.addGoal(5, new ElephantDrinkWaterGoal(this));
        this.goalSelector.addGoal(6, new ElephantMoveToWaterGoal(this, 1.0D, 8, 4));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new BabyHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new AttackPlayerNearBabiesGoal(this, 0.5F));

    }
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.RAVAGER_STEP, 0.15F, 1.0F);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return ModSounds.ELEPHANT_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ELEPHANT_AMBIENT.get();
    }


    protected SoundEvent getDeathSound() {
        return ModSounds.ELEPHANT_TRUMPET.get();
    }

    public  SoundEvent getDrinkingSound() { return SoundEvents.GENERIC_DRINK;}

    public  SoundEvent getMudSound() { return SoundEvents.MUD_PLACE;}


    protected float getSoundVolume() {
        return 0.2F;
    }
    @Nullable


    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob ageablemob) {
        ElephantEntity elephant = ModEntityTypes.ELEPHANT.get().create(level);
        if (elephant != null) {
            elephant.setVariant(this.random.nextBoolean() ? this.getVariant() : ((ElephantEntity) ageablemob).getVariant());
        }
        return elephant;
    }




    public boolean isFood(ItemStack food) {
        return FOOD_ITEMS.test(food);
    }


    @Override
   public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "main_controller", 0, this::mainControl));
       // controllerRegistrar.add(new AnimationController<>(this, "trumpet_controller", 0, this::trumpetPredicate));
        controllerRegistrar.add(new AnimationController<>(this, "death_controller", 0, this::deathPredicate));
        controllerRegistrar.add(new AnimationController<>(this, "attack_controller", 0, this::attackPredicate));
    }

    private <T extends GeoAnimatable> PlayState mainControl(AnimationState<T> AnimationState) {
        if (AnimationState.isMoving()) {
            AnimationState.getController().setAnimation(RawAnimation.begin().then("animation.elephant.walk", Animation.LoopType.LOOP));
        } else if (this.isDrinking()) {
            AnimationState.getController().setAnimation(RawAnimation.begin().then("animation.elephant.drink", Animation.LoopType.HOLD_ON_LAST_FRAME));
        } else if (isTrumpeting()) {
            AnimationState.getController().setAnimation(RawAnimation.begin().then("animation.elephant.trumpet", Animation.LoopType.PLAY_ONCE));
        } else {
            AnimationState.getController().setAnimation(RawAnimation.begin().then("animation.elephant.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }


     //  private PlayState trumpetPredicate (AnimationState state){
     //      if (isTrumpeting()) {
     //          state.getController().setAnimation(RawAnimation.begin().then("animation.elephant.trumpet", Animation.LoopType.PLAY_ONCE));

     //          return PlayState.CONTINUE;
     //      } else {
     //          state.getController().forceAnimationReset();
     //          return PlayState.STOP;
     //      }

     //  }

    private PlayState attackPredicate(AnimationState state) {
        if (this.swinging && state.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            state.getController().forceAnimationReset();
            state.getController().setAnimation(RawAnimation.begin().then("animation.elephant.attack", Animation.LoopType.PLAY_ONCE));
            this.swinging = false;
        }

        return PlayState.CONTINUE;
    }

        private PlayState deathPredicate (AnimationState animationState){
            if (this.dead) {
                animationState.getController().setAnimation(RawAnimation.begin().then("animation.elephant.death", Animation.LoopType.PLAY_ONCE));

            }
            return PlayState.CONTINUE;
        }

        public void aiStep () {
            super.aiStep();
            if (this.level().random.nextInt(400) == 0) {
                imitateNearbyMobs(this.level(), this);
            }

            if (this.level().random.nextInt(200) == 0) {
                setFalse();
            }

            if (this.level() instanceof ServerLevel serverLevel) {
                if (this.isMuddy()) {
                    this.setDirtyTicks(this.isInWater() ? 0 : Math.max(0, this.getDirtyTicks() - 1));
                } else {
                    SoundEvent mudsplat = getMudSound();
                    long dayTime = serverLevel.getDayTime();
                    if (dayTime > 4300 && dayTime < 11000 && this.onGround() && this.getRandom().nextFloat() < 0.001f && !this.isDrinking()) {
                        this.swing(InteractionHand.MAIN_HAND);
                        this.setDirtyTicks(1000);
                        this.playSound(mudsplat,1,1);
                        serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.DIRT.defaultBlockState()), this.getX(), this.getY(), this.getZ(),
                                200, 0.5, 3.0, 0.5, 10);
                    }
                }
            }

            if (this.level() instanceof ServerLevel serverLevel) {
                if (this.isDrinking() && this.random.nextInt(50) == 0) {
                    SoundEvent soundEvent = this.getDrinkingSound();
                    this.playSound(soundEvent, 1f,1f);


                }
            }
        }


        @Override
        public AnimatableInstanceCache getAnimatableInstanceCache () {
            return cache;
        }

        @Override
        public InteractionResult mobInteract (Player player, InteractionHand hand){
            return super.mobInteract(player, hand);
        }

    static class ElephantMeleeAttackGoal extends MeleeAttackGoal {
        public ElephantMeleeAttackGoal(PathfinderMob pathfinderMob, double speedMultiplier, boolean followingTargetEvenIfNotSeen) {
            super(pathfinderMob, speedMultiplier, followingTargetEvenIfNotSeen);
        }

        @Override
        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return Mth.square(this.mob.getBbWidth());
        }
    }

        static class ElephantMoveToWaterGoal extends MoveToBlockGoal {
            private final ElephantEntity elephant;

            public ElephantMoveToWaterGoal(ElephantEntity pathfinderMob, double speedModifier, int searchRange, int verticalSearchRange) {
                super(pathfinderMob, speedModifier, searchRange, verticalSearchRange);
                this.elephant = pathfinderMob;
            }

            @Override
            public boolean canUse() {
                return !this.elephant.isBaby() && !this.elephant.isDrinking() && this.elephant.waterPos == null && super.canUse();
            }

            @Override
            public boolean canContinueToUse() {
                return !this.isReachedTarget() && super.canContinueToUse();
            }

            @Override
            protected boolean isValidTarget(LevelReader level, BlockPos pos) {
                if (level.getBlockState(pos).is(Blocks.GRASS_BLOCK)) {
                    for (Direction direction : Direction.Plane.HORIZONTAL) {
                        if (level.getFluidState(pos.relative(direction)).is(Fluids.WATER)) {
                            this.elephant.waterPos = pos.relative(direction);
                            return true;
                        }
                    }
                }
                return false;
            }

            @Override
            public double acceptedDistance() {
                return 2.5D;
            }

            @Override
            public void stop() {
                this.elephant.setDrinking(true);
                super.stop();
            }
        }
        static class ElephantDrinkWaterGoal extends Goal {
            private final ElephantEntity elephant;
            private int drinkTicks;

            public ElephantDrinkWaterGoal(ElephantEntity elephant) {
                this.elephant = elephant;
                this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
            }

            @Override
            public boolean canUse() {
                if (this.elephant.waterPos == null || this.elephant.distanceToSqr(Vec3.atCenterOf(this.elephant.waterPos)) > 15) {
                    this.elephant.setDrinking(false);
                    return false;
                }
                return this.elephant.isDrinking();
            }

            @Override
            public boolean canContinueToUse() {
                return this.drinkTicks > 0 && super.canContinueToUse();
            }

            @Override
            public void start() {
                this.drinkTicks = 150;
                if (this.elephant.waterPos != null) {
                    this.elephant.getLookControl().setLookAt(Vec3.atCenterOf(this.elephant.waterPos));
                }
            }

            @Override
            public void tick() {
                this.drinkTicks--;
                if (this.elephant.waterPos != null) {
                    this.elephant.getLookControl().setLookAt(Vec3.atCenterOf(this.elephant.waterPos));
                }
            }

            @Override
            public void stop() {
                this.elephant.waterPos = null;
                this.elephant.setDrinking(false);
            }
        }
    }
