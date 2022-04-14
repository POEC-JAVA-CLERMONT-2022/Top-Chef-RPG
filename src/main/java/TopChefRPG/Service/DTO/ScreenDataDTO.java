package TopChefRPG.Service.DTO;

import TopChefRPG.Service.RecipeService;
import TopChefRPG.model.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ScreenDataDTO {

    public int idCook;
    public String cookName;
    public int experience;
    public int dexterity;
    public int creativity;
    public int strength;
    public int luck;
    public Character gender;
    public List<Ingredient> ingredients;
    public List<Lesson> lessons;
    public String userName;
    public int userId;
    public List<RecipeDTO> recipes;
    public String errorMessage;

    public ScreenDataDTO() {
    }

    public ScreenDataDTO(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public ScreenDataDTO(Cook cook, ArrayList<RecipeDTO> recipeDTOs) {
        this.cookName = cook.getName();
        this.idCook = cook.getId();
        this.experience = cook.getExperience();
        this.creativity = cook.getCreativity();
        this.dexterity = cook.getDexterity();
        this.strength = cook.getStrength();
        this.luck = cook.getLuck();
        this.gender = cook.getGender();
        this.ingredients = cook.getIngredients();
        this.lessons = new ArrayList<Lesson>();
        for (CookLesson cl : cook.getCookLessons()) {
            this.lessons.add(cl.getLesson());
        }
        this.userId = cook.getUser().getId();
        this.userName = cook.getUser().getName();
        this.recipes = recipeDTOs;
        this.lessons = new ArrayList<Lesson>();
        for (CookLesson cl : cook.getCookLessons()) {
            this.lessons.add(cl.getLesson());
        }
    }


}
