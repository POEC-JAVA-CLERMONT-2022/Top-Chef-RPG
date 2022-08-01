package TopChefRPG.model;

import TopChefRPG.Exception.ErrorType;
import TopChefRPG.Exception.TopChefException;
import TopChefRPG.Service.CookService;
import TopChefRPG.Service.RecipeService;
import TopChefRPG.Service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

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
    @DisplayName("changement d'XP Augmentation")
    public void changeExperienceTest_augmentation_xpupdated() {
        int previousXP = cook1.getExperience();
        int experienceGain = 10;
        cook1.changeExperience(experienceGain);
        Assertions.assertEquals(previousXP+experienceGain, cook1.getExperience());

    }
    @Test
    @DisplayName("changement d'XP baisse impossible")
    public void changeExperienceTest_downImpossible() {
        int impossibleDown = -cook1.getExperience() -1;
        TopChefException exception = Assert.assertThrows(TopChefException.class, ()-> cook1.changeExperience(impossibleDown));
        Assertions.assertEquals(ErrorType.INCORRECT_DATA, exception.getExceptionType());
        Assertions.assertEquals("impossible de changer l'expérience à une valeure inférieur à 0 !", exception.getExceptionDescription());
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getHttpStatus());
    }
    @Test
    @DisplayName("changement d'XP baisse possible")
    public void changeExperienceTest_down_Ok() {
        int possibleDown = -cook1.getExperience();
        cook1.changeExperience(possibleDown);
        Assertions.assertEquals(0, cook1.getExperience());
    }

    @Test
    @DisplayName("changement caractéristiques")
    public void testChangeCarac() {
        int actualStrength = cook1.getStrength();
        int actualDexterity = cook1.getDexterity();
        int actualCreativity = cook1.getCreativity();
        int actualLuck = cook1.getLuck();
        cook1.changeCaracteristique(0,0,0,0);
        Assertions.assertEquals(actualStrength, cook1.getStrength());
        Assertions.assertEquals(actualDexterity, cook1.getDexterity());
        Assertions.assertEquals(actualCreativity, cook1.getCreativity());
        Assertions.assertEquals(actualLuck, cook1.getLuck());

        cook1.changeCaracteristique(10,20,30,40);
        Assertions.assertEquals(actualStrength+10, cook1.getStrength());
        Assertions.assertEquals(actualDexterity+20, cook1.getDexterity());
        Assertions.assertEquals(actualCreativity+30, cook1.getCreativity());
        Assertions.assertEquals(actualLuck+40, cook1.getLuck());
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

    @Test
    @DisplayName("Cook To String")
    public void toStringTest(){
        String name = cook1.getName();
        String exp = Integer.toString( cook1.getExperience());
        Assertions.assertEquals("nom : " + name + " ,experience : " + exp, cook1.toString());
    }


}

