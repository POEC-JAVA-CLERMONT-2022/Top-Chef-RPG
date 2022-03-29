package TopChefRPG;

import TopChefRPG.Repository.UserRepository;
import TopChefRPG.Service.CookService;
import TopChefRPG.Service.UserService;
import TopChefRPG.model.Cook;
import TopChefRPG.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class TopChefApplication {
	@Autowired
	private UserService userService;

	@Autowired
	private CookService cookService;


	public static void main(String[] args)
	{
		SpringApplication.run(TopChefApplication.class, args);

	}

	@EventListener(classes = {ApplicationStartedEvent.class})
	public void applicationStarted() {
		List<User> users = userService.findAll();
		System.out.println("passe ici");
		for (User user : users)
		{
			System.out.println(user.getName());
		}
		String userName = "user4";
		userService.create(userName);
		User testUser = userService.findByName(userName);
		String CookName =userName+"Cook";
		Cook cook = cookService.createCook(CookName, 'M', testUser);


	}

}
