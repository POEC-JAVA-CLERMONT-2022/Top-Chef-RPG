package services;

import java.util.ArrayList;
import models.User;

import Action.ActionAdaptor;
import dataConnection.DataAdaptor;

public class ServiceGame {
	DataAdaptor DA ;
	ActionAdaptor AA ;
	ArrayList<User> listUser;
	
	
	public ServiceGame()
	{
		DA = new DataAdaptor();
		AA = new ActionAdaptor();
		listUser = new ArrayList<User>();
		
	}
	
	// fonction de base qui g�re la boucle de jeu : tout doit s'executer � partir de cette instance de cette classe et g�rer les 
	public void run()
	{
		boolean exit = false;
		
		// appel de la fonction pour afficher l'�cran d'acceuil
		AA.showWelcomeMenu();
		while (exit==false)
		{
			
		}
	}

}
