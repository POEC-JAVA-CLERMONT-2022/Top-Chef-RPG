package TopChefRPG.web;


import TopChefRPG.Service.CookService;
import TopChefRPG.model.Cook;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cook")
public class CookController {
    @Autowired
    CookService cookService;

    //http://localhost:8080/cook/
    @GetMapping()
    public String returnTest ()
    {
        return "ca marche";
    }

    //http://localhost:8080/cook/id?id=1
    @GetMapping("/id")
    public Cook getCookById(@RequestParam int id)
    {
        Cook cookFind = cookService.getCookById(id);
        return cookFind;
        //return cookService.getCookById(id);
    }


}
