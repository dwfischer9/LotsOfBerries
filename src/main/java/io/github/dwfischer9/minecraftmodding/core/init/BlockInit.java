package io.github.dwfischer9.minecraftmodding.core.init;

import io.github.dwfischer9.minecraftmodding.TutorialMod;
import io.github.dwfischer9.minecraftmodding.common.block.CustomBush;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class BlockInit {

	private BlockInit() {
	}

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			TutorialMod.MODID);
	public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
					.strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.WOOD)));

	public static final RegistryObject<Block> STEEL_BEAM = BLOCKS.register("steel_beam",
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(5F, 6.0F)
					.requiresCorrectToolForDrops().sound(SoundType.STONE))); // .strength is (time to break, explosion)

	public static final RegistryObject<BushBlock> CUSTOM_BUSH = BLOCKS.register("custom_bush",
			() -> new CustomBush(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).randomTicks()
					.noCollission().sound(SoundType.SWEET_BERRY_BUSH)));
}
