package TopChefRPG;


import TopChefRPG.Service.*;

import TopChefRPG.Service.DTO.ResultRecipeDTO;
import TopChefRPG.model.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;


import java.util.List;


@SpringBootApplication
public class TopChefApplication {
    @Autowired
    private UserService userService;

    @Autowired
    private CookService cookService;

    @Autowired

    private LessonService lessonService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private CookLessonService cookLessonService;

    @Autowired
    private IngredientService ingredientService;

    public static void main(String[] args) {
        SpringApplication.run(TopChefApplication.class, args);

    }

    @EventListener(classes = {ApplicationStartedEvent.class})
    public void applicationStarted() {

        List<User> users = userService.findAll();
        int idUser ;
        if (users.size() == 0)
        {
            User newUser = userService.create("userTest", "mymail@mail.com", "mdp");
            idUser = newUser.getId();
        }
        else
        {
            idUser = users.get(0).getId();
        }
        User user = userService.findById(idUser);
        List<Cook> cooks = userService.getAllCooks(user);
        Cook cook;
        if (cooks.size() == 0)
        {
            cook = cookService.createCook("superCook",'M', user );
        }
        else
        {
            cook = cooks.get(0);
        }
        if (recipeService.getRecipes().size()==0) {
            recipeService.createRecipes();
        }
        while (cook.getIngredients().get(0).getIngredientQuantity() < 30)
        {
            ResultRecipeDTO rr = cookService.tryRecipe(1, cook);
        }
        /*
        while (cook.getIngredients().get(1).getIngredientQuantity() < 30)
        {
            ResultRecipeDTO rr = cookService.tryRecipe(2, cook);
        }*/


        lessonService.initializeLesson();

        System.out.println(cook.getIngredients().get(0).getName()+" " +cook.getIngredients().get(0).getIngredientQuantity());

    }

}
