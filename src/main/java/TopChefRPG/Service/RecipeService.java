package TopChefRPG.Service;

import TopChefRPG.Repository.RecipeRepository;
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

    public Recipe getRecipe(Long id)
    {
        Recipe recipe = recipeRepository.getById(id);

        return recipe;
    }

}
