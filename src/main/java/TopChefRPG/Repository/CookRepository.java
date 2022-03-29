package TopChefRPG.Repository;

import TopChefRPG.model.Cook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookRepository extends JpaRepository<Cook,Long> {



}
