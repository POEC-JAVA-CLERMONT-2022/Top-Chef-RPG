package TopChefRPG.model;

import javax.persistence.*;


@Entity

@AssociationOverrides( {
        @AssociationOverride(name = "cooklessonsPK.cook", joinColumns = @JoinColumn(name = "id_cook")),
        @AssociationOverride(name = "cooklessonsPK.lesson", joinColumns = @JoinColumn(name = "id_lesson")),
})

public class CookLesson {

    @EmbeddedId
    private CookLessonPK cooklessonsPK;

    private Integer countUse;



    public CookLesson(){}

public CookLesson(CookLessonPK cooklessonsPK) {
        this.cooklessonsPK = cooklessonsPK;
        this.countUse = 0;
    }


    public Integer getCountUse() {
        return countUse;
    }

    public void incrementCountUse(){
        this.countUse +=1;
    }


}

