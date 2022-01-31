package io.github.dwfischer9.LotsOfBerries.core.init;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class PlacedFeatureInit {

	public static final PlacedFeature CUSTOM_BUSH_PLACED = PlacementUtils.register("custom_bush_placed",
			ConfigFeatureInit.BERRY_BUSH_CONFIG.placed());
}
