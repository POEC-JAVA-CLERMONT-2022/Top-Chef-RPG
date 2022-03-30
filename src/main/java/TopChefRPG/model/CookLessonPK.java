package TopChefRPG.model;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CookLessonPK implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private Cook cook;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;

    protected CookLessonPK() {
    }

    public CookLessonPK(Cook cook, Lesson lesson) {
        this.cook = cook;
        this.lesson = lesson;
    }
}
