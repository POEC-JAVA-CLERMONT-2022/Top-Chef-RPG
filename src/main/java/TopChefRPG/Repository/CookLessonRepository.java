package TopChefRPG.Repository;


import TopChefRPG.model.Cook;
import TopChefRPG.model.CookLesson;
import TopChefRPG.model.CookLessonPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CookLessonRepository extends JpaRepository<CookLesson, CookLessonPK> {

    public List<CookLesson>findAllByCooklessons_Cook(Cook cook);

    }


