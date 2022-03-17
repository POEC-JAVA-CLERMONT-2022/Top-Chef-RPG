package javaCode;

public class Lesson {
	private String name;
	private int dexterityIncrease;
	private int strengthIncrease;
	private int creativityIncrease;
	private int luckIncrease;
	private int experienceCost;
	
	// prévision de la liste d'ingrédients requis pour débloquer l'achat du cours
	// private ArrayList<Ingredient> lessonBuyCost;
	
	
	// généteur de lesson va chercher les données d'une leçon en base
	public Lesson ()
	{
		// exemple de code en dur à placer dans la classe qui va chercher les données
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
