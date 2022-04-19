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
}
