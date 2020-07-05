package program;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static program.Afname.*;


// condiston 1
// conditosn 2

class AfnameTest {

    // checkt of die de objecten aanmaakt.
   @Test
    public void CheckStartToets(){
       assertEquals(0, Afname.opdrachten.size());
       StartToets("Rekenen");
       assertEquals(10, Afname.opdrachten.size());
   }

    @Test
    public void CheckOefen(){
 // checkt of de objecten worden aangemaakt
       assertEquals(10, Afname.opdrachten.size());
       StartOefen("Rekenen" , "10");


       // of het oefen nummerdat mee wordt gegeven wordt gebruikt
        // vraagt het getal op wat is meee gegeven dus 10
        Input opdracht1 = Afname.opdrachten.get(0);
        assertEquals(10, ((RekenInput) opdracht1).getGetal2());


    }

}
