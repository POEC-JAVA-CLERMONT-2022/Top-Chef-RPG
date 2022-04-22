package TopChefRPG.model;

import javax.persistence.*;

@Entity
public class IngredientList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    public String getName() {
        return name;
    }

    @Column(name = "Ingredient")
    private String name;

    public IngredientList()
    {}

    public IngredientList(String name)
    {
        this.name = name;
    }


}
