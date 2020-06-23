package program;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdressTest {

    //test getter setters van de adress class.
    @Test
    void checkGetterSetter() {
        Adress adress = new Adress("shon", "shon@shon", "2132342323");

        adress.setName("Lewis");
        assertEquals("Lewis", adress.getName());
        assertEquals("shon@shon", adress.getEmail());
        assertEquals(2132342323, adress.getTel());


    }
}