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

@SpringBootTest

@ExtendWith(MockitoExtension.class)

public class CookTest {

    Cook cook1;
    Cook cook2;
    User paulo;
    Lesson patate;
    Cook_Lesson cooklesson;

    @Autowired
    UserService userService;

    @Autowired
    CookService cookService;

    @Autowired
    RecipeService recipeService;


    @BeforeEach
    public void varInitialize() {
        paulo = userService.create("paulo", "mail", "password");
        cook1 = new Cook("alexandre", 'M', paulo);
        cook2 = new Cook("alexandra", 'F', paulo);
        patate = new Lesson();
        patate.setparameerOfLesson("patate", 3, 3, 3, 3, 3, "patate", 3);
        cooklesson = new Cook_Lesson(cook1, patate);

    }

    @Test
    @DisplayName("changement de nom du cook")
    public void TestChangeName() {
        //methode à tester
        Assertions.assertNotEquals("stephane", cook1.getName());
        cook1.setName("stephane");
        Assertions.assertEquals("stephane", cook1.getName());
    }

    @Test
    @DisplayName("changement d'XP")
    public void testChangeXPCook() {
        Assertions.assertNotNull(cook1.getExperience());
        Assertions.assertEquals(0, cook1.getExperience());
        cook1.changeExperience(3);
        Assertions.assertEquals(3, cook1.getExperience());

    }

    @Test
    @DisplayName("changement caractéristiques")
    public void testChangeCarac() {

        cook1.changeCaracteristique(3, 6, 7, 45);
        Assertions.assertNotNull(cook1.getStrength());
        Assertions.assertNotNull(cook1.getDexterity());
        Assertions.assertNotNull(cook1.getLuck());
        Assertions.assertNotNull(cook1.getCreativity());
        Assertions.assertEquals(4, cook1.getStrength());
        Assertions.assertEquals(7, cook1.getDexterity());
        Assertions.assertEquals(8, cook1.getCreativity());
        Assertions.assertEquals(45, cook1.getLuck());
        cook1.changeCaracteristique(0, 0, 0, 0);
        Assertions.assertNotNull(cook1.getStrength());
        Assertions.assertNotNull(cook1.getDexterity());
        Assertions.assertNotNull(cook1.getLuck());
        Assertions.assertNotNull(cook1.getCreativity());
        Assertions.assertEquals(4, cook1.getStrength());
        Assertions.assertEquals(7, cook1.getDexterity());
        Assertions.assertEquals(8, cook1.getCreativity());
        Assertions.assertEquals(45, cook1.getLuck());
    }

    @Test
    @DisplayName("add lesson")
    public void addcooklessons() {
        cook1.addLesson(cooklesson);
        Assertions.assertEquals(1, cook1.getCookLessons().toArray().length);
        Assertions.assertEquals(cooklesson, cook1.getCookLessons().get(0));
        cook1.addLesson(cooklesson);
        Assertions.assertEquals(2, cook1.getCookLessons().toArray().length);
        Assertions.assertEquals(cooklesson, cook1.getCookLessons().get(1));
    }

}

