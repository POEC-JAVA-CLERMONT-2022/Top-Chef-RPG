package TopChefRPG.web;


import TopChefRPG.Service.CookService;
import TopChefRPG.model.Cook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cook")
public class CookController {
    @Autowired
    CookService cookService;

    //http://localhost:8080/cook/



    //http://localhost:8080/cook/id?id=1
    @GetMapping("/{id}")
    public Cook getCookById(@PathVariable int id)
    {
        Cook cookFind = cookService.getCookById(id);
        return cookFind;
        //return cookService.getCookById(id);
    }

    @GetMapping("/{id}/delete")
    public void delCookById(@PathVariable int id)
    {
        Cook cookDel = cookService.delCookById(id);
    }
    
   /* @PostMapping("/{id}")
    public Cook getCookById(@PathVariable int id)
    {
        Cook cookFind = cookService.getCookById();
        cookFind.setName();

    }*/
}
