package program;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RekenenHomeController {
    // gaat naar het Toets overzicht
    public void toToets(ActionEvent event) throws IOException {
        Parent toToets = FXMLLoader.load(getClass().getResource("RekenenToets.fxml"));
        Scene Totoets = new Scene(toToets);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Totoets);
        window.show();

    }
    // gaat naar het Oefen overzicht
    public void toOefen(ActionEvent event) throws IOException {
        Parent toOefen = FXMLLoader.load(getClass().getResource("OefenRekenen.fxml"));
        Scene ToOefen = new Scene(toOefen);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(ToOefen);
        window.show();

    }
    // Gaat naar EcuatieHome overzicht
    public void BacktoEducatieHome(ActionEvent event) throws IOException {
        Parent tohome = FXMLLoader.load(getClass().getResource("educativeHome.fxml"));
        Scene homeScene = new Scene(tohome);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }


}
