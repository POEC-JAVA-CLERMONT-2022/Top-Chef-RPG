package TopChefRPG.Service;

import TopChefRPG.Repository.RecipeRepository;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Recipe;
import TopChefRPG.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class RecipeServiceTest {

    @InjectMocks
    RecipeService recipeService;
    @Mock
    private RecipeRepository mockkRecipeRepository;

    @Test
    public void createRecipe()
    {
        // nothing to test ???
    }

    @Test
    public void getRecipes()
    {
        // initializing data
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("recipe1", "", 0, "", 0, "", 0, 10, "pomme", 5, "", 0, 1, 1, 1));
        recipes.add(new Recipe("recipe2", "firtI", 5, "SecondI", 10, "", 0, 10, "pomme", 5, "", 0, 1, 1, 1));
        recipes.add(new Recipe("recipe3", "firtI", 20, "SecondI", 20, "thirdI", 30, 10, "firstL", 10, "secondL", 10, 1, 1, 1));
        when(mockkRecipeRepository.findAll()).thenReturn(recipes);

        // calling method
        List<Recipe> recipeReturned = recipeService.getRecipes();
        assertEquals(recipes.size(), recipeReturned.size());
        Recipe lastRecipe = recipeReturned.get(2);
        assertNotNull(lastRecipe.requiredIngredients);
        assertEquals(3,lastRecipe.requiredIngredients.size());
        assertEquals(2,lastRecipe.lootIngredient.size());

        //TODO verify
    }

    @Test
    public void getProbabilityOfSucces()
    {
        Recipe recipe1 = new Recipe("recetteTest","ing1",1, "ing",2, "ing", 3, 100, "loot", 1, "loot", 2, 1,1,1);
        Recipe recipe20 = new Recipe("recetteTest","ing1",1, "ing",2, "ing", 3, 100, "loot", 1, "loot", 2, 20,20,20);

        User emptyUser = new User();
        Cook cookTest = new Cook("cookTest", 'M', emptyUser );

        // avec les carac = 1 et niveau requis = 1 on devrait avoir 50 % de réussite
        int proba = recipeService.getProbabilityOfSucces(recipe1,cookTest);
        assertEquals(50,proba);

        // on augmente la chance du cook pour monter à 63% de réussite (50% + 26 de luck)
        cookTest.changeCaracteristique(0,0,0,26);
        proba = recipeService.getProbabilityOfSucces(recipe1,cookTest);
        assertEquals(63,proba);

        // on augmente la chance au max (50) pour monter la proba 75%
        cookTest.changeCaracteristique(0,0,0,24);
        proba = recipeService.getProbabilityOfSucces(recipe1,cookTest);
        assertEquals(75,proba);
    }
}
