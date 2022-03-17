package javaCode;

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
	public Lesson ()
	{
		// exemple de code en dur � placer dans la classe qui va chercher les donn�es
		String nomLesson = "tarte au pommes";
		int dI = 10;
		int sI = 10;
		int cI = 5;
		int lI = 20;
		int eC = 300;
		
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
