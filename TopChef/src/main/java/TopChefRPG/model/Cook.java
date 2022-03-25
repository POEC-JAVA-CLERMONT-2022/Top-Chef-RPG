package TopChefRPG.model;

import org.aspectj.weaver.loadtime.Agent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cook {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idCook;


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

    @OneToMany( targetEntity=Ingredient.class, mappedBy="cook" )
    private List<Ingredient> ingredients;

    public Cook(String name) {
        this.name = name;
    }


    public Cook() {

    }

    public Long getId() {
        return idCook;
    }


}
