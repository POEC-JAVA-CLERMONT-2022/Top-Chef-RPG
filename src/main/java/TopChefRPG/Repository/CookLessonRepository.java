package TopChefRPG.Repository;


import TopChefRPG.model.Cook;
import TopChefRPG.model.CookLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CookLessonRepository extends JpaRepository<CookLesson, Integer> {




    @Query("select c from CookLesson c where c.cook = ?1")
    List<CookLesson> findCookLessonByCook(Cook cook);
    }


