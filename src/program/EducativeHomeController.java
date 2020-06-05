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
    public void toSchrijven(ActionEvent event) throws IOException {
        Parent tohome  = FXMLLoader.load(getClass().getResource("Schrijven.fxml"));
        Scene homeScene = new Scene(tohome);

        //pakt stage informatie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }
}
