package TopChefRPG.Service.DTO;

public class CookDTO {

    public String name;
    public String newName;
    public int idCook;
    public int dexterity;


    public CookDTO(String name, int idCook)
    {
        this.name = name;
        this.idCook = idCook;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}
