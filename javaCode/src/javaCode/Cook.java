package javaCode;

import java.util.ArrayList;

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
		this.experience= 0;
		this.creativity=0;
		this.dexterity=0;
		this.strength=0;
		this.luck=0;
		//rajouter appel vers m�thodde instanciation listes. 
	}
	
	public void SaveCook ()
	{
		
	}
	
}
