package javaCode.Action;



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
	
	

}
