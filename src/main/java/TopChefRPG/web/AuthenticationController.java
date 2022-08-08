package TopChefRPG.web;

import TopChefRPG.Security.JwtUtils;
import TopChefRPG.Service.DTO.EntityMessage;
import TopChefRPG.Service.DTO.LoginDTO;
import TopChefRPG.Service.UserService;
import TopChefRPG.model.User;
import TopChefRPG.model.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder encoder ;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;




    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUserName(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        loginDto.setToken(jwt);

        return ResponseEntity.ok(loginDto);
    }
//@Valid @RequestBody LoginDTO loginDTO
    @PostMapping(value="/signin", produces= "application/json")
    public ResponseEntity<EntityMessage> registerUser(@Valid @RequestBody LoginDTO loginDTO){
        EntityMessage message = new EntityMessage("Création du compte reussie", HttpStatus.OK);
        if (userService.userExistByName(loginDTO.getUserName())){
            message.message= "Le nom est déjà utilisé";
            message.httpStatus= HttpStatus.CONFLICT;
            return new ResponseEntity<>( message, message.httpStatus);
        }
        if (userService.userExistByMail(loginDTO.getMail()))
        {
            message.message= "Le mail est déjà utilisé";
            message.httpStatus= HttpStatus.CONFLICT;
            return new ResponseEntity<>( message, message.httpStatus);
        }

        User user = new User(loginDTO.getUserName(), loginDTO.getMail(), encoder.encode(loginDTO.getPassword()));

        user.setRoles("ROLE_USER");
        user.setActive(true);
        userService.save(user);
        return new ResponseEntity<>( message, message.httpStatus);
    }


}
