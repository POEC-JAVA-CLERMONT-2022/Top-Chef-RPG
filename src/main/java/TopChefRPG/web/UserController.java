package TopChefRPG.web;

import TopChefRPG.Service.CookService;
import TopChefRPG.Service.DTO.CookDTO;
import TopChefRPG.Service.UserService;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String getUserById(@PathVariable int id) {
        User userFind = userService.findById(id);
        return userFind.getName();
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