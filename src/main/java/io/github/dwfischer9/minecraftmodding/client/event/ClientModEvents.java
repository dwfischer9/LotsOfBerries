package io.github.dwfischer9.minecraftmodding.client.event;

import io.github.dwfischer9.minecraftmodding.TutorialMod;
import io.github.dwfischer9.minecraftmodding.client.renderer.BleepoRenderer;
import io.github.dwfischer9.minecraftmodding.client.renderer.model.BleepoModel;
import io.github.dwfischer9.minecraftmodding.core.init.EntityInit;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = TutorialMod.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
	private ClientModEvents() {
	}

	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(BleepoModel.LAYER_LOCATION, BleepoModel::createBodyLayer);
	}

	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EntityInit.BLEEPO.get(), BleepoRenderer::new);
	}
}
