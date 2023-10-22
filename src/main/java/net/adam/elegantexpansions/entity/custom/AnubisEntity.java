package net.adam.elegantexpansions.entity.custom;

import net.adam.elegantexpansions.entity.ModEntityTypes;
import net.adam.elegantexpansions.item.ModItems;
import net.adam.elegantexpansions.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import javax.annotation.Nullable;
import java.util.EnumSet;


public class AnubisEntity extends Monster implements GeoEntity {
    private AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);

    private final ServerBossEvent bossEvent = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private boolean firstsummon;
    private LivingEntity target;
    private boolean secondsummon;
    private boolean thirdsummon;
    private boolean summon1;
    private boolean summon2;
    private boolean summon3;
    private boolean friends1;
    private boolean friends2;
    private boolean friends3;
    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(AnubisEntity.class, EntityDataSerializers.INT);
    private static final int INVULNERABLE_TICKS = 220;
    protected int nextSoundTickCount;



    public AnubisEntity(EntityType<? extends AnubisEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setHealth(this.getMaxHealth());
        this.xpReward = 500;
    }

    public int getInvulnerableTicks() {
        return this.entityData.get(DATA_ID_INV);
    }

    public boolean isInvulnerable() {
        return this.getInvulnerableTicks() > 0;
    }

    public void setInvulnerableTicks(int p_31511_) {
        this.entityData.set(DATA_ID_INV, p_31511_);
    }

    public void makeInvulnerable() {
        this.setInvulnerableTicks(220);
        this.bossEvent.setProgress(0.0F);
        this.setHealth(this.getMaxHealth() / 3.0F);
        this.playSound(ModSounds.ANUBIS_SPAWN.get());

    }




    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_INV, 0);
    }

    public void addAdditionalSaveData(CompoundTag p_31485_) {
        super.addAdditionalSaveData(p_31485_);
        p_31485_.putInt("Invul", this.getInvulnerableTicks());
    }

    public void readAdditionalSaveData(CompoundTag p_31474_) {
        super.readAdditionalSaveData(p_31474_);
        this.setInvulnerableTicks(p_31474_.getInt("Invul"));
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
        return MobType.UNDEAD;
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

                .add(Attributes.MAX_HEALTH, 200)
                .add(Attributes.ARMOR,20)
                .add(Attributes.ARMOR_TOUGHNESS,5)
                .add(Attributes.ATTACK_DAMAGE, 10.00f)
                .add(Attributes.ATTACK_SPEED, 1.1f)
                .add(Attributes.MOVEMENT_SPEED, 0.215f)
                .add(Attributes.FOLLOW_RANGE,45.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 1.2f).build();

    }

    @Override
    public void clearFire() {
        super.clearFire();
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new AnubisEntity.AnubisDoNothingGoal());
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

        if (this.isInvulnerable()) {
            animationState.getController().setAnimation(RawAnimation.begin().then("spawning", Animation.LoopType.PLAY_ONCE));
            return PlayState.CONTINUE;
        }
        if (animationState.isMoving()) {
            animationState.getController().setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationState state) {
        if (this.swinging && state.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            state.getController().forceAnimationReset();
            state.getController().setAnimation(RawAnimation.begin().then("attack", Animation.LoopType.PLAY_ONCE));
            this.swinging = false;
        }
        return PlayState.CONTINUE;
    }




    private PlayState firstAnim(AnimationState state) {
        if (this.quater() && !this.isInvulnerable()) {
            state.getController().setAnimation(RawAnimation.begin().then("cast", Animation.LoopType.PLAY_ONCE));
        }
        return PlayState.CONTINUE;
    }

    private PlayState secondAnim(AnimationState state) {
        if (this.half() && !this.isInvulnerable()) {
            state.getController().setAnimation(RawAnimation.begin().then("cast", Animation.LoopType.PLAY_ONCE));
        }
        return PlayState.CONTINUE;
    }

    private PlayState thirdAnim(AnimationState state) {
        if (this.threequater()) {
            state.getController().setAnimation(RawAnimation.begin().then("summon", Animation.LoopType.PLAY_ONCE));
        }
        return PlayState.CONTINUE;
    }


    public boolean quater() {
        return this.getHealth() <= this.getMaxHealth() / 1.5F;
    }

    public boolean half() {
        return this.getHealth() <= this.getMaxHealth() / 2.0F;
    }
    public boolean threequater() {
        return this.getHealth() <= this.getMaxHealth() / 4.0F;
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this, "controller",
                0, this::predicate));
        controllers.add(new AnimationController(this, "attackController",
                0, this::attackPredicate));
        controllers.add(new AnimationController<>(this, "firstController",
                0, this::firstAnim));
        controllers.add(new AnimationController<>(this, "secondController",
                0, this::secondAnim));
        controllers.add(new AnimationController<>(this, "thirdController",
                0, this::thirdAnim));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return factory;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(ModSounds.GOLEM_WALK.get(), 0.25F, 1.0F);
    }

    protected void dropCustomDeathLoot(DamageSource p_31464_, int p_31465_, boolean p_31466_) {
        super.dropCustomDeathLoot(p_31464_, p_31465_, p_31466_);
        ItemEntity itementity = this.spawnAtLocation(ModItems.GEM_UPGRADE_TEMPLATE.get());
        if (itementity != null) {
            itementity.setExtendedLifetime();
        }

    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.GOLEM_HURT.get();
    }
    protected SoundEvent getDeathSound() {
        return ModSounds.GOLEM_DEATH.get();
    }
    protected SoundEvent getAmbientSound() {
        return !isInvulnerable() ? ModSounds.ANUBIS_AMBIENT.get() : null;

    }

    @Override
    public int getAmbientSoundInterval() {
        return 300;
    }


    protected float getSoundVolume() {
        return 2F;
    }

    @Override
    public void baseTick() {
        super.baseTick();
    }

    public boolean hurt(DamageSource p_31461_, float p_31462_) {
        if (this.isInvulnerableTo(p_31461_)) {
            return false;

        } else if (!p_31461_.is(DamageTypeTags.WITHER_IMMUNE_TO) && !(p_31461_.getEntity() instanceof AnubisEntity)) {
            if (this.getInvulnerableTicks() > 0 && !p_31461_.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                return false;

            } else {



                if (this.half()) {
                    Entity entity = p_31461_.getDirectEntity();
                    if (entity instanceof AbstractArrow) {
                        return false;
                    }
                }
                if (this.threequater()) {
                    Entity entity = p_31461_.getDirectEntity();
                    if (entity instanceof AbstractArrow && entity instanceof Projectile) {
                        return false;
                    }
                }
            }
        }
        return super.hurt(p_31461_, p_31462_);
    }


    @Override
    public boolean doHurtTarget(Entity p_32892_) {
        boolean flag = super.doHurtTarget(p_32892_);
        if (flag && this.getMainHandItem().isEmpty() && p_32892_ instanceof LivingEntity) {
            float f = this.level().getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            ((LivingEntity) p_32892_).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60 * (int) f), this);
        }

        return flag;
    }

    public void summonLightning(Entity ptarget) {
        if (!level().isClientSide()) {
            ServerLevel world = ((ServerLevel) level());
            BlockPos position = ptarget.blockPosition();

            EntityType.LIGHTNING_BOLT.spawn(world, (ItemStack) null, null, position,
                    MobSpawnType.TRIGGERED, true, true);
        }
    }

    @Override
    protected void customServerAiStep() {
        if (this.getInvulnerableTicks() > 0) {
            int k1 = this.getInvulnerableTicks() - 1;
            this.bossEvent.setProgress(1.0F - (float)k1 / 220.0F);
            if (k1 == 50) {
                this.summonLightning(this);
            }
            if (k1 == 125) {
                this.summonLightning(this);
            }
            if (k1 == 200) {
                this.summonLightning(this);
            }
            if (k1 == 2) {
                this.clearFire();
            }

            this.setInvulnerableTicks(k1);
            if (this.tickCount % 10 == 0) {
                this.heal(10.0F);
            }

        } else {
            super.customServerAiStep();

            this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        }
        {
            if (this.quater() && !this.summon1 && !this.friends1 && !this.isInvulnerable()) {
                this.level().playSound(null, blockPosition(), ModSounds.ANUBIS_HEAL1.get(), SoundSource.HOSTILE, 1, 1);
                this.summon1 = true;

                if (this.summon1 && !this.friends1) {


                    this.level().playSound(null, blockPosition(), ModSounds.ANUBIS_AWAKEN.get(), SoundSource.HOSTILE, 1, 1);
                    this.friends1 = true;
                }
            }

        }
        {
            if (this.half() && !this.summon2 && !this.isInvulnerable()) {
                this.level().playSound(null, blockPosition(), ModSounds.ANUBIS_HEAL2.get(), SoundSource.HOSTILE, 1, 1);
                this.summon2 = true;


            }

        }
        {
            if (this.threequater() && !this.summon3 && !this.isInvulnerable()) {
                this.level().playSound(null, blockPosition(), ModSounds.ANUBIS_HEAL3.get(), SoundSource.HOSTILE, 1, 1);
                this.summon3 = true;
            }

        }

        {
            if (this.quater() && !this.firstsummon && !this.isInvulnerable()) {
                ServerLevel serverlevel = (ServerLevel) AnubisEntity.this.level();
                this.heal(250);
                for (int i = 0; i < 3; ++i) {
                    BlockPos blockpos = AnubisEntity.this.blockPosition().offset(-2 + AnubisEntity.this.random.nextInt(5), 1, -2 + AnubisEntity.this.random.nextInt(5));
                    MummyEntity mummy = ModEntityTypes.MUMMY.get().create(AnubisEntity.this.level());
                    if (mummy != null) {
                        mummy.moveTo(blockpos, 0.0F, 0.0F);
                        mummy.finalizeSpawn(serverlevel, AnubisEntity.this.level().getCurrentDifficultyAt(blockpos), MobSpawnType.MOB_SUMMONED, (SpawnGroupData) null, (CompoundTag) null);
                        serverlevel.addFreshEntity(mummy);
                        this.firstsummon = true;
                    }

                }
            }

        }
        {
            if (this.half() && !this.secondsummon && !this.isInvulnerable()) {
                ServerLevel serverlevel = (ServerLevel) AnubisEntity.this.level();
                this.heal(250);

                for (int i = 0; i < 7; ++i) {
                    BlockPos blockpos = AnubisEntity.this.blockPosition().offset(-2 + AnubisEntity.this.random.nextInt(5), 1, -2 + AnubisEntity.this.random.nextInt(5));
                    MummyEntity mummy = ModEntityTypes.MUMMY.get().create(AnubisEntity.this.level());
                    if (mummy != null) {
                        mummy.moveTo(blockpos, 0.0F, 0.0F);
                        mummy.invulnerableTime = 10;
                        mummy.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST));
                        mummy.finalizeSpawn(serverlevel, AnubisEntity.this.level().getCurrentDifficultyAt(blockpos), MobSpawnType.MOB_SUMMONED, (SpawnGroupData) null, (CompoundTag) null);
                        serverlevel.addFreshEntity(mummy);
                        this.secondsummon = true;

                    }
                }
            }
        }

        {
            if (this.threequater() && !this.thirdsummon && !this.isInvulnerable()) {
                ServerLevel serverlevel = (ServerLevel) AnubisEntity.this.level();
                this.heal(250);

                for (int i = 0; i < 11; ++i) {
                    BlockPos blockpos = AnubisEntity.this.blockPosition().offset(-2 + AnubisEntity.this.random.nextInt(5), 1, -2 + AnubisEntity.this.random.nextInt(5));
                    MummyEntity mummy = ModEntityTypes.MUMMY.get().create(AnubisEntity.this.level());
                    if (mummy != null) {
                        mummy.moveTo(blockpos, 0.0F, 0.0F);
                        mummy.invulnerableTime = 10;
                        mummy.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST));
                        mummy.finalizeSpawn(serverlevel, AnubisEntity.this.level().getCurrentDifficultyAt(blockpos), MobSpawnType.MOB_SUMMONED, (SpawnGroupData) null, (CompoundTag) null);
                        serverlevel.addFreshEntity(mummy);
                        this.thirdsummon = true;

                    }
                }
            }
        }
    }


    class AnubisDoNothingGoal extends Goal {
        public AnubisDoNothingGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            return AnubisEntity.this.getInvulnerableTicks() > 0;
        }
    }

}









