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

    @ManyToOne
    @JoinColumn(name="idCook", nullable=false)
    private Cook cook;

    public Recipe(Long id) {
        this.idRecipe = id;
    }

    public Recipe() {

    }

}