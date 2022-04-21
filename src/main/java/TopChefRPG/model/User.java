package TopChefRPG.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="mail")
    private String mail;

    @Column(name="password")
    private String password;

    // en prévision de la possibilité d'avoir plusieurs cuistots par user, on stock les users sous forme de liste
    @OneToMany( targetEntity=Cook.class, mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cook> cooks;

    public User(String name, String mail, String password) {
        this.name = name;
        this.password= password;
        this.mail =mail;
    }
    public List<Cook> getCooks() {
        return cooks;
    }
    public User() {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getMail() { return mail; }


}
