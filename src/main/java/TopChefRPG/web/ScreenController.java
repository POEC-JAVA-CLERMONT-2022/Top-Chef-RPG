package TopChefRPG.web;

import TopChefRPG.Service.CookService;
import TopChefRPG.Service.DTO.RecipeDTO;
import TopChefRPG.Service.DTO.ScreenDataDTO;
import TopChefRPG.Service.RecipeService;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/screenData")
public class ScreenController {

    @Autowired
    CookService cookService;

    @Autowired
    RecipeService recipeService;





    //http://localhost:8080/screenData?idCook=1
    @GetMapping()
    public ScreenDataDTO getDataForScreen(@RequestParam int idCook)
    {
        // tester si le cook existe
        if (cookService.getCookById(idCook) != null) {
            // récupération du cook
            Cook cook = cookService.getCookById(idCook);
            ArrayList<RecipeDTO> recipeDTOs = new ArrayList<>();
            for (Recipe recipe : recipeService.getRecipes()) {
                RecipeDTO recipeDTO = new RecipeDTO(recipe, cook);
                recipeDTOs.add(recipeDTO);
            }
            return new ScreenDataDTO(cook, recipeDTOs);
        }
        else
        {
            return new ScreenDataDTO("Cook not find !");
        }
    }
}
