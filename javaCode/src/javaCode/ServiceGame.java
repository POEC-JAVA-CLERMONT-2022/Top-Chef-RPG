package javaCode;

import java.util.ArrayList;

import javaCode.Action.ActionAdaptor;
import javaCode.dataConnection.DataAdaptor;

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
	
	// fonction de base qui gère la boucle de jeu
	public void run()
	{
		boolean exit = false;
		AA.showWelcomeMenu();
		while (exit==false)
		{
			
		}
	}

}
