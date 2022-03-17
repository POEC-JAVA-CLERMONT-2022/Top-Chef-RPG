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
		// code à remplacer par le service de connexion aux données
		String recipeName = "eplucher pommes";
		int eG = 30;
		int sR = 0;
		int dR = 0;
		int cR = 0;
		// pour la première recette la liste est vide, mais pour les suivantes il faudrat ajouter les ingredients à la liste.
		ArrayList<Ingredient> rI = new ArrayList<Ingredient>();
		
		// liste des ingredients lootables.
		ArrayList<Ingredient> lI = new ArrayList<Ingredient>();
		// il faudra aller chercher le nom de l'ingredient dans la table de données
		Ingredient loot1 = new Ingredient("pomme");
		// il faut aller chercher en BDD la quantité de l'ingrédient à gagner en effectuant la recette
		loot1.setQuantity(10);
		// ajout de l'ingredient lootable à la liste 
		lI.add(loot1);
		
		// fin de l'exemple de code service connexion aux données
		
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
		boolean succes = false;
		float rd = Random
		
	}
}
