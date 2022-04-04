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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


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
    public void testCreateCook() {

        //instantiation donnée


        User paulo = userService.create("paulo", "mail", "password");



        Cook cook1 = new Cook("alexandre", 'M', paulo);
        Cook cook2 = new Cook("alexandra", 'F', paulo);

        //appel de la méthode à tester


        cook1 = cookService.saveCook(cook1);
        cookService.saveCook(cook2);
        Integer test = cook1.getId();
        System.out.println("test= " + test);

        cook1.setName("boris");


        //LinkedList<Cook> cookList = new LinkedList<Cook>();

        //Cook cook3 = cookRepository.getCookByName("boris");
        //test des valeurs après execution du code

        Assertions.assertNotNull(cook1);
        //Assertions.assertEquals("boris", cook1.getName());
        Assertions.assertEquals("boris", cookService.getCookById(cook1.getId()).getName());

        Assertions.assertNotEquals(1, cookRepository.findAll().size());

        //Assertions.assertEquals(2, cookList.size() );

        //Assertions.assertEquals("toto", "toto");
        //Assertions.assertEquals(2, recettes.size());
    }
}
