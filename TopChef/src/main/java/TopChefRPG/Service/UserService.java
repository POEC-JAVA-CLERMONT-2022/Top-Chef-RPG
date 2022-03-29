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
        return this.userRepository.save(user);
    }

    public User findById(Long id)
    {
        Optional< User>  findUser= userRepository.findById(id);
        if (findUser.isPresent())
            return findUser.get();
        else {
            System.out.println("user non trouvé en base de données");
            User emptyUser = new User();
            return emptyUser;
        }

    }

    public User findByName(String name)
    {
        User user =  userRepository.findByName(name);
        return user;
    }

}
