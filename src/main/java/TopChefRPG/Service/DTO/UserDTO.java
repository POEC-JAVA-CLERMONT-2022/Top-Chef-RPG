package TopChefRPG.Service.DTO;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private String userName;
    private String mail;
    private int id;
    //private List<String> CooksNameList = new ArrayList<>();
    public UserDTO(){}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
