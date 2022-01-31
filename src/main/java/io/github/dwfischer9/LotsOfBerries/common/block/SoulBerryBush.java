package io.github.dwfischer9.LotsOfBerries.common.block;

import io.github.dwfischer9.LotsOfBerries.core.init.ItemsInit;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class SoulBerryBush extends CustomBush {

	public SoulBerryBush(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos position, Player player, InteractionHand hand,
			BlockHitResult hitResult) {
		int i = state.getValue(AGE); // i = age
		boolean flag = i == 3;
		if (!flag && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
			return InteractionResult.PASS;
		} else if (i > 1) {
			int j = 1 + level.random.nextInt(2);
			popResource(level, position, new ItemStack(ItemsInit.SOULBERRIES.get(), j + (flag ? 1 : 0)));// TODO
			level.playSound((Player) null, position, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS,
					1.0F, 0.8F + level.random.nextFloat() * 0.4F);
			level.setBlock(position, state.setValue(AGE, Integer.valueOf(1)), 2);
			return InteractionResult.sidedSuccess(level.isClientSide);
		} else {
			return super.use(state, level, position, player, hand, hitResult);
		}
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		BlockPos blockpos = pPos.below();
		return this.mayPlaceOn(pLevel.getBlockState(blockpos), pLevel, blockpos);
	}

	@Override
	protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return pState.is(Blocks.SOUL_SAND) || pState.is(Blocks.SOUL_SOIL);
	}
}
