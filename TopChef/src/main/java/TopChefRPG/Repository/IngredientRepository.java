package TopChefRPG.Repository;

import TopChefRPG.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IngredientRepository extends JpaRepository<User,Long>{
}