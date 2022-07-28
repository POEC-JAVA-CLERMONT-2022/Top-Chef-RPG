package TopChefRPG.Repository;


import TopChefRPG.model.Cook;
import TopChefRPG.model.Cook_Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CookLessonRepository extends JpaRepository<Cook_Lesson, Integer> {


    List<Cook_Lesson> findCookLessonByCook(Cook cook);
}


