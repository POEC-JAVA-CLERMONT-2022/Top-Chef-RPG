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
    // classe inutile (code déplacé dans cook)

}
