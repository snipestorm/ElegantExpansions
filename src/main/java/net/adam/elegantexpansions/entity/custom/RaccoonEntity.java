package net.adam.elegantexpansions.entity.custom;

import com.google.common.collect.Maps;
import net.adam.elegantexpansions.entity.ModEntityTypes;
import net.adam.elegantexpansions.entity.variant.ElephantVariant;
import net.adam.elegantexpansions.entity.variant.RaccoonVariant;
import net.adam.elegantexpansions.sound.ModSounds;
import net.adam.elegantexpansions.util.ModBiomeTags;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FrogVariant;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;


public class RaccoonEntity extends Animal implements GeoEntity, PlayerRideable {
    private static final Predicate<LivingEntity> PARENT_RACCOON_SELECTOR = (parent) -> {
        return parent instanceof RaccoonEntity && ((RaccoonEntity) parent).isBred();
    };
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.SWEET_BERRIES);
    private static final TargetingConditions MOMMY_TARGETING = TargetingConditions.forNonCombat().range(16.0D).ignoreLineOfSight().selector(PARENT_RACCOON_SELECTOR);
    private static final int FLAG_BRED = 8;
    private static final EntityDataAccessor<Byte> DATA_ID_FLAGS = SynchedEntityData.defineId(RaccoonEntity.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(RaccoonEntity.class, EntityDataSerializers.INT);


    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);


    public RaccoonEntity(EntityType<? extends RaccoonEntity> entityType, Level level) {
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

    public boolean canBeLeashed(Player p_21418_) {
        return true;
    }

    public void addAdditionalSaveData(CompoundTag raccoonadd) {
        super.addAdditionalSaveData(raccoonadd);
        raccoonadd.putBoolean("Bred", this.isBred());
        raccoonadd.putInt("Variant", this.getTypeVariant());
    }

    public void readAdditionalSaveData(CompoundTag raccoonread) {
        super.readAdditionalSaveData(raccoonread);
        this.setBred(raccoonread.getBoolean("Bred"));
        this.entityData.set(DATA_ID_TYPE_VARIANT, raccoonread.getInt("Variant"));
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_FLAGS, (byte) 0);
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    public RaccoonVariant getVariant() {
        return RaccoonVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(RaccoonVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason,
                                        @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        Holder<Biome> holder = pLevel.getBiome(this.blockPosition());
        if (holder.is(ModBiomeTags.SPAWNS_BLACK_RACCOON)) {
            this.setVariant(RaccoonVariant.BLACK);

        } else if (holder.is(ModBiomeTags.SPAWNS_BROWN_RACCOON)) {
            this.setVariant(RaccoonVariant.BROWN);

        } else if (holder.is(ModBiomeTags.SPAWNS_RED_RACCOON)) {
            this.setVariant(RaccoonVariant.RED);

        } else if (holder.is(ModBiomeTags.SPAWNS_BLUE_RACCOON)) {
            this.setVariant(RaccoonVariant.BLUE);

        } else if (holder.is(ModBiomeTags.SPAWNS_WHITE_RACCOON)) {
            this.setVariant(RaccoonVariant.WHITE);

        } else {
            this.setVariant(RaccoonVariant.GREY);
        }
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    public boolean isBred() {
        return this.getFlag(8);
    }

    public void setBred(boolean babyraccoon) {
        this.setFlag(8, babyraccoon);
    }

    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3f).build();
    }

    @SubscribeEvent
    public static void entitySpawnRestriction(SpawnPlacementRegisterEvent event) {
        event.register(ModEntityTypes.RACCOON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.25D, FOOD_ITEMS, false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }

    @Nullable


    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob mob) {
        RaccoonEntity raccoon = ModEntityTypes.RACCOON.get().create(serverLevel);
        if (raccoon != null) {
            RaccoonVariant raccoonvariant;
            if (useRareVariant(this.random)) {
                raccoonvariant = RaccoonVariant.getRareSpawnVariant(this.random);
            } else {
                raccoonvariant = this.random.nextBoolean() ? this.getVariant() : ((RaccoonEntity)mob).getVariant();
            }

            raccoon.setVariant(raccoonvariant);
            raccoon.setPersistenceRequired();
        }

        return raccoon ;
    }

    private static boolean useRareVariant(RandomSource p_218436_) {
        return p_218436_.nextInt(100) == 0;
    }
    public boolean isFood(ItemStack food) {
        return FOOD_ITEMS.test(food);
    }


    @Override
   public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::idlewalk));
        controllerRegistrar.add(new AnimationController<>(this, "death_controller", 0, this::deathPredicate));
    }

    private <T extends GeoAnimatable> PlayState idlewalk(AnimationState<T> AnimationState) {
        if (AnimationState.isMoving()) {
            AnimationState.getController().setAnimation(RawAnimation.begin().then("animation.raccoon.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        AnimationState.getController().setAnimation(RawAnimation.begin().then("animation.raccoon.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }




    private PlayState deathPredicate(AnimationState animationState) {
        if (this.dead) {
            animationState.getController().setAnimation(RawAnimation.begin().then("animation.raccoon.sit", Animation.LoopType.PLAY_ONCE));

        }
        return PlayState.CONTINUE;
    }

    public void aiStep() {
        super.aiStep();
        this.followParent();

    }


    protected void followParent() {
        if (this.isBred() && this.isBaby()) {
            LivingEntity livingentity = this.level().getNearestEntity(RaccoonEntity.class, MOMMY_TARGETING, this, this.getX(), this.getY(), this.getZ(), this.getBoundingBox().inflate(16.0D));
            if (livingentity != null && this.distanceToSqr(livingentity) > 4.0D) {
                this.navigation.createPath(livingentity, 0);
            }
        }

    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        return super.mobInteract(player, hand);
    }


}
