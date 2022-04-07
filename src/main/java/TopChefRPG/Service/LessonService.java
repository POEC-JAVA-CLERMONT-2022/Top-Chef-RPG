package TopChefRPG.Service;


import TopChefRPG.Repository.LessonRepository;
import TopChefRPG.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    LessonRepository lessonRepository;

    public void initializeLesson() {
        Lesson lesson1 = new Lesson("couteaux japonais", 10, 10, 10, 10, 100, "pomme", 20);
        lessonRepository.save(lesson1);

        Lesson lesson2 = new Lesson("cuisson à la poele", 20, 25, 30, 30, 300, "patate", 30);
        lessonRepository.save(lesson2);

        Lesson lesson3 = new Lesson("cuisson au four", 30, 20, 40, 20, 600, "steak", 15);
        lessonRepository.save(lesson3);

    }

    public Lesson getLessonById(int Id) {
        return lessonRepository.getLessonById(Id);
    }

    public List<Lesson> getAllLessons()
    {
        return lessonRepository.findAll();
    }
}
