package io.github.dwfischer9.minecraftmodding.core.init;

import io.github.dwfischer9.minecraftmodding.TutorialMod;
import io.github.dwfischer9.minecraftmodding.common.entity.Bleepo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
	private EntityInit() {
	}

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			TutorialMod.MODID);

	public static final RegistryObject<EntityType<Bleepo>> BLEEPO = ENTITIES.register("bleepo",
			() -> EntityType.Builder.of(Bleepo::new, MobCategory.CREATURE).sized(0.8f, 0.6f)
					.build(new ResourceLocation(TutorialMod.MODID, "bleepo").toString()));
}
