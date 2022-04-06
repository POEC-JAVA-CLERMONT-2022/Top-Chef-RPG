package TopChefRPG.Service;

import TopChefRPG.Repository.CookRepository;
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

    @Autowired
    CookRepository cookRepository;

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
            cook.getIngredients().add(ingredient);

            //ingredientRepository.save(ingredient);
        }
        cookRepository.save(cook);
    }

    // mise à jour de la liste d'ingredients d'un cook !! Attention innutile avec la mise à jour en direct de la bdd par hibernate
    public void saveIngredients(List<Ingredient> ingredients)
    {
        for (Ingredient ing :ingredients)
        {
            ingredientRepository.save(ing);
        }
    }


}
