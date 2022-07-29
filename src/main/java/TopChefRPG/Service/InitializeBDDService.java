package TopChefRPG.Service;

import TopChefRPG.Exception.ErrorType;
import TopChefRPG.Exception.TopChefException;
import TopChefRPG.Repository.IngredientListRepository;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Lesson;
import TopChefRPG.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitializeBDDService {

    IngredientListRepository ingredientListRepository;

    IngredientService ingredientService;

    RecipeService recipeService;

    LessonService lessonService;

    OwnerService ownerService;

    CookService cookService;

    @Autowired
    public InitializeBDDService(IngredientListRepository ingredientListRepository, IngredientService ingredientService,
                                RecipeService recipeService, LessonService lessonService, OwnerService ownerService, CookService cookService) {
        this.ingredientListRepository = ingredientListRepository;
        this.ingredientService = ingredientService;
        this.recipeService = recipeService;
        this.lessonService = lessonService;
        this.ownerService = ownerService;
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
        try{
            recipeService.getRecipes();
        }
        catch (TopChefException exception)
        {
            if (exception.getExceptionType() == ErrorType.DATA_NOT_INITIALIZED_IN_BDD) {
                recipeService.createRecipes();
            }
        }
        //initialisation des leçons.
        List<Lesson> lessons = lessonService.getAllLessons();
        if (lessons.size() == 0) {
            lessonService.initializeLesson();
        }

    }

    public void setUSerANdCookInBDD() {
        // inintialisation d'un context de données en BDD
        List<Owner> users = ownerService.findAll();
        int idUser;
        if (users.size() == 0) {
            Owner newUser = ownerService.create("userTest", "mymail@mail.com", "mdp");
            idUser = newUser.getId();
        } else {
            idUser = users.get(0).getId();
        }
        Owner user = ownerService.findById(idUser);

        List<Cook> cooks = ownerService.getAllCooks(user);
        Cook cook;
        if (cooks.size() == 0) {
            cookService.createCook("superCook", 'M', user);
        }
        Owner user2 = ownerService.create("deleteMe", "mymail@toto.com","pass" );
        Cook cookdrop = cookService.createCook("dropme", 'F', user2);
        try {
            cookService.delCookById(cookdrop.getId());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

    }
}
