
package TopChefRPG.Service;

import TopChefRPG.model.Cook;
import TopChefRPG.model.CookLesson;
import TopChefRPG.model.Lesson;
import TopChefRPG.model.User;
import TopChefRPG.Service.CookService;
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

    @Autowired
    CookService cookService;

    @Autowired
    UserService userService;


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
    }
}

