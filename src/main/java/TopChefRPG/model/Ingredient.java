package TopChefRPG.model;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column (name="IngredientName")
    private String name;

    @Column (name="Quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name="idCook", nullable=false)
    private Cook cook;


    public Ingredient() {
    }

    public Ingredient(String name, Cook cook)
    {
        this.name=name;
        this.quantity=-1;
        this.cook=cook;
    }

    public int getIngredientQuantity()
    {
        return this.quantity;
    }

    public void setIngredientQuantity(int quantitychange)
    {
        if (this.quantity+quantitychange >=0)
        {
            this.quantity+=quantitychange;
        }
        else
        {
            System.out.println("modification de la quantité impossible car inférieure à 0 pour "+this.name);
        }
    }


    public Long getId() {
        return id;
    }

}
