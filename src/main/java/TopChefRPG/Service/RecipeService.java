package TopChefRPG.Service;

import TopChefRPG.Exception.ErrorType;
import TopChefRPG.Exception.TopChefException;
import TopChefRPG.Repository.RecipeRepository;
import TopChefRPG.Service.DTO.RecipeDTO;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Ingredient;
import TopChefRPG.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    RecipeRepository recipeRepository;
    @Autowired
    public RecipeService(RecipeRepository recipeRepository){
        this.recipeRepository =recipeRepository;
    }

    public void createRecipes() {

        Recipe epluchPomme = new Recipe("Eplucher pomme", "", 0, "", 0, "", 0, 10, "pomme", 5, "", 0, 1, 1, 1);
        recipeRepository.save(epluchPomme);
        Recipe tartePomme = new Recipe("Compote", "pomme", 10, "", 0, "", 0, 15, "patate", 5, "", 0, 10, 10, 10);
        recipeRepository.save(tartePomme);
        Recipe frites = new Recipe("Frites au four", "patate", 5, "", 0, "", 0, 25, "farine", 5, "eau", 7, 25, 15, 10);
        recipeRepository.save(frites);
        Recipe pateATarte = new Recipe("Pâte à tarte", "farine", 5, "eau", 5, "", 0, 30, "pate à tarte", 2, "", 0, 30, 20, 15);
        recipeRepository.save(pateATarte);
        Recipe epluchChou = new Recipe("Eplucher chou", "", 0, "", 0, "", 0, 10, "chou", 50, "saucisse", 1, 35, 30, 15);
        recipeRepository.save(epluchChou);
        Recipe tartopomme = new Recipe("Tarte aux pommes", "pate à tarte",1 , "pomme", 10, "", 0, 80, "tomate", 10, "mozzarela", 5, 30, 40, 25);
        recipeRepository.save(tartopomme);
        Recipe soupochou = new Recipe("Soupe aux choux", "chou",8 , "patate", 10, "eau", 10, 120, "saucisse", 5, "eau", 8, 40, 20, 20);
        recipeRepository.save(soupochou);
        Recipe socochou = new Recipe("Saucise au chou", "chou",3 , "saucisse", 2, "", 0, 200, "mozzarela", 5, "eau", 10, 30, 40, 25);
        recipeRepository.save(socochou);
        Recipe pateApizza = new Recipe("Pate à pizza", "farine",10 , "eau", 5, "", 0, 300, "pate à pizza", 2, "tomate", 10, 45, 35, 40);
        recipeRepository.save(pateApizza);
        Recipe pizza = new Recipe("Pizza !", "pate à pizza",1 , "tomate", 4, "mozzarela", 5, 500, "mozzarela", 10, "saucisse", 10, 50, 50, 50);
        recipeRepository.save(pizza);

    }

    public List<Recipe> getRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();
        if (recipes.isEmpty())
        {
            throw new TopChefException(ErrorType.DATA_NOT_INITIALIZED_IN_BDD, "no recipes returned from BDD", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        for (Recipe recipe : recipes) {
            recipe.requiredIngredients = new ArrayList<>();
            if (recipe.getFirstIngredient().length() > 0) {
                recipe.requiredIngredients.add(new Ingredient(recipe.getFirstIngredient(), recipe.getFirstQty()));
            }
            if (recipe.getSecondIngredient().length() > 0) {
                recipe.requiredIngredients.add(new Ingredient(recipe.getSecondIngredient(), recipe.getSecondQty()));
            }
            if (recipe.getThirdIngredient().length() > 0) {
                recipe.requiredIngredients.add(new Ingredient(recipe.getThirdIngredient(), recipe.getThirdQty()));
            }
            recipe.lootIngredient = new ArrayList<>();
            if (recipe.getLooting1Name().length() > 0) {
                recipe.lootIngredient.add(new Ingredient(recipe.getLooting1Name(), recipe.getLooting1Qty()));
            }
            if (recipe.getLooting2Name().length() > 0) {
                recipe.lootIngredient.add(new Ingredient(recipe.getLooting2Name(), recipe.getLooting2Qty()));
            }
        }
        return recipes;
    }

    public List<RecipeDTO> getRecipesDTO (Cook cook){

        List<Recipe> recipes = getRecipes();

        List<RecipeDTO> recipeDTOS = new ArrayList<>();
        int chanceOfSuccess ;
        for (Recipe recipe : recipes)
        {
            chanceOfSuccess = getProbabilityOfSucces(recipe, cook);
            recipeDTOS.add(new RecipeDTO(recipe, chanceOfSuccess, cook.getIngredients()));
        }
        return recipeDTOS;
    }

    public Recipe getRecipe(int id) {
        if (recipeRepository.existsById(id)) {
            Recipe recipe = recipeRepository.getRecipeById(id);
            recipe.requiredIngredients = new ArrayList<>();
            // on nourrit les listes d'ingrédients loot et requis de l'objet
            if (recipe.getFirstIngredient().length() > 0) {
                recipe.requiredIngredients.add(new Ingredient(recipe.getFirstIngredient(), recipe.getFirstQty()));
            }
            if (recipe.getSecondIngredient().length() > 0) {
                recipe.requiredIngredients.add(new Ingredient(recipe.getSecondIngredient(), recipe.getSecondQty()));
            }
            if (recipe.getThirdIngredient().length() > 0) {
                recipe.requiredIngredients.add(new Ingredient(recipe.getThirdIngredient(), recipe.getThirdQty()));
            }
            recipe.lootIngredient = new ArrayList<>();
            if (recipe.getLooting1Name().length() > 0) {
                recipe.lootIngredient.add(new Ingredient(recipe.getLooting1Name(), recipe.getLooting1Qty()));
            }
            if (recipe.getLooting2Name().length() > 0) {
                recipe.lootIngredient.add(new Ingredient(recipe.getLooting2Name(), recipe.getLooting2Qty()));
            }

            return recipe;
        }
        else {
            throw new TopChefException(ErrorType.WRONG_RECIPE_ID, "Aucune recette ne correspond à l'ID : "+ id, HttpStatus.NOT_FOUND);
        }
    }

    // fonction qui calcule la chance de succès d'une recette retourne un int compris entre 0 et 100
    public int getChanceSucces(Recipe recipe, Cook cook) {
        //Le calcul se décompose en 2 parties 50 % sont uniquement liés à luck (valeur entre 0 et 50)
        // la chance donne une possibilité aléatoire d'ajout entre 0 et la valeur de luck du cook
        // les 50 % restant sont calculés en comparant le niveau requis et le niveau du cook pour ses
        // 3 caractèristiques et rapportés à 50.
        // la recette sera réussie si le score

        int chanceSucces = 0;


        // on augmente la chance de réussite de la chance du cuisinnier (en théorie ajout entre 0 et 50)
        if (cook.getLuck() <= 50)
            chanceSucces += Math.random() * cook.getLuck();
        else
            chanceSucces += Math.random() * 50;

        // on calcul ensuite l'apport des niveaux requis (value max 50 %)
        int sumRequis = recipe.getCreativityRequired() + recipe.getStrengthRequired() + recipe.getDexterityRequired();
        // calcul de chaque apport de caracteristique : si la carac est au dessus du niveau requis elle ne compense pas une autre carac
        double strengthGain ;
        double dexterityGain ;
        double creativityGain ;
        double strengthRequired = recipe.getStrengthRequired();
        double dexterityRequired = recipe.getDexterityRequired();
        double creativityRequired = recipe.getCreativityRequired();
        double cookCreativity = cook.getCreativity();
        double cookDexterity = cook.getDexterity();
        double cookStrength = cook.getStrength();
        // si le cook n'a pas le niveau requis on donne les points qu'il obtient

        // creativity
        if (cookDexterity < dexterityRequired)
            creativityGain =  cookCreativity/ sumRequis;
            // si il à plus que le niveau requis on lui met les points max que la caracteristique apporte
        else
            creativityGain = creativityRequired / sumRequis;


        // dexterity
        if (cookDexterity < dexterityRequired)
            dexterityGain = cookDexterity / sumRequis;
        else
            dexterityGain = dexterityRequired / sumRequis;

        // strength
        if (cookStrength < strengthRequired)
            strengthGain = cookStrength / sumRequis;
        else
            strengthGain = strengthRequired / sumRequis;

        // on fait la somme des gains dans chance Succès
        chanceSucces += (creativityGain + dexterityGain + strengthGain) *50;

        return chanceSucces;
    }
    // fonction qui calcule la probabilité  de succès d'une recette retourne un int compris entre 0 et 100
    public int getProbabilityOfSucces(Recipe recipe, Cook cook) {
        //Le calcul se décompose en 2 parties 50 % sont uniquement liés à luck (valeur entre 0 et 50)
        // La chance est calculé comme la moitié de luck car on doit afficher la même valeur en estimation de chance pour les mêmes caracteristiques
        // les 50 % restant sont calculés en comparant le niveau requis et le niveau du cook pour ses
        // 3 caractèristiques et rapportés à 50.
        // la recette sera réussie si le score

        int chanceSucces = 0;


        // on augmente la chance de réussite de la chance du cuisinnier (en théorie ajout entre 0 et 50)
        if (cook.getLuck() <= 50)
            chanceSucces += ((double)cook.getLuck())/2;
        else
            chanceSucces += 25;

        // on calcul ensuite l'apport des niveaux requis (value max 50 %)
        int sumRequis = recipe.getCreativityRequired() + recipe.getStrengthRequired() + recipe.getDexterityRequired();
        // calcul de chaque apport de caracteristique : si la carac est au dessus du niveau requis elle ne compense pas une autre carac
        double strengthGain ;
        double dexterityGain ;
        double creativityGain ;
        double strengthRequired = recipe.getStrengthRequired();
        double dexterityRequired = recipe.getDexterityRequired();
        double creativityRequired = recipe.getCreativityRequired();
        double cookCreativity = cook.getCreativity();
        double cookDexterity = cook.getDexterity();
        double cookStrength = cook.getStrength();
        // si le cook n'a pas le niveau requis on donne les points qu'il obtient

        // creativity
        if (cookDexterity < dexterityRequired)
            creativityGain =  cookCreativity/ sumRequis;
            // si il à plus que le niveau requis on lui met les points max que la caracteristique apporte
        else
            creativityGain = creativityRequired / sumRequis;


        // dexterity
        if (cookDexterity < dexterityRequired)
            dexterityGain = cookDexterity / sumRequis;
        else
            dexterityGain = dexterityRequired / sumRequis;

        // strength
        if (cookStrength < strengthRequired)
            strengthGain = cookStrength / sumRequis;
        else
            strengthGain = strengthRequired / sumRequis;

        // on fait la somme des gains dans chance Succès
        chanceSucces += (creativityGain + dexterityGain + strengthGain) *50;

        return chanceSucces;
    }


}
