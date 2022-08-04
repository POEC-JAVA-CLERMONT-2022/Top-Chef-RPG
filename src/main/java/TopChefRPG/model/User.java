package TopChefRPG.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    private String userName;

    private String password;

    private String mail;

    private boolean active;

    private String roles;

    @OneToMany( targetEntity=Cook.class, mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cook> cooks;


    public User(){}

    public User(String userName,  String mail, String password){
        this.userName =userName;
        this.mail = mail;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Cook> getCooks() {
        return cooks;
    }

    public void setCooks(List<Cook> cooks) {
        this.cooks = cooks;
    }
}
