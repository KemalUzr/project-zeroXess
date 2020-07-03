package program;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiseasesControllerTest {
    //deze test kijd door middel van Decsion coverage of de aandoeningen van de medische dossier klopt.

    @Test
    public void aandoeningtestlogisch() {
        DiseasesController LmedischDossier = new DiseasesController();
        assertEquals("Diabetes type 2, last bij beide knieën.", LmedischDossier.getDiabetesGeval());
        assertEquals("Hartaandoening, veel last bij kransslagaders.", LmedischDossier.getHartaandoeningGeval());
    }
    @Test
    public void aandoeningtestfysiek(){
        DiseasesController FmedischDossier = new DiseasesController();
        assertNotEquals("Alzheimer", FmedischDossier.getDiabetesGeval());
        assertNotEquals("Hooikoorts", FmedischDossier.getHartaandoeningGeval());
    }
}