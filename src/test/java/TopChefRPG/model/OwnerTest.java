package TopChefRPG.model;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest


public class OwnerTest {
    @Test
    public void createOwner()
    {
        Owner owner = new Owner("paulo", "florian@balkany.fr", "******");
        assertNotNull(owner);
        assertEquals("paulo", owner.getName());
        assertEquals("florian@balkany.fr", owner.getMail());

    }
}
