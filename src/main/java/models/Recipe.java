package models;

import java.util.ArrayList;
import java.util.Random;


public class Recipe {
	//definition de la classe recette
	private String name;
	private ArrayList<Ingredient> requiredIngredient;
	private int experienceGain;
	private ArrayList<Ingredient> lootedIngredients;
	private int strengthRequired;
	private int dexterityRequired;
	private int creativityRequired;
	
	//constructeur de recette
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

	/*
	// m�thode qui calcule la r�alisation de la recette, et le gain obtenu
	public boolean doRecipe (int cookLuck)
	{
		boolean success = false;
		int tryRecipe = getChanceOfSuccess(cookLuck);
		// on test si un tirage al�atoire est inferieur au chances de succ�s
		if (tryRecipe > (int)Math.random()*100)
		{
			success = true;
		}

		
		return success;
	}
	
	// fonction qui retourne la chance de succ�s d'une recette
	public int getChanceOfSuccess (int cookLuck)
	{
		
		// par d�faut on prend une valeur de 50 de base qui pourra �tre diff�rente ult�rieurement selon les caracteristiques du cook
		int chanceOfSuccess = 50+ cookLuck;
		return chanceOfSuccess ;
	}
	*/
	
}
