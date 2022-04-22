package TopChefRPG.Service;
import TopChefRPG.Repository.LessonRepository;
import TopChefRPG.Service.DTO.LessonDTO;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService {

    LessonRepository lessonRepository;

    CookLessonService cookLessonService;

    @Autowired
    public LessonService(LessonRepository lessonRepository,CookLessonService cookLessonService){
        this.lessonRepository =lessonRepository;
        this.cookLessonService = cookLessonService;
    }
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

    public List<LessonDTO> getLessonsBuyed (Cook cook)
    {
        List<LessonDTO> lessonDTOS = new ArrayList<>();
        for (Lesson lesson : cookLessonService.getLessonsOfCook(cook))
        {
            LessonDTO lessonDTO = new LessonDTO(lesson);
            lessonDTOS.add(lessonDTO);
        }
        return lessonDTOS;
    }

    public List<LessonDTO> getLessonsNotOwned (Cook cook)
    {
        List<Lesson> lessons = getAllLessons();
        List<Lesson> ownedLessons = cookLessonService.getLessonsOfCook(cook);
        List<LessonDTO> notOwnedLessons =new ArrayList<>();

        // on parcourt la liste des lessons achetées et on les retire de la liste générale de leçons.
        for (Lesson lessonowned : ownedLessons)
        {
            lessons.removeIf(lesson -> lessonowned == lesson);
        }
        // on rempli la liste de lessons non achetées
        for(Lesson notOwnedLesson : lessons)
        {
            notOwnedLessons.add(new LessonDTO(notOwnedLesson));
        }
        return notOwnedLessons;
    }
}
