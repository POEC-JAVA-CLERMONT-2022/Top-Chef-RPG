package TopChefRPG.TopChef.model;

import javax.persistence.*;

@Entity
public class Cook {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name="name")
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    public Cook() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
