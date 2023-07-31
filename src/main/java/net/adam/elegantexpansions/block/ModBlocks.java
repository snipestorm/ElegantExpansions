package net.adam.elegantexpansions.block;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.block.custom.GemCuttingStationBlock;
import net.adam.elegantexpansions.block.custom.GemInfusingStationBlock;
import net.adam.elegantexpansions.block.custom.ModFlammableRotatedPillarBlock;
import net.adam.elegantexpansions.block.custom.ShardCreationStationBlock;
import net.adam.elegantexpansions.fluid.ModFluids;
import net.adam.elegantexpansions.item.ModItems;
import net.adam.elegantexpansions.worldgen.tree.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, ElegantExpansions.MOD_ID);

    //ruby//

    public static final RegistryObject<Block> RUBY_BLOCK = registerblock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> RUBY_ORE = registerblock("ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2,6)));

    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerblock("deepslate_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .strength(8f).requiresCorrectToolForDrops(), UniformInt.of(2,6)));

//sapphire//

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerblock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SAPPHIRE_ORE = registerblock("sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2,6)));

    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerblock("deepslate_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .strength(8f).requiresCorrectToolForDrops(), UniformInt.of(2,6)));

    //tanzanite//

    public static final RegistryObject<Block> TANZANITE_BLOCK = registerblock("tanzanite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ENDSTONE_TANZANITE_ORE = registerblock("endstone_tanzanite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2,6)));

    //citrine//

    public static final RegistryObject<Block> CITRINE_BLOCK = registerblock("citrine_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NETHER_CITRINE_ORE = registerblock("nether_citrine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2,6)));

    //onyx//

    public static final RegistryObject<Block> ONYX_BLOCK = registerblock("onyx_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops()));

    //Gem based blocks//

    public static final RegistryObject<Block> GEM_CUTTING_STATION = registerblock("gem_cutting_station",
            () -> new GemCuttingStationBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GEM_INFUSING_STATION = registerblock("gem_infusing_station",
            () -> new GemInfusingStationBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHARD_CREATION_STATION = registerblock("shard_creation_station",
            () -> new ShardCreationStationBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .strength(6f).requiresCorrectToolForDrops()));



    public static final RegistryObject<Block> MAGIC_LOG = registerblock("magic_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(5f)));

    public static final RegistryObject<Block> MAGIC_WOOD = registerblock("magic_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(5f)));

    public static final RegistryObject<Block> STRIPPED_MAGIC_LOG = registerblock("stripped_magic_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(5f)));

    public static final RegistryObject<Block> STRIPPED_MAGIC_WOOD = registerblock("stripped_magic_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(5f)));



    public static final RegistryObject<Block> MAGIC_PLANKS = registerblock("magic_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(5f)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> MAGIC_LEAVES = registerblock("magic_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });

    public static final RegistryObject<Block> MAGIC_SAPLING = registerblock("magic_sapling",
            () -> new SaplingBlock(new MagicTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> WILLOW_LOG = registerblock("willow_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(5f)));

    public static final RegistryObject<Block> WILLOW_WOOD = registerblock("willow_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(5f)));

    public static final RegistryObject<Block> STRIPPED_WILLOW_LOG = registerblock("stripped_willow_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(5f)));

    public static final RegistryObject<Block> STRIPPED_WILLOW_WOOD = registerblock("stripped_willow_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(5f)));



    public static final RegistryObject<Block> WILLOW_PLANKS = registerblock("willow_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(5f)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> WILLOW_LEAVES = registerblock("willow_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });

    public static final RegistryObject<Block> WILLOW_SAPLING = registerblock("willow_sapling",
            () -> new SaplingBlock(new WillowTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> MAPLE_LEAVES = registerblock("maple_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });

    public static final RegistryObject<Block> MAPLE_SAPLING = registerblock("maple_sapling",
            () -> new SaplingBlock(new MapleTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> ASH_LOG = registerblock("ash_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(5f)));

    public static final RegistryObject<Block> ASH_WOOD = registerblock("ash_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(5f)));

    public static final RegistryObject<Block> STRIPPED_ASH_LOG = registerblock("stripped_ash_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(5f)));

    public static final RegistryObject<Block> STRIPPED_ASH_WOOD = registerblock("stripped_ash_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(5f)));



    public static final RegistryObject<Block> ASH_PLANKS = registerblock("ash_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(5f)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> ASH_LEAVES = registerblock("ash_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });

    public static final RegistryObject<Block> ASH_SAPLING = registerblock("ash_sapling",
            () -> new SaplingBlock(new AshTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));




    public static final RegistryObject<Block> BANANA_LOG = registerblock("banana_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(5f)));

    public static final RegistryObject<Block> BANANA_WOOD = registerblock("banana_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(5f)));

    public static final RegistryObject<Block> STRIPPED_BANANA_LOG = registerblock("stripped_banana_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(5f)));

    public static final RegistryObject<Block> STRIPPED_BANANA_WOOD = registerblock("stripped_banana_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(5f)));



    public static final RegistryObject<Block> BANANA_PLANKS = registerblock("banana_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(5f)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> BANANA_LEAVES = registerblock("banana_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });

    public static final RegistryObject<Block> BANANA_SAPLING = registerblock("banana_sapling",
            () -> new SaplingBlock(new BananaTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));



    public static final RegistryObject<LiquidBlock> MAGICAL_SAP_BLOCK = BLOCKS.register("magical_sap_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MAGICAL_SAP, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));



    private static <T extends Block> RegistryObject<T> registerblock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;


    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register (IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
