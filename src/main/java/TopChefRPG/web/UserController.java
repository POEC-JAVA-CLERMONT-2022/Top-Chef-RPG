package TopChefRPG.web;

import TopChefRPG.Exception.ErrorType;
import TopChefRPG.Exception.TopChefException;
import TopChefRPG.Service.CookService;
import TopChefRPG.Service.DTO.CookDTO;
import TopChefRPG.Service.UserService;
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
    public ResponseEntity<String> getUserById(@PathVariable int id) {
        try{
            User userFind = userService.findById(id);
            if (userFind.getId() ==0)
            {
                // si on a pas le User en BDD on jette cette exception
                // permet l'appel du error controller sur ce type précis d'exception
                throw new TopChefException(ErrorType.NO_DATA,"No User find in BDD with id : "+ id , HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(userFind.getName(), HttpStatus.OK);
        }
        catch (Exception exception)
        {
            // on jette une exception pour que ce soit capté par l'error controller
            throw exception;
        }


    }

    @PostMapping("/delete/{id}")
    public void delUserById(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PostMapping("/createCook/{idUser}")
    public void createCook(@RequestBody CookDTO cookDTO, @PathVariable int idUser)
    {
        User user = userService.findById(idUser);
        cookService.createCook(cookDTO.getName(), cookDTO.getGender(), user);
    }
}