package TopChefRPG.Service;

import TopChefRPG.Repository.CookRepository;
import TopChefRPG.Service.DTO.ResultLessonDTO;
import TopChefRPG.Service.DTO.ResultRecipeDTO;
import TopChefRPG.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CookService {
    private CookRepository cookRepository;

    private IngredientService ingredientService;

    private RecipeService recipeService;


    public CookService (CookRepository cookRepository, IngredientService ingredientService, RecipeService recipeService )
    {
        this.cookRepository = cookRepository;
        this.ingredientService = ingredientService;
        this.recipeService = recipeService;
    }

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

    @Transactional
    public void delCookById(int idCook)
    {
        Cook cook = getCookById(idCook);
    // suppression manuelle des ingrédients
    //ingredientService.deleteIngredients(cook.getIngredients());

    //entityManager.remove(cook);
        cookRepository.deleteCookById(idCook);
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

    public ResultLessonDTO doLesson (int idLesson, Cook cook)
    {
        ResultLessonDTO resultLessonDTO = new ResultLessonDTO(-1,-1,-1,-1,-1);
        boolean haveBuyLesson = false;
        // on parcourt les cooklessons possedées par le cook pour voir si il possède la bonne leçon.
        for (CookLesson cl : cook.getCookLessons())
        {
            if (cl.getLesson().getIdLesson() == idLesson) {
                haveBuyLesson = true;
                Lesson lesson = cl.getLesson();
                // Vérification que l'expérience est suffisante
                if (cook.getExperience() >= lesson.getExperienceCost())
                {
                    // MAJ de l'expérience
                    cook.changeExperience(- lesson.getExperienceCost());
                    //Amélioration des stats du cook de moitié de l'écart entre la valeur max et le niveau actuel jusqu'au max de la lesson

                    int strengthIncrease = (lesson.getStrengthIncrease() - cook.getStrength()+1)/2;
                    if (strengthIncrease <0) {strengthIncrease =0;}
                    int dexterityIncrease = (lesson.getDexterityIncrease() - cook.getDexterity()+1)/2;
                    if (dexterityIncrease<0){dexterityIncrease=0;}
                    int creativityIncrease = (lesson.getCreativityIncrease() - cook.getCreativity()+1)/2;
                    if (creativityIncrease < 0) { creativityIncrease =0;}
                    int luckIncrease = (lesson.getLuckIncrease() - cook.getLuck()+1)/2;
                    if (luckIncrease <0 ) { luckIncrease = 0 ;}

                    cook.changeCaracteristique(strengthIncrease, dexterityIncrease, creativityIncrease, luckIncrease);
                    // incrémentation de cooklesson
                    cl.incrementCountUse();
                    resultLessonDTO = new ResultLessonDTO(dexterityIncrease, creativityIncrease, strengthIncrease, luckIncrease,lesson.getExperienceCost());
                }
                else{
                    // message erreur cook pas assez d'expérience
                }
            }
        }
        if (haveBuyLesson == false)
        {
            //message erreur lesson pas possedée par le cook;+
        }
        cookRepository.save(cook);
        return resultLessonDTO ;
    }

    public Cook getCookById(int id) {
        return cookRepository.getCookById(id);
    }


}
