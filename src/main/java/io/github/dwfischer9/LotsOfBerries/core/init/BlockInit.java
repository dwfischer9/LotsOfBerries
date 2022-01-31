package io.github.dwfischer9.LotsOfBerries.core.init;

import java.util.ArrayList;
import java.util.Arrays;

import io.github.dwfischer9.LotsOfBerries.Main;
import io.github.dwfischer9.LotsOfBerries.common.block.CustomBush;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class BlockInit {

	private BlockInit() {
	}

	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Main.MODID);

	public static final RegistryObject<BushBlock> CUSTOM_BUSH = BLOCKS.register("custom_bush",
			() -> new CustomBush(PropertyInit.CUSTOM_BUSH_PROPERTY));


	public static ArrayList<RegistryObject<BushBlock>> bushList = new ArrayList<>(Arrays.asList(CUSTOM_BUSH));
}
