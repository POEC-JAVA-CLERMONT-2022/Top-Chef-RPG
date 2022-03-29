package TopChefRPG.model;


import javax.persistence.*;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idRecipe;

    @Column(name = "name")
    private String name;

    @Column(firstIngredient = "firstIngredient")
    private String firstIngredient;

    @Column(firstQty = "firstQty")
    private Integer firstQty;

    @Column(secondIngredient = "secondIngredient")
    private String thirdIngredient;

    @Column(secondQty = "secondQty")
    private Integer secondQty;

    @Column(thirdIngredient = "thirdIngredient")
    private String thirdIngredient;

    @Column(thirdQty = "thirdQty")
    private Integer thirdQty;

    @Column(experience = "experience")
    private Integer experience;

    @Column(looting1Name = "looting1Name")
    private String looting1Name;

    @Column(looting1Qty = "looting1Qty")
    private Integer looting1Qty;

    @Column(looting2Name = "looting2Name")
    private String looting2Name;

    @Column(looting2Qty = "looting2Qty")
    private Integer looting2Qty;
}