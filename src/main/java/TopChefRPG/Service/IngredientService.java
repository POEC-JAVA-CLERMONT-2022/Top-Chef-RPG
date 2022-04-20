package TopChefRPG.Service;

import TopChefRPG.Repository.CookRepository;
import TopChefRPG.Repository.IngredientListRepository;
import TopChefRPG.Repository.IngredientRepository;
import TopChefRPG.Service.DTO.IngredientDTO;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Ingredient;
import TopChefRPG.model.IngredientList;
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

    @Autowired
    IngredientListRepository ingredientListRepository;

    public void initializeIngredient(Cook cook)
    {





        for (IngredientList ingredientList : ingredientListRepository.findAll())
        {
            Ingredient ingredient = new Ingredient(ingredientList.getName(), cook);
            cook.getIngredients().add(ingredient);


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

    // retourne une liste d'ingrédients (nom quantité) qui ont été initialisés (quantité >-1)
    public List<IngredientDTO> getIngredientOfCook (int idCook){
        Cook cook = cookRepository.getCookById(idCook);
        List<IngredientDTO> ingredientDTOS = new ArrayList<>();
        for (Ingredient ingredient : cook.getIngredients())
        {
            if (ingredient.getIngredientQuantity()>-1)
            {
                IngredientDTO ingredientDTO = new IngredientDTO(ingredient);
                ingredientDTOS.add(ingredientDTO);
            }
        }
        return ingredientDTOS;
    }



}
