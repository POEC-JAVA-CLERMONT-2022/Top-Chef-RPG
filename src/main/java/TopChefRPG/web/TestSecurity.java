package TopChefRPG.web;

import TopChefRPG.Repository.CookRepository;
import TopChefRPG.Repository.IngredientRepository;
import TopChefRPG.Repository.UserRepository;
import TopChefRPG.Service.DTO.IngredientDTO;
import TopChefRPG.Service.DTO.LoginDTO;
import TopChefRPG.Service.IngredientService;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Ingredient;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.function.Supplier;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600, allowedHeaders ="*")
@RequestMapping(value="/api")
public class TestSecurity {
    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping ("/")
    public String acceuil(){
        return ("<h1> noob</h1>");
    }

    @GetMapping ("/user")
    public String user (){
        return ("<h1> userpage</h1>");
    }

    @GetMapping ("/admin")
    public String admin (){
        return ("<h1> admin pages</h1>");
    }

    @GetMapping( "/test")
    public ResponseEntity<String> test (){
        return new ResponseEntity("hopla ça passe",HttpStatus.OK);
    }

    @GetMapping( value="/testJson", produces="application/json")
    public ResponseEntity<IngredientDTO> testGetJson () {
        Ingredient ingredient = ingredientRepository.getById(1);
        IngredientDTO ingredientDTO = new IngredientDTO(ingredient);
        return new ResponseEntity<>(ingredientDTO, HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<String> registerUser(@Valid @RequestBody LoginDTO loginDTO){
        System.out.println(loginDTO);
        return new ResponseEntity<>("Pa passe ici", HttpStatus.OK);
    }
}
