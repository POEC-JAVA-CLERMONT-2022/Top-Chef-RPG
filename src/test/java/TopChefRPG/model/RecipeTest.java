package TopChefRPG.model;
import TopChefRPG.Service.CookService;
import TopChefRPG.Service.RecipeService;
import TopChefRPG.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import  TopChefRPG.model.CookLesson;

@SpringBootTest
public class RecipeTest {

    @Test
    @DisplayName("constructeur recipe")
    {
        Recipe recipe = new Recipe("poutine","frites", 30, "érable", 50, "fromage", 60, 12, "pommes", )
    }

}
