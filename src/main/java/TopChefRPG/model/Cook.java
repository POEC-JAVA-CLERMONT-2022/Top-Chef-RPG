package TopChefRPG.model;

import TopChefRPG.Exception.ErrorType;
import TopChefRPG.Exception.TopChefException;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "dexterity")
    private int dexterity;
    @Column(name = "strength")
    private int strength;
    @Column(name = "creativity")
    private int creativity;
    @Column(name = "luck")
    private int luck;
    @Column(name = "gender")
    private Character gender;
    @Column(name = "experience")
    private int experience;

    @OneToMany(targetEntity = Ingredient.class, cascade = CascadeType.ALL,  mappedBy = "cook",  fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Ingredient> ingredients;
    @OneToMany(targetEntity = Cook_Lesson.class, cascade = CascadeType.ALL, mappedBy = "cook", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Cook_Lesson> cookLessons;
    @ManyToOne     @JoinColumn(name = "id_Owner" ,nullable = false)
    private Owner owner;

    public int getDexterity() {
        return dexterity;
    }
    public int getStrength() {
        return strength;
    }
    public int getCreativity() {
        return creativity;
    }
    public int getExperience() {
        return experience;
    }
    public int getLuck() {
        return luck;
    }
    public Character getGender() {
        return gender;
    }
    public Owner getUser() {
        return owner;
    }
    public String getName() {
        return this.name;
    }
    public Cook(String name, Character gender, Owner user) {
        this.name = name;
        this.creativity = 1;
        this.dexterity = 1;
        this.strength = 1;
        this.luck = 0;
        this.experience = 0;
        this.gender = gender;
        this.ingredients = new ArrayList<>();
        this.cookLessons = new ArrayList<>();
        this.owner = user;
    }
    public Cook() {
    }
    public int getId() {
        return id;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    @Override
    public String toString() {
        return "nom : " + this.name + " ,experience : " + this.experience;
    }
    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }
    public List<Cook_Lesson> getCookLessons() {
        return this.cookLessons;
    }
    public void addLesson(Cook_Lesson cookLesson) {
        this.cookLessons.add(cookLesson);
    }
    public void changeExperience(int changeValue) {
        // si on est dans une valeur acceptable de changement (l'expe ne peut être inferieur à 0)
        if (this.experience + changeValue >= 0)
            this.experience += changeValue;
        else {
            throw new TopChefException(ErrorType.INCORRECT_DATA, "impossible de changer l'expérience à une valeure inférieur à 0 !", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public void changeCaracteristique(int strengthIncrease, int dexterityIncrease, int creativityIncrease, int luckIncrease) {
        this.strength += strengthIncrease;
        this.dexterity += dexterityIncrease;
        this.creativity += creativityIncrease;
        this.luck += luckIncrease;
    }
}
