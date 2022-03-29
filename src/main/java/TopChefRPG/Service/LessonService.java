package TopChefRPG.Service;


import TopChefRPG.Repository.LessonRepository;
import TopChefRPG.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

    @Autowired
    LessonRepository lessonRepository;

public void initializeLesson(){
    Lesson lesson1 = new Lesson("tarte aux pommes", 10, 10, 10);
    lessonRepository.save(lesson1);

    Lesson lesson2 = new Lesson("poulet fermier", 20, 25, 30);
    lessonRepository.save(lesson2);

    Lesson lesson3 = new Lesson("boeuf stroganoff", 30, 30, 3);
    lessonRepository.save(lesson3);

}


}
