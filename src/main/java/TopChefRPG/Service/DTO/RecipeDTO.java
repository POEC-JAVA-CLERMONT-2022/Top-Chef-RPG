package TopChefRPG.Service.DTO;
import TopChefRPG.model.Ingredient;
import TopChefRPG.model.Recipe;
import com.sun.xml.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;
import java.util.List;

public class RecipeDTO {
    public int idRecipe;

    public String name;
    public ArrayList<IngredientDTO> ingredientsRequired;
    public ArrayList<IngredientDTO> lootIngredient;
    public int strengthRequired;
    public int dexterityRequired;
    public int creativityRequired;
    public int chanceOfSucces;
    public int experienceGain;
    public boolean doable ;

    public RecipeDTO (Recipe recipe, int chanceOfSucces, List<Ingredient> ingredients)
    {
        this.idRecipe = recipe.getIdRecipe();
        this.name = recipe.getName();
        this.ingredientsRequired = new ArrayList<IngredientDTO>();
        this.lootIngredient =  new ArrayList<IngredientDTO>();
        this.strengthRequired = recipe.getStrengthRequired();
        this.creativityRequired = recipe.getCreativityRequired();
        this.dexterityRequired = recipe.getDexterityRequired();
        this.chanceOfSucces = chanceOfSucces;
        this.experienceGain = recipe.getExperience();
        this.doable = true;
        for (Ingredient ingRequired : recipe.requiredIngredients)
        {
            for (Ingredient ingStock : ingredients)
            {
                if (ingRequired.getName().equals(ingStock.getName()))
                {
                    if (ingRequired.getIngredientQuantity()> ingStock.getIngredientQuantity() )
                        this.doable = false;
                }
            }
            //remplissage des ingrédients requis sous forme DTO
            this.ingredientsRequired.add(new IngredientDTO(ingRequired));
        }
        for (Ingredient ingLoot : recipe.lootIngredient)
        {
            this.lootIngredient.add(new IngredientDTO(ingLoot));
        }



    }

    public int getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(int idRecipe) {
        this.idRecipe = idRecipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<IngredientDTO> getIngredientsRequired() {
        return ingredientsRequired;
    }

    public void setIngredientsRequired(ArrayList<IngredientDTO> ingredientsRequired) {
        this.ingredientsRequired = ingredientsRequired;
    }

    public ArrayList<IngredientDTO> getLootIngredient() {
        return lootIngredient;
    }

    public void setLootIngredient(ArrayList<IngredientDTO> lootIngredient) {
        this.lootIngredient = lootIngredient;
    }

    public int getStrengthRequired() {
        return strengthRequired;
    }

    public void setStrengthRequired(int strengthRequired) {
        this.strengthRequired = strengthRequired;
    }

    public int getDexterityRequired() {
        return dexterityRequired;
    }

    public void setDexterityRequired(int dexterityRequired) {
        this.dexterityRequired = dexterityRequired;
    }

    public int getCreativityRequired() {
        return creativityRequired;
    }

    public void setCreativityRequired(int creativityRequired) {
        this.creativityRequired = creativityRequired;
    }

    public int getChanceOfSucces() {
        return chanceOfSucces;
    }

    public void setChanceOfSucces(int chanceOfSucces) {
        this.chanceOfSucces = chanceOfSucces;
    }

    public int getExperienceGain() {
        return experienceGain;
    }

    public void setExperienceGain(int experienceGain) {
        this.experienceGain = experienceGain;
    }

    public boolean isDoable() {
        return doable;
    }

    public void setDoable(boolean doable) {
        this.doable = doable;
    }
}
