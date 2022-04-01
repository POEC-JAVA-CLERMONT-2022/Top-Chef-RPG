package TopChefRPG.Repository;

import TopChefRPG.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
    User findByName(String name);

    @Query("select u from User u where u.mail = ?1 and u.password = ?2")
    Optional<User> findUserByMailAndPassword (String mail, String password);
}
