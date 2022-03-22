package dataConnection;

import java.util.ArrayList;

import models.Cook;
import models.Lesson;
import models.Recipe;
import models.User;

public class DataAdaptor {
	private InterfaceData dataProvider; 

	public DataAdaptor()
	{
		// variable que l'on pourrait r�cup�rer dans un fichier de config
		String env = "dev";
		// selon l'environnement le dataprovider va chercher et instancier soit la classe qui charge les donn�es en java ou en BDD
		// l'objet dataProvider fera appel aux m�me fonctions chez les deux classes 
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
	// fonction de chargement des le�ons
	public ArrayList<Lesson> getOwnedLessons(String name)
	{
		return this.getOwnedLessons(name);
	}
	
	//sauvegarde de l'utilisateur
	public void saveUser(User user)
	{
		this.dataProvider.saveUser(user);
	}
}
