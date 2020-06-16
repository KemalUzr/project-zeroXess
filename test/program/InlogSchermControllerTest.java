package program;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InlogSchermControllerTest {

    //kijkt of de gebruikersnaam en wachtwoord correct zijn.
    @Test
    public void naLogin() {
        InlogSchermController inlogSchermController = new InlogSchermController();

        assertEquals("Jan", inlogSchermController.getGebruikersnaam());
        assertEquals("123", inlogSchermController.getWachtwoord());
    }
}