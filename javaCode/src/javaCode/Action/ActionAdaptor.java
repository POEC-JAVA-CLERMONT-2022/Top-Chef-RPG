package javaCode.Action;



public class ActionAdaptor {
	private InterfaceActionHandler interfaceProvider;

	public ActionAdaptor()
	{

		// variable que l'on pourrait récupérer dans un fichier de config
		String env = "dev";
		// selon l'environnement l'interface provider va chercher et instancier soit la classe qui gère l'affichage en console ou web
		// l'objet interfaceprovider fera appel aux même fonctions chez les deux classes 
		if (env.equals("dev"))
		{
			interfaceProvider = new ConsoleServices();
		}
		else
		{
			//interfaceProvider = new DataInBDD();
		}	
	}
	
	

}
