package com.dreammaster.witcheryhandler;

import java.awt.Color;

import alkalus.main.api.RecipeManager;
import alkalus.main.api.plugin.base.BasePluginWitchery;
import gregtech.api.enums.ItemList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class GTNH_Witchery_Plugin extends BasePluginWitchery {

	public GTNH_Witchery_Plugin() {
		super(new LoadPhase[] {LoadPhase.INIT, LoadPhase.POSTINIT});
	}

	@Override
	public String getPluginName() {
		return "GTNH Witchery Plugin";
	}

	@Override
	public boolean preInit() {
		// Hier machen wir nichts.
		return false;
	}
	
	@Override
	public boolean init() {
		// in der init Phase fügen wir die Rezepte hinzu.
		
		/*
		 * 	RecipeManager.Art_des_Rezeptes (z.B. Kettle).addRecipe
		 */
		
		RecipeManager.Kettle.addRecipe(
				ItemList.Bottle_Rum.get(1L),
				1, //Bonus mit Witch Hat 
				0, //Familiar ID
				1.0f, //Benötigte Power vom Altar
				Color.BLACK.getRGB(), //farbe
				0, //Dimension ID
				true,//Wird dies im Kettle Rezept buch angezeigt?
				new ItemStack[] {
						new ItemStack(Items.sugar), new ItemStack(Items.dye)
				}
				);
		
		return true;
	}

	@Override
	public boolean postInit() {
		//Hier entfernen wir die Rezepte:
		
		RecipeManager.Kettle.removeRecipe(ItemList.Bottle_Rum.get(1L));
		
		
		/*
		 * 	RecipeManager.Art_des_Rezeptes (z.B. Kettle).removeRecipe
		 * 
		 * 	Mit RecipeManager.Art_des_Rezeptes (z.B. Kettle).findRecipeUsingIngredient(ItemStack) 
		 *  lassen sich rezepte finden die den Inhaltsstoff ItemStack haben.
		 */
		
		return true;
	}



}
