package io.github.dwfischer9.LotsOfBerries.core.init;

import java.util.Arrays;

import io.github.dwfischer9.LotsOfBerries.common.block.CustomBush;
import io.github.dwfischer9.LotsOfBerries.common.block.SoulBerryBush;
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
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class ConfigFeatureInit {

	public static final ConfiguredFeature<RandomPatchConfiguration, ?> BERRY_BUSH_CONFIG = FeatureUtils
			.register("berry_bush_config", Feature.FLOWER.configured(new RandomPatchConfiguration(1, 20, 20, () -> {
				return Feature.SIMPLE_BLOCK
						.configured(new SimpleBlockConfiguration(BlockStateProvider
								.simple(BlockInit.CUSTOM_BUSH.get().defaultBlockState().setValue(CustomBush.AGE, 3))))
						.placed(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
								RarityFilter.onAverageOnceEvery(7), BlockPredicateFilter.forPredicate(BlockPredicate
										.wouldSurvive(Blocks.DANDELION.defaultBlockState(), BlockPos.ZERO)));
			})));
	public static final ConfiguredFeature<RandomPatchConfiguration, ?> SOULBERRY_BUSH_CONFIG = FeatureUtils
			.register("soulberry_bush_config", Feature.FLOWER.configured(new RandomPatchConfiguration(1, 20, 20, () -> {
				return Feature.SIMPLE_BLOCK
						.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(
								BlockInit.SOULBERRY_BUSH.get().defaultBlockState().setValue(SoulBerryBush.AGE, 3))))
						.placed(InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
								RarityFilter.onAverageOnceEvery(1),
								BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(
										Arrays.asList(Blocks.SOUL_SAND, Blocks.SOUL_SOIL, Blocks.NETHERRACK))));
			})));

}
