package TopChefRPG.model;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LessonTest {
    @Test
    public void createLesson()
    {
        Lesson lesson =  new Lesson();
        lesson.setparameerOfLesson("lessonName",10,15,20,25,100,"ingredientName",10);
        assertNotNull(lesson);
        assertEquals(lesson.getName(), "lessonName");
        assertEquals(lesson.getStrengthIncrease(),10 );
        assertEquals(lesson.getDexterityIncrease(), 15);
        assertEquals(lesson.getCreativityIncrease(), 20);
        assertEquals(lesson.getLuckIncrease(),25);
        assertEquals(lesson.getExperienceCost(),100);
        assertEquals(lesson.getIngredientName(), "ingredientName");
        assertEquals(lesson.getIngredientQuantity(), 10);
    }
}
