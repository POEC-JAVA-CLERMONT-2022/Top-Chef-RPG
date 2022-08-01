package TopChefRPG.web;

import TopChefRPG.Exception.ErrorType;
import TopChefRPG.Exception.TopChefException;
import TopChefRPG.Service.CookService;
import TopChefRPG.Service.DTO.CookDTO;
import TopChefRPG.Service.UserService;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Owner;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {


    UserService userService;

    CookService cookService;
    @Autowired
    public UserController(UserService userService, CookService cookService)
    {
        this.userService = userService;
        this.cookService = cookService;
    }

    @GetMapping("/{id}/name")
    public ResponseEntity<String> getOwnerById(@PathVariable int id) {
        User userFind = userService.findById(id);
        if (userFind.getId() ==0)
        {
            // si on a pas le User en BDD on jette cette exception
            // permet l'appel du error controller sur ce type précis d'exception
            throw new TopChefException(ErrorType.NO_DATA,"No User find in BDD with id : "+ id , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userFind.getUserName(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delOwnerById(@PathVariable int id) {
        userService.deleteOwner(id);
    }

    @PostMapping("/createCook/{idOwner}")
    public int createCook(@RequestBody CookDTO cook, @PathVariable int idUser)
    {
        User user = userService.findById(idUser);
        Cook cookreturned = cookService.createCook(cook.getName(), 'M', user);
        return cookreturned.getId();
    }
}