package TopChefRPG.model;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest


public class UserTest {
    @Test
    public void createUser()
    {
        User user = new User("paulo", "florian@balkany.fr", "******");
        assertNotNull(user);
        assertEquals("paulo", user.getUserName());
        assertEquals("florian@balkany.fr", user.getMail());

    }
}
