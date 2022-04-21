package TopChefRPG.Repository;

import TopChefRPG.model.Cook;

import TopChefRPG.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CookRepository extends JpaRepository<Cook, Integer> {


    void deleteCookById(int Id);


    //TODO à supprimer
    Cook getCookByName(String name);



    Cook getCookById(int id);

    @Query("select c from Cook c where c.user = ?1")
    List<Cook> getCooksByUser(User user);


}
