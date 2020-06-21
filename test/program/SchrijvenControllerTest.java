package program;

import org.junit.jupiter.api.Test;
import static program.Afname.*;
import java.lang.reflect.Array;


import static org.junit.jupiter.api.Assertions.*;

class SchrijvenControllerTest {
    //dit moeten invoervelden voorstellen
    String voorbeeldinvoer1 = "reading a book daily is very important";
    String voorbeeldinvoer2 = "exercising is important to stay fit";
    String voorbeeldinvoer3 = "she had a habit of taking showers in lemonade";
    int count = 0;

    @Test
    public void testCheckTest(){
        StartToets("Schrijven");
        int loopnummer = 0;

        for (int i=0; i <= 2; i++) {
            Input input = Afname.opdrachten.get(loopnummer);
            if (loopnummer == 0){
                //checkt of de invgevoerde text gelijk staat aan het antwoord.
                assertEquals(voorbeeldinvoer1, ((SchrijvenInput) input).getAntwoord());
            }
            if (loopnummer == 1){
                assertEquals(voorbeeldinvoer2, ((SchrijvenInput) input).getAntwoord());
            }
            if (loopnummer == 2){
                assertEquals(voorbeeldinvoer3, ((SchrijvenInput) input).getAntwoord());
            }
            System.out.println(((SchrijvenInput) input).getAntwoord());
            loopnummer++;
        }
    }
}