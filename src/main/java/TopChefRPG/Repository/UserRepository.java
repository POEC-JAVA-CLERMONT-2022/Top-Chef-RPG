package TopChefRPG.Repository;

import TopChefRPG.model.Owner;
import TopChefRPG.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUserName(String username);

    Optional<User> findByUserName(String userName);

    Optional<User> findOwnerByMailAndPassword(String mail, String password);
}
