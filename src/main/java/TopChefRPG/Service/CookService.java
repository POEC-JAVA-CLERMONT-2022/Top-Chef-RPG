package TopChefRPG.Service;

import TopChefRPG.Repository.CookRepository;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Recipe;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookService {

    @Autowired
    private CookRepository cookRepository;

    @Autowired
    private IngredientService ingredientService ;

    @Autowired RecipeService recipeService;

    public Cook createCook(String name, Character gender, User user)
    {
        Cook cook = new Cook(name, gender, user);
        cook =this.cookRepository.save(cook);
        // instancier la liste d'ingredients
        ingredientService.initializeIngredient(cook);

        return cook;
    }
    public Cook changeName(Cook cook,String newName)
    {
        cook.setName(newName);
        cookRepository.save(cook);
        return cook;
    }

    public void saveCook(Cook cook)
    {
        cookRepository.save(cook);
    }

    // fonction de sauvegarde des ingredients du cook. Appel la fonction de sauvegarde des ingredients
    // en passant une liste d'ingredients
    public void saveCookIngredients(Cook cook)
    {
        ingredientService.saveIngredients(cook.getIngredients());
    }

    public void deleteCook(Cook cook)
    {
        cookRepository.deleteById(cook.getId());
    }

    public void tryRecipe(Long idRecipe, Cook cook)
    {
        Recipe recipe = recipeService.getRecipe(idRecipe);

        // checker si possible pour les quantité ingredients

        //
    }

}
