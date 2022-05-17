package TopChefRPG.Service;
import TopChefRPG.Exception.ErrorType;
import TopChefRPG.Exception.TopChefException;
import TopChefRPG.Repository.LessonRepository;
import TopChefRPG.Service.DTO.LessonDTO;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        Lesson lesson0 = new Lesson("Epluchage pommes", 10, 10, 10, 10, 100, "pomme", 20);
        lessonRepository.save(lesson0);

        Lesson lesson1 = new Lesson("Taille de frites", 30, 10, 15, 10, 200, "patate", 20);
        lessonRepository.save(lesson1);

        Lesson lesson2 = new Lesson("pate à tarte", 20, 25, 30, 20, 300, "farine", 30);
        lessonRepository.save(lesson2);

        Lesson lesson3 = new Lesson("cuisson cocotte", 80, 60, 50, 40, 1200, "chou", 20);
        lessonRepository.save(lesson3);

        Lesson lesson4 = new Lesson("pate à pizza", 50, 80, 40, 30, 2000, "tomate", 30);
        lessonRepository.save(lesson4);

    }

    public Lesson getLessonById(int Id) {
        if (lessonRepository.existsById(Id))
        {
            return lessonRepository.getLessonById(Id);
        }
        else {
            throw  new TopChefException(ErrorType.WRONG_LESSON_ID, "Aucune lesson ne correspond à l'Id : "+ Id, HttpStatus.NOT_FOUND);
        }
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
        if (lessons.isEmpty())
        {
            throw new TopChefException(ErrorType.DATA_NOT_INITIALIZED_IN_BDD, "Aucune lecçon n'existe en BDD", HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
