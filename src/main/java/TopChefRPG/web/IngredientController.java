package TopChefRPG.web;

import TopChefRPG.Service.DTO.IngredientDTO;
import TopChefRPG.Service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/Ingredient/")
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @GetMapping("/{idCook}")
    public List<IngredientDTO> getIngredients(@PathVariable int idCook) {
        return ingredientService.getIngredientOfCook(idCook);
    }


}