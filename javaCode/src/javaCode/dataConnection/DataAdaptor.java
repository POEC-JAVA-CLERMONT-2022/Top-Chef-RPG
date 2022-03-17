package javaCode.dataConnection;

import java.util.ArrayList;

import javaCode.Cook;
import javaCode.Recipe;

public class DataAdaptor {
	private InterfaceData dataProvider; 

	public DataAdaptor()
	{
		// variable que l'on pourrait récupérer dans un fichier de config
		String env = "dev";
		// selon l'environnement le dataprovider va chercher et instancier soit la classe qui charge les données en java ou en BDD
		// l'objet dataProvider fera appel aux même fonctions chez les deux classes 
		if (env.equals("dev"))
		{
			 dataProvider = new DataInJava();
		}
		else
		{
			 dataProvider = new DataInBDD();
		}		
	}
	
	// fonction de sauvegarde
	public void SaveCook (Cook cook)
	{
		this.dataProvider.saveCook(cook);
	}
	
	// fonction de chargement d'un cook
	public Cook loadCook(String name)
	{
		return this.dataProvider.loadCook(name);
	}
	
	// fonction de chargement des recettes
	public ArrayList<Recipe> getRecipe()
	{
		return this.dataProvider.getRecipe();
	}
}
