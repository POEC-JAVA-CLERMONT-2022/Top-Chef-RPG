package TopChefRPG.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest


public class UserTest {
    @Test
    public void createuser()
    {
        User user = new User("paulo", "florian@balkany.fr", "******");
        assertNotNull(user);
        assertEquals("paulo", user.getName());
        assertEquals("florian@balkany.fr", user.getMail());

    }
}
