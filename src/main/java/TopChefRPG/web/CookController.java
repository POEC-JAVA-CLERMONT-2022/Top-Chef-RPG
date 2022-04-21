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
    public CookDTO getCookById(@PathVariable int id)
    {
        CookDTO cookDTO = new CookDTO();
        cookDTO.initialiseCookDTO(cookService.getCookById(id));
        return cookDTO;
    }

    @GetMapping("/{id}/delete")
    public void delCookById(@PathVariable int id)
    {
        Cook cook = cookService.getCookById(id);
        cookService.delCookById(id);
    }
    @PostMapping( "/changeName/{idCook}")
    public void changeName(@RequestBody CookDTO cookDTO, @PathVariable int idCook) {
        Cook cook = cookService.getCookById(idCook);
        cookService.changeName(cook, cookDTO.getNewName());
    }

    //TODO pas le bon controller
    @PostMapping ("/createCook/{idUser}")
    public void createCook(@RequestBody CookDTO cookDTO, @PathVariable int idUser)
    {
        User user = userService.findById(idUser);
        cookService.createCook(cookDTO.getName(), cookDTO.getGender(), user);
    }
}
