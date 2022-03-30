package TopChefRPG.web;


import TopChefRPG.Service.CookService;
import TopChefRPG.model.Cook;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Cook")
public class CookController {
    @Autowired
    CookService cookService;

    @GetMapping("{id}")
    public Cook getCookById(@PathVariable int id)
    {
        return cookService.getCookById(id);
    }


}
