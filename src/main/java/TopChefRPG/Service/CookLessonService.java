package TopChefRPG.Service;

import TopChefRPG.Exception.ErrorType;
import TopChefRPG.Exception.TopChefException;
import TopChefRPG.Repository.CookLessonRepository;
import TopChefRPG.Repository.CookRepository;
import TopChefRPG.model.Cook;
import TopChefRPG.model.Cook_Lesson;
import TopChefRPG.model.Ingredient;
import TopChefRPG.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CookLessonService {
    private final CookLessonRepository cookLessonRepository;
    private final CookRepository cookRepository;

    @Autowired
    public CookLessonService(CookLessonRepository cookLessonRepository, CookRepository cookRepository)
    {
        this.cookLessonRepository = cookLessonRepository;
        this.cookRepository = cookRepository;
    }

    public Cook buyLesson(Cook cook, Lesson lesson){

        // vérifier si le cook n'a pas déjà la lecon
        if (cook.getCookLessons().stream().anyMatch(cl-> cl.getLesson().getIdLesson()==lesson.getIdLesson())){
            throw  new TopChefException(ErrorType.ALLREADY_OWNED_LECON, "La leçon est déjà achetée par le Cook. Cook Id : "
                    + cook.getId() + ", lesson Id : "+ lesson.getIdLesson(), HttpStatus.NOT_ACCEPTABLE);
        }
        // si la lecon n'est pas encore achetée, on vérifie ensuite si il a ce qu'il faut comme ingredients requis
        else {
            // on parcourt la liste des ingrédients du cook pour trouver l'ingrédient requis pour l'achat.
            for (Ingredient ingCook : cook.getIngredients())
            {
                if (ingCook.getName().equals(lesson.getIngredientName()))
                {
                    // si le cook à assez d'ingrédients requis, on décrémente la quantité pour valider l'achat
                    if (ingCook.getIngredientQuantity() >= lesson.getIngredientQuantity())
                    {
                        ingCook.setIngredientQuantity(- lesson.getIngredientQuantity());
                        Cook_Lesson cookLesson = new Cook_Lesson(cook, lesson);
                        cook.addLesson(cookLesson);
                    }
                    else
                    {
                        throw new TopChefException(ErrorType.NOT_ENOUGH_INGREDIENT, "impossible d'effectuer le changement " +
                                "de quantité d'ingrédient, la valeure finale ne peut être négative", HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                }
            }
        }
        return cookRepository.save(cook);
    }

    public List<Cook_Lesson> getCookLesson(Cook cook){
        return cookLessonRepository.findCookLessonByCook (cook);
    }

    public List<Lesson> getLessonsOfCook(Cook cook)
    {
        List<Lesson> lessons = new ArrayList<>();
        for (Cook_Lesson cl : cook.getCookLessons())
        {
            lessons.add(cl.getLesson());
        }
        return lessons;
    }
}
