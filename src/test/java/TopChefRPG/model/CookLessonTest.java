package TopChefRPG.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CookLessonTest {

    @Test
    @DisplayName("test create cooklesson")
    public void createCookLesson() {
        User paulo = new User();
        Cook cook2 = new Cook("alexandra", 'F', paulo);
        Lesson patate = new Lesson("patate", 3, 3, 3, 3, 3, "patate", 3);
        CookLesson cookLesson = new CookLesson(cook2, patate);
        assertNotNull(cookLesson);
        assertEquals("paulo", cookLesson.getCook());
        assertEquals("patate", cookLesson.getLesson());
        assertEquals(0, cookLesson.getCountUse());
    }


    @Test
    @DisplayName("test cooklesson countuse")
    public void testcountuse() {
        User paulo = new User();
        Cook cook2 = new Cook("alexandra", 'F', paulo);
        Lesson patate = new Lesson("patate", 3, 3, 3, 3, 3, "patate", 3);
        CookLesson cookLesson = new CookLesson(cook2, patate);
        cookLesson.incrementCountUse();
        assertNotNull(cookLesson);
        assertEquals(1, cookLesson.getCountUse());
    }


}
