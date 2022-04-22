package TopChefRPG.model;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column (name="IngredientName")
    private String name;

    @Column (name="Quantity")
    private int quantity;

    @ManyToOne (cascade = CascadeType.ALL)
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

    // constructeur specifique pour les recettes ou les ingredients ne sont pas propres à un user
    // et e seront jamais en BDD
    public Ingredient(String name, int quantity)
    {
        this.name= name;
        this.quantity = quantity;
    }

    public int getIngredientQuantity()
    {
        return this.quantity;
    }

    public void setIngredientQuantity(int quantitychange)
    {
        // si on modifie pour la première fois l'ingrédient on doit l'initialiser
        if (this.quantity == -1 && quantitychange>0)
            this.quantity =0;
        if (this.quantity+quantitychange >=0)
        {
            this.quantity+=quantitychange;
        }
        else
        {
            //message erreur
            System.out.println("modification de la quantité impossible car inférieure à 0 pour "+this.name);

        }
    }

    public String getName()
    {
        return this.name;
    }

    @Override
    public String toString()
    {
        String retour ="";
        if (this.name.length()>0 )
        {
            retour+= "Ingredient : " +this.name;
        }
        // si la quantité à une valeur d'au moins -1
        if (this.quantity >= -2)
        {
            retour+= " Quantité : "+ this.quantity;
        }
        return retour;
    }

    public int getId() {
        return id;
    }

}
