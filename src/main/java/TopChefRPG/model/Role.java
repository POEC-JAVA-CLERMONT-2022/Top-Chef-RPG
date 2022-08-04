package TopChefRPG.model;

import org.mapstruct.control.MappingControl;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    private String role;

    //@ManyToOne
    //@JoinColumn(name = "id_User" ,nullable = false)
    //private User user;

    public int getId() {
        return id;
    }


}
