package io.github.dwfischer9.minecraftmodding.core.init;

import io.github.dwfischer9.minecraftmodding.TutorialMod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ItemsInit {

	private ItemsInit() {
	} // constructor

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			TutorialMod.MODID);
//----------------------------------Items------------------------------------\\
	public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	// ----------------------------------Food----------------------------------------\\
	public static final RegistryObject<Item> CUSTOM_BERRIES = ITEMS.register("custom_berries",
			() -> new ItemNameBlockItem(BlockInit.CUSTOM_BUSH.get(),new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
					.food(new FoodProperties.Builder().nutrition(3).saturationMod(0.2f).effect(()-> new MobEffectInstance(MobEffects.HEALTH_BOOST, 360,4), 1).build())));
	// ----------------------------------Spawn Eggs------------------------------------\\
	public static final RegistryObject<ForgeSpawnEggItem> BLEEPO_SPAWN_EGG = ITEMS.register("bleepo_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityInit.BLEEPO, 0X17D1C7, 0X4D1E65,
					new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

//----------------------------------Blocks----------------------------------\\
	public static final RegistryObject<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block",
			() -> new BlockItem(BlockInit.EXAMPLE_BLOCK.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

	public static final RegistryObject<BlockItem> STEEL_BEAM_ITEM = ITEMS.register("steel_beam",
			() -> new BlockItem(BlockInit.STEEL_BEAM.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS).stacksTo(64)));

//----------------------------------Tools------------------------------------\\

//	
//	public static final RegistryObject<SwordItem> ERZA_SWORD = ITEMS.register("erza_sword", ()-> new SwordItem(null, 40, 5f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
//	
//
//	public static final RegistryObject<PickaxeItem> EPIC_PICKAXE = ITEMS.register("epic_pickaxe", ()-> new PickaxeItem(null, 40, 5f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
//
//	public static final RegistryObject<ShovelItem> EPIC_SHOVEL = ITEMS.register("epic_shovel", ()-> new ShovelItem(null, 40, 5f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
//
//	public static final RegistryObject<AxeItem> EPIC_AXE = ITEMS.register("epic_axe", ()-> new AxeItem(null, 40, 5f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
//
//	public static final RegistryObject<HoeItem> EPIC_HOE = ITEMS.register("epic_hoe", ()-> new HoeItem(null, 40, 5f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
//
////----------------------------------Armor------------------------------------\\
//	public static final RegistryObject<ArmorItem> EPIC_HELMET = ITEMS.register("epic_helmet", ()->new ArmorItem(null,EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
//
//	public static final RegistryObject<ArmorItem> EPIC_CHESTPLATE = ITEMS.register("epic_chestplate", ()->new ArmorItem(null,EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
//	
//	public static final RegistryObject<ArmorItem> EPIC_LEGGINGS = ITEMS.register("epic_leggings", ()->new ArmorItem(null,EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
//
//	public static final RegistryObject<ArmorItem> EPIC_BOOTS = ITEMS.register("epic_boots", ()->new ArmorItem(null,EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
}
