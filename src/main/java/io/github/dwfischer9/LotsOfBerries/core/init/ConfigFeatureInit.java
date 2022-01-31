package io.github.dwfischer9.LotsOfBerries.core.init;

import io.github.dwfischer9.LotsOfBerries.common.block.CustomBush;
import net.minecraft.core.BlockPos;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;

public class ConfigFeatureInit {

	public static final ConfiguredFeature<RandomPatchConfiguration, ?> BERRY_BUSH_CONFIG = FeatureUtils
			.register("berry_bush_config", Feature.FLOWER.configured(new RandomPatchConfiguration(1, 20, 20, () -> {
				return Feature.SIMPLE_BLOCK
						.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(
								BlockInit.CUSTOM_BUSH.get().defaultBlockState().setValue(CustomBush.AGE, 3))))
						.placed(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
								BlockPredicateFilter.forPredicate(BlockPredicate
										.wouldSurvive(Blocks.DANDELION.defaultBlockState(), BlockPos.ZERO)));
			})));

}
