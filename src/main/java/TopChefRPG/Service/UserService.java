package TopChefRPG.Service;

import TopChefRPG.Repository.CookRepository;
import TopChefRPG.Repository.UserRepository;
import TopChefRPG.model.Cook;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    private CookRepository cookRepository;

    @Autowired
    public UserService(UserRepository userRepository,CookRepository cookRepository )
    {
        this.userRepository =userRepository;
        this.cookRepository=cookRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User create(String name, String mail, String password)
    {
        User user = new User(name, mail, password);
        return userRepository.save(user);
    }

    public User findById(int id) {
        return userRepository.findById(id).orElse(new User());
    }

    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    // inutile pour le moment mais pourrait servir avec l'authentification
    public Optional<User> findUserByMailAndPassword (String mail, String password)
    {
        return userRepository.findUserByMailAndPassword(mail, password);
    }

    // fonction non utile si l'on garde le fetch EAGER dans l'entity
    public List<Cook> getAllCooks (User user)
    {
        return cookRepository.getCooksByUser(user);
    }

    public void deleteUser(int id)
    {
        userRepository.deleteById(id);
    }
    public User save(User user)
    {
        return userRepository.save(user);
    }

}
