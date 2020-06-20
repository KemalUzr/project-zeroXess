package program;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.security.PublicKey;
import java.util.ResourceBundle;

import static program.Afname.*;


public class RekenenController implements Initializable {
    @FXML
    Label Getal1;
    @FXML
    Label Getal2;
    @FXML
    TextField Input;

    @FXML
    Label Cijfer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
Getal1.setText("Klick op ");
Getal2.setText("Start");
    }

    int count = 0;

    public void NextQestion(ActionEvent event) {

        //loop door opdrachten
        for (Opdracht opdracht : Afname.opdrachten) {
            // checkt of reken opdarcht is
            if (opdracht instanceof RekenOpdracht) {

                if (
                    // checkt of getal 1 gelijk is aan getal 1 zelfde voor getal 2
                        ((RekenOpdracht) opdracht).getGetal1().equals(Integer.parseInt(Getal1.getText())) &&
                                ((RekenOpdracht) opdracht).getGetal2().equals(Integer.parseInt(Getal2.getText()))
                ) {
                    opdracht.setInput(Input.getText());

                }
            }
        }
        // checkt of het rekenen is
        if (type.equals("Rekenen")) {
         if (count < Afname.opdrachten.size()){
            // haalt de volgende getallen uit de array
            Opdracht opdracht1 = Afname.opdrachten.get(count);
            Getal1.setText("" + ((RekenOpdracht) opdracht1).getGetal1());
            Getal2.setText("" + ((RekenOpdracht) opdracht1).getGetal2());

            count++;
         }else {
             BerekenScore();
             Cijfer.setText("Je Cijfer is " + Rekencijfer);
         }
        }
    }
// start de toets
    public void StartButton(ActionEvent event) {
        StartToets("Rekenen");
        Opdracht opdracht = Afname.opdrachten.get(count);
        Getal1.setText("" + ((RekenOpdracht) opdracht).getGetal1());
        Getal2.setText("" + ((RekenOpdracht) opdracht).getGetal2());
        count++;
    }



    //Gaat naar RekenenHome Ovezicht
    public void BacktorekenHome(ActionEvent event) throws IOException {
        Parent toRhome = FXMLLoader.load(getClass().getResource("RekenenHome.fxml"));
        Scene homeRScene = new Scene(toRhome);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homeRScene);
        window.show();
    }



}

