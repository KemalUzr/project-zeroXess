package program;

public class schrijvenQuestions {
    private String name;
    private String soundFileName;
    private String answer;
    static  int questionsAmount = 0;

    public schrijvenQuestions(String name, String soundFileName, String answer) {
        questionsAmount++;
        this.name = name;
        this.soundFileName = soundFileName;
        this.answer = answer;
    }

    public int getQuestionsAmount() {
        return questionsAmount;
    }

    public String getName() {
        return name;
    }

    public String getSoundURL() {
        return soundFileName;
    }

    public String getAnswer() {
        return answer;
    }
}
