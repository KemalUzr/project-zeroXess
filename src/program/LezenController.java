package program;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
public class LezenController{
    public int totalPoints = 0;
    @FXML
    private TextArea QuestionField;
    @FXML
    private TextField AnswerField;
    @FXML
    private Button startButton;
    @FXML
    private Label Feedback;
    @FXML
    private Button submitButton;

    public String Q1 = "Where was the mother chicken sitting ?\n"
            +"(A) On her nest\n(B) On a rock\n(C) On the street";
    public String Q2 = "What color were her feathers ?\n"
            +"(A) Black\n(B) White\n(C) Yellow";
    public String Q3 = "What happend to the eggs ?\n"
            +"(A) It chcanged color\n(B) Nothing\n(C) It cracked open";

    public LezenQuestion[] questions = {
            new LezenQuestion(Q1, "A", 4),
            new LezenQuestion(Q2, "B", 3),
            new LezenQuestion(Q3, "C", 3)
    };
    int i = 0;
public void startTest(){
        QuestionField.setText(questions[i].question);
        startButton.setVisible(false);
    }
public void submit(){
        String text = AnswerField.getText();
        if (text.equals(questions[i].answer)) {
            Feedback.setText("correct");
            totalPoints= totalPoints+questions[i].points;
        }
        else
            Feedback.setText("incorrect");
        if(i<2)
            i++;
        else {
            Feedback.setText("Your final score is :" + totalPoints);
            submitButton.setVisible(false);
        }
        QuestionField.setText(questions[i].question);
        AnswerField.clear();

}
    public void toHomescreen(ActionEvent event) throws IOException {
        Parent tohome  = FXMLLoader.load(getClass().getResource("homescreen.fxml"));
        Scene homeScene = new Scene(tohome);

        //pakt stage informatie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }
}