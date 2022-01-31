package io.github.dwfischer9.LotsOfBerries;

import io.github.dwfischer9.LotsOfBerries.core.init.BlockInit;
import io.github.dwfischer9.LotsOfBerries.core.init.EntityInit;
import io.github.dwfischer9.LotsOfBerries.core.init.ItemsInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.MODID )
public class Main {
	public static final String MODID = "lotsofberries";
	public Main() { //constructor
		
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		BlockInit.BLOCKS.register(bus);
		ItemsInit.ITEMS.register(bus);
		EntityInit.ENTITIES.register(bus);
	}
	
}
