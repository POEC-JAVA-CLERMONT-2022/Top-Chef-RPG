package TopChefRPG.model;

import org.aspectj.weaver.loadtime.Agent;

import javax.persistence.*;
import java.util.*;

@Entity
public class Cook {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int idCook;


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

    @OneToMany( targetEntity=Ingredient.class, mappedBy="cook" , cascade = CascadeType.REMOVE)
    private List<Ingredient> ingredients;

    /*
    @OneToMany(targetEntity = Lesson.class, mappedBy = "cook")
    private List<Lesson> lessons;
*/
    @ManyToOne
    @JoinColumn(name="idUser", nullable=false)
    private User user;

    public int getDexterity() {
        return dexterity;
    }

    public int getStrength() {
        return strength;
    }

    public int getCreativity() {
        return creativity;
    }

    public int getLuck() {
        return luck;
    }

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

    public int getId() {
        return idCook;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    @Override
    public String toString()
    {
        String retour ="";
        if (this.name.length()>0)
            retour+= "nom : "+ this.name;
        retour += " ,experience : "+ this.experience;

        return retour;
    }

    public List<Ingredient> getIngredients()
    {
        return this.ingredients;
    }

}
