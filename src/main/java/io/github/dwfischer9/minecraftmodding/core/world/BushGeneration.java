package io.github.dwfischer9.minecraftmodding.core.world;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import io.github.dwfischer9.minecraftmodding.TutorialMod;
import io.github.dwfischer9.minecraftmodding.common.block.CustomBush;
import io.github.dwfischer9.minecraftmodding.core.init.BlockInit;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class BushGeneration {
	
	 public static final PlacedFeature PATCH_BERRY_COMMON = PlacementUtils.register("patch_berry_common", VegetationFeatures.PATCH_BERRY_BUSH.placed(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
	 public static final ConfiguredFeature<?, ?> PATCH_BERRY_BUSH = FeatureUtils.register("patch_berry_bush", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.SWEET_BERRY_BUSH.defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3))))), List.of(Blocks.GRASS_BLOCK))));
	 
	 public static final List<ConfiguredFeature<?, ?>> BUSHES = new ArrayList<>();
	 public static void registerBush() {
		ConfiguredFeature<?, ?> customBush = Registry.register(BuiltinRegistries.REGISTRY, "my_patch_berry_bush", customBush.feature());
		BUSHES.add(register("custom_bush", customBush));
	}

	private static <Config extends FeatureConfiguration> ConfiguredFeature<Config, ?> register(String name,
			ConfiguredFeature<Config, ?> configuredFeature) {
		return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(TutorialMod.MODID, name),
				configuredFeature);

	}

	@Mod.EventBusSubscriber(modid = TutorialMod.MODID, bus = Bus.FORGE)
public static class ForgeBusSubscriber{
	@SubscribeEvent
	public static void biomeLoading(BiomeLoadingEvent event) {
		List<Supplier<PlacedFeature>> features = event.getGeneration().getFeatures(Decoration.VEGETAL_DECORATION);
		switch(event.getCategory()) {
		
		default: BushGeneration.BUSHES.forEach(bush -> features.add(0, () -> bush));
		
		}
	}
	
}
}
