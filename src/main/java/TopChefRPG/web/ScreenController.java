package TopChefRPG.web;

import TopChefRPG.Service.CookService;
import TopChefRPG.Service.DTO.ScreenDataDTO;
import TopChefRPG.model.Cook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/screenData")
public class ScreenController {

    @Autowired
    CookService cookService;

    //http://localhost:8080/screenData?idCook=1
    @GetMapping()
    public ScreenDataDTO getDataForScreen(@RequestParam int idCook)
    {
        // tester si le cook existe

        // récupération du cook
        Cook cook = cookService.getCookById(idCook);

        return new ScreenDataDTO(cook);
    }


}
