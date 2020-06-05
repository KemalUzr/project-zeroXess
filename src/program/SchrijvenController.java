package program;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.image.Image ;
import javax.swing.*;


public class SchrijvenController {

    public TextArea test1Field;
    public Label testNumber;
    public Button checkButton;
    public Button playButton;
    public Label middleText;
    public ImageView endscreenImage;
    public int current = 1; //houd bij welke mp3 file gebruikt moet worden
    public String arr[] = {
            "reading a book daily is very important",
            "exercising is important to stay fit",
            "she had a habit of taking showers in lemonade"
    };
    public int teller = 2; //

    //Speelt de mp3 file die is geselecteerd
    public void startTest(){
        final URL resource = getClass().getResource("../mp3/test" + current +".mp3");
        final Media media = new Media(resource.toString());
        final MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    //Controleerd antwoord
    public void checkTest(){
            String answer = arr[teller - 2];
            String input = test1Field.getText();
            if (input.equals(answer)){
                alertBox(true);
                test1Field.clear();
                testNumber.setText("Test " + teller);
                current = teller ;
                teller++;
            }else{
                alertBox(false);
            }
            if (teller == (arr.length + 2)){
                done();
            }
    }

    //Eindscherm laten zien voor als de gebruiker alles goed heeft
    public void done(){
        test1Field.setVisible(false);
        playButton.setVisible(false);
        checkButton.setVisible(false);
        testNumber.setText("Good Job!");
        middleText.setText("You have completed your test!");
        endscreenImage.setVisible(true);
    }

    //Alertbox laten zien bij het checken van antwoord
    public void alertBox(boolean status){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if (status == true){
            alert.setTitle("Good Job!");
            alert.setContentText("I have a great message for you!");
            alert.setContentText("press ok to continue");
            Image image = new Image(getClass().getResource("../images/goodjob.gif").toExternalForm());
            ImageView imageView = new ImageView(image);
            alert.setGraphic(imageView);
            alert.showAndWait();
        }else{
            alert.setTitle("False answer");
            alert.setContentText("I have a great message for you!");
            alert.setContentText("press ok to continue");
            Image image = new Image(getClass().getResource("../images/false.gif").toExternalForm());
            ImageView imageView = new ImageView(image);
            alert.setGraphic(imageView);
            alert.showAndWait();
        }
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
