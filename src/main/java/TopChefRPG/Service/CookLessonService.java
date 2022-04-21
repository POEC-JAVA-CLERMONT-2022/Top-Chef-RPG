package TopChefRPG.Service;

import TopChefRPG.Repository.CookLessonRepository;
import TopChefRPG.Repository.CookRepository;
import TopChefRPG.model.Cook;
import TopChefRPG.model.CookLesson;
import TopChefRPG.model.Ingredient;
import TopChefRPG.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CookLessonService {
    private CookLessonRepository cookLessonRepository;
    private CookRepository cookRepository;

    @Autowired
    public CookLessonService(CookLessonRepository cookLessonRepository, CookRepository cookRepository)
    {
        this.cookLessonRepository = cookLessonRepository;
        this.cookRepository = cookRepository;
    }

    public Cook buyLesson(Cook cook, Lesson lesson){

        // vérifier si le cook n'a pas déjà la lecon
        boolean alreadyBuyedLesson = false;
        for (CookLesson cl : cook.getCookLessons())
        {
            if (cl.getLesson().getIdLesson() == lesson.getIdLesson())
            {
                alreadyBuyedLesson = true;
                break;
                // message erreur leçon déjà achetée
            }
        }
        // si la lecon n'est pas encore achetée, on vérifie ensuite si il a ce qu'il faut comme ingredients requis
        if (!alreadyBuyedLesson)
        {
            //TODO: trop complexe

            // on parcourt la liste des ingrédients du cook pour trouver l'ingrédient requis pour l'achat.
            for (Ingredient ingCook : cook.getIngredients())
            {
                if (ingCook.getName().equals(lesson.getIngredientName()))
                {
                    // si le cook à assez d'ingrédients requis, on décrémente la quantité pour valider l'achat
                    if (ingCook.getIngredientQuantity() >= lesson.getIngredientQuantity())
                    {
                        ingCook.setIngredientQuantity(- lesson.getIngredientQuantity());
                        CookLesson cookLesson = new CookLesson(cook, lesson);
                        cook.addLesson(cookLesson);
                    }
                    else
                    {
                        //message erreur pas assez d'ingrédients pour faire la recette
                    }
                }
            }
        }
        return cookRepository.save(cook);
    }

    public List<CookLesson> getCookLesson(Cook cook){
        return cookLessonRepository.findCookLessonByCook (cook);
    }

    public List<Lesson> getLessonsOfCook(Cook cook)
    {
        List<Lesson> lessons = new ArrayList<>();
        for (CookLesson cl : cook.getCookLessons())
        {
            lessons.add(cl.getLesson());
        }
        return lessons;
    }
}
