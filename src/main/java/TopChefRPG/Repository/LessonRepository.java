package TopChefRPG.Repository;



import TopChefRPG.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LessonRepository extends JpaRepository<Lesson,Long> {

    Lesson findByName(String name);

    @Override
    default Optional<Lesson> findById(Long aLong) {
        return null;
    }
}
