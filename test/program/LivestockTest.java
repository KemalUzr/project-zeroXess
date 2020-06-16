package program;

import org.junit.jupiter.api.Test;

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
        String voorbeeldinvoerveld = "13";
        Mammal test = new Mammal("12", "33", "Dog");
        test.setAmount(voorbeeldinvoerveld);
        try {
            BufferedWriter writercowA = new BufferedWriter(new FileWriter("testAmount.txt"));
            writercowA.write(voorbeeldinvoerveld);
            writercowA.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(test.getAmount(), getValue("testAmount"));
    }

    public String getValue(String specific) throws IOException {
        String returnValue = Files.readString(Paths.get(specific + ".txt"), Charset.defaultCharset());
        return returnValue;
    }
}