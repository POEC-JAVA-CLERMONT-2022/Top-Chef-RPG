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

    public int getDexterityChange() {
        return dexterityChange;
    }

    public void setDexterityChange(int dexterityChange) {
        this.dexterityChange = dexterityChange;
    }

    public int getCreativityChange() {
        return creativityChange;
    }

    public void setCreativityChange(int creativityChange) {
        this.creativityChange = creativityChange;
    }

    public int getStrengthChange() {
        return strengthChange;
    }

    public void setStrengthChange(int strengthChange) {
        this.strengthChange = strengthChange;
    }

    public int getLuckChange() {
        return luckChange;
    }

    public void setLuckChange(int luckChange) {
        this.luckChange = luckChange;
    }

    public int getExperienceUsed() {
        return experienceUsed;
    }

    public void setExperienceUsed(int experienceUsed) {
        this.experienceUsed = experienceUsed;
    }
}
