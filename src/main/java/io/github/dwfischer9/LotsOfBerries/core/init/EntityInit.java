package io.github.dwfischer9.LotsOfBerries.core.init;

import io.github.dwfischer9.LotsOfBerries.Main;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {
	private EntityInit() {
	}

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			Main.MODID);

}
