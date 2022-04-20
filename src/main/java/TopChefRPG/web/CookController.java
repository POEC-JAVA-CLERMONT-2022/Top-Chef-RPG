package TopChefRPG.web;


import TopChefRPG.Service.CookService;
import TopChefRPG.Service.DTO.CookDTO;
import TopChefRPG.model.Cook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cook")
public class CookController {
    @Autowired
    CookService cookService;


    //http://localhost:8080/cook/1
    @GetMapping("/{id}")
    public CookDTO getCookById(@PathVariable int id)
    {
        CookDTO cookDTO = new CookDTO();
        cookDTO.setCookDTO(cookService.getCookById(id));
        return cookDTO;
    }

    @GetMapping("/{id}/delete")
    public void delCookById(@PathVariable int id)
    {
        cookService.delCookById(id);
    }
    @PostMapping(path = "/changeName/{idCook}")
    public void changeName(@RequestBody CookDTO cookDTO, @PathVariable int idCook) {
        Cook cook = cookService.getCookById(idCook);
        cookService.changeName(cook, cookDTO.getNewName());
    }
}
