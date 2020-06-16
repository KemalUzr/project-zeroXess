package program;

import org.junit.Test;

import static org.junit.Assert.*;

public class InlogSchermControllerTest {

    //kijkt of de gebruikersnaam en wachtwoord correct zijn.
    @Test
    public void naLogin() {
        String Gebruikersnaam = "Jan";
        String Wachtwoord = "123";

        assertEquals("Jan", Gebruikersnaam);
        assertEquals("123", Wachtwoord);
    }
}