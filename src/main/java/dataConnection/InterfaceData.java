package dataConnection;

import java.util.ArrayList;

import models.Cook;
import models.Lesson;
import models.Recipe;
import models.User;

public interface InterfaceData {
	
	public void saveCook(Cook cook);
	
	// fonction de chargement de cuisinier par nom de cuisinier
	public Cook loadCook(String nameCook);
	// fonction de chargement de cuisinier par id de cuisinier
	public Cook loadCook(int  idCook);
	//fonction de get recettes
	public ArrayList<Recipe> getRecipe();
	
	// fonction qui fournit la liste des Recettes achet�es par un joueur
	public ArrayList<Lesson> getOwnedLessons (String nameCook);

	public void saveUser (User user);
}
