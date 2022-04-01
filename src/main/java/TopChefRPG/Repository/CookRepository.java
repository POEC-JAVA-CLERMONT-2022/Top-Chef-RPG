package TopChefRPG.Repository;

import TopChefRPG.model.Cook;

import TopChefRPG.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CookRepository extends JpaRepository<Cook,Integer> {


Cook getCookByName(String name);

@Query("select c from Cook c where c.id = ?1")
Cook getCookById(int id);


}
