package TopChefRPG.Service;

import TopChefRPG.Repository.IngredientRepository;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public void initializeIngredient(Cook cook)
    {
        ArrayList<String> ingredients = new ArrayList<String>();
        ingredients.add("pomme");
        ingredients.add("patate");
        ingredients.add("steak");
        ingredients.add("farine");

        for (String ing : ingredients)
        {
            Ingredient ingredient = new Ingredient(ing, cook);
            ingredientRepository.save(ingredient);
        }


    }


}
