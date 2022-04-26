package TopChefRPG.Service;

import TopChefRPG.Repository.IngredientListRepository;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Lesson;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitializeBDDService {

    IngredientListRepository ingredientListRepository;

    IngredientService ingredientService;

    RecipeService recipeService;

    LessonService lessonService;

    UserService userService;

    CookService cookService;

    @Autowired
    public InitializeBDDService(IngredientListRepository ingredientListRepository, IngredientService ingredientService,
                                RecipeService recipeService, LessonService lessonService, UserService userService, CookService cookService) {
        this.ingredientListRepository = ingredientListRepository;
        this.ingredientService = ingredientService;
        this.recipeService = recipeService;
        this.lessonService = lessonService;
        this.userService = userService;
        this.cookService = cookService;
    }

    public InitializeBDDService() {
        setDatainBDD();
    }


    public void setDatainBDD() {
        // initialisation des ingrédients si vide
        if (ingredientListRepository.findAll().size() == 0) {
            ingredientService.initializeIngredientListInBDD();
        }
        // initialisation des recettes
        if (recipeService.getRecipes().size() == 0) {
            recipeService.createRecipes();
        }
        //initialisation des leçons.
        List<Lesson> lessons = lessonService.getAllLessons();
        if (lessons.size() == 0) {
            lessonService.initializeLesson();
        }

    }

    public void setUSerANdCookInBDD() {
        // inintialisation d'un context de données en BDD
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
        try {
            cookService.delCookById(cookdrop.getId());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        //var delete = userService.getAllCooks(user2).remove(cookdrop);
        //user2 = userService.saveUser(user2);


        // suppression marche sur le user
        //userService.deleteUser(user2.getId());
        //cookService.delCookById(cookdrop.getId());


        /*
        cook = cookService.getCookById(cook.getId());


        while (cook.getIngredients().get(0).getIngredientQuantity() < 30) {
            ResultRecipeDTO rr = cookService.tryRecipe(1, cook);
        }

        while (cook.getIngredients().get(1).getIngredientQuantity() < 30)
        {
            ResultRecipeDTO rr = cookService.tryRecipe(2, cook);
        }
*/


        //Lesson lesson = lessonService.getLessonById(1);
    }
}
