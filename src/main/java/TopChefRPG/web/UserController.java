package TopChefRPG.web;

import TopChefRPG.Service.UserService;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public void returnTest() {

    }

    @GetMapping("/{id}/name")
    public String getUserById(@PathVariable int id) {
        User userFind = userService.findById(id);
        return userFind.getName();
    }


    @GetMapping("/{id}/delete")
    public void delUserById(@PathVariable int id) {
        userService.deleteUser(id);

    }
}