package net.adam.elegantexpansions.block.entity;
import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.block.ModBlocks;
import net.adam.elegantexpansions.block.entity.custom.GemCuttingStationBlockEntity;
import net.adam.elegantexpansions.block.entity.custom.GemInfusingStationBlockEntity;
import net.adam.elegantexpansions.block.entity.custom.ShardCreationStationBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ElegantExpansions.MOD_ID);

    public static final RegistryObject<BlockEntityType<GemCuttingStationBlockEntity>> GEM_CUTTING_STATION_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("gem_cutting_station_block_entity", () ->
                    BlockEntityType.Builder.of(GemCuttingStationBlockEntity::new,
                            ModBlocks.GEM_CUTTING_STATION.get()).build(null));

    public static final RegistryObject<BlockEntityType<GemInfusingStationBlockEntity>> GEM_INFUSING_STATION_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("gem_infusing_station_block_entity", () ->
                    BlockEntityType.Builder.of(GemInfusingStationBlockEntity::new,
                            ModBlocks.GEM_INFUSING_STATION.get()).build(null));

    public static final RegistryObject<BlockEntityType<ShardCreationStationBlockEntity>> SHARD_CREATION_STATION_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("shard_creation_station_block_entity", () ->
                    BlockEntityType.Builder.of(ShardCreationStationBlockEntity::new,
                            ModBlocks.SHARD_CREATION_STATION.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}