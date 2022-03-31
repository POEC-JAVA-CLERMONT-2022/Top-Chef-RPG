package TopChefRPG.Service;


import TopChefRPG.Repository.LessonRepository;
import TopChefRPG.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

    @Autowired
    LessonRepository lessonRepository;

    public void initializeLesson() {
        Lesson lesson1 = new Lesson("couteaux japonais", 10, 10, 10, 10, 100);
        lessonRepository.save(lesson1);

        Lesson lesson2 = new Lesson("cuisson à la poele", 20, 25, 30, 30, 300);
        lessonRepository.save(lesson2);

        Lesson lesson3 = new Lesson("cuisson au four", 30, 30, 3, 2, 3000);
        lessonRepository.save(lesson3);

    }

    public Lesson getLessonById(int Id) {
        return lessonRepository.getById(Id);
    }
}
