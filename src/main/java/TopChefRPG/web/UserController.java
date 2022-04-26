package TopChefRPG.web;

import TopChefRPG.Exception.TopChefException;
import TopChefRPG.Service.CookService;
import TopChefRPG.Service.DTO.CookDTO;
import TopChefRPG.Service.UserService;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;


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
    public String getUserById(@PathVariable int id) {
        try{
            User userFind = userService.findById(id);
            if (userFind.getId() ==0)
            {
                // si l'on a pas le User en BDD on jette cette exception (à remplacer par une custom ?)
                // permet l'appel du error controller sur ce type précis d'exception
                throw new TopChefException();
            }
            return userFind.getName();
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