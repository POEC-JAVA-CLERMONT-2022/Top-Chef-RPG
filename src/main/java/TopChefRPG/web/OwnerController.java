package TopChefRPG.web;

import TopChefRPG.Exception.ErrorType;
import TopChefRPG.Exception.TopChefException;
import TopChefRPG.Service.CookService;
import TopChefRPG.Service.DTO.CookDTO;
import TopChefRPG.Service.OwnerService;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class OwnerController {


    OwnerService ownerService;

    CookService cookService;
    @Autowired
    public OwnerController(OwnerService ownerService, CookService cookService)
    {
        this.ownerService = ownerService;
        this.cookService = cookService;
    }

    @GetMapping("/{id}/name")
    public ResponseEntity<String> getOwnerById(@PathVariable int id) {
        Owner ownerFind = ownerService.findById(id);
        if (ownerFind.getId() ==0)
        {
            // si on a pas le User en BDD on jette cette exception
            // permet l'appel du error controller sur ce type précis d'exception
            throw new TopChefException(ErrorType.NO_DATA,"No User find in BDD with id : "+ id , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ownerFind.getName(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delOwnerById(@PathVariable int id) {
        ownerService.deleteOwner(id);
    }

    @PostMapping("/createCook/{idOwner}")
    public int createCook(@RequestBody CookDTO cook, @PathVariable int idOwner)
    {
        Owner owner = ownerService.findById(idOwner);
        Cook cookreturned = cookService.createCook(cook.getName(), 'M', owner);
        return cookreturned.getId();
    }
}