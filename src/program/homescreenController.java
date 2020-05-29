package program;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class homescreenController {
    public void terugLogin(ActionEvent event) throws IOException {
        Parent showLogin = FXMLLoader.load(getClass().getResource("inlogScherm.fxml"));
        Scene showLoginScene = new Scene(showLogin);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(showLoginScene);
        window.show();
    }

    public void naProfiel(ActionEvent event) throws IOException {
        Parent showProfiel = FXMLLoader.load(getClass().getResource("Profiel.fxml"));
        Scene showProfielScene = new Scene(showProfiel);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(showProfielScene);
        window.show();
    }
}