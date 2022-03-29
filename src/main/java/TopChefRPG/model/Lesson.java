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





    public Lesson() {

    }

    public Lesson(String name, Integer strengthIncrease, Integer dexterityIncrease, Integer creativityIncrease) {

        this.name = name;
        this.strengthIncrease = strengthIncrease;
        this.dexterityIncrease = dexterityIncrease;
        this.creativityIncrease = creativityIncrease;
    }
}