package TopChefRPG.Service;

import TopChefRPG.Exception.ErrorType;
import TopChefRPG.Exception.TopChefException;
import TopChefRPG.Repository.CookRepository;
import TopChefRPG.Repository.OwnerRepository;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;

    private CookRepository cookRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository, CookRepository cookRepository) {
        this.ownerRepository = ownerRepository;
        this.cookRepository = cookRepository;
    }

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @Transactional
    public Owner create(String name, String mail, String password) {
        Owner user = new Owner(name, mail, password);
        return ownerRepository.save(user);
    }

    public Owner findById(int id) {
        return ownerRepository.findById(id).orElse(new Owner());
    }

    public Owner saveUser(Owner owner) {
        return ownerRepository.save(owner);
    }

    // inutile pour le moment mais pourrait servir avec l'authentification
    public Optional<Owner> findOwnerByMailAndPassword(String mail, String password) {
        return ownerRepository.findOwnerByMailAndPassword(mail, password);
    }

    // fonction non utile si l'on garde le fetch EAGER dans l'entity
    public List<Cook> getAllCooks(Owner owner) {
        return cookRepository.getCooksByOwner(owner);
    }

    public void deleteOwner(int id) {

        if (ownerRepository.existsById(id)) {
            ownerRepository.deleteById(id);
        } else {
            throw new TopChefException(ErrorType.NO_DATA, "no Owner are in BDD with ID : " + id + ". Impossible to delete", HttpStatus.NOT_FOUND);
        }

    }

    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

}
