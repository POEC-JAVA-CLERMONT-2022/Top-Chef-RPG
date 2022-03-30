package TopChefRPG.Repository;


import TopChefRPG.model.CookLesson;
import TopChefRPG.model.CookLessonPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CookLessonRepository extends JpaRepository<CookLesson, CookLessonPK> {
}
