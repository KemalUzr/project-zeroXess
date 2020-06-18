package program;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EducativeHomeController {

    // zorgt er voor dat je terug kan gaan naar het keuze menu kan.
    public void toHomescreen(ActionEvent event) throws IOException {
        Parent tohome  = FXMLLoader.load(getClass().getResource("homescreen.fxml"));
        Scene homeScene = new Scene(tohome);

        //pakt stage informatie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }
    public void naLezen(ActionEvent event) throws IOException {
        Parent toLezen  = FXMLLoader.load(getClass().getResource("Lezen.fxml"));
        Scene lezenScene = new Scene(toLezen);

        //pakt stage informatie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(lezenScene);
        window.show();
    }
    public void toSchrijven(ActionEvent event) throws IOException {
        Parent tohome  = FXMLLoader.load(getClass().getResource("Schrijven.fxml"));
        Scene homeScene = new Scene(tohome);

        //pakt stage informatie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }
    public void ToReken(ActionEvent event) throws IOException{
        Parent toReken = FXMLLoader.load(getClass().getResource("RekenenHome.fxml"));
        Scene toRHOmeScene = new Scene(toReken);

        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(toRHOmeScene);
        window.show();
    }
}
