package TopChefRPG.web;
import TopChefRPG.Service.CookService;
import TopChefRPG.Service.DTO.RecipeDTO;
import TopChefRPG.Service.DTO.ResultRecipeDTO;
import TopChefRPG.Service.RecipeService;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    CookService cookService;

    @GetMapping("/recipes/{idCook}")
    public List<RecipeDTO> getRecipe(@PathVariable int idCook)
    {
        return recipeService.getRecipesDTO(idCook);
    }


    //localhost:8080/recipe/doRecipe/1/2
    @GetMapping("/doRecipe/{idCook}/{idRecipe}")
    public ResultRecipeDTO doRecipe(@PathVariable int idCook, @PathVariable int idRecipe)
    {
        Cook cook = cookService.getCookById(idCook);
        Recipe recipe = recipeService.getRecipe(idRecipe);
        ResultRecipeDTO result = cookService.tryRecipe(recipe.getIdRecipe(), cook);
        return result;
    }

}
