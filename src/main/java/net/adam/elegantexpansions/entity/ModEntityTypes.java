package net.adam.elegantexpansions.entity;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.entity.custom.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ElegantExpansions.MOD_ID);

    public static final RegistryObject<EntityType<GolemEntity>> GOLEM =
            ENTITY_TYPES.register("golem",
                    () -> EntityType.Builder.of(GolemEntity::new, MobCategory.MONSTER)
                            .sized(1.5F, 3.1f)
                            .build(new ResourceLocation(ElegantExpansions.MOD_ID, "golem").toString()));

    public static final RegistryObject<EntityType<MummyEntity>> MUMMY =
            ENTITY_TYPES.register("mummy",
                    () -> EntityType.Builder.of(MummyEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95f)
                            .build(new ResourceLocation(ElegantExpansions.MOD_ID, "mummy").toString()));

    public static final RegistryObject<EntityType<PlayersMummy>> PLAYERS_MUMMY =
            ENTITY_TYPES.register("players_mummy",
                    () -> EntityType.Builder.of(PlayersMummy::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95f)
                            .build(new ResourceLocation(ElegantExpansions.MOD_ID, "mummy").toString()));

    public static final RegistryObject<EntityType<AnubisEntity>> ANUBIS =
            ENTITY_TYPES.register("anubis",
                    () -> EntityType.Builder.of(AnubisEntity::new, MobCategory.MONSTER)
                            .sized(0.9F, 2.25f)
                            .build(new ResourceLocation(ElegantExpansions.MOD_ID, "anubis").toString()));

    public static final RegistryObject<EntityType<TigerEntity>> TIGER =
            ENTITY_TYPES.register("tiger",
                    () -> EntityType.Builder.of(TigerEntity::new, MobCategory.CREATURE)
                            .sized(0.6F, 1.95f)
                            .build(new ResourceLocation(ElegantExpansions.MOD_ID, "tiger").toString()));

    public static final RegistryObject<EntityType<WhiteTigerEntity>> WHITE_TIGER =
            ENTITY_TYPES.register("white_tiger",
                    () -> EntityType.Builder.of(WhiteTigerEntity::new, MobCategory.CREATURE)
                            .sized(0.6F, 1.95f)
                            .build(new ResourceLocation(ElegantExpansions.MOD_ID, "white_tiger").toString()));

    public static final RegistryObject<EntityType<AlbinoTigerEntity>> ALBINO_TIGER =
            ENTITY_TYPES.register("albino_tiger",
                    () -> EntityType.Builder.of(AlbinoTigerEntity::new, MobCategory.CREATURE)
                            .sized(0.6F, 1.95f)
                            .build(new ResourceLocation(ElegantExpansions.MOD_ID, "albino_tiger").toString()));

    public static final RegistryObject<EntityType<CapybaraEntity>> CAPYBARA =
            ENTITY_TYPES.register("capybara",
                    () -> EntityType.Builder.of(CapybaraEntity::new, MobCategory.CREATURE)
                            .sized(0.6F, 1.95f)
                            .build(new ResourceLocation(ElegantExpansions.MOD_ID, "capybara").toString()));

    public static final RegistryObject<EntityType<ShrekEntity>> SHREK =
            ENTITY_TYPES.register("shrek",
                    () -> EntityType.Builder.of(ShrekEntity::new, MobCategory.CREATURE)
                            .sized(2F, 3f)
                            .build(new ResourceLocation(ElegantExpansions.MOD_ID, "shrek").toString()));

    public static final RegistryObject<EntityType<SharkEntity>> SHARK =
            ENTITY_TYPES.register("shark",
                    () -> EntityType.Builder.of(SharkEntity::new, MobCategory.WATER_CREATURE)
                            .sized(1.3F, 0.7f)
                            .build(new ResourceLocation(ElegantExpansions.MOD_ID, "shrek").toString()));

    public static final RegistryObject<EntityType<ElephantEntity>> ELEPHANT =
            ENTITY_TYPES.register("elephant",
                    () -> EntityType.Builder.of(ElephantEntity::new, MobCategory.CREATURE)
                            .sized(2.2F,3F)
                            .build(new ResourceLocation(ElegantExpansions.MOD_ID, "elephant").toString()));

    public static final RegistryObject<EntityType<RaccoonEntity>> RACCOON =
            ENTITY_TYPES.register("raccoon",
                    () -> EntityType.Builder.of(RaccoonEntity::new, MobCategory.CREATURE)
                            .sized(0.8F,0.6F)
                            .build(new ResourceLocation(ElegantExpansions.MOD_ID, "raccoon").toString()));

    public static final RegistryObject<EntityType<LionEntity>> LION =
            ENTITY_TYPES.register("lion",
                    () -> EntityType.Builder.of(LionEntity::new, MobCategory.CREATURE)
                            .sized(0.6F, 1.95f)
                            .build(new ResourceLocation(ElegantExpansions.MOD_ID, "lion").toString()));

    public static final RegistryObject<EntityType<HippoEntity>> HIPPO =
            ENTITY_TYPES.register("hippo",
                    () -> EntityType.Builder.of(HippoEntity::new, MobCategory.CREATURE)
                            .sized(0.6F, 1.95f)
                            .build(new ResourceLocation(ElegantExpansions.MOD_ID, "hippo").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}