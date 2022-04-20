package TopChefRPG.Service.DTO;

public class ResultLessonDTO {

    public int dexterityChange;
    public int creativityChange;
    public int strengthChange;
    public int luckChange;
    public int experienceUsed;

    public ResultLessonDTO(int dexterityChange, int creativityChange, int strengthChange, int luckChange, int experienceUsed )
    {
        this.dexterityChange = dexterityChange;
        this.creativityChange =creativityChange;
        this.strengthChange = strengthChange;
        this.luckChange = luckChange;
        this.experienceUsed =experienceUsed;
    }

}
