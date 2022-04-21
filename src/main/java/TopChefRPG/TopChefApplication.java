package TopChefRPG;


import TopChefRPG.Repository.IngredientListRepository;
import TopChefRPG.Repository.IngredientRepository;
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

    //TODO : à supprimer
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

    @Autowired
    private IngredientListRepository ingredientListRepository;

    public static void main(String[] args) {
        SpringApplication.run(TopChefApplication.class, args);

    }

    //TODO : à mettre dans les Tests
    @EventListener(classes = {ApplicationStartedEvent.class})
    public void applicationStarted() {
        if (ingredientListRepository.findAll().size()==0)
        {
            ingredientService.initializeIngredientListInBDD();
        }

        List<User> users = userService.findAll();
        int idUser;
        if (users.size() == 0) {
            User newUser = userService.create("userTest", "mymail@mail.com", "mdp");
            idUser = newUser.getId();
        } else {
            idUser = users.get(0).getId();
        }
        User user = userService.findById(idUser);

        List<Cook> cooks = userService.getAllCooks(user);
        Cook cook;
        if (cooks.size() == 0) {
            cook = cookService.createCook("superCook", 'M', user);
        } else {
            cook = cooks.get(0);
        }
        User user2 = userService.create("deleteMe", "mymail@toto.com","pass" );
        Cook cookdrop = cookService.createCook("dropme", 'F', user2);
        cookService.delCookById(cookdrop.getId());
        //var delete = userService.getAllCooks(user2).remove(cookdrop);
        //user2 = userService.saveUser(user2);


        // suppression marche sur le user
        //userService.deleteUser(user2.getId());
        //cookService.delCookById(cookdrop.getId());

        if (recipeService.getRecipes().size() == 0) {
            recipeService.createRecipes();
        }
        cook = cookService.getCookById(cook.getId());
/*

        while (cook.getIngredients().get(0).getIngredientQuantity() < 30) {
            ResultRecipeDTO rr = cookService.tryRecipe(1, cook);
        }

        while (cook.getIngredients().get(1).getIngredientQuantity() < 30)
        {
            ResultRecipeDTO rr = cookService.tryRecipe(2, cook);
        }*/


        List<Lesson> lessons = lessonService.getAllLessons();
        if (lessons.size() == 0) {
            lessonService.initializeLesson();
        }

        Lesson lesson = lessonService.getLessonById(1);

    }

}
