package TopChefRPG.web;

import TopChefRPG.Service.DTO.LoginDTO;
import TopChefRPG.Service.UserService;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserService userService;





    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginDto){

        String token ="token";


        return ResponseEntity.ok("ok" );
    }
//@Valid @RequestBody LoginDTO loginDTO
    @GetMapping("/signin")
    public ResponseEntity<String> registerUser2(@Valid @RequestBody LoginDTO loginDTO){
        if (userService.userExistByName(loginDTO.getUserName())){
            return ResponseEntity.badRequest().body("Le nom est déjà utilisé");
        }
        if (userService.userExistByMail(loginDTO.getMail()))
        {
            return ResponseEntity.badRequest().body("Le mail est déjà associé à un compte");
        }
        User user = new User(loginDTO.getUserName(), loginDTO.getPassword(), loginDTO.getPassword());

        user.setRoles("ROLE_USER");
        userService.save(user);
        return ResponseEntity.ok("ca passe ici");
    }


}
