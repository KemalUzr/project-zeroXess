package program;



import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProfielTest {
    @Test
    //Checkt of het inlog naam overeen komt met de profiel naam
    public void profielTest() throws IOException {
        assertEquals("Jan", Files.readString(Paths.get("name.txt"), Charset.defaultCharset()));
    }
}