package TopChefRPG.Service.DTO;

import TopChefRPG.Service.RecipeService;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Ingredient;
import TopChefRPG.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;

public class RecipeDTO {
    @Autowired
    RecipeService recipeService;


    public int idRecipe;
    public String name;
    public ArrayList<Ingredient> ingredientsRequired;
    public ArrayList<Ingredient> lootIngredient;
    public int strengthRequired;
    public int dexterityRequired;
    public int creativityRequired;
    public int chanceOfSucces;
    public int experienceGain;
    public boolean doable ;

    public RecipeDTO (Recipe recipe, Cook cook)
    {
        this.idRecipe = recipe.getIdRecipe();
        this.name = recipe.getName();
        this.ingredientsRequired = recipe.requiredIngredients;
        this.lootIngredient =  recipe.lootIngredient;
        this.strengthRequired = recipe.getStrengthRequired();
        this.creativityRequired = recipe.getCreativityRequired();
        this.dexterityRequired = recipe.getDexterityRequired();
        this.chanceOfSucces = recipeService.getProbabilityOfSucces(recipe, cook);
        this.experienceGain = recipe.getExperience();
        this.doable = true;
        for (Ingredient ingRequired : recipe.requiredIngredients)
        {
            for (Ingredient ingStock : cook.getIngredients())
            {
                if (ingRequired.getName().equals(ingStock.getName()))
                {
                    if (ingRequired.getIngredientQuantity()> ingStock.getIngredientQuantity() )
                        this.doable = false;
                }
            }
        }
    }
}
