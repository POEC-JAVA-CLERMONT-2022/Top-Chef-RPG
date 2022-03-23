package models;

import java.util.ArrayList;

import dataConnection.DataAdaptor;

public class Cook {
	//d�claration des variables de cook
	private String name;
	private Character gender;
	private int experience;
	private int dexterity;
	private int strength;
	private int creativity;
	private int luck;
	private ArrayList<Lesson> lessons;
	private ArrayList<Ingredient> ingredients;
	//private ArrayList<Tool> tools;

	
	
	// methode de cr�ation du joueur avec ses variables � 0
	public Cook (String name)
	{
		this.name = name;
		this.setExperience(0);
		this.setCreativity(0);
		this.setDexterity(0);
		this.setStrength(0);
		this.setLuck(0);
		
		//rajouter appel vers m�thodde instanciation listes. 
	}
	
	public void SaveCook ()
	{
		DataAdaptor DA = new DataAdaptor();
		DA.SaveCook(this);
	}
	// classe de chargement d'un cook
	public Cook loadCook(String name)
	{
		DataAdaptor DA = new DataAdaptor();
		return DA.loadCook(name);
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getCreativity() {
		return creativity;
	}

	public void setCreativity(int creativity) {
		this.creativity = creativity;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}

	public ArrayList<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(ArrayList<Lesson> lessons) {
		this.lessons = lessons;
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String getName() {
		return name;
	}
	
}
