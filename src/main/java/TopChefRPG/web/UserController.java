package TopChefRPG.web;

import TopChefRPG.Exception.ErrorType;
import TopChefRPG.Exception.TopChefException;
import TopChefRPG.Security.JwtUtils;
import TopChefRPG.Service.CookService;
import TopChefRPG.Service.DTO.CookDTO;
import TopChefRPG.Service.DTO.UserDTO;
import TopChefRPG.Service.UserService;
import TopChefRPG.Service.mapper.UserMapperImpl;
import TopChefRPG.model.Cook;
import TopChefRPG.model.User;
import TopChefRPG.model.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    UserService userService;

    JwtUtils jwtUtils;

    CookService cookService;

    UserMapperImpl userMapper;
    @Autowired
    public UserController(UserService userService, CookService cookService, JwtUtils jwtUtils, UserMapperImpl userMapper)
    {
        this.userService = userService;
        this.cookService = cookService;
        this.jwtUtils = jwtUtils;
        this.userMapper = userMapper;
    }

    @GetMapping("/getUser")
    @PreAuthorize("hasRole('USER')")
    public UserDTO getUser(@RequestHeader String authorization){
        if (StringUtils.hasText(authorization) && authorization.startsWith("Bearer "))
        {
            String userName = jwtUtils.getUserNameFromJwtToken(authorization.substring(7, authorization.length()));
            User user = userService.findContextUser();
            UserDTO userDTO = userMapper.UserToUserDTO(user);
            return userDTO;
        }
        else throw new TopChefException(ErrorType.NO_DATA, "no user found", HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}/name")
    public ResponseEntity<String> getUserById(@PathVariable int id) {
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
    public void delUserById(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PostMapping("/createCook/{idUser}")
    @PreAuthorize("hasRole('USER')")
    public int createCook(@RequestBody CookDTO cook, @PathVariable int idUser)
    {
        User user = userService.findById(idUser);
        Cook cookreturned = cookService.createCook(cook.getName(), 'M', user);
        return cookreturned.getId();
    }



}