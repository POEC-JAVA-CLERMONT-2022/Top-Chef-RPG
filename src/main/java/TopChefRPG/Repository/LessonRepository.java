package TopChefRPG.Repository;



import TopChefRPG.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LessonRepository extends JpaRepository<Lesson,Integer> {


    Lesson findByName(String name);

    Lesson getLessonById(int id);


}
