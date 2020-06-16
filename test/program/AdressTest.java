package program;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EnumSource;
import javax.swing.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

public class AdressTest {

    //test getter setters van de adress class.
    @Test
    void checkName() {
        Adress adress = new Adress("shon", "shon@shon", "2132342323");

        adress.setName("Lewis");
        assertEquals("Lewis", adress.getName());
        assertEquals("shon@shon", adress.getEmail());
        assertEquals("2132342323", adress.getTel());


    }
}