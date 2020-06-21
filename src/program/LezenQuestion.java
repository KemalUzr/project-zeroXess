package program;

public class LezenQuestion {
    public String question;
    public String answer;
    public int points;

    public LezenQuestion(String question, String answer, int points){
        this.question = question;
        this.answer = answer;
        this.points = points;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getPoints() {
        return points;
    }
}
