package TopChefRPG.Service;

import TopChefRPG.Repository.UserRepository;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User create(String name)
    {
        User user = new User(name, "mail", "password");
        return userRepository.save(user);
    }

    public User findById(int id) {
        return userRepository.findById(id).orElse(new User());
    }

    public void saveUser(User user)
    {
        userRepository.save(user);
    }

    public User findByName(String name)
    {
        User user =  userRepository.findByName(name);
        return user;
    }

    public Optional<User> findUserByMailAndPassword (String mail, String password)
    {
        Optional<User> userFinded = userRepository.findUserByMailAndPassword(mail, password);
        return userFinded;
    }

    public void deleteUser(User userToDelete)
    {
        userRepository.deleteById(userToDelete.getId());
    }

}
