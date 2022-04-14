package TopChefRPG.model;

import TopChefRPG.Repository.CookRepository;

import TopChefRPG.Service.CookService;
import TopChefRPG.Service.RecipeService;
import TopChefRPG.Service.UserService;
import TopChefRPG.model.Cook;

import TopChefRPG.model.User;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;


@SpringBootTest

@ExtendWith(MockitoExtension.class)

public class CookTest {

    Cook cook1;
    Cook cook2;
    User paulo;

    @Autowired
    UserService userService;

    @Autowired
    CookService cookService;



    @Autowired
    RecipeService recipeService;


@BeforeEach
public void varInitialize(){
    paulo = userService.create("paulo", "mail", "password");
    cook1 = new Cook("alexandre", 'M', paulo);
    cook2 = new Cook("alexandra", 'F', paulo);
}





    @Test
    @DisplayName("changement de nom du cook")
    public void TestChangeName() {

        //instantiation donnée

        //methode à tester
        Assertions.assertNotEquals("stephane", cook1.getName());
        cook1.setName("stephane");
        Assertions.assertEquals("stephane", cook1.getName());

    }
        @Test
        @DisplayName("changement d'XP")
        public void testChangeXPCook()
        {

            cook1.changeExperience(3);



            Assertions.assertEquals(3, cook1.getExperience());

    }



}

