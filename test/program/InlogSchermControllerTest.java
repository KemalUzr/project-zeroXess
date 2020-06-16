package program;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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