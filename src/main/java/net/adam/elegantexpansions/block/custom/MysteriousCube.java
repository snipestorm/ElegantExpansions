package net.adam.elegantexpansions.block.custom;

import net.adam.elegantexpansions.entity.ModEntityTypes;
import net.adam.elegantexpansions.entity.custom.GolemEntity;
import net.adam.elegantexpansions.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class MysteriousCube extends Block {

    public static final IntegerProperty GOLEM_HATCH = IntegerProperty.create("golem_hatch",0,3);
    public static final int MAX_GOLEM_HATCH_LEVEL = 3;
    private static final int RANDOM_HATCH_OFFSET_TICKS = 300;
    private static final int HATCH__TICKS = 24000;

    public MysteriousCube(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(GOLEM_HATCH, Integer.valueOf(0)));
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_277441_) {
        p_277441_.add(GOLEM_HATCH);
    }

    public int getHatchLevel(BlockState p_279125_) {
        return p_279125_.getValue(GOLEM_HATCH);
    }

    public BlockState setHatchLevel(BlockState state) {
        return state.setValue(GOLEM_HATCH, Integer.valueOf(this.getHatchLevel(state) +1));
    }

    private boolean isReadyToHatch(BlockState p_278021_) {
        return this.getHatchLevel(p_278021_) == 3;
    }

    private boolean hasHadAmethyst(BlockState state) {
        return this.getHatchLevel(state) >= 1;
    }

    public void tick(BlockState state, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (!this.isReadyToHatch(state)) {
            serverLevel.playSound((Player) null, blockPos, ModSounds.GOLEM_BLOCK_CRACK.get(), SoundSource.BLOCKS, 0.7F, 0.9F + randomSource.nextFloat() * 0.2F);
            serverLevel.setBlock(blockPos, state.setValue(GOLEM_HATCH, Integer.valueOf(this.getHatchLevel(state) + 1)), 3);
        } else {
            serverLevel.playSound((Player) null, blockPos, ModSounds.GOLEM_BLOCK_CRACK.get(), SoundSource.BLOCKS, 0.7F, 0.9F + randomSource.nextFloat() * 0.2F);
            serverLevel.destroyBlock(blockPos, false);
            GolemEntity golem = ModEntityTypes.GOLEM.get().create(serverLevel);
            if (golem != null) {
                Vec3 vec3 = blockPos.getCenter();
                golem.moveTo(vec3.x(), vec3.y(), vec3.z(), Mth.wrapDegrees(serverLevel.random.nextFloat() * 360.0F), 0.0F);
                golem.makeInvulnerable();
                serverLevel.addFreshEntity(golem);

            }
        }
    }
    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState1, boolean b) {
       if (!level.isClientSide()) {
           level.levelEvent(3009, blockPos, 0);
       }


        if (hasHadAmethyst(blockState)) {
        int i = 18000;
        int j = i / 3;
        level.gameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Context.of(blockState));
        level.scheduleTick(blockPos, this, j - level.random.nextInt(300));

        }
    }
}
