package TopChefRPG.Service;

import TopChefRPG.Repository.CookRepository;
import TopChefRPG.Service.DTO.ResultRecipeDTO;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Ingredient;
import TopChefRPG.model.Recipe;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class CookService {

    @Autowired
    private CookRepository cookRepository;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    RecipeService recipeService;

    public Cook createCook(String name, Character gender, User user) {
        Cook cook = new Cook(name, gender, user);
        cook = this.cookRepository.save(cook);
        // instancier la liste d'ingredients
        ingredientService.initializeIngredient(cook);

        return cook;
    }

    public Cook changeName(Cook cook, String newName) {
        cook.setName(newName);
        cookRepository.save(cook);
        return cook;
    }

    public void saveCook(Cook cook) {
        cookRepository.save(cook);
    }

    // fonction de sauvegarde des ingredients du cook. Appel la fonction de sauvegarde des ingredients
    // en passant une liste d'ingredients
    public void saveCookIngredients(Cook cook) {
        ingredientService.saveIngredients(cook.getIngredients());
    }

    public void deleteCook(Cook cook) {
        cookRepository.deleteById(cook.getId());
    }


    // fonction qui gère la réalisation d'une recette et renvoi un objet spécifique pour l'affichage de la recette
    public ResultRecipeDTO tryRecipe(int idRecipe, Cook cook) {
        Recipe recipe = recipeService.getRecipe(idRecipe);

        // instanciation de l'objet de retour de la réalisation de la recette
        ResultRecipeDTO RRDTO = new ResultRecipeDTO();

        // checker si possible pour les quantité ingredients
        boolean haveEnoughIngredient = true;
        for (Ingredient ingRequis : recipe.requiredIngredients) {
            for (Ingredient ingEnStock : cook.getIngredients()) {
                // si on est sur le même ingredient
                if (ingRequis.getName().equals(ingEnStock.getName())) {
                    if (ingRequis.getIngredientQuantity() > ingEnStock.getIngredientQuantity())
                        haveEnoughIngredient = false;
                }
            }
        }
        // si il n'y a pas assez d'ingredients, on renvoi un message d'erreur uniquement
        if (!haveEnoughIngredient)
        {
            RRDTO.setErrorMessage("Pas assez d'ingrédients pour faire la recette !");
        }
        // si la quantité d'ingrédients est suffisante pour faire la recette
        else
        {
            // on mets à jour les ingredients requis
            for (Ingredient ingRequis : recipe.requiredIngredients) {
                for (Ingredient ingEnStock : cook.getIngredients()) {
                    // si on est sur le même ingredient
                    if (ingRequis.getName().equals(ingEnStock.getName())) {
                        // on décrémente la quantité d'ingrédients
                        ingEnStock.setIngredientQuantity(- ingRequis.getIngredientQuantity());
                    }
                }
            }
            RRDTO.addIngredientUsed(recipe.requiredIngredients);

            // on test la réussite de la recette, si le score est supperieur à 100
            if (recipeService.getChanceSucces(recipe, cook)> Math.random()*100)
            {
                // on met à jour les ingredients looté
                for (Ingredient ingLoot : recipe.lootIngredient) {
                    for (Ingredient ingEnStock : cook.getIngredients()) {
                        // si on est sur le même ingredient
                        if (ingLoot.getName().equals(ingEnStock.getName())) {
                            // on décrémente la quantité d'ingrédients
                            ingEnStock.setIngredientQuantity(ingLoot.getIngredientQuantity());
                        }
                    }
                }
                // mise à jour de l'expérience du cook
                cook.changeExperience(recipe.getExperience());
                // on nourrit l'objet du message de retour
                RRDTO.setTextRetour("la recette est réussie !!");

                RRDTO.addIngredientLoot(recipe.lootIngredient);
                RRDTO.setExperienceGain(recipe.getExperience());
                RRDTO.setSucces(true);

            }
            else
            {
                // on passe le message d'echec
                RRDTO.setTextRetour("la recette a echouée !!");
                RRDTO.setSucces(false);
            }
            // on fait une sauvegarde en base de l'état du cook et de ses ingredients
            cookRepository.save(cook);
        }
        return RRDTO;
    }

    public Cook getCookById(int id) {
        return cookRepository.getById(id);
    }


}
