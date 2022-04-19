package TopChefRPG.Service;

import TopChefRPG.Repository.RecipeRepository;
import TopChefRPG.model.Recipe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
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
    }



}
