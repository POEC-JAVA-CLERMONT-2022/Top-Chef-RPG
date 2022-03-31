package TopChefRPG.Service.DTO;

import TopChefRPG.model.Ingredient;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;

public class ResultRecipeDTO {

    private ArrayList<Ingredient> ingredientLoot;

    private ArrayList<Ingredient> ingredientUsed;

    private int experienceGain;

    private String textRetour;

    private String errorMessage;

    private boolean succes;

    public ResultRecipeDTO()
    {
        this.ingredientLoot = new ArrayList<Ingredient>();
        this.ingredientUsed = new ArrayList<Ingredient>();
    }
    public void addIngredientLoot (ArrayList<Ingredient> ingredients)
    {
        for (Ingredient i : ingredients)
            this.ingredientLoot.add(i);
    }

    public void addIngredientUsed (ArrayList<Ingredient> ingredients)
    {
        for (Ingredient i : ingredients)
            this.ingredientUsed.add(i);
    }


    public void setExperienceGain(int experienceGain) {
        this.experienceGain = experienceGain;
    }

    public void setTextRetour(String textRetour) {
        this.textRetour = textRetour;
    }

    public void setSucces(boolean succes) {
        this.succes = succes;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
