package javaCode.dataConnection;

import java.util.ArrayList;

import javaCode.Cook;
import javaCode.Ingredient;
import javaCode.Lesson;
import javaCode.Recipe;
import javaCode.User;

public class DataInJava implements InterfaceData {
	
	

	@Override
	public void saveCook(Cook cook) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cook loadCook(String nameCook) {
		// TODO Auto-generated method stub
		
		Cook neoCook = new Cook(nameCook);
		if (nameCook.equals("robert"))
		{
			neoCook.setCreativity(25);
			neoCook.setDexterity(25);
			neoCook.setExperience(500);
			neoCook.setGender('M');
			neoCook.setStrength(30);
			neoCook.setLuck(30);
			Ingredient pomme = new Ingredient("pomme");
			pomme.setQuantity(200);
			ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
			ingredients.add(pomme);
			neoCook.setIngredients(ingredients);
			
		}
		return neoCook;
	}

	@Override
	public Cook loadCook(int idCook) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Recipe> getRecipe() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Lesson> getOwnedLessons(String nameCook) {
		// TODO Auto-generated method stub
		ArrayList<Lesson> lessons = new ArrayList<Lesson>();

		Lesson lesson = new Lesson("Cuisinner les pommes", 10, 10, 5, 20, 300);
		
		lessons.add(lesson);
		
		return lessons;

	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
	}


}
