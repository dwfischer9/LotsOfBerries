package io.github.dwfischer9.minecraftmodding;

import io.github.dwfischer9.minecraftmodding.core.init.BlockInit;
import io.github.dwfischer9.minecraftmodding.core.init.EntityInit;
import io.github.dwfischer9.minecraftmodding.core.init.ItemsInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TutorialMod.MODID )
public class TutorialMod {
	public static final String MODID = "tutorialmod";
	public TutorialMod() { //constructor
		
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		BlockInit.BLOCKS.register(bus);
		ItemsInit.ITEMS.register(bus);
		EntityInit.ENTITIES.register(bus);
	}
	
}
