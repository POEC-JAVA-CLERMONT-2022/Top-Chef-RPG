package TopChefRPG.Service.DTO;

import TopChefRPG.model.Cook;
import org.springframework.beans.BeanUtils;

public class CookDTO {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewName() {
        return newName;
    }

    public int getIdCook() {
        return idCook;
    }

    public void setIdCook(int idCook) {
        this.idCook = idCook;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getCreativity() {
        return creativity;
    }

    public void setCreativity(int creativity) {
        this.creativity = creativity;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    private String name;
    private String newName;
    private int idCook;
    private int dexterity;
    private int strength;
    private int creativity;
    private int luck;
    private Character gender;
    private int experience;



    public CookDTO(String name, int idCook) {
        this.name = name;
        this.idCook = idCook;
    }

    public CookDTO() {
    }

    public void setCookDTO(Cook cook) {
        BeanUtils.copyProperties(cook, this);
    }


    public void setNewName(String newName) {
        this.newName = newName;
    }
}