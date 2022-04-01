package TopChefRPG;

import TopChefRPG.Repository.CookRepository;
import TopChefRPG.Repository.UserRepository;
import TopChefRPG.Service.CookService;
import TopChefRPG.Service.RecipeService;
import TopChefRPG.Service.UserService;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Recipe;
import TopChefRPG.model.User;
import org.assertj.core.internal.bytebuddy.dynamic.scaffold.MethodGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootTest

public class CookTest {

    @Autowired
    UserService userService;

    @Autowired
    CookService cookService;

    @Autowired
    RecipeService recipeService;

    @Test
    public void testCreateCook() {

        //instantiation donnée


        User paulo = userService.create("paulo");



        Cook cook1 = new Cook("alexandre", 'M', paulo);
        Cook cook2 = new Cook("alexandra", 'F', paulo);

        //appel de la méthode à tester


        cookService.saveCook(cook1);
        cookService.saveCook(cook2);
        cook1.setName("boris");
        cookService.saveCook(cook1);
        //LinkedList<Cook> cookList = new LinkedList<Cook>();

        //Cook cook3 = cookRepository.getCookByName("boris");
        //test des valeurs après execution du code

        Assertions.assertNotNull(cook1);
        Assertions.assertEquals("boris", cook1.getName());
        //Assertions.assertEquals(2, cookList.size() );

        //Assertions.assertEquals("toto", "toto");
        //Assertions.assertEquals(2, recettes.size());
    }
}
