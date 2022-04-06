package TopChefRPG.Service;

import TopChefRPG.Repository.CookLessonRepository;
import TopChefRPG.Repository.CookRepository;
import TopChefRPG.model.Cook;
import TopChefRPG.model.CookLesson;
import TopChefRPG.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookLessonService {


    @Autowired
    private CookLessonRepository cookLessonRepository;

    @Autowired
    private CookRepository cookRepository;

    public Cook buyLesson(Cook cook, Lesson lesson){
        // tester si l'achat est possible en checkant la quantité d'ingrédients;

        CookLesson cookLesson = new CookLesson(cook, lesson);
        cook.addLesson(cookLesson);
        return cookRepository.save(cook);
    }

    public List<CookLesson> getCookLesson(Cook cook){
        return cookLessonRepository.findCookLessonByCook (cook);
    }

    public void doLesson (CookLesson cookLesson)
    {
        cookLesson.incrementCountUse();
    }
}
