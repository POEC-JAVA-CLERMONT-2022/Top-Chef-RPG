package TopChefRPG.web;

import TopChefRPG.Service.UserService;
import TopChefRPG.model.Cook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

}
