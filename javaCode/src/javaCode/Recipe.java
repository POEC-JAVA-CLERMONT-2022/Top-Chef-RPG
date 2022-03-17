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
	
	
	public Recipe()
	{
		// code � remplacer par le service de connexion aux donn�es
		String recipeName = "eplucher pommes";
		int eG = 30;
		int sR = 0;
		int dR = 0;
		int cR = 0;
		// pour la premi�re recette la liste est vide, mais pour les suivantes il faudrat ajouter les ingredients � la liste.
		ArrayList<Ingredient> rI = new ArrayList<Ingredient>();
		
		// liste des ingredients lootables.
		ArrayList<Ingredient> lI = new ArrayList<Ingredient>();
		// il faudra aller chercher le nom de l'ingredient dans la table de donn�es
		Ingredient loot1 = new Ingredient("pomme");
		// il faut aller chercher en BDD la quantit� de l'ingr�dient � gagner en effectuant la recette
		loot1.setQuantity(10);
		// ajout de l'ingredient lootable � la liste 
		lI.add(loot1);
		
		// fin de l'exemple de code service connexion aux donn�es
		
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
		
		// par d�faut on prend une valeur de 50 de base qui pourra �tre diff�rent ult�rieurement selon les recettes
		int chanceOfSuccess = 50+ cookLuck;
		return chanceOfSuccess ;
	}
}
