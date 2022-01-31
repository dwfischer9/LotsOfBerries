package io.github.dwfischer9.LotsOfBerries.core.init;

import io.github.dwfischer9.LotsOfBerries.Main;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ItemsInit {

	private ItemsInit() {
	} // constructor

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);
//----------------------------------Items------------------------------------\\
	// ----------------------------------Food----------------------------------------\\
	public static final RegistryObject<Item> CUSTOM_BERRIES = ITEMS.register("custom_berries",
			() -> new ItemNameBlockItem(BlockInit.CUSTOM_BUSH.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
							.food(new FoodProperties.Builder().nutrition(3).saturationMod(0.2f)
									.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 360, 4), 1).build())));

	public static final RegistryObject<Item> SOULBERRIES = ITEMS.register("soulberries",
			() -> new ItemNameBlockItem(BlockInit.SOULBERRY_BUSH.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
							.food(new FoodProperties.Builder().nutrition(3).saturationMod(0.2f)
									.effect(() -> new MobEffectInstance(MobEffects.WITHER, 40, 4), 1).build())));
	// ----------------------------------Spawn
	// Eggs------------------------------------\\

//----------------------------------Blocks----------------------------------\\

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
