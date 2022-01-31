package io.github.dwfischer9.LotsOfBerries.core.world;

import io.github.dwfischer9.LotsOfBerries.Main;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class WorldGen {
	@SubscribeEvent
	public static void onBiomeLoad(BiomeLoadingEvent event) {
		BushGeneration.generateBushes(event);
	}
}
