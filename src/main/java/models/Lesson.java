package models;

public class Lesson {
	private String name;
	private int dexterityIncrease;
	private int strengthIncrease;
	private int creativityIncrease;
	private int luckIncrease;
	private int experienceCost;
	
	// pr�vision de la liste d'ingr�dients requis pour d�bloquer l'achat du cours
	// private ArrayList<Ingredient> lessonBuyCost;
	
	
	// g�n�teur de lesson va chercher les donn�es d'une le�on en base
	public Lesson (String nomLesson, int dI, int sI, int cI, int lI, int eC)
	{
		
		this.name = nomLesson;
		this.creativityIncrease = cI;
		this.strengthIncrease = sI;
		this.dexterityIncrease = dI;
		this.luckIncrease= lI;
		this.experienceCost =eC;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getExperienceCost ()
	{
		return this.experienceCost;
	}

	public int getDexterityIncrease() {
		return dexterityIncrease;
	}

	public int getStrengthIncrease() {
		return strengthIncrease;
	}

	public int getCreativityIncrease() {
		return creativityIncrease;
	}

	public int getLuckIncrease() {
		return luckIncrease;
	}
	
	
}
