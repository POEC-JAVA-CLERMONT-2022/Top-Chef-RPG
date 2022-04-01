package TopChefRPG.web;

import TopChefRPG.Service.CookService;
import TopChefRPG.Service.DTO.ResultRecipeDTO;
import TopChefRPG.Service.RecipeService;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    CookService cookService;

    @GetMapping()
    public String getRecipe()
    {
        return "toto";
    }



    //localhost:8080/recipe/getsucces?idCook=1&idRecipe=1
    @GetMapping("/getsucces")
    public int getChanceSucces(@RequestParam int idCook, @RequestParam int idRecipe)
    {
        Cook cook = cookService.getCookById(idCook);
        Recipe recipe = recipeService.getRecipe(idRecipe);
        int chance = recipeService.getChanceSucces(recipe,cook);
        return chance;
    }

    //localhost:8080/recipe/doRecipe?idCook=1&idRecipe=1
    @GetMapping("/doRecipe")
    public ResultRecipeDTO doRecipe(@RequestParam int idCook, @RequestParam int idRecipe)
    {
        Cook cook = cookService.getCookById(idCook);
        Recipe recipe = recipeService.getRecipe(idRecipe);
        ResultRecipeDTO result = cookService.tryRecipe(recipe.getIdRecipe(), cook);
        return result;
    }

}
