package TopChefRPG.Service;

import TopChefRPG.Repository.CookRepository;
import TopChefRPG.model.Cook;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookService {

    @Autowired
    private CookRepository cookRepository;

    @Autowired
    private IngredientService ingredientService ;

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

    public void tryRecipe()
    {

    }

}
