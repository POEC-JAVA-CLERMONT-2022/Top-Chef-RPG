package TopChefRPG.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSecurity {

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
}
