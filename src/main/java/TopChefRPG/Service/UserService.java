package TopChefRPG.Service;

import TopChefRPG.Repository.UserRepository;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public User findByName(String name)
    {
        User user =  userRepository.findByName(name);
        return user;
    }

}