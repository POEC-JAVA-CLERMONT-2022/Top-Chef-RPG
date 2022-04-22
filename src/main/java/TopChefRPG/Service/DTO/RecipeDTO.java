package TopChefRPG.Service.DTO;
import TopChefRPG.model.Ingredient;
import TopChefRPG.model.Recipe;
import java.util.ArrayList;
import java.util.List;

public class RecipeDTO {
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

    public RecipeDTO (Recipe recipe, int chanceOfSucces, List<Ingredient> ingredients)
    {
        this.idRecipe = recipe.getIdRecipe();
        this.name = recipe.getName();
        this.ingredientsRequired = recipe.requiredIngredients;
        this.lootIngredient =  recipe.lootIngredient;
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

    public ArrayList<Ingredient> getIngredientsRequired() {
        return ingredientsRequired;
    }

    public void setIngredientsRequired(ArrayList<Ingredient> ingredientsRequired) {
        this.ingredientsRequired = ingredientsRequired;
    }

    public ArrayList<Ingredient> getLootIngredient() {
        return lootIngredient;
    }

    public void setLootIngredient(ArrayList<Ingredient> lootIngredient) {
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
