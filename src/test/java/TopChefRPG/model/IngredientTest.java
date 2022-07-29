package TopChefRPG.model;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class IngredientTest {

    Owner userTest;
    Cook cook;

   @BeforeEach
    public void contentInitializing()
    {
        userTest= new Owner("userForIngredientTest", "mail", "password");
        cook = new Cook("cookTestIngredient", 'F', userTest);
    }

    @Test
    @DisplayName("create Ingredient")
    public void createIngredient()
    {
        Ingredient ingredientTest = new Ingredient("ingredientName", cook);
        Assertions.assertNotNull(ingredientTest);
        Assertions.assertEquals(ingredientTest.getName(), "ingredientName");
        Assertions.assertEquals(ingredientTest.getIngredientQuantity(), -1);
    }
    @Test
    @DisplayName("Ingredient to String")
    public void ingredientToString()
    {
        Ingredient ingredientTest = new Ingredient("ingredientName", cook);
        Assertions.assertEquals(ingredientTest.toString(),"Ingredient : ingredientName Quantité : -1");
    }
    @Test
    @DisplayName("Set Ingredient Quantity")
    public void setIngredientQuantity()
    {
        Ingredient ingredientTest = new Ingredient("ingredientName", cook);
        // la valeur initiale doit être -1
        Assertions.assertEquals(ingredientTest.getIngredientQuantity(), -1);
        // on ne doit pas pouvoir initier un changement négatif quand à -1
        ingredientTest.setIngredientQuantity(-5);
        Assertions.assertEquals(ingredientTest.getIngredientQuantity(), -1);
        // on doit pouvoir augmenter la valeur et retrouver cette quantité exacte
        ingredientTest.setIngredientQuantity(2);
        Assertions.assertEquals(ingredientTest.getIngredientQuantity(), 2);
        // on doit pouvoir l'augmenter
        ingredientTest.setIngredientQuantity(10);
        Assertions.assertEquals(ingredientTest.getIngredientQuantity(), 12);
        // on doit pouvoir la réduire
        ingredientTest.setIngredientQuantity(-7);
        Assertions.assertEquals(ingredientTest.getIngredientQuantity(), 5);
        // on ne doit pas pouvoir la réduire à une valeur inférieure à 0
        ingredientTest.setIngredientQuantity(-10);
        Assertions.assertEquals(ingredientTest.getIngredientQuantity(), 5);
    }
}
