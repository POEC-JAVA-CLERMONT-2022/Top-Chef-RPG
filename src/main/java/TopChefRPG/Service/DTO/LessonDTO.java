package TopChefRPG.Service.DTO;

import TopChefRPG.model.Lesson;

public class LessonDTO {
    public String name;
    public int strengthIncrease;
    private int dexterityIncrease;
    private int creativityIncrease;
    private int luckIncrease;
    private int experienceCost;
    private String ingredientName;
    private int ingredientQuantity;

    public LessonDTO(Lesson lesson){
        this.name = lesson.getName();
        this.strengthIncrease = lesson.getStrengthIncrease();
        this.dexterityIncrease = lesson.getDexterityIncrease();
        this.creativityIncrease = lesson.getCreativityIncrease();
        this.luckIncrease = lesson.getLuckIncrease();
        this.experienceCost = lesson.getExperienceCost();
        this.ingredientName = lesson.getIngredientName();
        this.ingredientQuantity = lesson.getIngredientQuantity();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrengthIncrease() {
        return strengthIncrease;
    }

    public void setStrengthIncrease(int strengthIncrease) {
        this.strengthIncrease = strengthIncrease;
    }

    public int getDexterityIncrease() {
        return dexterityIncrease;
    }

    public void setDexterityIncrease(int dexterityIncrease) {
        this.dexterityIncrease = dexterityIncrease;
    }

    public int getCreativityIncrease() {
        return creativityIncrease;
    }

    public void setCreativityIncrease(int creativityIncrease) {
        this.creativityIncrease = creativityIncrease;
    }

    public int getLuckIncrease() {
        return luckIncrease;
    }

    public void setLuckIncrease(int luckIncrease) {
        this.luckIncrease = luckIncrease;
    }

    public int getExperienceCost() {
        return experienceCost;
    }

    public void setExperienceCost(int experienceCost) {
        this.experienceCost = experienceCost;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getIngredientQuantity() {
        return ingredientQuantity;
    }

    public void setIngredientQuantity(int ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    }
}
