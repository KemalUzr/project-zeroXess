package program;

import java.util.Collection;

public class RekenOpdracht extends Opdracht {

    Integer Getal1;
    Integer Getal2;

    public RekenOpdracht(Integer getal1, Integer getal2) {
        //super( );
        Getal1 = getal1;
        Getal2 = getal2;
    }

    public Integer getGetal1() {
        return Getal1;
    }

    public Integer getGetal2() {
        return Getal2;
    }

    public Boolean CheckRekenen() {

        int CorrecteAntwoord = Getal1 * Getal2;
        return Integer.parseInt(super.getInput()) == (CorrecteAntwoord);


    }
}

