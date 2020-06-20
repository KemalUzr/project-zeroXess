package program;

import org.junit.jupiter.api.Test;
import program.Mammal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class LivestockTest {

    @Test
    void saveStock() throws IOException {
        String voorbeeldinvoerveld = "13"; //dit moet een invoerveld voorstellen
        Mammal test = new Mammal("12", "33", "Dog"); //aanmaken van nieuwe mamal
        test.setAmount(voorbeeldinvoerveld);    //gebruikt de setAmount functie om de amount van test te veranderen naar de invoerveld.
        assertEquals(test.getAmount(), voorbeeldinvoerveld); //test of de amount van test gelijk is aan
        try {
            BufferedWriter writercowA = new BufferedWriter(new FileWriter("testAmount.txt"));
            writercowA.write(voorbeeldinvoerveld);  //zet de invoerveld waarde in de testAmount.txt
            writercowA.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(test.getAmount(), getValue("testAmount")); //Test of de waarde van de amount die in test zit gelijk is aan de waarde in de .txt bestand
    }

    public String getValue(String specific) throws IOException {
        String returnValue = Files.readString(Paths.get(specific + ".txt"), Charset.defaultCharset());
        return returnValue;
    }
}