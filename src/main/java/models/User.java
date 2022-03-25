package models;

import dataConnection.DataAdaptor;

public class User {
	private String name;
	private String mail;
	private String password;
	private Cook cook;
	// en pr�vision de l'ajout de la possibilit� pour un user d'avoir plusieurs cook
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
		// tant que le user n'a qu'un seul cuisinier � chaque appel de la fonction qui r��crase l'existant si il existe d�j�.
		Cook cook = new Cook(name);
		this.cook = cook;		
	}
	//sauvegarde du cuisinnier
	public void saveCook()
	{
		//this.cook.SaveCook();
	}
	// chargement du cuisinier
	/*public void loadCook(String name)
	{
		this.cook = this.cook.loadCook(name);
	}*/
	
	// fonction de sauvegarde du User en BDD
	public void saveUser()
	{
		//DataAdaptor DA = new DataAdaptor();
		//DA.saveUser(this);
	}
	
	
}
