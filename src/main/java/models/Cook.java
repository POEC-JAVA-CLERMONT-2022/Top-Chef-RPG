package models;

import java.util.ArrayList;
import dataConnection.DataAdaptor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public class Cook {
	//d�claration des variables de cook
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;

	@Column (name = "name", length = 100)
	private String name;

	@Column (name= "gender", length = 1)
	private Character gender;

	@Column (name="experience")
	private int experience;

	@Column (name="dexterity")
	private int dexterity;

	@Column (name="strength")
	private int strength;

	@Column (name="creativty")
	private int creativity;

	@Column (name="luck")
	private int luck;

	//@OneToMany( targetEntity=Lesson.class, mappedBy="cook" )
	//private ArrayList<Lesson> lessons ;

	@OneToMany( targetEntity=Ingredient.class, mappedBy= "cooks")
	private ArrayList<Ingredient> ingredients;
	//private ArrayList<Tool> tools;

	public Cook() {
		this.name = "";
		this.setExperience(0);
		this.setCreativity(0);
		this.setDexterity(0);
		this.setStrength(0);
		this.setLuck(0);
	}
	
	// methode de cr�ation du joueur avec ses variables � 0
	// les lessons et ingredients sont des listes vides initialement
	public Cook (String name)
	{
		this.name = name;
		this.setExperience(0);
		this.setCreativity(0);
		this.setDexterity(0);
		this.setStrength(0);
		this.setLuck(0);
		//this.lessons = new ArrayList<Lesson>();
		this.ingredients =new ArrayList<Ingredient>();
		
		//rajouter appel vers m�thodde instanciation listes.
		// il faudra créer en base les 20 items ingredients liés au cook
		// aucune lesson n'est dispo au départ => la liste peut rester vide
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

	/*
	public ArrayList<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(ArrayList<Lesson> lessons) {
		this.lessons = lessons;
	} */

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
