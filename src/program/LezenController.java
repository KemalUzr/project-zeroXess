package program;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class LezenController {
    public int points = 0;
    @FXML
    private Button submitButton;
    @FXML
    private Label feedback;
    @FXML
    private Label Vraag1;
    @FXML
    private Label Vraag2;
    @FXML
    private Label Vraag3;

    @FXML
    public RadioButton correctAnswer1;
    @FXML
    public RadioButton correctAnswer2;
    @FXML
    public RadioButton correctAnswer3;

    public void toHomescreen(ActionEvent event) throws IOException {
        Parent tohome  = FXMLLoader.load(getClass().getResource("homescreen.fxml"));
        Scene homeScene = new Scene(tohome);

        //pakt stage informatie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }
    public void submit(){
        if(correctAnswer1.isSelected() == true) {
            Vraag1.setText(Vraag1.getText() + "   Correct");
            points =points +4;
        }
        else
            Vraag1.setText(Vraag1.getText()+"   Fout");
        if(correctAnswer2.isSelected() == true){
            Vraag2.setText(Vraag2.getText()+"   Correct");
            points =points +3;
        }
        else
            Vraag2.setText(Vraag2.getText()+"   Fout");
        if(correctAnswer3.isSelected() == true){
            Vraag3.setText(Vraag3.getText()+"   Correct");
            points =points +3;
        }
        else
            Vraag3.setText(Vraag3.getText()+"   Fout");

        submitButton.setVisible(false);
        feedback.setText("Your final score is :"+points);

    }


}
