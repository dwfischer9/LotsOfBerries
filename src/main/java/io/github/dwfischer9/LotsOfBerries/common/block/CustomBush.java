package io.github.dwfischer9.LotsOfBerries.common.block;

import java.util.Random;

import io.github.dwfischer9.LotsOfBerries.core.init.ItemsInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CustomBush extends BushBlock {

	public static final int MAX_AGE = 3;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
	private static final VoxelShape SAPLING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
	private static final VoxelShape MID_GROWTH_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

	public CustomBush(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos position, CollisionContext context) {
		if (state.getValue(AGE) == 0) {
			return SAPLING_SHAPE;
		} else {
			return state.getValue(AGE) < 3 ? MID_GROWTH_SHAPE : super.getShape(state, getter, position, context);
		}
	}

	public boolean isRandomlyTicking(BlockState state) {
		return state.getValue(AGE) < 3;
	}

	public void randomTick(BlockState state, ServerLevel level, BlockPos position, Random random) {
		int i = state.getValue(AGE);
		if (i < 3 && level.getRawBrightness(position.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks
				.onCropsGrowPre(level, position, state, random.nextInt(5) == 0)) {
			level.setBlock(position, state.setValue(AGE, Integer.valueOf(i + 1)), 2);
			net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, position, state);
		}

	}

	public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel,
			BlockPos pCurrentPos, BlockPos pFacingPos) {
		return !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState()
				: super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
	}

	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		BlockPos blockpos = pPos.below();
		if (pState.getBlock() == this)
			return pLevel.getBlockState(blockpos).canSustainPlant(pLevel, blockpos, Direction.UP, this);
		return this.mayPlaceOn(pLevel.getBlockState(blockpos), pLevel, blockpos);
	}

	protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return pState.is(BlockTags.DIRT) || pState.is(Blocks.FARMLAND);
	}

	@SuppressWarnings("deprecation")
	public InteractionResult use(BlockState state, Level level, BlockPos position, Player player, InteractionHand hand,
			BlockHitResult hitResult) {
		int i = state.getValue(AGE); // i = age
		boolean flag = i == 3;
		if (!flag && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
			return InteractionResult.PASS;
		} else if (i > 1) {
			int j = 1 + level.random.nextInt(2);
			popResource(level, position, new ItemStack(ItemsInit.CUSTOM_BERRIES.get(), j + (flag ? 1 : 0)));// TODO
			level.playSound((Player) null, position, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS,
					1.0F, 0.8F + level.random.nextFloat() * 0.4F);
			level.setBlock(position, state.setValue(AGE, Integer.valueOf(1)), 2);
			return InteractionResult.sidedSuccess(level.isClientSide);
		} else {
			return super.use(state, level, position, player, hand, hitResult);
		}
	}

	public void entityInside(BlockState state, Level level, BlockPos position, Entity entity) {
		if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX
				&& entity.getType() != EntityType.BEE) {
			entity.makeStuckInBlock(state, new Vec3((double) 0.8F, 0.75D, (double) 0.8F));
//			if (!level.isClientSide && state.getValue(AGE) > 0
//					&& (entity.xOld != entity.getX() || entity.zOld != entity.getZ())) {
//				double d0 = Math.abs(entity.getX() - entity.xOld);
//				double d1 = Math.abs(entity.getZ() - entity.zOld);
//				if (d0 >= (double) 0.003F || d1 >= (double) 0.003F) {
//					entity.hurt(DamageSource.SWEET_BERRY_BUSH, 1.0F);
//				}
//			}

		}
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> item) {
		item.add(AGE);
	}

	public boolean isValidBonemealTarget(BlockGetter getter, BlockPos position, BlockState state, boolean bool) {
		return state.getValue(AGE) < 3;
	}

	public boolean isBonemealSuccess(Level level, Random random, BlockPos position, BlockState state) {
		return true;
	}

	public void performBonemeal(ServerLevel level, Random random, BlockPos position, BlockState state) {
		int i = Math.min(3, state.getValue(AGE) + 1);
		level.setBlock(position, state.setValue(AGE, Integer.valueOf(i)), 2);
	}

}
