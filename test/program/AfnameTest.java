package program;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static program.Afname.*;


// condiston 1
// conditosn 2

class Checkrekeken {

    // checkt of die de objecten aanmaakt.
   @Test
    public void CheckStartToets(){

       assertEquals(0, Afname.opdrachten.size());
       StartToets("Rekenen");
       assertEquals(3, Afname.opdrachten.size());
   }

    @Test
    public void CheckOefen(){
 // checkt of de objecten worden aangemaakt
       assertEquals(0, Afname.opdrachten.size());
       StartOefen("Rekenen" , "10");
       assertEquals(10,Afname.opdrachten.size());


       // of het oefen nummerdat mee wordt gegeven wordt gebruikt
        Input opdracht1 = Afname.opdrachten.get(0);
        assertEquals(10, ((RekenInput) opdracht1).getGetal2());


    }

}
