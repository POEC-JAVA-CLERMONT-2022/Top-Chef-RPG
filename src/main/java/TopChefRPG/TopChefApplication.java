package TopChefRPG;
import TopChefRPG.Repository.IngredientListRepository;
import TopChefRPG.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class TopChefApplication {

    @Autowired
    InitializeBDDService initializeBDDService;


    public static void main(String[] args) {
        SpringApplication.run(TopChefApplication.class, args);
    }

    @EventListener(classes = {ApplicationStartedEvent.class})
    public void applicationStarted() {
        initializeBDDService.setDatainBDD();
        initializeBDDService.setUSerANdCookInBDD();
    }
}
