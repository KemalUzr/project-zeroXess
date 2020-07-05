package program;

import org.junit.jupiter.api.Test;
import static program.Afname.*;
import java.lang.reflect.Array;


import static org.junit.jupiter.api.Assertions.*;

class SchrijvenControllerTest {


    @Test
    public void testCheckTest(){
        //dit moeten invoervelden voorstellen
        String userinput1 = "reading a book daily is very important";
        String userinput2 = "exercising is important to stay fit";
        String userinput3 = "she had a habit of taking showers in lemonade";
        StartToets("Schrijven");
        int loopnummer = 0;

        for (int i=0; i <= 2; i++) {
            Input input = Afname.opdrachten.get(loopnummer);
            if (loopnummer == 0){
                //checkt of de invgevoerde text gelijk staat aan het antwoord.
                assertEquals(userinput1, ((SchrijvenInput) input).getAntwoord());
            }
            if (loopnummer == 1){
                assertEquals(userinput2, ((SchrijvenInput) input).getAntwoord());
            }
            if (loopnummer == 2){
                assertEquals(userinput3, ((SchrijvenInput) input).getAntwoord());
            }
            System.out.println(((SchrijvenInput) input).getAntwoord());
            loopnummer++;
        }
    }
}
//