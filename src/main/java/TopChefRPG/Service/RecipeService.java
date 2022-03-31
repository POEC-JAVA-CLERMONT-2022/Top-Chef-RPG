package TopChefRPG.Service;

import TopChefRPG.Repository.RecipeRepository;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Ingredient;
import TopChefRPG.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;


    public void createRecipes( ){

        Recipe epluchPomme =new Recipe("eplucher pomme", "",0,"",0,"",0,10,"pomme",5,"",0,0,0,0);
        recipeRepository.save(epluchPomme);
        Recipe tartePomme =new Recipe("tarte au pommes", "pomme",10,"",0,"",0,10,"patate",5,"",0,0,0,0);
        recipeRepository.save(tartePomme);
    }

    public List<Recipe> getRecipes()
    {
        List<Recipe> recipes = recipeRepository.findAll();
        for (Recipe recipe :recipes)
        {
            recipe.requiredIngredients = new ArrayList<Ingredient>();
            if (recipe.getFirstIngredient().length()>0)
            {
                recipe.requiredIngredients.add( new Ingredient(recipe.getFirstIngredient(), recipe.getFirstQty()));
            }
            if (recipe.getSecondIngredient().length()>0)
            {
                recipe.requiredIngredients.add( new Ingredient(recipe.getSecondIngredient(), recipe.getSecondQty()));
            }
            if (recipe.getThirdIngredient().length()>0)
            {
                recipe.requiredIngredients.add( new Ingredient(recipe.getThirdIngredient(), recipe.getThirdQty()));
            }
            recipe.lootIngredient =new ArrayList<Ingredient>();
            if (recipe.getLooting1Name().length()>0)
            {
                recipe.lootIngredient.add(new Ingredient(recipe.getLooting1Name(),recipe.getLooting1Qty()));
            }
            if (recipe.getLooting2Name().length()>0)
            {
                recipe.lootIngredient.add(new Ingredient(recipe.getLooting2Name(),recipe.getLooting2Qty()));
            }
        }
        return recipes;
    }

    public Recipe getRecipe(int id)
    {
        Recipe recipe = recipeRepository.getById(id);

        return recipe;
    }

    // fonction qui calcule la chance de succès d'une recette retourne un int compris entre 0 et 100
    public int getChanceSucces( Recipe recipe, Cook cook)
    {
        //Le calcul se décompose en 2 parties 50 % sont uniquement liés à luck (valeur entre 0 et 50)
        // la chance donne une possibilité aléatoire d'ajout entre 0 et la valeur de luck du cook
        // les 50 % restant sont calculés en comparant le niveau requis et le niveau du cook pour ses
        // 3 caractèristiques et rapportés à 50.
        // la recette sera réussie si le score

        int chanceSucces =0;


        // on augmente la chance de réussite de la chance du cuisinnier (en théorie ajout entre 0 et 50)
        if (cook.getLuck()<=50)
            chanceSucces += Math.random()*cook.getLuck();
        else
            chanceSucces += Math.random()*50;

        // on calcul ensuite l'apport des niveaux requis (value max 50 %)
        int sumRequis = recipe.getCreativityRequired()+recipe.getStrengthRequired() + recipe.getDexterityRequired();
        // calcul de chaque apport de caracteristique : si la carac est au dessus du niveau requis elle ne compense pas une autre carac
        int strengthGain =0;
        int dexterityGain=0;
        int creativityGain=0;
        // si le cook n'a pas le niveau requis on donne les points qu'il obtient
        if (cook.getCreativity()<recipe.getCreativityRequired())
            creativityGain= cook.getCreativity()/sumRequis;
        // si il à plus que le niveau requis on lui met les points max que la caracteristique apporte
        else
            creativityGain= recipe.getCreativityRequired()/sumRequis;
        if (cook.getDexterity()<recipe.getDexterityRequired())
            dexterityGain= cook.getDexterity()/sumRequis;
        else
            dexterityGain= recipe.getDexterityRequired()/sumRequis;
        if (cook.getStrength()< recipe.getStrengthRequired())
            strengthGain= cook.getStrength()/sumRequis;
        else
            strengthGain= recipe.getStrengthRequired()/sumRequis;

        // on fait la somme des gains dans chance Succès
        chanceSucces+= creativityGain+dexterityGain+strengthGain;

        return chanceSucces;
    }


}
