package TopChefRPG.model;


import javax.persistence.*;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idLesson;

    @Column(name = "name")
    private String name;

    @Column(name = "strengthIncrease")
    private Integer strengthIncrease;

    @Column(name = "dexterityIncrease")
    private Integer dexterityIncrease;

    @Column(name = "creativityIncrease")
    private Integer creativityIncrease;

    @ManyToOne
    @JoinColumn(name="idCook", nullable=false)
    private Cook cook;

    public Lesson(Long id) {
        this.idLesson = id;
    }

    public Lesson() {

    }
}