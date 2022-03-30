package TopChefRPG.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity

@AssociationOverrides( {
        @AssociationOverride(name = "cooklessons.cook", joinColumns = @JoinColumn(name = "id_cook")),
        @AssociationOverride(name = "cooklessons.lesson", joinColumns = @JoinColumn(name = "id_lesson")),
})

public class CookLesson {

    @EmbeddedId
    private CookLessonPK cooklessons;

    private Integer CountUse;

    public CookLesson(){}

public CookLesson(CookLessonPK cooklessons) { this.cooklessons = cooklessons;}


    public Integer getCountUse() {
        return CountUse;
    }

    public void incrementCountUse(){
        this.CountUse+=1;
    }


}

