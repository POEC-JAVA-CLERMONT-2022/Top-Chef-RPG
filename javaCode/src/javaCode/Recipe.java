package javaCode;

import java.util.ArrayList;
import java.util.Random;

public class Recipe {
	private String name;
	private ArrayList<Ingredient> requiredIngredient;
	private int experienceGain;
	private ArrayList<Ingredient> lootedIngredients;
	private int strengthRequired;
	private int dexterityRequired;
	private int creativityRequired;
	
	
	public Recipe(String recipeName,int eG, int sR, int dR, int cR, ArrayList<Ingredient> rI, ArrayList<Ingredient> lI)
	{
		this.name = recipeName;
		this.creativityRequired =cR;
		this.dexterityRequired =dR;
		this.strengthRequired = sR;
		this.experienceGain =eG;
		this.lootedIngredients = lI;
		this.requiredIngredient =rI;
		
	}


	public String getName() {
		return name;
	}


	public int getExperienceGain() {
		return experienceGain;
	}


	public ArrayList<Ingredient> getRequiredIngredient() {
		return requiredIngredient;
	}


	public int getStrengthRequired() {
		return strengthRequired;
	}


	public int getDexterityRequired() {
		return dexterityRequired;
	}


	public int getCreativityRequired() {
		return creativityRequired;
	}


	public ArrayList<Ingredient> getLootedIngredients() {
		return lootedIngredients;
	}
	
	// méthode qui calcule la réalisation de la recette, et le gain obtenu
	public boolean doRecipe (int cookLuck)
	{
		boolean success = false;
		int tryRecipe = getChanceOfSuccess(cookLuck);
		// on test si un tirage aléatoire est inferieur au chances de succès
		if (tryRecipe > (int)Math.random()*100)
		{
			success = true;
		}

		
		return success;
	}
	
	// fonction qui retourne la chance de succès d'une recette
	public int getChanceOfSuccess (int cookLuck)
	{
		
		// par défaut on prend une valeur de 50 de base qui pourra être différente ultérieurement selon les caracteristiques du cook
		int chanceOfSuccess = 50+ cookLuck;
		return chanceOfSuccess ;
	}
	
	
}
