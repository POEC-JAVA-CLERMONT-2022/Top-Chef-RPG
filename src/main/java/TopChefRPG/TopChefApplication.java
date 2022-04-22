package TopChefRPG;
import TopChefRPG.Repository.IngredientListRepository;
import TopChefRPG.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TopChefApplication {



    public static void main(String[] args) {
        SpringApplication.run(TopChefApplication.class, args);
        //InitializeBDDService initializeBDD = new InitializeBDDService();

    }
}
