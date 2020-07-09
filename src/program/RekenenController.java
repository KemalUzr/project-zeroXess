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
        for (program.Input input : Afname.opdrachten) {
            // checkt of reken opdarcht is
            if (input instanceof RekenInput) {

                if (
                    // checkt of getal 1 gelijk is aan getal 1 zelfde voor getal 2
                        ((RekenInput) input).getGetal1().equals(Integer.parseInt(Getal1.getText())) &&
                                ((RekenInput) input).getGetal2().equals(Integer.parseInt(Getal2.getText()))
                ) {
                    input.setInput(Input.getText());

                }
            }
        }
        SetNextQestion();
    }

    public void SetNextQestion(){

        // checkt of het rekenen is
            if (count < Afname.opdrachten.size()) {
                // haalt de volgende getallen uit de array
                program.Input input1 = Afname.opdrachten.get(count);
                Getal1.setText("" + ((RekenInput) input1).getGetal1());
                Getal2.setText("" + ((RekenInput) input1).getGetal2());

                count++;
            } else {
                Cijfer.setText("Je Cijfer is " + BerekenScore());
            }
        }




    // start de toets
    public void StartButton(ActionEvent event) {
        StartToets("Rekenen");
        program.Input input = Afname.opdrachten.get(count);
        Getal1.setText("" + ((RekenInput) input).getGetal1());
        Getal2.setText("" + ((RekenInput) input).getGetal2());
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

