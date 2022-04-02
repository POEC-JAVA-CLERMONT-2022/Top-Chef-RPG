package TopChefRPG.model;


import javax.persistence.*;
import java.util.ArrayList;


@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "firstIngredient")
    private String firstIngredient;

    @Column(name = "firstQty")
    private Integer firstQty;

    @Column(name = "secondIngredient")
    private String secondIngredient;

    @Column(name = "secondQty")
    private Integer secondQty;

    @Column(name = "thirdIngredient")
    private String thirdIngredient;

    @Column(name = "thirdQty")
    private Integer thirdQty;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "looting1Name")
    private String looting1Name;

    @Column(name = "looting1Qty")
    private Integer looting1Qty;

    @Column(name = "looting2Name")
    private String looting2Name;

    @Column(name = "looting2Qty")
    private Integer looting2Qty;

    @Column(name = "strengthRequired")
    private Integer strengthRequired;

    @Column(name = "dexterityRequired")
    private Integer dexterityRequired;

    @Column(name = "creativityRequired")
    private Integer creativityRequired;

    @Transient
    public ArrayList<Ingredient> requiredIngredients;

    @Transient
    public ArrayList<Ingredient> lootIngredient;



    public Recipe() {
    }

    public Recipe(String name, String firstIngredient, Integer firstQty, String secondIngredient,
                  Integer secondQty, String thirdIngredient, Integer thirdQty, Integer experience,
                  String looting1Name, Integer looting1Qty, String looting2Name, Integer looting2Qty,
                  Integer strengthRequired, Integer dexterityRequired, Integer creativityRequired)
    {
        this.name = name;
        this.firstIngredient = firstIngredient;
        this.firstQty = firstQty;
        this.secondIngredient = secondIngredient;
        this.secondQty = secondQty;
        this.thirdIngredient = thirdIngredient;
        this.thirdQty = thirdQty;
        this.experience = experience;
        this.looting1Name = looting1Name;
        this.looting1Qty = looting1Qty;
        this.looting2Name = looting2Name;
        this.looting2Qty = looting2Qty;
        this.strengthRequired = strengthRequired;
        this.dexterityRequired = dexterityRequired;
        this.creativityRequired = creativityRequired;









    }


    public int getIdRecipe() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstIngredient() {
        return firstIngredient;
    }

    public Integer getFirstQty() {
        return firstQty;
    }

    public String getSecondIngredient() {
        return secondIngredient;
    }

    public Integer getSecondQty() {
        return secondQty;
    }

    public String getThirdIngredient() {
        return thirdIngredient;
    }

    public Integer getThirdQty() {
        return thirdQty;
    }

    public Integer getExperience() {
        return experience;
    }

    public String getLooting1Name() {
        return looting1Name;
    }

    public Integer getLooting1Qty() {
        return looting1Qty;
    }

    public String getLooting2Name() {
        return looting2Name;
    }

    public Integer getLooting2Qty() {
        return looting2Qty;
    }

    public Integer getStrengthRequired() {
        return strengthRequired;
    }

    public Integer getDexterityRequired() {
        return dexterityRequired;
    }

    public Integer getCreativityRequired() {
        return creativityRequired;
    }
}