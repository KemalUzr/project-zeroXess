package program;

import org.junit.jupiter.api.Test;
import program.LezenController;
import program.LezenQuestion;

import static org.junit.jupiter.api.Assertions.*;


public class LezenControllerTest {
    LezenController lezenController = new LezenController();
    String antwoordA = "A";//Dit moet een Input voorstellen.
    String antwoordB = "B";//Dit moet een Input voorstellen.
    String antwoordC = "C";//Dit moet een Input voorstellen.


    //De volgende tests test of de antwoorden goed werken
    @Test
    public void Test(){
        assertTrue(antwoordA.equals(lezenController.questions[0].answer));
    }
    @Test
    public void Test1(){
        assertFalse(antwoordB.equals(lezenController.questions[0].answer));
    }
    @Test
    public void Test3(){
        assertTrue(antwoordB.equals(lezenController.questions[1].answer));
    }
    @Test
    public void Test4(){
        assertFalse(antwoordA.equals(lezenController.questions[1].answer));
    }
    @Test
    public void Test5(){
        assertTrue(antwoordC.equals(lezenController.questions[2].answer));
    }
    @Test
    public void Test6(){
        assertFalse(antwoordA.equals(lezenController.questions[2].answer));
    }
}