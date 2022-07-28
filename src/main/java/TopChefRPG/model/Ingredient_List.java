package TopChefRPG.model;

import javax.persistence.*;

@Entity
public class Ingredient_List {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    public String getName() {
        return name;
    }
    @Column(name = "ingredient")
    private String name;
    public Ingredient_List(){}
    public Ingredient_List(String name)
    {
        this.name = name;
    }
}
