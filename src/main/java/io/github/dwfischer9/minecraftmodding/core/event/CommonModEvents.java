package io.github.dwfischer9.minecraftmodding.core.event;

import io.github.dwfischer9.minecraftmodding.TutorialMod;
import io.github.dwfischer9.minecraftmodding.common.entity.Bleepo;
import io.github.dwfischer9.minecraftmodding.core.init.EntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;;
@Mod.EventBusSubscriber(modid = TutorialMod.MODID, bus = Bus.MOD)
public class CommonModEvents {

	
	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(EntityInit.BLEEPO.get(), Bleepo.createAttributes().build());
	}
}
