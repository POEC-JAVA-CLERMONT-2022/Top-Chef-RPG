package TopChefRPG.Service;

import TopChefRPG.Exception.ErrorType;
import TopChefRPG.Exception.TopChefException;
import TopChefRPG.Repository.CookRepository;
import TopChefRPG.Repository.IngredientListRepository;
import TopChefRPG.Repository.IngredientRepository;
import TopChefRPG.Service.DTO.IngredientDTO;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Ingredient;
import TopChefRPG.model.IngredientList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService {

    IngredientRepository ingredientRepository;

    CookRepository cookRepository;

    IngredientListRepository ingredientListRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository, CookRepository cookRepository, IngredientListRepository ingredientListRepository) {
        this.ingredientRepository = ingredientRepository;
        this.cookRepository = cookRepository;
        this.ingredientListRepository = ingredientListRepository;
    }

    public void initializeIngredient(Cook cook) {
        for (IngredientList ingredientList : ingredientListRepository.findAll()) {
            Ingredient ingredient = new Ingredient(ingredientList.getName(), cook);
            cook.getIngredients().add(ingredient);
        }
        cookRepository.save(cook);
    }

    // mise à jour de la liste d'ingredients d'un cook !! Attention innutile avec la mise à jour en direct de la bdd par hibernate
    public void saveIngredients(List<Ingredient> ingredients) {
        ingredientRepository.saveAll(ingredients);
    }

    // retourne une liste d'ingrédients (nom quantité) qui ont été initialisés (quantité >-1)
    public List<IngredientDTO> getIngredientOfCook(int idCook) {
        try {
            List<IngredientDTO> ingredientDTOS = new ArrayList<>();

            if (cookRepository.existsById(idCook)) {
                Cook cook = cookRepository.getCookById(idCook);

                for (Ingredient ingredient : cook.getIngredients()) {
                    if (ingredient.getIngredientQuantity() > -1) {
                        IngredientDTO ingredientDTO = new IngredientDTO(ingredient);
                        ingredientDTOS.add(ingredientDTO);
                    }
                }
                return ingredientDTOS;
            }
            else {
                throw new TopChefException(ErrorType.NO_DATA, "No cook with id : "+ idCook +" in BDD", HttpStatus.NOT_FOUND );
            }
        } catch (Exception exception) {
            throw exception;
        }


    }

    public void initializeIngredientListInBDD() {
        IngredientList ing = new IngredientList("pomme");
        ingredientListRepository.save(ing);
        ing = new IngredientList("patate");
        ingredientListRepository.save(ing);
        ing = new IngredientList("steak");
        ingredientListRepository.save(ing);
        ing = new IngredientList("chou");
        ingredientListRepository.save(ing);
    }

    public void deleteIngredients(List<Ingredient> ingredients) {
        for (Ingredient ing : ingredients) {
            ingredientRepository.deleteById(ing.getId());
        }
    }
}
