package TopChefRPG.Repository;

import TopChefRPG.model.Cook;
import TopChefRPG.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CookRepository extends JpaRepository<Cook, Integer> {

    void removeCookById(int id);

    Cook getCookById(int id);

    List<Cook> getCooksByUser(User user);


}
