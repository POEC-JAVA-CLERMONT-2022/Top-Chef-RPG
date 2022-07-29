package TopChefRPG.Repository;

import TopChefRPG.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer>
{

    Optional<Owner> findOwnerByMailAndPassword (String mail, String password);
}
