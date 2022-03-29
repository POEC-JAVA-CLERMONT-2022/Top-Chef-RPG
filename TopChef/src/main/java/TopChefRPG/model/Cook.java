package TopChefRPG.model;

import org.aspectj.weaver.loadtime.Agent;

import javax.persistence.*;
import java.util.*;

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

    @ManyToOne
    @JoinColumn(name="idUser", nullable=false)
    private User user;

    public Cook(String name, Character gender, User user )
    {
        this.name = name;
        this.creativity=0;
        this.dexterity=0;
        this.strength=0;
        this.luck=0;
        this.experience=0;
        this.gender= gender;
        this.ingredients=new ArrayList<Ingredient>() ;
        this.user= user;
    }


    public Cook() {
    }

    public Long getId() {
        return idCook;
    }


}
