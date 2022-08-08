package TopChefRPG.Repository;
import TopChefRPG.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUserName(String username);

    Optional<User> findByUserName(String userName);

    Optional<User> findUserByMailAndPassword(String mail, String password);

    Optional<User> findUserByMail  (String mail);

}
