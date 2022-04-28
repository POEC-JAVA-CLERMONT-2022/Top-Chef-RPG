package TopChefRPG.Service;

import TopChefRPG.model.Cook;
import TopChefRPG.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CookServiceTest {

    Cook cook1;
    Cook cook2;
    User paulo;
    CookService cookService;
    UserService userService;

    @Autowired
    public CookServiceTest (CookService cookService, UserService userService)
    {
        this.cookService =cookService;
        this.userService = userService;
    }


    @BeforeEach
    public void varInitialize() {
        paulo = userService.create("paulo", "mail", "password");
        cook1 = cookService.createCook("alexandre", 'M', paulo);
        cook2 = cookService.createCook("alexandra", 'F', paulo);
    }

    @Test
    @DisplayName("test create cook")
    void testCreateCook() {

        Assertions.assertNotNull(cook1);
        Assertions.assertNotNull(cook1.getIngredients());
        Assertions.assertEquals(paulo, cook1.getUser());
    }

    @Test
    @DisplayName("changement de nom du cook")
    public void TestChangeName() {
        //methode à tester
        Assertions.assertNotEquals("stephane", cook1.getName());
        cook1 = cookService.changeName(cook1, "stephane");
        Assertions.assertEquals("stephane", cook1.getName());
    }

}

