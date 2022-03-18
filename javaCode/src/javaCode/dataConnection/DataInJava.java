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
		ArrayList<Recipe> recipes = new ArrayList<Recipe>(); 
		Ingredient pommes = new Ingredient("pomme");
		Ingredient pommeLoots = new Ingredient("pomme");
		pommes.setQuantity(2);
		pommeLoots.setQuantity(10);
		Ingredient pdt = new Ingredient("pomme de terre");
		Ingredient pdtLoot = new Ingredient("pomme de terre");
		pdt.setQuantity(5);
		pdtLoot.setQuantity(10);
		Ingredient farine = new Ingredient("farine");
		Ingredient farineLoot = new Ingredient("farine");
		farine.setQuantity(3);
		farineLoot.setQuantity(8);
		ArrayList<Ingredient> listeIngredientLoot = new ArrayList<Ingredient>();
		listeIngredientLoot.add(pdtLoot);
		ArrayList<Ingredient> listeIngredient = new ArrayList<Ingredient>();

		ArrayList<Ingredient> listeIngredient2= new ArrayList<Ingredient>();
		listeIngredient2.add(pdt);
		ArrayList<Ingredient> listeIngredientLoot2 = new ArrayList<Ingredient>();
		listeIngredientLoot2.add(farineLoot);
		listeIngredientLoot2.add(pommeLoots);

		ArrayList<Ingredient> listeIngredient3= new ArrayList<Ingredient>();
		listeIngredient3.add(farine);
		listeIngredient3.add(pommes);
		ArrayList<Ingredient> listeIngredientLoot3 = new ArrayList<Ingredient>();
		listeIngredientLoot3.add(farineLoot);
		listeIngredientLoot3.add(pommeLoots);
		listeIngredientLoot3.add(pdtLoot);


		Recipe recette1 = new Recipe("tourte", 10, 10, 10, 5, listeIngredient , listeIngredientLoot); 
		Recipe recette2 = new Recipe("frites", 12, 12, 12, 2, listeIngredient2, listeIngredientLoot2);
		Recipe recette3 = new Recipe("cake", 15, 15, 16, 9, listeIngredient3, listeIngredientLoot3);

		// TODO Auto-generated method stub
		recipes.add(recette1);
		recipes.add(recette2);
		recipes.add(recette3);
		return recipes ;
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
