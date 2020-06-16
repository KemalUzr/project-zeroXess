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

    public void naProfiel(ActionEvent event) throws IOException {
        Parent showProfiel = FXMLLoader.load(getClass().getResource("Profiel.fxml"));
        Scene showProfielScene = new Scene(showProfiel);
        Aves Chicken = new Aves("12", "222", "Chicken");
        Aves Duck = new Aves("12", "222", "Duck");
        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(showProfielScene);
        window.show();
    }

    public void livestock(ActionEvent event) throws IOException {
        Parent showLivestock = FXMLLoader.load(getClass().getResource("Livestock.fxml"));
        Scene showLivestockScene = new Scene(showLivestock);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(showLivestockScene);
        window.show();
    }
    public void naMedisch(ActionEvent event) throws IOException {
        Parent showBeschikbaarheden = FXMLLoader.load(getClass().getResource("Beschikbaarheden.fxml"));
        Scene showBeschikbaarhedenScene = new Scene(showBeschikbaarheden);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(showBeschikbaarhedenScene);
        window.show();
    }

    public void naExchange(ActionEvent event) throws IOException {
        Parent showHome = FXMLLoader.load(getClass().getResource("Exchange.fxml"));
        Scene showHomeScene = new Scene(showHome);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(showHomeScene);
        window.show();
    }

    public void toAdress(ActionEvent event) throws IOException{
        Parent toadress = FXMLLoader.load(getClass().getResource("adressScherm.fxml"));
        Scene adressScene = new Scene(toadress);

        //pakt stage informatie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(adressScene);
        window.show();

    }

    public void toEducative(ActionEvent event) throws IOException{
        Parent toEducative = FXMLLoader.load(getClass().getResource("educativeHome.fxml"));
        Scene EducativeScene = new Scene(toEducative);

        //pakt stage informatie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(EducativeScene);
        window.show();

    }
}
