package TopChefRPG.web;

import TopChefRPG.Service.CookLessonService;
import TopChefRPG.Service.CookService;
import TopChefRPG.Service.DTO.LessonDTO;
import TopChefRPG.Service.DTO.ResultLessonDTO;
import TopChefRPG.Service.LessonService;
import TopChefRPG.model.Cook;
import TopChefRPG.model.CookLesson;
import TopChefRPG.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Lessons")
public class LessonController {

    @Autowired
    LessonService lessonService;
    @Autowired
    CookLessonService cookLessonService;

    @Autowired
    CookService cookService;


    //TODO: gestion des exceptions + logger + code retour
    @GetMapping("/ownedByCook/{idCook}")
    public List<LessonDTO> getLessonsOwned(@PathVariable int idCook) {
        Cook cook = cookService.getCookById(idCook);
        return lessonService.getLessonsBuyed(cook);
    }

    @GetMapping("/tobuy/{idCook}")
    public List<LessonDTO> getLessonToBuy(@PathVariable int idCook) {
        Cook cook = cookService.getCookById(idCook);
        return lessonService.getLessonsNotOwned(cook);
    }

    @GetMapping("/buyLesson/{idCook}/{idLesson}")
    public void buyLesson(@PathVariable int idCook, @PathVariable int idLesson) {
        Cook cook = cookService.getCookById(idCook);
        Lesson lesson = lessonService.getLessonById(idLesson);
        cookLessonService.buyLesson(cook, lesson);
    }

    //TODO utiliser un post
    @GetMapping("/doLesson/{idCook}/{idLesson}")
    public ResultLessonDTO doLesson(@PathVariable int idCook, @PathVariable int idLesson)
    {
        Cook cook = cookService.getCookById(idCook);

        return cookService.doLesson( idLesson, cook);
    }
}
