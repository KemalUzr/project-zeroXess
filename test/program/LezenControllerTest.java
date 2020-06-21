package program;

import org.junit.jupiter.api.Test;
import program.LezenController;
import program.LezenQuestion;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LezenControllerTest {
    LezenController lezenController = new LezenController();
    String antwoordCorrect = "A";//Dit moet een correcte Input voorstellen.
    String antwoordInCorrect = "B";//Dit moet een incorrecte Input voorstellen.

    @Test
    public void Test(){
        assertEquals(lezenController.totalPoints==4,antwoordCorrect.equals(lezenController.questions[1].answer));
    }
    @Test
    public void Test1(){
        assertEquals(lezenController.totalPoints==0,antwoordInCorrect.equals(lezenController.questions[1].answer));
    }
}