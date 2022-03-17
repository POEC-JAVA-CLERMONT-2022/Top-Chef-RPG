package javaCode.dataConnection;

import java.util.ArrayList;

import javaCode.Cook;
import javaCode.Lesson;
import javaCode.Recipe;

public interface InterfaceData {
	
	public void saveCook(Cook cook);
	
	// fonction de chargement de cuisinnier par nom de cuisinier
	public Cook loadCook(String nameCook);
	// fonction de chargement de cuisinnier par id de cuisinier
	public Cook loadCook(int  idCook);
	//fonction de get recettes
	public ArrayList<Recipe> getRecipe();
	
	// fonction qui fournit la liste des Recettes achetées par un joueur
	public ArrayList<Lesson> getOwnedLessons (String nameCook);


}
