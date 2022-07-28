package TopChefRPG.Service.mapper;

import TopChefRPG.Service.DTO.LessonDTO;
import TopChefRPG.model.Lesson;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface  LessonMapper {

    LessonDTO lessonToLessonDTO(Lesson lesson);

    List<LessonDTO> ListLessonToListLessonDTO(List<Lesson> lesson);

}
