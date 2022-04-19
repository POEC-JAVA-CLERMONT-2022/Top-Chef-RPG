package TopChefRPG.web;

import TopChefRPG.Service.DTO.LessonDTO;
import TopChefRPG.Service.LessonService;
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


    @GetMapping("/ownedByCook/{idCook}")
    public List<LessonDTO> getLessonsOwned (@PathVariable int idCook)
    {
        return lessonService.getLessonsBuyed(idCook);
    }

    @GetMapping ("/tobuy/{idCook}")
    public List<LessonDTO> getLessonToBuy (@PathVariable int idCook)
    {
        return lessonService.getLessonsNotOwned(idCook);
    }

}
