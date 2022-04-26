package TopChefRPG.Repository;
import TopChefRPG.model.Cook;
import TopChefRPG.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface CookRepository extends JpaRepository<Cook, Integer> {

    @Query ("delete from Cook c where c.id = :id")
    @Modifying
    void deleteCookById(@Param("id") int id);
    //void removeCookById(int id);

    Cook getCookById(int id);

    List<Cook> getCooksByUser(User user);


}
