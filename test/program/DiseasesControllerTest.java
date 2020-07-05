package program;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DiseasesControllerTest {


        //deze test kijd door middel van Decsion coverage of de aandoeningen van de medische dossier klopt.
        @Test
        public void LogischDiseseTest() {
            DiseasesController diseasesController = new DiseasesController();
            assertEquals("Diabetes type 2, last bij beide knieën.", diseasesController.getDiabetesGeval());
            assertEquals("Hartaandoening, veel last bij kransslagaders.", diseasesController.getHartaandoeningGeval());
        }
        @Test
        public void FysiekDiseaseTest(){
            DiseasesController diseasesController = new DiseasesController();
            assertNotEquals("Alzheimer", diseasesController.getDiabetesGeval());
            assertNotEquals("Hooikoorts", diseasesController.getHartaandoeningGeval());
        }
    }
