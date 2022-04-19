package TopChefRPG.Service.DTO;

import TopChefRPG.model.Ingredient;

public class IngredientDTO {
    public String ingredientName;

    public int ingredientQuantity;

    public IngredientDTO(Ingredient ingredient)
    {
        this.ingredientName =ingredient.getName();
        this.ingredientQuantity =ingredient.getIngredientQuantity();
    }
}
