package io.github.dwfischer9.minecraftmodding.client.renderer;

import io.github.dwfischer9.minecraftmodding.TutorialMod;
import io.github.dwfischer9.minecraftmodding.client.renderer.model.BleepoModel;
import io.github.dwfischer9.minecraftmodding.common.entity.Bleepo;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class BleepoRenderer<Type extends Bleepo> extends MobRenderer<Type, BleepoModel<Type>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(TutorialMod.MODID, "textures/entities/bleepo.png");
	public BleepoRenderer(Context context) {
		super(context, new BleepoModel<>(context.bakeLayer(BleepoModel.LAYER_LOCATION)), 0.5f);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResourceLocation getTextureLocation(Type entity) {
		return TEXTURE;
	}

}

