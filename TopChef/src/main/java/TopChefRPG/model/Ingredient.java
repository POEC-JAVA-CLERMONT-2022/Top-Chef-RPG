package TopChefRPG.model;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column (name="IngredientName")
    private String name;

    @Column (name="Quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name="idCook", nullable=false)
    private Cook cook;


    public Ingredient(Long id) {
        this.id = id;
    }

    public Ingredient() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
