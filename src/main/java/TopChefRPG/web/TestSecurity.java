package TopChefRPG.web;

import TopChefRPG.Repository.CookRepository;
import TopChefRPG.Repository.IngredientRepository;
import TopChefRPG.Repository.UserRepository;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Ingredient;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.function.Supplier;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping("/api")
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
    public String test (){
        return "hopla ça passe";
    }

    @GetMapping( "/testJson")
    public Ingredient testGetJson () {
        Ingredient ingredient = ingredientRepository.getById(1);
        return ingredient;
    }
}
