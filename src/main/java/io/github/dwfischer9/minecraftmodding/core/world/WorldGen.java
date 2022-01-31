package io.github.dwfischer9.minecraftmodding.core.world;

import io.github.dwfischer9.minecraftmodding.TutorialMod;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TutorialMod.MODID)
public class WorldGen {
	@SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        BushGeneration.generateBushes(event);
        }
}
