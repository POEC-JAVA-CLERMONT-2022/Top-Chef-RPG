package TopChefRPG.model;

import javax.persistence.*;


@Entity
public class CookLesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    private Integer countUse;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="idCook", nullable=false)
    private Cook cook;

    @ManyToOne
    @JoinColumn(name="idLesson", nullable=false)
    private Lesson lesson;

    public CookLesson(){}

    public CookLesson(Cook cook, Lesson lesson)
    {
        this.cook = cook;
        this.lesson =lesson;
        this.countUse = 0;
    }




    public Integer getCountUse() {
        return countUse;
    }

    public void incrementCountUse(){
        this.countUse +=1;
    }


    public Cook getCook() {
        return cook;
    }

    public Lesson getLesson() {
        return lesson;
    }
}

