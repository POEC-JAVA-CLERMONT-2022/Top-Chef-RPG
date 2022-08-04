package TopChefRPG.Service;

import TopChefRPG.Exception.ErrorType;
import TopChefRPG.Exception.TopChefException;
import TopChefRPG.Repository.CookRepository;
import TopChefRPG.Repository.UserRepository;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Owner;
import TopChefRPG.model.User;
import TopChefRPG.model.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    private CookRepository cookRepository;


    @Autowired
    public UserService(UserRepository userRepository, CookRepository cookRepository) {
        this.userRepository = userRepository;
        this.cookRepository = cookRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User create(String name, String mail, String password) {
        User user = new User(name, mail, password);
        return userRepository.save(user);
    }

    public User findById(int id) {
        return userRepository.findById(id).orElse(new User());
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // inutile pour le moment mais pourrait servir avec l'authentification
    public Optional<User> findUserByMailAndPassword(String mail, String password) {
        return userRepository.findUserByMailAndPassword(mail, password);
    }

    // fonction non utile si l'on garde le fetch EAGER dans l'entity
    public List<Cook> getAllCooks(User user) {
        return cookRepository.getCooksByUser(user);
    }

    public void deleteUser(int id) {

        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new TopChefException(ErrorType.NO_DATA, "no Owner are in BDD with ID : " + id + ". Impossible to delete", HttpStatus.NOT_FOUND);
        }
    }

    public boolean userExistByName (String userName)
    {
        Optional<User> result = userRepository.findByUserName(userName);
        return result.isPresent();
    }
    public boolean userExistByMail (String mail){
        Optional<User> result = userRepository.findUserByMail(mail);
        return result.isPresent();
    }


    public User findContextUser() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findUserByUserName(userDetails.getUsername());
    }

    public User save(User user) {
        return userRepository.save(user);
    }

}
