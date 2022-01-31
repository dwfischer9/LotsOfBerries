package io.github.dwfischer9.LotsOfBerries.core.world;

import java.util.List;
import java.util.function.Supplier;

import io.github.dwfischer9.LotsOfBerries.core.init.PlacedFeatureInit;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class BushGeneration {
	public static void generateBushes(final BiomeLoadingEvent event) {
		@SuppressWarnings("unused")
		ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
		ResourceLocation biome = event.getName();
		List<Supplier<PlacedFeature>> base = event.getGeneration()
				.getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
		if (biome.toString().contains("plains"))
			base.add(() -> PlacedFeatureInit.CUSTOM_BUSH_PLACED);

		else if (biome.toString().contains("soul"))
			base.add(() -> PlacedFeatureInit.SOULBERRY_BUSH_PLACED);

	}

}