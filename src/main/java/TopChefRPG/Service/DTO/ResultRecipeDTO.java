package TopChefRPG.Service.DTO;
import java.util.ArrayList;

public class ResultRecipeDTO {
    private ArrayList<IngredientDTO> ingredientLoot;
    private ArrayList<IngredientDTO> ingredientUsed;
    private int experienceGain;
    private String textRetour;
    private String errorMessage;
    private boolean succes;

    public ResultRecipeDTO()
    {
        this.ingredientLoot = new ArrayList<>();
        this.ingredientUsed = new ArrayList<>();
    }
    public void addIngredientLoot (ArrayList<IngredientDTO> dtos)
    {
        this.ingredientLoot.addAll(dtos);
    }

    public void addIngredientUsed (ArrayList<IngredientDTO> dtos)
    {
        this.ingredientUsed.addAll(dtos);
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

    public ArrayList<IngredientDTO> getIngredientLoot() {
        return ingredientLoot;
    }


    public String getTextRetour() {
        return textRetour;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setIngredientLoot(ArrayList<IngredientDTO> ingredientLoot) {
        this.ingredientLoot = ingredientLoot;
    }

    public ArrayList<IngredientDTO> getIngredientUsed() {
        return ingredientUsed;
    }

    public void setIngredientUsed(ArrayList<IngredientDTO> ingredientUsed) {
        this.ingredientUsed = ingredientUsed;
    }

    public int getExperienceGain() {
        return experienceGain;
    }

    public boolean isSucces() {
        return succes;
    }
}
