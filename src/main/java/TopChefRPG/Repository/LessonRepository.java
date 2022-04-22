package TopChefRPG.Repository;
import TopChefRPG.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Integer> {

    Lesson getLessonById(int id);


}
