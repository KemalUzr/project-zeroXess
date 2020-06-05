package program;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DiseasesController {
    public void naHome(ActionEvent event) throws IOException {
        Parent showHome = FXMLLoader.load(getClass().getResource("homescreen.fxml"));
        Scene showHomeScene = new Scene(showHome);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(showHomeScene);
        window.show();
    }
}
