package javaCode.dataConnection;

import java.util.ArrayList;

import javaCode.Cook;
import javaCode.Ingredient;

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

}
