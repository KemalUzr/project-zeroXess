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
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(showLoginScene);
        window.show();
    }

    public void toAdress(ActionEvent event) throws IOException{
        Parent toadress = FXMLLoader.load(getClass().getResource("addressCell.fxml"));
        Scene adressScene = new Scene(toadress);

        //pakt stage informatie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(adressScene);
        window.show();

    }



}
