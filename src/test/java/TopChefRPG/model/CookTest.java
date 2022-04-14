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

    
    @Autowired
    UserService userService;

    @Autowired
    CookService cookService;

    @Mock
    CookRepository mockcookRepository;

    @Autowired
    RecipeService recipeService;


@BeforeEach
public void varInitialize(){
    User paulo = userService.create("paulo", "mail", "password");
    Cook cook1 = new Cook("alexandre", 'M', paulo);
    Cook cook2 = new Cook("alexandra", 'F', paulo);
}

    @Test

    @DisplayName("Save Cook")
    public void testSaveCook() {

        //instantiation donnée

        
       


        //appel de la méthode à tester


        //cook1 = cookService.saveCook(cook1);
        //cookService.saveCook(cook2);
        System.out.println("toto)");
        //test des valeurs après execution du code
        //test si l'id de cook 1 = 1'
        Assertions.assertEquals("alexandre", mockcookRepository.getCookById(cook1.getId()).getName());
        //test du nombre de cook créés
        //Assertions.assertEquals(2, cookRepository.findAll().size());

    }

    @Test
    @DisplayName("test create cook")
    public void testCreateCook(){

        User paulo = userService.create("paulo", "mail","password");


        Cook cook1 = cookService.createCook("alexandre", 'M', paulo);

        Assertions.assertNotNull(cook1);

    }


    @Test
    @DisplayName("changement de nom du cook")
    public void TestChangeName() {

        //instantiation donnée
        User paulo = userService.create("paulo","mail", "pass");


        Cook cook1 = new Cook("alexandre", 'M', paulo);

        Cook cookenbase = cookService.saveCook(cook1);


        //methode à tester
        cookService.changeName(cookenbase, "stephane");


        Assertions.assertEquals("stephane", cookService.getCookById(cookenbase.getId()).getName());

    }
        @Test
        @DisplayName("changement d'XP")
        public void testChangeXPCook()
        {
            




            cook1.changeExperience(3);

            mockcookRepository.save(cook1);

            Assertions.assertEquals(3, cookService.getCookById(cook1.getId()).getExperience());

    }



}

