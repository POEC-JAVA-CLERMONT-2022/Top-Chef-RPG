package TopChefRPG.Repository;

import TopChefRPG.model.Cook;
<<<<<<< HEAD

import TopChefRPG.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
=======
import TopChefRPG.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> 69075f70c8cadef84adf9b9029e89d14a74106cf
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CookRepository extends JpaRepository<Cook, Integer> {


    void deleteCookById(int Id);
    void removeCookById(int id);

    Cook getCookById(int id);

    List<Cook> getCooksByUser(User user);


}
