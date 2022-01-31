package io.github.dwfischer9.LotsOfBerries.core.init;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class PropertyInit {

	private PropertyInit() {
	}

	public final static BlockBehaviour.Properties CUSTOM_BUSH_PROPERTY = BlockBehaviour.Properties
			.of(Material.PLANT, MaterialColor.COLOR_GREEN).randomTicks().noCollission().instabreak()
			.sound(SoundType.SWEET_BERRY_BUSH);
	public final static BlockBehaviour.Properties SOULBERRY_BUSH_PROPERTY = BlockBehaviour.Properties
			.of(Material.REPLACEABLE_FIREPROOF_PLANT, MaterialColor.NETHER).randomTicks().noCollission().instabreak()
			.sound(SoundType.SOUL_SAND);

}
