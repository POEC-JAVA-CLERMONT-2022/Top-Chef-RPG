package TopChefRPG.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "strengthIncrease")
    private int strengthIncrease;

    @Column(name = "dexterityIncrease")
    private int dexterityIncrease;

    @Column(name = "creativityIncrease")
    private int creativityIncrease;

    private int luckIncrease;

    private int experienceCost;


    // variables pour l'achat
    private String ingredientName;

    private int ingredientQuantity;

    @OneToMany(targetEntity = CookLesson.class, mappedBy = "lesson")
    private List<CookLesson> cookLessons;


    public Lesson() {

    }

    public Lesson(String name, Integer strengthIncrease, Integer dexterityIncrease, Integer creativityIncrease, Integer luckIncrease, Integer experienceCost, String ingredientName, int ingredientQuantity) {

        this.name = name;
        this.strengthIncrease = strengthIncrease;
        this.dexterityIncrease = dexterityIncrease;
        this.creativityIncrease = creativityIncrease;
        this.luckIncrease = luckIncrease;
        this.experienceCost = experienceCost;
        this.ingredientName = ingredientName;
        this.ingredientQuantity = ingredientQuantity;
    }

    public int getIdLesson() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStrengthIncrease() {
        return strengthIncrease;
    }

    public int getDexterityIncrease() {
        return dexterityIncrease;
    }

    public int getCreativityIncrease() {
        return creativityIncrease;
    }

    public int getLuckIncrease() {
        return luckIncrease;
    }

    public int getExperienceCost() {
        return experienceCost;
    }

    public String getIngredientName() { return ingredientName; }

    public int getIngredientQuantity() { return ingredientQuantity; }
}