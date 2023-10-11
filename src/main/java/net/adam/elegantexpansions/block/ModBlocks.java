package net.adam.elegantexpansions.block;

import net.adam.elegantexpansions.ElegantExpansions;
import net.adam.elegantexpansions.block.custom.*;
import net.adam.elegantexpansions.fluid.ModFluids;
import net.adam.elegantexpansions.item.ModItems;
import net.adam.elegantexpansions.worldgen.tree.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, ElegantExpansions.MOD_ID);

   // public static final RegistryObject<Block> ANUBIS_SKULL = registerblock("anubis_skull",
   //         () -> new AnubisSkullBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.WITHER_SKELETON)
   //                 .strength(1.0F).noOcclusion().pushReaction(PushReaction.DESTROY)));
//
   // public static final RegistryObject<Block> ANUBIS_WALL_SKULL = registerblock("anubis_wall_skull",
   //         () -> new AnubisWallSkullBlock(BlockBehaviour.Properties.of().noOcclusion().strength(1.0F).dropsLike(ANUBIS_SKULL.get()).pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> LANTERN_OF_ANUBIS = registerblock("lantern_of_anubis",
            () -> new LanternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).forceSolidOn().requiresCorrectToolForDrops().strength(3.5F)
                    .sound(SoundType.LANTERN).lightLevel((p_152677_) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> GOLD_CHAIN = registerblock("gold_chain",
            () -> new ChainBlock(BlockBehaviour.Properties.of().forceSolidOn().requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F).sound(SoundType.CHAIN).noOcclusion()));

    public static final RegistryObject<Block> EYE_OF_HORUS_GOLD = registerblock("eye_of_horus_gold",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ANKH_GOLD = registerblock("ankh_gold",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GLPYH_OF_ANUBIS_GOLD = registerblock("glyph_of_anubis_gold",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ANUBIS_SUMMON_BLOCK = registerblock("anubis_summon_block",
            () -> new AnubisSummonBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(AnubisSummonBlock.LIT) ? 15 : 0)
                    .strength(-1F, 1200F).sound(SoundType.METAL).noLootTable()));

//golem//

    public static final RegistryObject<Block> MYSTERIOUS_CUBE = registerblock("mysterious_cube",
            () -> new MysteriousCube(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.GLASS)));

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
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GEM_INFUSING_STATION = registerblock("gem_infusing_station",
            () -> new GemInfusingStationBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHARD_CREATION_STATION = registerblock("shard_creation_station",
            () -> new ShardCreationStationBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SAP_EXTRACTOR = registerblock("sap_extractor",
            () -> new SapExtractorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> WHITE_SAND = registerblock("white_sand",
            () -> new SandBlock(16118234, BlockBehaviour.Properties.of().mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));

  // public static final RegistryObject<Block> WHITE_SUSPICIOUS_SAND = registerblock("white_suspicious_sand",
  //         () ->  new BrushableBlock(ModBlocks.WHITE_SAND.get(), BlockBehaviour.Properties.of().mapColor(MapColor.SAND)
  //                 .instrument(NoteBlockInstrument.SNARE).strength(0.25F).sound(SoundType.SUSPICIOUS_SAND)
  //                 .pushReaction(PushReaction.DESTROY), SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED));

    public static final RegistryObject<Block> WHITE_SANDSTONE = registerblock("white_sandstone",
            () -> new Block (BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM)
    .requiresCorrectToolForDrops().strength(0.8F)));

    public static final RegistryObject<Block> SMOOTH_WHITE_SANDSTONE = registerblock("smooth_white_sandstone",
            () -> new Block (BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().strength(0.8F)));



    public static final RegistryObject<Block> ECHO_SOIL = registerblock("echo_soil",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.3f)
                    .mapColor(MapColor.COLOR_PURPLE)));

    public static final RegistryObject<Block> SCULK_GLEAM = registerblock("sculk_gleam",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(1f)
                    .lightLevel(state -> 15).mapColor(MapColor.SAND), UniformInt.of(1, 3)));

    public static final RegistryObject<Block> CHISELED_WHITE_SANDSTONE = registerblock("chiseled_white_sandstone",
            () -> new Block (BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().strength(0.8F)));



    public static final RegistryObject<Block> MAGIC_LOG = registerblock("magic_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(2f)));

    public static final RegistryObject<Block> MAGIC_WOOD = registerblock("magic_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(2f)));

    public static final RegistryObject<Block> STRIPPED_MAGIC_LOG = registerblock("stripped_magic_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(2f)));

    public static final RegistryObject<Block> STRIPPED_MAGIC_WOOD = registerblock("stripped_magic_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(2f)));



    public static final RegistryObject<Block> MAGIC_PLANKS = registerblock("magic_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2f)) {
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
                    .strength(2f)));

    public static final RegistryObject<Block> WILLOW_WOOD = registerblock("willow_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(2f)));

    public static final RegistryObject<Block> STRIPPED_WILLOW_LOG = registerblock("stripped_willow_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(2f)));

    public static final RegistryObject<Block> STRIPPED_WILLOW_WOOD = registerblock("stripped_willow_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(2f)));



    public static final RegistryObject<Block> WILLOW_PLANKS = registerblock("willow_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2f)) {
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
                    .strength(2f)));

    public static final RegistryObject<Block> ASH_WOOD = registerblock("ash_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(2f)));

    public static final RegistryObject<Block> STRIPPED_ASH_LOG = registerblock("stripped_ash_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(2f)));

    public static final RegistryObject<Block> STRIPPED_ASH_WOOD = registerblock("stripped_ash_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(2f)));



    public static final RegistryObject<Block> ASH_PLANKS = registerblock("ash_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2f)) {
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
                    .strength(2f)));

    public static final RegistryObject<Block> BANANA_WOOD = registerblock("banana_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(2f)));

    public static final RegistryObject<Block> STRIPPED_BANANA_LOG = registerblock("stripped_banana_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(2f)));

    public static final RegistryObject<Block> STRIPPED_BANANA_WOOD = registerblock("stripped_banana_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(2f)));



    public static final RegistryObject<Block> BANANA_PLANKS = registerblock("banana_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2f)) {
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
            () -> new SandSaplingBlock(new BananaTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> ECHO_LOG = registerblock("echo_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(2f)));

    public static final RegistryObject<Block> ECHO_WOOD = registerblock("echo_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(2f)));

    public static final RegistryObject<Block> STRIPPED_ECHO_LOG = registerblock("stripped_echo_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(2f)));

    public static final RegistryObject<Block> STRIPPED_ECHO_WOOD = registerblock("stripped_echo_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(2f)));



    public static final RegistryObject<Block> ECHO_PLANKS = registerblock("echo_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2f)) {
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

    public static final RegistryObject<Block> ECHO_LEAVES = registerblock("echo_leaves",
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

    public static final RegistryObject<Block> ECHO_SAPLING = registerblock("echo_sapling",
            () -> new SculkSaplingBlock(new EchoTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<LiquidBlock> MAGICAL_SAP_BLOCK = BLOCKS.register("magical_sap_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MAGICAL_SAP, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));

    public static final RegistryObject<Block> MYSTICSHROOM = registerblock("mysticshroom",
            () -> new FlowerBlock(() -> MobEffects.NIGHT_VISION, 5, BlockBehaviour.Properties.copy(Blocks.POPPY)));
    public static final RegistryObject<Block> POTTED_MYSTICSHROOM = BLOCKS.register("potted_mysticshroom",
            () -> new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT),MYSTICSHROOM, BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY)));

    public static final RegistryObject<Block> MYSTIC_GLOWFLOWER = registerblock("mystic_glowflower",
            () -> new FlowerBlock(() -> MobEffects.GLOWING, 5, BlockBehaviour.Properties.copy(Blocks.POPPY).lightLevel((light) -> {
                return 6;
            })));
    public static final RegistryObject<Block> POTTED_MYSTIC_GLOWFLOWER = BLOCKS.register("potted_mystic_glowflower",
            () -> new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT),MYSTIC_GLOWFLOWER, BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).lightLevel((light) -> {
                return 4;
            })));
    public static final RegistryObject<Block> ICY_IRIS = registerblock("icy_iris",
            () -> new TallFlowerBlock(BlockBehaviour.Properties.copy(Blocks.PEONY)));


    public static final RegistryObject<Block> MAGIC_STAIRS = registerblock("magic_stairs",
            () -> new StairBlock(() -> ModBlocks.MAGIC_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MAGIC_SLAB = registerblock("magic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> MAGIC_BUTTON = registerblock("magic_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.OAK, 30, true));
    public static final RegistryObject<Block> MAGIC_PRESSURE_PLATE = registerblock("magic_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> MAGIC_FENCE = registerblock("magic_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> MAGIC_FENCE_GATE = registerblock("magic_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> MAGIC_WALL = registerblock("magic_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> MAGIC_DOOR = registerblock("magic_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> MAGIC_TRAPDOOR = registerblock("magic_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));


    public static final RegistryObject<Block> ASH_STAIRS = registerblock("ash_stairs",
            () -> new StairBlock(() -> ModBlocks.ASH_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ASH_SLAB = registerblock("ash_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ASH_BUTTON = registerblock("ash_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.OAK, 30, true));
    public static final RegistryObject<Block> ASH_PRESSURE_PLATE = registerblock("ash_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> ASH_FENCE = registerblock("ash_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> ASH_FENCE_GATE = registerblock("ash_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> ASH_WALL = registerblock("ash_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ASH_DOOR = registerblock("ash_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> ASH_TRAPDOOR = registerblock("ash_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> WILLOW_STAIRS = registerblock("willow_stairs",
            () -> new StairBlock(() -> ModBlocks.WILLOW_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WILLOW_SLAB = registerblock("willow_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WILLOW_BUTTON = registerblock("willow_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.OAK, 30, true));
    public static final RegistryObject<Block> WILLOW_PRESSURE_PLATE = registerblock("willow_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> WILLOW_FENCE = registerblock("willow_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> WILLOW_FENCE_GATE = registerblock("willow_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> WILLOW_WALL = registerblock("willow_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WILLOW_DOOR = registerblock("willow_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> WILLOW_TRAPDOOR = registerblock("willow_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> PALM_STAIRS = registerblock("palm_stairs",
            () -> new StairBlock(() -> ModBlocks.BANANA_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PALM_SLAB = registerblock("palm_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PALM_BUTTON = registerblock("palm_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.OAK, 30, true));
    public static final RegistryObject<Block> PALM_PRESSURE_PLATE = registerblock("palm_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> PALM_FENCE = registerblock("palm_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> PALM_FENCE_GATE = registerblock("palm_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> PALM_WALL = registerblock("palm_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PALM_DOOR = registerblock("palm_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> PALM_TRAPDOOR = registerblock("palm_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> ECHO_STAIRS = registerblock("echo_stairs",
            () -> new StairBlock(() -> ModBlocks.ECHO_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ECHO_SLAB = registerblock("echo_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ECHO_BUTTON = registerblock("echo_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.OAK, 30, true));
    public static final RegistryObject<Block> ECHO_PRESSURE_PLATE = registerblock("echo_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> ECHO_FENCE = registerblock("echo_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> ECHO_FENCE_GATE = registerblock("echo_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> ECHO_WALL = registerblock("echo_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ECHO_DOOR = registerblock("echo_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> ECHO_TRAPDOOR = registerblock("echo_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));

    //SCULK STONE//

    public static final RegistryObject<Block> SCULK_STONE = registerblock("sculk_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_CYAN)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCULK_STONE_STAIRS = registerblock("sculk_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.SCULK_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SCULK_STONE_SLAB = registerblock("sculk_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SCULK_STONE_BUTTON = registerblock("sculk_stone_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.STONE),
                    BlockSetType.STONE, 30, true));
    public static final RegistryObject<Block> SCULK_STONE_PRESSURE_PLATE = registerblock("sculk_stone_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE),
                    BlockSetType.STONE));
    public static final RegistryObject<Block> SCULK_STONE_WALL = registerblock("sculk_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).sound(SoundType.STONE)));


    public static final RegistryObject<Block> COBBLED_SCULK_STONE = registerblock("cobbled_sculk_stone",
            () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<Block> COBBLED_SCULK_STONE_STAIRS = registerblock("cobbled_sculk_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.SCULK_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COBBLED_SCULK_STONE_SLAB = registerblock("cobbled_sculk_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COBBLED_SCULK_STONE_WALL = registerblock("cobbled_sculk_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).sound(SoundType.STONE)));

    public static final RegistryObject<Block> POLISHED_SCULK_STONE = registerblock("polished_sculk_stone",
            () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<Block> POLISHED_SCULK_STONE_STAIRS = registerblock("polished_sculk_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.SCULK_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> POLISHED_SCULK_STONE_SLAB = registerblock("polished_sculk_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> POLISHED_SCULK_STONE_WALL = registerblock("polished_sculk_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).sound(SoundType.STONE)));

    public static final RegistryObject<Block> SCULK_STONE_BRICKS = registerblock("sculk_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<Block> SCULK_STONE_BRICK_STAIRS = registerblock("sculk_stone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.SCULK_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SCULK_STONE_BRICK_SLAB = registerblock("sculk_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SCULK_STONE_BRICK_WALL = registerblock("sculk_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).sound(SoundType.STONE)));


    public static final RegistryObject<Block> SMOOTH_SCULK_STONE = registerblock("smooth_sculk_stone",
            () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<Block> SMOOTH_SCULK_STONE_STAIRS = registerblock("smooth_sculk_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.SCULK_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SMOOTH_SCULK_STONE_SLAB = registerblock("smooth_sculk_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));


    public static final RegistryObject<Block> CHISELED_SCULK_STONE = registerblock("chiseled_sculk_stone",
            () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get())));






    //display cabinets//

    public static final RegistryObject<Block> DISPLAY_CASE = registerblock("display_case",
            () -> new DisplayCaseBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.GLASS)));



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
