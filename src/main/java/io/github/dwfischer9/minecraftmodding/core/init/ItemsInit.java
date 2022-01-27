package io.github.dwfischer9.minecraftmodding.core.init;

import assets.tutorialmod.core.init.BlockInit;
import io.github.dwfischer9.minecraftmodding.TutorialMod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ItemsInit {

	private ItemsInit() {} //constructor

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MODID);
//----------------------------------Items------------------------------------\\
	public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
//----------------------------------Blocks----------------------------------\\
	public static final RegistryObject<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block",() -> new BlockItem(BlockInit.EXAMPLE_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

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


