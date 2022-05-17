package TopChefRPG.web;


import TopChefRPG.Exception.ErrorType;
import TopChefRPG.Exception.TopChefException;
import TopChefRPG.Service.*;
import TopChefRPG.Service.DTO.*;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Lesson;
import TopChefRPG.model.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/cook")
public class CookController {
    Logger logger = LoggerFactory.getLogger(CookController.class);

    CookService cookService;
    UserService userService;
    RecipeService recipeService;
    LessonService lessonService;
    CookLessonService cookLessonService;
    IngredientService ingredientService;

    @Autowired
    public CookController(CookService cookService, UserService userService, RecipeService recipeService,
                          LessonService lessonService, CookLessonService cookLessonService, IngredientService ingredientService) {
        this.cookService = cookService;
        this.userService = userService;
        this.recipeService = recipeService;
        this.lessonService = lessonService;
        this.cookLessonService = cookLessonService;
        this.ingredientService = ingredientService;
    }

    //http://localhost:8080/cook/1
    @GetMapping("/{id}")
    public ResponseEntity<CookDTO> getCookById(@PathVariable int id) {
        try {
            logger.info("given cook " + id+ " try to get data of Cook from BDD ");
            CookDTO cookDTO = new CookDTO();
            cookDTO.initialiseCookDTO(cookService.getCookById(id));
            return new ResponseEntity<> (cookDTO, HttpStatus.OK);
        }
        catch (Exception exception)
        {
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //http://localhost:8080/cook/changeName/cook/1
    @PostMapping("/changeName/{idCook}")
    public void changeName(@RequestBody CookDTO cookDTO, @PathVariable int idCook) {
        logger.info("changement du nom du cook {}", idCook);
        Cook cook = cookService.getCookById(idCook);
        if (!cookDTO.getNewName().equals( cookDTO.getName()) && cookDTO.getNewName().length()>0)
        {
            cookService.changeName(cook, cookDTO.getNewName());
        }
        else
        {
            String error = "" ;
            if (!Objects.equals(cookDTO.getNewName(), cookDTO.getName()))
            {
                error = "the new name is identical to the old name";
            }
            if (cookDTO.getNewName().length()>0)
            {
                error = " the new name is not defined or empty";
            }
            logger.error("impossible to change name : "+ error + " old name : " + cookDTO.getName()+ ", new Name : "+ cookDTO.getNewName());
            throw new TopChefException(ErrorType.INCORRECT_DATA, "impossible to change name : "+ error, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    //http://localhost:8080/cook/1
    @DeleteMapping("/{id}")
    public void delCookById(@PathVariable int id) {
        logger.info(" appel destruction du cook "+  id);
        cookService.delCookById(id);
    }


    //http://localhost:8080/cook/ingredients/1
    @GetMapping("/ingredients/{idCook}")
    public ResponseEntity<List<IngredientDTO>> getIngredients(@PathVariable int idCook) {
        return new ResponseEntity<>( ingredientService.getIngredientOfCook(idCook), HttpStatus.OK);
    }

    //http://localhost:8080/cook/getRecipe/1
    @GetMapping("/getRecipe/{idCook}")
    public List<RecipeDTO> getRecipe(@PathVariable int idCook) {
        Cook cook = cookService.getCookById(idCook);
        return recipeService.getRecipesDTO(cook);
    }

    //http://localhost:8080/cook/doRecipe/1/1
    @PostMapping("/doRecipe/{idCook}/{idRecipe}")
    public ResultRecipeDTO doRecipe(@PathVariable int idCook, @PathVariable int idRecipe) {
        Cook cook = cookService.getCookById(idCook);
        Recipe recipe = recipeService.getRecipe(idRecipe);
        return cookService.tryRecipe(recipe.getIdRecipe(), cook);
    }

    //http://localhost:8080/cook/lessons/tobuy/1
    @GetMapping("/lessons/toBuy/{idCook}")
    public List<LessonDTO> getLessonToBuy(@PathVariable int idCook) {
        Cook cook = cookService.getCookById(idCook);
        return lessonService.getLessonsNotOwned(cook);
    }

    //http://localhost:8080/cook/lessons/buy/1/1
    @PostMapping("/lessons/buy/{idCook}/{idLesson}")
    public void buyLesson(@PathVariable int idCook, @PathVariable int idLesson) {
        Cook cook = cookService.getCookById(idCook);
        Lesson lesson = lessonService.getLessonById(idLesson);
        cookLessonService.buyLesson(cook, lesson);
    }

    //http://localhost:8080/cook/lessons/ownedByCook/1
    @GetMapping("/lessons/ownedByCook/{idCook}")
    public List<LessonDTO> getLessonsOwned(@PathVariable int idCook) {
        Cook cook = cookService.getCookById(idCook);
        return lessonService.getLessonsBuyed(cook);
    }

    //http://localhost:8080/cook/lessons/doLesson/1/1
    @PostMapping("/lessons/doLesson/{idCook}/{idLesson}")
    public ResultLessonDTO doLesson(@PathVariable int idCook, @PathVariable int idLesson) {
        Cook cook = cookService.getCookById(idCook);
        return cookService.doLesson(idLesson, cook);
    }
}
