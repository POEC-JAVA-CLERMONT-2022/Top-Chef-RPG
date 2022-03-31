package TopChefRPG.model;

import javax.persistence.*;


@Entity



public class CookLesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer countUse;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cook cook;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;

    public CookLesson(){}




    public Integer getCountUse() {
        return countUse;
    }

    public void incrementCountUse(){
        this.countUse +=1;
    }


}

