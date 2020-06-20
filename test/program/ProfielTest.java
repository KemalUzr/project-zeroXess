package program;


import org.junit.jupiter.api.Test;
import program.InlogSchermController;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class ProfielTest {
    @Test
    //Checkt of het inlog naam overeen komt met de profiel naam
    public void profielTest() throws IOException {
        InlogSchermController inlogSchermController = new InlogSchermController();
        assertEquals(inlogSchermController.getGebruikersnaam(), Files.readString(Paths.get("name.txt"), Charset.defaultCharset()));
        assertEquals("Jan",Files.readString(Paths.get("name.txt"), Charset.defaultCharset()));
    }
}