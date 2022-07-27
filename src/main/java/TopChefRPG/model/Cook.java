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
    @OneToMany(targetEntity = CookLesson.class, cascade = CascadeType.ALL, mappedBy = "cook", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<CookLesson> cookLessons;
    @ManyToOne     @JoinColumn(name = "idUser" ,nullable = false)
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
    public int getExperience() {
        return experience;
    }
    public int getLuck() {
        return luck;
    }
    public Character getGender() {
        return gender;
    }
    public User getUser() {
        return user;
    }
    public String getName() {
        return this.name;
    }
    public Cook(String name, Character gender, User user) {
        this.name = name;
        this.creativity = 1;
        this.dexterity = 1;
        this.strength = 1;
        this.luck = 0;
        this.experience = 0;
        this.gender = gender;
        this.ingredients = new ArrayList<>();
        this.cookLessons = new ArrayList<>();
        this.user = user;
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
        String retour = "";
        if (this.name.length() > 0)
            retour += "nom : " + this.name;
        retour += " ,experience : " + this.experience;
        return retour;
    }
    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }
    public List<CookLesson> getCookLessons() {
        return this.cookLessons;
    }
    public void addLesson(CookLesson cookLesson) {
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
