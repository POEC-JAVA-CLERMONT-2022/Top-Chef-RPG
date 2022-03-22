package javaCode.Action;

import javaCode.dataConnection.DataInBDD;
import javaCode.dataConnection.DataInJava;

public class actionAdaptor {
	private InterfaceActionHandler interfaceProvider;

	public actionAdaptor()
	{

		// variable que l'on pourrait r�cup�rer dans un fichier de config
		String env = "dev";
		// selon l'environnement le dataprovider va chercher et instancier soit la classe qui charge les donn�es en java ou en BDD
		// l'objet dataProvider fera appel aux m�me fonctions chez les deux classes 
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
