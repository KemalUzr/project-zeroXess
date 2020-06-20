package program;

import java.util.ArrayList;


public class Afname {
    static public ArrayList<Opdracht> opdrachten = new ArrayList<>();
    static String type;

    static Integer Rekencijfer;


    // berekent de score van de opdrachten.
    public static void BerekenScore() {
        int aantalgoed= 0;

        if (type.equals("Rekenen")) {
            for (Opdracht Shon : opdrachten) {
                    // doet alleen dingen als het een rekenopdracht is.
                if (Shon instanceof RekenOpdracht){
                    if (((RekenOpdracht) Shon).CheckRekenen()){
                        aantalgoed++;
                    }
                }
            }
        }

        Rekencijfer = aantalgoed / opdrachten.size() * 9 +1;
    }

    // start de toets
    public static void StartToets( String Soorttoets ) {
            type = Soorttoets;
        if (type.equals("Rekenen")) {

            RekenOpdracht opdracht1 = new RekenOpdracht(1, 2);
            RekenOpdracht opdracht2 = new RekenOpdracht(2, 2);
            RekenOpdracht opdracht3 = new RekenOpdracht(3, 2);
//            RekenOpdracht opdracht4 = new RekenOpdracht(1, 2);
//            RekenOpdracht opdracht5 = new RekenOpdracht(1, 2);
//            RekenOpdracht opdracht6 = new RekenOpdracht(1, 2);
//            RekenOpdracht opdracht7 = new RekenOpdracht(1, 2);
//            RekenOpdracht opdracht8 = new RekenOpdracht(1, 2);
//            RekenOpdracht opdracht9 = new RekenOpdracht(1, 2);
//            RekenOpdracht opdracht10 = new RekenOpdracht(1, 2);
            opdrachten.add(opdracht1);
            opdrachten.add(opdracht2);
            opdrachten.add(opdracht3);
//            opdrachten.add(opdracht4);
//            opdrachten.add(opdracht5);
//            opdrachten.add(opdracht6);
//            opdrachten.add(opdracht7);
//            opdrachten.add(opdracht8);
//            opdrachten.add(opdracht9);
//            opdrachten.add(opdracht10);
        }

    }

    // start oefenen
    public void StartOefen() {

    }
}
