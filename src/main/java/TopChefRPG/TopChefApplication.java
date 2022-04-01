package TopChefRPG;


import TopChefRPG.Service.*;

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

    public static void main(String[] args) {
        SpringApplication.run(TopChefApplication.class, args);

    }

    @EventListener(classes = {ApplicationStartedEvent.class})
    public void applicationStarted() {
        /*
        List<User> users = userService.findAll();
        System.out.println("passe ici");
        for (User user : users) {
            System.out.println(user.getName());
        }
        int id = 1;
        String userName = "user6";
        userService.create(userName);
        User testUser = userService.findById(id);
        String CookName = userName + "Cook";
        Cook cook = cookService.createCook(CookName, 'M', testUser);
        recipeService.createRecipes();
        Cook test = cookService.getCookById(1);

        System.out.println(cook.toString());
        cookService.changeName(cook, "El gringo");
        System.out.println("après changement du cook par update (save)");
        System.out.println(cook.toString());
        List<Recipe> recettes = recipeService.getRecipes();
        for (Recipe re : recettes) {
            System.out.println(re.getName() + " " + re.getLooting1Name() + " " + re.lootIngredient.toString());
        }

        // code de test de suppression en cascade
        User adieu = userService.create("Adieu");

        Cook goodBye = cookService.createCook("goodbye", 'F', adieu);

        userService.deleteUser(adieu);
        lessonService.initializeLesson();

        cookLessonService.buyLesson(cookService.getCookById(1), lessonService.getLessonById(1));
        cookLessonService.buyLesson(cookService.getCookById(1), lessonService.getLessonById(2));
        List<CookLesson> toto = cookLessonService.getCookLesson(cookService.getCookById(1));

        for (CookLesson cl : toto)
            System.out.println(cl.toString());
        */
    }

}
