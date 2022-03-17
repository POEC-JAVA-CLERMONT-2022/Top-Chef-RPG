package javaCode;

public class User {
	private String name;
	private String mail;
	private String password;
	private Cook cook;
	// en prévision de l'ajout de la possibilité pour un user d'avoir plusieurs cook
	// private ArrayList<Cook> listCook;
	
	public User (String name, String mail, String password)
	{
		this.name = name;
		this.mail = mail;
		this.password = password;
	}
	
	// creation d'un cook pour le user
	public void createCook (String name)
	{
		// tant que le user n'a qu'un seul cuisinier à chaque appel de la fonction qui réécrase l'existant si il existe déjà.
		Cook cook = new Cook(name);
		this.cook = cook;		
	}
	//sauvegarde du cuisinnier
	public void saveCook()
	{
		this.cook.SaveCook();
	}
	// chargement du cuisinnier
	public void loadCook(String name)
	{
		this.cook = this.cook.loadCook(name);
	}
	
}
