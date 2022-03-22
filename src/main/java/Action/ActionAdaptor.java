package Action;

import models.User;

public class ActionAdaptor {
	private InterfaceActionHandler interfaceProvider;

	public ActionAdaptor()
	{

		// variable que l'on pourrait r�cup�rer dans un fichier de config
		String env = "dev";
		// selon l'environnement l'interface provider va chercher et instancier soit la classe qui g�re l'affichage en console ou web
		// l'objet interfaceprovider fera appel aux m�me fonctions chez les deux classes 
		if (env.equals("dev"))
		{
			interfaceProvider = new ConsoleServices();
		}
		else
		{
			//interfaceProvider = new DataInBDD();
		}	
	}
	
	public void signIn(String nameUser, String mail, String password)
	{
		// dans cette m�thode on va devoir cr�er un user dans la classe service
	}
	
	
	public void logIn(String nameUser, String password)
	{
		
	}
	
	// fonction qui doit afficher le menu d'acceuil. En retour de la fonction on renvoit un user virtuel qui contient les infos donn�es par l'utilisateur.
	// il faudra donc utiliser ces informations pour v�rifier dans serviceGame si le User est dans la BDD ou si c'est une cr�ation.
	public User showWelcomeMenu()
	{
		interfaceProvider.showWelcomeMenu();
		
		
		User virtualUser = new User(null, null, null);
		return virtualUser;
	}

}
