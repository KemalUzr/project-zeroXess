package program;

public class SchrijvenInput extends Input {
    private String Antwoord;
    private String mp3;

    public void checkTaalOpdrachten(){

    }

    public SchrijvenInput(String antwoord, String mp3) {
        Antwoord = antwoord;
        this.mp3 = mp3;
    }
    public String getAntwoord() {
        return Antwoord;
    }

    public String getMp3() {
        return mp3;
    }
}
