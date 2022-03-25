package TopChefRPG.model;

import javax.persistence.*;

@Entity
public class Cook {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name="name")
    private String name;

    @Column(name="dexterity")
    private int dexterity;

    @Column (name="strength")
    private int strength;

    @Column (name="creativity")
    private int creativity;

    @Column (name="luck")
    private int luck;

    @Column (name="gender")
    private Character gender;

    @Column (name="experience")
    private int experience;

    public Cook(String name) {
        this.name = name;
    }


    public Cook() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
