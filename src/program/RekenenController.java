package program;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RekenenController {
// gaat terug naar educative overzicht
    public void ToEducativeHome(ActionEvent event) throws IOException {
        Parent ToEducativeHome  = FXMLLoader.load(getClass().getResource("educativeHome.fxml"));
        Scene EducativeScene = new Scene(ToEducativeHome);

        //pakt stage informatie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(EducativeScene);
        window.show();
    }
    // gaat naar oefen Scherm
    public void ToOefen(ActionEvent event) throws IOException {
        Parent tooefen  = FXMLLoader.load(getClass().getResource("RekenenOefenen.fxml"));
        Scene oefenScene = new Scene(tooefen);

        //pakt stage informatie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(oefenScene);
        window.show();
    }

    // gaat naar toets Scherm
    public void ToToets(ActionEvent event) throws IOException{
        Parent toToets  = FXMLLoader.load(getClass().getResource("RekenenToets.fxml"));
        Scene ToetsScene = new Scene(toToets);

        //pakt stage informatie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(ToetsScene);
        window.show();
    }
}
