package program;

import java.util.ArrayList;


public class Afname {
    static public ArrayList<Input> opdrachten = new ArrayList<>();
    static String type;


    // berekent de score van de opdrachten.
    public static int BerekenScore() {
        int aantalgoed= 0;

        if (type.equals("Rekenen")) {
            for (Input Shon : opdrachten) {
                    // doet alleen dingen als het een rekenopdracht is.
                if (Shon instanceof RekenInput){
                    if (((RekenInput) Shon).CheckRekenen()){
                        aantalgoed++;
                    }
                }
            }
        }
        return aantalgoed;
    }

    // start de toets
    public static void StartToets( String Soorttoets ) {
            type = Soorttoets;
        if (type.equals("Rekenen")) {

            RekenInput opdracht1 = new RekenInput(1, 2);
            RekenInput opdracht2 = new RekenInput(2, 3);
            RekenInput opdracht3 = new RekenInput(3, 7);
            RekenInput opdracht4 = new RekenInput(9, 5);
            RekenInput opdracht5 = new RekenInput(9, 2);
            RekenInput opdracht6 = new RekenInput(6, 2);
            RekenInput opdracht7 = new RekenInput(15, 2);
            RekenInput opdracht8 = new RekenInput(19, 4);
            RekenInput opdracht9 = new RekenInput(1, 2);
            RekenInput opdracht10 = new RekenInput(4, 2);
            opdrachten.add(opdracht1);
            opdrachten.add(opdracht2);
            opdrachten.add(opdracht3);
            opdrachten.add(opdracht4);
            opdrachten.add(opdracht5);
            opdrachten.add(opdracht6);
            opdrachten.add(opdracht7);
            opdrachten.add(opdracht8);
            opdrachten.add(opdracht9);
            opdrachten.add(opdracht10);
        }
        if (type.equals("Schrijven")) {
            SchrijvenInput opdracht1 = new SchrijvenInput("reading a book daily is very important", "test1");
            opdrachten.add(opdracht1);
            SchrijvenInput opdracht2 = new SchrijvenInput("exercising is important to stay fit", "test2");
            opdrachten.add(opdracht2);
            SchrijvenInput opdracht3 = new SchrijvenInput("she had a habit of taking showers in lemonade", "test3");
            opdrachten.add(opdracht3);
        }
    }

    // start oefenen
    public static void StartOefen( String Soorttoets , String oefenNummer ) {

       Integer nummer = Integer.parseInt(oefenNummer);
        type = Soorttoets;
        if (type.equals("Rekenen")){

            RekenInput opdracht1 = new RekenInput(1, nummer);
            RekenInput opdracht2 = new RekenInput(2, nummer);
            RekenInput opdracht3 = new RekenInput(3, nummer);
            RekenInput opdracht4 = new RekenInput(4, nummer);
            RekenInput opdracht5 = new RekenInput(5, nummer);
            RekenInput opdracht6 = new RekenInput(6, nummer);
            RekenInput opdracht7 = new RekenInput(7, nummer);
            RekenInput opdracht8 = new RekenInput(8, nummer);
            RekenInput opdracht9 = new RekenInput(9, nummer);
            RekenInput opdracht10 = new RekenInput(10 , nummer);


            opdrachten.add(opdracht1);
            opdrachten.add(opdracht2);
            opdrachten.add(opdracht3);
            opdrachten.add(opdracht4);
            opdrachten.add(opdracht5);
            opdrachten.add(opdracht6);
            opdrachten.add(opdracht7);
            opdrachten.add(opdracht8);
            opdrachten.add(opdracht9);
            opdrachten.add(opdracht10);
        }


    }
}
