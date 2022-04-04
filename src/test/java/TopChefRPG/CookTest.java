package TopChefRPG;

import TopChefRPG.Repository.CookRepository;
import TopChefRPG.Repository.UserRepository;
import TopChefRPG.Service.CookService;
import TopChefRPG.Service.RecipeService;
import TopChefRPG.Service.UserService;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Recipe;
import TopChefRPG.model.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.internal.bytebuddy.dynamic.scaffold.MethodGraph;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import java.util.function.BooleanSupplier;
import java.util.function.Function;

@SpringBootTest

public class CookTest {

    @Autowired
    UserService userService;

    @Autowired
    CookService cookService;

    @Autowired
    CookRepository cookRepository;

    @Autowired
    RecipeService recipeService;


    @Test

    @DisplayName("Save Cook")
    public void testSaveCook() {

        //instantiation donnée

        User paulo = userService.create("paulo", "mail", "password");



        Cook cook1 = new Cook("alexandre", 'M', paulo);
        Cook cook2 = new Cook("alexandra", 'F', paulo);


        //appel de la méthode à tester


        cook1 = cookService.saveCook(cook1);
        //cookService.saveCook(cook2);
        System.out.println("toto)");
        //test des valeurs après execution du code
        //test si l'id de cook 1 = 1'
        Assertions.assertEquals("alexandre", cookRepository.getCookById(cook1.getId()).getName());
        //test du nombre de cook créés
        //Assertions.assertEquals(2, cookRepository.findAll().size());

    }

    @Test
    @DisplayName("test create cook")
    public void testCreateCook(){

        User paulo = userService.create("paulo");


        Cook cook1 = cookService.createCook("alexandre", 'M', paulo);

        Assertions.assertNotNull(cook1);

    }


    @Test
    @DisplayName("changement de nom du cook")
    public void TestChangeName() {

        //instantiation donnée
        User paulo = userService.create("paulo");


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
            User paulo = userService.create("paulo");
            Cook cook1 = new Cook("alexandre", 'M', paulo);

            cookRepository.save(cook1);

            cook1.changeExperience(3);

            cookRepository.save(cook1);

            Assertions.assertEquals(3, cookService.getCookById(cook1.getId()).getExperience());

    }
}

