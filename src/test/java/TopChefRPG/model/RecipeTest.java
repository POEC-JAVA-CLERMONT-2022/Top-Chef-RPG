package TopChefRPG.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RecipeTest {

    @Test
    @DisplayName("constructeur recipe")
    public void createRecipe() {
        Recipe recipe = new Recipe("poutine", "frites", 30, "érable", 50, "fromage", 60, 12, "pommes", 10, "patates", 10, 10, 11, 12);

        Assertions.assertNotNull(recipe);
        Assertions.assertEquals("poutine", recipe.getName());
        Assertions.assertEquals("frites", recipe.getFirstIngredient());
        Assertions.assertEquals(30, recipe.getFirstQty());
        Assertions.assertEquals("érable", recipe.getSecondIngredient());
        Assertions.assertEquals(50, recipe.getSecondQty());
        Assertions.assertEquals("fromage", recipe.getThirdIngredient());
        Assertions.assertEquals(60, recipe.getThirdQty());
        Assertions.assertEquals(12, recipe.getExperience());
        Assertions.assertEquals("pommes", recipe.getLooting1Name());
        Assertions.assertEquals(10, recipe.getLooting1Qty());
        Assertions.assertEquals("patates", recipe.getLooting2Name());
        Assertions.assertEquals(10, recipe.getLooting2Qty());
        Assertions.assertEquals(10, recipe.getStrengthRequired());
        Assertions.assertEquals(12, recipe.getCreativityRequired());
        Assertions.assertEquals(11, recipe.getDexterityRequired());
    }

}
