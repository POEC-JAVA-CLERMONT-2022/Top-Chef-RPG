package TopChefRPG.web;


import TopChefRPG.Service.*;
import TopChefRPG.Service.DTO.*;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Lesson;
import TopChefRPG.model.Recipe;
import TopChefRPG.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public CookDTO getCookById(@PathVariable int id) {
        logger.info("given cook {}", id);
        CookDTO cookDTO = new CookDTO();
        cookDTO.initialiseCookDTO(cookService.getCookById(id));
        return cookDTO;
    }

    //http://localhost:8080/cook/changeName/cook/1
    @PostMapping("/changeName/{idCook}")
    public void changeName(@RequestBody CookDTO cookDTO, @PathVariable int idCook) {
      logger.info("changement du nom du cook {}", idCook)   
      Cook cook = cookService.getCookById(idCook);
        cookService.changeName(cook, cookDTO.getNewName());
    }
    //http://localhost:8080/cook/delete/1
    @GetMapping("/delete/{id}")
    public void delCookById(@PathVariable int id) {
        logger.info("destruction du cook {} si il le veut bien, id");
        Cook cook = cookService.getCookById(id);
        cookService.delCookById(id);
    }


    //http://localhost:8080/cook/ingredients/1
    @GetMapping("/ingredients/{idCook}")
    public List<IngredientDTO> getIngredients(@PathVariable int idCook) {
        return ingredientService.getIngredientOfCook(idCook);
    }

    //http://localhost:8080/cook/changeName/1
    @GetMapping("/getRecipe/{idCook}")
    public List<RecipeDTO> getRecipe(@PathVariable int idCook) {      
      Cook cook = cookService.getCookById(idCook);
      return recipeService.getRecipesDTO(cook);
    }

    //http://localhost:8080/cook/doRecipe/1/1
    @GetMapping("/doRecipe/{idCook}/{idRecipe}")
    public ResultRecipeDTO doRecipe(@PathVariable int idCook, @PathVariable int idRecipe) {
        Cook cook = cookService.getCookById(idCook);
        Recipe recipe = recipeService.getRecipe(idRecipe);
        ResultRecipeDTO result = cookService.tryRecipe(recipe.getIdRecipe(), cook);
        return result;
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
