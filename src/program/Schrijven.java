package program;

public class Schrijven {

    private String mp3FileUrl = "../mp3/test";
    private String Anwer;


    public Schrijven(String fileName, String anwer) {
        this.mp3FileUrl = mp3FileUrl + fileName ;
        Anwer = anwer;
    }

    public void setMp3FileUrl(String mp3FileUrl) {
        this.mp3FileUrl = mp3FileUrl;
    }

    public void setAnwer(String anwer) {
        Anwer = anwer;
    }

    public String getMp3FileUrl() {
        return mp3FileUrl;
    }

    public String getAnwer() {
        return Anwer;
    }
}
