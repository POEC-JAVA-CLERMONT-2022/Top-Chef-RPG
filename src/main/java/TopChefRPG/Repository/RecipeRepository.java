package TopChefRPG.Repository;

import TopChefRPG.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository <Recipe,Integer>{



    Recipe getRecipeById(int id);

}
