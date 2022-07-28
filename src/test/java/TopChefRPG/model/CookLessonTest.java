package TopChefRPG.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CookLessonTest {

    @Test
    @DisplayName("test create cooklesson")
    public void createCookLesson() {
        User paulo = new User();
        Cook cook2 = new Cook("alexandra", 'F', paulo);
        Lesson patate = new Lesson();
        patate.setparameerOfLesson("patate", 3, 3, 3, 3, 3, "patate", 3);
        Cook_Lesson cookLesson = new Cook_Lesson(cook2, patate);
        assertNotNull(cookLesson);
        assertEquals("alexandra", cookLesson.getCook().getName());
        assertEquals("patate", cookLesson.getLesson().getName());
        assertEquals(0, cookLesson.getCountUse());
    }


    @Test
    @DisplayName("test cooklesson countuse")
    public void testcountuse() {
        User paulo = new User();
        Cook cook2 = new Cook("alexandra", 'F', paulo);
        Lesson patate = new Lesson();
        patate.setparameerOfLesson("patate", 3, 3, 3, 3, 3, "patate", 3);
        Cook_Lesson cookLesson = new Cook_Lesson(cook2, patate);
        cookLesson.incrementCountUse();
        assertNotNull(cookLesson);
        assertEquals(1, cookLesson.getCountUse());
    }


}
