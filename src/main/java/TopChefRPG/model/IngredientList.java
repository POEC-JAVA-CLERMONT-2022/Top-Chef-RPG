package TopChefRPG.model;


import org.hibernate.annotations.CollectionId;

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
}
