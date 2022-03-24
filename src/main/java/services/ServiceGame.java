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
	
	// fonction de base qui gère le jeu : elle doit implémenter un event handler qui reçoit les demande en provenance de l'affichage
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
