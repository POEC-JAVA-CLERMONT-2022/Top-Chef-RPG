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

    public void buyLesson(Cook cook, Lesson lesson){
        CookLesson cookLesson = new CookLesson(cook, lesson);
        cookLessonRepository.save(cookLesson);
    }

    public List<CookLesson> getCookLesson(Cook cook){
        return cookLessonRepository.findCookLessonByCook (cook);
    }
}
