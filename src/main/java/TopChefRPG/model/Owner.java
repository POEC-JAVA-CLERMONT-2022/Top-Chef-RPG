package TopChefRPG.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {
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


    public Owner(String name, String mail, String password) {
        this.name = name;
        this.password= password;
        this.mail =mail;
    }

    public Owner() {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getMail() { return mail; }


}
