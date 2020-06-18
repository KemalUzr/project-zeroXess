package program;


import org.junit.jupiter.api.Test;
import program.InlogSchermController;

import static org.junit.jupiter.api.Assertions.*;

public class InlogSchermControllerTest {

    //kijkt of de gebruikersnaam en wachtwoord correct zijn.
    @Test
    public void loginCriteria() {
        InlogSchermController inlogSchermController = new InlogSchermController();
        assertEquals("Jan", inlogSchermController.getGebruikersnaam());
        assertEquals("123", inlogSchermController.getWachtwoord());
    }
    @Test
    public void correctLogin () {
        InlogSchermController inlogSchermController = new InlogSchermController();
        assertFalse(inlogSchermController.getCorrectLogin());
    }
}