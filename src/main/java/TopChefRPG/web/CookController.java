package TopChefRPG.web;


import TopChefRPG.Service.CookService;
import TopChefRPG.Service.DTO.CookDTO;
import TopChefRPG.Service.UserService;
import TopChefRPG.model.Cook;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cook")
public class CookController {
    @Autowired
    CookService cookService;

    @Autowired
    UserService userService;


    //http://localhost:8080/cook/1
    @GetMapping("/{id}")
    public Cook getCookById(@PathVariable int id)
    {
        return cookService.getCookById(id);
    }

    @GetMapping("/{id}/delete")
    public void delCookById(@PathVariable int id)
    {
        cookService.delCookById(id);
    }
    @PostMapping( "/changeName/{idCook}")
    public void changeName(@RequestBody CookDTO cookDTO, @PathVariable int idCook) {
        Cook cook = cookService.getCookById(idCook);
        cookService.changeName(cook, cookDTO.newName);
    }

    @PostMapping ("/createCook/{idUser}")
    public void createCook(@RequestBody CookDTO cookDTO, @PathVariable int idUser)
    {
        User user = userService.findById(idUser);
        cookService.createCook();
    }
}
