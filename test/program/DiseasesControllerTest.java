package program;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DiseasesControllerTest {
        //deze test kijd door middel van Decsion coverage of de aandoeningen van de medische dossier klopt.

        @Test
        public void geval1Test() {
            DiseasesController geval1Test = new DiseasesController();
            assertEquals("Diabetes type 2, last bij beide knieën.", geval1Test.getGeval1());
            assertEquals("Hartaandoening, veel last bij kransslagaders.", geval1Test.getGeval2());
        }
        @Test
        public void geval2Test(){
            DiseasesController geval2Test = new DiseasesController();
            assertNotEquals("Alzheimer", geval2Test.getGeval1());
            assertNotEquals("Hooikoorts", geval2Test.getGeval2());
        }
    }
