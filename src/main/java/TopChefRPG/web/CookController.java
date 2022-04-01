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

    @GetMapping()
    public String returnTest ()
    {
        return "ca marche";
    }
/*
    @GetMapping()
    public String getCookById(@PathVariable int id)
    {
        return "ca marche avec :"+ id;
        //return cookService.getCookById(id);
    }

*/
}
